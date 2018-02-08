package com.my.sort;

import java.util.Arrays;
import java.util.List;

public class InsertSort {

	public static void main(String[] args) {
		Integer[] arr = new Integer[]{7,2,6,9,7,3,4};
		List<Integer> list = Arrays.asList(arr);
		insertSort(list);
		list.stream().forEach(i->System.out.print(i + ","));

	}
	
	public static void insertSort(List<Integer> list){
		//i<list.size()-1; warn
		for(int i=0; i<list.size()-1; i++){
			//j=i+1; j > 0; warn
			for(int j=i+1; j > 0; j--){
				if(list.get(j).compareTo(list.get(j-1)) < 0){
					Integer temp = list.get(j-1);
					list.set(j-1, list.get(j));
					list.set(j, temp);
				}else{
					break;
				}
			}
		}
	}

}
