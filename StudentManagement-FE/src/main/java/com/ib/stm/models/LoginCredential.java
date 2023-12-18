package com.ib.stm.models;

import org.springframework.stereotype.Service;

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
   public static  String regNo;
   public static long dob;

   public static boolean validate = false;

   public void setLoginCredential(UserCredentials userCredentials)
   {
       if (userCredentials == null)
           return;
       regNo = userCredentials.getUsername();
       dob = userCredentials.getDob();
   }

   public void validateUser(Boolean status)
   {
       validate = status;

       if (!validate)
       {
           regNo = null;
           dob = 0;
       }
   }

   public String getUsername()
   {
       return regNo;
   }

    public Long getDob()
    {
        return dob;
    }
}
