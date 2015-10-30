package com.emoiluj.doubleviewpagersample;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.text.InputType;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class SplashActivity extends Activity implements View.OnKeyListener{

    private TextView title;
    private LinearLayout line;
    private ImageView logo;
    private LinearLayout data;
    private EditText etHorizontal;
    private EditText etVertical;
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

        etHorizontal = (EditText) findViewById(R.id.splash_data_horizontal_childs_et);
        etVertical = (EditText) findViewById(R.id.splash_data_vertical_childs_et);
        etHorizontal.setInputType(InputType.TYPE_CLASS_NUMBER);
        etVertical.setInputType(InputType.TYPE_CLASS_NUMBER);
        etVertical.setOnKeyListener(this);

        button.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                goToMain();
            }
        });

    }

    public boolean onKey(View v, int keyCode, KeyEvent event) {
        if (v.getId() == R.id.splash_data_vertical_childs_et && event.getAction() == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
            goToMain();
        }
        return false;
    }

    private void goToMain(){
        if (etHorizontal.getText().toString().length() > 0 && etVertical.getText().toString().length() > 0) {
            Intent intent = new Intent(getApplicationContext(), com.emoiluj.doubleviewpagersample.MainActivity.class);
            intent.putExtra("HORIZONTAL", Integer.valueOf(etHorizontal.getText().toString()));
            intent.putExtra("VERTICAL", Integer.valueOf(etVertical.getText().toString()));
            startActivity(intent);
            finish();
        } else {
            Toast.makeText(getApplicationContext(), "Boxes can not be empty!", Toast.LENGTH_SHORT).show();
        }
    }

}