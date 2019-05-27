package com.yhz.test.io;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
/**
 * 字节数组输出流
 * @author sunny
 *
 */
public class ByteArrayOutputStreamDemo {
	public static void main(String[] args) throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
        String s = "welcome to use ByteArrayOutputStreamDemo";
        byte[] buf = s.getBytes();  
        baos.write(buf); //将指定的byte数组写到字节数组输出流中
        System.out.println(baos.toString());  //将字节数组输出流内容转换成字符串输出
        //将字节数组输出流中的内容复制到字节数组中
        byte[] b = baos.toByteArray();
        for (int i = 0; i < b.length; i++) {
            System.out.print((char)b[i]);
        }
        baos.close();
	}
}
