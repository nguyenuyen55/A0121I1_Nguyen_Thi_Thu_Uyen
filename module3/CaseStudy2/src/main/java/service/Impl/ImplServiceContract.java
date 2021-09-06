package service.Impl;

import bean.Contract;
import repository.IRepositoryContract;
import repository.Impl.RepositoryContractImpl;
import service.IServiceContract;

import java.util.List;

public class ImplServiceContract implements IServiceContract {
    IRepositoryContract repositoryContract = new RepositoryContractImpl();

    @Override
    public List<Contract> contracts() {
        return repositoryContract.contracts();
    }

    @Override
    public void createContract(Contract contract) {
        repositoryContract.createContract(contract);
    }
}
