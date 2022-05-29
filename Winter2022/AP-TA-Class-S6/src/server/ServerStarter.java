package server;

public class ServerStarter {
    public static void main(String[] args) {
        Server server = new Server(8642);
        Thread thread = new Thread(server);
        thread.start();
    }
}
