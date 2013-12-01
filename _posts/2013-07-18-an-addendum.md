---
layout: post
title: An Addendum
categories:
- Computer Science
---

I should probably admit, I didn't particularly like ending <a href="http://www.reslabs.com.au/journal/complexity-rockstars" target="_blank">my post on algorithms</a> at Discrete Fourier Transforms. I just don't have as strong a background in mathematics as I'd like to have in order to really do the concept justice. To set things right, here's an easy to follow explanation of something that I do understand, the P vs NP debate!

So what are P and NP? Simply put, they both represent sets of problems. Specifically, sets of problems that we can give a yes or no answer to, which mathematicians call "decision problems". So what defines each problem set?

P is made up of all the problems that can be <em>solved</em> in polynomial time. If we had the problem "is x less than y", that would be in the P set because it's something we can solve quickly (in constant time in this case).

NP is made up of all the problems that can be <em>verified</em> in polynomial time. To illustrate the difference, if I gave you a sudoku and asked you to solve it, it'd probably take a while. But if I gave you a <strong>solution to</strong> a soduku, it'd be trivial to see whether or not it was correct.

So those are the two problem sets. The debate is, does P=NP? In other words, if we have a problem that can be verified quickly, does that mean that there must exist some way to solve that problem quickly? What's important here is that there are lots of difficult problems that we don't have a quick solution to, but that we can quickly verify solutions for. If P does equal NP, there must be some quick solution to that difficult problem that we just haven't found yet.

For example, an NP problem currently forms the basis of most current public-key cryptography: the fact that it is computationally impossible to factor huge numbers. If P=NP then there must actually be an efficient way to do that, which would effectively break services like https, ssh, pgp and bitcoin. Another example is the travelling salesman problem I described in the other post. Consider the applications that easily computable optimal routes could have in real life, from optimizing logistics to sequencing dna.

You can see a nice list of arguments against P=NP  <a href="http://www.scottaaronson.com/blog/?p=122" target="_blank">here</a>. I rather like what he lists as the "Philosophical Argument": 

<blockquote><p>If P=NP, then the world would be a profoundly different place than we usually assume it to be. There would be no special value in “creative leaps,” no fundamental gap between solving a problem and recognizing the solution once it’s found. Everyone who could appreciate a symphony would be Mozart; everyone who could follow a step-by-step argument would be Gauss; everyone who could recognize a good investment strategy would be Warren Buffett. It’s possible to put the point in Darwinian terms: if this is the sort of universe we inhabited, why wouldn’t we already have evolved to take advantage of it?</p></blockquote>
The <a href="http://www.cs.umd.edu/~gasarch/papers/poll.pdf" target="_blank">most common opinion</a> amongst computer scientists is that the debate will be solved sometime soon, with P not being equal to NP. Really, it's difficult to disagree with that based on current literature. If you were to conclusively prove things one way or the other, there'd be a <a href="http://www.claymath.org/millennium/" target="_blank">Millennium Prize</a> waiting for you.

Ok there, done. All is right with the world again.