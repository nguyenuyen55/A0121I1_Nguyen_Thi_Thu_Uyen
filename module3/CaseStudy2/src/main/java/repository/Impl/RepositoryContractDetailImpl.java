package repository.Impl;

import bean.Contract;
import bean.ContractDetail;
import repository.IRepositoryContractDetail;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RepositoryContractDetailImpl implements IRepositoryContractDetail {
    @Override
    public List<ContractDetail> contractDetails() {
        List<ContractDetail> contractDetails = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            statement = connection.prepareStatement("select * from contract_detail");
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int contract_detail_id = resultSet.getInt("contract_detail_id");
                int contract_id = resultSet.getInt("contract_id");
                int attach_service_id = resultSet.getInt("attach_service_id");
                int quantity = resultSet.getInt("quantity");

                contractDetails.add(new ContractDetail(contract_detail_id,contract_id,attach_service_id,quantity));

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
        return contractDetails;
    }

    @Override
    public void createContract(ContractDetail contractDetail) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("insert into contract_detail(contract_id,attach_service_id,quantity)\n" +
                    "values(?,?,?);");
            statement.setInt(1,  contractDetail.getContractId());
            statement.setInt(2,  contractDetail.getServiceid());
            statement.setInt(3,  contractDetail.getQuantity());
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
