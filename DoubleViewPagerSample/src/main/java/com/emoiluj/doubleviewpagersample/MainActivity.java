package com.emoiluj.doubleviewpagersample;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.view.Window;

import com.emoiluj.doubleviewpager.DoubleViewPager;
import com.emoiluj.doubleviewpager.DoubleViewPagerAdapter;

import java.util.ArrayList;


public class MainActivity extends Activity{

    private DoubleViewPager viewpager;
    private int horizontalChilds;
    private int verticalChilds;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        loadDataFromSplash();
        loadUI();
    }

    private void loadDataFromSplash(){
        horizontalChilds = getIntent().getExtras().getInt("HORIZONTAL");
        verticalChilds = getIntent().getExtras().getInt("VERTICAL");
    }

    private void loadUI() {

        ArrayList<PagerAdapter> verticalAdapters = new ArrayList<PagerAdapter>();
        generateVerticalAdapters(verticalAdapters);

        viewpager = (DoubleViewPager) findViewById(R.id.pager);
        viewpager.setAdapter(new DoubleViewPagerAdapter(getApplicationContext(), verticalAdapters));
    }

    private void generateVerticalAdapters(ArrayList<PagerAdapter> verticalAdapters) {
        for (int i=0; i<horizontalChilds; i++){
            verticalAdapters.add(new VerticalPagerAdapter(this, i, verticalChilds));
        }
    }

}