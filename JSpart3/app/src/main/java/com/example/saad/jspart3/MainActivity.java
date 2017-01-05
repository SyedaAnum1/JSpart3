package com.example.saad.jspart3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button signin_btn;
    Button signup_btn;

    TextView searchJob1_btn;
    TextView postJob1_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        signin_btn = (Button)findViewById(R.id.sign_in_btn);
        signup_btn = (Button)findViewById(R.id.signup_btn);
        searchJob1_btn = (TextView) findViewById(R.id.searchJob1_btn);
        postJob1_btn = (TextView) findViewById(R.id.postJob1_btn);

        signin_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,SignIn1.class);
                startActivity(intent);
            }
        });

        signup_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,SignUp1.class);
                startActivity(intent);
            }
        });

        searchJob1_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,SearchJob1.class);
                startActivity(intent);
            }
        });
        postJob1_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,PostJob1.class);
                startActivity(intent);
            }
        });
    }
}
