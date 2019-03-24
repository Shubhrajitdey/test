package com.example.hp.projectsignin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText uid,upass;
    Button signin,signup;
    TextView fogetpass;
    CheckBox cb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        uid=(EditText)findViewById(R.id.useridet);
        upass=(EditText)findViewById(R.id.passwordet);
        signin=(Button)findViewById(R.id.loginbt);
        signup=(Button)findViewById(R.id.signupbt);
        fogetpass=(TextView)findViewById(R.id.forgetet);
        cb=(CheckBox)findViewById(R.id.checkbox);

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n=uid.getText().toString();
                String e=upass.getText().toString();
                if(n.length()==0){
                    showerror(1);
                    uid.setText("");
                    upass.setText("");
                    return;
                }
                if(e.length()==0){
                    showerror(2);
                    uid.setText("");
                    upass.setText("");
                    return;
                }
                else{
                    uid.setText("");
                    upass.setText("");
                    Toast.makeText(getApplicationContext(),"logged in successfully",Toast.LENGTH_SHORT).show();
                }

            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(MainActivity.this,signup.class);
                startActivity(in);
                finish();

            }
        });
        fogetpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        cb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
    public void showerror(int i){
        switch(i){
            case 1: uid.requestFocus();
                uid.setError("Invalid UserId");
                break;
            case 2:upass.requestFocus();
                upass.setError("Invalid Password");
                break;
        }
    }

}
