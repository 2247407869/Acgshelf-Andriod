package com.example.lls.bangdan;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

/**
 * Created by LLS on 2018/3/1.
 */

public class DetailActivity extends AppCompatActivity {
    private String color;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        final Intent intent2 = getIntent();
        color = intent2.getStringExtra("color");


        RadioGroup radgroup = (RadioGroup) findViewById(R.id.radioGroup);
        RadioButton radioButton1 = (RadioButton) findViewById(R.id.radioButton1);
        RadioButton radioButton2 = (RadioButton) findViewById(R.id.radioButton2);
        RadioButton radioButton3 = (RadioButton) findViewById(R.id.radioButton3);
        RadioButton radioButton4 = (RadioButton) findViewById(R.id.radioButton4);
        RadioButton radioButton5 = (RadioButton) findViewById(R.id.radioButton5);
        if (color!=null){
            switch (color){
                case "1":
                    radioButton1.setChecked(true);
                    break;
                case "2":
                    radioButton2.setChecked(true);
                    break;
                case "3":
                    radioButton3.setChecked(true);
                    break;
                case "4":
                    radioButton4.setChecked(true);
                    break;
                case "5":
                    radioButton5.setChecked(true);
                    break;
            }
        }
        //第一种获得单选按钮值的方法
        //为radioGroup设置一个监听器:setOnCheckedChanged()
        radgroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radbtn = (RadioButton) findViewById(checkedId);
                switch (radbtn.getId()){
                    case R.id.radioButton1:
                        color = "1";
                        break;
                    case R.id.radioButton2:
                        color = "2";
                        break;
                    case R.id.radioButton3:
                        color = "3";
                        break;
                    case R.id.radioButton4:
                        color = "4";
                        break;
                    case R.id.radioButton5:
                        color = "5";
                        break;
                    case R.id.radioButton6:
                        color = null;
                        break;
                }
                intent2.putExtra("recolor",color);
                setResult(0x123,intent2);
                finish();
            }
        });

    }
}
