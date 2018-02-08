package com.my.sort;

import java.util.Arrays;
import java.util.List;

public class MergeSort {
	public static void main(String[] args){
		Integer[] arr = new Integer[]{7,2,6,9,7,3,4,5};
		mergeSort(arr, 0, arr.length-1, new Integer[arr.length]);
		List<Integer> list = Arrays.asList(arr);
		list.stream().forEach(i->System.out.print(i + ","));
	}
	
	public static void mergeSort(Integer[] arr, int first, int last, Integer[] temp){
		if(first < last){
			int mid = (first + last)/2;
			System.out.println("mergeSort " + first + " " + last);
			mergeSort(arr, first, mid, temp);
			mergeSort(arr, mid+1, last, temp);
			mergeArr(arr, first, mid, last, temp);
		}
	}
	
	public static void mergeArr(Integer[] arr, int first, int mid, int end, Integer[] temp){
		System.out.println("mergeArr " + first + " " + end);
		int f = first;
		int m = mid;
		int g = m+1;
		int n = end;
		int k=0;
		
		while(f <= m && g <= n){
			if(arr[f].compareTo(arr[g]) > 0){
				temp[k] = arr[g];
				g++;
				k++;
			}else{
				temp[k] = arr[f];
				f++;
				k++;
			}
		}
		
		while(f <= m){
			temp[k] = arr[f];
			f++;
			k++;
		}
		
		while(g <= n){
			temp[k] = arr[g];
			g++;
			k++;
		}
		
		for(int i=0; i < k; i++){
			arr[i+first] = temp[i];
		}
		
	}
}
