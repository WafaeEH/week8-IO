package engine;

import java.io.Serializable;
import java.util.Random;

import engine.IO.Writer;

public class BankAccount implements Serializable {

	private static final long serialVersionUID = 1256532397751798948L;
	
	private String name;
	private String phoneNumber;
	private String address;
	private double balance;
	
	private Random rand;
	
	private String accountSignature;
	
	public BankAccount() {
		this("UNKNOWN", "UNKNOWN", "UNKNOWN", 0);
	}
	
	public BankAccount(String name, String phoneNumber, String address, double balance) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.balance = balance;
		rand = new Random();
		generateAccountSignature();
	}
	
	public BankAccount build(String readedString) {
		String[] split = readedString.split(";");
		setSignature(split[0]);
		setName(split[1]);
		setPhoneNumber(split[2]);
		setAddress(split[3]);
		setBalance(Double.parseDouble(split[4]));
		return this;
	}
	
	public void withdraw(double amount) throws Exception {
		if (amount > balance) throw new Exception("Het aangevraagd aantal is te hoog!");
		if (amount <= 0) throw new Exception("Het aangevraagd aantal is te laag!");
		balance -= amount;
		Writer.write(getAccountSignature(), getDetails());
	}
	
	public void deposit(double amount) throws Exception {
		if (amount <= 0) throw new Exception("Het aangevraagd aantal is te laag!");
		balance += amount;
		Writer.write(getAccountSignature(), getDetails());
	}
	
	private void generateAccountSignature() {
		int value = 0;
		for (int i = 0; i < 24; i++) {
			if (i % 4 == 0 && i != 0 && i != 24) accountSignature += "-";
			value = rand.nextInt(15) + 65;
			accountSignature += (char) value;
		}
		accountSignature = accountSignature.substring(4);
	}
	
	public void writeObject() {
		Writer.writeObject(this);
	}
	
	public void writeDetails() {
		Writer.write(getAccountSignature(), getDetails());
	}
	
	private String getDetails() {
		return getAccountSignature() + ";" + getName() + ";" + getPhoneNumber() + ";" + getAddress() + ";" + getBalance();
	}
	
	public String toString() {
		return accountSignature;
	}
	
	public String getName() { return name; }
	public String getPhoneNumber() { return phoneNumber; }
	public String getAddress() { return address; }
	public double getBalance() { return balance; }
	public String getAccountSignature() { return accountSignature; }
	
	public void setSignature(String signature) { accountSignature = signature; }
	public void setName(String name) { this.name = name; }
	public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
	public void setAddress(String address) { this.address = address; }
	public void setBalance(double balance) { this.balance = balance; }
}