package service;

import bean.Contract;

import java.util.List;

public interface IServiceContract {
    List<Contract> contracts();
    void createContract(Contract contract);
}
