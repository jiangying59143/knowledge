package com.my.sort;

import java.util.Arrays;
import java.util.List;

public class SelectSort {
	public static void main(String[] args){
		Integer[] arr = new Integer[]{7,2,6,9,7,3,4};
		List<Integer> list = Arrays.asList(arr);
		selectSort(list);
		list.stream().forEach(i->System.out.print(i + ","));
	}
	
	public static void selectSort(List<Integer> list){
		for(int i=0; i<list.size()-1; i++){
			int k=i;
			for(int j=i+1; j<list.size(); j++){
				if(list.get(j).compareTo(list.get(k)) < 0){
					k=j;
				}
			}
			Integer temp = list.get(i);
			list.set(i, list.get(k));
			list.set(k, temp);
		}
	}
}
