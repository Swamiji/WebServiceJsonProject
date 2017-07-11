package com.example.amit.webserviceinformation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DisplayListview extends AppCompatActivity {
String json_string;
    JSONArray jsonArray;
    JSONObject jsonObject;
    ContactAdapter contactAdapter;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_listview);
        contactAdapter=new ContactAdapter(this,R.layout.row);
        listView=(ListView)findViewById(R.id.displaylist);
        listView.setAdapter(contactAdapter);
        json_string=  getIntent().getExtras().getString("json_data");
        try {
            jsonObject=new JSONObject(json_string);
            jsonArray=jsonObject.getJSONArray("server response");

            int count=0;
            String name,email,mobile;

            while (count<jsonArray.length())
            {
                JSONObject JO=jsonArray.getJSONObject(count);
                name=JO.getString("name");
                email=JO.getString("email_id");
                mobile=JO.getString("mobile_number");
                Contacts contacts=new Contacts(name,email,mobile);
                contactAdapter.add(contacts);
                count++;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
