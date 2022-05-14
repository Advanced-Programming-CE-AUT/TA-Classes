package examples.livelock;

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
            if (!spoon.getDiner().equals(this)) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                continue;
            }


            if (partner.isHungary()) {
                System.out.printf("%s: You eat first %s!\n", this.name, partner.getName());
                spoon.setDiner(partner);
                continue;
            }

            spoon.use();
            this.isHungary = false;
            System.out.printf("%s I'm finished, and not hungary any more %s", name, partner.getName());
            spoon.setDiner(partner);
        }
    }

    public boolean isHungary() {
        return isHungary;
    }

    public String getName() {
        return name;
    }
}

