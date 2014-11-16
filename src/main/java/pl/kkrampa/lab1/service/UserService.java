package pl.kkrampa.lab1.service;

import pl.kkrampa.lab1.domain.User;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    public List<User> userzy = new ArrayList<User>();

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
            userzy.add(user);
            return true;
        }
        return false;
    }
}
