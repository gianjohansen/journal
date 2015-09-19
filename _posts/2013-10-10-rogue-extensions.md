---
layout: post
title: When Rogue Browser Extensions Attack
categories:
- Web Development
---

There are plenty of not-so-nice developers out there. I'd noticed recently while browsing the web that some pages (I'm not sure what the exact criteria was) would have a "height: auto" style automatically added to their top-level html tag just after loading, even if their height was otherwise specified elsewhere. This destroys layouts that need a fixed height value on their html tag to use when the body tag calculates its size.

<a target="_blank" href="/journal/images/56.jpg"><img src="/journal/assets/images/56.jpg"></a>
<span class="post-caption">On the left is Safari loading the page as it's supposed to look, on the right is Chrome with the added height styling.</span>

The fact that it happens a split second after loading instead of before rendering is a sign that it's a javascript problem, so I took a look and sure enough there were 8 js files I'd never seen before that were being loaded in from "superfish.com". Creepy, right? I had a look at what "superfish.com" is and it's a startup that analyzes images so that they can be meaningfully classified for searching. As a developer I thought "neat idea" but what exactly was their code doing on my page?

Turns out (here's the really scary part) an extension that I've been using for years now, SmoothScroll, has decided to monetize by <strong>scanning every web page you visit</strong> and serving ads to you based on your browsing habits. The javascript is a part of that monetization. Who needs the NSA when you've got developers like that?

Anyway, if you're running into the problem I described with your top-level html tag being modified after the page loads, check your extensions list. Disable them one-by-one and then delete the one that's causing it when you find it.
