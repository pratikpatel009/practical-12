package com.example.practical12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button button;
    TextView textView;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        textView = findViewById(R.id.textView);
        editText = findViewById(R.id.editTextTextPersonName);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String msg = editText.getText().toString();

                SharedPreferences sharedPreferences = getSharedPreferences("pratik",MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();

                editor.putString("str",msg);
                editor.apply();
                textView.setText(msg);
            }
        });

        SharedPreferences getShared = getSharedPreferences("pratik",MODE_PRIVATE);
        String value = getShared .getString("str","Save a node and it will show up here");
        textView.setText(value);
        editText.setText(value);
    }
}