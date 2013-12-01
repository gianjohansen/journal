---
layout: post
title: Repairing an Invalid Node Structure in OS X
categories:
- Apple
---

I'm going to start this post with something you probably don't want to hear: if you've googled this article then there's a good chance your drive is already a lost cause. It's unfortunate that SSD's don't yet come standard in every new computer, because the only thing reliable about today's drives is that they will <a href="http://static.usenix.org/event/fast07/tech/full_papers/pinheiro/pinheiro_html/" target="_blank">reliably fail</a>. Of course, there are a couple of things we can try before we give up. All may not be lost.

## The Problem
Let's start from the beginning. Apple use a file system called HFS+ in OS X. HFS+ uses a catalog system to keep track of files and directories. That catalog is stored using a <a href="http://en.wikipedia.org/wiki/B-tree" target="_blank">B-tree</a>. An Invalid Node Structure indicates damage to this data structure. Damage likely caused by a failing hard drive.

Symptoms of this problem include an abnormally long boot time with frequent kernel panics, and then when OS X does manage to load it will be too slow to use. Eventually it'll refuse to boot at all. 

<img src="/assets/images/29.jpg">
<span class="post-caption">Look familiar?</span>

## Step 1: Disk Utility
- Insert the OS X installation disk that came with your computer.
- Restart your computer, holding the C key as it turns on to tell it to boot from the installation disk. When the spinning disk appears you can let go. I've occasionally experienced problems with this process, so if this doesn't work hold the Option key and you'll get a menu to choose which disk to boot from.
- Select a language. When the welcome screen appears, go to the utilities menu and choose Disk Utility.
- Select the partition that OS X is on and click Repair Disk.

At this point it'll either fix the problem and you can go on as normal, or it'll throw an error and you should move on to step 2.

## Step 2: File system check (fsck)
- Close Disk Utility
- Go to the utilities menu and choose Terminal.
- Enter 'diskutil list' to get a list of all the drives on your machine. You need to identify OS X and take note of its name (in the format 'diskNsN').
- Enter 'fsck_hfs -frpy /dev/diskNsN', replacing in the correct numbers.

If it tells you that the system cannot be repaired, go on to the next step. Otherwise, it will have fixed the problem with your file system's catalog, and you can go back into Disk Utility and click repair, and it will work.

<img src="/assets/images/31.png">
<span class="post-caption">Hope for a screen like this.</span>

## Optional: DiskWarrior
&nbsp;<a href="http://www.alsoft.com/diskwarrior/" target="_blank">DiskWarrior</a> is a commercial program that repairs problems with Mac hard drives. It's pricey but there are lots of reports of it solving this particular error. Thing is, the problem is almost certainly caused by a hardware fault, so it's likely that the best DiskWarrior can do is treat the symptoms of the problem but not the cause. In other words, you'll soon need to go through this process again, and again, and so on. If you're confident that your problem is not with your hardware, however, this would probably be a good course of action.

For detailed instructions, check Diskwarrior's <a href="http://www.alsoft.com/DiskWarrior/support.html" target="_blank">documentation</a>.

## Step 3a: Data recovery
If fsck_hfs failed to repair your disk then we can safely assume it's beyond repair. The best we can do now is salvage your data, replace the broken drive and restore the data. The easiest way of doing this is with Apple's <a href="http://support.apple.com/kb/HT1661" target="_blank">firewire target mode</a>. If you don't have access to another mac or your computer doesn't have a firewire port, skip to step 3b.

- You'll need another mac with a firewire port (the host machine). Connect it to your broken mac (the target machine), which should be powered off.
- Turn on the target machine, holding down the T key as it boots up. This will start it in target mode.
- From the host machine, you should now have access to the target machine's hard drive. Save whatever data you need.
- When done, eject the target machine's drive and restart it. Go to step 4.

## Step 3b: Data recovery without target mode
We can also recover the data on the disk using a Linux liveCD. We'll use <a href="http://linuxmint.com/" target="_blank">Mint</a> for this, because it's the most likely to have the relevant proprietary graphics card and wireless drivers for your mac.

- Burn the Live CD. Note: Make sure you're burning a bootable ISO and not just the data. In OS X this is done by opening Disk Utility, dragging the .iso file into the list on the left and clicking burn in the top menu.
- Boot from that disk by inserting it and holding C as the computer turns on.
- Once you're on the linux desktop, mount the OS X drive by opening the file browser and clicking it. Once mounted you should see it appear on your desktop.
- Next, open a terminal window. Type 'sudo nemo' to open a file browser with elevated privileges. From here, you can browse the mac disk and copy files from it. Alternatively, use 'sudo su' to get root access and go from there if you prefer the command line (note: you won't be able to access OS X's files without root).
- When done, restart your computer and the disk should eject automatically.

<img src="/assets/images/32.png">
<span class="post-caption">Linux to the rescue.</span>

## Step 4: Replace the drive
Now that your data is safe, you need to look up the model of your mac to see how to replace its internal hard drive. That's well outside the scope of this article, but just know that it's not as scary as it seems. Try to make sure that the replacement is an SSD. If you're anything like me, this is not an experience you'll want to repeat.

Once you've replaced the drive, install OS X and migrate the data back. Once you've done that you'll be ready to go. Good luck.