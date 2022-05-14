package examples.livelock;

public class Spoon {
    private Diner diner;

    public Spoon(Diner diner) {
        this.diner = diner;
    }

    public Diner getDiner() {
        return diner;
    }

    public synchronized void setDiner(Diner diner) {
        this.diner = diner;
    }

    public synchronized void use() {
        System.out.printf("%s has eaten", diner.getName());
    }
}
