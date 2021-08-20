package model.service;

import model.bean.User;
import model.repository.IRepositoryUser;
import model.repository.ImlRepositorUser;

import java.sql.SQLException;
import java.util.List;

public class ImIUserService implements IUserService {
    private IRepositoryUser imlRepositorUser = new ImlRepositorUser();
    @Override
    public void insertUser(User user) throws SQLException {
        imlRepositorUser.insertUser(user);
    }

    @Override
    public User selectUser(int id) {
        return imlRepositorUser.selectUser(id);
    }

    @Override
    public List<User> selectAllUsers() {
        return imlRepositorUser.selectAllUsers();
    }

    @Override
    public boolean deleteUser(int id) {
        return imlRepositorUser.deleteUser(id);
    }

    @Override
    public boolean updateUser(User user) {
        return imlRepositorUser.updateUser(user);
    }

    @Override
    public List<User> searchUser(String country) {
        return imlRepositorUser.searchUser(country);
    }
}
