package com.example.rh;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class SignInUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Remove title bar
        try
        {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){}


        this.setContentView(R.layout.activity_sign_in_up);

    }
    public void goToSignIn(View view){
        Intent intent = new Intent(this, SignInActivity.class);
        startActivity(intent);

    }
    public void goToSignUp(View view){
        Intent intent = new Intent(this, SignUpActivity.class);
        startActivity(intent);
    }


}
