package service.Impl;

import bean.Service;
import repository.IRepositoryService;
import repository.Impl.RepositoryServiceImpl;
import service.IService_Service;

import java.util.List;

public class ImpIService_Service implements IService_Service {
IRepositoryService service1= new RepositoryServiceImpl();
    @Override
    public List<Service> listService() {
        return service1.services();
    }

    @Override
    public void create(Service service) {
service1.addNewCustomer(service);
    }
}
