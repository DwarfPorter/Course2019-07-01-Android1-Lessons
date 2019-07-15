package ru.geekbrains.debug;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Integer arg1;
    Integer arg2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.equal);
        final EditText number1 = findViewById(R.id.number1);
        final EditText number2 = findViewById(R.id.number2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView equalText = findViewById(R.id.textView);
                try {
                    arg1 = Integer.valueOf(number1.getText().toString());
                    arg2 = Integer.valueOf(number2.getText().toString());
                    if (arg1.equals(arg2)){
                        equalText.setText("Равно!");
                    }
                    else{
                        equalText.setText("Не равно!");
                    }
                } catch (NumberFormatException e) {
                    equalText.setText("Введите число!");
                }
            }
        });
    }
}
