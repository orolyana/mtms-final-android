package com.example.ibra.project;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

//import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.auth.FirebaseUser;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    private CardView buyticket, payexpress, yourticket, viewtraffic, sharebutton, emergencycall;
    private NavigationView navigation;

  // private FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        mDrawerLayout = findViewById(R.id.drawer);
        buyticket = findViewById(R.id.buy_ticket);
        payexpress = findViewById(R.id.pay_express);
        yourticket = findViewById(R.id.your_ticket);
        viewtraffic = findViewById(R.id.view_traffic);

        emergencycall = findViewById(R.id.emergency_call);
        /*auth=FirebaseAuth.getInstance();

        if(auth.getCurrentUser()==null){
            finish();
            startActivity(new Intent(getApplicationContext(),LoginActivity.class));
        }
        FirebaseUser user=auth.getCurrentUser();*/
        final Activity activity = this;


    /*  sharebutton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent shareintent = new Intent(Intent.ACTION_SEND);
                shareintent.setType("text/plain");
                String sharebody = "your body here";
                String sharesub = "your subject here";
                shareintent.putExtra(Intent.EXTRA_SUBJECT, sharesub);
                shareintent.putExtra(Intent.EXTRA_TEXT, sharebody);
                startActivity(Intent.createChooser(shareintent, "share using"));
            }
        }
        );*/

        payexpress.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                IntentIntegrator integrator = new IntentIntegrator(activity);
                integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
                integrator.setPrompt("PAY WAY");
                integrator.setCameraId(0);
                integrator.setBeepEnabled(false);
                integrator.setBarcodeImageEnabled(false);
                integrator.initiateScan();


            }
        });
        buyticket.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);

            }
        });
        viewtraffic.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intenta= new Intent(MainActivity.this, Ticket.class);
                startActivity(intenta);

            }
        });
        yourticket.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intento = new Intent(MainActivity.this, Ticket.class);
                startActivity(intento);

            }
        });
        emergencycall.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("tel: +251966732395");
                Intent intent = new Intent(Intent.ACTION_DIAL, uri);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }


            }
        });
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navigation = (NavigationView) findViewById(R.id.navigation_view);
        navigation.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                int id = menuItem.getItemId();
                switch (id) {
                    case R.id.myaccount:
                        //Do some thing here
                        // add navigation drawer item onclick method here
                        break;
                    case R.id.setting:
                        Intent a = new Intent(getApplicationContext(), SettingsActivity.class);
                        startActivity(a);
                        break;

                    case R.id.share:
                        Intent sendIntent = new Intent();
                        sendIntent.setAction(Intent.ACTION_SEND);
                        sendIntent.putExtra(Intent.EXTRA_TEXT,
                                "Hey check out my app at: https://play.google.com/store/apps/details?id=com.google.android.apps.plus");
                        sendIntent.setType("text/plain");
                        startActivity(sendIntent);
                        //Do some thing here
                        // add navigation drawer item onclick method here
                        break;
                    case R.id.logout:
                        Intent k = new Intent(getApplicationContext(), LoginActivity.class);
                        startActivity(k);
                        //Do some thing here
                        // add navigation drawer item onclick method here
                        break;
                    case R.id.menharya_faq:
                        Intent l = new Intent(getApplicationContext(), About.class);
                        startActivity(l);
                        break;
                }
                return false;
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {
            if (result.getContents() == null) {
                Toast.makeText(this, "you cancelled the request", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, result.getContents(), Toast.LENGTH_LONG).show();
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }

    }
}
