package com.codegym.casestudy.entity;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.Set;

@Entity
public class Contract implements Validator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int contractId;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;
    //tien cọc
    @NotNull(message = "Không được để trống")
    private double deposit;
    @NotNull(message = "Không được để trống")
    private double totalMoney;
    @ManyToOne(targetEntity = Customer.class)
    @JoinColumn(name = "customerId",referencedColumnName = "customerId")
    private Customer customer;
    @ManyToOne(targetEntity = Employee.class)
    @JoinColumn(name = "employeeId",referencedColumnName = "employeeId")
    private Employee employee;
    @ManyToOne(targetEntity = Service.class)
    @JoinColumn(name = "serviceId",referencedColumnName = "serviceId")
    private Service service;
    @OneToMany(mappedBy = "contract",cascade = CascadeType.ALL)
    private Set<ContractDetail> contractDetails;

    public Contract() {
    }

    public int getContractId() {
        return contractId;
    }

    public void setContractId(int contractId) {
        this.contractId = contractId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Set<ContractDetail> getContractDetails() {
        return contractDetails;
    }

    public void setContractDetails(Set<ContractDetail> contractDetails) {
        this.contractDetails = contractDetails;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Contract.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
    Contract contract =(Contract) target;
        Date start= contract.getStartDate();
        Date end= contract.getEndDate();
        LocalDate today = LocalDate.now();
        if((start.getYear()==end.getYear()&&(end.getMonth()-start.getMonth()>3))){
            errors.rejectValue("endDate",null,"thời gian ket thuc phai nhỏ hơn 3 tháng");
        }
        if(contract.getDeposit()<=0){
            errors.rejectValue("deposit",null,"phải là số nguyên dương");
        }
        if(contract.getTotalMoney()<=0){
            errors.rejectValue("totalMoney",null,"phải là số nguyên dương");
        }

    }
}
