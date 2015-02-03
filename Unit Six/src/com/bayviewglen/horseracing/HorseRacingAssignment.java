package com.bayviewglen.horseracing;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class HorseRacingAssignment {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);

		introduction();

		String play = "";

		NumberFormat format = NumberFormat.getCurrencyInstance(Locale.CANADA);
		String[] playersInfo = getPlayerInfo();
		String[] playerNames = getPlayerNames(playersInfo);
		double[] playerWallets = getPlayerWallets(playersInfo);
		String[] horses = getHorses();

		while (!play.equalsIgnoreCase("no")) {
			playerNamesChart(playersInfo, playerNames, playerWallets);

			String[] horsesPlaying = initializeHorses(horses);

			displayHorses(horsesPlaying);

			boolean race = true;

			double[] bet = new double[playerNames.length];
			int[] horseBet = new int[playerNames.length];

			for (int i = 0; i < horseBet.length; i++) {
				horseBet[i] = 9;
			}

			while (race) {

				int choice = getChoice(keyboard);

				if (choice == 1) {
					getBets(keyboard, playerNames, playerWallets, format, horsesPlaying, bet, horseBet);
				} else if (choice == 2) {
					addPlayer();
				} else if (choice == 3) {
					// save and quit
					race = false;
				} else {
					displayRaceGraphic(horsesPlaying, keyboard);
					race = false;
				}

			}

			adjustWallets(horsesPlaying, playerNames, playerWallets, bet, horseBet);

			playAgain(keyboard);
			
			//if no offer to save and quit or quit without saving 

		}

	}

	private static void adjustWallets(String[] horses, String[] playerNames, double[] playerWallets, double[] bet, int[] horseBet) {
		int[] horsePositions = new int[horses.length];
		int winner = horseWinner(horsePositions);

		for (int i = 0; i < playerNames.length; i++) {
			if (horseBet[i] == 9) {
				System.out.println(playerNames[i] + "you did not bet on a horse.");
			} else if (winner == horseBet[i]) {
				playerWallets[i] += bet[i];
				System.out.println(playerNames[i] + " your horse won!");
			} else {
				playerWallets[i] -= bet[i];
				System.out.println(playerNames[i] + " your horse lost!");
			}
		}

	}

	private static void addPlayer() {
		// TODO Auto-generated method stub

	}

	public static int getChoice(Scanner keyboard) {
		System.out.println("What would you like to do? 1. Bet on horses, 2. Add a player, 3. Save and quit, 4. Start race");
		int choice = 0;
		while (choice != 1 && choice != 2 && choice != 3 && choice != 4) {
			System.out.println("Please enter the number that coresponds with your choice");
			String playing = keyboard.nextLine();

			try {
				choice = Integer.valueOf(playing);
			} catch (NumberFormatException e) {
				System.out.println("Please enter a NUMBER");
				choice = -1;
			}
		}
		return choice;
	}

	public static void displayHorses(String[] arr) {
		System.out.println(" \nThe Horses in this race are:");
		for (int i = 0; i < arr.length; i++) {
			System.out.println(i + 1 + ". " + arr[i]);
		}
	}

	public static String[] initializeHorses(String[] horses) {
		int x = (int) (Math.random() * (8 - 5) + 5);
		int numHorses = horses.length;
		String[] horsesPlaying = new String[x];

		for (int i = 0; i < x; i++) {
			int y = (int) (Math.random() * numHorses);
			horsesPlaying[i] = horses[y];
		}
		return horsesPlaying;
	}

	public static double[] makeStringDouble(String[] value) {
		double[] doubl = { 0.0 };
		for (int i = 0; i <= doubl.length; i++) {
			doubl[i] = Double.valueOf(value[i]);
		}

		return doubl;
	}

	public static double[] getPlayerWallets(String[] info) {
		String[] wallet = new String[info.length];
		for (int i = 0; i < info.length; i++) {
			int position = info[i].indexOf(',');
			wallet[i] = info[i].substring(position + 1);
		}
		double[] money = new double[info.length];
		for (int i = 0; i < money.length; i++) {
			money[i] = Double.valueOf(wallet[i]);
		}

		return money;
	}

	public static String[] getPlayerNames(String[] info) {
		String[] name = new String[info.length];
		for (int i = 0; i < info.length; i++) {
			int position = info[i].indexOf(',');
			name[i] = info[i].substring(0, position);
		}
		return name;
	}

	public static String[] getPlayerInfo() {
		String[] info = { "" };
		String fileName = "input/playerInfo.dat";
		Scanner files = null;
		try {
			files = new Scanner(new File(fileName));
			String num = files.nextLine();
			int number = Integer.valueOf(num);
			info = new String[number];
			int i = 0;
			while (files.hasNext()) {
				info[i] = files.nextLine();
				i++;
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found: " + e.getMessage());
		} finally {
			if (files != null) {
				files.close();
			}
		}
		return info;

	}

	public static void playAgain(Scanner keyboard) {
		String play;
		System.out.print("Would you like to play another race? (Yes/No)");
		play = keyboard.nextLine();

		while (!play.equalsIgnoreCase("yes") && !play.equalsIgnoreCase("no")) {
			System.out.print("Do you want to play again? Yes/No ");
			play = keyboard.nextLine();
		}
	}

	public static void displayRaceGraphic(String[] horses, Scanner keyboard) {
		boolean winner = false;
		int[] horsePositions = new int[horses.length];
		horsesTrack(horses, horsePositions, keyboard);
		while (!winner) {
			advanceHorses(horsePositions);
			horsesTrack(horses, horsePositions, keyboard);
			winner = checkForWinner(horsePositions);
		}
		int win = horseWinner(horsePositions);
		System.out.println(horses[win] + " is the winner of the race!!!");
	}

	public static int horseWinner(int[] horsePositions) {
		int winner = 0;
		for (int i = 0; i < horsePositions.length; i++) {
			if (horsePositions[i] == 20)
				winner = i;
		}
		return winner;
	}

	public static void advanceHorses(int[] horsePositions) {
		// TODO Auto-generated method stub
		for (int i = 0; i < horsePositions.length; i++) {
			int j = (int) (Math.random() * 3);
			horsePositions[i] += j;
		}
	}

	public static boolean checkForWinner(int[] horsePositions) {
		boolean win = false;
		for (int i = 0; i < horsePositions.length; i++) {
			if (horsePositions[i] == 20)
				win = true;
		}
		return win;
	}

	public static void horsesTrack(String[] horses, int[] horsePositions, Scanner keyboard) {
		for (int i = 0; i < horses.length; i++) {
			System.out.println("--------------------------------------------------------------------------------------------"); // 15
			int flag = horsePositions[i] + 1;
			String format = "%" + flag + "s";
			System.out.printf("%-17s |" + format, horses[i], "x \n");

		}
		System.out.println("--------------------------------------------------------------------------------------------"); // 15
		System.out.println();
		System.out.println("Press enter to play next round");
		String next = keyboard.nextLine();
	}

	public static void getBets(Scanner keyboard, String[] playerNames, double[] playerWallets, NumberFormat format, String[] horsesPlaying, double[] bet, int[] horseBet) {

		int racePlayers = horsesPlaying.length;
		boolean keepBetting = true;
		int num = 0;
		// exceptions!!
		while (keepBetting) {
			while (num > playerNames.length || num < 1) {
				System.out.println("Please enter the number coresponding to your name: ");
				String name = keyboard.nextLine();

				try {
					num = Integer.valueOf(name);
				} catch (NumberFormatException e) {
					System.out.println("Please enter a NUMBER");
					num = -1;
				}
			}

			int playerIndex = num - 1;

			getIndividualBet(keyboard, playerNames, playerWallets, format, bet, playerIndex, horseBet, racePlayers);

			System.out.println("Would another player like to bet? (Yes/No)");
			String betting = keyboard.nextLine();

			while (!betting.equalsIgnoreCase("yes") && !betting.equalsIgnoreCase("no")) {
				System.out.print("Would another player like to bet? Yes/No ");
				betting = keyboard.nextLine();
			}
			if (betting.equalsIgnoreCase("no")) {
				keepBetting = false;
			}
		}

	}

	public static void getIndividualBet(Scanner keyboard, String[] playerNames, double[] playerWallets, NumberFormat format, double[] bet, int playerIndex, int[] horseBet, int racePlayers) {
		getIndividualMoneyBet(keyboard, playerNames, playerWallets, format, bet, playerIndex);
		getIndividualHorseBet(keyboard, playerNames, playerIndex, horseBet, racePlayers);
	}

	public static void getIndividualMoneyBet(Scanner keyboard, String[] playerNames, double[] playerWallets, NumberFormat format, double[] bet, int playerIndex) {
		while (bet[playerIndex] < 1 || bet[playerIndex] > playerWallets[playerIndex]) {
			System.out.print(playerNames[playerIndex] + ", you have " + format.format(playerWallets[playerIndex]) + " in your account. Please enter your bet: ");
			String readBet = keyboard.nextLine();

			try {
				bet[playerIndex] = Double.valueOf(readBet);
			} catch (NumberFormatException e) {
				System.out.println("Please enter a NUMBER");
				bet[playerIndex] = -1;
			}
		}
	}

	public static void getIndividualHorseBet(Scanner keyboard, String[] playerNames, int playerIndex, int[] horseBet, int racePlayers) {
		while (horseBet[playerIndex] < 1 || horseBet[playerIndex] > racePlayers) {
			System.out.print(playerNames[playerIndex] + " please enter the number that coresponds to the horse you wish to bet on: ");
			String readHorse = keyboard.nextLine();

			try {
				horseBet[playerIndex] = Integer.valueOf(readHorse) - 1;
			} catch (NumberFormatException e) {
				System.out.println("Please enter a NUMBER");
				horseBet[playerIndex] = -1;
			}
		}
	}

	public static String[] getHorses() {
		String[] horses = { "" };
		String fileName = "input/horses.dat";
		Scanner files = null;
		try {
			files = new Scanner(new File(fileName));
			String num = files.nextLine();
			int number = Integer.valueOf(num);
			horses = new String[number];
			int i = 0;
			while (files.hasNext()) {
				horses[i] = files.nextLine();
				i++;
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found: " + e.getMessage());
		} finally {
			if (files != null) {
				files.close();
			}
		}
		return horses;

	}

	public static void playerNamesChart(String[] info, String[] names, double[] wallets) {
		System.out.printf("%-3s %-25s %-10s \n", "#", "Player Name", "Wallet");
		for (int i = 0; i < info.length; i++) {
			System.out.printf("%-3d %-25s %-10.2f \n", i + 1, names[i], wallets[i]);
		}

	}

	public static void introduction() {
		System.out.println("Welcome to the Horse Racing game!!");
	}

}
