package repository;

import bean.Employee;

import java.util.List;

public interface IRepositoryEmployee {
    List<Employee> employees();
    void addEmp(Employee e);
    void updateEmp(Employee e,int id);
    void deleteEmp(int id);
    Employee selectById(int id);
    List<Employee> search(String name);
}
