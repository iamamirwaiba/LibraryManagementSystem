package com.amirproject.librarymanagement.Validator;

import org.springframework.context.annotation.Configuration;

@Configuration
public class CredentialValidator {


    public boolean phoneNumberValidation(String phoneNumber) {

        String regex = "(0/91)?[7-9][0-9]{9}";
        if (!phoneNumber.matches(regex)) {
            throw new IllegalStateException("Phone Number invalid");
        }
        return phoneNumber.matches(regex);

    }

    public Boolean emailValidatio(String email) {
        String regex = "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?";
        if (!email.matches(regex)) {
            throw new IllegalStateException("Invalid Email");

        }
        return email.matches(regex);
    }
}
