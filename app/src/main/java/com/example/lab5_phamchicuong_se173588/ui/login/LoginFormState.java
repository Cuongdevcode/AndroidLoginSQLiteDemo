package com.example.lab5_phamchicuong_se173588.ui.login;

public class LoginFormState {
    private Integer usernameError;
    private Integer passwordError;
    public boolean isDataValid;

    LoginFormState(Integer usernameError, Integer passwordError)
    {
        this.usernameError=usernameError;
        this.passwordError=passwordError;
        this.isDataValid=false;
    }

    LoginFormState(boolean isDataValid)
    {
        this.usernameError=null;
        this.passwordError=null;
        this.isDataValid=isDataValid;
    }

    public Integer getUsernameError()
    {
        return usernameError;
    }
    public Integer getPasswordError()
    {
        return passwordError;
    }
    public boolean isDataValid()
    {
        return isDataValid;
    }
}
