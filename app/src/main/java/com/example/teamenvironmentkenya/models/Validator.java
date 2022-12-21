package com.example.teamenvironmentkenya.models;

import android.util.Patterns;

import com.google.android.material.textfield.TextInputLayout;

public class Validator {

    public static boolean validateInputText(TextInputLayout inputLayout){
        String name = inputLayout.getEditText().getText().toString().trim();

        if(name.isEmpty()){
            inputLayout.setError("This field is required");
            inputLayout.setErrorEnabled(true);
            return false;
        }else{
            inputLayout.setError(null);
            inputLayout.setErrorEnabled(false);
            return true;
        }

    }

    public static boolean validateEmail(TextInputLayout inputLayout){
        String name = inputLayout.getEditText().getText().toString().trim();
        if(name.isEmpty()){
            inputLayout.setError("Please enter your email");
            inputLayout.setErrorEnabled(true);
            return false;
        }else if(!Patterns.EMAIL_ADDRESS.matcher(name).matches()){
            inputLayout.setError("Please enter a valid email address");
            inputLayout.setErrorEnabled(true);
            return false;
        }else{
            inputLayout.setError(null);
            inputLayout.setErrorEnabled(false);
            return true;
        }
    }

    public static boolean validPassword(TextInputLayout inputLayout, TextInputLayout inputLayout1){
        String passwordOne = inputLayout.getEditText().getText().toString().trim();
        String passwordTwo = inputLayout1.getEditText().getText().toString().trim();

        if (passwordTwo.isEmpty()){
            inputLayout.setError("Please confirm your password");
            inputLayout1.setErrorEnabled(true);
            return false;
        }else if(!passwordOne.equals(passwordTwo)){
            inputLayout.setError("Passwords must match ");
            inputLayout.setErrorEnabled(true);
            return false;
        }else{
            inputLayout.setError(null);
            inputLayout1.setError(null);
            inputLayout.setErrorEnabled(false);
            inputLayout1.setErrorEnabled(false);
            return true;
        }

    }
}
