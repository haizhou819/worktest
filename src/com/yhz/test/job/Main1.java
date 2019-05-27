package com.yhz.test.job;

//Java版本 最近邻居
import java.awt.geom.Point2D;
import java.util.Scanner;

public class Main1 {

 static int[] getClosest(Point2D.Double[] points)
 {
     int[] result = new int[2];
     /* 在这里补充代码, 注意，要求result[0] < result[1] */
     /* distance = points[0].distance(points[1]) */
     double min = points[0].distance(points[1]);//默认第一个点与第二个点最近
     int p0 = 0;
     int p1 = 1;
     for(int i=0;i<points.length-1;i++){
    	 double tempMin = 0l;
    	 int j;
    	 for(j=i+1;j<points.length;j++){
    		 tempMin = points[i].distance(points[j]);
    	 }
    	 if(min > tempMin){
    		 min = tempMin;
    		 p0 = i;
    		 if(j == points.length){
    			 p1 = j-1;
    		 }else{
    			 p1 = j;
    		 }
    	 }
     }
    
     result[0] = p0;
     result[1] = p1;
     return result;
 }
 
 public static void main(String[] args) {
     Point2D.Double[] points;
     Scanner input = new Scanner(System.in);
     {
         int n = input.nextInt();
         input.nextLine();
         points = new Point2D.Double[n];
         for (int i = 0; i < n; ++i) {
             double x = input.nextDouble();
             double y = input.nextDouble();
             input.nextLine();
             points[i] = new Point2D.Double(x, y);
         }
     }
     int[] result = getClosest(points);
     System.out.printf("Closest points: %d, %d\n", result[0], result[1]);
 }
}