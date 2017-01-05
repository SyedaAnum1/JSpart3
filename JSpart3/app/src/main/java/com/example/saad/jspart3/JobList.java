package com.example.saad.jspart3;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
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
import java.util.ArrayList;

public class JobList extends AppCompatActivity {


    ProgressDialog progressDialog;
    String title;
    String country;
    String city;
    String state;
    private static int start = 0;
    TextView page1;
    TextView page2;
    TextView page3;
    TextView page4;
    TextView pageNext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_list);

        page1 = (TextView)findViewById(R.id.page1);
        page2 = (TextView)findViewById(R.id.page2);
        page3 = (TextView)findViewById(R.id.page3);
        page4 = (TextView)findViewById(R.id.page4);
        pageNext = (TextView)findViewById(R.id.pageNext);


        Intent myIntent = getIntent();
        title = myIntent.getStringExtra("title");
        country = myIntent.getStringExtra("country");
        city = myIntent.getStringExtra("city");
        state = myIntent.getStringExtra("state");
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Scanning New Vacancies");
        progressDialog.show();



        myAsync async = new myAsync();
        async.execute();

        page1 = (TextView)findViewById(R.id.page1);
        page1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                start = 0;
                page1.setTextColor(Color.parseColor("#000000"));
                page2.setTextColor(Color.parseColor("#607D8B"));
                page3.setTextColor(Color.parseColor("#607D8B"));
                page4.setTextColor(Color.parseColor("#607D8B"));
                pageNext.setTextColor(Color.parseColor("#607D8B"));
                myAsync async = new myAsync();
                async.execute();
            }
        });

        page2 = (TextView)findViewById(R.id.page2);
        page2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                start = 10;
                page1.setTextColor(Color.parseColor("#607D8B"));
                page2.setTextColor(Color.parseColor("#000000"));
                page3.setTextColor(Color.parseColor("#607D8B"));
                page4.setTextColor(Color.parseColor("#607D8B"));
                pageNext.setTextColor(Color.parseColor("#607D8B"));
                myAsync async = new myAsync();
                async.execute();
            }
        });

        page3 = (TextView)findViewById(R.id.page3);
        page3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                start = 20;
                page1.setTextColor(Color.parseColor("#607D8B"));
                page2.setTextColor(Color.parseColor("#607D8B"));
                page3.setTextColor(Color.parseColor("#000000"));
                page4.setTextColor(Color.parseColor("#607D8B"));
                pageNext.setTextColor(Color.parseColor("#607D8B"));
                myAsync async = new myAsync();
                async.execute();
            }
        });

        page4 = (TextView)findViewById(R.id.page4);
        page4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                start = 30;
                page1.setTextColor(Color.parseColor("#607D8B"));
                page2.setTextColor(Color.parseColor("#607D8B"));
                page3.setTextColor(Color.parseColor("#607D8B"));
                page4.setTextColor(Color.parseColor("#000000"));
                pageNext.setTextColor(Color.parseColor("#607D8B"));
                myAsync async = new myAsync();
                async.execute();
            }
        });

        pageNext = (TextView)findViewById(R.id.pageNext);
        pageNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                start += 10;
                page1.setTextColor(Color.parseColor("#607D8B"));
                page2.setTextColor(Color.parseColor("#607D8B"));
                page3.setTextColor(Color.parseColor("#607D8B"));
                page4.setTextColor(Color.parseColor("#607D8B"));
                pageNext.setTextColor(Color.parseColor("#000000"));
                myAsync async = new myAsync();
                async.execute();
            }
        });






    }
    public String[] getDataFromServer() {
        try {
            URL url = new URL("http://api.indeed.com/ads/apisearch?publisher=7678773726830322&format=json&q="+title+"&l="+city+"%2C+"+state+"&sort=&radius=&st=&jt=&start="+start+"&limit=&fromage=&filter=&latlong=1&co="+country+"&chnl=&userip=1.2.3.4&useragent=Mozilla/%2F4.0%28Firefox%29&v=2");
            //URL url = new URL("http://www.yahoo.com");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.connect();

            InputStream is = connection.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);

            String completedData = "";
            String tempData = null;
            while((tempData=br.readLine()) !=null){
                completedData+=tempData;
            }
            Log.d("Data From Api","<><><>"+completedData);
            return parseJSON(completedData);


        }
        catch (Exception e){
            e.printStackTrace();
            Log.d("Joblist Activity","Exception -- "+e.getMessage());
        }
        return null;
    }

    private String[] parseJSON(String jsonString){

        String[] a1 = new String[190];
        try {
            JSONObject obj = new JSONObject(jsonString);
            a1[0] = obj.getString("version");
            a1[1] = obj.getString("query");
            a1[2] = obj.getString("location");
            a1[3] = obj.getString("paginationPayload");
            a1[4] = obj.getString("radius");
            a1[5] = obj.getString("dupefilter");
            a1[6] = obj.getString("highlight");
            a1[7] = obj.getString("totalResults");
            a1[8] = obj.getString("start");
            a1[9] = obj.getString("pageNumber");

            JSONArray results = obj.getJSONArray("results");

            JSONObject firstIndex = results.getJSONObject(0);
            JSONObject secondIndex = results.getJSONObject(1);
            JSONObject thirdIndex = results.getJSONObject(2);
            JSONObject fourthIndex = results.getJSONObject(3);
            JSONObject fifthIndex = results.getJSONObject(4);
            JSONObject sixthIndex = results.getJSONObject(5);
            JSONObject seventhIndex = results.getJSONObject(6);
            JSONObject eighthIndex = results.getJSONObject(7);
            JSONObject ninethIndex = results.getJSONObject(8);
            JSONObject tenthindex = results.getJSONObject(9);

            a1[10] = firstIndex.getString("jobtitle");
            a1[11] = firstIndex.getString("company");
            a1[12] = firstIndex.getString("city");
            a1[13] = firstIndex.getString("state");
            a1[14] = firstIndex.getString("country");
            a1[15] = firstIndex.getString("formattedLocation");
            a1[16] = firstIndex.getString("source");
            a1[17] = firstIndex.getString("date");
            a1[18] = firstIndex.getString("snippet");
            a1[19] = firstIndex.getString("url");
            a1[20] = firstIndex.getString("latitude");
            a1[21] = firstIndex.getString("longitude");
            a1[22] = firstIndex.getString("jobkey");
            a1[23] = firstIndex.getString("sponsored");
            a1[24] = firstIndex.getString("expired");
            a1[25] = firstIndex.getString("formattedLocationFull");
            a1[26]= firstIndex.getString("formattedRelativeTime");
            a1[27]=null;

            a1[28] = secondIndex.getString("jobtitle");
            a1[29] = secondIndex.getString("company");
            a1[30] = secondIndex.getString("city");
            a1[31] = secondIndex.getString("state");
            a1[32] = secondIndex.getString("country");
            a1[33] = secondIndex.getString("formattedLocation");
            a1[34] = secondIndex.getString("source");
            a1[35] = secondIndex.getString("date");
            a1[36] = secondIndex.getString("snippet");
            a1[37] = secondIndex.getString("url");
            a1[38] = secondIndex.getString("latitude");
            a1[39] = secondIndex.getString("longitude");
            a1[40] = secondIndex.getString("jobkey");
            a1[41] = secondIndex.getString("sponsored");
            a1[42] = secondIndex.getString("expired");
            a1[43] = secondIndex.getString("formattedLocationFull");
            a1[44]= secondIndex.getString("formattedRelativeTime");
            a1[45]= null;


            a1[46] = thirdIndex.getString("jobtitle");
            a1[47] = thirdIndex.getString("company");
            a1[48] = thirdIndex.getString("city");
            a1[49] = thirdIndex.getString("state");
            a1[50] = thirdIndex.getString("country");
            a1[51] = thirdIndex.getString("formattedLocation");
            a1[52] = thirdIndex.getString("source");
            a1[53] = thirdIndex.getString("date");
            a1[54] = thirdIndex.getString("snippet");
            a1[55] = thirdIndex.getString("url");
            a1[56] = thirdIndex.getString("latitude");
            a1[57] = thirdIndex.getString("longitude");
            a1[58] = thirdIndex.getString("jobkey");
            a1[59] = thirdIndex.getString("sponsored");
            a1[60] = thirdIndex.getString("expired");
            a1[61] = thirdIndex.getString("formattedLocationFull");
            a1[62]= thirdIndex.getString("formattedRelativeTime");
            a1[63]= null;


            a1[64] = fourthIndex.getString("jobtitle");
            a1[65] = fourthIndex.getString("company");
            a1[66] = fourthIndex.getString("city");
            a1[67] = fourthIndex.getString("state");
            a1[68] = fourthIndex.getString("country");
            a1[69] = fourthIndex.getString("formattedLocation");
            a1[70] = fourthIndex.getString("source");
            a1[71] = fourthIndex.getString("date");
            a1[72] = fourthIndex.getString("snippet");
            a1[73] = fourthIndex.getString("url");
            a1[74] = fourthIndex.getString("latitude");
            a1[75] = fourthIndex.getString("longitude");
            a1[76] = fourthIndex.getString("jobkey");
            a1[77] = fourthIndex.getString("sponsored");
            a1[78] = fourthIndex.getString("expired");
            a1[79] = fourthIndex.getString("formattedLocationFull");
            a1[80]= fourthIndex.getString("formattedRelativeTime");
            a1[81]= null;

            a1[82] = fifthIndex.getString("jobtitle");
            a1[83] = fifthIndex.getString("company");
            a1[84] = fifthIndex.getString("city");
            a1[85] = fifthIndex.getString("state");
            a1[86] = fifthIndex.getString("country");
            a1[87] = fifthIndex.getString("formattedLocation");
            a1[88] = fifthIndex.getString("source");
            a1[89] = fifthIndex.getString("date");
            a1[90] = fifthIndex.getString("snippet");
            a1[91] = fifthIndex.getString("url");
            a1[92] = fifthIndex.getString("latitude");
            a1[93] = fifthIndex.getString("longitude");
            a1[94] = fifthIndex.getString("jobkey");
            a1[95] = fifthIndex.getString("sponsored");
            a1[96] = fifthIndex.getString("expired");
            a1[97] = fifthIndex.getString("formattedLocationFull");
            a1[98]= fifthIndex.getString("formattedRelativeTime");
            a1[99]= null;

            a1[100] = sixthIndex.getString("jobtitle");
            a1[101] = sixthIndex.getString("company");
            a1[102] = sixthIndex.getString("city");
            a1[103] = sixthIndex.getString("state");
            a1[104] = sixthIndex.getString("country");
            a1[105] = sixthIndex.getString("formattedLocation");
            a1[106] = sixthIndex.getString("source");
            a1[107] = sixthIndex.getString("date");
            a1[108] = sixthIndex.getString("snippet");
            a1[109] = sixthIndex.getString("url");
            a1[110] = sixthIndex.getString("latitude");
            a1[111] = sixthIndex.getString("longitude");
            a1[112] = sixthIndex.getString("jobkey");
            a1[113] = sixthIndex.getString("sponsored");
            a1[114] = sixthIndex.getString("expired");
            a1[115] = sixthIndex.getString("formattedLocationFull");
            a1[116]= sixthIndex.getString("formattedRelativeTime");
            a1[117]= null;

            a1[118] = seventhIndex.getString("jobtitle");
            a1[119] = seventhIndex.getString("company");
            a1[120] = seventhIndex.getString("city");
            a1[121] = seventhIndex.getString("state");
            a1[122] = seventhIndex.getString("country");
            a1[123] = seventhIndex.getString("formattedLocation");
            a1[124] = seventhIndex.getString("source");
            a1[125] = seventhIndex.getString("date");
            a1[126] = seventhIndex.getString("snippet");
            a1[127] = seventhIndex.getString("url");
            a1[128] = seventhIndex.getString("latitude");
            a1[129] = seventhIndex.getString("longitude");
            a1[130] = seventhIndex.getString("jobkey");
            a1[131] = seventhIndex.getString("sponsored");
            a1[132] = seventhIndex.getString("expired");
            a1[133] = seventhIndex.getString("formattedLocationFull");
            a1[134]= seventhIndex.getString("formattedRelativeTime");
            a1[135]= null;

            a1[136] = eighthIndex.getString("jobtitle");
            a1[137] = eighthIndex.getString("company");
            a1[138] = eighthIndex.getString("city");
            a1[139] = eighthIndex.getString("state");
            a1[140] = eighthIndex.getString("country");
            a1[141] = eighthIndex.getString("formattedLocation");
            a1[142] = eighthIndex.getString("source");
            a1[143] = eighthIndex.getString("date");
            a1[144] = eighthIndex.getString("snippet");
            a1[145] = eighthIndex.getString("url");
            a1[146] = eighthIndex.getString("latitude");
            a1[147] = eighthIndex.getString("longitude");
            a1[148] = eighthIndex.getString("jobkey");
            a1[149] = eighthIndex.getString("sponsored");
            a1[150] = eighthIndex.getString("expired");
            a1[151] = eighthIndex.getString("formattedLocationFull");
            a1[152]= eighthIndex.getString("formattedRelativeTime");
            a1[153]= null;

            a1[154] = ninethIndex.getString("jobtitle");
            a1[155] = ninethIndex.getString("company");
            a1[156] = ninethIndex.getString("city");
            a1[157] = ninethIndex.getString("state");
            a1[158] = ninethIndex.getString("country");
            a1[159] = ninethIndex.getString("formattedLocation");
            a1[160] = ninethIndex.getString("source");
            a1[161] = ninethIndex.getString("date");
            a1[162] = ninethIndex.getString("snippet");
            a1[163] = ninethIndex.getString("url");
            a1[164] = ninethIndex.getString("latitude");
            a1[165] = ninethIndex.getString("longitude");
            a1[166] = ninethIndex.getString("jobkey");
            a1[167] = ninethIndex.getString("sponsored");
            a1[168] = ninethIndex.getString("expired");
            a1[169] = ninethIndex.getString("formattedLocationFull");
            a1[170]= ninethIndex.getString("formattedRelativeTime");
            a1[171]= null;

            a1[172] = tenthindex.getString("jobtitle");
            a1[173] = tenthindex.getString("company");
            a1[174] = tenthindex.getString("city");
            a1[175] = tenthindex.getString("state");
            a1[176] = tenthindex.getString("country");
            a1[177] = tenthindex.getString("formattedLocation");
            a1[178] = tenthindex.getString("source");
            a1[179] = tenthindex.getString("date");
            a1[180] = tenthindex.getString("snippet");
            a1[181] = tenthindex.getString("url");
            a1[182] = tenthindex.getString("latitude");
            a1[183] = tenthindex.getString("longitude");
            a1[184] = tenthindex.getString("jobkey");
            a1[185] = tenthindex.getString("sponsored");
            a1[186] = tenthindex.getString("expired");
            a1[187] = tenthindex.getString("formattedLocationFull");
            a1[188]= tenthindex.getString("formattedRelativeTime");
            a1[189]= null;


            //Log.d(TAG,"DAta = "+data);
            return a1;
        }
        catch (JSONException e) {
            e.printStackTrace();
            Log.d("MainActivity","Exception -- "+e.getMessage());
        }
        return a1;
    }


    public class myAsync extends AsyncTask<Void, Void, String[]> {
        @Override
        protected String[] doInBackground(Void... params) {
            String[] metadata = getDataFromServer();
            return metadata;
        }

        @Override
        protected void onPostExecute(final String[] s) {
            super.onPostExecute(s);

            final ArrayList<Word> list = new ArrayList<Word>();
            list.add(new Word(s[10], s[11], s[14], s[12], s[17], s[16], s[13], s[15], s[18], s[19], s[20], s[21], s[22], s[23], s[24], s[25], s[26]));
            list.add(new Word(s[28], s[29], s[32], s[30], s[35], s[34], s[31], s[33], s[36], s[37], s[38], s[39], s[40], s[41], s[42], s[43], s[44] ));
            list.add(new Word(s[46], s[47], s[50], s[48], s[53], s[52], s[49], s[51], s[54], s[55], s[56], s[57], s[58], s[59], s[60], s[61], s[62]));
            list.add(new Word(s[64], s[65], s[68], s[66], s[71], s[70], s[67], s[69], s[72], s[73], s[74], s[75], s[76], s[77], s[78], s[79], s[80]));
            list.add(new Word(s[82], s[83], s[86], s[84], s[89], s[88], s[85], s[87], s[90], s[91], s[92], s[93], s[94], s[95], s[96], s[97], s[98]));
            list.add(new Word(s[100], s[101], s[104], s[105], s[107], s[106], s[103], s[105], s[108], s[109], s[110], s[111], s[112], s[113], s[114], s[115], s[116]));
            list.add(new Word(s[118], s[119], s[122], s[120], s[125], s[124], s[121], s[123], s[126], s[127], s[128], s[129], s[130], s[131], s[132], s[133], s[134]));
            list.add(new Word(s[136], s[137], s[140], s[138], s[143], s[142], s[139], s[141], s[144], s[145], s[146], s[147], s[148], s[149], s[150], s[151], s[152]));
            list.add(new Word(s[154], s[155], s[158], s[156], s[161], s[160], s[157], s[159], s[162], s[163], s[164], s[165], s[166], s[167], s[168], s[169], s[170]));
            list.add(new Word(s[172], s[173], s[176], s[174], s[179], s[178], s[175], s[177], s[180], s[181], s[182], s[183], s[184], s[185], s[186], s[187], s[188]));

            progressDialog.dismiss();
            WordAdapter adapter = new WordAdapter(JobList.this, list);
            ListView rootView = (ListView) findViewById(R.id.rootView);

            rootView.setAdapter(adapter);

            if(start + 2 > Integer.parseInt(s[7])){
                pageNext.setVisibility(View.GONE);
            }
            else {
                pageNext.setVisibility(View.VISIBLE);
            }

            rootView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            Word data = list.get(position);
                            Intent intent = new Intent(JobList.this, the_Job.class);
                            intent.putExtra("jobtitle",data.getmTitle());
                            intent.putExtra("company", data.getmCompany());
                            intent.putExtra("city", data.getmCity());
                    intent.putExtra("state", data.getmState());
                    intent.putExtra("country", data.getmCountry());
                    intent.putExtra("formattedLocation", data.getmformattedLocation());
                    intent.putExtra("source", data.getmSource());
                    intent.putExtra("data", data.getmPostDate());
                    intent.putExtra("snippet", data.getmSnippet());
                    intent.putExtra("url", data.getmURL());
                    intent.putExtra("latitude", data.getmLatitude());
                    intent.putExtra("longitude", data.getmLongitude());
                    intent.putExtra("jobkey", data.getmJobkey());
                    intent.putExtra("sponsored", data.getmSponsored());
                    intent.putExtra("expired", data.getmExpired());
                    intent.putExtra("formattedLocationFull", data.getMformattedLocationFull());
                    intent.putExtra("formattedRelativeTime", data.getMformattedRelativeTime());
                            //intent.putExtra("s", s);
                            startActivity(intent);

                }
            });


        }
    }
}
