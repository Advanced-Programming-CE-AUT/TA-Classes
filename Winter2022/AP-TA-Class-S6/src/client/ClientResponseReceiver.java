package client;

import model.Response;
import server.ClientHandler;

import java.io.IOException;
import java.io.ObjectInputStream;

public class ClientResponseReceiver implements Runnable{
    private ObjectInputStream in;

    public ClientResponseReceiver(ObjectInputStream in){
        this.in = in;
    }
    @Override
    public void run() {

        while (true){
            try {
                Response response = (Response) in.readObject();

                if(response.getStatusCode()/100 == 2){
                    System.out.println(response.getText());
                }
                else if(response.getStatusCode()/100 == 4){
                    System.err.println(response.getText());
                }
            } catch (IOException exception) {
                exception.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
