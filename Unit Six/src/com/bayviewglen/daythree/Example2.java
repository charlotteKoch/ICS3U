package com.bayviewglen.daythree;

public class Example2 {

	public static void main(String[] args) {
		
		int[][] numbers = {{10,11,12,13},
		{14,15,16,17},
		{18,19,20,21},
		{22,23,24,25},
		{26,27,28,29}};
		
		display(numbers);

		int[][] numbers2 = {{0},{0}};
		
		for (int i=0; i!=5; i++){
			for (int j=0; i!=6; j++){
				System.out.println(numbers2[i][j]);
			}
		}
	}
	public static void display(int[][] arr) {
		System.out.println("---");
		System.out.println("Display Starting");
		for (int i = 0; i<5; i++){
			for (int j = 0; j<4; j++ ){
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println("");
		}
		System.out.println("Display Ending");
		System.out.println("---");
	}
}
	
