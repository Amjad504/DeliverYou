package com.example.deliveryou;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Currency_Converter {
    private static final String API_KEY = "pg6eIBfdzXiyGvbaU1QuoORnDGuFof1n";
    private static final String BASE_URL = "http://data.fixer.io/api/latest";

    public static double getCurrencyRate(String currencyCode) throws IOException, JSONException {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(BASE_URL + "?access_key=" + API_KEY + "&symbols=" + currencyCode)
                .build();

        Response response = client.newCall(request).execute();
        String responseBody = response.body().string();

        JSONObject json = new JSONObject(responseBody);
        JSONObject rates = json.getJSONObject("rates");
        double rate = rates.getDouble(currencyCode);

        return rate;
    }

    public static class CurrencyConverterTask extends AsyncTask<Void, Void, Double> {
        private String currencyCode;

        public CurrencyConverterTask(String currencyCode) {
            this.currencyCode = currencyCode;
        }

        @Override
        protected Double doInBackground(Void... params) {
            double rate = 0.0;

            try {
                rate = Currency_Converter.getCurrencyRate(currencyCode);
                Log.d("Currency_Converter", "Response Body: " + String.valueOf(rate));
            } catch (IOException | JSONException e) {
                e.printStackTrace();
            }

            return rate;
        }

        @Override
        protected void onPostExecute(Double result) {
            // Update UI with result
        }
    }
}
