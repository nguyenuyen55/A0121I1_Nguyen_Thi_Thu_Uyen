package repository.Impl;

import bean.RentType;
import bean.ServiceType;
import repository.IRepositoryServiceType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RespositoryServiceTypeImpl implements IRepositoryServiceType {

    @Override
    public List<ServiceType> serviceTypes() {
        Connection connection = DBConnection.getConnection();
        List<ServiceType> serviceTypes = new ArrayList<>();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement =connection.prepareStatement("select * from service_type");
            resultSet = statement.executeQuery();
            while(resultSet.next()){
                int typeId = resultSet.getInt("service_type_id");
                String typename = resultSet.getString("service_type_name");
                serviceTypes.add(new ServiceType(typeId,typename));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                resultSet.close();
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        DBConnection.close();
        return serviceTypes;
    }
}
