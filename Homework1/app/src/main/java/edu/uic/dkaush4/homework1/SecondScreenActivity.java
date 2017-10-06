package edu.uic.dkaush4.homework1;

import android.content.ComponentName;
import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.HashMap;

import static android.R.attr.data;
import static android.R.attr.protectionLevel;

public class SecondScreenActivity extends AppCompatActivity {

    public static final int CONTACT_SAVED = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.secondary_layout);
    }


    @Override
    public void onStart(){
        super.onStart();
        //Helper Instructions.
        Toast.makeText(this, "Use the text field to create  contact.", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onResume(){
        super.onResume();
        final View.OnClickListener e = new View.OnClickListener() {

            //Create EventListener and Attach it to create contact button to invoke Contacts app.
            @Override
            public void onClick(View view) {
                final EditText cName = (EditText)findViewById(R.id.editText2);

                //String qualifiers.
                String strName = cName.getText().toString();
                String[] splitStr = strName.trim().split("\\s+");

                if((cName.getText().toString()).matches("") || splitStr.length <= 1){
                    Toast.makeText(SecondScreenActivity.this, "Please provide a Contact Name to save or check input.", Toast.LENGTH_LONG).show();
                }
                else{
                    //Creating Intent for invoking Contact activity.
                    Intent invokeContacts = new Intent(Intent.ACTION_INSERT);
                    invokeContacts.setType(ContactsContract.Contacts.CONTENT_TYPE);

                    final EditText name = (EditText)findViewById(R.id.editText2);
                    final String contactName = name.getText().toString();

                    invokeContacts.putExtra(ContactsContract.Intents.Insert.NAME, contactName);
                    invokeContacts.putExtra("finishActivityOnSaveCompleted", true);

                    //Starting contact activity.
                    startActivityForResult(invokeContacts, CONTACT_SAVED);
                }
            }
        };

        //FEtching Button and setting created eventListener on it.
        final Button cContact = (Button)findViewById(R.id.createContact);
        cContact.setOnClickListener(e);
    }

    //Method to fetch intent result and trigger change in current activity.
    @Override
    protected void onActivityResult(int resultCode, int requestCode, Intent data){

        Log.i("Got result.", Integer.toString(requestCode));

        final TextView messageBox= (TextView)findViewById(R.id.mBox);
        if(requestCode == -1){
            //Can make a function for this and call it as a helper, but these conditional statement
            //are pretty simple.
            messageBox.setText("Contact saved!");
        }
        else{
            messageBox.setText("Contact was not saved!");
        }
    }
}
