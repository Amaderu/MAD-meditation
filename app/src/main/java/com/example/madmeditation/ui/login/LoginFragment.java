package com.example.madmeditation.ui.login;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.PatternMatcher;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.madmeditation.R;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginFragment extends Fragment {

    private LoginViewModel mViewModel;

    public static LoginFragment newInstance() {
        return new LoginFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    public static boolean validateEmail(String email){
        //final String pattern = Patterns.EMAIL_ADDRESS.pattern();

        //Перед тем, как отправить данные на сервер для получения токена, необходимо проверить
        //заполненность полей, а также наличие символа @ в поле для Email.
        if(email.isEmpty())
            return false;
        else if(!email.matches("^[A-Za-z.]+?\\@[A-Za-z]+\\.[A-Za-z]{2,3}$")){
            return false;
        }
        return true;
    }
    public static boolean validatePassword(String password){
        if(password.isEmpty())
            return false;
        /*else if(!password.matches("\\[A-z]{8,}")){
            return false;
        }*/
        return true;
    }
}