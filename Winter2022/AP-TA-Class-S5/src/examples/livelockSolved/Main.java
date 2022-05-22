package examples.livelockSolved;

public class Main {
    public static void main(String[] args) {
        Diner husband = new Diner("john");
        Diner wife = new Diner("Denis");

//        most live locks occur because of poor design
//        here if we designed our program to have 2 spoons everything would have worked properly
//        so by adding two spoons we have:
        Spoon spoon1 = new Spoon(husband);
        Spoon spoon2 = new Spoon(wife);

        new Thread(() -> husband.eatWith(spoon1, wife)).start();
        new Thread(() -> wife.eatWith(spoon2, husband)).start();
    }
}
