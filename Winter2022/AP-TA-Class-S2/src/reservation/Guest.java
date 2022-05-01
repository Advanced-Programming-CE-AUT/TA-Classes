package reservation;

import java.util.ArrayList;

public class Guest implements Payer{
    private String firstName;
    private String lastName;
    private String nationalCode;
    private int credit;
    private ArrayList<House> reservedHouses;

    public Guest(String firstName, String lastName, String nationalCode, int initialCredit) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nationalCode = nationalCode;
        this.credit = initialCredit;
        this.reservedHouses = new ArrayList<>();
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

    public int getCredit() {
        return credit;
    }

    @Override
    public int pay() {
        int fee = (int) (credit * 0.1);
        credit -= fee;
        return fee;
    }

    @Override
    public String toString() {
        return "Guest{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", credit='" + credit + '\'' +
                ", nationalCode='" + nationalCode + '\'' +
                '}';
    }
}
