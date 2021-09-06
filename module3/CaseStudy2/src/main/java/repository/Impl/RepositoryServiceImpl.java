package repository.Impl;

import bean.Customer;
import bean.CustomerType;
import bean.Service;
import repository.IRepositoryService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RepositoryServiceImpl implements IRepositoryService {
    public static final String SELECT_FROM_CUSTOMER_TYPE = "select * from customer_type";
    public static final String INSERT_SERVICE = "insert into service(service_name,service_area,service_cost,service_max_people,rent_type_id,service_type_id,standard_room,description_other_convenience,pool_area,number_of_floors)\n" +
            "values(?,?,?,?,?,?,?,?,?,?)";

    @Override
    public List<Service> services()  {
        List<Service> services= new ArrayList<>();
        Connection  connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            statement = connection.prepareStatement("select * from service");
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                int serviceId = resultSet.getInt("service_id");
                String serviceName= resultSet.getString("service_name");
                int serviceArea= resultSet.getInt("service_area");
                double serviceCost = resultSet.getDouble("service_cost");
                int serviceMaxPeople= resultSet.getInt("service_max_people");
                int rentType= resultSet.getInt("rent_type_id");
                int serviceTypeId= resultSet.getInt("service_type_id");
                String standRoom= resultSet.getString("standard_room");
                String description = resultSet.getString("description_other_convenience");
                double poolArea= resultSet.getDouble("pool_area");
                int numberFloors= resultSet.getInt("number_of_floors");
                services.add(new Service(serviceId,serviceName,serviceArea,serviceCost, serviceMaxPeople,rentType,serviceTypeId, standRoom,description,poolArea, numberFloors));


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
        }
        DBConnection.close();
        return services;
    }

    @Override
    public void addNewCustomer(Service service) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(INSERT_SERVICE);
            statement.setString(1, service.getService_name());
            statement.setInt(2,service.getService_area());
            statement.setDouble(3,service.getService_cost());
            statement.setInt(4,service.getService_people());
            statement.setInt(5,service.getRent_id());
            statement.setInt(6,service.getService_type_id());
            statement.setString(7,service.getStandard_room());
            statement.setString(8,service.getDescription());
            statement.setDouble(9,service.getPool_area());
            statement.setInt(10,service.getNumber_foors());
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
}
