package reservation;

public class House {
    private String address;
    private int capacity;
    private String id;
    private int cost;

    public House(String address, int capacity, String id, int cost) {
        this.address = address;
        this.id = id;
        this.capacity = capacity;
        this.cost = cost;
    }

    public String getAddress() {
        return address;
    }

    public String getId() {
        return id;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getCost() {
        return cost;
    }
}
