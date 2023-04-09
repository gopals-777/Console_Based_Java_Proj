package in.grs.ATM;

import java.util.ArrayList;
import java.util.Date;

class Bank implements IAccount {

	private int sBalance, cBalance;
	private ArrayList<String> transcHistory = new ArrayList<String>();
	boolean flag = false;
	Date date = new Date();

	// Savings account balance store
	@Override
	public void sDeposit(int amount) {
		sBalance = sBalance + amount;
		System.out.println("Amount credited: " + amount);
		transcHistory.add("Amount credited: " + amount);
		flag = true;
	}

	// Current account balance store
	@Override
	public void cDeposit(int amount) {
		cBalance = cBalance + amount;
		System.out.println("Amount credited: " + amount + "At");
		transcHistory.add("Amount credited: " + amount);
		flag = true;
	}

	// Withdrawal amount (self-service)
	@Override
	public void sWithdraw(int amount) {

		sBalance = sBalance - amount;
		System.out.println("Amount debited (self): " + amount);
		transcHistory.add("Amount debited (self): " + amount);
		flag = true;
	}

	// Withdrawal amount (self-service)
	@Override
	public void cWithdraw(int amount) {
		cBalance = cBalance - amount;
		System.out.println("Amount debited (self): " + amount);
		transcHistory.add("Amount debited (self): " + amount);
		flag = true;
	}

	// Transferring to a Bank account
	@Override
	public void sTransfer(BankTransaction bt, int amount) {

		sBalance = sBalance - amount;
		System.out.println("Amount Transferred successfully...!!");
		transcHistory.add("Amount " + amount + " debited to : " + bt.getSAccountNum());
		flag = true;

	}

	@Override
	public void cTransfer(BankTransaction bt, int amount) {

		cBalance = cBalance - amount;
		System.out.println("Amount Transferred successfully....!!");
		transcHistory.add("Amount " + amount + " debited to : " + bt.getCAccountNum());
		flag = true;
	}

	// Transaction History (S)
	@Override
	public void sTranscHistory() {
		if (flag) {
			for (String x : transcHistory) {
				System.out.println(x);
			}

		} else {
			System.out.println("NO TRANSCATIONS YET......");
		}

	}

//Transaction History (C)
	@Override
	public void cTranscHistory() {
		if (flag) {
			for (String x : transcHistory) {
				System.out.println(x);
			}

		} else {
			System.out.println("NO TRANSCATIONS YET......");
		}

	}


	// Get Balance
	@Override
	public int sGetBalance() {
		return sBalance;
	}

	@Override
	public int cGetBalance() {
		return cBalance;
	}
}