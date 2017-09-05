package questao2_antes;

public abstract class BankAccount {
	// Class Description: Checking and Savings Account
	// 2.a. Dentro dos padrões de GRASP, o SRP mais se indentifica com o padrão
	// Expert. Além disso, LoD realaciona mediante a ideia que classes devem
	// possuir o menor numero de responsabilidades possiveis.
	public double Balance() {
		return _balance;
	};

	public void Deposit(double amount) {
	};

	public void Withdraw(double amount) {
	};

	public void AddInterest(double amount) {
	};

	public void Transfer(double amount, BankAccount toAccount) {
	};

	private double _balance;
}
