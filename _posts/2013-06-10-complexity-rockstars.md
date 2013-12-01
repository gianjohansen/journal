---
layout: post
title: Complexity Rockstars
categories:
- Computer Science
---

There are some algorithms that you're never going to be able to escape, try as you might. The kinds of algorithms that every interviewer will want to ask about, like quicksorts and linked lists. Basically, the celebrities of the big-O world. I wanted to write up a list of them to act as a quick reminder for myself before interviews, so here it is. I'll make sure to keep this updated.

We'll start with the easy ones. I won't go into detail for these because the only difficulty here is coming up with the best and worst case conditions whilst under pressure.

## Quicksort
<i>Everyone's favourite.</i>
Take an element from the list as a pivot, partition the list into two sections (higher and lower than the pivot), and quicksort the partitions.<br>
Best case - O(nlogn) - every pivot you take happens to be the middle value.<br>
Worst case - O(n^2) - every pivot you take happens to be the largest or smallest value.<br>
Average case - O(nlogn) - other cases.

## Mergesort
<i>Quicksort's messier roommate.</i>
Divide the list into 1-element sections and sort by merging each section until you're left with only one.<br>
Best case- O(nlogn) - list is already sorted.<br>
Worst case - O(nlogn) - list alternates between largest and smallest, eg, 1, 10, 2, 9, etc.<br>
Average case - O(nlogn) - other cases.

## Heapsort
<i>Perfect for when you expect the worst.</i>
Heapify the data and repeatedly take the smallest/largest element from the heap until the heap is empty.<br>
All cases - O(nlogn) - well that's the point, I guess.

## Binary Search
<i>"I'm thinking of a number between 1 and 100".</i>
Compare the input with the middle value from the list, discard the half that it isn't in and binary search the remaining half.<br>
Best case - O(1) - input value is the middle value.<br>
Worst case - O(logn) - input value is not in the list.<br>
Average case - O(logn) - other cases.

## Depth-First Search (DFS)
<i>Solves mazes like no other.</i>
Start at the root and travel down a branch. Every time you hit a node without any children, step back to the last node with unexplored children and continue from there.<br>
Best case - O(1) - input value is the root.<br>
Worst case - O(|V| + |E|) - input value is the final node you check.<br>
Average case - O(|V| + |E|) - other cases.

## Breadth-First Search (BFS)
<i>Poster child for graph theory.</i>
Start at the root and check every neighbour. Move to the next unexplored neighbour and repeat the process using it as the root.<br>
Best case - O(1) - input value is the root.<br>
Worst case - O(|V| + |E|) - input value is the final node you check.<br>
Average case - O(|V| + |E|) - other cases.

## Dijkstra's Algorithm
<i>Getting from A to B like your life depended on it.</i>
Paint all neighbours with their distance to the current node. Visit every node in turn and compare its neighbours's painted distances with what it would be for this one.<br>
Best case - O(1) - input value is the root.<br>
Worst case - O(|V|^2) - when we have to traverse every node in a complete graph.<br>
Average case - O(|V|^2) - other cases.

## B-tree
<i>Makes your filesystems and databases run on time.</i>
A binary tree that allows internal nodes to have more than two children. Note: these runtimes are the same as those for red-black trees.<br>
Searching - O(logn) - worst case when we search all the way down to a leaf.<br>
Inserting - O(logn) - worst case when we need to split all the way up to the root.<br>
Deleting - O(logn) - worst case when we need to rebalance all the way up to the root.

Ok, now lets get into the trickier ones. Some of these won't be algorithms.

## A* Search
Pathfinding algorithm that is remarkably competitive considering how easy it is to implement. Since being developed in the 1960s it has become the most common pathfinding algorithm used in game development. A* is complete and will always find (one of) the shortest path(s) if one exists.

We will assign each node a cost, <b>f'(n) = g(n) + h'(n)</b>, where <b>f'(n)</b> is the shortest path relative to the node, <b>g(n)</b> is the total distance from the start to here and <b>h'(n)</b> is the (heuristically-generated) estimate for the distance from here to the end point.

We start with an empty priority queue labelled OPEN. We add every passable node adjacent to the starting node to that OPEN list and then move the starting node to a CLOSED list. We then choose the node with the lowest <b>f'(n)</b> value described above and repeat the process from there. If any of the nodes we check are already on the open list, we update the node's cost and then we check whether that path would be cheaper than the current one. OPEN is kept sorted based on <b>f'(n)</b> values. This continues until we've reached the end node, at which point we have the shortest path.

Time complexity depends on the efficiency of the heuristic used to calculate <b>h'(n)</b>. In the worst case, A* runs in exponential time, O(2^n).

You can find an implementation in C <a href="https://github.com/BigZaphod/AStar" target="_blank">here</a>.

## Travelling Salesman
Long-discussed NP-hard problem that every CS student is required to solve a minimum of twelve times during their degree. Dates back to at least the 1930s and has become the quintessential problem in algorithmic optimization. Also an important problem amongst the P versus NP crowd.

The problem states that a traveller wants to visit a number of cities and must find as short a path as possible if he is to visit every one. We look at the cities and roads as nodes and edges on a graph. If we were to brute-force a solution we would be looking at O(n!) runtime, which is obviously too expensive to be practical. Various heuristic algorithms have been devised that give better performance.

We can get a short solution (though not an optimal one) using a greedy-heuristic called the <b>nearest neighbour</b> algorithm. You take a random city as the starting point then find the cheapest edge adjacent to you that leads to an unvisited city and take it. Mark that city as visited and repeat the process. When every city has been visited, you have your path. Nearest neighbour is <b>not</b> a complete algorithm.

In the worst case, nearest neighbour will give you the single unique worst possible tour.

You can find an implementation in python <a href="https://github.com/raunak/Travelling-Salesman-Problem" target="_blank">here</a>.

## Knight's Tour
More mathematics than pure CS. Records of this problem go back to at least the 9th century. Probably only widespread because of how useful it is in teaching Hamiltonian paths to first-year students. This is basically a solved problem because we have linear-time solutions for it.

If we take a knight on an empty chess board, the problem asks us to find a path that knight can take that would visit every square on the board exactly once. Solutions can be either open or closed depending on whether or not the knight finishes on the square on which he started.

A famous heuristic solution to the problem is <b>Warnsdorff's rule</b>. We calculate the number of successors that each possible move from our current position will have. Based on those calculations we choose the square that will most quickly bring us to the end. Following this as a greedy path will produce an open solution to the problem.

You can find an implementation in python <a href="https://github.com/douglassquirrel/warnsdorff" target="_blank">here</a>.

## Fast Fourier Transform
I've never actually used the fast fourier transform but i've heard the discrete fourier transform described as one of mankind's most important achievements, so take that as you will. FFT was actually superseded by the <a href="http://www2.technologyreview.com/article/427676/a-faster-fourier-transform/">sparse fourier transform</a> in 2012 but it'll never go away because there are particular cases where SFT doesn't apply.

FFT relies on some very difficult mathematics but the basic idea is that DFT is used in signal processing to simplify how we approach a problem. It decomposes a wave into its constituent parts, because analyzing those can be a lot easier than analyzing the wave as a whole.

To do this, take any wave and transform it so that instead of representing it over the <b>time</b> domain we instead represent it over the <b>frequency</b> domain. For each value on the frequency spectrum the transformation gives us an amplitude and a phase. FFT is a way of efficiently computing this transformation.

You can find an implementation in C <a href="https://github.com/FFTW/fftw3" target="_blank">here</a> and a better explanation than mine <a href="http://www.earlevel.com/main/2002/08/31/a-gentle-introduction-to-the-fft/" target="_blank">here</a>.

Wow, let's hope we don't ever get FFT in an interview! I'll end this list here but I've probably missed some obvious ones. Let me know if you think others should be added.