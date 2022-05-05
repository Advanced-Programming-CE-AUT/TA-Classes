package utils;

import model.MyDictionary;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class FileUtils {

    private File dictionaryMapFile;

    public FileUtils() {
        dictionaryMapFile = new File("dictionary.bin");
    }

    public HashMap<String, String> readDictionaryMap(String fileName) {
        HashMap<String, String> dictionaryMap = null;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))){
            dictionaryMap = (HashMap<String, String>) in.readObject();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return dictionaryMap;
    }

    public void writeDictionaryMap(HashMap<String, String> dictionaryMap, String fileName){
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))){
            out.writeObject(dictionaryMap);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void outTxt(HashMap<String, String> dictionaryMap, String fileName){
        try(BufferedWriter out = new BufferedWriter(new FileWriter(fileName))){
            Set<String> words = dictionaryMap.keySet();
            Iterator<String> it = words.iterator();
            while(it.hasNext()){
                String word = it.next();
                out.write(word + ":" + dictionaryMap.get(word) + "\n");
            }
            out.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public HashMap<String, String> loadTxt(String fileName){
        HashMap<String, String> dictionaryMap = new HashMap<>();
        try(Scanner scanner = new Scanner(new File(fileName))){
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                String[] array = line.split(":");
                String word = array[0];
                String description = array[1];
                dictionaryMap.put(word, description);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return dictionaryMap;
    }

    public HashMap<String, String> loadDictionaryMap(){
        if(!this.dictionaryMapFile.exists()){
            try {
                dictionaryMapFile.createNewFile();
                HashMap<String, String> map = new HashMap<>();
                writeDictionaryMap(map, dictionaryMapFile.getName());
                return map;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return readDictionaryMap(dictionaryMapFile.getName());
    }

    public String getDictionaryMapFileName() {
        return dictionaryMapFile.getName();
    }
}
