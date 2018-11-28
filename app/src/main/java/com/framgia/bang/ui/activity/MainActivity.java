package com.framgia.bang.ui.activity;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.framgia.bang.intent_framgia.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String KEY ="KEY";
    public static final int REQUEST_CODE = 012;
    private Button mImplicit, mExplicit, mSend;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControls();
        addEvents();
    }

    private void addEvents() {
        mImplicit.setOnClickListener(this);
        mExplicit.setOnClickListener(this);
        mSend.setOnClickListener(this);
    }

    private void addControls() {
        mExplicit = findViewById(R.id.btn_explicit);
        mImplicit = findViewById(R.id.btn_implicit);
        mSend = findViewById(R.id.btn_send);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_explicit:
                Intent intent = new Intent(this, SecondActivity.class);
                intent.putExtra(KEY, " send");
                startActivity(intent);
                break;
            case R.id.btn_implicit:
                Intent call = new Intent(Intent.ACTION_CALL);
                call.setData(Uri.parse("tel: 0379692508"));
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE)
                        != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[]
                    // permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the
                    // documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                startActivity(call);
                break;
            case R.id.btn_send:
                Intent intent1 = new Intent(this, SecondActivity.class);
                startActivityForResult(intent1, REQUEST_CODE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE){
            if (resultCode == Activity.RESULT_OK){
                String b = data.getStringExtra(SecondActivity.EXTRA);
                Toast.makeText(this, ""+b, Toast.LENGTH_SHORT).show();
            }
        }
    }
}
