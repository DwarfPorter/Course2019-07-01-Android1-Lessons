package ru.geekbrains.pressbutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Нажата кнопка", Toast.LENGTH_SHORT).show();
            }
        });
        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(listenerButton2);

        Button button3 = findViewById(R.id.button3);
        Button button4 = findViewById(R.id.button4);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.button3){
            Toast.makeText(MainActivity.this, "Нажата кнопка 3", Toast.LENGTH_SHORT).show();
            return;
        }
        if (view.getId() == R.id.button4){
            Toast.makeText(MainActivity.this, "Нажата кнопка 4", Toast.LENGTH_SHORT).show();
            return;
        }
    }

    private View.OnClickListener listenerButton2 = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Toast.makeText(MainActivity.this, "Нажата кнопка 2", Toast.LENGTH_SHORT).show();
        }
    };
}
