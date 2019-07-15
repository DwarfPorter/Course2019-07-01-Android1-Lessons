package ru.geekbrains.sendsms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText text = findViewById(R.id.editText2);
        Button send = findViewById(R.id.button);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String smsBody = text.getText().toString();
                Intent smsSend = new Intent(Intent.ACTION_SENDTO);
                smsSend.setData(Uri.parse("smsto:44556"));
                smsSend.putExtra("sms_body", smsBody);
                startActivity(smsSend);
            }
        });
    }
}
