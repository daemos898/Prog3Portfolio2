public class ConcurrencyThreads {
    public static void main(String[] args) {
    	//Create the two threads for counting up and counting down
        Thread counterUp = new Thread(new CounterUp());
        Thread counterDown = new Thread(new CounterDown());

        //Start the counter up thread
        counterUp.start();
        try {
        	//Makes sure that the counter up thread is complete before it starts the counter down
            counterUp.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //Start the counter down thread
        counterDown.start();
    }
}

//Method for thread 1 to follow
class CounterUp implements Runnable {
    @Override
    public void run() {
    	//Starts the thread at 0 and stops the thread at 20
        for (int i = 0; i <= 20; i++) {
            System.out.println("Thread 1: " + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

//Method for thread 2 to follow
class CounterDown implements Runnable {
    @Override
    public void run() {
    	//Starts the thread at 20 and makes it end at 0
        for (int i = 20; i >= 0; i--) {
            System.out.println("Thread 2: " + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}