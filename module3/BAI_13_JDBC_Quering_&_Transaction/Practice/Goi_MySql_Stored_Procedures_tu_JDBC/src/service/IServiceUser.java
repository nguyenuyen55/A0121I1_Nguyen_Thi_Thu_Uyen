package service;

import bean.User;

import java.util.List;

public interface IServiceUser {
    void createUser(User user);

    void update(User user);

    List<User> users();

    boolean delete(int id);

    User selectById(int id);

    User searchById(int id);

    void addUserTransaction(User user, int[] permission);

    void insertUpdateWithoutTransaction();

   void insertUpdateUseTransaction();
}
