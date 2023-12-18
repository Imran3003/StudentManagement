package com.ib.stm.controller;

import com.ib.stm.models.LoginCredential;
import com.ib.stm.models.UserCredentials;
import com.ib.stm.parser.PropertiesParser;
import com.ib.stm.parser.PropertiesParserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

/**
 * FeController.java
 *
 * @author Mohamed Subaideen Imran A (mohamedsubaideenimran@nmsworks.co.in)
 * @module com.ib.stm.controller
 * @created Dec 18, 2023
 */
@RestController
public class FeController
{
    @Autowired
    RestTemplate restTemplate;

    @Autowired
    LoginCredential loginCredential;

    @RequestMapping("/")
    public ModelAndView showLoginPage()
    {
        return new ModelAndView("loginPage.html");
    }

    @RequestMapping("/login/FE")
    private ModelAndView login(@RequestParam String regNo, @RequestParam  @DateTimeFormat(pattern = "yyyy-MM-dd") Date dob , Model model)
    {
        long date = dob.getTime();

        UserCredentials userCredentials = new UserCredentials(regNo, date);

        PropertiesParser propertiesParser = PropertiesParserUtils.getPropertiesParserInstance();

        String beBaseURL = propertiesParser.getBeBaseURL();

        Boolean status = restTemplate.postForObject(beBaseURL + "/login/validate", userCredentials, Boolean.class);

        System.out.println("status = " + status);

        if (status)
        {
            loginCredential.setLoginCredential(userCredentials);
            return new ModelAndView("passwordPage.html");
        }
        model.addAttribute("message","No user found");
        return new ModelAndView("loginPage.html");

    }

}
