package com.emoiluj.doubleviewpagersample;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.text.InputType;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class SplashActivity extends Activity{

    private TextView title;
    private LinearLayout line;
    private ImageView logo;
    private LinearLayout data;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash);
        loadUI();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                logo.setVisibility(View.GONE);
                title.setVisibility(View.VISIBLE);
                line.setVisibility(View.VISIBLE);
                data.setVisibility(View.VISIBLE);
                button.setVisibility(View.VISIBLE);
            }

        }, 2000);
    }

    private void loadUI(){

        title = (TextView) findViewById(R.id.splash_title);
        title.setTypeface(Typeface.createFromAsset(getAssets(), "OpenSans-Light.ttf"));
        line = (LinearLayout) findViewById(R.id.splash_line);
        logo = (ImageView) findViewById(R.id.splash_logo);
        data = (LinearLayout) findViewById(R.id.splash_data);
        button = (Button) findViewById(R.id.splash_button);

        ((TextView) findViewById(R.id.splash_data_horizontal_childs_tv)).setTypeface(Typeface.createFromAsset(getAssets(), "OpenSans-Light.ttf"));
        ((TextView) findViewById(R.id.splash_data_vertical_childs_tv)).setTypeface(Typeface.createFromAsset(getAssets(), "OpenSans-Light.ttf"));

        final EditText horizontal = (EditText) findViewById(R.id.splash_data_horizontal_childs_et);
        final EditText vertical = (EditText) findViewById(R.id.splash_data_vertical_childs_et);
        horizontal.setInputType(InputType.TYPE_CLASS_NUMBER);
        vertical.setInputType(InputType.TYPE_CLASS_NUMBER);

        button.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                if(horizontal.getText().toString().length() > 0 && vertical.getText().toString().length() > 0){
                    Intent intent = new Intent(getApplicationContext(), com.emoiluj.doubleviewpagersample.MainActivity.class);
                    intent.putExtra("HORIZONTAL", Integer.valueOf(horizontal.getText().toString()));
                    intent.putExtra("VERTICAL", Integer.valueOf(vertical.getText().toString()));
                    startActivity(intent);
                    finish();
                }else{
                    Toast.makeText(getApplicationContext(), "Boxes can not be empty!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

}