package com.example.project1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn2 = findViewById(R.id.idlogin);
        Button btn  = findViewById(R.id.idlogin2);
        EditText H = findViewById(R.id.idheight);
        EditText W = findViewById(R.id.idweight);
        TextView r = findViewById(R.id.resultat);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,MainActivity4.class);
                startActivity(i);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              float  h = Float.parseFloat(H.getText().toString()) / 100;
              float  w = Float.parseFloat(W.getText().toString());
              float res = (w / (h * h) );
              r.setText(String.valueOf(res));
                Toast.makeText(MainActivity.this,"234243",Toast.LENGTH_LONG).show();
            }
        });
    }
}