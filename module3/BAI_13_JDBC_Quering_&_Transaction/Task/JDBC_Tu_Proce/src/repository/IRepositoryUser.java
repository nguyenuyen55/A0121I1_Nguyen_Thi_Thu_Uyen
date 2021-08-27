package repository;

import bean.User;

import java.util.List;

public interface IRepositoryUser {
    void createUser(User user);

    void update(User user);

    List<User> users();

    boolean delete(int id);

    User selectById(int id);

    User searchById(int id);




}
