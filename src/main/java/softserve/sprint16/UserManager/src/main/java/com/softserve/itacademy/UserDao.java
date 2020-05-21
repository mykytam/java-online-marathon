package com.softserve.itacademy;

import java.util.LinkedList;
import java.util.List;

public class UserDao {

    private static UserDao userDaoInstance = null;
    private List<User> users = new LinkedList<>();

    private UserDao() {
    }

    public static UserDao getInstance() {
        if (userDaoInstance == null) {
            userDaoInstance = new UserDao();
            return userDaoInstance;
        }
        return userDaoInstance;
    }

    public boolean create(User user) {
        if (user != null) {
            return users.add(user);
        }
        return false;
    }

    public User read(int id) {
        return users
                .stream()
                .filter(user -> user.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public boolean update(int id, User user) {
        int index = users.indexOf(read(id));
        return users.set(index, user) != null;
    }

    public boolean delete(int id) {
        return users.remove(read(id));
    }

    public List<User> readAll() {
        return users;
    }
}