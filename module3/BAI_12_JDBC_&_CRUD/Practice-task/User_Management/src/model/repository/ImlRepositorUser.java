package model.repository;

import model.bean.User;

import javax.jws.soap.SOAPBinding;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ImlRepositorUser  implements IRepositoryUser{

    private static final String INSERT_USERS_SQL = "INSERT INTO users" + "  (name, email, country) VALUES " +
            " (?, ?, ?);";

    private static final String SELECT_USER_BY_ID = "select id,name,email,country from users where id =?";
    private static final String SELECT_ALL_USERS = "select * from users";
    private static final String DELETE_USERS_SQL = "delete from users where id = ?;";
    private static final String UPDATE_USERS_SQL = "update users set name = ?,email= ?, country =? where id = ?;";
   // public static final String WHERE_COUNTRY_LIKE = "select * from users where country = ? ";
    public static final String WHERE_COUNTRY_LIKE = "select * from users where country like ? ";

    public ImlRepositorUser() {
    }


    @Override
    public void insertUser(User user) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement =null;

        if(connection != null){

        try {



            statement= connection.prepareStatement(INSERT_USERS_SQL);
            statement.setString(1,user.getName());
            statement.setString(2,user.getEmail());
            statement.setString(3,user.getCountry());

            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try{
                statement.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
            DBConnection.close();
        }
        }
        }




    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
    @Override
    public User selectUser(int id) {
        Connection connection =DBConnection.getConnection();
        PreparedStatement statement= null;
        ResultSet resultSet = null;

        User user = null;
        if(connection!=null){
            try {
                statement = connection.prepareStatement(SELECT_USER_BY_ID);
                statement.setInt(1,id);
                resultSet = statement.executeQuery();

                while (resultSet.next()){
                    String name = resultSet.getString("name");
                    String email = resultSet.getString("email");
                    String country = resultSet.getString("country");
                    user = new User(id,name,email,country);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                try {
                    resultSet.close();
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                DBConnection.close();
            }

        }
        return user;
    }


    @Override
    public List<User> selectAllUsers() {
        Connection connection = DBConnection.getConnection();
        PreparedStatement   statement =null;
        ResultSet resultSet=null;

        List<User> userList =new ArrayList<>();

        try {
            statement = connection.prepareStatement(SELECT_ALL_USERS);
            resultSet= statement.executeQuery();

            User user =null;
            while (resultSet.next()){
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");
                int id = resultSet.getInt("id");
                user = new User(id,name,email,country);
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try{
                resultSet.close();
                statement.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
            DBConnection.close();

        }Collections.sort(userList, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });

    return userList;
    }






    @Override
    public boolean deleteUser(int id) {
        boolean rowDeleted =false;
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement=null;

        try {
            statement= connection.prepareStatement(DELETE_USERS_SQL);
            statement.setInt(1,id);
            rowDeleted = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                statement.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
            DBConnection.close();
        }
return rowDeleted;

    }


    @Override
    public boolean updateUser(User user) {
        boolean rowUpdate =false;
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement=null;

        try {
            statement = connection.prepareStatement(UPDATE_USERS_SQL);
            statement.setString(1,user.getName());
            statement.setString(2,user.getEmail());
            statement.setString(3,user.getCountry());
            statement.setInt(4,user.getId());

            rowUpdate= statement.executeUpdate()>0;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try{
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            DBConnection.close();
        }
        return rowUpdate;


    }

    @Override
    public List<User> searchUser(String countryS)  {
       Connection connection = DBConnection.getConnection();
       PreparedStatement statement =null;
        User user=null;
       ResultSet resultSet =null;
        List<User> users = new ArrayList<>();

        try {
          statement = connection.prepareStatement(WHERE_COUNTRY_LIKE);
            statement.setString(1,"%"+countryS+"%");
            resultSet = statement.executeQuery();

            while (resultSet.next()){
                String name = resultSet.getString("name");
                String country = resultSet.getString("country");
                String email = resultSet.getString("email");
                int id= resultSet.getInt("id");
                user = new User(id,name,email,country);
                users.add(user);}
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try{
                resultSet.close();
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            DBConnection.close();
        }


       return users;
    }

}
