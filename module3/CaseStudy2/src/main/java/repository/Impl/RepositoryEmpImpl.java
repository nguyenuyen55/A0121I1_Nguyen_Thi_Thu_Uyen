package repository.Impl;

import bean.Employee;
import bean.Service;
import repository.IRepositoryEmployee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RepositoryEmpImpl implements IRepositoryEmployee {
    @Override
    public List<Employee> employees() {
        List<Employee> employees= new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            statement = connection.prepareStatement("select * from employee");
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                int empId = resultSet.getInt("employee_id");
                String empName= resultSet.getString("employee_name");
                Date dateBirthday=resultSet.getDate("employee_birthday");
                String idcard= resultSet.getString("employee_id_card");
                Double salary = resultSet.getDouble("employee_salary");
                String phone = resultSet.getString("employee_phone");
                String email = resultSet.getString("employee_email");
                String address = resultSet.getString("employee_address");
                int postionId= resultSet.getInt("position_id");
                int eduction = resultSet.getInt("education_degree_id");
                int divisionId= resultSet.getInt("division_id");
                String username= resultSet.getString("username");
                employees.add(new Employee(empId,empName,dateBirthday,idcard,salary,phone,email,address,postionId,eduction,divisionId,username) );
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
        return employees;
    }

    @Override
    public void addEmp(Employee e) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("insert into employee (employee_name,position_id,education_degree_id,division_id,employee_birthday,employee_id_card,employee_salary,employee_phone,employee_address,employee_email)\n" +
                    "values (?,?,?,?,?,?,?,?,?,?)");
           statement.setString(1,e.getEmployeeName());
            statement.setInt(2,e.getPostionId());
            statement.setInt(3,e.getEducationId());
            statement.setInt(4,e.getDivisionId());
           statement.setDate(5, (java.sql.Date) e.getDateBirthday());
           statement.setString(6,e.getIdCard());
           statement.setDouble(7,e.getSalary());
           statement.setString(8,e.getPhone());
            statement.setString(9,e.getAddress());
           statement.setString(10,e.getEmail());
            statement.executeUpdate();
        } catch (SQLException e1) {
            e1.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
        }
        DBConnection.close();
    }

    @Override
    public void updateEmp(Employee emp, int id) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;

        try {
            statement = connection.prepareStatement("update employee\n" +
                    "set employee_name =?,position_id=?,education_degree_id=?,division_id=?,employee_birthday=?,employee_id_card=?,employee_salary=?,employee_phone=?,employee_address=?,employee_email=?\n" +
                    "where employee_id=?");
            statement.setString(1,emp.getEmployeeName());
            statement.setInt(2,emp.getPostionId());
            statement.setInt(3,emp.getEducationId());
            statement.setInt(4,emp.getDivisionId());
            statement.setDate(5, (java.sql.Date) emp.getDateBirthday());
            statement.setString(6,emp.getIdCard());
            statement.setDouble(7,emp.getSalary());
            statement.setString(8,emp.getPhone());
            statement.setString(9,emp.getAddress());
            statement.setString(10,emp.getEmail());
            statement.setInt(11,id);
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
    public void deleteEmp(int id) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("delete from employee where employee_id=? ");

            statement.setInt(1,id);
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
    public Employee selectById(int id) {
        Employee employee =null;
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            statement = connection.prepareStatement("select * from employee where employee_id=?");
            statement.setInt(1,id);
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                int empId = resultSet.getInt("employee_id");
                String empName= resultSet.getString("employee_name");
                Date dateBirthday=resultSet.getDate("employee_birthday");
                String idcard= resultSet.getString("employee_id_card");
                Double salary = resultSet.getDouble("employee_salary");
                String phone = resultSet.getString("employee_phone");
                String email = resultSet.getString("employee_email");
                String address = resultSet.getString("employee_address");
                int postionId= resultSet.getInt("position_id");
                int eduction = resultSet.getInt("education_degree_id");
                int divisionId= resultSet.getInt("division_id");
                String username= resultSet.getString("username");
                employee = new Employee(empId,empName,dateBirthday,idcard,salary,phone,email,address,postionId,eduction,divisionId,username) ;
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
        return employee;
    }

    @Override
    public List<Employee> search(String name) {
        List<Employee> employees= new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            statement = connection.prepareStatement("select * from employee where employee_name like ?");
            statement.setString(1,"%"+name+"%");
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                int empId = resultSet.getInt("employee_id");
                String empName= resultSet.getString("employee_name");
                Date dateBirthday=resultSet.getDate("employee_birthday");
                String idcard= resultSet.getString("employee_id_card");
                Double salary = resultSet.getDouble("employee_salary");
                String phone = resultSet.getString("employee_phone");
                String email = resultSet.getString("employee_email");
                String address = resultSet.getString("employee_address");
                int postionId= resultSet.getInt("position_id");
                int eduction = resultSet.getInt("education_degree_id");
                int divisionId= resultSet.getInt("division_id");
                String username= resultSet.getString("username");
                employees.add(new Employee(empId,empName,dateBirthday,idcard,salary,phone,email,address,postionId,eduction,divisionId,username) );
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
        return employees;
    }


}
