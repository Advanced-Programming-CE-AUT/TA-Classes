import exception.InvalidInputException;
import model.MyDictionary;
import utils.FileUtils;

import java.util.HashMap;
import java.util.Scanner;

public class DictionaryApplication {
    private final MyDictionary myDictionary;

    public DictionaryApplication() {
        this.myDictionary = new MyDictionary();
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                processInput(scanner.nextLine());
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }

    private void processInput(String input) throws Exception {
        Scanner scanner = new Scanner(input);
        String command = scanner.next();
        switch (command) {
            case "add":
                if (input.contains("\"")) {
                    addCommand(input);
                } else {
                    throw new Exception();
                }
                break;
            case "meaning":
                if (input.contains("\"")) {
                    meanCommand(input);
                } else {
                    throw new Exception();
                }
                break;
            case "load-bin":
                loadCommand(input);
                break;
            case "load-txt":
                loadTxtCommand(input);
                break;
            case "out-bin":
                outBinCommand(input);
                break;
            case "out-txt":
                outTxtCommand(input);
                break;
            case "reset":
                reset();
                break;
            case "exit":
                System.exit(0);
                break;
            case "help":
                helpCommand();
            default:
                throw new Exception();
        }
    }

    private void helpCommand() {
        System.out.println(
                "1- add \"[word]\" \"[description]\" -- add a word to the dictionary.\n" +
                        "2- meaning \"[word]\" -- prints the meaning of the word.\n" +
                        "3- load-bin [file name] -- loads dictionary from a binary file\n" +
                        "4- load-txt [file name] -- loads dictionary from a txt file (format of file : [word]:[description])\n" +
                        "5- out-bin [file name] -- saves the dictionary to the file (binary file)\n" +
                        "6- out-txt [file name] -- saves the dictionary to the file (text file)\n" +
                        "3- help -- prints this message.\n");

    }

    private void meanCommand(String input) {
        int firstIndexOf = input.indexOf("\"");
        int secondIndexOf = input.indexOf("\"", firstIndexOf + 1);
        String word = input.substring(firstIndexOf + 1, secondIndexOf);
        String description = this.myDictionary.meaningOf(word);
        if (description == null) {
            System.err.println("not found !");
        } else {
            System.out.println(description);
        }

    }

    private void addCommand(String input) {
        int firstIndexOf = input.indexOf("\"");
        int secondIndexOf = input.indexOf("\"", firstIndexOf + 1);
        String word = input.substring(firstIndexOf + 1, secondIndexOf);
        firstIndexOf = input.indexOf("\"", secondIndexOf + 1);
        secondIndexOf = input.indexOf("\"", firstIndexOf + 1);
        String description = input.substring(firstIndexOf + 1, secondIndexOf);
        this.myDictionary.addWord(word, description);
        System.out.println("the word has been added successfully!");
    }

    public void reset() {
        myDictionary.reset();
    }
}
