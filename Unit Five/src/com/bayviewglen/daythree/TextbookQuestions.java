 package com.bayviewglen.daythree;

import java.text.DecimalFormat;
import java.util.Scanner;

public class TextbookQuestions {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);

		System.out.println("CubeRoots");
		cubeRoots();

		System.out.println("");
		System.out.println("SumSequence");

		sumSequence(keyboard);

		System.out.println("");
		System.out.println("Factorial");

		factorial(keyboard);

		System.out.println("");
		System.out.println("Fibonacci");

		fibonacci(keyboard);

		System.out.println("");
		System.out.println("Triangle");

		triangle();

		System.out.println("");
		System.out.println("Diamond");

		diamond();

		System.out.println("");
		System.out.println("CountDown");

		countDown(keyboard);

		System.out.println("");
		System.out.println("Point");

		point();

		System.out.println("");
		System.out.println("CalendarMonth");

		calendarMonth(keyboard);

		System.out.println("");
		System.out.println("Factors");

		factors(keyboard);

		keyboard.close();

	}

	public static void factors(Scanner keyboard) {
		System.out.print("Pleaser enter an integer: ");
		String userIn = keyboard.nextLine();

		int userInt = Integer.valueOf(userIn);

		for (int i = 1; i <= userInt; i++) {
			if (userInt % i == 0) {
				System.out.print(i + " ");
			}
		}
	}

	public static void calendarMonth(Scanner keyboard) {
		System.out.println("Please enter the day of the week that the month starts on (Sunday is 0): ");
		String weekDay = keyboard.nextLine();

		int weekDayInt = Integer.valueOf(weekDay);

		System.out.println("Please enter the number of days in the month: ");
		String dayNum = keyboard.nextLine();

		int dayNumInt = Integer.valueOf(dayNum);

		int dayMonth = 0;

		System.out.println("Sun\tMon\tTue\tWed\tThu\tFri\tSat");
		while (dayMonth < dayNumInt) {
			for (int i = 1; (i <= 7) && (dayMonth < dayNumInt); i++) {
				if (weekDayInt > 0) {
					System.out.print("\t");
					weekDayInt--;
				} else {
					dayMonth++;
					System.out.print(dayMonth + "\t");
				}
			}
			System.out.println("");
		}
	}

	public static void point() {
		int point = (int) (Math.random() * 6) + 1;
		System.out.println("Your point is: " + point);

		int roll = 0;
		int loopCount = 0;

		while (point != roll) {
			roll = (int) (Math.random() * 6) + 1;
			System.out.println(roll);
			loopCount++;
		}

		System.out.println("It took " + loopCount + " rolls to roll your point again");
	}

	public static void countDown(Scanner keyboard) {
		System.out.print("Please enter a number: ");
		int x = keyboard.nextInt();
		// eat rest of line
		keyboard.nextLine();
		
		for (int i = 100; i > x; i -= 5) {

			System.out.println(i);
		}
		System.out.println("I stopped");
	}

	public static void diamond() {
		for (int i = 1; i <= 4; i++) {
			for (int j = 1; j <= i * -1 + 5; j++) {
				System.out.print(" ");
			}
			for (int j = 1; j <= i * 2 - 1; j++) {
				System.out.print('*');
			}
			for (int j = 1; j <= i * -1 + 5; j++) {
				System.out.print(" ");
			}
			System.out.println(" ");
		}
		System.out.println("*********");
		for (int i = 1; i <= 4; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(" ");
			}
			for (int j = 1; j <= i * -2 + 9; j++) {
				System.out.print('*');
			}
			for (int j = 1; j <= i; j++) {
				System.out.print(" ");
			}
			System.out.println(" ");
		}
	}

	public static void triangle() {
		for (int i = 1; i <= 6; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print('*');
			}
			System.out.println("");
		}
	}

	public static void fibonacci(Scanner keyboard) {
		System.out.print("Please enter a number: ");
		int x = keyboard.nextInt();
		keyboard.nextLine();
		int y = 1;
		int z = 1;
		int a = 1;

		System.out.print(y + " " + z + " ");

		for (int i = 1; i <= x; i++) {
			a = y + z;
			y = z;
			z = a;
			System.out.print(z + " ");
		}
	}

	public static void factorial(Scanner keyboard) {
		System.out.print("Please enter a number: ");
		int x = keyboard.nextInt();
		keyboard.nextLine();
		int y = 1;

		for (int i = 2; i <= x; i++) {
			y *= i;
		}
		System.out.println(y);
	}

	public static void sumSequence(Scanner keyboard) {
		System.out.print("Please enter a number: ");
		int x = keyboard.nextInt();
		keyboard.nextLine();
		int y = 1;

		for (int i = 2; i <= x; i++) {
			y += i;
		}
		System.out.println(y);
	}

	public static void cubeRoots() {
		for (int i = 10; i <= 50; i++) {
			double num = Math.cbrt(i);
			DecimalFormat myFormatter = new DecimalFormat("##.####");
			String formatted = myFormatter.format(num);
			System.out.print(i + "\t" + formatted);
			System.out.println("");
		}
	}
}
