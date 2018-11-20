/*
 * bankAccount.java
 * 
 * Copyright 2018 Boured <boured@boured_laptop>
 * 
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301, USA.
 * 
 * 
 */

import java.util.Scanner; //Import Scanner class for user input.
import java.util.Random; //Import Random class for randomize ID number.
import java.util.InputMismatchException; //Import info for error when entering wrong things.

public class bankProgram {

	public static void main (String[] args) {
		
		int bankChoice = 0;//Sets choice int
		double depositAmount = 0;//Sets variable for communication with object.
		double withdrawAmount = 0;//Sets variable for communication with object.		
		boolean error = false;//Set to true when an exception is triggered to handle error.
		Scanner input = new Scanner(System.in);//Creates Scanner object for user input named "input".
		String name = "";//Initializes name to be entered later.
		Random rng = new Random();//Creates Random class to randomize ID.
		int id = rng.nextInt();//Creates an Int named id with a randomly generated ID everytime it's ran.

		System.out.println("Welcome to the Bank of Memes https://www.youtube.com/watch?v=cB_AnteqNJ0");//Welcomes user with memes.
		System.out.println("First we must create your first dank account!");//Tells the user straight!

		System.out.println("First enter your name (It is preferable to use your name, not xXx_YOLOSWAG69_xXx");//Prompts the user for thier name.
		name = input.nextLine();//Stores entered input into the name varaible.
		
		System.out.println("Creating Account...");//Flavor text.
				
		BankAccount bankFunction = new BankAccount(name,id);//Creates an instance of the BankAccount Object in the source.

		System.out.println("Account Created! Your name is " + bankFunction.getName() + " and your ID is " + bankFunction.getAccountNum());//FLAVOR
	
		while(bankChoice != 4){
			bankChoice = 0;//Resets choice.
			//Prompts user for input
			System.out.println("Choose an Option");
			System.out.println("1. Make Deposit");
			System.out.println("2. Make a Withdrawl");
			System.out.println("3. View Account Information");
			System.out.println("4. Quit");
			//

			bankChoice = input.nextInt();//Store user input to choose the choice needed.
		
		
			
			if(bankChoice == 1){
			
				do{
					try{
						System.out.println("Enter the amount you wish to deposit!");//Prompts user to enter an amount to deposit
						depositAmount = input.nextDouble(); //Stores entered amount into the depositAmount variable.
						bankFunction.deposit(depositAmount);//Calls function to deposit entered cash money dollars.
						System.out.println("Money deposited, your new balance is " + bankFunction.getBalance());//Confirms with user.
						error = false;
					}
					catch(InputMismatchException e){
						System.out.println("ERROR! INVALID VALUE DETECTED! TYPE NORMALLY YOU NERD!");
						input.nextLine();
						error = true;
					}
				}while(error);
		
			}//End of if loop


			if(bankChoice == 2){
				do{
					try{
						System.out.println("Enter the amount you wish to withdraw!");//Prompts user for an amount to withdraw.
						withdrawAmount = input.nextDouble();//Stores entered amount into the withdrawAmount variable.
						bankFunction.withdraw(withdrawAmount);//Calls function to withdraw entered cash money dollars.
						System.out.println("Money withdrawn, your new balance is " + bankFunction.getBalance());//Confirms with user.
						error = false;
					}
					catch(InputMismatchException e){
						System.out.println("ERROR! INVALID VALUE DETECTED! TYPE NORMALLY YOU NERD!");
						input.nextLine();
						error = true;
					}
				}while(error);

			}//End of if loop
			
			if(bankChoice == 3){
				System.out.println("Name: " + bankFunction.getName());//Lists user entered name.
				System.out.println("Account #: " + bankFunction.getAccountNum());//Listes users random ID number.
				System.out.println("Balance: " + bankFunction.getBalance());//Lists user's current balance.
			}//End of if loop
		
		
			if(bankChoice == 4){
				System.out.println("Quit key detected! Exiting...");
			}//End of if loop	
		
		}//End of while loop
	
	}//End of main program.

}//https://www.youtube.com/watch?v=JsxavPANO8s
