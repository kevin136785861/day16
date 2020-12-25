package dao;

import common.utils.JDBCUtils;
import domain.User;

import javax.sql.StatementEventListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImp implements UserDao {
    @Override
    public User search(String username, String pwd) {
        Connection connection = JDBCUtils.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT upwd FROM utb1 WHERE uname=?");
            ps.setString(1,username);
            ResultSet resultSet = ps.executeQuery();
            if(resultSet.next()){
                String upwd = resultSet.getString(1);
                return new User(username,upwd);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public List<String> userAll(){
        List<String> list = new ArrayList<>();
        Connection connection = JDBCUtils.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT uname FROM utb1");
            ResultSet resultSet = ps.executeQuery();
            while(resultSet.next()){
                list.add(resultSet.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
