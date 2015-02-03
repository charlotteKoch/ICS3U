package com.bayviewglen.daytwo;

import java.util.Scanner;

public class Example2 {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Please enter width and height of the box: ");
		
		int width = keyboard.nextInt();
		int height = keyboard.nextInt();

		for (int i = 1; i <= width; i++) {
			System.out.print('*');
		}
		System.out.println();
		
		for (int j=1; j<=height-2; j++){
			System.out.print('*');
			for (int k=1; k<=width-2; k++){
				System.out.print(' ');
			}
			System.out.println('*');
		}

		for (int i = 1; i <=width; i++) {
			System.out.print('*');
		}
		
		keyboard.close();
	}

}
