package com.softserve.itacademy;

public class User {
    private static int counter = 1;
    private int id;
    private String username;
    private String password;

    public User() {
        this.id = counter++;
    }

    public User(String username, String password) {
        this.id = counter++;
        this.username = username;
        this.password = password;
    }

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        User.counter = counter;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}