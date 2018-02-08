package com.my.sort;

import java.util.Arrays;
import java.util.List;

/**
 * 快速排序
 * @author Administrator
 *
 */
public class QuickSort {

	public static void main(String[] args) {
		Integer[] arr = new Integer[]{7,2,6,9,7,3,4};
		List<Integer> list = Arrays.asList(arr);
		quickSort(list, 0, list.size()-1);
		list.stream().forEach(i->System.out.print(i + ","));
	}
	
	
	public static void quickSort(List<Integer> list, int l, int r){
		if(l<r){
			int left = l;
			int right = r;
			Integer key = list.get(left);
			while(left < right){
				//从右向左
				while(left < right && list.get(right).compareTo(key) >= 0){//加=，不然重复数字会死循环
					right--;
				}
				list.set(left, list.get(right));
				list.stream().forEach(i->System.out.print(i + ","));
				System.out.println();
				//从左向右
				while(left < right && list.get(left).compareTo(key) <= 0){//加=，不然重复数字会死循环
					left++;
				}
				list.set(right, list.get(left));
				list.stream().forEach(i->System.out.print(i + ","));
				System.out.println();
			}
			
			list.set(left, key);
			quickSort(list, l, left-1);
			quickSort(list, left+1, r);
		}
		
	}

}
