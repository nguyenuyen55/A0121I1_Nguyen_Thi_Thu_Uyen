package repository.Impl;

import bean.RentType;
import repository.IRepositoryRentType;

import javax.naming.CompositeName;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RepositoryRentTypeImpl implements IRepositoryRentType {
    @Override
    public List<RentType> rentypes() {
        Connection connection = DBConnection.getConnection();
        List<RentType> rentTypes = new ArrayList<>();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement =connection.prepareStatement("select * from rent_type");
            resultSet = statement.executeQuery();
            while(resultSet.next()){
                int typeId = resultSet.getInt("rent_type_id");
                String typename = resultSet.getString("rent_type_name");
                double typeCost = resultSet.getInt("rent_type_cost");
                rentTypes.add(new RentType(typeId,typename,typeCost));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }  finally {
            try {
                resultSet.close();
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        DBConnection.close();
        return rentTypes;
    }
}
