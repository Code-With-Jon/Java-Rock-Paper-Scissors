import java.util.Random; //Import Random library
import java.util.Scanner; // Import Scanner library

/* Name: Jonathan Fink  
Assignment: Project 3
Analysis: 
This program was created to create a Rock, Paper Scissors Game. The program starts off by asking the user
to select a menu option of either Rock, Paper, or Scissors. The program analyzes the users choice by storing
the first character of the users selection which is associated to the related full string menu option.
The users choice is then compared against the computers randomly generated choice. Each outcome returns
an Integer 1, 0, or -1 depending on whether the user won, there was a tie, or if the user lost. 
After the program determines who won, the results are displayed. After that, the program asks the user 
if they would like to play again. If the user wants to play again, the code is looped through again. 
If the user doesnt want to play again, the program displays a thank you message, and 
exits the game. */

public class RPS {
	//Create User and Computer Objects and are Privately stored.
	private User user;
	private Computer computer;

		//Create menu of possible options as constants to choose from
		private enum RockPaperScissors {
			ROCK, PAPER, SCISSORS;
			
			//DetermineWinner method which take in the menu options and another 
			//choice from the menu options and compares the choices to evaluate what Integer to return 
			public int determineWinner(RockPaperScissors otherChoice) {
				//  return a 0 if there is a tie
				if (this == otherChoice)
					return 0;
				//Switch/Case to run through possible outcomes and what integer to return
				switch (this) {
				case ROCK:
					return (otherChoice == SCISSORS ? 1 : -1);
				case PAPER:
					return (otherChoice == ROCK ? 1 : -1);
				case SCISSORS:
					return (otherChoice == PAPER ? 1 : -1);
				}       

				return 0;
			}
	}
			
			//Create User Class & Create Scanner object
			private class User {
			private Scanner inputScanner;

			//Create User method & Scanner input
				public User(){
					inputScanner = new Scanner(System.in);
	}
				//Within the RockPaperScissors enum menu, Create "getMove" method
				public RockPaperScissors getMove() {	
					
					//Ask user to select one menu option
					System.out.println("Please select (R)ock, (P)aper or (S)cissors");
					
					//Attach users selection to String variable "userInput"
					String userInput = inputScanner.nextLine();
					
					//Converts user's input to upper case (will be used to acknowledge which selection is made
					userInput = userInput.toUpperCase();
					
					//Create a char variable "firstChar" to store the first letter of the users input 
					char firstChar = userInput.charAt(0);  
					
					//Analyzes if the users first letter matches the first letter of one of the menu options,
					//associate them together
					if (firstChar == 'R' || firstChar == 'P'
							|| firstChar == 'S') {
						switch (firstChar) {
						case 'R':
							return RockPaperScissors.ROCK;
						case 'P':
							return RockPaperScissors.PAPER;
						case 'S':
							return RockPaperScissors.SCISSORS;
	        }
	    }
					return getMove();
	}
				//Create "playAgain" method
				public boolean playAgain(){
					//Ask user if they want to play another round
					System.out.print("Do you want to play again?");
					
					//attach users answer to String variable playAgain
					String playAgain = inputScanner.nextLine();
					
					//Convert users answer to upper case
					playAgain = playAgain.toUpperCase();
					
					//analyze first letter of users input to equal 'Y'
					return playAgain.charAt(0) == 'Y';
				}
	}
			//Create Computer Class
			private class Computer {
				//Whithin RockPaperScissors Class, Create getComputerMove method
				public RockPaperScissors getComputerMove() {
					
					//Create an array to store the values consisting of the menu options  
					RockPaperScissors[] moves = RockPaperScissors.values();
					
					//Generate random index
					Random random = new Random();
					int index = random.nextInt(moves.length);
					
					//return the randomly selected element from the moves array 
					return moves[index];
				}
	}
			//Create RPS method which includes the User method and the Computer method
			public  RPS() {
				user = new User();
				computer = new Computer();
	}
			
			public void startGame() {
				System.out.println("Ready to play Rock, Paper, Scissors?");
				
				// Get move from user
				RockPaperScissors userChoice = user.getMove();
				
				// Get move from computer
				RockPaperScissors computerChoice = computer.getComputerMove();
				
				System.out.println("ROCK!");
				System.out.println("\nPAPER!");
				System.out.println("\nSCISSORS!");
				System.out.println("\nSHOOT!");
				System.out.println("\n---------------");
				//Display what was selected by user and computer
				System.out.println("\nYou chose " + userChoice + ".");
				System.out.println("Computer chose " + computerChoice + ".\n");
				
				// Compare moves and determine winner by accessing the determineWinner scaling system
				// which passes the users choice and the computers choice
				int determineWinner = userChoice.determineWinner(computerChoice);
				switch (determineWinner) {
				case 0: // A 0 was returned so it was a tie & explanation
					System.out.println("Both you and the computer chose" + userChoice + " It's a Tie!");
					break;
				case 1: // A 1 was returned so User wins & explanation
					System.out.println(userChoice + " beats " + computerChoice + ". You won!");
					break;
				case -1: // A -1 Integer was returned so Computer wins & explanation
					System.out.println(computerChoice + " beats " + userChoice + ". You lost.");
					break;
	}


				// Ask user to play again. 
				// If user selects to play again, run through "startGame" method
				if (user.playAgain()) {
					System.out.println();
					startGame();
					//If the user selects not to play again, output thanks
				} else
					System.out.println("Thanks for playing!");
	}
			
//LAUNCH MAIN GAME		
public static void main(String[] args) {
RPS start_new_round = new RPS();
start_new_round.startGame();
	}
}
