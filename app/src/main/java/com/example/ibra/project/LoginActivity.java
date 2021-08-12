package com.example.ibra.project;

//import android.app.ProgressDialog;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
/*
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
*/
//import com.google.firebase.internal.FirebaseAppHelper;

public class LoginActivity extends AppCompatActivity {

    //private ProgressDialog progressialog;
   // private FirebaseAuth firebaseauth;
    private EditText usernametext ;
    private EditText passwordtext;
    private TextView registertext;
    private CardView logincard ;
    private DatabaseHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        helper = new DatabaseHelper(this);

        registertext=findViewById(R.id.register_text);
        logincard=findViewById(R.id.login_card);



        usernametext= findViewById(R.id.username_text);
        passwordtext=findViewById(R.id.password_text);

        /*firebaseauth=FirebaseAuth.getInstance();
        if(firebaseauth.getCurrentUser()!=null){
            finish();
            startActivity(new Intent(LoginActivity.this,MainActivity.class));
        }

        progressialog=new ProgressDialog(this);*/
        logincard.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
try{
               // userLogin();

    String  una = usernametext.getText().toString().trim();
    String ears= passwordtext.getText().toString().trim();
    String password= helper.searchPass(una);

    try{
        Intent intent=new Intent(LoginActivity.this,MainActivity.class);
          startActivity(intent);
    }

//        if(ears.equals(password)){
//            Intent intent=new Intent(LoginActivity.this,MainActivity.class);
//            startActivity(intent);
//        }
//        else{
//            Toast.makeText(LoginActivity.this,"username and password not match",Toast.LENGTH_SHORT).show();
//            Intent intenta=new Intent(LoginActivity.this,LoginActivity.class);
//            startActivity(intenta);
//        }}
    catch (Exception e){
        e.printStackTrace();
    }
               }
                catch (Exception e){
                   e.printStackTrace();
                }

                }



        });
        registertext.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent=new Intent(LoginActivity.this,FormActivity.class);
                startActivity(intent);

            }
        });
        Log.i("HELLO","before");



    }

        /*if  (v.getId()==R.id.register_text) {
            Intent intent=new Intent(LoginActivity.this,FormActivity.class);
            startActivity(intent);

        }*/
    }

   /*@Override

    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = firebaseauth.getCurrentUser();
    }



    private void userLogin() {
        String email=emailtext.getText().toString().trim();
        String password=passwordtext.getText().toString().trim();
        if(TextUtils.isEmpty(password)){
            Toast.makeText(LoginActivity.this,"please enter Password",Toast.LENGTH_SHORT).show();
            return;


        }
        if(TextUtils.isEmpty(email)){
            Toast.makeText(LoginActivity.this,"please enter email",Toast.LENGTH_SHORT).show();
            return;


        }

        progressialog.setMessage("processing...");
        progressialog.show();
        firebaseauth.signInWithEmailAndPassword(email,password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override

                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressialog.dismiss();
                        finish();

                        Log.i("HELLO","1111111111111111111111");

                        if(task.isSuccessful()){
                            Log.i("HELLO","2222222222222");
                            FirebaseUser user = firebaseauth.getCurrentUser();

                            startActivity(new Intent(LoginActivity.this,MainActivity.class));




                        }

                        else {
                            // If sign in fails, display a message to the user.

                            Log.e("Signup Error", "onCancelled", task.getException());

                        }
                    }



                });


    }*/



