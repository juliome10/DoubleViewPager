package com.emoiluj.doubleviewpager;

import java.util.Random;

import com.emoiluj.doubleviewpager.R;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.RelativeLayout.LayoutParams;


public class MainActivity extends Activity{

	private ExtendedHorizontalViewPager viewpager;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		loadUI();
	}

	private void loadUI() {
		viewpager = (ExtendedHorizontalViewPager) findViewById(R.id.pager);
		viewpager.setAdapter(new HorizontalPagerAdapter(getApplicationContext()));
	}

	
	public class HorizontalPagerAdapter extends PagerAdapter{

		private Context mContext;
		
		public HorizontalPagerAdapter(Context c){
			mContext = c;
		}
		
		@Override
		public int getCount() {
			return 3;
		}

		@Override
		public boolean isViewFromObject(View view, Object object) {
			return view == ((View) object);
		}
		
		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			
			RelativeLayout relative = new RelativeLayout(mContext);
			relative.setPadding(0, 0, 0, 0);
			LayoutParams relativelp = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
			relative.setLayoutParams(relativelp);
			relative.setBackgroundColor(getColor(position));
			relative.setGravity(Gravity.CENTER);
			
			ExtendedVerticalViewPager verticalVP = new ExtendedVerticalViewPager(mContext);
			verticalVP.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
			verticalVP.setAdapter(new VerticalPagerAdapter(mContext, position));
			relative.addView(verticalVP);
			
			container.addView(relative);
			return relative;
		};
		
		
		public void destroyItem(View container, int position, Object view) {
	        ((ExtendedHorizontalViewPager) container).removeView((View) view);
	    };
		
	}
	
	
	
	public class VerticalPagerAdapter extends PagerAdapter{

		private Context mContext;
		private int mParent;
		
		public VerticalPagerAdapter(Context c, int parent){
			mContext = c;
			mParent = parent;
		}
		
		@Override
		public int getCount() {
			return 5;
		}

		@Override
		public boolean isViewFromObject(View view, Object object) {
			return view == ((View) object);
		}
		
		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			
			RelativeLayout relative = new RelativeLayout(mContext);
			LayoutParams relativelp = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
			relative.setLayoutParams(relativelp);
			relative.setBackgroundColor(getColor(position));
			relative.setGravity(Gravity.CENTER);
			
			TextView tv = new TextView(mContext);
			LayoutParams tvlp=new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			tvlp.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE);
			tv.setLayoutParams(tvlp);
			tv.setText("P:"+mParent + " H:"+position);
			tv.setTextSize(70);
			relative.addView(tv);
			
			container.addView(relative);
			return relative;
		};
		
		
		public void destroyItem(View container, int position, Object view) {
	        ((ExtendedVerticalViewPager) container).removeView((View) view);
	    };
		
	}
	
	
	public int getColor(int position){
		Random rand = new Random();
		int r = rand.nextInt(255);
		int g = rand.nextInt(255);
		int b = rand.nextInt(255);

		return Color.rgb(r,g,b);
	}
}