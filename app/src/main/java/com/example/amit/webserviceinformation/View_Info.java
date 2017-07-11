package com.example.amit.webserviceinformation;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class View_Info extends AppCompatActivity {
    TextView textView;
    EditText email,mobile;
    String json_string;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view__info);
        email=(EditText)findViewById(R.id.email);
        mobile=(EditText)findViewById(R.id.mobile);
        textView=(TextView)findViewById(R.id.textjson);
    }
    public void view_Info(View view)
    {
        String Email,Mobile;
        Email=email.getText().toString();
        Mobile=mobile.getText().toString();
        String method="viewdata";
        BackgroundTask backgroundTask=new BackgroundTask(this);
        backgroundTask.execute(method,Email,Mobile);
        //email.setText(" ");
        //mobile.setText(" ");

    }
public void view_json(View view)
{
    String method="viewjson";
    MyTask myTask=new MyTask(this);
    myTask.execute(method);

}
public void Cleartext(View view)
{
    textView.setVisibility(View.INVISIBLE);
}
public void parsejson(View view)
{
 if(json_string==null){
     Toast.makeText(getApplicationContext(),"First get json",Toast.LENGTH_SHORT).show();
 }
 else
 {
     Intent intent=new Intent(this,DisplayListview.class);
     intent.putExtra("json_data",json_string);
     startActivity(intent);
 }


}

public class MyTask extends AsyncTask<String,Void,String>{
    Context context;

    public MyTask(Context context) {
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... params) {
        String json_url="http://10.0.2.2/webapp/json_get_data_info";
        String method=params[0];
        if(method.equals("viewjson")){
            try {
                URL url=new URL(json_url);
                HttpURLConnection httpURLConnection= (HttpURLConnection) url.openConnection();
                InputStream inputStream=httpURLConnection.getInputStream();
                InputStreamReader inputStreamReader=new InputStreamReader(inputStream);
                BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
                StringBuilder stringBuilder=new StringBuilder();
                String JSON_String=" ";
                while ((JSON_String=bufferedReader.readLine())!=null)
                {
                    stringBuilder.append(JSON_String+"\n");
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return stringBuilder.toString().trim();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String result) {
        textView.setText(result);
        textView.setVisibility(View.VISIBLE);
        json_string=result;

    }
}

}
