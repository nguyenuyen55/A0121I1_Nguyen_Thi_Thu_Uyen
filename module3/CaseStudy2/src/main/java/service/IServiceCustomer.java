package service;

import bean.Customer;
import bean.CustomerType;

import java.util.List;

public interface IServiceCustomer {
    List<Customer> customer_list();
    List<CustomerType> customer_types();
    void addNewCustomer(Customer customer);
    void update (Customer customer , int id);
    void delete (int id);
    Customer selectById(int id);
    List<Customer> searchByName(String name);

}
