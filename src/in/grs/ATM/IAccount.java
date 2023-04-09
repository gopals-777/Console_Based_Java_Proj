package in.grs.ATM;
//Current account, Savings account

public interface IAccount {

	void sDeposit(int amount);

	void cDeposit(int amount);

	void sWithdraw(int amount);

	void cWithdraw(int amount);

	void sTransfer(BankTransaction bt, int amount);

	void cTransfer(BankTransaction bt, int amount);

	void sTranscHistory();

	void cTranscHistory();

	int sGetBalance();

	int cGetBalance();

}
