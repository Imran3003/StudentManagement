package com.ib.stm.service;

/**
 * UserService.java
 *
 * @author Mohamed Subaideen Imran A (mohamedsubaideenimran@nmsworks.co.in)
 * @module com.ib.stm.service
 * @created Dec 19, 2023
 */
import com.ib.stm.models.UserCredentials;
import com.ib.stm.repos.UserInfoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserInfoRepo userInfoRepo;

    public boolean isUserPasswordValid(UserCredentials userCredentials) {
        return userInfoRepo.existsByRegNoAndDobAndPassword(userCredentials.getUsername(), userCredentials.getDob(), userCredentials.getPassword());
    }

    public boolean isUserValid(UserCredentials userCredentials) {
        return userInfoRepo.existsByRegNoAndDob(userCredentials.getUsername(), userCredentials.getDob());
    }
}
