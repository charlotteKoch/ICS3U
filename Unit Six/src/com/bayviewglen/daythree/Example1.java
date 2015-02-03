package com.bayviewglen.daythree;

import java.util.ArrayList;

public class Example1 {

	public static void main(String[] args) {

		int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		ArrayList<Integer> numbers2 = new ArrayList<Integer>();

		numbers2.add(4);
		numbers2.add(14);
		numbers2.add(24);
		numbers2.add(34);
		numbers2.add(44);
		numbers2.add(54);
		numbers2.add(64);
		
		// for each loop -- cannot modify the collection 
		for (int element : numbers2) {
			numbers2.remove(2);
		}
		
		display(numbers); 

	}

	public static void display(int[] arr) {
		System.out.println("---");
		System.out.println("Display Starting");
		for (int element : arr) {
			System.out.println(element);
		}
		System.out.println("Display Ending");
		System.out.println("---");
	}
}
