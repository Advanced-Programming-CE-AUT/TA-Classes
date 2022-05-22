package examples.livelockSolved;

public class Diner {
    private final String name;
    private boolean isHungary;

    public Diner(String name, boolean isHungary) {
        this.name = name;
        this.isHungary = isHungary;
    }

    public Diner(String name) {
        this.name = name;
        this.isHungary = true;
    }

    public void eatWith(Spoon spoon, Diner partner) {
        while (isHungary) {
            spoon.use();
            this.isHungary = false;
            System.out.printf("%s has finished, and is not hungary any more \n", name);
            spoon.setDiner(partner);
        }
    }

    public String getName() {
        return name;
    }

    public boolean isHungary() {
        return isHungary;
    }
}

