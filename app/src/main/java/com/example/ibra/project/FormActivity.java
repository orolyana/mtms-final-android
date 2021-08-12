package com.example.ibra.project;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;
import android.os.Handler;

/*import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
//import com.google.firebase.auth.AuthResult;
//import com.google.firebase.auth.FirebaseAuth;*/

public class FormActivity extends AppCompatActivity {
    DatabaseHelper helper=new DatabaseHelper(this);
    private EditText nametext,phone, email, workplace, license,leveltext,passwordtext,banktext;
    private ProgressDialog progress;
    //private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        /*
        auth=FirebaseAuth.getInstance();

        if(auth.getCurrentUser()!=null){
            finish();
            startActivity(new Intent(getApplicationContext(),MainActivity.class));
        }*/
        CardView signupcard = findViewById(R.id.signup_card);
        nametext=findViewById(R.id.name_text);
        phone=findViewById(R.id.user_phone);
        license=findViewById(R.id.licenseno_text);
        email=findViewById(R.id.user_email);
        passwordtext=findViewById(R.id.password_text);
        workplace=findViewById(R.id.workplace_text);

        progress=new ProgressDialog(this);
        Log.i("HELLO","before form");
        signupcard.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                    registeruser();
                   Intent intent=new Intent(FormActivity.this,LoginActivity.class);
                   startActivity(intent);

            }
        });

    }

    private void registeruser(){
        String name=nametext.getText().toString().trim();
        String password=passwordtext.getText().toString().trim();
        String bank=banktext.getText().toString().trim();
        int b=Integer.parseInt(bank);
        String level=leveltext.getText().toString().trim();
        int l=Integer.parseInt(level);

        try{
            if(TextUtils.isEmpty(name)){
                Toast.makeText(FormActivity.this,"please enter Name",Toast.LENGTH_LONG).show();
                return;

            }
            if(TextUtils.isEmpty(password)){
                Toast.makeText(FormActivity.this,"please enter Password",Toast.LENGTH_LONG).show();
                return;


            }

            if(TextUtils.isEmpty(bank)){
                Toast.makeText(FormActivity.this,"please enter Bank Account",Toast.LENGTH_LONG).show();
                return;


            }
            if(TextUtils.isEmpty(level)){
                Toast.makeText(FormActivity.this,"please enter Level",Toast.LENGTH_LONG).show();


            }



            Contact c=new Contact();
            c.setName(name);
            c.setPass(password);
            c.setBank(b);
            c.setLevel(l);
            progress.setMessage("u are registering wait...");
            progress.show();
            helper.insertContact(c);

        }
 catch(Exception e){
     System.out.println(e);}

        /*

auth.createUserWithEmailAndPassword(phone,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
    @Override
    public void onComplete(@NonNull Task<AuthResult> task) {
        if(task.isSuccessful()){

                finish();
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
        else{
            Toast.makeText(FormActivity.this,"registaration failed, try again",Toast.LENGTH_SHORT).show();
        }

    }
});*/
    }}


