package edu.uic.dkaush4.project2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by debojitkaushik on 10/5/17.
 */

public class dealerships extends AppCompatActivity {
    private String[][] dealers =  {
            {"Fletcher Jones" , "Greater Chicago Motors" , "Audi Morton Grove"},
            {"Windy City Motors" , "Bentley Gold Coast" , "Rolls Royce gold Coast"},
            {"CARZINC" , "Napleton's Aston Martin of Chicago" , "Aston Martin Greater Chicago"},
            {"The Autobarn Nissan of Evanston" , "CarMax" , "Berman Nissan of Chicago"},
            {"Bettenhausen Maserati" , "MASERATI OF CHICAGO" , "CARZINC"},
            {"Mercedes-Benz of Chicago" , "Loeber Motors" , "West End Auto Sales"},
            {"Lake Forest Sportscars" , "CARZINC" ,"McLaren Chicago Showroom"},
            {"Street Rods" , "CARZINC" , "Route 31 Auto Sales"},
            {"McLaren Chicago" , "CARZINC" , "Greater Chicago Automobiles"},
            {"Pagani Chicago" , "Sports cars Chicago" , "Pagani Inc"}
    };

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dealership_activity);
        Intent intent = getIntent();
        final int position = intent.getIntExtra("POSITION", 0);
        Log.i("Print Position", String.valueOf(position));
        String[] dealers = this.dealers[position];
        final ListView lv = (ListView)findViewById(R.id.listView);
        ArrayAdapter<String> itemsAdapter = new ArrayAdapter<String>(this, R.layout.listitem, dealers);
        lv.setAdapter(itemsAdapter);

        final ListView.OnItemClickListener clickEvent = new ListView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(dealerships.this , "No Dice! This is the end.", Toast.LENGTH_SHORT).show();
            }
        };

        lv.setOnItemClickListener(clickEvent);
    }
}
