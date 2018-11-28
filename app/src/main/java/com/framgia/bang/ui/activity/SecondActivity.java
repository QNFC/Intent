package com.framgia.bang.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;
import com.framgia.bang.intent_framgia.R;

public class SecondActivity extends AppCompatActivity {
    public static final String EXTRA = "EXTRA";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

//        Bundle a = getIntent().getExtras();
//        String b =a.getString(MainActivity.KEY);
        String c= "aaaa";
      //  Toast.makeText(this, ""+c, Toast.LENGTH_SHORT).show();

        Intent data = new Intent();
        data.putExtra(EXTRA, c);
        setResult(Activity.RESULT_OK, data);
    }
}
