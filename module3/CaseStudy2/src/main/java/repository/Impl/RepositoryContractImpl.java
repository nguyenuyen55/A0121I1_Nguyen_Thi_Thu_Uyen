package repository.Impl;

import bean.Contract;
import bean.Customer;
import repository.IRepositoryContract;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RepositoryContractImpl implements IRepositoryContract {
    @Override
    public List<Contract> contracts() {
        List<Contract> contracts = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            statement = connection.prepareStatement("select * from contract");
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int contractId = resultSet.getInt("contract_id");
                Date dateStart = resultSet.getDate("contract_start_date");
                Date dateEnd = resultSet.getDate("contract_end_date");
                Double deposit = resultSet.getDouble("contract_deposit");
                Double total = resultSet.getDouble("contract_total_money");
                int employeeId = resultSet.getInt("employee_id");
                int customerId = resultSet.getInt("customer_id");
                int serviceId = resultSet.getInt("service_id");

                contracts.add(new Contract(contractId,dateStart,dateEnd,deposit,total,employeeId,customerId,serviceId));
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
        return contracts;
    }

    @Override
    public void createContract(Contract contract) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("insert into contract(contract_start_date,contract_end_date,contract_deposit,contract_total_money,employee_id,customer_id,service_id)\n" +
                    "values(?,?,?,?,?,?,?)");
            statement.setDate(1, (Date) contract.getDateStart());
            statement.setDate(2, (Date) contract.getDateEnd());
            statement.setDouble(3,  contract.getDeposit());
            statement.setDouble(4,  contract.getContractTotal());
            statement.setInt(5,  contract.getEmployeeId());
            statement.setInt(6,  contract.getCustomerId());
            statement.setInt(7,  contract.getServiceId());
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
