package com.hammoud.razan.razanfinal2018;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LogInActivity extends AppCompatActivity {
    private EditText etEmail1, etPassword1;
    private Button btnSignIn, btnSignUp;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        etEmail1=findViewById(R.id.etEmail1);
        etPassword1=findViewById(R.id.etPassward1);
        btnSignIn=findViewById(R.id.btnSignIn);
        btnSignUp=findViewById(R.id.btnSignUp);

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dataHundler();
            }
        });


        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LogInActivity.this,MainActivity.class);
                startActivity(i);
            }
        });
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(LogInActivity.this,SignUpActivity.class);
                startActivity(intent);
            }
        });
    }
    private void dataHundler() {
        boolean isOk= true; // if alla the fields filled well
        String email= etEmail1.getText().toString();
        String password= etPassword1.getText().toString();
        boolean isok = false;
        if (email.length()<4 || email.indexOf('@')<0 || email.indexOf('.')<0)
        {
            etEmail1.setError("worng Email");
            isok=false;
        }
        if (password.length()<8)
        {
            etPassword1.setError(" Have to be at least 8 char");
            isok=false;
        }

    }
    private void signIn(String email, String passw){
        FirebaseAuth auth=FirebaseAuth.getInstance();
        auth.signInWithEmailAndPassword(email,passw).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if(task.isSuccessful())
                {
                    Intent i = new Intent(LogInActivity.this,LogInActivity.class);
                    startActivity(i);
                    Intent intent = new Intent(LogInActivity.this,SignUpActivity.class);
                    startActivity(i);

                }

            }
        });

    }
}
