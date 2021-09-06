package service.Impl;

import bean.Employee;
import repository.IRepositoryEmployee;
import repository.Impl.RepositoryEmpImpl;
import service.IServiceEmployee;

import java.util.List;

public class ImplServiceEmployee implements IServiceEmployee {
    private IRepositoryEmployee repositoryEmployee = new RepositoryEmpImpl();

    @Override
    public List<Employee> employees() {

        return repositoryEmployee.employees();
    }

    @Override
    public void addEmp(Employee e) {
        repositoryEmployee.addEmp(e);
    }

    @Override
    public void updateEmp(Employee e, int id) {
        repositoryEmployee.updateEmp(e, id);
    }

    @Override
    public void deleteEmp(int id) {
        repositoryEmployee.deleteEmp(id);
    }

    @Override
    public Employee selectById(int id) {
        return repositoryEmployee.selectById(id);
    }

    @Override
    public List<Employee> search(String name) {
        return repositoryEmployee.search(name);
    }
}
