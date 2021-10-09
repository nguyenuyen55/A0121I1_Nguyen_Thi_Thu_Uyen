package com.codegym.casestudy.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class Customer {
    @Id
    private String customerId;
    private String customerName;
    @DateTimeFormat(iso= DateTimeFormat.ISO.DATE)
    @Temporal(TemporalType.DATE)
    private Date birthday;
    private int gender;
    private String idCard;
    private String phone;
    private String email;
    private String address;

    @ManyToOne(targetEntity = CustomerType.class)
    @JoinColumn(name = "customerTypeId" ,referencedColumnName = "customerTypeId")
    private CustomerType customertypes;

    @OneToMany(mappedBy = "customer")
    private Set<Contract> contract;

    public Customer() {
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }



    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public CustomerType getCustomertypes() {
        return customertypes;
    }

    public void setCustomertypes(CustomerType customertypes) {
        this.customertypes = customertypes;
    }

    public Set<Contract> getContract() {
        return contract;
    }

    public void setContract(Set<Contract> contract) {
        this.contract = contract;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
