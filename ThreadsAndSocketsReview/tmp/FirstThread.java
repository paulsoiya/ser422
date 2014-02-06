class Worker425 implements Runnable {
    protected int id;

    public Worker425 (int assignedID) {
        id = assignedID;
    }

    public void run() {
        for (int loop=0; loop < 5; loop++) {
            System.out.println("Hello from " + id  + " loop=" + loop);
        }
    }
}

class FirstThread {
    public static void main(String args[]) {
        int  times= Integer.parseInt(args[0]);

        for (int loop=0; loop < times; loop++) {
	    try {
		Thread.sleep(500);
	    } catch (Throwable t) {
		t.printStackTrace();
	    }
            Runnable worker = new Worker425(loop);
            Thread task = new Thread(worker, "Task#"+loop);
            task.start();
        }
    }
}
