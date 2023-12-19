package com.ib.stm.controller;

import com.ib.stm.models.LoginCredential;
import com.ib.stm.models.UserCredentials;
import com.ib.stm.parser.PropertiesParser;
import com.ib.stm.parser.PropertiesParserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;
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

    String beBaseURL;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    LoginCredential loginCredential;

    private void init()
    {
        PropertiesParser propertiesParser = PropertiesParserUtils.getPropertiesParserInstance();

        beBaseURL = propertiesParser.getBeBaseURL();
    }

    @RequestMapping("/")
    public ModelAndView showLoginPage()
    {
        init();
        return new ModelAndView("loginPage.html");
    }

    @RequestMapping("/login/FE")
    private ModelAndView login(@RequestParam String regNo, @RequestParam  @DateTimeFormat(pattern = "yyyy-MM-dd") Date dob , Model model)
    {
        long date = dob.getTime();

        //993859200
        System.out.println("date = " + date);

        UserCredentials userCredentials = new UserCredentials(regNo, date);

        System.out.println("beBaseURL = " + beBaseURL);

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

    @RequestMapping("/validatePassword")

    private ModelAndView validatePass(@RequestParam String password,Model model)
    {
        UserCredentials userCredentials = new UserCredentials(loginCredential.getUsername(), loginCredential.getDob());
        userCredentials.setPassword(password);

        System.out.println("userCredentials = " + userCredentials);

        Boolean status = restTemplate.postForObject(beBaseURL + "/BE/validatePassword", userCredentials, Boolean.class);

        if (status)
        {
            model.addAttribute("message","succefully Login");
            return new ModelAndView("passwordPage.html");
        }

        model.addAttribute("message","invalid password");
        return new ModelAndView("passwordPage.html");

    }

}
