package se.cygni.workshop.classic;

public class Account {
	protected static final int MAX_AMOUNT = 20000;
	private int balance;

	public void deposit(int amount) {
		checkValidAmount(amount);
		this.balance = balance + amount;
	}

	private boolean isNegativeAmount(int amount) {
		return amount < 0;
	}

	public int balance() {
		return balance;
	}

	public void withdraw(int amount) {
		
		if(isWithdrawMoreThanBalance(amount))
			throw new NegativeBalanceException();
		
		if(isMoreThanMaxAmount(amount))
			throw new TooLargeWithdrawalException();
		
		checkValidAmount(amount);
		balance -= amount;
	}

	private boolean isMoreThanMaxAmount(int amount) {
		return amount > MAX_AMOUNT;
	}

	private void checkValidAmount(int amount) {	
		
		
		if (isNegativeAmount(amount)) {
			throw new NegativeAmountException();
		}
	}

	private boolean isWithdrawMoreThanBalance(int amountToWithdraw) {
		return balance-amountToWithdraw < 0;
	}

}
