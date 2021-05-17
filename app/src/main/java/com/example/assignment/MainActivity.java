package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity
        extends AppCompatActivity {

    TextView tvCases, tvRecovered, tvCritical, tvActive, tvTodayCases, tvTotalDeaths, tvTodayDeaths, tvAffectedCountries, tests,
    tvPopulation, tvCases1, tvRecovered1, tvCritical1, tvActive1, tvTodayCases1, tvTotalDeaths1, tvTodayDeaths1, tvAffectedCountries1;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvCases = findViewById(R.id.tvCases);
        tvRecovered = findViewById(R.id.tvRecovered);
        tvCritical = findViewById(R.id.tvCritical);
        tvActive = findViewById(R.id.tvActive);
        tvTodayCases = findViewById(R.id.tvTodayCases);
        tvTotalDeaths = findViewById(R.id.tvTotalDeaths);
        tvTodayDeaths = findViewById(R.id.tvTodayDeaths);
        tvAffectedCountries = findViewById(R.id.tvAffectedCountries);
        tests = findViewById(R.id.tests);
        tvPopulation = findViewById(R.id.tvPopulation);
        tvCases1 = findViewById(R.id.tvCases1);
        tvRecovered1 = findViewById(R.id.tvRecovered1);
        tvCritical1 = findViewById(R.id.tvCritical1);
        tvActive1 = findViewById(R.id.tvActive1);
        tvTodayCases1 = findViewById(R.id.tvTodayCases1);
        tvTotalDeaths1 = findViewById(R.id.tvTotalDeaths1);
        tvTodayDeaths1 = findViewById(R.id.tvTodayDeaths1);
        tvAffectedCountries1 = findViewById(R.id.tvAffectedCountries1);

        fetchdata();
    }

    private void fetchdata()
    {

//      String url = "https://disease.sh/v3/covid-19/gov/India";
        String url1 = "https://disease.sh/v3/covid-19/all";
        String url = "https://disease.sh/v3/covid-19/countries/India";

        StringRequest request = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response)
                    {
                        try {
                            JSONObject jsonObject = new JSONObject(response.toString());

                            tvCases.setText(jsonObject.getString("cases"));
                            tvRecovered.setText(jsonObject.getString("recovered"));
                            tvCritical.setText(jsonObject.getString("critical"));
                            tvActive.setText(jsonObject.getString("active"));
                            tvTodayCases.setText(jsonObject.getString("todayCases"));
                            tvTotalDeaths.setText(jsonObject.getString("deaths"));
                            tvTodayDeaths.setText(jsonObject.getString("deathsPerOneMillion"));
                            tvAffectedCountries.setText(jsonObject.getString("casesPerOneMillion"));
                            tests.setText(jsonObject.getString("tests"));
                            tvPopulation.setText(jsonObject.getString("population"));
                        }
                        catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error)
                    {
                        Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });


        StringRequest request1 = new StringRequest(Request.Method.GET, url1,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response1) {
                        try {
                            JSONObject jsonObject1 = new JSONObject(response1.toString());
                            tvCases1.setText(jsonObject1.getString("cases"));
                            tvRecovered1.setText(jsonObject1.getString("recovered"));
                            tvCritical1.setText(jsonObject1.getString("critical"));
                            tvActive1.setText(jsonObject1.getString("active"));
                            tvTodayCases1.setText(jsonObject1.getString("todayCases"));
                            tvTotalDeaths1.setText(jsonObject1.getString("deaths"));
                            tvTodayDeaths1.setText(jsonObject1.getString("deathsPerOneMillion"));
                            tvAffectedCountries1.setText(jsonObject1.getString("casesPerOneMillion"));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error)
                        {
                            Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);
        RequestQueue requestQueue1 = Volley.newRequestQueue(this);
        requestQueue1.add(request1);
    }
}