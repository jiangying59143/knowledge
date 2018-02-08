package com.my.sort;

import java.util.Arrays;
import java.util.List;

public class ShellSort {
	public static void main(String[] args){
		Integer[] arr = new Integer[]{7,2,6,9,7,3,4};
		List<Integer> list = Arrays.asList(arr);
		shellSort(list);
		list.stream().forEach(i->System.out.print(i + ","));
	}
	
	public static void shellSort(List<Integer> list){
		int incre = list.size();
		while(true){
			incre = incre / 2;
			for(int k=0; k<incre; k++){
				for(int i=k+incre; i< list.size(); i+=incre){
					for(int j = i; j > k; j-= incre){
						if(list.get(j).compareTo(list.get(j-incre)) < 0){
							Integer temp = list.get(j-incre);
							list.set(j-incre, list.get(j));
							list.set(j, temp);
						}
					}
					list.stream().forEach(s->System.out.print(s + ","));
					System.out.println();
				}
			}
			if(incre == 1){
				break;
			}
		}
	}
}
