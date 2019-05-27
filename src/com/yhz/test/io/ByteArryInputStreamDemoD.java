package com.yhz.test.io;

import java.io.ByteArrayInputStream;
import java.io.IOException;
/**
 * 字节数组输入流
 * @author sunny
 *
 */
public class ByteArryInputStreamDemoD {
	public static void main(String[] args) throws IOException {
         String str = "abcdefghijk";
         byte[] strBuf = str.getBytes();  //字符串转换成字节数组
         ByteArrayInputStream bais = new ByteArrayInputStream(strBuf);
         int data = bais.read();          //从字节数组输入流读取字节
         while(data!=-1){
             char upper = Character.toUpperCase((char)data);
             System.out.print(upper+" ");
             data = bais.read();
         }
         bais.close();
	}
}
