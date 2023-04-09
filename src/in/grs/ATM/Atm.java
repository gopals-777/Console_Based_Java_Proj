package in.grs.ATM;

import java.util.Scanner;

interface IServices {
	void atmServices();
}

class ServicesImpl implements IServices {

	@Override
	public void atmServices() {
		// security limitation
		int limit = 1;
		// user choice
		int choice = 0;
		int amount = 0;

		System.out.println("\n******** Welcome To GRS ATM APPLICATION ********\n");

		// Taking input from user
		Scanner sc = new Scanner(System.in);

		// Creating required objects
		// tight Coupling
		Account ah = new Account();
		BankTransaction bt = new BankTransaction();
		// loose coupling
		IAccount bank = new Bank();

		while (limit <= 3) {
			// For security reason, limiting the access by keeping a counter

			System.out.print("\nKINDLY ENTER THE USER ID: ");
			String userId = sc.next();

			System.out.print("ENTER PIN: ");
			String userPin = sc.next();

			if (userId.equals(ah.getId()) && userPin.equals(ah.getPin())) {

				// Increasing the limit to 3 if the user types correct details
				limit = 4;

				System.out.println("\n*******************************************");
				System.out.println("Welcome to GRS BANKING APPLICATION");
				System.out.println("*********************************************\n");

				// Account type selection
				System.out.println("SELECT THE ACCOUNT TYPE: ");
				System.out.println("_________________________");
				System.out.print("\n1. SAVINGS ACCOUNT \n2. CURRENT ACCOUNT\n");
				System.out.print("\nchoice: ");
				int account = sc.nextInt();

				// value checking
				if (account == 1 || account == 2) {
				} else {
					System.out.println("Please! enter correct input");
					System.exit(0);
				}

				// ATM OPTIONS
				while (true) {
					System.out.println("\n\t\t OPTIONS");
					System.out.println("\t_____________________________________\n");
					System.out.println("1. DEPOSIT \t 2. WITHDRAWAL \n");
					System.out.println("3. TRANSFER \t 4. TRANSACTIONS HISTORY\n");
					System.out.println("5. BALANCE \t 6. QUIT\n");
					System.out.println("************************************************\n");

					System.out.print("Enter your choice: ");
					choice = sc.nextInt();
					switch (choice) {

					case 1:
						System.out.print("Enter amount to be deposited: ");
						if (account == 1) {
							// Savings account
							amount = sc.nextInt();
							bank.sDeposit(amount);
						} else {
							// Current account
							amount = sc.nextInt();
							bank.cDeposit(amount);
						}

						break;

					case 2:
						System.out.print("Enter amount to be withdrawn: ");
						if (account == 1) {
							// Savings account
							// Checking condition that balance request is valid or not
							amount = sc.nextInt();
							if (amount <= bank.sGetBalance()) {
								bank.sWithdraw(amount);
							} else
								System.out.println("Insufficient balance");

						} else {
							// Current account
							// Checking condition that balance request is valid or not
							amount = sc.nextInt();
							if (amount <= bank.cGetBalance()) {
								bank.cWithdraw(amount);
							} else
								System.out.println("Insufficient balance");
						}

						break;


					// Auto account number
					case 3:
						if (bt.getSAccountNum().equals("123456789") && account == 1) {
							System.out.print("Enter amount to be transferred: ");
							amount = sc.nextInt();
							bt.bTransaction(bank, bt, account, amount);

						} else if (bt.getCAccountNum().equals("0987654321") && account == 2) {
							System.out.print("Enter amount to be transferred: ");
							amount = sc.nextInt();
							bt.bTransaction(bank, bt, account, amount);
						} else
							System.out.println("Wrong details! provided. Please, try again.");

						break;

					case 4:
						bank.sTranscHistory();
						break;

					case 5:
						if (account == 1)
							System.out.println("\nAccount Balance is: " + bank.sGetBalance());
						else if (account == 2)
							System.out.println("\nAccount Balance is: " + bank.cGetBalance());
						break;

					case 6:
						System.out.println(
								"_______________________________________________________________________________________");
						System.out.println("\nMESSAGE:   \nThankYou for using GRS ATM APPLICATION!!!");
						System.out.println(
								"_______________________________________________________________________________________");
						System.exit(0);
					}
				}

			} else if (limit == 3) {
				limit++;
				System.out.println(
						"_______________________________________________________________________________________");
				System.out.println(
						"\nMESSAGE:   Your ATM services has been blocked for 24 hrs. Please try again later...");
				System.out.println(
						"_______________________________________________________________________________________");
			} else {
				limit++;
				System.out.println("_______________________________________________________");
				System.out.println("\nMESSAGE:   Incorrect user credentials, Please enter correct credentials..!! ");
				System.out.println("______________________________________________________");
			}

		}

	}
}


class Atm {
	public static void main(String[] args) {
		// Interface promoting loose coupling
		IServices atm = new ServicesImpl();

		// Calling ATM services of AtmImpl which is implementation class of Interface
		// IAtm
		atm.atmServices();
	}
}










