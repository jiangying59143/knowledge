package com.my.sort;

import java.util.Arrays;
import java.util.List;

public class BubbleSort {
	public static void main(String[] args){
		Integer[] arr = new Integer[]{7,2,6,9,7,3,4};
		List<Integer> list = Arrays.asList(arr);
		bubbleSort(list);
		list.stream().forEach(i->System.out.print(i + ","));
	}
	
	public static void bubbleSort(List<Integer> list){
		Integer temp;
		boolean flag;
		for(int i=0; i<list.size(); i++){
			flag = false;
			
			for(int j=list.size()-1; j>i; j--){
				if(list.get(j).compareTo(list.get(j-1)) < 0){
					temp = list.get(j);
					list.set(j, list.get(j-1));
					list.set(j-1, temp);
					flag = true;
				}
			}
			
			if(!flag)break;
		}
	}
}
