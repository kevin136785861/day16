package service;

import dao.UserDao;
import dao.UserDaoImp;
import domain.User;

import java.util.List;

public class UserServiceIml implements UserService {
    private UserDao userDao = new UserDaoImp();
    @Override
    public User login(User user) {
        User search = userDao.search(user.getName(), user.getPwd());
        if(search != null){
            if(user.getPwd().equals(search.getPwd())){
                return search;
            }
        }
        return null;
    }

    @Override
    public List<String> userAll() {
        List<String> list = userDao.userAll();
        return list;
    }
}
