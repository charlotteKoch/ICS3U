package com.bayviewglen.daytwo;

public class Example1 {

	public static void main(String[] args) {

		int[] numbers = new int[10];

		int[] numbers2 = { 7, 5, 14, 22, 17, 18, 50, 42, 45, 10 };

		int[] numbers3 = new int[100];

		int size = 0;

		copyArray(numbers2, numbers);

		printEven(numbers);

		addLength(numbers3, size, 17);
		addLength(numbers3, size, 117);
		addLength(numbers3, size, 217);

		size = removeIgnoreOrder(numbers3, size, 1);
		
		size = removeKeepOrder(numbers3,size,1);
		
		System.out.println(numbers3);

	}

	private static int removeKeepOrder(int[] arr, int size, int index) {
		for (int i=index; i<size-1;i++){
			arr[i] = arr[i+1];
		}
		return --size; 
	}

	private static int removeIgnoreOrder(int[] numbers, int size, int i) {
		if (i <= 0 || i > size) {
			return size;
		} else{
			numbers[i] = numbers[--size];
			return size;
		}
	}

	private static int addLength(int[] arr, int size, int num) {
		if (size == arr.length) {
			return size;
		} else {
			arr[size++] = num;
			return size;
		}
	}

	public static void copyArray(int[] src, int[] destination) {
		for (int i = 0; i < src.length; i++) {
			destination[i] = src[i];
		}
	}

	public static void printEven(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % 2 == 0) {
				System.out.print(arr[i]);
			}
		}
	}
}
