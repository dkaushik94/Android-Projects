package edu.uic.dkaush4.project2;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;


public class Gallery extends AppCompatActivity {

    //Array to contain company names.
    private String[] carCompanies = new String[]{
            "Audi",
            "Rolls Royce",
            "Aston Martin",
            "Nissan",
            "Maserati",
            "Mercedes Benz",
            "Koenigsegg",
            "HotRod",
            "McLaren",
            "Pagani"
    };

    //List of all image for the car companies.
    private static int[] thumbnails = {
            R.drawable.audi_a8,
            R.drawable.rollsroyce_wraith,
            R.drawable.astonmartin_vulcan,
            R.drawable.nissa_gtr,
            R.drawable.maserati_quattroporte,
            R.drawable.mercedes_gla5w4,
            R.drawable.koenigsegg_agera,
            R.drawable.custom_hotrod,
            R.drawable.maclaren,
            R.drawable.pagani_zonda
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        final GridView grid = (GridView) findViewById(R.id.gridView);
        grid.setOnCreateContextMenuListener(this);

        registerForContextMenu(grid);
        grid.setAdapter(new GridAdapter(this, carCompanies, thumbnails));

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        menu.add(0, 1, 0, "View Image");
        menu.add(0, 2, 0, "Visit Website");
        menu.add(0, 3, 0, "Nearby Dealers");
        super.onCreateContextMenu(menu, v, menuInfo);
    }

        @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
            switch (item.getItemId()) {
            case 1:
                Toast.makeText(this, "Here you go!", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(Gallery.this, ImageLightBox.class);
                intent.putExtra("CAR_NAME", thumbnails[info.position]);
                intent.putExtra("MAP_NUMBER",info.position);
                startActivity(intent);
                break;
            case 2:
            {
                Toast.makeText(this, "Lets go web surfin'!", Toast.LENGTH_LONG).show();
                String[] url = getResources().getStringArray(R.array.urls);
                Intent goToBrowser = new Intent(Intent.CATEGORY_BROWSABLE);
                goToBrowser.setAction(Intent.ACTION_VIEW);
                goToBrowser.setData(Uri.parse(url[info.position]));
                startActivity(goToBrowser);
                break;
            }
            case 3:
                Toast.makeText(this, "Dealers for you!", Toast.LENGTH_LONG).show();
                Intent i = new Intent(Gallery.this, dealerships.class);
                i.putExtra("POSITION", info.position);
                startActivity(i);
                break;
        }
        return true;
    }

}
