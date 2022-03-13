package com.example.madmeditation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.example.madmeditation.common.BasicActivity;
import com.example.madmeditation.databinding.ActivityMainBinding;
import com.example.madmeditation.databinding.FragmentLoginBinding;
import com.example.madmeditation.ui.login.LoginFragment;

public class LoginActivity extends BasicActivity {
    FragmentLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = FragmentLoginBinding.inflate(LayoutInflater.from(this));
        setContentView(binding.getRoot());
        binding.login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validateAll();
            }
        });
    }

    public static boolean validateEmail(String email) {
        //final String pattern = Patterns.EMAIL_ADDRESS.pattern();

        //Перед тем, как отправить данные на сервер для получения токена, необходимо проверить
        //заполненность полей, а также наличие символа @ в поле для Email.
        if (email.isEmpty())
            return false;
        else if (!email.matches("^[A-Za-z.]+?\\@[A-Za-z]+\\.[A-Za-z]{2,3}$")) {
            return false;
        }
        return true;
    }

    public static boolean validatePassword(String password) {
        if (password.isEmpty())
            return false;
        /*else if(!password.matches("\\[A-z]{8,}")){
            return false;
        }*/
        return true;
    }

    void validateAll() {
        if (!validateEmail(binding.email.getText().toString()) || !validatePassword(binding.password.getText().toString())) {
            onCreateDialog("Ошибка", "введены неверные данные логина и пароля").show();
        } else
            dialogBuilder().setTitle("Авторизация").setMessage("успешно").setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    startActivity(new Intent(LoginActivity.this, MainActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK));
                }
            }).show();
    }
}