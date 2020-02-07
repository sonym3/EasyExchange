package com.example.easyexchange;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Convert extends AppCompatActivity {
    Spinner from,to;
    TextView answ;
    String x,y;
    private String strUrl="https://api.exchangerate-api.com/v4/latest/";
    private Button find;
    private EditText value;
    private int val;
    String money;
    Float valuee;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convert);
        find=(Button) findViewById(R.id.btnFind);
        from=(Spinner)findViewById(R.id.fromm);
        to=(Spinner)findViewById(R.id.too);
        value=(EditText)findViewById(R.id.value);
        answ=(TextView)findViewById(R.id.answer);


        find.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                x= (String) from.getSelectedItem();
                y= (String) to.getSelectedItem();
                if (value.getText().toString().equals("")){
                    Toast.makeText(Convert.this, "You did not enter a money", Toast.LENGTH_SHORT).show();
                    return;
                }
                valuee=Float.parseFloat(value.getText()+"");
                strUrl+=x;
                System.out.println(strUrl);

                new MyTask().execute();
            }
        });

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_nav);
        bottomNavigationView.setSelectedItemId(R.id.navigation_convert );
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_dash:
                        Intent a = new Intent(Convert.this,MainActivity.class);
                        startActivity(a);
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.navigation_convert:
                        break;
                    case R.id.navigation_favorite:
                        Intent b = new Intent(Convert.this, Calculator.class);
                        startActivity(b);
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.navigation_about:
                        Intent c = new Intent(Convert.this,Information.class);
                        startActivity(c);
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });



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

                money=obj2.getString(y);


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
            float newMoney = Float.parseFloat(money);
            System.out.println("Floating money is " + newMoney);
            strUrl="https://api.exchangerate-api.com/v4/latest/";
            System.out.println("new URL "+ strUrl);
            float answer = newMoney*valuee;
            answ.setText(answer+"");
            super.onPostExecute(result);

        }
    }


}
