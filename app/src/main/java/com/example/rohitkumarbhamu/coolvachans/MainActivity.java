package com.example.rohitkumarbhamu.coolvachans;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.widget.RelativeLayout;

import com.example.rohitkumarbhamu.coolvachans.data.QuoteData;
import com.example.rohitkumarbhamu.coolvachans.data.QuoteListAsyncResponse;
import com.example.rohitkumarbhamu.coolvachans.data.QuoteViewPagerAdapter;
import com.example.rohitkumarbhamu.coolvachans.model.QouteFragment;
import com.example.rohitkumarbhamu.coolvachans.model.Quote;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private QuoteViewPagerAdapter quoteViewPagerAdapter;
    private ViewPager viewPager;
    private ScaleGestureDetector mScaleGestureDetector;
    private float mScaleFactor = 1.0f;
    private RelativeLayout relativeLayout;

    @Override
    public boolean onTouchEvent(MotionEvent motionevent) {
        mScaleGestureDetector.onTouchEvent(motionevent);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        quoteViewPagerAdapter =new QuoteViewPagerAdapter(getSupportFragmentManager(),getFragments());

        viewPager=findViewById(R.id.viewPager);
        viewPager.setAdapter(quoteViewPagerAdapter);
        relativeLayout=(RelativeLayout)findViewById(R.id.relativelayout);
        mScaleGestureDetector = new ScaleGestureDetector(this, new ScaleListener());
        //new QuoteData().getQuotes();
    }
    private List<Fragment> getFragments(){
        final List<Fragment> fragmentList=new ArrayList<>();



        for (int i=0;i<50;i++){
            QouteFragment qouteFragment= QouteFragment.newInstance("If India is not secular , then India is not India at all. ","Atal Bihari Vajpayee");
            fragmentList.add(qouteFragment);
        }

        return fragmentList;
    }

    private class ScaleListener extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        @Override
        public boolean onScale(ScaleGestureDetector scaleGestureDetector){
            mScaleFactor *= scaleGestureDetector.getScaleFactor();
            mScaleFactor = Math.max(0.1f,
                    Math.min(mScaleFactor, 10.0f));
            relativeLayout.setScaleX(mScaleFactor);
            relativeLayout.setScaleY(mScaleFactor);
            return true;
        }
    }
}

