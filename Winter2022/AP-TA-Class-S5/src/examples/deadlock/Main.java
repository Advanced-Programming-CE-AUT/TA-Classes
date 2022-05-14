package examples.deadlock;

public class Main {
    public static void main(String[] args) {
        String resource1 = "this is string 1";
        String resource2 = "this is string 2";

        new Thread(new TaskOne(resource1, resource2), "thread-1").start();
//        uncomment the TaskTwo Runnable to see Deadlock.
        new Thread(new TaskTwo(resource1, resource2), "thread-2").start();
    }
}
