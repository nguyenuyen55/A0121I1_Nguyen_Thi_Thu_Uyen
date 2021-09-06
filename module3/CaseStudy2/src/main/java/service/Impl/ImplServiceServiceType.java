package service.Impl;

import bean.ServiceType;
import repository.IRepositoryService;
import repository.IRepositoryServiceType;
import repository.Impl.RespositoryServiceTypeImpl;
import service.IServiceServiceType;

import java.util.List;

public class ImplServiceServiceType implements IServiceServiceType {
    IRepositoryServiceType serviceType= new RespositoryServiceTypeImpl();
    @Override
    public List<ServiceType> servicetype() {
        return serviceType.serviceTypes();
    }
}
