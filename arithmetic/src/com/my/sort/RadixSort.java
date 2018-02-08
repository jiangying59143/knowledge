package com.my.sort;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RadixSort{

	public static void main(String[] args){
		int[] arr = new int[]{76,21,61,93,75,101,34,43,};
		radixSort(arr, new int[arr.length], arr.length, 3, 10, new int[10]);
		List<Integer> list = IntStream.of(arr).boxed().collect(Collectors.toList());
		list.stream().forEach(i->System.out.print(i + ","));
	}

	public static void radixSort(int A[],int temp[],int n,int k,int r,int cnt[]){
	
	   //A:原数组
	   //temp:临时数组
	   //n:序列的数字个数
	   //k:最大的位数2
	   //r:基数10
	   //cnt:存储bin[i]的个数
	
	   for(int i=0 , rtok=1; i<k ; i++ ,rtok = rtok*r){
		   System.out.println(i);
	       //初始化
	       for(int j=0;j<r;j++){
	           cnt[j] = 0;
	       }
	       //计算每个箱子的数字个数
	       for(int j=0;j<n;j++){
	           cnt[(A[j]/rtok)%r]++;
	           System.out.println(A[j] + " ========= " + rtok + " ============" + (A[j]/rtok)%r);
	       }
	       //cnt[j]的个数修改为前j个箱子一共有几个数字
	       for(int j=1;j<r;j++){
	           cnt[j] = cnt[j-1] + cnt[j];
	       }
	       for(int j = n-1;j>=0;j--){      //重点理解
	           cnt[(A[j]/rtok)%r]--;
	           temp[cnt[(A[j]/rtok)%r]] = A[j];
	       }
	       for(int j=0;j<n;j++){
	           A[j] = temp[j];
	       }
	   }
	}
}