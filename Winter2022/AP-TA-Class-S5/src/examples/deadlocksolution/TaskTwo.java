package examples.deadlocksolution;

public class TaskTwo implements Runnable {
    private final String resource1;
    private final String resource2;

    public TaskTwo(String resource1, String resource2) {

        this.resource1 = resource1;
        this.resource2 = resource2;
    }

    @Override
    public void run() {
        synchronized (resource2) {
            System.out.println(Thread.currentThread().getName() + " has locked resource 2");


            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            synchronized (resource1) {
                System.out.println(Thread.currentThread().getName() + " has locked resource 1");
            }
        }
    }
}
