package com.example.realmdatabaseproject;

import io.realm.RealmObject;

public class HelperModal extends RealmObject
{
    String inputEmail,inputPassword;

    public String getInputEmail() {
        return inputEmail;
    }

    public void setInputEmail(String inputEmail) {
        this.inputEmail = inputEmail;
    }

    public String getInputPassword() {
        return inputPassword;
    }

    public void setInputPassword(String inputPassword) {
        this.inputPassword = inputPassword;
    }
}
