package reservation;

import java.util.Scanner;

public class CommandProcessor {
    private Manager manager;

    public CommandProcessor(Manager manager) {
        this.manager = manager;
    }



    public void run(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your commands: ");

        String input = "";
        while (!(input = scanner.nextLine()).equalsIgnoreCase("end")){

            String[] splitInput = input.split("\\s");

            if(input.startsWith("add host")){
                manager.addHost(splitInput[2], splitInput[3], splitInput[4], Integer.parseInt(splitInput[5]));
            }
            else if(input.startsWith("show hosts")){
                manager.showHosts();
            }
            else if(input.startsWith("add guest")){
                manager.addGuest(splitInput[2], splitInput[3], splitInput[4], Integer.parseInt(splitInput[5]));
            }
            else if(input.startsWith("show guests")){
                manager.showGuests();
            }
            else if(input.startsWith("add house")){
                manager.addHouse(splitInput[2], Integer.parseInt(splitInput[3]), splitInput[4], splitInput[5], Integer.parseInt(splitInput[6]));
            }
            else if (input.startsWith("update storage")) {
                manager.updateStorage();
            }

            else {
                System.out.println("Invalid Input");
            }




        }
    }
}
