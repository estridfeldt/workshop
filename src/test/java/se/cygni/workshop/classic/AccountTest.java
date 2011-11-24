package se.cygni.workshop.classic;

import static org.junit.Assert.*;

import org.junit.Test;

public class AccountTest {

	@Test
	public void shouldAddDepositToBalanceForAccount() {
		// fixtures
		Account target = new Account();
		int amount = 100;

		// test
		target.deposit(amount);

		// assert
		assertEquals(amount, target.balance());

	}

	@Test
	public void shouldIncreaseBalanceOnDeposit() {
		// fixtures
		Account target = new Account();

		int amount = 100;

		// test
		target.deposit(amount);
		target.deposit(amount);

		// assert
		assertEquals(200, target.balance());

	}

	@Test
	public void shouldNotAcceptNegativeAmountAsDeposit() {
		// fixtures
		Account target = new Account();
		int amount = -100;

		try {
			// test
			target.deposit(amount);

			// assert
			fail("Should throw exception");
		} catch (NegativeAmountException e) {
			// Success
		}

	}

	@Test
	public void shouldWithdrawAmountFromBalanceForAccount() {
		// fixtures
		Account target = new Account();
		int amountToWithdraw = 100;
		target.deposit(200);

		// test
		target.withdraw(amountToWithdraw);

		// assert
		assertEquals(100, target.balance());

	}

	@Test
	public void shouldNotWithdrawMoreThanBalance() {
		// fixtures
		Account target = new Account();
		target.deposit(100);

		try {
			// test
			target.withdraw(200);

			// assert
			fail("Should throw exception when withdrawing more than balance.");
		} catch (NegativeBalanceException e) {
			// success
		}
	}

	@Test(expected = NegativeAmountException.class)
	public void shouldNotAcceptNegativeAmountAsWithdrawal() {
		// fixtures
		Account target = new Account();
		int amount = -100;

		// test
		target.withdraw(amount);
	}
	
	@Test(expected = TooLargeWithdrawalException.class)
	public void shouldNotWithdrawMoreThanMaxAmount() {
		//fixtures
		Account target = new Account();
		int amount = Account.MAX_AMOUNT+1;
		target.deposit(amount);
		
		//test
		target.withdraw(amount);
		
	}

}
