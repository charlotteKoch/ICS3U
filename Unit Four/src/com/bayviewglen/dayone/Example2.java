package com.bayviewglen.dayone;

import java.util.Scanner;

public class Example2 {

	public static void main(String[] args) {
	Scanner keyboard = new Scanner(System.in);
		
		System.out.print("Please enter two integers: ");
		int x = keyboard.nextInt();
		int y = keyboard.nextInt();
		
		int low, high;
		
		if (x>y) {
			low = y;
			high = x;
		}else{
			low = x;
			high = y;
		}
		
		int sum = 0;
		for(int z=low; z<=high; z++){
			sum+=z;
		}
		
		System.out.println(sum);
	}

}
