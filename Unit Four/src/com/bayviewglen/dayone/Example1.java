/*
 * Example: while loop without an if statement
 * 
 * Write a program that will sum all of the number between two numbers that the user enters
 */
package com.bayviewglen.dayone;

import java.util.Scanner;

public class Example1 {

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
		
		int sum=0;
		while(low<=high){
			low++;    //sum=low+1
			sum+=low; //sum=sum+1ow
		}
	}

}
