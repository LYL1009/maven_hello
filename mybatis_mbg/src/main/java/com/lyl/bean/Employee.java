package com.lyl.bean;

public class Employee {
    private Integer id;

    private String empname;

    private Integer gender;

    private String email;

    private String loginAccount;

    public Employee(Integer id, String empname, Integer gender, String email, String loginAccount) {
        this.id = id;
        this.empname = empname;
        this.gender = gender;
        this.email = email;
        this.loginAccount = loginAccount;
    }

    public Employee() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmpname() {
        return empname;
    }

    public void setEmpname(String empname) {
        this.empname = empname == null ? null : empname.trim();
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getLoginAccount() {
        return loginAccount;
    }

    public void setLoginAccount(String loginAccount) {
        this.loginAccount = loginAccount == null ? null : loginAccount.trim();
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", empname='" + empname + '\'' +
                ", gender=" + gender +
                ", email='" + email + '\'' +
                ", loginAccount='" + loginAccount + '\'' +
                '}';
    }
}