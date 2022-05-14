package examples.deadlockSolved;

public class Main {
    public static void main(String[] args) {
        String resource1 = "this is string 1";
        String resource2 = "this is string 2";

        Thread t1 = new Thread(new TaskOne(resource1, resource2), "thread-1");
        t1.start();

//        condition 1 has been broken!
        try {
            t1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        new Thread(new TaskTwo(resource1, resource2), "thread-2").start();
    }
}
