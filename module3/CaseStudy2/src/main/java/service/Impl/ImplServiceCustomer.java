package service.Impl;

import bean.Customer;
import bean.CustomerType;
import repository.IRepositotyCustomer;
import repository.Impl.RepositoryCustomerImpl;
import service.IServiceCustomer;

import java.util.List;

public class ImplServiceCustomer implements IServiceCustomer {
    IRepositotyCustomer repositotyCustomer= new RepositoryCustomerImpl();
    @Override
    public List<Customer> customer_list() {
        return repositotyCustomer.customer_list();
    }



    @Override
    public void update(Customer customer, int id) {
repositotyCustomer.update(customer,id);
    }

    @Override
    public void delete(int id) {
repositotyCustomer.delete(id);
    }

    @Override
    public Customer selectById(int id) {
        return repositotyCustomer.selectById(id);
    }

    @Override
    public List<Customer> searchByName(String name) {
        return repositotyCustomer.searchByName(name);
    }

    @Override
    public List<CustomerType> customer_types() {
        return repositotyCustomer.customer_types();
    }

    @Override
    public void addNewCustomer(Customer customer) {
        repositotyCustomer.addNewCustomer(customer);
    }
}
