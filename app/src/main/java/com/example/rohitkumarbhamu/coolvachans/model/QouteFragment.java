package com.example.rohitkumarbhamu.coolvachans.model;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.rohitkumarbhamu.coolvachans.R;

import java.util.concurrent.ThreadLocalRandom;

/**
 * A simple {@link Fragment} subclass.
 */
public class QouteFragment extends Fragment {


    public QouteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View quoteView=inflater.inflate(R.layout.fragment_qoute, container, false);
        TextView quoteText =quoteView.findViewById(R.id.quoteText);
        TextView byAuthor =quoteView.findViewById(R.id.byAuthor);
        CardView cardView=quoteView.findViewById(R.id.cardView);

        String quote=getArguments().getString("quote");
        String  author=getArguments().getString("author");

        quoteText.setText(quote);
        byAuthor.setText("-"+author);


        return quoteView;
    }
    public static final QouteFragment newInstance(String quote ,String author){
        QouteFragment fragment = new QouteFragment();
        Bundle bundle =new Bundle();
        bundle.putString("quote",quote);
        bundle.putString("author",author);
        fragment.setArguments(bundle);

        return fragment;
    }

}
