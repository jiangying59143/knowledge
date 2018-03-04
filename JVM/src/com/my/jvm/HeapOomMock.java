package com.my.jvm;

import java.util.ArrayList;
import java.util.List;
/**
 * @run parameters
 * -javaagent:d:\workspace\java\knowledge\JVM\SizeOfObject.jar -Xms10M -Xmx20M -XX:MetaspaceSize=8M -XX:MaxMetaspaceSize=16M -XX:+PrintGC -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -XX:+PrintHeapAtGC -Xloggc:gc.log
 * @author Administrator
 *
 */
public class HeapOomMock {
	/**Bit（比特，一个二进制位，通信常用的单位 0,1）

		Byte（字节，由八个二进制位组成，是计算机中表示存储空间的最基本容量单位） K（千，存储空间的容量单位, kilobyte，1K=1024字节）
		
		M（兆，megabyte，1M=1024K）
		
		G（吉，gigabyte，1G=1024M）
		
		T（太，1T=1024G）
	**/
	
	//int 32bit=4byte 
	
	public static void main(String[] args) throws InterruptedException {
		List<int[]> list = new ArrayList<int[]>();
		Thread.sleep(5*1000);
		try {
			while(true) {
				Thread.sleep(1000);
				//剩余内存
				long initm=Runtime.getRuntime().freeMemory()/1024/1024;
				//总内存
				long totalm = Runtime.getRuntime().totalMemory()/1024/1024;
				System.out.println("free :" + initm + "M" + "---total : " + totalm + "M");//sysout，然后ALT+/ 
				list.add(new int[1024*1024/4]);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
