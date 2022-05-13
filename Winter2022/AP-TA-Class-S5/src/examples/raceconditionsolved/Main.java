package examples.raceconditionsolved;

public class Main {
    public static void main(String[] args) {
        Counter counter = new Counter();
        new Thread(new RaceConditionSolvedExample(counter), "thread-1").start();

        new Thread(new RaceConditionSolvedExample(counter), "thread-2").start();

        new Thread(new RaceConditionSolvedExample(counter), "thread-3").start();
    }
}
