package repository;

import bean.Customer;
import bean.CustomerType;
import bean.Service;

import java.util.List;

public interface IRepositoryService {
    List<Service> services();
    void addNewCustomer(Service service);

}
