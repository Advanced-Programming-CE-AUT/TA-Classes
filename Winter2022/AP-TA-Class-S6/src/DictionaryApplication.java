import exception.InvalidInputException;
import model.MyDictionary;
import utils.FileUtils;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class DictionaryApplication {
    private final MyDictionary myDictionary;
    private final FileUtils fileUtils;

    public DictionaryApplication() {
        this.fileUtils = new FileUtils();
        this.myDictionary = new MyDictionary(fileUtils.loadDictionaryMap());
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                processInput(scanner.nextLine());
            } catch (InvalidInputException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    private void processInput(String input) throws InvalidInputException {
        Scanner scanner = new Scanner(input);
        String command = scanner.next();
        switch (command) {
            case "add":
                if (input.contains("\"")) {
                    addCommand(input);
                } else {
                    throw new InvalidInputException();
                }
                break;
            case "meaning":
                if (input.contains("\"")) {
                    meanCommand(input);
                } else {
                    throw new InvalidInputException();
                }
                break;
            case "load-bin":
                loadBinCommand(input);
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
                throw new InvalidInputException();
        }
    }

    private void outBinCommand(String input) {
        String[] splitInput = input.split(" ");
        String fileName = splitInput[1];
        fileUtils.writeDictionaryMap(myDictionary.getDictionaryMap(), fileName);
    }

    private void outTxtCommand(String input) {
        String[] splitInput = input.split(" ");
        String fileName = splitInput[1];
        fileUtils.outTxt(this.myDictionary.getDictionaryMap(), fileName);
    }

    private void loadTxtCommand(String input) throws InvalidInputException {
        String[] splitInput = input.split(" ");
        if (splitInput.length == 2) {
            String fileName = splitInput[1];
            HashMap<String, String> map = fileUtils.loadTxt(fileName);
            this.myDictionary.putAllDictionaryMap(map);
            updateDictionaryMap();
        } else {
            throw new InvalidInputException();
        }
    }

    private void loadBinCommand(String input) throws InvalidInputException {
        String[] splitInput = input.split(" ");
        if (splitInput.length == 2) {
            String filename = splitInput[1];
            HashMap<String, String> map = fileUtils.readDictionaryMap(filename);
            this.myDictionary.putAllDictionaryMap(map);
            updateDictionaryMap();
        } else {
            throw new InvalidInputException();
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
                        "7- help -- prints this message.\n");

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
        updateDictionaryMap();
        System.out.println("the word has been added successfully!");
    }

    private void updateDictionaryMap() {
        fileUtils.writeDictionaryMap(this.myDictionary.getDictionaryMap(), fileUtils.getDictionaryMapFileName());
    }

    public void reset() {
        myDictionary.reset();
        updateDictionaryMap();
    }
}
