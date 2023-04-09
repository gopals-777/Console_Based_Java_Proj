package in.grs.ATM;
class BankTransaction {

	private String pSaccountNum = "123456789";
	private String pCaccountNum = "0987654321";

	public void bTransaction(IAccount bank, BankTransaction bt, int account, int amount) {


		if (account == 1 && bank.sGetBalance() >= amount) {
			System.out.println("Transferring Money...");
			bank.sTransfer(bt, amount);
		} else if (account == 2 && bank.cGetBalance() >= amount) {
			System.out.println("Transferring Money...");
			bank.cTransfer(bt, amount);
		} else
			System.out.print("Insufficient balance to transfer money!!");

	}

	public String getSAccountNum() {

		return pSaccountNum;

	}

	public String getCAccountNum() {
		return pCaccountNum;

	}
}