package reservation;

import java.util.ArrayList;

public class Host implements Payer {
    private String firstName;
    private String lastName;
    private String nationalCode;
    private int credit;
    private ArrayList<House> houses;

    public Host(String firstName, String lastName, String nationalCode, int initialCredit) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nationalCode = nationalCode;
        this.credit = initialCredit;
        this.houses = new ArrayList<>();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public ArrayList<House> getHouses() {
        return houses;
    }

    public int getCredit() {
        return credit;
    }

    public void addHouse(House house){
        houses.add(house);
    }

    @Override
    public int pay() {
        int fee = (int) (credit * 0.2);
        credit -= fee;
        return fee;
    }

    @Override
    public String toString() {
        return "Host{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", nationalCode='" + nationalCode + '\'' +
                ", credit='" + credit + '\'' +
                ", houses=" + houses +
                '}';
    }
}
