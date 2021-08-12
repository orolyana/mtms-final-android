package com.example.ibra.project;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.ibra.project.R.id.show_destination;

public class Ticket extends AppCompatActivity {
    private TextView showdestination;
    DatabaseHelper helper=new DatabaseHelper(this);
    private TextView showstart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket);

       showstart=findViewById(R.id.show_start);
        showdestination=findViewById(R.id.show_destination);

        viewData();

        /*Cursor password=helper.viewTowns();
        showstart.setText(getIntent().getExtras().getString("start"));
        showdestination.setText(getIntent().getExtras().getString("destination"));*/
    }

    private void viewData() {


        Cursor res = helper.viewTowns();
        if (res.getCount()==0){
            Toast.makeText(Ticket.this,"ticket is not reserved",Toast.LENGTH_SHORT).show();
            return;
        }
        StringBuffer buffer=new StringBuffer();
        while(res.moveToNext()){
            showstart.setText(buffer.append("Start town is " + res.getString(0)));
            showdestination.setText(buffer.append("Destination Town is " + res.getString(1)));
        }
    }

}
