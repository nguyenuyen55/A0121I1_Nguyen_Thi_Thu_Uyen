package com.codegym.casestudy.entity;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.Set;

@Entity
public class Customer implements Validator {
    @Id
    private String customerId;
    private String customerName;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
//    @Temporal(TemporalType.DATE)
    private Date birthday;
    private int gender;
    private String idCard;
    private String phone;
    private String email;
    private String address;

    @ManyToOne(targetEntity = CustomerType.class)
    @JoinColumn(name = "customerTypeId", referencedColumnName = "customerTypeId",nullable = false)
    private CustomerType customertypes;

    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
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

    @Override
    public boolean supports(Class<?> clazz) {
        return Customer.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Customer customer = (Customer) target;
        LocalDate today = LocalDate.now();
        Date birthday = customer.getBirthday();
        if (birthday == null) {
            errors.rejectValue("birthday", "dateNotNull", "tuổi phải lớn hơn 18");
        } else {
            LocalDate birthLocal = birthday.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            if (Period.between(birthLocal, today).getYears() < 18) {
                errors.rejectValue("birthday", "dateCus", "tuổi phải lớn hơn 18");
            }
        }

    }
}
