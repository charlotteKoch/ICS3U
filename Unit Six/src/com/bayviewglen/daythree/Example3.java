package com.bayviewglen.daythree;

public class Example3 {

	public static void main(String[] args) {

		int[][] triangleArray = new int[5][];

		for (int i = 0; i < triangleArray.length; ++i) {
			triangleArray[i] = new int[i];
		}

		display(triangleArray);

	}

	public static void display(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println("");
		}
	}
}
