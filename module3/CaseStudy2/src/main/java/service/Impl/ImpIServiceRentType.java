package service.Impl;

import bean.RentType;
import repository.IRepositoryRentType;
import repository.Impl.RepositoryRentTypeImpl;
import repository.Impl.RespositoryServiceTypeImpl;
import service.IServiceRentType;

import java.util.List;

public class ImpIServiceRentType implements IServiceRentType {
    IRepositoryRentType serviceType = new RepositoryRentTypeImpl();
    @Override
    public List<RentType> rentTypes() {
        return serviceType.rentypes();
    }
}
