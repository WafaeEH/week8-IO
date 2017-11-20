package engine.handlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import engine.BankAccount;
import engine.BankAccountList;
import presentation.PanelBankAccounts;
import presentation.PanelCreateBankAccount;
import presentation.PanelMainMenu;
import presentation.WindowBuilder;

public class ButtonHandler {

	private static WindowBuilder mainGrid;
	private static PanelMainMenu panelMainMenu;
	private static PanelCreateBankAccount panelCreateBankAccount;
	private static PanelBankAccounts panelBankAccounts;
	
	private static BankAccountList accounts;

	public static ActionListener setActionCreateBankAccount() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String name = panelCreateBankAccount.getName();
				String phone = panelCreateBankAccount.getNumber();
				String address = panelCreateBankAccount.getAddress();
				long value = 0;
				try {
					value = Integer.parseInt(panelCreateBankAccount.getBalance());
				} catch (NumberFormatException ex) {
					System.out.println(ex.getMessage());
					return;
				}
				if (name.isEmpty() || phone.isEmpty() || address.isEmpty()) {
					try {
						throw new Exception("Invalid inputs");
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
					return;
				}
				BankAccount account = new BankAccount(name, phone, address, value);
				accounts.addAccount(account);
				panelBankAccounts.addToList(account);
				System.out.println("Account Created");
			}
			
		};
	}
	
	public static ActionListener setActionCancelCreateBankAccount() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				mainGrid.changeTab("MainMenu");
				panelCreateBankAccount.reset();
			}

		};
	}

	public static ActionListener setActionChangeTabCreateBankAccount() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				mainGrid.changeTab("CreateBankAccount");
			}

		};
	}

	public static void importMainGrid(WindowBuilder grid) {
		mainGrid = grid;
	}

	public static void importPanelMainMenu(PanelMainMenu panel) {
		panelMainMenu = panel;
	}

	public static void importPanelCreateBankAccount(PanelCreateBankAccount panel) {
		panelCreateBankAccount = panel;
	}
	
	public static void importPanelBankAccounts(PanelBankAccounts panel) {
		panelBankAccounts = panel;
	}
	
	public static void importEngineBankAccountsList(BankAccountList list) {
		accounts = list;
	}

}