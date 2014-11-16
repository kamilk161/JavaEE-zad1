package pl.kkrampa.lab1.service;

import pl.kkrampa.lab1.domain.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserService {
    public ArrayList<User> userzy;

    public UserService() {
        try {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream("baza.out"));
            userzy = (ArrayList<User>) is.readObject();
        } catch (IOException e) {
            userzy = new ArrayList<User>();
        } catch (ClassNotFoundException e) {
            userzy = new ArrayList<User>();
        }
    }

    public User findByLogin(String username) {
        for(User user : userzy) {
            if(user.getLogin().equals(username)) {
                return user;
            }
        }
        return null;
    }

    public boolean addUser(User user) {
        if(findByLogin(user.getLogin()) == null) {
            if(user.getPassword().equals(user.getRpassword())) {
                userzy.add(user);
                try {
                    ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("baza.out"));
                    os.writeObject(userzy);
                } catch (IOException e) {}
                return true;
            }
        }
        return false;
    }
}
