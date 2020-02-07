package com.example.easyexchange;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private TextView mTextViewResult;
    private RequestQueue mQueue;
    private Button btn;
    private String strUrl="https://api.exchangerate-api.com/v4/latest/USD";
    String[] mCurrency = new String[12];
    String[] mRate = new String[12];
    String o1,o2,o3,o4,o5,o6,o7;
    TextView a1,a2,a3,a4,a5,a6,a8,a9,a10;
    TextView b1,b2,b3,b4,b5,b6,b8,b9,b10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        a1=(TextView)findViewById(R.id.cur1);
        a2=(TextView)findViewById(R.id.cur2);
        a3=(TextView)findViewById(R.id.cur3);
        a4=(TextView)findViewById(R.id.cur4);
        a5=(TextView)findViewById(R.id.cur5);
        a6=(TextView)findViewById(R.id.cur6);
        a8=(TextView)findViewById(R.id.cur8);
        a9=(TextView)findViewById(R.id.cur9);
        a10=(TextView)findViewById(R.id.cur10);


        b1=(TextView)findViewById(R.id.rate1);
        b2=(TextView)findViewById(R.id.rate2);
        b3=(TextView)findViewById(R.id.rate3);
        b4=(TextView)findViewById(R.id.rate4);
        b5=(TextView)findViewById(R.id.rate5);
        b6=(TextView)findViewById(R.id.rate6);
        b8=(TextView)findViewById(R.id.rate8);
        b9=(TextView)findViewById(R.id.rate9);
        b10=(TextView)findViewById(R.id.rate10);


        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_nav);
        bottomNavigationView.setSelectedItemId(R.id.navigation_dash);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_dash:
                        break;
                    case R.id.navigation_convert:
                        Intent a = new Intent(MainActivity.this, Convert.class);
                        a.putExtra("name", mCurrency);
                        a.putExtra("rate", mRate);
                        startActivity(a);
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.navigation_favorite:
                        Intent b = new Intent(MainActivity.this, Calculator.class);
                        startActivity(b);
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.navigation_about:
                        Intent c = new Intent(MainActivity.this, Information.class);
                        startActivity(c);
                        overridePendingTransition(0, 0);
                        return true;
                }
                return true;
            }
        });

        new MyTask().execute();
    }

    private class MyTask extends AsyncTask<String, String, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... params){

            URL url = null;
            try {
                url = new URL(strUrl);

                HttpURLConnection client = (HttpURLConnection) url.openConnection();
                client.setRequestMethod("GET");
                client.connect();



                BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));

                String response = in.readLine();
                //System.out.println("Whole is" + response);


                JSONObject obj1 = new JSONObject(response);
                JSONObject obj2 = obj1.getJSONObject("rates");
                mRate[0]=obj2.getString("USD");
                mCurrency[0]="USD";

                mRate[1]=obj2.getString("AED");
                mCurrency[1]="AED";

                mRate[2]=obj2.getString("ARS");
                mCurrency[2]="ARS";

                mRate[3]=obj2.getString("AUD");
                mCurrency[3]="AUD";

                mRate[4]=obj2.getString("BGN");
                mCurrency[4]="BGN";

                mRate[5]=obj2.getString("BRL");
                mCurrency[5]="BRL";

                mRate[6]=obj2.getString("BSD");
                mCurrency[6]="BSD";

                mRate[7]=obj2.getString("CAD");
                mCurrency[7]="CAD";

                mRate[8]=obj2.getString("CHF");
                mCurrency[8]="CHF";

                mRate[9]=obj2.getString("CLP");
                mCurrency[9]="CLP";

                mRate[10]=obj2.getString("CNY");
                mCurrency[10]="CNY";

                mRate[11]=obj2.getString("COP");
                mCurrency[11]="COP";

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;

        }

        @Override
        protected void onPostExecute(String result){

            a1.setText(mCurrency[0]);
            b1.setText(mRate[0]);

            a2.setText(mCurrency[1]);
            b2.setText(mRate[1]);

            a3.setText(mCurrency[2]);
            b3.setText(mRate[2]);

            a4.setText(mCurrency[3]);
            b4.setText(mRate[3]);

            a5.setText(mCurrency[4]);
            b5.setText(mRate[4]);

            a6.setText(mCurrency[5]);
            b6.setText(mRate[5]);

            a8.setText(mCurrency[6]);
            b8.setText(mRate[6]);

            a9.setText(mCurrency[7]);
            b9.setText(mRate[7]);

            a10.setText(mCurrency[8]);
            b10.setText(mRate[8]);

            super.onPostExecute(result);

        }
    }



}



