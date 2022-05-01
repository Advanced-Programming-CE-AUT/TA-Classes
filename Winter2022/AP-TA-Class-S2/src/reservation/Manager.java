package reservation;

import java.util.ArrayList;

public class Manager {
    private ArrayList<Guest> guests;
    private ArrayList<Host> hosts;
    private int storage;


    public Manager() {
        this.guests = new ArrayList<>();
        this.hosts = new ArrayList<>();
    }

    public void addHost(String firstName, String lastName, String nationalCode, int initialCredit){
        Host host = new Host(firstName, lastName, nationalCode, initialCredit);
        hosts.add(host);
        System.out.println("Host Added Successfully!");
    }

    public void showHosts(){
        int i = 1;
        for (Host host : hosts) {
            System.out.println(i +""+host);
            i++;
        }
    }
    public void addGuest(String firstName, String lastName, String nationalCode, int initialCredit){
        Guest guest = new Guest(firstName, lastName, nationalCode, initialCredit);
        guests.add(guest);
            System.out.println("Guest Added Successfully!");

    }

    public void showGuests(){
        int i = 1;
        for (Guest guest : guests) {
            System.out.println(i + "" + guest);
            i++;
        }
    }

    public void addHouse(String address, int capacity, String id, String ownerNationalCode, int cost){
        House house = new House(address, capacity, id, cost);
        Host host = getHostByNationalCode(ownerNationalCode);
        host.addHouse(house);
        System.out.println("House Added Successfully!");

    }

    private Host getHostByNationalCode(String nationalCode){
        for (Host host : hosts) {
            if(host.getNationalCode().equals(nationalCode))
                return host;
        }
        return null;
    }

    public void updateStorage() {
        for (Guest guest: guests)
            storage += guest.pay();

        for (Host host: hosts)
            storage += host.pay();

        System.out.println("The storage has been updated.");
    }
}
