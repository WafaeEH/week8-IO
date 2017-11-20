package engine;

import java.util.Random;

public class BankAccount {

	private String name;
	private String phoneNumber;
	private String address;
	private long balance;
	
	private String accountSignature;
	
	public BankAccount(String name, String phoneNumber, String address, long balance) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.balance = balance;
		generateAccountSignature();
	}
	
	public void withdraw(long amount) throws Exception {
		if (amount > balance) throw new Exception("Impossible");
		if (amount <= 0) throw new Exception("Impossible");
		balance -= amount;
	}
	
	public void deposit(long amount) throws Exception {
		if (amount <= 0) throw new Exception("Impossible");
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
		return "##############\n" +
			   "Rekening: " + accountSignature + "\n" +
			   "Name: " + name + "\n" +
			   "PhoneNumber: " + phoneNumber + "\n" +
			   "Address: " + address + "\n" +
			   "Balance: " + balance;
	}
	
	public String getName() { return name; }
	public String getPhoneNumber() { return phoneNumber; }
	public String getAddress() { return address; }
	public long getBalance() { return balance; }
	public String getAccountSignature() { return accountSignature; }
	
	public void setName(String name) { this.name = name; }
	public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
	public void setAddress(String address) { this.address = address; }
	public void setBalance(long balance) { this.balance = balance; }
}