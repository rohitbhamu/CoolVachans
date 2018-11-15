package com.example.rohitkumarbhamu.coolvachans.data;

import com.example.rohitkumarbhamu.coolvachans.model.Quote;

import java.util.ArrayList;

public interface QuoteListAsyncResponse {
    void processFinished(ArrayList<Quote> quotes);
}
