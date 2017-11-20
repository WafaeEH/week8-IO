package engine;

import java.util.Random;

public class BankAccount {

	private String name;
	private String phoneNumber;
	private String address;
	private double balance;
	
	private String accountSignature;
	
	public BankAccount() {
		this("UNKNOWN", "UNKNOWN", "UNKNOWN", 0);
	}
	
	public BankAccount(String name, String phoneNumber, String address, double balance) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.balance = balance;
		generateAccountSignature();
	}
	
	public void withdraw(double amount) throws Exception {
		if (amount > balance) throw new Exception("Het aangevraagd aantal is te hoog!");
		if (amount <= 0) throw new Exception("Het aangevraagd aantal is te laag!");
		balance -= amount;
	}
	
	public void deposit(double amount) throws Exception {
		if (amount <= 0) throw new Exception("Het aangevraagd aantal is te laag!");
		balance += amount;
	}
	
	private void generateAccountSignature() {
		Random rand = new Random();
		int value = 0;
		for (int i = 0; i < 24; i++) {
			if (i % 4 == 0 && i != 0 && i != 24) accountSignature += "-";
			value = rand.nextInt(15) + 65;
			accountSignature += (char) value;
		}
		accountSignature = accountSignature.substring(4);
	}
	
	public String toString() {
		return accountSignature;
	}
	
	public String getName() { return name; }
	public String getPhoneNumber() { return phoneNumber; }
	public String getAddress() { return address; }
	public double getBalance() { return balance; }
	public String getAccountSignature() { return accountSignature; }
	
	public void setName(String name) { this.name = name; }
	public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
	public void setAddress(String address) { this.address = address; }
	public void setBalance(long balance) { this.balance = balance; }
}