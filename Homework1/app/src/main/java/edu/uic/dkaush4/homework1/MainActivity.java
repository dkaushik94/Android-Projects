package edu.uic.dkaush4.homework1;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();

        final EditText textInput = (EditText) findViewById(R.id.editText);
        final TextView box = (TextView) findViewById(R.id.nameBox);

        textInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Log.i("Listener", textInput.getText().toString());

                box.setText(textInput.getText().toString() + "!");
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
    @Override
    public void onResume() {
        super.onResume();
        Log.i("OnResume function","FIRE FIRE FIRE!");

        //On Resuming Activity create eventlistener.
        final View.OnClickListener event = new View.OnClickListener(){
            public void onClick(View v){
                final EditText tBox = (EditText)findViewById(R.id.editText);
                //Checking if the text Field has input or not.
                if((tBox.getText().toString()).matches("")){
                    Toast.makeText(MainActivity.this , "Use the text field to input your name and then proceed!", Toast.LENGTH_LONG).show();
                }
                else {
                    Intent secondScreen = new Intent(MainActivity.this, SecondScreenActivity.class);
                    startActivity(secondScreen);
                }
            }
        };

        //Fetch Button and attach eventListener to it.
        final Button butt = (Button)findViewById(R.id.getStarted);
        butt.setOnClickListener(event);
    }
}
