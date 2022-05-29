package model;

import java.io.Serializable;

public class Response implements Serializable {
    private String text;
    private int statusCode;

    public Response(String text, int statusCode) {
        this.text = text;
        this.statusCode = statusCode;
    }

    public String getText() {
        return text;
    }

    public int getStatusCode() {
        return statusCode;
    }
}
