package com.yhz.test.algorithm.dp.knapsack;

public class KnapsackItem {
	 private int weight; //物品重量 
    private int value; //物品价值
    
    public KnapsackItem(int weight, int value) { 
        this.value = value; 
        this.weight = weight; 
    } 
    public int getWeight() { 
        return weight; 
    } 
       
    public int getValue() { 
        return value; 
    } 
       
    public String toString() { 
        return "[weight: " + weight + " " + "value: " + value + "]";   
    } 
}
