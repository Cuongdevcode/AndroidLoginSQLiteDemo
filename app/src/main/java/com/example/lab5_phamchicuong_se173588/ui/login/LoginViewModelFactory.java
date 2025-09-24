package com.example.lab5_phamchicuong_se173588.ui.login;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.lab5_phamchicuong_se173588.data.LoginDataSource;
import com.example.lab5_phamchicuong_se173588.data.LoginRepository;

public class LoginViewModelFactory implements ViewModelProvider.Factory {

    @NonNull
    @Override
    @SuppressWarnings("unchecked")
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass)
    {
        if(modelClass.isAssignableFrom(LoginViewModel.class)){
            return (T) new LoginViewModel(LoginRepository.getInstance(new LoginDataSource()));

        }else {
            throw new IllegalArgumentException("UnKnown ViewModel class");

        }
    }
}
