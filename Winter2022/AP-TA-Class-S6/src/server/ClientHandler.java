package server;

import model.MyDictionary;
import model.Request;
import model.RequestType;
import model.Response;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientHandler implements Runnable {
    private Socket clientSocket;
    private ObjectInputStream inputStream;
    private ObjectOutputStream outputStream;
    private MyDictionary myDictionary;

    public ClientHandler(Socket clientSocket, MyDictionary myDictionary) {
        this.clientSocket = clientSocket;
        this.myDictionary = myDictionary;
        try {
            outputStream = new ObjectOutputStream(clientSocket.getOutputStream());
            inputStream = new ObjectInputStream(clientSocket.getInputStream());
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                Request request = (Request) inputStream.readObject();
                Response response = getResponse(request);
                outputStream.writeObject(response);
            } catch (IOException | ClassNotFoundException e) {
                //e.printStackTrace();
                outputStream.close();
                inputStream.close();

            }
        }
    }

    private Response getResponse(Request request) {
        Response response = null;
        if (request.getType() == RequestType.ADD_WORD) {
            String word = request.getWord();
            String description = request.getDescription();
            if (word == null || description == null) {
                response = new Response("Bad Request!", 400);
            } else {
                myDictionary.addWord(word, description);
                response = new Response("Word added successfully", 200);
            }
        } else if (request.getType() == RequestType.MEANING) {
            String word = request.getWord();
            if (word == null) {
                response = new Response("Bad Request!", 400);
            } else {
                String meaning = myDictionary.meaningOf(word);
                if (meaning == null) {
                    response = new Response("Not Found!", 404);
                } else {
                    response = new Response(word + ": " + meaning, 200);
                }
            }
        } else if (request.getType() == RequestType.HELP) {
            response = new Response(
                    "1- add \"[word]\" \"[description]\" -- add a word to the dictionary.\n" +
                            "2- meaning \"[word]\" -- prints the meaning of the word.\n" +
                            "3- help -- prints this message.\n", 200);
        } else {
            response = new Response("Bad Request!", 400);
        }
        return response;
    }
}
