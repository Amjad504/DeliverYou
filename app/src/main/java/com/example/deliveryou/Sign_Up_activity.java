package com.example.deliveryou;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Currency;
import java.util.Locale;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Sign_Up_activity extends AppCompatActivity {

    RadioButton userradio,driverradio;
    TextView login_btn;
    Button signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        getSupportActionBar().hide();



        @SuppressLint("WrongViewCast")
//        TextView check = findViewById(R.id.login_text);

        Locale currentLocale = Locale.getDefault();
        String currentCountry = currentLocale.getCountry();

//        String country = "IN"; // replace with your desired country code
        Locale locale = new Locale("", currentCountry);
        Currency currency = Currency.getInstance(locale);
        String currencyCode = currency.getCurrencyCode();

        Log.d("Currency code", currencyCode.toString());

//        fetchCurrencyValue(currencyCode,check);

        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setNavigationBarColor(0xFFFFFFFF);
        window.setStatusBarColor(0xFFFFFFFF);

        signup = findViewById(R.id.sign_up_btn);
        login_btn = findViewById(R.id.login_btn);
        userradio = findViewById(R.id.Customer);
        driverradio = findViewById(R.id.Driver);
        userradio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!userradio.isSelected()) {
                    userradio.setChecked(true);
                    userradio.setSelected(true);
                    driverradio.setChecked(false);
                    driverradio.setSelected(false);
                } else {
                    userradio.setChecked(false);
                    userradio.setSelected(false);
                }
            }
        });
        driverradio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!driverradio.isSelected()) {
                    userradio.setChecked(false);
                    userradio.setSelected(false);
                    driverradio.setChecked(true);
                    driverradio.setSelected(true);
                } else {
                    driverradio.setChecked(false);
                    driverradio.setSelected(false);
                }
            }
        });
        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Sign_Up_activity.this,Login.class);
                startActivity(i);
                finish();
            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (userradio.isSelected())
                {
                    Intent i = new Intent(Sign_Up_activity.this,Signup_customer.class);
                    startActivity(i);
                    finish();
                }
                else if (driverradio.isSelected())
                {
                    Intent i = new Intent(Sign_Up_activity.this,Signup_Driver1.class);
                    startActivity(i);
                }

            }
        });
    }



    private void fetchCurrencyValue(String countryCode, TextView check) {

        OkHttpClient client = new OkHttpClient();

        String url = "https://openexchangerates.org/api/latest.json?app_id=524d55cf442c4320b5ee4a1304d9d46f&base="+ countryCode;

        Request request = new Request.Builder()
                .url(url)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @SuppressLint("SetTextI18n")
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    String jsonResponse = response.body().string();

                    try {
                        JSONObject jsonObject = new JSONObject(jsonResponse);
                        JSONObject ratesObject = jsonObject.getJSONObject("rates");
                        Double currencyRate = ratesObject.getDouble("EUR");
                        String currencySymbol = Currency.getInstance(countryCode).getSymbol(); // fetch currency symbol
                        currencyRate = 1.0 / currencyRate;// invert the currency value
                        currencyRate = currencyRate * 1.49;
                        Double finalCurrencyValue = currencyRate;
                        String formattedValue = String.format("%.2f", finalCurrencyValue); // format the converted value with 2 decimal places
                        runOnUiThread(() -> {
                            check.setText(currencySymbol + " " + formattedValue);
                            Log.d("Currency Value", formattedValue);
                        });
                    } catch (JSONException e) {
                        e.printStackTrace();
                        Log.e("JSON Exception", e.getMessage());
                    }
                }
            }
        });
    }

}