package com.ib.stm.controller;

import com.ib.stm.models.UserCredentials;
import com.ib.stm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * BeController.java
 *
 * @author Mohamed Subaideen Imran A (mohamedsubaideenimran@nmsworks.co.in)
 * @module com.ib.stm.controller
 * @created Dec 18, 2023
 */
@RestController
public class BeController {

    @Autowired
    UserService userService;

    @RequestMapping("login/validate")
    public Boolean validateUser(@RequestBody UserCredentials userCredentials)
    {
        System.out.println("userCredentials = " + userCredentials);

        return userService.isUserValid(userCredentials);
    }

    @RequestMapping("BE/validatePassword")
    public Boolean validatePassword(@RequestBody UserCredentials userCredentials)
    {
        System.out.println("userCredentials = " + userCredentials);

        return userService.isUserPasswordValid(userCredentials);
    }
}
