package com.example.rh;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.example.rh.models.User;

public class SignUpActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Sign Up");
        setContentView(R.layout.activity_sign_up);


    }

    public void GoToBack(View view) {
        Intent intent = new Intent(this, SignInUpActivity.class);
        startActivity(intent);
    }

    public void GoToLogIn(View view) {
        ApiCaller caller = new ApiCaller();

        EditText Name = (EditText) findViewById(R.id.NameET);
        EditText FirstName = (EditText) findViewById(R.id.FirstNameET);
        EditText Email = (EditText) findViewById(R.id.EmailET);
        EditText Phone = (EditText) findViewById(R.id.PhoneET);
        EditText Password = (EditText) findViewById(R.id.PasswordET);

        try {

            int valideForm;
            //call api pour nouveau user
            User user = new User(Name.getText().toString(), FirstName.getText().toString(), Email.getText().toString(), Password.getText().toString(), Phone.getText().toString());

            caller.Createuser(user);

            valideForm = checkForm(user);
            if (valideForm== 0){
                Intent intent = new Intent(this, SignInActivity.class);
                startActivity(intent);
            }


        } catch (Exception e) {
            Log.e("test", "GoToLogIn: " + e);
        }



    }

    public int checkForm(User newuser) {
        String Erreur = "";

        int status = 0;
        if (newuser.getName().matches("[^A-Za-z']")|| newuser.getName().matches("")) {
            Erreur = Erreur + "Name : only a-Z allowed\n";
            status = 1;
        }
        if (newuser.getFirstname().matches("[^A-Za-z']")|| newuser.getFirstname().matches("")) {
            Erreur = Erreur + "FirstName : only a-Z allowed\n";
            status = 1;
        }
        if (newuser.getPhone().matches("[^0-9]")|| newuser.getPhone().matches("")) {
            Erreur = Erreur + "Phone : no letter nedeed\n";
            status = 1;

        }
        if (newuser.getEmail().matches("")) {
            Erreur = Erreur + "Email : Empty\n";
            status = 1;

        }
        if (newuser.getPassword().length() < 8) {
            Erreur = Erreur + "password < 8 char\n";
            status = 1;
        }
        if (status == 1) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(Erreur)
                    .setTitle("Result Check Form");

            AlertDialog alert = builder.create();
            alert.show();
            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                }
            });

        } else {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Valide Form")
                    .setTitle("Result Check Form");

            AlertDialog alert = builder.create();
            alert.show();
            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {

                }
            });
        }
        return status;
    }

}
