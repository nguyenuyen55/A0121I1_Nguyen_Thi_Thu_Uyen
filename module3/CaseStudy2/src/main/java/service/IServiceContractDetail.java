package service;

import bean.ContractDetail;

import java.util.List;

public interface IServiceContractDetail {
    List<ContractDetail> contractDetails();
    void createContract(ContractDetail contractDetail);
}
