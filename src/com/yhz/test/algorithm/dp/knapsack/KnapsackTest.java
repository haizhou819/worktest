package com.yhz.test.algorithm.dp.knapsack;

public class KnapsackTest {
	public static void main(String[] args) {
		KnapsackItem[] bags = new KnapsackItem[] { 
                new KnapsackItem(2,13), new KnapsackItem(1,10), 
                new KnapsackItem(3,24), new KnapsackItem(2,15), 
                new KnapsackItem(4,28), new KnapsackItem(5,33), 
                new KnapsackItem(3,20), new KnapsackItem(1, 8) 
        }; 
        int totalWeight = 12; 
        Knapsack kp = new Knapsack(bags, totalWeight); 
        kp.solve(); 
        System.out.println(" -------- 该背包问题实例的解: --------- "); 
        System.out.println("最优值：" + kp.getBestValue());  
        System.out.println("最优解[选取的背包]: "); 
        System.out.print(kp.getBestSolution()); 
        System.out.println("最优值矩阵："); 
        int[][] bestValues = kp.getBestValues(); 
        for (int i=0; i < bestValues.length; i++) { 
            for (int j=0; j < bestValues[i].length; j++) { 
                System.out.printf("%-5d", bestValues[i][j]); 
            } 
            System.out.println(); 
        } 
	}
}
