---
layout: post
title: An Introduction to Transactional Memory In Java
categories:
- Programming
---

It's no secret that handling concurrent access to shared memory is a chore, even at the best of times. You need to decide on granularity, carefully manage locking and unlocking the shared data, and stay on the watch for race conditions, deadlocks, starvation and priority inversion. Luckily, a smarter way of doing things emerged during the '90s that is quickly making its way through academia. It's called transactional memory and it solves a lot of the problems we face with the traditional locking mechanisms that we're so used to.

## Locking Sucks
If you've never used locks before, they're a way of allowing parallel programming by making sure that two threads can't access the same data at the same time. When a thread needs access to the shared data (the "critical section") it acquires the lock guarding it. When another thread comes along also needing that data it tries to acquire that lock but can't, so it just waits. When the first thread is done it releases the lock and moves on, allowing the second thread to acquire it and gain access to the data. The concept is simple but there are actually a lot of problems with this approach.

If you lock too much code you may as well have written the program sequentially, because you end up with the threads traversing large sections of code one at a time anyway. The whole reason we work in parallel is to avoid that. Meanwhile if you lock small sections you get lots of overhead and it's very difficult to avoid introducing possible deadlocks. That's when you have two threads holding resources but needing the resource held by the other thread to continue, stalling the program indefinitely. And compounding that is the fact that locking is notoriously difficult to debug and verify as correct. In a large project potential deadlocks can be almost impossible to detect.

## But Databases Got It Right
If you've done any work with database programming you'll know that in SQL we use transactions to ensure <a href="http://en.wikipedia.org/wiki/ACID" target="_blank">ACID</a> code. In pseudocode:

<pre>BEGIN TRANSACTION
    Write X In Table A
    Write X In Table B
COMMIT</pre>

What's relevant here is that those two statements are guaranteed to either both be successful or neither. If both statements are successful, we commit the changes and continue. On the other hand, if Table A is written to successfully but Table B isn't then we roll back to the initial state (i.e. any changes to Table A are undone). That's called atomicity.

The point here is that we want code to execute sequentially, and if we reach the end successfully then great. If not, we abort (and usually try again). Transactional Memory takes that model and applies it to parallel programming. This is good because of the abstraction that it provides to programmers. Instead of having to deal with individual locks, we can instead just deal with the much easier concept of transactions. That makes writing synchronized code much easier because our only job is to mark the beginning and end of the transaction. It avoids the performance problem we get with coarse-grained locking because transactional memory is by nature optimistic (i.e. we can act without locking as though there will be no conflicts and only intervene if there are).

## But It's Not All Peaches And Cream
When we moved from binary to ASM and then from ASM to high level languages, we were making the conscious decision to trade performance for ease of use. Unfortunately, moving from locking to transactional memory requires the same tradeoff. We needed improved hardware to cover the performance hit of going from "CMP" to ".isGreaterThan()", and that may be the case here too. Proponents will often say that transactional memory is inherently faster than locking but real world testing (see <a href="http://www.bscmsrc.eu/sites/default/files/cf-final.pdf" target="_blank">here</a> and <a href="http://queue.acm.org/detail.cfm?id=1454466" target="_blank">here</a>) has shown that the overhead introduced is significant. Further study is needed (especially using code optimized for transactions) to properly gauge performance factors.

## Let's Build It
To demonstrate the system for ourselves we're going to implement in Java a solution to Dijkstra's <a href="http://en.wikipedia.org/wiki/Dining_philosophers_problem" target="_blank">Dining Philosophers problem</a> using Eclipse. If you've never seen the problem before then I'd highly recommended you read up on it but you can just follow the code if you like.

<ul><li style="word-wrap: break-word"><strong>Step 1</strong>: Support for Transactional Memory in Java exists in the form of the <a href="https://sites.google.com/site/deucestm/" target="_blank">Deuce</a> framework. Grab the source from the <a href="https://github.com/DeuceSTM/DeuceSTM" target="_blank">github repo</a> using 'git clone https://github.com/DeuceSTM/DeuceSTM.git'.</li>
<li><strong>Step 2</strong>: Now we turn that project into a jar file. Enter the DeuceSTM folder and run 'ant agent-jar' to create deuceAgent.jar inside ./bin. Ignore the warnings. When done, cd into the bin folder.<img src="/assets/images/14.png"></li>
<li><strong>Step 3</strong>: Now locate the jar runtime archive on your machine (hint: use 'locate rt.jar'). Add the methods from the jar we created to your rt.jar by using 'java -jar deuceAgent.jar rt.jar rt_instrumented.jar' (replace "rt.jar" with the correct location).<img src="/assets/images/15.png"></li>
<li><strong>Step 4</strong>: The newly created rt_instrumented.jar is the jar we'll use for this project. Create a new project in Eclipse. Select the src folder in package explorer and then click File > Import > File System, and then browse to the DeuceSTM folder and add the "java" folder in DeuceSTM > src. Then right click the project, select Build Path > Add External Archives, and then select your rt_instrumented.jar. Now the transactional memory library should be set up.</li>
<li><strong>Step 5</strong>: <a href="/assets/files/DiningPhilosopher.java">Click here</a> to download an implementation of the Dining Philosopher problem <strong>without</strong> any transactions. Add it to your project. Notice the problem that we're trying to solve: it eventually deadlocks.<img src="/journal/assets/images/17.png"></li>
<li><strong>Step 6</strong>: Lets make this code transactional. We need to change the mechanism we have set up for locking/unlocking. That's this method:
<img src="/journal/assets/images/16.png">
The "synchronized" blocks represent the traditional locking style. First the left chopstick is locked, then the right chopstick, then the code runs. This is where the deadlock happens. In java we declare a method as a transaction using the @Atomic keyword. First we import Deuce using 'import org.deuce.Atomic;'. Then we add @Atomic to the method the same way we would @Override. Finally, we remove the traditional locks. Method getChopsticks() should now look like this:

@Atomic
public void getChopsticks() {
	while (chopsticks[id] != 0 || chopsticks[(id + 1) % total] != 0) {
		try {
			Thread.sleep(20);
		} catch (Exception e) {
			System.err.println("Philosopher " + id + " cannot sleep: "+ e);
		}
	}
	chopsticks[id] = id+1;
	chopsticks[(id + 1) % total] = id+1;
}</li>
<li><strong>Step 7</strong>: Running the code again, we see that it runs without any deadlocks. The entire method now runs properly and you'll see that when a deadlock would have occurred it instead aborts. Mission accomplished.<img src="/assets/images/18.png"></li>
</ul>

## What Now?
Transactional Memory is currently very cool. It's big in academia and has some brand-name supporters. "We need to explore new techniques like transactional memory that will allow us to get the full benefit of all those transistors and map that into higher and higher performance", said Bill Gates at a conference in 2005. It's a very promising area of research and it'd be an exciting area to get into. For further reading I'd suggest the two papers that started things, <a href="http://www.cs.brown.edu/~mph/HerlihyM93/herlihy93transactional.pdf" target="_blank">'Transactional Memory: architectural support for lock-free data structures'</a> from 1993 and <a href="http://www.cse.ohio-state.edu/~agrawal/788-su08/Papers/week4/shavit95software.pdf" target="_blank">'Software Transactional Memory'</a> from 1997.
