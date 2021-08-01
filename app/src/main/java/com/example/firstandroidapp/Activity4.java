package com.example.firstandroidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Activity4 extends AppCompatActivity {

    EditText edittext2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4);

        edittext2 = findViewById(R.id.edittext2);

        Intent intent = getIntent();
        String password = intent.getStringExtra("Password");
        edittext2.setText(password);

        Button button_send_back = findViewById(R.id.button_send_back);
        button_send_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String showPass = password;
                Intent showPassIntent = new Intent();
                showPassIntent.putExtra("showPass", showPass);
                setResult(RESULT_OK, showPassIntent);
                finish();
            }
        });
    }
}