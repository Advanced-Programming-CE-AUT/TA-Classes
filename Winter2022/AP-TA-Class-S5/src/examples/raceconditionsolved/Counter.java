package examples.raceconditionsolved;

public class Counter {
    public int counter;

    public Counter(int counter) {
        this.counter = counter;
    }

    public Counter() {
        this.counter = 0;
    }

    public void add() {
        this.counter++;
    }

    public void subtract() {
        this.counter--;
    }

    public int getCounter() {
        return counter;
    }
}
