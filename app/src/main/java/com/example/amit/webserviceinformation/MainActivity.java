package com.example.amit.webserviceinformation;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.net.ConnectivityManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button add_info,view_info;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        add_info=(Button)findViewById(R.id.addinfo);
        view_info=(Button)findViewById(R.id.viewinfo);
        textView=(TextView)findViewById(R.id.textView);
        ConnectivityManager connectivityManager= (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo=connectivityManager.getActiveNetworkInfo();
        if(networkInfo!=null&&networkInfo.isConnected()){
            textView.setVisibility(View.INVISIBLE);
        }
        else
        {
            add_info.setEnabled(false);
            view_info.setEnabled(false);
        }
    }
    public void add_info(View view)
    {
        Intent intent=new Intent(this,Add_Info.class);
        startActivity(intent);
    }
    public void view_contact(View view)
    {
        Intent intent=new Intent(this,View_Info.class);
        startActivity(intent);
    }

}
