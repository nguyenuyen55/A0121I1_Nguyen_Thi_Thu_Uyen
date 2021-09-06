package bean;

import java.util.Date;

public class Employee {
    private int employeeId;
    private  String employeeName;
    private Date dateBirthday;
    private String idCard;
    private double salary;
    private String phone;
    private String email;
    private String address;
    private int postionId;
    private int educationId;
    private int divisionId;
    private String username;

    public Employee(String employeeName, Date dateBirthday, String idCard, double salary, String phone, String email, String address, int postionId, int educationId, int divisionId) {
        this.employeeName = employeeName;
        this.dateBirthday = dateBirthday;
        this.idCard = idCard;
        this.salary = salary;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.postionId = postionId;
        this.educationId = educationId;
        this.divisionId = divisionId;
    }

    public Employee(int employeeId, String employeeName, Date dateBirthday, String idCard, double salary, String phone, String email, String address, int postionId, int educationId, int divisionId, String username) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.dateBirthday = dateBirthday;
        this.idCard = idCard;
        this.salary = salary;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.postionId = postionId;
        this.educationId = educationId;
        this.divisionId = divisionId;
        this.username = username;
    }

    public Employee(String employeeName, Date dateBirthday, String idCard, double salary, String phone, String email, String address, int postionId, int educationId, int divisionId, String username) {
        this.employeeName = employeeName;
        this.dateBirthday = dateBirthday;
        this.idCard = idCard;
        this.salary = salary;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.postionId = postionId;
        this.educationId = educationId;
        this.divisionId = divisionId;
        this.username = username;
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

    public Date getDateBirthday() {
        return dateBirthday;
    }

    public void setDateBirthday(Date dateBirthday) {
        this.dateBirthday = dateBirthday;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
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

    public int getPostionId() {
        return postionId;
    }

    public void setPostionId(int postionId) {
        this.postionId = postionId;
    }

    public int getEducationId() {
        return educationId;
    }

    public void setEducationId(int educationId) {
        this.educationId = educationId;
    }

    public int getDivisionId() {
        return divisionId;
    }

    public void setDivisionId(int divisionId) {
        this.divisionId = divisionId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
