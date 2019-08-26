package com.example.rh;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;

import com.example.rh.API.NetworkClient;
import com.example.rh.API.UserAPI;
import com.example.rh.models.Loging;
import com.example.rh.models.User;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class SignInActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle("Sign In");
        setContentView(R.layout.activity_sign_in);

        SharedPreferences pref = getApplicationContext().getSharedPreferences("login", MODE_PRIVATE);
        EditText log = (EditText) findViewById(R.id.emailTextView);
        EditText password = (EditText) findViewById(R.id.passwordTextView);
        Switch remember = (Switch) findViewById(R.id.rememberSW);
        String emailtv=pref.getString("log", "");// getting String
        String passwordtv=pref.getString("password", "");// getting String
        boolean remembersw = pref.getBoolean("remember", false);

        log.setText(emailtv);
        password.setText(passwordtv);
        remember.setChecked(remembersw);

    }

    public void GoToHome(View view){
        EditText log = (EditText) findViewById(R.id.emailTextView);
        EditText password = (EditText) findViewById(R.id.passwordTextView);
        Switch rememberme = (Switch) findViewById(R.id.rememberSW) ;
        Log.e("test", "GoToHome: "+rememberme.isChecked());
        if(rememberme.isChecked()){
            createPreferences(log.getText().toString(),password.getText().toString());
        }else{
            clearPreferences();
        }
        //loginuser(log.getText().toString(),password.getText().toString());
        Intent intent = new Intent(this, FragmentManagerActivity.class);
        startActivity(intent);
    }
    public void GoToBack(View view){
        Intent intent = new Intent(this, SignInUpActivity.class);
        startActivity(intent);
    }

    public void createPreferences(String log,String password){
        SharedPreferences pref = getApplicationContext().getSharedPreferences("login", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();

        editor.putString("log", log);  // Saving string
        editor.putString("password", password);  // Saving string

        editor.putBoolean("remember",true);

        editor.apply();

    }
    public void clearPreferences(){
        SharedPreferences pref = getApplicationContext().getSharedPreferences("login", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.clear();
        editor.apply();
    }
    private void loginuser(String login , String password){
        Retrofit retrofit = NetworkClient.getRetrofitClient();

        UserAPI userAPI = retrofit.create(UserAPI.class);

        Loging loging = new Loging(login,password);

        Call call = userAPI.createUser(loging);
        /*
        This is the line which actually sends a network request. Calling enqueue() executes a call asynchronously. It has two callback listeners which will invoked on the main thread
        */
        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                /*This is the success callback. Though the response type is JSON, with Retrofit we get the response in the form of WResponse POJO class
                 */
                if (response.body() != null) {
                    List<User> users = response.body();
                    Log.e("test", "onResponse: "+ users.get(0).getIdUser());
                }
            }
            @Override
            public void onFailure(Call call, Throwable t) {
                Log.e("test", "onFailure: "+t );
            }
        });
    }
}
