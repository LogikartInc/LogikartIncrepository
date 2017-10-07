package com.example.chinmay.logikartinc;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Profile extends AppCompatActivity implements View.OnClickListener {

    private FirebaseAuth firebaseAuth;

    private TextView textViewuseremail;
    private Button buttonLogout;

    private DatabaseReference databaseReference;

    private EditText editTextName,editTextPhone,editTextAddress;
    private Button buttonsave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        firebaseAuth = FirebaseAuth.getInstance();

        if (firebaseAuth.getCurrentUser() == null)
        {
            finish();
            startActivity(new Intent(this,Login.class));
        }

        databaseReference = FirebaseDatabase.getInstance().getReference();

        editTextName = (EditText)findViewById(R.id.editTextName);
        editTextPhone = (EditText)findViewById(R.id.editTextPhone);
        editTextAddress = (EditText)findViewById(R.id.editTextAddress);
        buttonsave = (Button)findViewById(R.id.buttonsave);

        FirebaseUser user = firebaseAuth.getCurrentUser();

        textViewuseremail = (TextView) findViewById(R.id.textViewuseremail);

        textViewuseremail.setText("Welcome"+user.getEmail());

        buttonLogout = (Button) findViewById(R.id.buttonLogout);

        buttonLogout.setOnClickListener(this);
        buttonsave.setOnClickListener(this);

    }

    private void saveUserInformation(){

        String name =editTextName.getText().toString().trim();
        String phone =editTextPhone.getText().toString().trim();
        String address=editTextAddress.getText().toString().trim();

        UserInformation userInformation = new UserInformation(name,phone,address);

        FirebaseUser user = firebaseAuth.getCurrentUser();

        databaseReference.child(user.getUid()).setValue(userInformation);

        Toast.makeText(this,"Information Saved...", Toast.LENGTH_LONG).show();

        Intent intent=new Intent(this,MovingMap.class);
        startActivity(intent);



    }

    @Override
    public void onClick(View view) {

        if (view == buttonLogout){
            firebaseAuth.signOut();
            finish();
            startActivity(new Intent(this, Login.class));
        }
        if (view == buttonsave){
            saveUserInformation();
        }

    }
}
