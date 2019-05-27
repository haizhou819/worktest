package com.yhz.test.url;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

public class URLTest {
	public static void main(String[] args) throws IOException, JSONException {
		InputStream is = null;
		BufferedReader buffer = null;
		try {
			URL url = new URL("https://www.juxinli.com/api/access_report_token?client_secret=4j332l0dc0b43fgef2e32bf853e6ca0&hours=per&org_name=juxinli");
			URLConnection urlcon = url.openConnection();
	        is = urlcon.getInputStream();
	        
	        buffer = new BufferedReader(new InputStreamReader(is));
	        StringBuffer bs = new StringBuffer();
            String l = null;
	        while((l=buffer.readLine())!=null){
	            bs.append(l);
	        }
	        JSONObject jsonObject = new JSONObject(bs.toString());
	        String tokenStr = jsonObject.getString("access_token");
	        Map<String,Object> map = new HashMap<String,Object>();
	        Iterator<?> it = jsonObject.keys();
	        while(it.hasNext()){
	        	String key = (String)it.next();
	        	Object value = jsonObject.get(key);
	        	//System.out.println((String)v);
	        	map.put(key, value);
	        	
	        }
	        
	        for(String k : map.keySet()){
	        	System.out.println((String)map.get(k));
	        }
	        System.out.println(bs.toString());
	        System.out.println(tokenStr);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}finally{
			if(buffer != null)buffer.close();
			if(is != null)is.close();
		}
	}
}
