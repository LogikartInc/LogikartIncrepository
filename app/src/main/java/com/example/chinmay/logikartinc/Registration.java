package com.example.chinmay.logikartinc;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Registration extends AppCompatActivity implements View.OnClickListener{

    private Button buttonRegister;
    private EditText editTextEmail,editTextPassword,editTextConfirmPassword;
    private TextView textViewSignin;

    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        firebaseAuth = FirebaseAuth.getInstance();

        if (firebaseAuth.getCurrentUser() !=null){
            //profile activity here
            finish();
            startActivity(new Intent(getApplicationContext(),Profile.class));
        }

        buttonRegister =(Button) findViewById(R.id.buttonRegister);
        editTextEmail =(EditText) findViewById(R.id.editTextEmail);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        editTextConfirmPassword =(EditText) findViewById(R.id.editTextConfirmPassword);
        textViewSignin = (TextView) findViewById(R.id.textViewSignin);

        buttonRegister.setOnClickListener(this);
        textViewSignin.setOnClickListener(this);

        progressDialog = new ProgressDialog(this);

    }

    private void registerUser()
    {
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();
        String confirmpassword = editTextConfirmPassword.getText().toString().trim();

        if(TextUtils.isEmpty(email)){
            //email is empty.
            Toast.makeText(this,"Please Enter Email",Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(password)){
            //password is empty.
            Toast.makeText(this,"Please Enter Password",Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(confirmpassword)){
            //confirm password is empty.
            Toast.makeText(this,"Please Enter Confirm Password",Toast.LENGTH_SHORT).show();
            return;
        }

        progressDialog.setMessage("Registering User...");
        progressDialog.show();

        firebaseAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                        {
                            finish();
                                startActivity(new Intent(getApplicationContext(),Profile.class));

                        }
                        else
                        {
                            Toast.makeText(Registration.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

    }

    @Override
    public void onClick(View view) {
        if(view == buttonRegister)
        {
            registerUser();
        }
        if(view == textViewSignin)
        {
            //will open login activity;
            startActivity(new Intent(this,Login.class));
        }
    }
}
