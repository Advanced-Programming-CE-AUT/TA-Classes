package server;

import model.MyDictionary;
import utils.FileUtils;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements Runnable {
    private int port;
    private FileUtils fileUtils;
    private MyDictionary myDictionary;

    public Server(int port){
        this.port = port;
        this.fileUtils = new FileUtils();
        this.myDictionary = new MyDictionary(fileUtils.loadDictionaryMap());
    }


    @Override
    public void run() {
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client accepted from "+clientSocket);
                ClientHandler clientHandler = new ClientHandler(clientSocket, myDictionary);
                Thread thread = new Thread(clientHandler);
                thread.start();
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
