package com.example.amit.webserviceinformation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Add_Info extends AppCompatActivity {
    EditText name,email_id,mobile_number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__info);
        name=(EditText)findViewById(R.id.name);
        email_id=(EditText)findViewById(R.id.email);
        mobile_number=(EditText)findViewById(R.id.mobile);
    }

    public void Save_Info(View view)
    {
        String NAME,EMAIL,MOBILE;
        NAME=name.getText().toString();
        EMAIL=email_id.getText().toString();
        MOBILE=mobile_number.getText().toString();
        String method="datainsertion";
        BackgroundTask backgroundTask=new BackgroundTask(this);
        backgroundTask.execute(method,NAME,EMAIL,MOBILE);
        finish();

    }
}
