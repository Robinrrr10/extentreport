package com.github.extentreport;

import java.io.IOException;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

/**
 * Hello world!
 *
 */
public class App 
{
    public Response callGetRequest( String url )
    {
        System.out.println( "Start" );
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();
        
        Response response = null;
        try {
			response = client.newCall(request).execute();
			//System.out.println("response is:" + response.body().toString());
			//System.out.println("response is:" + response.body().string());
		} catch (IOException e) {
			e.printStackTrace();
		}
        
        
        System.out.println( "End" );
        return response;
    }
}
