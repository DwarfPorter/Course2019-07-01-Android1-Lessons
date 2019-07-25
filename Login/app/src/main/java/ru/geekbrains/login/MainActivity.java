package ru.geekbrains.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText login;
    private TextInputEditText password;

    Pattern checkLogin = Pattern.compile("^[A-Z][a-z]+$");
    Pattern checkPassword = Pattern.compile("^.{6,}$");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login = findViewById(R.id.inputLoginName);
        password = findViewById(R.id.inputPassword);

        login.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (b) return;
                TextView tv = (TextView) view;

                validate(tv, checkLogin, "Это не имя");
            }
        });

        password.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (b) return;
                TextView tv = (TextView) view;

                validate(tv, checkPassword, "Пароль простой");
            }
        });
    }

    private void validate(TextView tv, Pattern check, String message){
        String value = tv.getText().toString();
        if (check.matcher(value).matches()){
            hideError(tv);
        }
        else{
            showError(tv, message);
        }
    }

    private void showError(TextView tv, String message) {
        tv.setError(message);
    }

    private void hideError(TextView tv) {
        tv.setError(null);
    }


}
