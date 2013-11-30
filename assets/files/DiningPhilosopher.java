public class DiningPhilosopher implements Runnable {
	
	public Boolean alive = true;
	public int id;
	public Integer[] chopsticks;
	public int total;
	
	public DiningPhilosopher(int id, Integer[] chopsticks, int total) {
		this.id = id;
		this.chopsticks = chopsticks;
		this.total = total;
	}
	
	public void run() {
		while(true) {
			if (!alive) break;
			eat();
			System.out.println("Philosopher " + id + " has eaten...");
			think();
		}
	}
	
	/**
	 * Need to lock both chopsticks during the time the current philosopher sees
	 * that they are not grabbed and the time it grabs them (so that no other can 
	 * grab one of these chopsticks in between)
	 */
	public void getChopsticks() {
		synchronized(chopsticks[id])  {
			synchronized(chopsticks[(id + 1) % total]) {
				while (chopsticks[id] != 0 || chopsticks[(id + 1) % total] != 0) {
					try {
						Thread.sleep(20);
					} catch (Exception e) {
						System.err.println("Philosopher " + id + " cannot sleep: "+ e);
					}
				}
				chopsticks[id] = 1;
				chopsticks[(id + 1) % total] = 1;
			}
		}
	}
	
	public void eat() {
		// get the two chopsticks
		getChopsticks();
		try {
			Thread.sleep(100);
		} catch (Exception e) {
			System.err.println("Philosopher " + id + " cannot eat: "+ e);
		}
		chopsticks[id] = 0;
		chopsticks[(id + 1) % total] = 0;
	}
	
	
	public void think() {
		try {
			Thread.sleep(100);
		} catch (Exception e) {
			System.err.println("Philosopher " + id + " cannot think: "+ e);
		}
	}
	
	public void die() {
		// a philosopher dies only at the end (after 5s)
		alive = false;
	}
	
	public static void main(String[] args) {
		int numPhilosophers = 5;
		Thread[] threads = new Thread[numPhilosophers];
		DiningPhilosopher[] dps = new DiningPhilosopher[numPhilosophers];
		int numSeconds = 1200;
		Integer[] chopsticks = new Integer[numPhilosophers];
		
		// initialize chopsticks
		for (int i=0; i<5; i++) chopsticks[i] = 0;
		
		// create chopsticks
    	for(int threadNum = 0; threadNum < 5; threadNum++) {
    		dps[threadNum] = new DiningPhilosopher(threadNum, chopsticks, numPhilosophers);
    		threads[threadNum] = new Thread(dps[threadNum]);
    	}
	
    	// start the five philosophers
		for (Thread thread : threads) thread.start();
		
		// let them run during 5s
		try {
			Thread.sleep(numSeconds * 1000);
		} catch (Exception e) {
			System.err.println("Main thread cannot sleep: " + e);
		} finally {
			// kill them all
			for (DiningPhilosopher dp : dps) dp.die();
		}
		// wait for the threads to complete
		try {
		  for (Thread thread : threads) thread.join();
		} catch (Exception e) {
			System.err.println("Main thread cannot wait for others: " + e);
		}
	}
}