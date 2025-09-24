package com.example.lab5_phamchicuong_se173588.data;

import com.example.lab5_phamchicuong_se173588.data.model.LoggedInUser;

public class LoginRepository {

    private static volatile LoginRepository instance;
    private LoginDataSource dataSource;
    private LoggedInUser user =null;


    //private constructor: singleton access
    private LoginRepository(LoginDataSource dataSource){this.dataSource= dataSource;}

    public static LoginRepository getInstance(LoginDataSource loginDataSource)
    {
        if(instance == null)
        {
            instance = new LoginRepository(loginDataSource);
        }
        return instance;
    }

    public  boolean isLoggedIn(){ return user !=null;}

    public  void logout(){
        user = null;
        dataSource.logout();
    }

    private  void setLoggedInUser(LoggedInUser user)
    {
        this.user= user;

    }
    public  Result<LoggedInUser> login(String username, String password){
        //hadle login
        Result<LoggedInUser> result =  dataSource.login(username, password);
        if(result instanceof  Result.Success){
            setLoggedInUser(((Result.Success<LoggedInUser>)result).getData());
        }
        return result;

    }
}
