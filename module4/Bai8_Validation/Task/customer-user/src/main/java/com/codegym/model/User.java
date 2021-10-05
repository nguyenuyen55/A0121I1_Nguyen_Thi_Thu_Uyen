package com.codegym.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class User {
    private int id;
    @NotEmpty(message = "Không được để tên rỗng")
    @Size(min = 2,max = 30,message = "tên phải từ 2 đến 30 kí tự")
    private String name;
    @NotNull(message = "Không được để tuổi rỗng")
    @Min(value = 18,message = "Tuổi phải lớn hay bằng 18 tuổi")
    private int age;
    private String address;

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
