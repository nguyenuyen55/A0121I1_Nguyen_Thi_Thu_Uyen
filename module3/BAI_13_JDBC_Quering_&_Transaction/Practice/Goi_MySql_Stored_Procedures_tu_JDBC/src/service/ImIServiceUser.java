package service;

import bean.User;
import repository.IRepositoryUser;
import repository.ImlRepositoryUser;

import java.util.List;

public class ImIServiceUser implements IServiceUser {
    private IRepositoryUser repositoryUser = new ImlRepositoryUser();

    @Override
    public void createUser(User user) {
        repositoryUser.createUser(user);
    }

    @Override
    public void update(User user) {
        repositoryUser.update(user);
    }

    @Override
    public List<User> users() {
        return repositoryUser.users();
    }

    @Override
    public boolean delete(int id) {
        return repositoryUser.delete(id);
    }

    @Override
    public User selectById(int id) {
        return repositoryUser.selectById(id);
    }

    @Override
    public User searchById(int id) {
        return repositoryUser.searchById(id);
    }

    @Override
    public void addUserTransaction(User user, int[] permission) {
        repositoryUser.addUserTransaction(user, permission);
    }

    @Override
    public void insertUpdateWithoutTransaction() {
        repositoryUser.insertUpdateWithoutTransaction();
    }

    @Override
    public void insertUpdateUseTransaction() {
        repositoryUser.insertUpdateUseTransaction();
    }
}
