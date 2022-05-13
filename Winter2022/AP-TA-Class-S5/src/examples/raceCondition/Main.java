package examples.raceCondition;

public class Main {
    public static void main(String[] args) {
        Counter counter = new Counter();
        new Thread(new RaceConditionExample(counter), "thread-1").start();

        new Thread(new RaceConditionExample(counter), "thread-2").start();

        new Thread(new RaceConditionExample(counter), "thread-3").start();
    }
}
