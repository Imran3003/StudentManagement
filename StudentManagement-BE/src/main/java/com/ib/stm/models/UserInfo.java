package com.ib.stm.models;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * UserInfo.java
 *
 * @author Mohamed Subaideen Imran A (mohamedsubaideenimran@nmsworks.co.in)
 * @module com.ib.stm.models
 * @created Dec 19, 2023
 */
@Entity
public class UserInfo
{
    @Id
    private int id;
    private String regNo;
    private long dob;
    private String password;

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public long getDob() {
        return dob;
    }

    public void setDob(long dob) {
        this.dob = dob;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int  getId() {
        return id;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", regNo='" + regNo + '\'' +
                ", dob=" + dob +
                ", password='" + password + '\'' +
                '}';
    }
}
