package model.repository;

import model.bean.User;

import java.sql.SQLException;
import java.util.List;

public interface IRepositoryUser {
     void insertUser(User user) throws SQLException;
     User selectUser(int id);
    List<User> selectAllUsers();
    boolean deleteUser(int id);
    boolean updateUser(User user);
    List<User> searchUser(String name) ;

}
