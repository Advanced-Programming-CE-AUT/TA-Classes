package client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientApplication {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 8642);
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            Thread requestSender = new Thread(new ClientRequestSender(out));
            Thread responseReceiver = new Thread(new ClientResponseReceiver(in));
            requestSender.start();
            responseReceiver.start();
        } catch (IOException exception) {
            exception.printStackTrace();
        }

    }
}
