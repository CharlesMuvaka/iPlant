package com.example.teamenvironmentkenya;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Toast;

import com.example.teamenvironmentkenya.database.DatabaseClient;
import com.example.teamenvironmentkenya.databinding.ActivitySignUpBinding;
import com.example.teamenvironmentkenya.models.Constants;
import com.example.teamenvironmentkenya.models.User;
import com.example.teamenvironmentkenya.models.Validator;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener{
    private ActivitySignUpBinding bind;
    private DatabaseClient client;
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind = ActivitySignUpBinding.inflate(getLayoutInflater());
        setContentView(bind.getRoot());

        pref = PreferenceManager.getDefaultSharedPreferences(this);
        editor = pref.edit();
        client = DatabaseClient.getInstance(this);
        bind.submit.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
       collectUserData();
    }

    private void collectUserData() {
        if (!Validator.validateInputText(bind.name) || !Validator.validateInputText(bind.phone)||
                !Validator.validateEmail(bind.emailAddress) || !Validator.validateInputText(bind.password)
                || !Validator.validPassword(bind.password, bind.confirmPassword)){
            return;
        }

        String useName = bind.name.getEditText().getText().toString().trim();
        String userPhone = bind.phone.getEditText().getText().toString().trim();
        String userEmail = bind.emailAddress.getEditText().getText().toString().trim();
        String userPassword = bind.password.getEditText().getText().toString().trim();

        editor.putString(Constants.USER_Name, useName).apply();
        editor.putString(Constants.USER_EMAIL, userEmail).apply();


        User user = new User(useName, userPhone, userEmail, userPassword);
        client.UserDao().addUser(user);
        Toast.makeText(this, "user successfully added", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();

    }
}