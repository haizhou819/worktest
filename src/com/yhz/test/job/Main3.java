package com.yhz.test.job;
/**
 * 最大子数组和问题
 * @author sunny
 *
 */
public class Main3 {
	//穷举法
	public int maxSubString(int[] arr){
		int max = 0;
		for(int i=0;i<arr.length;i++){
			int tempMax = 0;
			for(int j=i;j<arr.length;j++){
				tempMax +=arr[j];
				if(max < tempMax){
					max = tempMax;
				}
			}
		}
		return max;
	}
	
	public int maxSubString2(int[] arr){
		int n = arr.length;
		int nSum = arr[n - 1];
        int nAll = arr[n - 1];
        for(int i = n - 2; i >= 0; i--){    //从后向前遍历，反之亦可。
        	nSum = max( arr[i], arr[i] + nSum);  //保存临时最大值
            nAll = max(nSum, nAll);  //每次更新nSum之后，我们需要使用nSum与nAll进行比较，使得nAll保留着nSum的最大值。
        }
       return nAll;                       //nAll 中存放结果
	}
	
	public int maxSubString3(int[] arr){
		int nSum = arr[0];
		int nAll = arr[0];
		for(int i=1;i<arr.length;i++){//从前向后遍历，反之亦可。
			nSum = max(arr[i],nSum+arr[i]);
			nAll = max(nAll,nSum);
		}
		return nAll;
	}
	
	public int max(int a,int b){
		return a>b?a:b;
	}
	
	public static void main(String[] args) {
		Main3 m = new Main3();
		int A[] = {-1, 2, 3, 5,-4, 2};
		int result = m.maxSubString3(A);
		System.out.println(result);
	}
}
