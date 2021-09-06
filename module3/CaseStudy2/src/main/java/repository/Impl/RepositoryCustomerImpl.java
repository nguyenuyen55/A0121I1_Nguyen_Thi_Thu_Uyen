package repository.Impl;

import bean.Customer;
import bean.CustomerType;
import repository.IRepositotyCustomer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RepositoryCustomerImpl implements IRepositotyCustomer {

    public static final String SELECT_FROM_CUSTOMER = "select * from customer";
    public static final String SELECT_FROM_CUSTOMER_TYPE = "select * from customer_type";
    public static final String INSERT_CUSTOMER = "insert into customer(customer_type_id,customer_name,customer_birthday,customer_gender,customer_id_car,customer_phone,customer_email,customer_address)\n" +
            "values(?,?,?,?,?,?,?,?)";
    public static final String CUSTOMER_WHERE_CUSTOMER_ID = "select * from customer where customer_id =?";
    public static final String UPDATE_CUSTOMER = "update customer set customer_type_id=?,customer_name=?,customer_birthday=?,customer_gender=?,customer_id_car=?,customer_phone=?,customer_email=?,customer_address=?\n" +
            "where customer.customer_id =?";

    @Override
    public List<Customer> customer_list() {
        List<Customer> customers = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            statement = connection.prepareStatement(SELECT_FROM_CUSTOMER);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int customer_id = resultSet.getInt("customer_id");
                int customer_type_id = resultSet.getInt("customer_type_id");
                String customer_name = resultSet.getString("customer_name");
                String customer_birthday = resultSet.getString("customer_birthday");
                int customer_gender = resultSet.getInt("customer_gender");
                String customer_id_car = resultSet.getString("customer_id_car");
                String customer_phone = resultSet.getString("customer_phone");
                String customer_email = resultSet.getString("customer_email");
                String customer_address = resultSet.getString("customer_address");
                customers.add(new Customer(customer_id, customer_type_id, customer_name, customer_birthday, customer_gender, customer_id_car, customer_phone, customer_email, customer_address));
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
        return customers;
    }

    @Override
    public List<CustomerType> customer_types() {
        List<CustomerType> customerTypes = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            statement = connection.prepareStatement(SELECT_FROM_CUSTOMER_TYPE);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int customer_type_id = resultSet.getInt("customer_type_id");
                String customer_type_name = resultSet.getString("customer_type_name");
                customerTypes.add(new CustomerType(customer_type_id, customer_type_name));
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
        return customerTypes;
    }

    @Override
    public void addNewCustomer(Customer customer) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(INSERT_CUSTOMER);
            statement.setInt(1, customer.getCustomer_type_id());
            statement.setString(2, customer.getCustomer_name());
            statement.setString(3, customer.getCustomer_birthday());
            statement.setInt(4, customer.getCustomer_gender());
            statement.setString(5, customer.getCustomer_id_card());
            statement.setString(6, customer.getCustomer_phone());
            statement.setString(7, customer.getCustomer_email());
            statement.setString(8, customer.getCustomer_address());
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
    public void update(Customer customer, int id) {

        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;

        try {
            statement = connection.prepareStatement(UPDATE_CUSTOMER);
            statement.setInt(1, customer.getCustomer_type_id());
            statement.setString(2, customer.getCustomer_name());
            statement.setString(3, customer.getCustomer_birthday());
            statement.setInt(4, customer.getCustomer_gender());
            statement.setString(5, customer.getCustomer_id_card());
            statement.setString(6, customer.getCustomer_phone());
            statement.setString(7, customer.getCustomer_email());
            statement.setString(8, customer.getCustomer_address());
            statement.setInt(9, customer.getCustomer_id());
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
    public void delete(int id) {
        Customer customer = selectById(id);
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;

        try {
            statement = connection.prepareStatement("delete from customer where customer.customer_id=?");
            statement.setInt(1, id);
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
    public Customer selectById(int id) {
        Customer customer = null;
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            statement = connection.prepareStatement(CUSTOMER_WHERE_CUSTOMER_ID);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int customer_id = resultSet.getInt("customer_id");
                int customer_type_id = resultSet.getInt("customer_type_id");
                String customer_name = resultSet.getString("customer_name");
                String customer_birthday = resultSet.getString("customer_birthday");
                int customer_gender = resultSet.getInt("customer_gender");
                String customer_id_car = resultSet.getString("customer_id_car");
                String customer_phone = resultSet.getString("customer_phone");
                String customer_email = resultSet.getString("customer_email");
                String customer_address = resultSet.getString("customer_address");
                customer = new Customer(customer_id, customer_type_id, customer_name, customer_birthday, customer_gender, customer_id_car, customer_phone, customer_email, customer_address);

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
        return customer;
    }

    @Override
    public List<Customer> searchByName(String name) {
        List<Customer> customers = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            statement = connection.prepareStatement("select * from customer where customer_name like ?");
            statement.setString(1, "%" + name + "%");
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int customer_id = resultSet.getInt("customer_id");
                int customer_type_id = resultSet.getInt("customer_type_id");
                String customer_name = resultSet.getString("customer_name");
                String customer_birthday = resultSet.getString("customer_birthday");
                int customer_gender = resultSet.getInt("customer_gender");
                String customer_id_car = resultSet.getString("customer_id_car");
                String customer_phone = resultSet.getString("customer_phone");
                String customer_email = resultSet.getString("customer_email");
                String customer_address = resultSet.getString("customer_address");
                customers.add(new Customer(customer_id, customer_type_id, customer_name, customer_birthday, customer_gender, customer_id_car, customer_phone, customer_email, customer_address));
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
        return customers;
    }
}
