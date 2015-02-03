package com.bayviewglen.daytwo;

public class Example1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		for (int i = 1; i <= 5; i++) {
			for (int j = 5 - i; j > 0; j--) {
				System.out.print('.');
			}
			System.out.print(i);
			for (int k = 1; k < i; k++) {
				System.out.print('.');
			}
			System.out.println();
		}

	}	

}
