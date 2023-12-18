package com.ib.stm.models;

import java.util.Date;

/**
 * UserCredentials.java
 *
 * @author Mohamed Subaideen Imran A (mohamedsubaideenimran@nmsworks.co.in)
 * @module com.ib.stm.models
 * @created Dec 18, 2023
 */
public class UserCredentials
{
    private String username;
    public Long dob;
    public UserCredentials(String username, Long dob) {
        this.username = username;
        this.dob = dob;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getDob() {
        return dob;
    }

    public void setDob(Long dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "UserCredentials{" +
                "username='" + username + '\'' +
                ", dob=" + dob +
                '}';
    }
}
