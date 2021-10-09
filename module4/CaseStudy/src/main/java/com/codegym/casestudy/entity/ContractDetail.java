package com.codegym.casestudy.entity;

import javax.persistence.*;

@Entity
public class ContractDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int detailId;

    @ManyToOne(targetEntity = Contract.class)
    @JoinColumn(name = "contractId",referencedColumnName = "contractId")
    private Contract contract;
    @ManyToOne(targetEntity = AttachService.class)
    @JoinColumn(name = "attachServiceId",referencedColumnName = "attachServiceId")
    private AttachService attachService;

    private int quantity;

    public ContractDetail() {
    }

    public int getDetailId() {
        return detailId;
    }

    public void setDetailId(int detailId) {
        this.detailId = detailId;
    }


    public AttachService getAttachService() {
        return attachService;
    }

    public void setAttachService(AttachService attachService) {
        this.attachService = attachService;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
