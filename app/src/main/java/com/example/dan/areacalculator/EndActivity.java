package com.example.dan.areacalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class EndActivity extends AppCompatActivity {

    private float result;
    private int form;
    private TextView tvArea;
    private ImageView ivImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);
        tvArea = (TextView) findViewById(R.id.tvArea);
        ivImage = (ImageView) findViewById(R.id.ivImage);
        result = getIntent().getFloatExtra("result", 0);
        form = getIntent().getIntExtra("form", 0);
        String s = "";
        s = Float.toString(result);
        tvArea.setText(tvArea.getText() + s);

        if(form == 0){
            ivImage.setBackgroundResource(R.drawable.quadrado);
        }else{
            if(form == 1){
                ivImage.setBackgroundResource(R.drawable.triangulo);
            }else{
                ivImage.setBackgroundResource(R.drawable.circulo);
            }
        }
    }

    public void close(View v){
        finish();
    }
}
