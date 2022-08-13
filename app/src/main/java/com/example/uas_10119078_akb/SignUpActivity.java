package com.example.uas_10119078_akb;
//NIM : 10119078
//Nama : Adam Firdaus Darmawan
//Kelas : IF-2
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUpActivity extends AppCompatActivity {

    private EditText inputEmail, inputPassword;
    private Button btnSignIn,btnSignUp;
    private ProgressBar progressBar;

    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        auth = FirebaseAuth.getInstance();
        btnSignIn = (Button) findViewById(R.id.signin);
        btnSignUp = (Button) findViewById(R.id.signup);
        inputEmail = (EditText) findViewById(R.id.email);
        inputPassword = (EditText) findViewById(R.id.password);
        progressBar = (ProgressBar) findViewById(R.id.progressbar);

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = inputEmail.getText().toString().trim();
                String password = inputPassword.getText().toString().trim();

//                if (TextUtils.isEmpty(email)){
//                    Toast.makeText(SignUpActivity.this, "email tidak boleh kosong", Toast.LENGTH_SHORT).show();
//                }
                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(SignUpActivity.this, "password tidak boleh kosong", Toast.LENGTH_SHORT).show();
                }
                if(password.length() < 6){
                    Toast.makeText(SignUpActivity.this, "password minimal 6 karakter", Toast.LENGTH_SHORT).show();
                }

                progressBar.setVisibility(View.VISIBLE);

                auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(SignUpActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {


                        progressBar.setVisibility(View.GONE);

                        if (task.isSuccessful()){
                            Toast.makeText(SignUpActivity.this, "User berhasil dibuat", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(SignUpActivity.this, LoginActivity.class));
                            finish();

                        } else {
                            Toast.makeText(SignUpActivity.this, "Autentikasi gagal" + task.getException(), Toast.LENGTH_SHORT).show();

                        }
                    }
                });
            }
        });
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignUpActivity.this,LoginActivity.class));
            }
        });
    }
}

