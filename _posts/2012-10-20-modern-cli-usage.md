---
layout: post
title: Modern CLI Usage
categories:
- Programming
---

If you ever find yourself needing to derail a compsci class discussion for whatever reason you have a few dependable options. Pronunciation can often work ("Did you just say 'sequel'? It's 's-q-l', buddy"), as can choice of web browser ("I can't use Firefox. I only have 16 gigs of ram on this machine"). What if, though, you want a guaranteed class-wide argument, complete with shouting, baseless insults and at least two or three friends becoming lifelong enemies? Easy. Just casually imply that the command line is now obsolete, and then sit back and enjoy the chaos you've unleashed.

Alright, I may be exaggerating slightly, but the state of the command line in 2012 definitely seems to be one of those issues that people really take personally. It's particularly irrational because for a lot of use cases there's just no difference between using a CLI to accomplish a task vs using a GUI. I know plenty of notepad++ users who would be just as productive with vim, and vice versa. For simple, repetitive tasks I'll generally always go with point-and-click, simply because I don't need to think about it.

"But you're oversimplifying", I hear you say. "What about all the things you can do with a command line that you can't with a GUI?". 

<img src="/assets/images/9.png">
<span class="post-caption">A classic example, <a href="http://en.wikipedia.org/wiki/Cowsay" target="_blank">cowsay</a>.</span>

## Command Line Wizardry
Look, I'm a programmer, I get the command line. I use it daily and will probably continue to do so for as long as I can use a keyboard. Complex tasks will always be easier through the command line, and its true that there are lots of things for which there just isn't a graphical alternative. To give you some examples:

<ul><li>My work folder is organised using a directory for each project. Let's say I want to open the readme.txt files for each project, but I don't want to take the time to visit the dozens of subdirectories individually. I can just use 'find ./ -name "*.txt" | xargs vim'.</li>
<li>When I get to my networking class I like to have a list of the files that I modified during my class the week before. With the command line I can just use 'find . -mmin -*start time* -mmin +*end time*' to get all of them.</li>
<li>If I ever change the name of my company from "ResLabs" to "iRes 2.0" I'll need to update all the readme files in my project folders. I could open each one in a text editor and find/replace, or I could just use 'sed -i '' s/ResLabs/iRes\ 2.0/g *.txt'.</li>
<li>When coding a website it's much better to have all your CSS in a single file. If you've already made several .css files and need to combine them into a single "core.css" file then instead of copy-pasting each one in, you can just use 'cat *.css > core.css'.</li>
<li>If I've downloaded a 10GB video and need to transfer it from one computer to another but only have an 8GB usb thumb drive, I can just use 'split -b 8192m ironman.mp4' to take the first 8GB of data, and then rejoin it after I've copied it all.</li></ul>
And keep in mind, these are all one-line commands (piped commands still count as one line!). There are longer shell scripts that'd blow the minds of non command line users. I can't understate just how useful the command line can be.

## No Shell is an Island
But of course, that goes both ways. There are lots of tasks that are better done using a GUI, and i'm sure that more tasks will head that way as time goes on. I think the archetypal example of such a task would be editing pictures using something like photoshop (actual manipulation and not resizing, rotating, etc). I'm not sure what photo editing using the command line would be like, but I don't think it'd work.

<img src="/assets/images/11.png">
<span class="post-caption">I suspect it'd look something like this</span>

A more techy example is refactoring and code completion in emacs and vim. At the risk of offending the emacs crowd, vim is my editor-of-choice for a lot of my programming work and for any text editing (this post, for example). But for any medium-sized or larger project (e.g. any Java project that will involve more than 3-4 classes), i'm always going to fire up an IDE. It's just not very engineer-like to choose to throw away the efficiency that I would gain from using Eclipse or Visual Studio or whatever. 

## It's Alive! It's Alive!
So is the command line dead? Clearly not. But should it be? That's the more interesting question, and is much harder to answer. 

You could argue that being a dedicated CLI user puts me firmly in one camp, but i'd counter by saying that if I could point-and-click without thinking and achieve the same end results, I would. And I certainly think that in 2012 the vast, vast majority of users should never be forced to go anywhere near a command line. 

There was a time when we wrote everything in assembly and the idea of a high level language would have been seen as too much of a waste of memory and clock cycles. Eventually the technology got better and moved on, and programmers did too. Will the command line go the same way?

Maybe it's time we moved on to a more intuitive paradigm. What that new paradigm might look like, I don't know. Let's hope <a href="http://en.wikipedia.org/wiki/Google_X_Lab" target="_blank">Google X</a> are working on it.