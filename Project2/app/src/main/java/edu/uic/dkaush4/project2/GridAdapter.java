package edu.uic.dkaush4.project2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.Image;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static android.R.attr.content;
import static android.R.attr.data;

/**
 * Created by debojitkaushik on 9/28/17.
 */

public class GridAdapter extends BaseAdapter{

    String [] carCompanies;
    Context context;
    int [] imgId;
    private static LayoutInflater inflator =null;

    public GridAdapter(Context context, String[] carCompany, int[] imgId){
        super();
        this.carCompanies = carCompany;
        this.imgId = imgId;
        this.context = context;
        inflator = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

//    @Override
//    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo
//            contextMenuInfo) {
//        // empty implementation
//    }

    @Override
    public int getCount(){
        return carCompanies.length;
    }

    @Override
    public Object getItem(int position){
       return position;
    }

    @Override
    public long getItemId(int position){
        return position;
    }

    public class Holder
    {
        TextView label;
        ImageView carImg;
    }

    @Override
    public View getView (final int position, final View convertView, ViewGroup parent){
        Holder holder = new Holder();
        View rowView;
        rowView = inflator.inflate(R.layout.grid_item_layout,null);
        holder.label = (TextView) rowView.findViewById(R.id.label);
        Bitmap bitmap = Bitmap.createBitmap(50, 50, Bitmap.Config.ARGB_8888);
        holder.carImg = (ImageView) rowView.findViewById(R.id.carImage);
        holder.carImg.setImageBitmap(bitmap);
        holder.label.setText(carCompanies[position]);
        holder.carImg.setImageResource(imgId[position]);

        final View.OnClickListener shortPress = new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(context, ImageLightBox.class);
                intent.putExtra("CAR_NAME", imgId[position]);
                intent.putExtra("MAP_NUMBER", position);
                context.startActivity(intent);
            }
        };

        rowView.setOnClickListener(shortPress);

        return rowView;
    }
}


