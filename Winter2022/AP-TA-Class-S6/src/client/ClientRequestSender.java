package client;

import exception.InvalidInputException;
import model.Request;
import model.RequestType;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class ClientRequestSender implements Runnable{
    private ObjectOutputStream out;

    public ClientRequestSender(ObjectOutputStream out) {
        this.out = out;
    }


    @Override
    public void run() {
        String input = "";
        Scanner scanner = new Scanner(System.in);
        Request request = null;
        while (!input.equals("exit")){
            input = scanner.nextLine();
            if(input.equals("exit")){
                System.exit(0);
            }
            String command = (new Scanner(input)).next();
            switch (command) {
                case "add":
                    if (input.contains("\"")) {
                        request = addCommand(input);
                    }
                    break;
                case "meaning":
                    if (input.contains("\"")) {
                        request = meanCommand(input);
                    }
                    break;

                case "exit":
                    System.exit(0);
                    break;
                case "help":
                    request = helpCommand();
                    break;
            }
            try {
                out.writeObject(request);
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
    }

    private Request meanCommand(String input) {
        int firstIndexOf = input.indexOf("\"");
        int secondIndexOf = input.indexOf("\"", firstIndexOf + 1);
        String word = input.substring(firstIndexOf + 1, secondIndexOf);
        Request request = new Request(RequestType.MEANING, word, null);
        return request;
    }

    private Request addCommand(String input) {
        int firstIndexOf = input.indexOf("\"");
        int secondIndexOf = input.indexOf("\"", firstIndexOf + 1);
        String word = input.substring(firstIndexOf + 1, secondIndexOf);
        firstIndexOf = input.indexOf("\"", secondIndexOf + 1);
        secondIndexOf = input.indexOf("\"", firstIndexOf + 1);
        String description = input.substring(firstIndexOf + 1, secondIndexOf);
        Request request = new Request(RequestType.ADD_WORD, word, description);
        return request;
    }

    private Request helpCommand(){
        return new Request(RequestType.HELP, null, null);

    }

}
