package com.my.basics;

import com.my.size.SizeOfObject;

public class Basics {
	public static void main(String[] args) {            
        System.out.println("Byte: " + Byte.SIZE/8 +"byte");                 // 1    
        System.out.println("Character: " + Character.SIZE/8 +"byte");       // 2 
        System.out.println("Short: " + Short.SIZE/8 +"byte");               // 2 
        System.out.println("Integer: " + Integer.SIZE/8 +"byte");           // 4
        System.out.println("Long: " + Long.SIZE/8 +"byte");                 // 8
        System.out.println("Float: " + Float.SIZE/8 +"byte");               // 4    
        System.out.println("Double: " + Double.SIZE/8 +"byte");             // 8    
        System.out.println("Boolean: " + 1 +"bit");
        System.out.println("Object : " + SizeOfObject.sizeOf(new Basics())/8 +"byte");
	}
}
