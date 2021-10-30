package com.codegym.casestudy.entity;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
//import javax.validation.Validator;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

@Entity
public class Employee implements Validator {
    @Id
//    @NotBlank(message = "Không được để trống")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employeeId;
    @NotBlank(message = "Không được để trống")
    private String employeeName;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
//    @NotEmpty(message = "Không được để trống")
    private Date employeeBirthday;
    @NotBlank(message = "Không được để trống")
    private String employeeIdCard;
    @NotNull(message = "Không được để trống")
    private Double employeeSalary;
    @NotBlank(message = "Không được để trống")
    @Pattern(regexp = "^(091[0-9]{7})?$|^(090[0-9]{7})$",message = "Không đúng định dạng. 090xxxxxxx hoặc 091xxxxxxx")
    private String employeePhone;
    @NotBlank(message = "Không được để trống")
    private String employeeEmail;
    @NotBlank(message = "Không được để trống")
    private String employeeAddress;
    @ManyToOne(targetEntity = Position.class)
    @JoinColumn(name = "positionId",referencedColumnName = "position_id")
    private Position positions;
    @ManyToOne(targetEntity = Education.class)
    @JoinColumn(name = "eductionId",referencedColumnName = "education_degree_id")
    private Education educations;
    @ManyToOne(targetEntity = Division.class)
    @JoinColumn(name = "divisionId",referencedColumnName = "division_id")
    private Division divisions;
    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "username",referencedColumnName = "username")
    private String username;

    public Employee() {
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Date getEmployeeBirthday() {
        return employeeBirthday;
    }

    public void setEmployeeBirthday(Date employeeBirthday) {
        this.employeeBirthday = employeeBirthday;
    }

    public String getEmployeeIdCard() {
        return employeeIdCard;
    }

    public void setEmployeeIdCard(String employeeIdCard) {
        this.employeeIdCard = employeeIdCard;
    }

    public Double getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(Double employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public String getEmployeePhone() {
        return employeePhone;
    }

    public void setEmployeePhone(String employeePhone) {
        this.employeePhone = employeePhone;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public Position getPositions() {
        return positions;
    }

    public void setPositions(Position positions) {
        this.positions = positions;
    }

    public Education getEducations() {
        return educations;
    }

    public void setEducations(Education educations) {
        this.educations = educations;
    }

    public Division getDivisions() {
        return divisions;
    }

    public void setDivisions(Division divisions) {
        this.divisions = divisions;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Employee.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Employee employee = (Employee) target;
        LocalDate today = LocalDate.now();
        Date birthday= employee.getEmployeeBirthday();
        if(birthday==null){
            errors.rejectValue("employeeBirthday","dateNotNull");
        }else {
             LocalDate birthdayLocal = birthday.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
             if(Period.between(birthdayLocal,today).getYears()<18){
                 errors.rejectValue("employeeBirthday", "dateCus");

             }
        }

//        chung minh nhan dan
        String idCard = employee.getEmployeeIdCard();
        if(idCard !=""&&(idCard.length()<8 || idCard.length()>12)){
            errors.rejectValue("employeeIdCard",null,"Không đúng định dạng. Cmnd phải 8 hay 12 số");
        }

    }
}
