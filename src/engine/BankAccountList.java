package engine;

import java.util.LinkedList;

public class BankAccountList {

	private LinkedList<BankAccount> list = new LinkedList<>();
	
	public void addAccount(BankAccount account) {
		list.add(account);
	}
	
	public void printAccounts() {
		list.forEach(System.out::println);
	}
	
}