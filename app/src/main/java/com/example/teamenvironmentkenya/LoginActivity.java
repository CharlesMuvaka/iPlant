package com.example.teamenvironmentkenya;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Toast;

import com.example.teamenvironmentkenya.database.DatabaseClient;
import com.example.teamenvironmentkenya.databinding.ActivityLoginBinding;
import com.example.teamenvironmentkenya.models.Constants;
import com.example.teamenvironmentkenya.models.User;
import com.example.teamenvironmentkenya.models.Validator;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private ActivityLoginBinding bind;
    private List<User> allUsers;
    private SharedPreferences pref;
    private DatabaseClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(bind.getRoot());

        pref = PreferenceManager.getDefaultSharedPreferences(this);
        bind.submit.setOnClickListener(this);
        bind.forgot.setOnClickListener(this);
        bind.sign.setOnClickListener(this);
        allUsers = new ArrayList<>();
        client = DatabaseClient.getInstance(this);
        allUsers = client.UserDao().allUsers();

    }

    @Override
    public void onClick(View view) {
        if(view == bind.submit){
            Intent intent = new Intent(this, MainActivity.class);
            Toast.makeText(this, "successfully logged in", Toast.LENGTH_SHORT).show();
            startActivity(intent);

        }
        else if(view == bind.forgot){
            Toast.makeText(this, "functionality coming soon", Toast.LENGTH_SHORT).show();
        }else{
            startActivity(new Intent(this, SignUpActivity.class));
        }
    }

    private void validateUserData() {

        if(!Validator.validateInputText(bind.userName) || !Validator.validateInputText(bind.userPassword)){
            return;
        }

        String userName = bind.userName.getEditText().getText().toString().trim();
        String userPassword = bind.userPassword.getEditText().getText().toString().trim();

        for (User user:allUsers) {
            if (user.getName().equals(userName)){
                if (user.getPassword().equals(userPassword)){
                    Intent intent = new Intent(this, ShopActivity.class);
                    Toast.makeText(this, "successfully logged in", Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                }else {
                    bind.userPassword.setError("password doesn't match");
                }
            }else{
                bind.userName.setError("User doesn't exist");
                bind.userName.setErrorEnabled(true);
            }
        }

    }
}