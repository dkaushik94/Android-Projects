package edu.uic.dkaush4.project2;

import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by debojitkaushik on 10/3/17.
 */

public class ImageLightBox extends AppCompatActivity {

    protected String [] urls = {
            "http://www.audi.com/en.html",
            "https://www.rolls-roycemotorcars.com/en-GB/home.html",
            "https://global.astonmartin.com/en-us/",
            "https://www.nissanusa.com/",
            "http://www.maseratiusa.com/maserati/us/en",
            "https://www.mbusa.com/mercedes/index",
            "http://koenigsegg.com/",
            "http://www.hotrodsproducts.com/productinfo.aspx",
            "http://cars.mclaren.com/",
            "http://www.pagani.com/"
    };

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.light_box_view);
        final int position = getIntent().getIntExtra("CAR_NAME", 1);
        final int mapNumber = getIntent().getIntExtra("MAP_NUMBER", 1);

        final View.OnClickListener shortPressEvent = new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent goToBrowser = new Intent(Intent.CATEGORY_BROWSABLE);
                goToBrowser.setAction(Intent.ACTION_VIEW);
                goToBrowser.setData(Uri.parse(urls[Integer.valueOf(mapNumber)]));
                startActivity(goToBrowser);
            }
        };

        final ImageView imgView = (ImageView)findViewById(R.id.imageView);
        imgView.setOnClickListener(shortPressEvent);
        imgView.setImageResource(position);
    }
}
