package com.emoiluj.doubleviewpager;

import java.util.ArrayList;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;

public class DoubleViewPagerAdapter extends PagerAdapter{

	private Context mContext;
	private ArrayList<PagerAdapter> mAdapters;
	
	public DoubleViewPagerAdapter(Context context, ArrayList<PagerAdapter> verticalAdapters){
		mContext = context;
		mAdapters = verticalAdapters;
	}
	
	@Override
	public int getCount() {
		return mAdapters.size();
	}

	@Override
	public boolean isViewFromObject(View view, Object object) {
		return view == ((View) object);
	}
	
	@Override
	public void destroyItem(View container, int position, Object view) {
        ((HorizontalViewPager) container).removeView((View) view);
    };
    
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
    	VerticalViewPager childVP = new VerticalViewPager(mContext);
    	childVP.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
    	childVP.setAdapter(mAdapters.get(position));
    	container.addView(childVP);
    	return childVP;
    }

}
