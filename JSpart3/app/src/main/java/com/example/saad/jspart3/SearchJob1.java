package com.example.saad.jspart3;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class SearchJob1 extends AppCompatActivity {

    Button btn1;
    TextView textView;
    EditText jobTitle;
    EditText city;
    EditText state;
    EditText country;

    private static final String TAG = "MainActivity" ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_job1);
        jobTitle = (EditText)findViewById(R.id.jobTitle);
        city = (EditText)findViewById(R.id.city);
        state = (EditText)findViewById(R.id.state);
        country = (EditText)findViewById(R.id.country);
        btn1 = (Button)findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if((TextUtils.isEmpty(jobTitle.getText().toString()) && (TextUtils.isEmpty(country.getText().toString())) && (TextUtils.isEmpty(city.getText().toString())))){
                    Toast.makeText(SearchJob1.this,"Fields are empty..",Toast.LENGTH_SHORT).show();
                }
                else if(((TextUtils.isEmpty(country.getText().toString())) || (TextUtils.isEmpty(city.getText().toString())))){
                    Toast.makeText(SearchJob1.this,"Fields are empty..",Toast.LENGTH_SHORT).show();
                }
                else{
                Intent myIntent = new Intent(SearchJob1.this, JobList.class);
                myIntent.putExtra("title", jobTitle.getText().toString());
                myIntent.putExtra("country", country.getText().toString());
                myIntent.putExtra("city", city.getText().toString());
                myIntent.putExtra("state", state.getText().toString());
                startActivity(myIntent);
                }
            }
        });

    }

}
