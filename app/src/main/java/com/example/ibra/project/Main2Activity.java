package com.example.ibra.project;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;


public class Main2Activity extends AppCompatActivity {
    DatabaseHelper helper=new DatabaseHelper(this);

    private Spinner startspinner, destinationspinner;
    private Button confirmbutton;
    private TextView birrtext;
    private ProgressDialog progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        birrtext=findViewById(R.id.birr_view);
        progress=new ProgressDialog(this);
        startspinner=findViewById(R.id.start_spinner);
        destinationspinner=findViewById(R.id.destination_spinner);
        confirmbutton =findViewById(R.id.confirm_button);
        ArrayAdapter<String> mydapter=new ArrayAdapter<String >(Main2Activity.this,android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.cities));
      mydapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        startspinner.setAdapter(mydapter);
        destinationspinner.setAdapter(mydapter);


        confirmbutton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
               payWay();




                // birrtext.setText("paid 30 Birr");
               // Intent intent = new Intent(Main2Activity.this,Ticket.class);
                //startActivity(intent);
               /* intent.putExtra("start",start);
                intent.putExtra("destination",destination);
                */

            }
        });

    }

    private void payWay() {
        try {
            String start= startspinner.getSelectedItem().toString().trim();
            String destination= destinationspinner.getSelectedItem().toString().trim();
            Contact c=new Contact();
            c.setStart(start);
            c.setDestination(destination);

            helper.insertTowns(c);
            progress.setMessage("u are paying..");
            progress.show();
            closeContextMenu();
        }
        catch (Exception e){
            System.out.println(e);

        }

    }
}
