package com.example.shanmetta_tm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class dataUser {

    String fullnameuser;
    String emailUser;
    String passUser;
    String phoneUser;

    public dataUser(String fullnameuser, String emailUser, String passUser, String phoneUser) {
        this.fullnameuser = fullnameuser;
        this.emailUser = emailUser;
        this.passUser = passUser;
        this.phoneUser = phoneUser;


    }

    public String getEmailUser() {
        return emailUser;
    }

    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;
    }

    public String getPassUser() {
        return passUser;
    }

    public void setPassUser(String passUser) {
        this.passUser = passUser;
    }


}
