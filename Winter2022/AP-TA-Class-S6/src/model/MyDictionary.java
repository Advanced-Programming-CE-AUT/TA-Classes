package model;

import java.util.HashMap;

public class MyDictionary {
    private final HashMap<String, String> dictionaryMap;

    public MyDictionary() {
        dictionaryMap = new HashMap<>();
    }

    public MyDictionary(HashMap<String, String> map) {
        this.dictionaryMap = map;
    }

    public HashMap<String, String> getDictionaryMap() {
        return dictionaryMap;
    }

    public synchronized void addWord(String word, String description) {
        this.dictionaryMap.put(word, description);
    }
    public String meaningOf(String word) {
        return this.dictionaryMap.get(word);
    }

    public synchronized void reset() {
        this.dictionaryMap.clear();
    }

    public void putAllDictionaryMap(HashMap<String, String> map) {
        this.dictionaryMap.putAll(map);
    }

}
