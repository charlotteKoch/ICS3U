/*
 * Charlotte Koch
 * ICS3U AP
 * Blackjack Assignment
 * This program is made to play a text based version of blackjack 
 * Due: December, 2014
 * Mr. Deslauriers
 */
package com.bayviewglen.blackjack;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class BlackjackAssignment {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);

		// enter in to the game by entering name and not quit
		System.out.print("Please enter your name: ");
		String name = keyboard.nextLine();
		String quit = "quit";

		// when the player does not enter quit for name
		while (!name.equalsIgnoreCase(quit)) {

			// new players start with $500 in the bank
			double bank = 500.00;

			// get the player locale from the player and return a locale
			// formatter
			NumberFormat format = getLocaleFormatter(keyboard);

			// declares strings for entering the playing loop
			String play = "yes";
			String yes = "yes";
			String no = "no";

			// enter in to the playing loop
			while (play.equalsIgnoreCase(yes)) {
				double playerBet = getPlayerBet(keyboard, bank, format);

				// ace counters for player and dealer
				int playerAceCounter = 0;
				int dealerAceCounter = 0;

				// Deal player hand, check for aces, and format hand for both
				// player and running total including dealing with aces
				int playerCard1 = (int) (Math.random() * 52) + 1;
				if (checkIfAce(playerCard1)) {
					playerAceCounter++;
				}
				int playerCard2 = (int) (Math.random() * 52) + 1;
				if (checkIfAce(playerCard2)) {
					playerAceCounter++;
				}
				int playerSum = formatCardForSum(playerCard1) + formatCardForSum(playerCard2);
				if (playerSum > 21 && playerAceCounter >= 1) {
					playerAceCounter--;
					playerSum -= 10;
				}
				String playerHand = formatCardForPlayer(playerCard1) + "\t" + formatCardForPlayer(playerCard2);

				// Deal dealer hand, check for aces, and format hand for both
				// player and running total including dealing with aces
				int dealerCard1 = (int) (Math.random() * 52) + 1;
				if (checkIfAce(dealerCard1)) {
					dealerAceCounter++;
				}
				int dealerCard2 = (int) (Math.random() * 52) + 1;
				if (checkIfAce(dealerCard1)) {
					dealerAceCounter++;
				}
				int dealerSum = formatCardForSum(dealerCard1) + formatCardForSum(dealerCard2);
				if (dealerSum > 21 && dealerAceCounter >= 1) {
					dealerAceCounter--;
					dealerSum -= 10;
				}
				String dealerHand = formatCardForPlayer(dealerCard1) + "\tXX";

				// Show the player their hand and what they see of the dealer
				// hand
				System.out.println("Dealer: " + dealerHand);
				System.out.println("Player: " + playerHand);

				// allow playing phase loop to begin
				boolean deal = true;

				// check if double down is available
				boolean ddAvailable = true;
				if (bank / playerBet < 2) {
					ddAvailable = false;
				}

				// enter playing phase where player can choose to hit, stay, or
				// double down
				while (deal) {
					if (ddAvailable) {
						System.out.println("What do you want to do? 1. Hit, 2. Stay, 3. Double Down");
					} else {
						System.out.println("What do you want to do? 1. Hit, 2. Stay");
					}
					int choice = 0;
					while (choice != 1 && choice != 2 && choice != 3) {
						System.out.println("Please enter the number that coresponds with your choice");
						String playing = keyboard.nextLine();

						try {
							choice = Integer.valueOf(playing);
						} catch (NumberFormatException e) {
							System.out.println("Please enter a NUMBER");
							choice = -1;
						}
					}

					if (choice == 1) {
						deal = true;
						int playerCard3 = (int) (Math.random() * 52);
						if (checkIfAce(playerCard3)) {
							playerAceCounter++;
						}
						playerSum += formatCardForSum(playerCard3);
						if (playerSum > 21 && playerAceCounter >= 1) {
							playerAceCounter--;
							playerSum -= 10;
						}
						playerHand = playerHand + "\t" + formatCardForPlayer(playerCard3);
						ddAvailable = false;
						if (playerSum > 21) {
							deal = false;
						}
						System.out.println("Dealer: " + dealerHand);
						System.out.println("Player: " + playerHand);
					} else if (choice == 3) {
						int playerCard3 = (int) (Math.random() * 52);
						if (checkIfAce(playerCard3)) {
							playerAceCounter++;
						}
						playerSum += formatCardForSum(playerCard3);
						if (playerSum > 21 && playerAceCounter >= 1) {
							playerAceCounter--;
							playerSum -= 10;
						}
						playerHand = playerHand + "\t" + formatCardForPlayer(playerCard3);
						playerBet *= 2;
						deal = false;
					} else {
						deal = false;
					}

				}

				// reformat dealer hand to display to player
				dealerHand = formatCardForPlayer(dealerCard1) + "\t" + formatCardForPlayer(dealerCard2);

				// deal for dealer if needed based on rules

				boolean dealDealer = true;

				while (dealDealer) {
					if (dealerSum >= 17 || dealerSum >= playerSum || playerSum > 21) {
						dealDealer = false;
					} else if (dealerSum > 21) {
						dealDealer = false;
					} else {
						int dealerCard3 = (int) (Math.random() * 52) + 1;
						if (checkIfAce(dealerCard3)) {
							dealerAceCounter++;
						}
						dealerSum += formatCardForSum(dealerCard3);
						if (dealerSum > 21 && dealerAceCounter >= 1) {
							dealerAceCounter--;
							dealerSum -= 10;
						}
						dealerHand = dealerHand + "\t" + formatCardForPlayer(dealerCard3);
					}

				}

				// show player dealer and player hands and totals
				System.out.println("Dealer: " + dealerHand + "\t Total: " + dealerSum);
				System.out.println("Player: " + playerHand + "\t Total: " + playerSum);

				// display who won and add or subtract to player bank account
				if (playerSum > 21) {
					// BUST dealer wins
					System.out.println("You busted! The dealer wins!");
					bank -= playerBet;
				} else if (dealerSum > 21) {
					// BUST player wins
					System.out.println("The dealer busted! You win!");
					bank += playerBet;
				} else if (playerSum == dealerSum) {
					// TIE no one wins any money according to casino rules
					System.out.println("You and the dealer tied! You do not win or lose any money.");
				} else if (playerSum < dealerSum && playerSum < 21 && dealerSum < 21) {
					// dealer wins
					System.out.println("The dealer wins!");
					bank -= playerBet;
				} else {
					// player wins
					System.out.println("You win!");
					bank += playerBet;
				}

				// ask player if they want to play again to enter playing loop
				System.out.print("Do you want to play again? Yes/No ");
				play = keyboard.nextLine();

				while (!play.equalsIgnoreCase(yes) && !play.equalsIgnoreCase(no)) {
					System.out.print("Do you want to play again? Yes/No ");
					play = keyboard.nextLine();
				}

			}

			// ask for name in order to allow new player/ quit program
			System.out.print("Please enter your name: ");
			name = keyboard.nextLine();

		}
	}

	// method to check if a card is an ace
	public static boolean checkIfAce(int card) {
		boolean isAce;
		int cardAce = card % 13 + 1;

		if (cardAce == 1) {
			isAce = true;
		} else {
			isAce = false;
		}

		return isAce;

	}

	// method to convert cards in to numbers in order to make the player and
	// dealer sums
	public static int formatCardForSum(int card) {
		int cardForSum;
		int cardRaw = card % 13 + 1;

		if (cardRaw == 1) {
			cardForSum = 11;
		} else if (cardRaw == 11 || cardRaw == 12 || cardRaw == 13) {
			cardForSum = 10;
		} else {
			cardForSum = cardRaw;
		}
		return cardForSum;
	}

	// method to format cards in to strings for the user to see what has been
	// dealt
	public static String formatCardForPlayer(int card) {
		int cardFinal = card % 13 + 1;
		String faceValue;

		if (cardFinal == 1) {
			faceValue = "A";
		} else if (cardFinal == 11) {
			faceValue = "J";
		} else if (cardFinal == 12) {
			faceValue = "Q";
		} else if (cardFinal == 13) {
			faceValue = "K";
		} else {
			faceValue = String.valueOf(cardFinal);
		}

		int suit = card % 4 + 1;

		String suitValue;

		if (suit == 1) {
			suitValue = "C";
		} else if (suit == 2) {
			suitValue = "D";
		} else if (suit == 2) {
			suitValue = "S";
		} else {
			suitValue = "H";
		}

		String formattedCard = faceValue + suitValue;
		return formattedCard;
	}

	// method to obtain the player's bet
	public static double getPlayerBet(Scanner keyboard, double bank, NumberFormat format) {
		double bet = 0;

		while (bet < 1 || bet > bank) {
			System.out.print("You have " + format.format(bank) + "in your account. Please enter your bet: ");
			String readBet = keyboard.nextLine();

			try {
				bet = Double.valueOf(readBet);
			} catch (NumberFormatException e) {
				System.out.println("Please enter a NUMBER");
				bet = -1;
			}
		}
		return bet;
	}

	// method to get the player's locale and return a number formatter to format
	// numbers in the program
	public static NumberFormat getLocaleFormatter(Scanner keyboard) {
		int loc = -1;
		while (loc < 0 || loc > 10) {
			System.out.println("Please enter the number that coresponds with your location: ");
			System.out.println("1. Canada");
			System.out.println("2. United States");
			System.out.println("3. Korea");
			System.out.println("4. Germany");
			System.out.println("5. United Kingdom");
			System.out.println("6. China");
			System.out.println("7. France");
			System.out.println("8. Taiwan");
			System.out.println("9. Japan");
			System.out.println("10. Italy");
			String location = keyboard.nextLine();

			try {
				loc = Integer.valueOf(location);
			} catch (NumberFormatException e) {
				System.out.println("Please enter a NUMBER");
				loc = -1;
			}
		}
		Locale locale;
		if (loc == 1) {
			locale = Locale.CANADA;
		} else if (loc == 2) {
			locale = Locale.US;
		} else if (loc == 3) {
			locale = Locale.KOREA;
		} else if (loc == 4) {
			locale = Locale.GERMANY;
		} else if (loc == 5) {
			locale = Locale.UK;
		} else if (loc == 6) {
			locale = Locale.CHINA;
		} else if (loc == 7) {
			locale = Locale.FRANCE;
		} else if (loc == 8) {
			locale = Locale.TAIWAN;
		} else if (loc == 9) {
			locale = Locale.JAPAN;
		} else {
			locale = Locale.ITALY;
		}

		NumberFormat format = NumberFormat.getCurrencyInstance(locale);
		return format;
	}

}
