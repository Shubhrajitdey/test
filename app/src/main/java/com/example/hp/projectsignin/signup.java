package com.example.hp.projectsignin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class signup extends AppCompatActivity {
    EditText name,email,ph,password,confirmpassword;
    CheckBox cb;
    Button signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        name=(EditText)findViewById(R.id.fullName);
        email=(EditText)findViewById(R.id.userEmailId);
        ph=(EditText)findViewById(R.id.mobileNumber);
        password=(EditText)findViewById(R.id.password);
        confirmpassword=(EditText)findViewById(R.id.confirmPassword);
        cb=(CheckBox)findViewById(R.id.terms_conditions);
        signup=(Button)findViewById(R.id.signUpBtn);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n=name.getText().toString();
                String e=email.getText().toString();
                String p=ph.getText().toString();
                String pass=password.getText().toString();
                String conpass=confirmpassword.getText().toString();
                int a=e.indexOf("@");
                int b=e.indexOf(".");
                int f=(b-1)-a;
                int c=(e.length()-(b+1));
                int count=0;
                for(int x=0;x<e.length();x++){
                    if((e.charAt(x)=='@')||(e.charAt(x)=='.'))
                        count++;
                }

                if(n.trim().length()==0){
                    showerror(1);
                    return;
                }
                if(e.trim().length()==0||!e.contains("@")||!e.contains(".")||a<2||f<2||c<2||count>2||e.contains(" ")){
                    showerror(2);
                    return;
                }
                if(p.trim().length()==0 || p.trim().length()!=10){
                    showerror(3);
                    return;
                }
                if(pass.trim().length()==0){
                    showerror(4);
                    return;
                }
                if(conpass.trim().length()==0 && !conpass.equals(pass)){
                        showerror(5);
                        return;

                }
                else{
                    Toast.makeText(getApplicationContext(),"Register successful",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
    public void showerror(int i){
        switch(i){
            case 1: name.requestFocus();
               name.setError("Fill Name");
                break;
            case 2:email.requestFocus();
                email.setError("Invalid Email");
                break;
            case 3:ph.requestFocus();
                ph.setError("Invalid Phone");
                break;
            case 4:password.requestFocus();
                password.setError("Invalid PassWord");
                break;
            case 5:confirmpassword.requestFocus();
                confirmpassword.setError("Password doesn't match");
                break;
            case 6:cb.requestFocus();
                cb.setError("Must be Checked");
                break;
        }
    }
}
