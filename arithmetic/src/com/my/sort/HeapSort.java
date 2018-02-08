package com.my.sort;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class HeapSort {

	public static void main(String[] args){
		int[] arr = new int[]{76,21,61,93,75,101,34,43,};
		MinHeap_Sort(arr, arr.length);
		List<Integer> list = IntStream.of(arr).boxed().collect(Collectors.toList());
		list.stream().forEach(i->System.out.print(i + ","));
	}
	
	public static void MinHeap_Sort(int a[], int n) {
		int temp = 0;
		MakeMinHeap(a, n);

		for (int i = n - 1; i > 0; i--) {
			temp = a[0];
			a[0] = a[i];
			a[i] = temp;
			MinHeapFixdown(a, 0, i);
		}
	}

	public static void MakeMinHeap(int a[], int n) {
		for (int i = (n - 1) / 2; i >= 0; i--) {
			MinHeapFixdown(a, i, n);
		}
	}

	// 从i节点开始调整,n为节点总数 从0开始计算 i节点的子节点为 2*i+1, 2*i+2
	public static void MinHeapFixdown(int a[], int i, int n) {

		int j = 2 * i + 1; // 子节点
		int temp = 0;

		while (j < n) {
			// 在左右子节点中寻找最小的
			if (j + 1 < n && a[j + 1] < a[j]) {
				j++;
			}

			if (a[i] <= a[j])
				break;

			// 较大节点下移
			temp = a[i];
			a[i] = a[j];
			a[j] = temp;

			i = j;
			j = 2 * i + 1;
		}
	}
}
