package com.example.rh;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SignInActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Sign In");
        setContentView(R.layout.activity_sign_in);
    }

    public void GoToHome(View view){
        Intent intent = new Intent(this, FragmentManagerActivity.class);
        startActivity(intent);
    }
    public void GoToBack(View view){
        Intent intent = new Intent(this, SignInUpActivity.class);
        startActivity(intent);
    }
}
