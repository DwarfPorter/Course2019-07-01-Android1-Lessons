package ru.geekbrains.hellobrowser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void goBrowser(View view) {
        EditText url = findViewById(R.id.editText);
        String uriString = url.getText().toString();
        Uri uri = Uri.parse(uriString);
        Intent browser = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(browser);

    }
}
