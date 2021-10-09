package com.codegym.casestudy.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class AttachService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int attachServiceId;
    private String attchServiceName;
    private double cost;
    private String unit;
    private String status;
    @OneToMany(mappedBy = "attachService")
    private Set<ContractDetail> details;

    public AttachService() {
    }

    public int getAttachServiceId() {
        return attachServiceId;
    }

    public void setAttachServiceId(int attachServiceId) {
        this.attachServiceId = attachServiceId;
    }

    public String getAttchServiceName() {
        return attchServiceName;
    }

    public void setAttchServiceName(String attchServiceName) {
        this.attchServiceName = attchServiceName;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Set<ContractDetail> getDetails() {
        return details;
    }

    public void setDetails(Set<ContractDetail> details) {
        this.details = details;
    }
}
