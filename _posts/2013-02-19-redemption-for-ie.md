---
layout: post
title: Redemption For Internet Explorer
categories:
- Web Development
---

Microsoft's marketing team have been working very hard lately to convince the tech world that it's wrong to dislike Internet Explorer. According to them we're just trolls, mindlessly repeating vitriol from the past. Apparently IE is <em>good</em> now, and we'd agree if only we weren't <em>so</em> closed-minded!

<div class="video-container">
	<iframe width="640" height="390" src="http://www.youtube.com/embed/lD9FAOPBiDk?feature=player_detailpage" frameborder="0">
	</iframe>
</div>
<span class="post-caption">Wow, it's like they really know me!</span>

And by most measures it seems to be working. IE's market share has seen a <a href="http://arstechnica.com/information-technology/2013/02/internet-explorer-still-growing-as-windows-7-starts-its-decline/">steady increase</a> over the last few months, up 0.37% in the last month alone <em>[update: 6 months later that growth has gotten stronger and stronger]</em>. Many tech sites have admitted surprise at the improvement that IE has seen in its latest versions. So is Microsoft's PR right? Is it finally time to forgive and forget?

## Humble Beginnings
For a bit of context, let's take a look back to where things started going wrong. It's often forgotten that for a long time IE was considered the best browser you could use, and Microsoft were real innovators in the web space. Netscape was the market leader so Microsoft needed to innovate to compete, which they did. IE3 was the first browser to give us support for CSS, and IE4 was the first with DOM access, for example. The competition meant that web technology was progressing quickly, and at that point things seemed promising.

Of course, we all know what happened next. In a move that would later result in <a href="http://en.wikipedia.org/wiki/United_States_v._Microsoft"><em>that</em> antitrust case</a>, Microsoft leveraged the dominance of their Windows platform to effectively win the browser wars for them. They did this by bundling IE with windows, which history has shown gave IE a major edge in the market. They integrated it into the kernel, which gave it access to <a href="http://www.sonic.net/~undoc/comes_v_microsoft/comes_v_ms_schulman_opinions.txt">undocumented APIs</a> that gave it an inherent advantage over any third-party competition. Further, <a href="http://www.justice.gov/atr/cases/f3800/msjudgex.htm#vc">restrictive licenses</a> with OEMs meant that attempts to alter IE's prime position in the OS were met with threats of license termination. Competing with this proved too difficult for Netscape and by 2002 IE's market share had increased to 96%.

<img src="/journal/assets/images/33.png">

## A Monopoly Can Be A Dangerous Thing
With no threat of competition, innovation was no longer a priority. IE6 was far from perfect at release, and fixes that should have come quickly and continuously never did. The years that followed are known amongst developers as a kind of Dark Age for the web because of how web and browser development essentially came to a stop. When given control of the market, they showed that their business interests took priority over the continuing evolution of the web. The win for Microsoft had meant a loss for the user.

The biggest problem with IE was that it compromised security in ways that shouldn't have been possible. The kernel integration they added meant IE had an advantage with response times and system resources, but it also meant that it could be used as an attack vector to get to the kernel. And worse, when those security problems were discovered they went unfixed for years, and Microsoft sued websites that listed them.

Standards also fell victim during that time. Every web developer alive has felt the pain of spending hours getting a page to look good, only to check it in IE to find an unrecognisable mess. IE's rendering differed from the W3C standard, meaning developers had to choose between designing for IE or designing correctly. Their javascript implementation was incompatible with W3C standards, as was their java implementation. For a long time it felt as though Microsoft wanted to march exclusively to its own beat. This is probably the main reason for the lingering dislike of IE amongst techies; its inconsistencies meant huge increases to project development time. You would write some code, then have to rewrite it with fixes for IE.

<img src="/journal/assets/images/35.png">
<span class="post-caption">The <a href="http://www.webstandards.org/files/acid2/test.html#top">same page</a> rendered in Opera 8 (2005), IE6 (2001) and IE7 (2006).</span>

That stagnation continued for years. It wasn't until Mozilla began to eat away at IE's lead that they decided to try to make things right, but even then their effort seemed half-hearted. Their next version, IE7, proved only a slight improvement, despite coming 5 years later. IE8 wasn't much better. If at that point Microsoft had begun leading the charge when it came to emerging web technologies then they most likely would have held onto their majority market share. Unfortunately that just <a href="http://html5readiness.com/">didn't happen</a>, and steady competition from Firefox (and later Chrome) resulted in them falling below 50% in 2009-10.

IE was in trouble, and IE9 was their response. It was the first version not to be tied to the release of a new version of Windows, and to developers it was also the first version that showed promise. It offered real, tangible improvements over previous versions, like hardware-accelerated rendering, stronger malware protection and a new, much faster javascript engine. With IE9 Microsoft showed that when given the proper motivation they could innovate like they did when Netscape was around. IE9 was proof that it wasn't a lack of talent or resources that had been the problem, it was a lack of legitimate competition.

## All In The Past?
None of this answers the initial question, though. If all we're concerned about is using the best browser available, shouldn't we be evaluating IE as a standalone product without considering its history? 

Well, yes and no. There's a bigger picture here, and it would be irresponsible not to consider it.  When Microsoft had the majority market share the evolution of the web went on hold in favour of their bottom line. While that's less likely to happen today it's still a very real threat. Windows certainly won't be going anywhere soon, and as long as that's the case IE's huge userbase won't be either.

On the other hand, Microsoft now seem to have a genuine desire to make IE the best browser available again. While it's no secret that's ultimately motivated by money, we can't ignore the benefit that a motivated and enterprising Microsoft brings. As a developer, the <a href="http://www.tomshardware.com/reviews/internet-explorer-10-chrome-23-windows-8,3349.html">improvement</a> that IE10 has delivered over previous versions is just plain inspiring. If that can continue, we may yet see a day in which web developers are no longer haunted by IE in their sleep.

<img src="/journal/assets/images/36.png">
<span class="post-caption">Benchmarking from <a href="http://www.lucidchart.com/techblog/2012/11/14/ie10-how-does-it-really-stack-up/">Lucidchart</a> in November showed IE10 almost as fast as Chrome.</span>

It seems that all we can do is wait and see how the next few years play out for Microsoft. If IE were to become good enough that techies no longer felt obligated to switch browsers, I feel we'd be in serious trouble. It's happened before, like when Microsoft entered the antivirus market a few years ago. Amongst tech communities they quickly became the standard recommendation for antivirus software, but not because they were noticeably better than their competitors. They became the standard because their product was good enough to do the job and was available for free for all Windows users. What if IE were to become good enough? 

Ultimately, determining whether or not it's worth the risk seems to be a personal choice. It's becoming obvious that IE is becoming a competitive browser that will only get better as time goes on. That's a good thing for the user, but only if we have enough external competition to keep Microsoft in check. Let's hope that's always the case.