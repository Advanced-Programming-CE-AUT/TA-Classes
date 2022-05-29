package model;

import java.io.Serializable;

public class Request implements Serializable {
    private RequestType type;
    private String word;
    private String description;

    public Request(RequestType type, String word, String description) {
        this.type = type;
        this.word = word;
        this.description = description;
    }

    public RequestType getType() {
        return type;
    }

    public String getWord() {
        return word;
    }

    public String getDescription() {
        return description;
    }
}
