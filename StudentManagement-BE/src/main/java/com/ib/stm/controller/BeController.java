package com.ib.stm.controller;

import com.ib.stm.models.UserCredentials;
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

    @RequestMapping("login/validate")
    public Boolean validateUser(@RequestBody UserCredentials userCredentials)
    {
        System.out.println("userCredentials = " + userCredentials);
        return false;

    }
}
