package com.example.abc.project1;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.preference.*;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by abc on 4/26/2015.
 */
public class regiscreen extends Activity implements View.OnClickListener
{
    EditText  er_name,e_pass,r_cpass;
    CheckBox ch_regis;
    Button bt_regis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.secscreen);
        er_name = (EditText) findViewById(R.id.er_name);
        e_pass = (EditText) findViewById(R.id.e_pass);
        r_cpass = (EditText) findViewById(R.id.r_cpass);
        ch_regis = (CheckBox) findViewById(R.id.ch_regis);
        bt_regis = (Button) findViewById(R.id.bt_regis);
        bt_regis.setOnClickListener(this);
        bt_regis.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                Toast.makeText(getApplicationContext(), "touch", Toast.LENGTH_SHORT).show();

                return false;
            }
        });
    }



    public void saveMySharedPreference(String key,String Value) {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        Editor ed = sp.edit();
        ed.putString(key, Value);
        Toast.makeText(getApplicationContext(),Value,Toast.LENGTH_LONG).show();
        ed.commit();

    }



   public void saveMySharedPreference(String Key,Boolean Value)
   {
       SharedPreferences sp=PreferenceManager.getDefaultSharedPreferences(this);
       Editor ed=sp.edit();
       ed.putBoolean(Key,Value);
     Toast.makeText(getApplicationContext(),"welcome",Toast.LENGTH_LONG).show();
       ed.commit();
   }

    public void clearMySharedPreference()
    {
        SharedPreferences sp=PreferenceManager.getDefaultSharedPreferences(this);
        Editor ed=sp.edit().clear();
        ed.commit();

    }



@Override
public void onClick(View v){
switch (v.getId()) {
    case R.id.bt_regis:
        if (ch_regis.isChecked()) {

            String str = er_name.getText().toString();
            saveMySharedPreference(constants.pre_user, ch_regis.isChecked());
            saveMySharedPreference(constants.pre_check, str);
            break;
        }
        else {
            clearMySharedPreference();
            break;
        }
}

        }
        }










