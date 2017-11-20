package com.example.nguye.happybirthday;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * Created by nguye on 20-Nov-17.
 */

public class Song {
    private String name;
    private int length; // second
    private String author;

    public Song(String name, int length, String author) {
        this.name = name;
        this.length = length;
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLength() {
        String result = (int)(length / 60) + ":";
        result += length % 60;
        return result;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

}
