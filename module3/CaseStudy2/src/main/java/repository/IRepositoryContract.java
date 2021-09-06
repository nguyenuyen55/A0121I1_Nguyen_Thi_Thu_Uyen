package repository;

import bean.Contract;

import java.util.List;

public interface IRepositoryContract {
    List<Contract> contracts();
    void createContract(Contract contract);
 }
