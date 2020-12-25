package service;

import domain.User;

import java.util.List;

public interface UserService {
    User login(User user);
    List<String> userAll();
}
