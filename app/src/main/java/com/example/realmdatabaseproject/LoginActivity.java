package com.example.realmdatabaseproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import io.realm.Realm;
import io.realm.RealmResults;

public class LoginActivity extends AppCompatActivity {

     EditText emails , passwords;
    private Button  LoginButton , RegisterButton;

    Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emails = findViewById(R.id.edit_email);
        passwords = findViewById(R.id.edit_password);
        LoginButton = (Button)findViewById(R.id.login_button);
        RegisterButton = (Button)findViewById(R.id.register_button);

        realm.init(this);
        realm = Realm.getDefaultInstance();

        RegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                finish();
            }
        });
        LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (emails.getText().toString().isEmpty() | passwords.getText().toString().isEmpty())
                {
                    Toast.makeText(LoginActivity.this, "field Can't be empty", Toast.LENGTH_SHORT).show();
                }
                else
                {
                  //  realm.beginTransaction();


                    RealmResults<HelperModal> realmResults=realm.where(HelperModal.class).findAll();
                    String email="";
                    String pass="";

                    for (HelperModal helperModal:realmResults)
                    {
                        email+=helperModal.getInputEmail();
                        pass+=helperModal.getInputPassword();



                    }


                    if (email.contains(emails.getText().toString()) && pass.contains(passwords.getText().toString()))
                    {
                        Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent);
                        finish();
                    }
                    else {
                        Toast.makeText(LoginActivity.this, "invalid username or password", Toast.LENGTH_LONG).show();
                    }




                      //  realm.commitTransaction();

                }
            }
        });
    }


}
