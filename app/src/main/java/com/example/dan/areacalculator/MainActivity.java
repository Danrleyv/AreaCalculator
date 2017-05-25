package com.example.dan.areacalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private RadioGroup rgGeo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rgGeo = (RadioGroup) findViewById(R.id.geo);
    }

    public void goData(View v){
        int form = rgGeo.getCheckedRadioButtonId() - 2131427432;

        Intent intencao = new Intent(this, DataActivity.class);

        if(form >= 0){
            intencao.putExtra("form", form);
            startActivity(intencao);
        }else{
            Toast.makeText(this.getApplicationContext(), R.string.error1, Toast.LENGTH_LONG).show();
        }
    }
}
