package repository;

import bean.Contract;
import bean.ContractDetail;

import java.util.List;

public interface IRepositoryContractDetail {
    List<ContractDetail> contractDetails();
    void createContract(ContractDetail contractDetail);

}
