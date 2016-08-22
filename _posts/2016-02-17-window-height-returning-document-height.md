---
layout: post
title: "$(window).height() returning entire document height?"
categories:
- Web Development
---

Ran into some quirky behaviour with jQuery's height function today.

Given this code:

<pre>$(window).height();</pre>

Expected behaviour is for the height of the viewport (ie the visible part of the browser window) to be returned, and that's what happens in most cases. You can run the code against this blog post as a test, it includes jQuery.

While working on a small throwaway project I was using the function but realized it was returning the height of the document instead - not the viewport. I did the usual digging around and found others on stackoverflow having the same problem. Was it a browser quirk? An old version of jQuery?

After some frustrating testing I found that the reason for the change in behaviour was simply that I hadn't declared a doctype. The same code with a doctype correctly set returns the height of the browser viewport. That's this line:

<pre><!DOCTYPE html></pre>

Declare one of those at the top of your html and you'll get the correct result. In a future post I'll take a look at the jQuery source code to figure out why this is the case.
