package questao2_depois;

public abstract class BankAccount {
	// Class Description: Checking and Savings Account
	// 2.a. Dentro dos padr�es de GRASP, o SRP mais se indentifica com o padr�o
	// Expert. Al�m disso, LoD realaciona mediante a ideia que classes devem
	// possuir o menor numero de responsabilidades possiveis.
	//
	public double Balance() {
		return _balance;
	};

	public void Deposit(double amount) {
	};

	public abstract void Withdraw(double amount);

	private double _balance;
}
