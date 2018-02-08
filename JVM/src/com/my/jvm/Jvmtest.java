package com.my.jvm;

import java.util.ArrayList;
import java.util.List;

import com.my.size.SizeOfObject;

public class Jvmtest {
	/**Bit（比特，一个二进制位，通信常用的单位 0,1）

		Byte（字节，由八个二进制位组成，是计算机中表示存储空间的最基本容量单位） K（千，存储空间的容量单位, kilobyte，1K=1024字节）
		
		M（兆，megabyte，1M=1024K）
		
		G（吉，gigabyte，1G=1024M）
		
		T（太，1T=1024G）
	**/
	
	//int 32bit=4byte 
	private static int[] intArr = new int[1024*1024/4];
	
	public static void main(String[] args) throws InterruptedException {
		List<int[]> list = new ArrayList<int[]>();
		Jvmtest jt = new Jvmtest();
		Thread.sleep(5*1000);
		try {
			while(true) {
				Thread.sleep(1000);
				long initm=Runtime.getRuntime().freeMemory()/1024/1024;
				long totalm = Runtime.getRuntime().totalMemory()/1024/1024;
				System.out.println("free :" + initm + "M" + "---total : " + totalm + "M");//sysout，然后ALT+/ 
				list.add(new int[1024*1024/4]);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
