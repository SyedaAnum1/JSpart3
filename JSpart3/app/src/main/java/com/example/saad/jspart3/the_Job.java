package com.example.saad.jspart3;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.net.URI;
import java.net.URL;

public class the_Job extends AppCompatActivity {

    Button apply;

    TextView job1Title;
    TextView getKey;
    TextView getTitle;
    TextView getcompany;
    TextView getcity;
    TextView getstate;
    TextView getcountry;
    TextView getformattedLocation;
    TextView getsource;
    TextView getdate;
    TextView getsnippet;
    TextView geturl;
    TextView getsponsored;
    TextView getexpired;

    String jobTitle;
    String company;
    String city;
    String state;
    String country;
    String formattedLocation;
    String source;
    String date;
    String snippet;
    String url;
    String latitude;
    String longitude;
    String jobkey;
    String sponsored;
    String expired;
    String formattedLocationFull;
    String formattedRelativeTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_the_job);

        apply = (Button)findViewById(R.id.btnApply);

        job1Title = (TextView)findViewById(R.id.job1title);
        getKey = (TextView)findViewById(R.id.getjobkey);
        getTitle = (TextView)findViewById(R.id.getjobtitle);
        getcompany = (TextView)findViewById(R.id.getcompany_);
        getcity = (TextView)findViewById(R.id.getcity);
        getstate = (TextView)findViewById(R.id.getState);
        getcountry = (TextView)findViewById(R.id.getCountry);
        getformattedLocation = (TextView)findViewById(R.id.getformattedLocation);
        getsource = (TextView)findViewById(R.id.getSource);
        getdate = (TextView)findViewById(R.id.getdate);
        getsnippet = (TextView)findViewById(R.id.getSnippet);
        getsponsored = (TextView)findViewById(R.id.getSponsord);
        getexpired = (TextView)findViewById(R.id.getExpied);


        final Intent intent = getIntent();
        Bundle b = intent.getExtras();
        if(b != null){
             jobTitle = (String) b.get("jobtitle");
             company = (String) b.get("company");
             city = (String) b.get("city");
             state = (String) b.get("state");
            country = (String) b.get("country");
            formattedLocation = (String) b.get("formattedLocation");
            source = (String) b.get("source");
            date = (String) b.get("data");
            snippet = (String) b.get("snippet");
            url = (String) b.get("url");
            latitude = (String) b.get("latitude");
            longitude = (String) b.get("longitude");
            jobkey = (String) b.get("jobkey");
            sponsored = (String) b.get("sponsored");
            expired = (String) b.get("expired");
            formattedLocationFull = (String) b.get("formattedLocationFull");
            formattedRelativeTime = (String) b.get("formattedRelativeTime");
        }

        job1Title.setText(jobTitle);
        getKey.setText(jobkey);
        getTitle.setText(jobTitle);
        getcompany.setText(company);
        getcity.setText(city);
        getstate.setText(state);
        getcountry.setText(country);
        getformattedLocation.setText(formattedLocationFull);
        getsource.setText(source);
        getdate.setText(date);
        getsnippet.setText(snippet);
        getsponsored.setText(sponsored);
        getexpired.setText(expired);

        apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri webpage = Uri.parse(url);
                Intent intent1 = new Intent(Intent.ACTION_VIEW, webpage);
                if(intent1.resolveActivity(getPackageManager())!= null){
                      startActivity(intent1);
                }
            }
        });

    }

}
