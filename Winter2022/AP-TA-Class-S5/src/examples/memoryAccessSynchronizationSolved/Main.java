package examples.memoryAccessSynchronizationSolved;

public class Main {
    public static void main(String[] args) {
        Counter counter = new Counter();
        try {
            Thread thread = new Thread(new MemoryAccessSync(counter));
            thread.start();
            thread.join();
        } catch (InterruptedException e) {
            System.err.println(e);
        }

//        a critical section
        if (counter.getCounter() == 0) {
            System.out.println("value of counter is zero");
        } else {
            System.out.println("value of counter is not zero");
        }
    }
}
