package com.yhz.test.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;


public class TestIo {
	public static void main(String[] args) {
		fileWR();
	}
	//与控制台相关的读写
	public static void consoleWR(){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try{
			while(true){
				String str = br.readLine();
				System.out.println(str);
			}
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			if(br != null){
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	//与文件相关的读写
	public static void fileWR(){
		FileReader fr = null;
		FileWriter fw = null;
		BufferedReader br = null;
		BufferedWriter bw = null;
		//PrintWriter pw = null;
		try {
			fr = new FileReader("d:\\test\\hello.txt");
			fw = new FileWriter("d:\\test\\ok.txt");
			br = new BufferedReader(fr);
			//pw = new PrintWriter(fw);
			bw = new BufferedWriter(fw);
			String str;
		    while((str=br.readLine())!=null){
		    	System.out.println(str);
		    //	pw.println(str);
		    	bw.write(str);
		    	//bw.newLine();//换行
		    	bw.write("\r\n");//换行
		    }
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			if(br != null){
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(bw != null){
				try {
					bw.flush();
					bw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			/*if(pw != null){
				pw.flush();
				pw.close();
			}*/
		}
	}
}
