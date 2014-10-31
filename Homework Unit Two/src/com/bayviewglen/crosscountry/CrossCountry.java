/*
 * Charlotte Koch
 * ICS3U AP
 * Cross Country Assignment
 * This program is to help the Bayview Glen cross country team track their team's running times.
 * Due: October 31,2014
 * Mr. Deslauriers
 */
package com.bayviewglen.crosscountry;

import java.text.DecimalFormat;
import java.util.Scanner;

public class CrossCountry {

	public static final int SECONDS_PER_MINUTE = 60;

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);

		// get runner 1 information and extract first name
		System.out.print("Please enter your first and last name: ");
		String runner1Name1 = keyboard.nextLine();
		String runner1Name2 = runnerName(runner1Name1);
		System.out.println("Please enter all times in the format: min:sec.millisec");
		System.out.print(runner1Name2 + ", please enter your one mile time: ");
		String runner1Mile1 = keyboard.nextLine();
		System.out.print(runner1Name2 + ", please enter your time to the end of the second mile: ");
		String runner1Mile2 = keyboard.nextLine();
		System.out.print(runner1Name2 + ", please enter your total time to complete your 5km run: ");
		String runner1Time = keyboard.nextLine();

		// convert runner 1 information in to splits
		double runner1Split1 = convertToSeconds(runner1Mile1);
		double runner1Split2 = convertToSeconds(runner1Mile2) - runner1Split1;
		double runner1Split3 = convertToSeconds(runner1Time) - (runner1Split1 + runner1Split2);

		// format runner 1 splits
		int runner1Split1Min = (int) runner1Split1 / SECONDS_PER_MINUTE;
		String runner1Split1Sec = numberFormat(runner1Split1 % SECONDS_PER_MINUTE);
		int runner1Split2Min = (int) runner1Split2 / SECONDS_PER_MINUTE;
		String runner1Split2Sec = numberFormat(runner1Split2 % SECONDS_PER_MINUTE);
		int runner1Split3Min = (int) runner1Split3 / SECONDS_PER_MINUTE;
		String runner1Split3Sec = numberFormat(runner1Split3 % SECONDS_PER_MINUTE);
		int runner1TimeMin = (int) (runner1Split1 + runner1Split2 + runner1Split3) / SECONDS_PER_MINUTE;
		String runner1TimeSec = numberFormat((runner1Split1 + runner1Split2 + runner1Split3) % SECONDS_PER_MINUTE);
		System.out.print("\n");

		// print runner 1 summary
		System.out.println(runner1Name1 + " run summary: ");
		System.out.println("Split 1: " + runner1Split1Min + ":" + runner1Split1Sec);
		System.out.println("Split 2: " + runner1Split2Min + ":" + runner1Split2Sec);
		System.out.println("Split 3: " + runner1Split3Min + ":" + runner1Split3Sec);
		System.out.println("Total time: " + runner1TimeMin + ":" + runner1TimeSec);
		System.out.print("\n");

		// get runner 2 information and extract first name
		System.out.print("Please enter your first and last name: ");
		String runner2Name1 = keyboard.nextLine();
		String runner2Name2 = runnerName(runner2Name1);
		System.out.println("Please enter all times in the format: min:sec.millisec");
		System.out.print(runner2Name2 + ", please enter your one mile time: ");
		String runner2Mile1 = keyboard.nextLine();
		System.out.print(runner2Name2 + ", please enter your time to the end of the second mile: ");
		String runner2Mile2 = keyboard.nextLine();
		System.out.print(runner2Name2 + ", please enter your total time to complete your 5km run: ");
		String runner2Time = keyboard.nextLine();

		// convert runner 2 information in to splits
		double runner2Split1 = convertToSeconds(runner2Mile1);
		double runner2Split2 = convertToSeconds(runner2Mile2) - runner2Split1;
		double runner2Split3 = convertToSeconds(runner2Time) - (runner2Split1 + runner2Split2);

		// format runner 2 splits
		int runner2Split1Min = (int) runner2Split1 / SECONDS_PER_MINUTE;
		String runner2Split1Sec = numberFormat(runner2Split1 % SECONDS_PER_MINUTE);
		int runner2Split2Min = (int) runner2Split2 / SECONDS_PER_MINUTE;
		String runner2Split2Sec = numberFormat(runner2Split2 % SECONDS_PER_MINUTE);
		int runner2Split3Min = (int) runner2Split3 / SECONDS_PER_MINUTE;
		String runner2Split3Sec = numberFormat(runner2Split3 % SECONDS_PER_MINUTE);
		int runner2TimeMin = (int) (runner2Split1 + runner2Split2 + runner2Split3) / SECONDS_PER_MINUTE;
		String runner2TimeSec = numberFormat((runner2Split1 + runner2Split2 + runner2Split3) % SECONDS_PER_MINUTE);
		System.out.println();

		// print runner 2 summary
		System.out.println(runner2Name1 + " run summary: ");
		System.out.println("Split 1: " + runner2Split1Min + ":" + runner2Split1Sec);
		System.out.println("Split 2: " + runner2Split2Min + ":" + runner2Split2Sec);
		System.out.println("Split 3: " + runner2Split3Min + ":" + runner2Split3Sec);
		System.out.println("Total time: " + runner2TimeMin + ":" + runner2TimeSec);
		System.out.print("\n");

		// get runner 3 information and extract first name
		System.out.print("Please enter your first and last name: ");
		String runner3Name1 = keyboard.nextLine();
		String runner3Name2 = runnerName(runner3Name1);
		System.out.println("Please enter all times in the format: min:sec.millisec");
		System.out.print(runner3Name2 + ", please enter your one mile time: ");
		String runner3Mile1 = keyboard.nextLine();
		System.out.print(runner3Name2 + ", please enter your time to the end of the second mile: ");
		String runner3Mile2 = keyboard.nextLine();
		System.out.print(runner3Name2 + ", please enter your total time to complete your 5km run: ");
		String runner3Time = keyboard.nextLine();

		// convert runner 3 information in to splits
		double runner3Split1 = convertToSeconds(runner3Mile1);
		double runner3Split2 = convertToSeconds(runner3Mile2) - runner3Split1;
		double runner3Split3 = convertToSeconds(runner3Time) - (runner3Split1 + runner3Split2);

		// format runner 3 splits
		int runner3Split1Min = (int) runner3Split1 / SECONDS_PER_MINUTE;
		String runner3Split1Sec = numberFormat(runner3Split1 % SECONDS_PER_MINUTE);
		int runner3Split2Min = (int) runner3Split2 / SECONDS_PER_MINUTE;
		String runner3Split2Sec = numberFormat(runner3Split2 % SECONDS_PER_MINUTE);
		int runner3Split3Min = (int) runner3Split3 / SECONDS_PER_MINUTE;
		String runner3Split3Sec = numberFormat(runner3Split3 % SECONDS_PER_MINUTE);
		int runner3TimeMin = (int) (runner3Split1 + runner3Split2 + runner3Split3) / SECONDS_PER_MINUTE;
		String runner3TimeSec = numberFormat((runner3Split1 + runner3Split2 + runner3Split3) % SECONDS_PER_MINUTE);
		System.out.print("\n");

		// print runner 3 summary
		System.out.println(runner3Name1 + " run summary: ");
		System.out.println("Split 1: " + runner3Split1Min + ":" + runner3Split1Sec);
		System.out.println("Split 2: " + runner3Split2Min + ":" + runner3Split2Sec);
		System.out.println("Split 3: " + runner3Split3Min + ":" + runner3Split3Sec);
		System.out.println("Total time: " + runner3TimeMin + ":" + runner3TimeSec);
		System.out.print("\n");

		// get runner 4 information and extract first name
		System.out.print("Please enter your first and last name: ");
		String runner4Name1 = keyboard.nextLine();
		String runner4Name2 = runnerName(runner4Name1);
		System.out.println("Please enter all times in the format: min:sec.millisec");
		System.out.print(runner4Name2 + ", please enter your one mile time: ");
		String runner4Mile1 = keyboard.nextLine();
		System.out.print(runner4Name2 + ", please enter your time to the end of the second mile: ");
		String runner4Mile2 = keyboard.nextLine();
		System.out.print(runner4Name2 + ", please enter your total time to complete your 5km run: ");
		String runner4Time = keyboard.nextLine();

		// convert runner 4 information in to splits
		double runner4Split1 = convertToSeconds(runner4Mile1);
		double runner4Split2 = convertToSeconds(runner4Mile2) - runner4Split1;
		double runner4Split3 = convertToSeconds(runner4Time) - (runner4Split1 + runner4Split2);

		// format runner 4 splits
		int runner4Split1Min = (int) runner4Split1 / SECONDS_PER_MINUTE;
		String runner4Split1Sec = numberFormat(runner4Split1 % SECONDS_PER_MINUTE);
		int runner4Split2Min = (int) runner4Split2 / SECONDS_PER_MINUTE;
		String runner4Split2Sec = numberFormat(runner4Split2 % SECONDS_PER_MINUTE);
		int runner4Split3Min = (int) runner4Split3 / SECONDS_PER_MINUTE;
		String runner4Split3Sec = numberFormat(runner4Split3 % SECONDS_PER_MINUTE);
		int runner4TimeMin = (int) (runner4Split1 + runner4Split2 + runner4Split3) / SECONDS_PER_MINUTE;
		String runner4TimeSec = numberFormat((runner4Split1 + runner4Split2 + runner4Split3) % SECONDS_PER_MINUTE);
		System.out.print("\n");

		// print runner 4 summary
		System.out.println(runner4Name1 + " run summary: ");
		System.out.println("Split 1: " + runner4Split1Min + ":" + runner4Split1Sec);
		System.out.println("Split 2: " + runner4Split2Min + ":" + runner4Split2Sec);
		System.out.println("Split 3: " + runner4Split3Min + ":" + runner4Split3Sec);
		System.out.println("Total time: " + runner4TimeMin + ":" + runner4TimeSec);
		System.out.print("\n");

		// get runner 5 information and extract first name
		System.out.print("Please enter your first and last name: ");
		String runner5Name1 = keyboard.nextLine();
		String runner5Name2 = runnerName(runner5Name1);
		System.out.println("Please enter all times in the format: min:sec.millisec");
		System.out.print(runner5Name2 + ", please enter your one mile time: ");
		String runner5Mile1 = keyboard.nextLine();
		System.out.print(runner5Name2 + ", please enter your time to the end of the second mile: ");
		String runner5Mile2 = keyboard.nextLine();
		System.out.print(runner5Name2 + ", please enter your total time to complete your 5km run: ");
		String runner5Time = keyboard.nextLine();

		// convert runner 5 information in to splits
		double runner5Split1 = convertToSeconds(runner5Mile1);
		double runner5Split2 = convertToSeconds(runner5Mile2) - runner5Split1;
		double runner5Split3 = convertToSeconds(runner5Time) - (runner5Split1 + runner5Split2);

		// format runner 5 splits
		int runner5Split1Min = (int) runner5Split1 / SECONDS_PER_MINUTE;
		String runner5Split1Sec = numberFormat(runner5Split1 % SECONDS_PER_MINUTE);
		int runner5Split2Min = (int) runner5Split2 / SECONDS_PER_MINUTE;
		String runner5Split2Sec = numberFormat(runner5Split2 % SECONDS_PER_MINUTE);
		int runner5Split3Min = (int) runner5Split3 / SECONDS_PER_MINUTE;
		String runner5Split3Sec = numberFormat(runner5Split3 % SECONDS_PER_MINUTE);
		int runner5TimeMin = (int) (runner5Split1 + runner5Split2 + runner5Split3) / SECONDS_PER_MINUTE;
		String runner5TimeSec = numberFormat((runner5Split1 + runner5Split2 + runner5Split3) % SECONDS_PER_MINUTE);
		System.out.print("\n");

		// print runner 5 summary
		System.out.println(runner5Name1 + " run summary: ");
		System.out.println("Split 1: " + runner5Split1Min + ":" + runner5Split1Sec);
		System.out.println("Split 2: " + runner5Split2Min + ":" + runner5Split2Sec);
		System.out.println("Split 3: " + runner5Split3Min + ":" + runner5Split3Sec);
		System.out.println("Total time: " + runner5TimeMin + ":" + runner5TimeSec);
		System.out.print("\n");

		// print team summaries in a chart
		System.out.printf(" %25s %14s %14s %14s %14s \n", "Runner Name", "Split 1", "Split 2", "Split 3", "Total Time");
		System.out.printf(" %25s %7d:%06.3f %7d:%06.3f %7d:%06.3f %7d:%06.3f \n", runner1Name1, runner1Split1Min, runner1Split1 % SECONDS_PER_MINUTE, runner1Split2Min, runner1Split2
				% SECONDS_PER_MINUTE, runner1Split3Min, runner1Split3 % SECONDS_PER_MINUTE, runner1TimeMin, (runner1Split1 + runner1Split2 + runner1Split3) % SECONDS_PER_MINUTE);
		System.out.printf(" %25s %7d:%06.3f %7d:%06.3f %7d:%06.3f %7d:%06.3f \n", runner2Name1, runner2Split1Min, runner2Split1 % SECONDS_PER_MINUTE, runner2Split2Min, runner2Split2
				% SECONDS_PER_MINUTE, runner2Split3Min, runner2Split3 % SECONDS_PER_MINUTE, runner2TimeMin, (runner2Split1 + runner2Split2 + runner2Split3) % SECONDS_PER_MINUTE);
		System.out.printf(" %25s %7d:%06.3f %7d:%06.3f %7d:%06.3f %7d:%06.3f \n", runner3Name1, runner3Split1Min, runner3Split1 % SECONDS_PER_MINUTE, runner3Split2Min, runner3Split2
				% SECONDS_PER_MINUTE, runner3Split3Min, runner3Split3 % SECONDS_PER_MINUTE, runner3TimeMin, (runner3Split1 + runner3Split2 + runner3Split3) % SECONDS_PER_MINUTE);
		System.out.printf(" %25s %7d:%06.3f %7d:%06.3f %7d:%06.3f %7d:%06.3f \n", runner4Name1, runner4Split1Min, runner4Split1 % SECONDS_PER_MINUTE, runner4Split2Min, runner4Split2
				% SECONDS_PER_MINUTE, runner4Split3Min, runner4Split3 % SECONDS_PER_MINUTE, runner4TimeMin, (runner4Split1 + runner4Split2 + runner4Split3) % SECONDS_PER_MINUTE);
		System.out.printf(" %25s %7d:%06.3f %7d:%06.3f %7d:%06.3f %7d:%06.3f \n", runner5Name1, runner5Split1Min, runner5Split1 % SECONDS_PER_MINUTE, runner5Split2Min, runner5Split2
				% SECONDS_PER_MINUTE, runner5Split3Min, runner5Split3 % SECONDS_PER_MINUTE, runner5TimeMin, (runner5Split1 + runner5Split2 + runner5Split3) % SECONDS_PER_MINUTE);

		keyboard.close();
	}

	// to extract runner's first name for prompting
	static String runnerName(String name) {
		int position = name.indexOf(' ');
		String finalName = name.substring(0, position);
		return finalName;
	}

	// to convert splits in to seconds
	static double convertToSeconds(String time) {
		int position = time.indexOf(':');
		String min = time.substring(0, position);
		String sec = time.substring(position + 1);
		int minFinal = Integer.valueOf(min);
		double secFinal = Double.valueOf(sec);
		double finalTime = minFinal * SECONDS_PER_MINUTE + secFinal;
		return finalTime;

	}

	// to format all times so that they have only 3 decimal places
	static String numberFormat(double format) {
		DecimalFormat myFormatter = new DecimalFormat("00.###");
		return myFormatter.format(format);

	}
}
