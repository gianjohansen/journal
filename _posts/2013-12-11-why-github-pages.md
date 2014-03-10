---
layout: post
title: Why Github Pages
categories:
- Thoughts
---

Over the past week I've migrated my site to GitHub Pages. I've been meaning to try using a static site generator and the move felt right for a few reasons.

- **I can leverage github's servers:** Moving to GitHub's CDN and a static site generator from my slow server and CMS saved me about 4 seconds of load time on first visit and 0.2 seconds on subsequent loads. When even a 250ms delay is enough to [turn users away from a site](http://www.nytimes.com/2012/03/01/technology/impatient-web-users-flee-slow-loading-sites.html?pagewanted=all&_r=0), a 4 second improvement is definitely non-trivial. And that performance improvement comes at no cost because GitHub Pages hosting is 100% free.

- **I can take control of my workflow:** With Jekyll every post is a text file, which means I'm free from the awful online editor used in my old CMS. I have a particular workflow for development work and it's really nice that I can now blog using it as well. You don't ever really learn to appreciate things like syntax highlighting and predefined macros until you're forced to use one of those text-only WYSIWIG editors from Wordpress and Drupal and wherever else.

- **I can forget about backups:** Content and presentation are both stored in the repo, which means I have an automatic and complete backup of my entire site. And something that I think might be a bit underrated here is that because it's Git I can easily browse that backup on a per-file basis. So for example I can open a particular file and see my commit history for it and exactly how it looked at different points in time.

- **GitHub support rocks:** The quality of GitHub's customer service is well-documented. So far I've had 2 issues with my GitHub account and both times they were resolved within an hour of me contacting support, even though I'm only on a micro plan.

- **No messy database to worry about:** In addition to the tangible benefits of the site loading faster and eliminating any potential database security issues, switching to static files means that if GitHub ever turn evil I can switch to a different host with nothing more than a simple copy-paste.

- **Open source blogging:** And of course, because my blog is now open source if you don't like what I post then you can always submit a pull request!