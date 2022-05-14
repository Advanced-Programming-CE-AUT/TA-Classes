package examples.livelock;

public class Main {
    public static void main(String[] args) {
        Diner husband = new Diner("john");
        Diner wife = new Diner("Denis");

        Spoon spoon = new Spoon(husband);

        new Thread(() -> husband.eatWith(spoon, wife)).start();
        new Thread(() -> wife.eatWith(spoon, husband)).start();
    }
}
