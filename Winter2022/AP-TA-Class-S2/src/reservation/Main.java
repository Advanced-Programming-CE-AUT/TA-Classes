package reservation;

public class Main {
    public static void main(String[] args) {
        Manager manager = new Manager();
        CommandProcessor commandProcessor = new CommandProcessor(manager);
        commandProcessor.run();
    }
}
