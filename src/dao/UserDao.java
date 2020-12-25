package dao;

import domain.User;

import java.util.List;

public interface UserDao {
    User search(String username, String pwd);
    List<String> userAll();
}
