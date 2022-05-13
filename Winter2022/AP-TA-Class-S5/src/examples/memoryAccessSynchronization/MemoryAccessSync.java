package examples.memoryAccessSynchronization;

public class MemoryAccessSync implements Runnable {
    public Counter counter;

    public MemoryAccessSync(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
//        a critical section
        counter.add();
    }
}
