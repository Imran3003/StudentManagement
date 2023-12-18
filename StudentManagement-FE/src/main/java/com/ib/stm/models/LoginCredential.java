package com.ib.stm.models;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * LoginCredential.java
 *
 * @author Mohamed Subaideen Imran A (mohamedsubaideenimran@nmsworks.co.in)
 * @module com.ib.stm.models
 * @created Dec 18, 2023
 */
@Service
public class LoginCredential
{
   public static  String username;
   public static long dob;

   public static boolean validate = false;

   public void setLoginCredential(UserCredentials userCredentials)
   {
       if (userCredentials == null)
           return;
       username = userCredentials.getUsername();
       dob = userCredentials.getDob();
   }

   public void validateUser(Boolean status)
   {
       validate = status;

       if (!validate)
       {
           username = null;
           dob = 0;
       }
   }

   public String getUsername()
   {
       return username;
   }

    public Long getDob()
    {
        return dob;
    }
}
