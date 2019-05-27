package com.yhz.test.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonUtils {
	public  static Map<String,Object> parseJSON2Map(String jsonStr){
		//最外层解析
		Map<String,Object> map = new HashMap<String,Object>();
		try {
			JSONObject json = new JSONObject(jsonStr);
			Iterator<?> it = json.keys();
			while(it.hasNext()){
				String key = (String)it.next();
				Object value = json.get(key);
				//如果内层还是数组，继续解析
				if(value instanceof JSONArray){
					List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
					JSONArray jsonArray = (JSONArray)value;
					for(int i=0;i<jsonArray.length();i++){
						JSONObject json2 = (JSONObject)jsonArray.get(i);
						list.add(parseJSON2Map(json2.toString()));
					}
					map.put(key, list);
				}
				map.put(key, value);
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return map;
	}
	
	public static void main(String[] args) {
		File file = new File("E:\\zhangjie.txt");
		BufferedReader buffer = null;
		StringBuffer sb = new StringBuffer(); 
		Map<String,Object> map = null;
		try{
			buffer = new BufferedReader(new FileReader(file));
			String line = null;
			while((line=buffer.readLine())!= null){
				sb.append(line);
			}
			String jsonStr = sb.toString();
			//JSONObject json = new JSONObject(jsonStr);
			Map<String,Object> objectMap = parseJSON2Map(jsonStr);
			//String objStr = (String)objectMap.get("report_data");
			JSONObject json = (JSONObject)objectMap.get("report_data");
			JSONArray json2 = (JSONArray)json.get("application_check");
			JSONArray json3 = (JSONArray)json.get("behavior_check");
			JSONObject json5 = (JSONObject)json3.get(0);
			String jsonStr11 = json5.getString("check_point");
			int len = json.length();
			System.out.println(jsonStr11);
			//JSONObject json3 = (JSONObject)json2.get(0);
			//JSONArray json4 = (JSONArray)json3.get("behavior");
			System.out.println(json3);
			
			/*JSONObject json1 = json.getJSONObject("report_data");
			JSONObject json2 = json1.getJSONObject("cell_behavior");
			String jsonStr1 = json2.getString("application_check");*/
			//System.out.println(jsonStr1);
			//map = parseJSON2Map(jsonStr);
			//JSONObject json2 = ((JSONObject)((JSONObject)json.get("report_data")).get("contact_region"));
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}










