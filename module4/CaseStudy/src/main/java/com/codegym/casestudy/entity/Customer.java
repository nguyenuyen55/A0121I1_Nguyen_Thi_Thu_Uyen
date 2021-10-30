package com.codegym.casestudy.entity;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.Set;

@Entity
public class Customer implements Validator {
    @Id
    @Pattern(regexp="^KH-[0-9]{4}$",message="không đúng địng dạng: KH-XXXX ")
    private String customerId;
    @NotBlank(message = "Không được để trống")
    private String customerName;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
//    @Column(name = "birthday", columnDefinition = "date")
//    @Temporal(TemporalType.DATE)
    private Date birthday;
    private int gender;
    @NotBlank(message = "Không được để trống")
//    ^[0-9]{9}?$|^[0-9]{12}$
//    @Pattern(regexp = "^[0-9]{9}?$|^[0-9]{12}$",message = "Không đúng định dạng. Cmnd phải 8 hay 12 số")
    private String idCard;
    @NotBlank(message = "Không được để trống")
    //(091[0-9]{7})?$|^(090[0-9]{7})$
    @Pattern(regexp = "^(091[0-9]{7})?$|^(090[0-9]{7})$",message = "Không đúng định dạng. 090xxxxxxx hoặc 091xxxxxxx")
    private String phone;
    @NotBlank(message = "Không được để trống")
    private String email;
    @NotBlank(message = "Không được để trống")
    private String address;
    @ManyToOne(targetEntity = CustomerType.class)
    @JoinColumn(name = "customerTypeId", referencedColumnName = "customerTypeId",nullable = false)
    @NotNull(message = "Vui lòng chọn loại khách hàng")
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
        //ngay sinh
        LocalDate today = LocalDate.now();
        Date birthday = customer.getBirthday();
        if (birthday == null) {
            errors.rejectValue("birthday", "dateNotNull");
        } else {
            LocalDate birthLocal = birthday.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            if (Period.between(birthLocal, today).getYears() < 18) {
                errors.rejectValue("birthday", "dateCus", "tuổi phải lớn hơn 18");
            }
        }
//        chung minh nhan dan
        String idCard = customer.getIdCard();
        if(idCard !=""&&(idCard.length()<8 || idCard.length()>12)){

            errors.rejectValue("idCard",null,"Không đúng định dạng. Cmnd phải 8 hay 12 số");
        }

    }
}
