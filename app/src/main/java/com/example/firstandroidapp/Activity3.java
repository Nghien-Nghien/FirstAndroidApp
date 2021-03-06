package com.example.firstandroidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Activity3 extends AppCompatActivity {

    EditText edittext1;
    EditText edittext2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        edittext1 = findViewById(R.id.edittext1);
        edittext2 = findViewById(R.id.edittext2);

        Intent intent = getIntent();
        String id = intent.getStringExtra("ID");
        String password = intent.getStringExtra("Password");
        edittext1.setText(id);
        edittext2.setText(password);

        Button button_send_back = findViewById(R.id.button_send_back);
        button_send_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String showIdAndPass = id + " - " + password;
                Intent showIdAndPassIntent = new Intent();
                showIdAndPassIntent.putExtra("showIdAndPass", showIdAndPass);
                setResult(RESULT_OK, showIdAndPassIntent);
                finish();
            }
        });
    }
}