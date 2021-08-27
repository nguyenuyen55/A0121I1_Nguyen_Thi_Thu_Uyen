package repository;

import bean.User;

import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ImlRepositoryUser implements IRepositoryUser {

    public static final String INSERT_USER_SQL = "insert into users (name,email,country) value(?,?,?)";
    public static final String SELECT_FROM_USERS = "Select * from users";
    public static final String UPDATE_USERS = "update users set name =?, email=?,country =? where id = ?";
    public static final String DELETE_FROM_USERS_WHERE_ID = "delete from users where id=?";
    public static final String CALL_SEARCH_BY_ID = "call searchById(?)";
    public static final String CALL_INSERT_USER = "call insertUser(?,?,?)";
    public static final String USER_ID_PERMISION_ID_VALUES = "INSERT INTO user_permision(user_id,permision_id)VALUES(?,?)";
    private static final String SQL_INSERT = "INSERT INTO EMPLOYEE (NAME, SALARY, CREATED_DATE) VALUES (?,?,?)";
    private static final String SQL_UPDATE = "UPDATE EMPLOYEE SET SALARY=? WHERE NAME=?";
    private static final String SQL_TABLE_CREATE = "CREATE TABLE EMPLOYEE"
            + "("
            + " ID serial,"
            + " NAME varchar(100) NOT NULL,"
            + " SALARY numeric(15, 2) NOT NULL,"
            + " CREATED_DATE timestamp,"
            + " PRIMARY KEY (ID)"
            + ")";

    private static final String SQL_TABLE_DROP = "DROP TABLE IF EXISTS EMPLOYEE";
    public static final String CALL_SELECT_ALL_USER = "call select_all_user()";
    public static final String CALL_UPDATE_USER = "call update_user(?,?,?,?)";
    public static final String CALL_DELETE_USER = "call delete_user(?)";

    @Override
    public void createUser(User user) {
        Connection connection = DBConnection.getConnection();
        CallableStatement statement = null;

        try {
            statement = connection.prepareCall(CALL_INSERT_USER);
            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getCountry());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        DBConnection.close();
    }

    @Override
    public void update(User user) {

        Connection connection = DBConnection.getConnection();
        CallableStatement statement = null;

        try {
            statement = connection.prepareCall(CALL_UPDATE_USER);

            statement.setInt(1, user.getId());
            statement.setString(2, user.getName());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getCountry());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        DBConnection.close();
    }

    @Override
    public List<User> users() {
        Connection connection = DBConnection.getConnection();
        CallableStatement statement = null;
        ResultSet resultSet = null;
        List<User> users = new ArrayList<>();

        try {
            statement = connection.prepareCall(CALL_SELECT_ALL_USER);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");
                int id = resultSet.getInt("id");
                users.add(new User(id, name, email, country));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                resultSet.close();
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        DBConnection.close();


        return users;
    }

    @Override
    public boolean delete(int id) {
        boolean rowDel = false;
        User user = selectById(id);
        Connection connection = DBConnection.getConnection();
        CallableStatement statement = null;

        try {
            statement = connection.prepareCall(CALL_DELETE_USER);
            statement.setInt(1, user.getId());
            rowDel = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        DBConnection.close();
        return rowDel;
    }

    @Override
    public User selectById(int id) {
        User user = null;
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement("select * from users where id= ?");
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");
                user = new User(id, name, email, country);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            try {
                resultSet.close();
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        DBConnection.close();
        return user;
    }

    @Override
    public User searchById(int id) {
        User user = null;
        Connection connection = DBConnection.getConnection();
        CallableStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareCall(CALL_SEARCH_BY_ID);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");
                user = new User(id, name, email, country);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                resultSet.close();
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        DBConnection.close();
        return user;
    }
    void addUserTrance() throws SQLException {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
//insert into users
//values(333,"uus","ususu","hsus")
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement("insert into users values(?,?,?,?)");

            statement.setInt(1, 55);
            statement.setString(2, "tam");
            statement.setString(3, "tam@gmail.com");
            statement.setString(4,"vn");
            statement.executeUpdate();
            statement.setInt(1, 55);
            statement.setString(2, "dai phat");
            statement.setString(3, "tamphat@gmail.com");
            statement.setString(4,"vn");
            statement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {

            e.printStackTrace();
            connection.rollback();
        } finally {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        DBConnection.close();
    }

    public static void main(String[] args) throws SQLException {
        //test Trance
        ImlRepositoryUser imlRepositoryUser = new ImlRepositoryUser();
        imlRepositoryUser.addUserTrance();
    }



}
