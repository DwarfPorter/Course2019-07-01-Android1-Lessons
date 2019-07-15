package ru.geekbrains.secondactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity implements Constants{

    private EditText number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView param = findViewById(R.id.textView3);
        number = findViewById(R.id.editNumber2Activity);

        Parcel parcel = (Parcel) getIntent().getExtras().getSerializable(TEXT);

        param.setText(parcel.text);
        number.setText(((Integer) parcel.number).toString());

        Button ret = findViewById(R.id.buttonReturnTo1);
        ret.setOnClickListener(clickListener);
    }

    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intentResult = new Intent();
            intentResult.putExtra(NUMBER, number.getText().toString());
            setResult(RESULT_OK, intentResult);
            finish();
        }
    };
}
