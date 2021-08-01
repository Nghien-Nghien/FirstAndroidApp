package com.example.firstandroidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText textId;
    EditText textPassword;
    Button button_Activity2;
    Button button_Activity3;
    Button button_Activity4;
    TextView showIdPass;
    TextView showPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textId = findViewById(R.id.edittext1);
        textPassword = findViewById(R.id.edittext2);
        button_Activity2 = findViewById(R.id.button_activity2);
        button_Activity3 = findViewById(R.id.button_activity3);
        button_Activity4 = findViewById(R.id.button_activity4);

        button_Activity2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (textId.getText().toString().equals("") || textPassword.getText().toString().equals("")) {
                    Toast.makeText(MainActivity.this, "You not yet input username or password. Please recheck!", Toast.LENGTH_SHORT).show();
                } else if (textId.getText().toString().equals("Admin") && textPassword.getText().toString().equals("Android")) {
                    openActivity2();
                } else {
                    Toast.makeText(MainActivity.this, "Wrong input", Toast.LENGTH_SHORT).show();
                }
            }
        });

        button_Activity3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (textId.getText().toString().equals("") || textPassword.getText().toString().equals("")) {
                    Toast.makeText(MainActivity.this, "Please input both ID & Pass", Toast.LENGTH_SHORT).show();
                } else {
                    String id = (textId.getText().toString());
                    String password = (textPassword.getText().toString());
                    Intent intent = new Intent(MainActivity.this, Activity3.class);
                    intent.putExtra("ID", id);
                    intent.putExtra("Password", password);
                    startActivityIfNeeded(intent, 1);
                }
            }
        });

        button_Activity4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (textId.getText().toString().equals("") || textPassword.getText().toString().equals("")) {
                    Toast.makeText(MainActivity.this, "Please input both ID & Pass", Toast.LENGTH_SHORT).show();
                } else {
                    String id = (textId.getText().toString());
                    String password = (textPassword.getText().toString());
                    Intent intent = new Intent(MainActivity.this, Activity4.class);
                    intent.putExtra("ID", id);
                    intent.putExtra("Password", password);
                    startActivityIfNeeded(intent, 2);
                }
            }
        });
    }

    public void openActivity2() {
        Intent intent = new Intent(MainActivity.this, Activity2.class);
        startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {
            String showIdAndPass = data.getStringExtra("showIdAndPass");
            showIdPass = findViewById(R.id.textview3);
            showIdPass.setText(showIdAndPass);
        } else if (requestCode == 2 && resultCode == RESULT_OK) {
            String showOnlyPass = data.getStringExtra("showPass");
            showPass = findViewById(R.id.textview4);
            showPass.setText(showOnlyPass);
        }
    }
}
