package com.lyl.bean;

import java.util.Date;

public class Teacher {
    private Integer id;

    private String teachername;

    private String className;

    private String address;

    private Date birthDate;

    public Teacher(Integer id, String teachername, String className, String address, Date birthDate) {
        this.id = id;
        this.teachername = teachername;
        this.className = className;
        this.address = address;
        this.birthDate = birthDate;
    }

    public Teacher() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTeachername() {
        return teachername;
    }

    public void setTeachername(String teachername) {
        this.teachername = teachername == null ? null : teachername.trim();
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className == null ? null : className.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", teachername='" + teachername + '\'' +
                ", className='" + className + '\'' +
                ", address='" + address + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}