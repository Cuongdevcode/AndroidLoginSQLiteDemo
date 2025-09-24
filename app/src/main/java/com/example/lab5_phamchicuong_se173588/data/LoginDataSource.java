package com.example.lab5_phamchicuong_se173588.data;

import com.example.lab5_phamchicuong_se173588.data.model.LoggedInUser;

import com.example.lab5_phamchicuong_se173588.data.Result;
public class LoginDataSource {

    public Result<LoggedInUser> login(String username, String password) {
        try {
            // TODO: handle loggedInUser authentication
            LoggedInUser fakeUser = new LoggedInUser(
                    java.util.UUID.randomUUID().toString(),
                    "CuongPC FPT");
            return new Result.Success<>(fakeUser);
        } catch (Exception e) {
            return new Result.Error(new Exception("Error logging in", e));
        }
    }

    public void logout() {
        // TODO: revoke authentication
    }
}
