---
layout: post
title: Shakespearean Squares
categories:
- Programming
---

It's no secret that as long as final exams exist, they're <a href="http://www.tandfonline.com/doi/abs/10.1080/0144341940140306" target="_blank">going to suck</a>. Finding ways to relax after exams is therefore incredibly important, and while one of my friends will spend her summer in Europe and another is driving up to the Sunshine Coast, in IT we do things differently. In IT, if we really want to let out hair down we fire up a text editor and get coding. Here's an example of one of my favourite timesinks.

## The Shakespearean Programming Language
It's a safe bet to assume that most programming languages are designed to be readable (or at least not unreadable). There's a class of languages, however, that are designed to subvert that while still remaining functional. <a href="http://en.wikipedia.org/wiki/Whitespace_(programming_language)" target="_blank">Whitespace</a>, for example, ignores any characters that aren't whitespace, so entire programs are written using only spaces, tabs and newlines. Another example, <a href="http://en.wikipedia.org/wiki/Piet_(programming_language)" target="_blank">Piet</a>, involves creating abstract art-like bitmaps that resemble works by Piet Mondrian. My favourite (if only for just how absurd the concept is) has always been the Shakespearean Programming Language (SPL). Writing code in SPL involves unleashing one's inner muse to write plays that would make Shakespeare proud. Well, as much as lines of executable code could.

<img src="/journal/assets/images/26.gif">
<span class="post-caption"><a href="http://en.wikipedia.org/wiki/LOLCODE" target="_blank">LOLCODE</a> is designed to be a prettier version of C.</span>

## How It Works
A program in SPL is split into several logical sections, mimicking play conventions. We'll start by having a look at some sample code to see what the end result will be.

<img src="/journal/assets/images/28.png">
<span class="post-caption">As unlikely as it sounds, this is the start of a program that calculates fibonacci numbers.</span>

1: Title<br>
Must be as dramatic as possible (puns of course encouraged). This is included for aesthetic reasons only. Everything up to the first period will be considered the title.

2: Variable Declarations<br>
Our character list. Made up of (name, description) pairs, where description is just an inline comment. Just for fun, it's a requirement that each of the variables be the name of a character from one of Shakespeare's plays.

3: Control Flow<br>
The show begins! Each act and each scene is given a roman numeral identifier and a description. We jump between acts and scenes by referencing their identifier (like using a goto statement).

4: Variable Staging<br>
Characters can't speak if they're not on stage. For that we have the Enter and Exit keywords to move them on and off stage. Exeunt is similar to exit but it acts on multiple characters.

5: Message Passing<br>
Characters can interact with others. Made up of a character, a colon and then the line. This is where we really begin to unleash our creativity.

The goal is to use descriptive english adjectives and nouns to construct numerical constants. To do this we start with a noun with a value of 1 or -1, depending on whether it has a positive or negative connotation respectively. For example, 'hero' would be 1 and 'villain' would be -1. From there, we build up powers of two by preceding it with adjectives. Each adjective you add multiplies your constant by 2. So 'hero' is 1, 'handsome hero' is 2, 'brave handsome hero' is 4, and so on. Values are assigned by the character referring to the other as that adjective/noun combo. So 'You brave handsome hero' would assign 4 to the character being spoken to.

6: Data I/O<br>
We also output the values held by our variables using lines. 'Open your heart' outputs the numeric value that the character has been assigned. 'Speak your mind' prints the character mapped to that numeric value in the computer's character set (probably unicode).

Inputs are handled here too, using 'Listen to your heart' and 'Open your mind' in the same way that outputs are used.

## Our First Play
That's all the syntax we need to begin using SPL. To start with, lets write a program that takes a number from the user, N, and computes the first N squares. First, we need a title and some variables.

<pre>The Squaring of the Shrews
A play in two acts.

Romeo, our dashing hero.
Juliet, Romeo's sweetheart.
Benvolio, a friend of the Montague family.
Tybalt, a villain.</pre>

Now, let's get the user's input.

<pre>Act I: Proper Guidance.
Scene I: Benvolio struggles to lift his companion's spirits.

[Enter Romeo and Benvolio]

Benvolio:
  You are as fair as a golden summer's day! You are a hero!

Romeo: 
  Thou art a hog. Listen to your heart!

[Exit Benvolio]</pre>

Next, calculate the square and increment the loop counter. Romeo's dialogue to Juliet prints a space after each number.

<pre>Act II: Careful Calculation.
Scene I: Tybalt confronts Romeo.

[Enter Tybalt]

Romeo: 
  You cowardly devil. You are the square of me. Open your heart!

Tybalt:
  You are the sum of an animal and thyself.

[Exit Tybalt]

[Enter Juliet]

Romeo:
  Thou art as pretty as the product of a blossoming fair flower and 
  an amazing charming gentle angel. Speak thy mind!

[Exit Juliet]</pre>

And finally, check the loop counter against the max.

<pre>Scene II: Benvolio checks in on Romeo.

[Enter Benvolio]

Benvolio:
  Are you better than me?

[Exit Benvolio]

Romeo:
 If not, we shall proceed to scene I.

[Exeunt]
</pre>

And we're done! You can download the finished program <a href="/assets/files/squares.spl">here</a>, and get the compiler <a href="http://shakespearelang.sf.net/download/spl-1.2.1.tar.gz">here [.tar.gz]</a>. As you can see, the program waits for an input and then outputs the squares that you ask for.

<img src="/journal/assets/images/25.png">

As a follow up, try modifying this to include a stack, using "Remember" and "Recall" for pushing and popping respectively. I should warn you now, once you've started with these languages it's hard to stop. I guess it beats finals though, right?