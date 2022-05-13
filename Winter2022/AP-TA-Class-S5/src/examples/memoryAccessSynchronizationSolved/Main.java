package examples.memoryAccessSynchronizationSolved;

public class Main {
    public static void main(String[] args) {
        Counter counter = new Counter();
        new Thread(new MemoryAccessSync(counter)).start();
//        use .join() to solve this problem!

//        a critical section
        if (counter.getCounter() == 0) {
            System.out.println("value of counter is zero");
        } else {
            System.out.println("value of counter is not zero");
        }
    }
}
