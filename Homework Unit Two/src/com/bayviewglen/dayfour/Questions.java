package com.bayviewglen.dayfour;

import java.util.Scanner;

public class Questions {

	public static void main(String[] args) {

		int x = (int)(Math.random()*100)+1;
		System.out.println("A random number between one and one hundred is: " + x);
		
		int y = (int)(Math.random()*101)-50;
		System.out.println("A random number between negative -50 and 50 is: " + y);

		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("Please enter your first number: ");
		int numberOne = keyboard.nextInt();
		System.out.print("Please enter your second number: ");
		int numberTwo = keyboard.nextInt();
		String h = keyboard.nextLine();
		System.out.print(h);
		int dif= numberTwo-numberOne;
		int z = (int)(Math.random()*dif)+numberOne;
		System.out.println(z);
		
		System.out.print("Please press enter to roll a six sided dice: ");
		int dice=(int)(Math.random()*7);
		System.out.println(dice);
		
		System.out.print("Please enter a word: ");
		String a = keyboard.nextLine();
		int length = a.length();
		int b = (int)(Math.random()*length);
		String c = a.substring(b,b+1);
		System.out.println(c);
		
		int g = (int)(Math.random()*26)+65;
		char upper = (char)g;
		System.out.println(upper);
		
		int r = (int)(Math.random()*26)+97;
		char lower = (char)r;
		System.out.println(lower);
		
		keyboard.close();
	}

}
