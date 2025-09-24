package com.example.lab5_phamchicuong_se173588.ui.login;

import com.example.lab5_phamchicuong_se173588.data.model.LoggedInUser;

public class LoginResult {
    private LoggedInUser success;
    private Integer error;

    LoginResult(Integer error)
    {
        this.error= error;

    }
    LoginResult(LoggedInUser success)
    {
        this.success=success;
    }

    public LoggedInUser getSuccess()
    {
        return success;
    }
    public Integer getError()
    {
        return error;
    }
}
