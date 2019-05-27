package com.yhz.test.job.worksApp;
/**
 * 
 * @author sunny
 *
 */
//多段图求最短路径
class Cost{
      int C=0;
      int costId=0;
      public Cost(){}
      public Cost(int C,int costC,int id){
              this.C=C+costC;
              this.costId=id;
      }
}

public class Graphic {
      static int node[][]={
                 //0,1,2,3,4,5,6,7,8,9
                      {0,4,1,0,0,0,0,0,0,0},
                      {0,0,0,0,9,8,0,0,0,0},
                      {0,0,0,1,0,7,8,0,0,0},
                      {0,0,0,0,0,4,7,0,0,0},
                      {0,0,0,0,0,0,0,5,6,0},
                      {0,0,0,0,0,0,0,8,6,0},
                      {0,0,0,0,0,0,0,0,5,0},
                      {0,0,0,0,0,0,0,0,0,7},
                      {0,0,0,0,0,0,0,0,0,3},
                      {0,0,0,0,0,0,0,0,0,0}
      };
      static Cost [] cost=new Cost[10];
      static Cost [] dis=new Cost[10];
      static int [] path=new int[10];
      public static int C(int a,int b){
              return node[a][b];
      }//
      public static void show(){
              for(int i=0;i<node.length;i++){
                      for(int j=0;j<node[i].length;j++){
                              System.out.print(node[i][j]+" ");
                      }
                      System.out.println();
              }
      }//
      public static void initCost(){
              for(int i=0;i<cost.length;i++){
              cost[i]=new Cost();
      }
      }//
      public static void initDis(){
              for(int i=0;i<dis.length;i++){
              dis[i]=new Cost();
      }
      }//
      public static int plength(Cost dis[]){
              int num=0;
              for(int i=0;i<dis.length;i++){
                      if(dis[i].C==0){
                              num=i;
                              break;
                      }
              }
              return num;
      }
      public static int plength(int dis[]){
              int num=0;
              for(int i=0;i<dis.length;i++){
                      if(dis[i]==0){
                              num=i;
                              break;
                      }
              }
              return num;
      }
      public static Cost min(Cost dis[],int length){//取最小值
              Cost m=new Cost();
              m.C=9999;
              for(int i=0;i<length;i++){
                 if(dis[i].C<m.C){
                         m.C=dis[i].C;
                         m.costId=dis[i].costId;
                 }
              }
              return m;
      }//
      
      public static int[] goPoints(int start){//返回可到达哪些点
              int [] p={0,0,0,0,0,0,0,0,0,0};
              int counter=0;
              for(int y=0;y<node[start].length;y++){
                         if(node[start][y]!=0){
                                p[counter]=y;
                                counter++;
                     }
              }
              return p;
      }//
      ////////////////////////////////////////////////////////////////////////
      public static void process(){//核心算法
              initCost();
              for(int i=8;i>=0;i--){
              initDis();
                      for(int j=0;j<plength(goPoints(i));j++){  
                              int [] p=goPoints(i);
              dis[j]=new Cost(C(i,p[j]),cost[p[j]].C,p[j]);
                      }
      //
      cost[i]=min(dis,plength(dis));
      path[i]=cost[i].costId;
              }
      }//
      public static void output(){//输出 距离 及 路径
              System.out.println("0-9最短距离为："+cost[0].C);
              System.out.println("路径如下：");
              int t=path[0];
              System.out.print("0"+"-");
              do{
                      System.out.print(t+"-");
                      t=path[t];
              }while(t<9);
              System.out.print("9");
      }
      ////////////////////////////////////////////////////////////////////////
      public static void main(String[] args){
              show();
              process();
              for(int i=0;i<cost.length;i++){
              System.out.println("cost"+i+":"+cost[i].C+"   "+"path"+i+":"+path[i]);
      }
              output();
    
      }

}
