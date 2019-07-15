package ru.geekbrains.secondactivity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements Constants {

    private static final int REQUEST_CODE_ACTIVITY2 = 3;

    private EditText number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText param = findViewById(R.id.editText);
        number = findViewById(R.id.editNumber);

        final Button start2Activity = findViewById(R.id.button);
        start2Activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                //String text = param.getText().toString();
                Parcel parcel = new Parcel();
                parcel.text = param.getText().toString();
                parcel.number = Integer.parseInt(number.getText().toString());
                intent.putExtra(TEXT, parcel);
                startActivityForResult(intent, REQUEST_CODE_ACTIVITY2);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode != REQUEST_CODE_ACTIVITY2){
            super.onActivityResult(requestCode, resultCode, data);
            return;
        }
        if(resultCode == RESULT_OK){
            number.setText(data.getStringExtra(NUMBER));
        }
    }
}
