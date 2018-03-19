package ro.pub.cs.systems.eim.lab04.contactsmanager;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.provider.ContactsContract;
import android.provider.SyncStateContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

import Constants.Constants;

public class ContactsManagerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts_manager);

        EditText phoneEdit = findViewById(R.id.phoneEdit);

        Intent intent = getIntent();
        if (intent != null) {
            String phone = intent.getStringExtra("ro.pub.cs.systems.eim.lab04.contactsmanager.PHONE_NUMBER_KEY");
            if (phone != null) {
                phoneEdit.setText(phone);
            } else {
                //Toast.makeText(this, getResources().getString(R.string.phone_error), Toast.LENGTH_LONG).show();
            }
        }
    }

    public void showContainer(View view) {
        LinearLayout layout = findViewById(R.id.secondContainer);
        Button button = findViewById(R.id.toggleButton);

        if(layout.getVisibility() == View.VISIBLE) {
            layout.setVisibility(View.INVISIBLE);
            button.setText("Show additional fields");
        }
        else if(layout.getVisibility() == View.INVISIBLE) {
            layout.setVisibility(View.VISIBLE);
            button.setText("Hide additional fields");
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        switch(requestCode) {
            case Constants.CONTACTS_MANAGER_REQUEST_CODE:
                setResult(resultCode, new Intent());
                finish();
                break;
        }
    }

    public void cancelButton(View view) {
        setResult(Activity.RESULT_CANCELED, new Intent());
        //finish();
    }

    public void saveData(View view) {


        Intent intent = new Intent(ContactsContract.Intents.Insert.ACTION);
        intent.setType(ContactsContract.RawContacts.CONTENT_TYPE);

        startActivityForResult(intent, Constants.CONTACTS_MANAGER_REQUEST_CODE);

/*
        EditText nameEdit = findViewById(R.id.nameEdit);
        EditText phoneEdit = findViewById(R.id.phoneEdit);
        EditText emailEdit = findViewById(R.id.emailEdit);
        EditText addressEdit = findViewById(R.id.addressEdit);
        EditText jobEdit = findViewById(R.id.jobEdit);
        EditText companyEdit = findViewById(R.id.companyEdit);
        EditText websiteEdit = findViewById(R.id.websiteEdit);
        EditText imEdit = findViewById(R.id.imEdit);

        String name = nameEdit.getText().toString();
        String phone = phoneEdit.getText().toString();
        String email = emailEdit.getText().toString();
        String address = addressEdit.getText().toString();
        String jobTitle = jobEdit.getText().toString();
        String company = companyEdit.getText().toString();
        String website = websiteEdit.getText().toString();
        String im = imEdit.getText().toString();

        if (name != null) {
            intent.putExtra(ContactsContract.Intents.Insert.NAME, name);
        }
        if (phone != null) {
            intent.putExtra(ContactsContract.Intents.Insert.PHONE, phone);
        }
        if (email != null) {
            intent.putExtra(ContactsContract.Intents.Insert.EMAIL, email);
        }
        if (address != null) {
            intent.putExtra(ContactsContract.Intents.Insert.POSTAL, address);
        }
        if (jobTitle != null) {
            intent.putExtra(ContactsContract.Intents.Insert.JOB_TITLE, jobTitle);
        }
        if (company != null) {
            intent.putExtra(ContactsContract.Intents.Insert.COMPANY, company);
        }
        ArrayList<ContentValues> contactData = new ArrayList<ContentValues>();
        if (website != null) {
            ContentValues websiteRow = new ContentValues();
            websiteRow.put(ContactsContract.Data.MIMETYPE, ContactsContract.CommonDataKinds.Website.CONTENT_ITEM_TYPE);
            websiteRow.put(ContactsContract.CommonDataKinds.Website.URL, website);
            contactData.add(websiteRow);
        }
        if (im != null) {
            ContentValues imRow = new ContentValues();
            imRow.put(ContactsContract.Data.MIMETYPE, ContactsContract.CommonDataKinds.Im.CONTENT_ITEM_TYPE);
            imRow.put(ContactsContract.CommonDataKinds.Im.DATA, im);
            contactData.add(imRow);
        }
        intent.putParcelableArrayListExtra(ContactsContract.Intents.Insert.DATA, contactData);
        startActivity(intent);

        */
    }
}
