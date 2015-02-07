/*
 * Charlotte Koch
 * ICS3U AP
 * Horse racing Assignment
 * This program is made to play a text based version of a modified horse race 
 * Due: February 6, 2015
 * Mr. Deslauriers
 */
package com.bayviewglen.horseracing;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class HorseRacingAssignment {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);

		introduction();

		String play = "";

		// initialize variables from files
		NumberFormat format = NumberFormat.getCurrencyInstance(Locale.CANADA);
		String[] playersInfo = getPlayerInfo();
		String[] playerNames = getPlayerNames(playersInfo);
		double[] playerWallets = getPlayerWallets(playersInfo);
		String[] horses = getHorses();

		// enter in to playing loop
		while (!play.equalsIgnoreCase("no")) {

			// initialize horses in race
			String[] horsesPlaying = initializeHorses(horses);

			displayHorses(horsesPlaying);

			boolean race = true;

			double[] bet = new double[playerNames.length];
			int[] horseBet = new int[playerNames.length];

			for (int i = 0; i < horseBet.length; i++) {
				horseBet[i] = 9;
			}

			// give player options within a race
			while (race) {

				int choice = getChoice(keyboard);

				if (choice == 1) {
					// gets player bet
					playerNamesChart(playersInfo, playerNames, playerWallets);
					getBets(keyboard, playerNames, playerWallets, format, horsesPlaying, bet, horseBet);
				} else if (choice == 2) {
					// adds player to player list
					playersInfo = addPlayer(keyboard, playerNames, playerWallets, playersInfo);
					playerNames = getPlayerNames(playersInfo);
					playerWallets = getPlayerWallets(playersInfo);
					playerNamesChart(playersInfo, playerNames, playerWallets);
					bet = adjustDoubleArray(playersInfo, bet);
					horseBet = adjustIntArray(playersInfo, horseBet);
				} else if (choice == 3) {
					// saves and quits
					gameQuit(playersInfo, playerNames, playerWallets);
					race = false;
					play = "no";
				} else {
					// displays the race graphic
					displayRaceGraphic(horsesPlaying, keyboard);
					race = false;
				}

			}

			if (!play.equalsIgnoreCase("no")) {
			adjustWallets(horsesPlaying, playerNames, playerWallets, bet, horseBet);

			play = playAgain(keyboard);
			}
		}

		playerQuit(playersInfo, playerNames, playerWallets);
		// save and quit

	}

	public static int[] adjustIntArray(String[] playersInfo, int[] horseBet) {
		// adjust the betting array for new player
		int[] newBet = new int[playersInfo.length];

		for (int i = 0; i < playersInfo.length - 1; i++) {
			newBet[i] = 9;
		}
		newBet[playersInfo.length - 1] = 9;

		horseBet = newBet;

		return horseBet;
	}

	public static double[] adjustDoubleArray(String[] playersInfo, double[] bet) {
		// adjust betting array for new player
		double[] newBet = new double[playersInfo.length];

		for (int i = 0; i < playersInfo.length - 1; i++) {
			newBet[i] = bet[i];
		}
		newBet[playersInfo.length - 1] = 0;

		bet = newBet;
		return bet;
	}

	public static void gameQuit(String[] playersInfo, String[] playerNames, double[] playerWallets) {
		// writes over the player file in order to save game
		for (int i = 0; i < playersInfo.length; i++) {
			playersInfo[i] = playerNames[i] + ", " + playerWallets[i];
		}
		String fileName = "input/playerInfo.dat";
		PrintWriter printWriter;
		try {
			printWriter = new PrintWriter(new FileOutputStream(fileName));
			int length = playersInfo.length;
			printWriter.println(length);
			for (int i = 0; i < length; i++) {
				printWriter.println(playersInfo[i]);
			}
			printWriter.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void playerQuit(String[] playersInfo, String[] playerNames, double[] playerWallets) {
		// leads to game save method in order to save game
		System.out.println("You game will be saved. Thanks for playing!");
		gameQuit(playersInfo, playerNames, playerWallets);

	}

	public static void adjustWallets(String[] horses, String[] playerNames, double[] playerWallets, double[] bet, int[] horseBet) {
		// adjusts player wallets based on bets and winners
		int[] horsePositions = new int[horses.length];
		int winner = horseWinner(horsePositions);

		for (int i = 0; i < playerNames.length; i++) {
			if (horseBet[i] == 9) {
				System.out.println(playerNames[i] + " you did not bet on a horse.");
			} else if (winner == horseBet[i]) {
				playerWallets[i] += bet[i];
				System.out.println(playerNames[i] + " your horse won!");
			} else {
				playerWallets[i] -= bet[i];
				System.out.println(playerNames[i] + " your horse lost!");
			}
		}

	}

	public static String[] addPlayer(Scanner keyboard, String[] playerNames, double[] playerWallets, String[] playersInfo) {
		// adds a new player to the game
		System.out.println("Hello new player.The current players in the game are: ");
		playerNamesChart(playersInfo, playerNames, playerWallets);
		System.out.println("Please enter your first name: ");
		String playerName = keyboard.nextLine();
		System.out.println("Please enter the amount of money you want to put in your wallet: ");
		String wallet = keyboard.nextLine();

		String playerInfo = playerName + ", " + wallet;

		String[] newPlayersInfo = new String[playersInfo.length + 1];

		for (int i = 0; i < playersInfo.length; i++) {
			newPlayersInfo[i] = playersInfo[i];
		}
		newPlayersInfo[newPlayersInfo.length - 1] = playerInfo;

		playersInfo = newPlayersInfo;

		return playersInfo;

	}

	public static int getChoice(Scanner keyboard) {
		// gets choice for what actions the players would like
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
		// displays horses in the race
		System.out.println(" \nThe Horses in this race are:");
		for (int i = 0; i < arr.length; i++) {
			System.out.println(i + 1 + ". " + arr[i]);
		}
	}

	public static String[] initializeHorses(String[] horses) {
		// selects horses to be in the race
		int x = (int) (Math.random() * (4) + 5);
		int numHorses = horses.length;
		String[] horsesPlaying = new String[x];
		int[] horseIndex = new int[x];
		boolean previousInt = false;

		for (int i = 0; i < x; i++) {
			int y = (int) (Math.random() * numHorses);
			previousInt = checkForDuplicate(y, horseIndex);
			while (previousInt) {
				y = (int) (Math.random() * numHorses - 1);
				previousInt = checkForDuplicate(y, horseIndex);
			}
			horseIndex[i] = y;
		}

		for (int i = 0; i < x; i++) {
			horsesPlaying[i] = horses[horseIndex[i]];
		}

		return horsesPlaying;
	}

	public static boolean checkForDuplicate(int x, int[] y) {
		// checks for duplicate horses to make sure each horse is racing only
		// once
		for (int num : y) {
			if (num == x) {
				return true;
			}
		}
		return false;
	}

	public static double[] makeStringDouble(String[] value) {
		// converts a string array to a double array
		double[] doubl = { 0.0 };
		for (int i = 0; i <= doubl.length; i++) {
			doubl[i] = Double.valueOf(value[i]);
		}

		return doubl;
	}

	public static double[] getPlayerWallets(String[] info) {
		// extracts player wallet from player info array
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
		// extracts player names from player info array
		String[] name = new String[info.length];
		for (int i = 0; i < info.length; i++) {
			int position = info[i].indexOf(',');
			name[i] = info[i].substring(0, position);
		}
		return name;
	}

	public static String[] getPlayerInfo() {
		// reads player info from file
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

	public static String playAgain(Scanner keyboard) {
		// asks if player wants to play again in order to start a new race/quit
		String play;
		System.out.print("Would you like to play another race? (Yes/No)");
		play = keyboard.nextLine();

		while (!play.equalsIgnoreCase("yes") && !play.equalsIgnoreCase("no")) {
			System.out.print("Would you like to play another race? (Yes/No)");
			play = keyboard.nextLine();
		}
		return play;
	}

	public static void displayRaceGraphic(String[] horses, Scanner keyboard) {
		// displays the race graphic where horses advance across track
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
		// determines which horse has won
		int winner = 0;
		for (int i = 0; i < horsePositions.length; i++) {
			if (horsePositions[i] == 25)
				winner = i;
		}
		return winner;
	}

	public static void advanceHorses(int[] horsePositions) {
		// gets horses position in order to advance horses across the track
		for (int i = 0; i < horsePositions.length; i++) {
			int j = (int) (Math.random() * 3);
			horsePositions[i] += j;
		}
	}

	public static boolean checkForWinner(int[] horsePositions) {
		// checks if a horse has won
		boolean win = false;
		for (int i = 0; i < horsePositions.length; i++) {
			if (horsePositions[i] == 20)
				win = true;
		}
		return win;
	}

	public static void horsesTrack(String[] horses, int[] horsePositions, Scanner keyboard) {
		// displays the race track
		for (int i = 0; i < horses.length; i++) {
			System.out.println("--------------------------------------------------------------------------------------------");
			int flag = horsePositions[i] + 1;
			String format = "%" + flag + "s";
			System.out.printf("%-17s |" + format, horses[i], "x \n");

		}
		System.out.println("--------------------------------------------------------------------------------------------");
		System.out.println();
		System.out.println("Press enter to play next round");
		String next = keyboard.nextLine();
	}

	public static void getBets(Scanner keyboard, String[] playerNames, double[] playerWallets, NumberFormat format, String[] horsesPlaying, double[] bet, int[] horseBet) {
		// gets bets from players
		int racePlayers = horsesPlaying.length;
		boolean keepBetting = true;
		int playerIndex = 0;
		while (keepBetting) {

			playerIndex = selectPlayerToBet(keyboard, playerNames, playerIndex);
			
			if (playerWallets[playerIndex]!=0){

			getIndividualBet(keyboard, playerNames, playerWallets, format, bet, playerIndex, horseBet, racePlayers);
			
			} else {
				System.out.println("You do not have any money to bet.");
			}

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

	public static int selectPlayerToBet(Scanner keyboard, String[] playerNames, int playerIndex) {
		// gets which player is betting
		int num = 0;
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

		playerIndex = num - 1;

		return playerIndex;
	}

	public static void getIndividualBet(Scanner keyboard, String[] playerNames, double[] playerWallets, NumberFormat format, double[] bet, int playerIndex, int[] horseBet, int racePlayers) {
		// gets individual horse and player bets
		getIndividualMoneyBet(keyboard, playerNames, playerWallets, format, bet, playerIndex);
		getIndividualHorseBet(keyboard, playerNames, playerIndex, horseBet, racePlayers);
	}

	public static void getIndividualMoneyBet(Scanner keyboard, String[] playerNames, double[] playerWallets, NumberFormat format, double[] bet, int playerIndex) {
		// gets the amount of money a player wishes to bet
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
		// gets which horse a player wishes to bet on
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
		// reads horses from file
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
		// displays player names and wallets in a chart
		System.out.printf("%-3s %-25s %-10s \n", "#", "Player Name", "Wallet");
		for (int i = 0; i < info.length; i++) {
			System.out.printf("%-3d %-25s %-10.2f \n", i + 1, names[i], wallets[i]);
		}

	}

	public static void introduction() {
		// plays introduction
		System.out.println("Welcome to the Horse Racing game. Good luck!!");
	}

}
