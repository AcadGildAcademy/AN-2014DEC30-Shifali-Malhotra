package com.example.abc.project1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by abc on 4/24/2015.
*/
public class firstscreen extends Activity implements View.OnClickListener {
    EditText et_name, et_pass;
    Button bt_sub,bt_new;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.firstscreen);
        et_name = (EditText) findViewById(R.id.et_name);
        et_pass = (EditText) findViewById(R.id.et_pass);
        bt_sub = (Button) findViewById(R.id.bt_sub);
        bt_sub.setOnClickListener(this);
        bt_new=(Button)findViewById(R.id.bt_new);
        bt_new.setOnClickListener(this);


    }




    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_sub:

                String pass = et_pass.getText().toString();
                String name = et_name.getText().toString();
                if (name.equals("Malhotra74")) {
                    if (pass.equals("shifali")) {
                        Toast.makeText(getApplicationContext(), "Login Success", Toast.LENGTH_LONG).show();
                        break;
                    }
                    else
                    {
                        et_pass.setError("invalid");
                        break;
                    }

                    } else {
                    et_name.setError("invalid username");
                    break;
                }

            case R.id.bt_new: {
                Intent intent = new Intent(firstscreen.this, regiscreen.class);
                startActivity(intent);
                break;

            }
        }
    }


}

















