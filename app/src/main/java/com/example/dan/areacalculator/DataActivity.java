package com.example.dan.areacalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class DataActivity extends AppCompatActivity {
    private TextView tvName1;
    private TextView tvName2;
    private EditText etOp1;
    private EditText etOp2;
    private int form;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);

        tvName1 = (TextView) findViewById(R.id.name1);
        tvName2 = (TextView) findViewById(R.id.name2);
        etOp1 = (EditText) findViewById(R.id.op1);
        etOp2 = (EditText) findViewById(R.id.op2);
        form = getIntent().getIntExtra("form", 0);
        if(form == 0){
            tvName1.setText(getResources().getString(R.string.height) + " and " + getResources().getString(R.string.base));
        }else {
            if (form == 1) {
                tvName1.setText(getResources().getString(R.string.height));
                tvName2.setVisibility(View.VISIBLE);
                tvName2.setText(getResources().getString(R.string.base));
                etOp2.setVisibility(View.VISIBLE);
            }
        }
    }



    public void goEnd(View v){
        if(form == 1) {
            if (etOp1.getText().toString().isEmpty() || etOp2.getText().toString().isEmpty()) {
                Toast.makeText(this.getApplicationContext(), R.string.error1, Toast.LENGTH_LONG).show();
            } else {
                float op1 = Float.parseFloat(etOp1.getText().toString());
                float op2 = Float.parseFloat(etOp2.getText().toString());
                float result = 0;

                result = op1 * op2 /2;

                Intent intencao = new Intent(this, EndActivity.class);
                intencao.putExtra("result", result);
                intencao.putExtra("form", form);
                startActivity(intencao);
                finish();
            }
        }else{
            if (etOp1.getText().toString().isEmpty()) {
                Toast.makeText(this.getApplicationContext(), R.string.error1, Toast.LENGTH_LONG).show();
            } else {
                float op1 = Float.parseFloat(etOp1.getText().toString());
                float pi = (float) 3.14;
                float result = 0;

                result = op1 * op1;
                if(form == 2){
                    result = result*pi;
                }

                Intent intencao = new Intent(this, EndActivity.class);
                intencao.putExtra("result", result);
                intencao.putExtra("form", form);
                startActivity(intencao);
                finish();
            }
        }

    }
}
