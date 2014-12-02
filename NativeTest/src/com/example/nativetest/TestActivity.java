package com.example.nativetest;

import java.io.IOException;

import org.apache.http.*;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.os.Bundle;
import android.os.StrictMode;
import android.widget.TextView;

public class TestActivity extends Activity {

	
	 private static final String Urlstring="http://192.168.16.43:8888/devices/1";  
	 
	 private TextView txResult;  
	 
    @Override
    protected void onCreate(Bundle savedInstanceState) {

 
       super.onCreate(savedInstanceState);  
        
       setContentView(R.layout.activity_test);
       
  //     txResult = (TextView) findViewById(R.id.textView2);
       

        
        new Thread() {
        	@Override
        	public void run() {
        	// TODO Auto-generated method stub
        		
                String JSONString=connServerForResult(Urlstring);
                
                parseJson(JSONString);
                
           //     txResult.setText("jsonObj");
                
        	super.run();
        	}
        	}.start();
        
        
    }

    private String connServerForResult(String strUrl) { 


    HttpGet httpRequest = new HttpGet(strUrl); 


    
    String strResult = ""; 


    try { 



    HttpClient httpClient = new DefaultHttpClient(); 



    HttpResponse httpResponse = httpClient.execute(httpRequest); 


    
    if (httpResponse.getStatusLine().getStatusCode()  ==  HttpStatus.SC_OK)  
    { 


    	strResult = EntityUtils.toString(httpResponse.getEntity()); 
    	


    	} 


    	} catch (ClientProtocolException e) { 


    	e.printStackTrace(); 

    	} catch (IOException e) { 


    	e.printStackTrace(); 

    	} 

    	return strResult;
    }
    
    private void parseJson(String strResult) { 



    try { 


    JSONObject  jsonObj = new JSONObject(strResult); 


     TextView t1 = (TextView) findViewById(R.id.textView1);
    
    t1.setText("aaaaaaaaaaaaaaaaaaaaaaaaaa");


    } catch (JSONException e) { 

    System.out.println("Json parse error"); 

    e.printStackTrace();  
}
    }
}
    
