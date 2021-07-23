package com.example.firstandroidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText textId = findViewById(R.id.edittext1);
        EditText textPassword = findViewById(R.id.edittext2);
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (textId.getText().toString().equals("") || textPassword.getText().toString().equals("")) {
                    Toast.makeText(MainActivity.this, "You not yet input username or password. Please recheck!", Toast.LENGTH_LONG).show();
                } else if (textId.getText().toString().equals("Admin") && textPassword.getText().toString().equals("Android")) {
                    openActivity2();
                }
                else {
                    Toast.makeText(MainActivity.this,"Wrong input",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void openActivity2() {
        Intent intent = new Intent(MainActivity.this, Activity2.class);
        startActivity(intent);
    }
}