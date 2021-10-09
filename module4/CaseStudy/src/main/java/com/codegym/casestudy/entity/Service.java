package com.codegym.casestudy.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int serviceId;
    private String nameService;
    private int serviceArea;
    private double serviceCost;
    private int maxPeople;

    private String standardRoom;
    private String descriptionOther;
    private double pool_area;
    private int numberFloors;
    @ManyToOne(targetEntity = ServiceType.class)
    @JoinColumn(name = "serviceTypeId",referencedColumnName = "serviceTypeId")
    private ServiceType serviceTypes;
    @ManyToOne(targetEntity = RentType.class)
    @JoinColumn(name = "rentTypeId",referencedColumnName = "rentTypeId")
    private RentType rentType;
    @OneToMany(mappedBy = "service")
    private Set<Contract> contracts;

    public Service() {
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public String getNameService() {
        return nameService;
    }

    public void setNameService(String nameService) {
        this.nameService = nameService;
    }

    public int getServiceArea() {
        return serviceArea;
    }

    public void setServiceArea(int serviceArea) {
        this.serviceArea = serviceArea;
    }

    public double getServiceCost() {
        return serviceCost;
    }

    public void setServiceCost(double serviceCost) {
        this.serviceCost = serviceCost;
    }

    public int getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(int maxPeople) {
        this.maxPeople = maxPeople;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescriptionOther() {
        return descriptionOther;
    }

    public void setDescriptionOther(String descriptionOther) {
        this.descriptionOther = descriptionOther;
    }

    public double getPool_area() {
        return pool_area;
    }

    public void setPool_area(double pool_area) {
        this.pool_area = pool_area;
    }

    public int getNumberFloors() {
        return numberFloors;
    }

    public void setNumberFloors(int numberFloors) {
        this.numberFloors = numberFloors;
    }

    public ServiceType getServiceTypes() {
        return serviceTypes;
    }

    public void setServiceTypes(ServiceType serviceTypes) {
        this.serviceTypes = serviceTypes;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    public Set<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(Set<Contract> contracts) {
        this.contracts = contracts;
    }
}
