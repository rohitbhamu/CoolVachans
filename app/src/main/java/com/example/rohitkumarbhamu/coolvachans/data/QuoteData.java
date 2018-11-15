package com.example.rohitkumarbhamu.coolvachans.data;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.rohitkumarbhamu.coolvachans.controller.AppController;
import com.example.rohitkumarbhamu.coolvachans.model.Quote;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

//created by rohit bhamu
public class QuoteData {
    ArrayList<Quote>quoteArrayList=new ArrayList<>();
    public void getQuotes(final QuoteListAsyncResponse callBack){
        String url="https://gist.githubusercontent.com/nasrulhazim/54b659e43b1035215cd0ba1d4577ee80/raw/e3c6895ce42069f0ee7e991229064f167fe8ccdc/quotes.json";

        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
            for (int i=0;i<response.length();i++){
                try {
                    JSONObject quoteObject = response.getJSONObject(i);
                    Quote quote= new Quote();
                    quote.setQuote(quoteObject.getString("quote"));

                    quote.setAuthor(quoteObject.getString("name"));

                    Log.d("STUFFF::",quoteObject.getString("name"));

                    quoteArrayList.add(quote);


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            if (null != callBack) callBack.processFinished(quoteArrayList);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        AppController.getInstance().addToRequestQueue(jsonArrayRequest);
    }

}

