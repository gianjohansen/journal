---
layout: post
title: Deciphering The Java Collections Framework
categories:
- Computer Science
---

Searching through the Java Collections Framework can be a bit overwhelming, especially for beginners. There are dozens of classes in the framework and while each one is supposed to be suited to certain tasks, the individual javadoc listings don't go into what exactly those tasks are. Knowing which data structure to use in any given situation is incredibly important, so not having a thorough understanding of Java's collection classes can lead to big problems down the line. The core classes are enough to cover almost all use cases, but how do we decide between them?

## Some Terminology
An <strong>interface</strong> is an abstract type that defines the operations that should be available to a certain class. It's like a declaration of what we expect a class to do, without going into the specific ways in which it will do it. An <strong>implementation</strong> is where we provide the actual code to carry out the things we defined in the interface. We say that a class implements an interface, and then override each of the methods that were defined. This is an <strong>abstraction</strong>, because when we actually use the class we can refer to the interface without caring about what the underlying code looks like.

The <strong>Java Collections Framework</strong> provides several standardized (and optimized) choices of common collection classes so that java developers don't need to write them themselves. It's made up of interfaces, implementations and operation-defining algorithms.

## Important Classes
<div class="entrytable" >
  <table >
    <thead>
    <tr> 
      <th>
        Interface
      </th>
      <th>
        Description
      </th>
      <th>
        Example
      </th>
      <th>
        Implementations
      </th>
    </tr>
    </thead>
    <tr>
      <td >
        <strong><a href="http://docs.oracle.com/javase/7/docs/api/java/util/List.html" target="_blank">List</a></strong>
      </td>
      <td>
        An ordered collection. Think of it as a sequence of objects. Duplicates entries are allowed. Elements are accessed by index.
      </td>
      <td>
        A todo list that allows repeated entries.
      </td>
      <td>
        <a href="http://docs.oracle.com/javase/7/docs/api/java/util/ArrayList.html" target="_blank">ArrayList</a><br>
        <a href="http://docs.oracle.com/javase/7/docs/api/java/util/LinkedList.html" target="_blank">LinkedList</a><br>
        <a href="http://docs.oracle.com/javase/7/docs/api/java/util/concurrent/CopyOnWriteArrayList.html" target="_blank">CopyOnWriteArrayList</a>
      </td>
    </tr>
    <tr>
      <td >
        <strong><a href="http://docs.oracle.com/javase/7/docs/api/java/util/Set.html" target="_blank">Set</a></strong>
      </td>
      <td>
        An unordered collection. No duplicate elements are allowed. Elements are accessed directly, you cant use their index.
      </td>
      <td>
        A list of ID numbers that need to be unique.
      </td>
      <td>
        <a href="http://docs.oracle.com/javase/7/docs/api/java/util/HashSet.html" target="_blank">HashSet</a><br><a href="http://docs.oracle.com/javase/7/docs/api/java/util/LinkedHashSet.html" target="_blank">LinkedHashSet</a><br><a href="http://docs.oracle.com/javase/7/docs/api/java/util/TreeSet.html" target="_blank">TreeSet</a><br><a href="http://docs.oracle.com/javase/7/docs/api/java/util/concurrent/ConcurrentSkipListSet.html" target="_blank">ConcurrentSkipListSet</a><br><a href="http://docs.oracle.com/javase/7/docs/api/java/util/concurrent/CopyOnWriteArraySet.html" target="_blank">CopyOnWriteArraySet</a>
      </td>
    </tr>
    <tr>
      <td >
        <strong><a href="http://docs.oracle.com/javase/7/docs/api/java/util/Map.html" target="_blank">Map</a></strong>
      </td>
      <td>
        Keys are mapped to objects, and you retrieve an object by looking up its key. Keys cannot be duplicated but the objects can be.
      </td>
      <td>
        An english dictionary that maps words to definitions.
      </td>
      <td>
        <a href="http://docs.oracle.com/javase/7/docs/api/java/util/HashMap.html" target="_blank">HashMap</a><br><a href="http://docs.oracle.com/javase/7/docs/api/java/util/LinkedHashMap.html" target="_blank">LinkedHashMap</a><br><a href="http://docs.oracle.com/javase/7/docs/api/java/util/TreeMap.html" target="_blank">TreeMap</a><br><a href="http://docs.oracle.com/javase/7/docs/api/java/util/concurrent/ConcurrentHashMap.html" target="_blank">ConcurrentHashMap</a><br><a href="http://docs.oracle.com/javase/7/docs/api/java/util/concurrent/ConcurrentSkipListMap.html" target="_blank">ConcurrentSkipListMap</a>
      </td>
    </tr>
    <tr>
      <td >
        <strong><a href="http://docs.oracle.com/javase/7/docs/api/java/util/Queue.html" target="_blank">Queue</a></strong>
      </td>
      <td>
        An ordered list that simulates a queue by only allowing access to the last element (this is called first-in-first-out access).
      </td>
      <td>
        A list of site visitors, used to serve them in order.
      </td>
      <td>
        <a href="http://docs.oracle.com/javase/7/docs/api/java/util/PriorityQueue.html" target="_blank">PriorityQueue</a><br><a href="http://docs.oracle.com/javase/7/docs/api/java/util/concurrent/ConcurrentLinkedQueue.html" target="_blank">ConcurrentLinkedQueue</a><br><a href="http://docs.oracle.com/javase/7/docs/api/java/util/concurrent/DelayQueue.html" target="_blank">DelayQueue</a><br><a href="http://docs.oracle.com/javase/7/docs/api/java/util/concurrent/PriorityBlockingQueue.html" target="_blank">PriorityBlockingQueue</a><br><a href="http://docs.oracle.com/javase/7/docs/api/java/util/concurrent/LinkedBlockingQueue.html" target="_blank">LinkedBlockingQueue</a>
      </td>
    </tr>
  </table>
</div>

## Deciding Between Interfaces
Deciding on an interface is usually straightforward. It doesn't take much experience to get a feel for which operations you'll need for different types of data. It's deciding between specific implementations that can be tricky.

<p><strong>List</strong>&#58; If you need a specific ordering and access to all elements, you should probably use a list. You can also use them as boundless arrays.</p>
<p><strong>Set</strong>&#58; If you can't have duplicates in your list then you should go with a set.</p>
<p><strong>Map</strong>&#58; You use maps when you have values that you want to give identifiers to, like giving string labels to objects.</p>
<p><strong>Queue</strong>&#58; Use queues when you need a kind of pipeline where temporal order is important, like in the producer-consumer pattern.</p>

And remember, there's some overlap here. You could use a list as a set by checking if the list contains an item before adding it, for example. A small amount of experience working with each class will mean you'll never really be stuck choosing an interface, but remember that there are no hard-and-fast rules.

## Deciding Between Implementations
To decide on an implementation we need to think about the nature of the data that will be stored and how you'll be interacting with it. To illustrate the decisions that go into choosing, I put together these flowcharts. Just start with your interface and answer Y/N to each of the questions ("I don't care" is equivalent to "N").

<center><strong>Interface: List</strong></center>
<img src="/assets/images/19.png">
If you don't need concurrency then use an <a href="http://docs.oracle.com/javase/7/docs/api/java/util/ArrayList.html" target="_blank">ArrayList</a>, unless you need a queue-like list implementation (you probably won't) with a <a href="http://docs.oracle.com/javase/7/docs/api/java/util/LinkedList.html" target="_blank">LinkedList</a>. If you do need concurrency, we have the <a href="http://docs.oracle.com/javase/7/docs/api/java/util/concurrent/CopyOnWriteArrayList.html" target="_blank">CopyOnWriteArrayList</a>. It creates a new copy of the list on every write, which enables your concurrent access but is very costly if you have a lot of writes. If that's the case, consider using an ArrayList and providing synchronous access in some other way.<br>
<strong>Recommended general-purpose implementation: ArrayList</strong>

<center><strong>Interface: Set</strong></center>
<img src="/assets/images/20.png">
Apart from whether or not you need concurrent access, sort order during iteration is realistically the only thing separating the different set classes. If you don't need concurrency and don't care about sort order, use a <a href="http://docs.oracle.com/javase/7/docs/api/java/util/HashSet.html" target="_blank">HashSet</a>. If you want sorted elements then use a <a href="http://docs.oracle.com/javase/7/docs/api/java/util/TreeSet.html" target="_blank">TreeSet</a>, if you want order to be the same as input order then use a <a href="http://docs.oracle.com/javase/7/docs/api/java/util/LinkedHashSet.html" target="_blank">LinkedHashSet</a>. For the concurrent classes, if you want sorted elements use a <a href="http://docs.oracle.com/javase/7/docs/api/java/util/concurrent/ConcurrentSkipListSet.html" target="_blank">ConcurrentSkipListSet</a>, otherwise use a <a href="http://docs.oracle.com/javase/7/docs/api/java/util/concurrent/CopyOnWriteArraySet.html" target="_blank">CopyOnWriteArraySet</a> (with the same caveat as with the CopyOnWriteArrayList).<br>
<strong>Recommended general-purpose implementation: HashSet</strong>

<center><strong>Interface: Map</strong></center>
<img src="/assets/images/21.png">
The map flowchart looks similar to the set flowchart because most set classes are implemented as maps, which is funny because maps aren't technically collections. Anyway, if you need concurrency and sort order we have <a href="http://docs.oracle.com/javase/7/docs/api/java/util/concurrent/ConcurrentSkipListMap.html" target="_blank">ConcurrentSkipListMaps</a>, if you need concurrency and don't care about order, we have <a href="http://docs.oracle.com/javase/7/docs/api/java/util/concurrent/ConcurrentHashMap.html" target="_blank">ConcurrentHashMaps</a>. For non-concurrent classes, we have <a href="http://docs.oracle.com/javase/7/docs/api/java/util/TreeMap.html" target="_blank">TreeMaps</a> for sorted order, <a href="http://docs.oracle.com/javase/7/docs/api/java/util/LinkedHashMap.html" target="_blank">LinkedHashMaps</a> for input order and <a href="http://docs.oracle.com/javase/7/docs/api/java/util/HashMap.html" target="_blank">HashMaps</a> otherwise.<br>
<strong>Recommended general-purpose implementation: HashMap</strong>

<center><strong>Interface: Queue</strong></center>
<img src="/assets/images/22.png">
The queue implementations are slightly more complicated than the others. Blocking classes can block on push/pop if certain conditions aren't met.If you don't need blocking......and need concurrency, use a <a href="http://docs.oracle.com/javase/7/docs/api/java/util/concurrent/ConcurrentLinkedQueue.html" target="_blank">ConcurrentLinkedQueue</a>....and you don't need concurrency, you can order by priority with a <a href="http://docs.oracle.com/javase/7/docs/api/java/util/PriorityQueue.html" target="_blank">PriorityQueue</a> or by input order with a <a href="http://docs.oracle.com/javase/7/docs/api/java/util/LinkedList.html" target="_blank">LinkedList</a>.If you need blocking......and want priority order, use a <a href="http://docs.oracle.com/javase/7/docs/api/java/util/concurrent/PriorityBlockingQueue.html" target="_blank">PriorityBlockingQueue</a>....and want a delay system, use a <a href="http://docs.oracle.com/javase/7/docs/api/java/util/concurrent/DelayQueue.html" target="_blank">DelayQueue</a>....and want a bound on the number of elements, use an <a href="http://docs.oracle.com/javase/7/docs/api/java/util/concurrent/ArrayBlockingQueue.html" target="_blank">ArrayBlockingQueue</a>. Otherwise, a <a href="http://docs.oracle.com/javase/7/docs/api/java/util/concurrent/LinkedBlockingQueue.html" target="_blank">LinkedBlockingQueue</a>.Note that a <a href="http://docs.oracle.com/javase/7/docs/api/java/util/concurrent/SynchronousQueue.html" target="_blank">SynchronousQueue</a> is roughly the same as a LinkedBlockingQueue with a capacity of 1.<br>
<strong>Recommended general-purpose implementation: PriorityQueue</strong>

## Rolling Your Own
Of course, you can always implement your own collection class if you need some sort of custom functionality. I'd recommend against this if possible because the classes in Java Collections Framework are already optimized, but if you need to then this route is always available.

If you want to write your own class, you need to implement one of the framework's abstract classes. The classes available to you are <a href="http://docs.oracle.com/javase/7/docs/api/java/util/AbstractCollection.html" target="_blank">AbstractCollection</a>, <a href="http://docs.oracle.com/javase/7/docs/api/java/util/AbstractSet.html" target="_blank">AbstractSet</a>, <a href="http://docs.oracle.com/javase/7/docs/api/java/util/AbstractList.html" target="_blank">AbstractList</a>, <a href="http://docs.oracle.com/javase/7/docs/api/java/util/AbstractSequentialList.html" target="_blank">AbstractSequentialList</a>, <a href="http://docs.oracle.com/javase/7/docs/api/java/util/AbstractQueue.html" target="_blank">AbstractQueue</a> and <a href="http://docs.oracle.com/javase/7/docs/api/java/util/AbstractMap.html" target="_blank">AbstractMap</a>.

<img src="/assets/images/23.png">
<span class="post-caption">Where it all begins... except for maps, which don't extend Collection but are in the collection framework just to trip you up.</span>

Creating a custom collection class is outside of the scope of this article so I won't provide any code, but it's no different to implementing any other interface. Just check the API to figure out which methods need to be written, and then provide them and any other methods in your class.

## Conclusion
The Java Collections Framework is an incredibly useful tool for any Java developer, and it's something that really is worth knowing back-to-front. As discussed, the key to choosing an appropriate data structure is knowing ahead of time what the data will look like and what you expect to be doing with it. Once you've figured that out it usually it's not too difficult to take it from there. We all know someone who uses ArrayLists to store everything and anything. Don't be that person.