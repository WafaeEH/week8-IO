package engine.handlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;

import javax.swing.JList;

import engine.BankAccount;
import engine.BankAccountList;
import presentation.Popup;
import presentation.FrameAccount;
import presentation.WindowBuilder;
import presentation.nodes.PanelBankAccounts;
import presentation.nodes.PanelCreateBankAccount;

public class ButtonHandler {

	private static WindowBuilder mainGrid;
	private static PanelCreateBankAccount panelCreateBankAccount;
	private static PanelBankAccounts panelBankAccounts;
	
	private static BankAccountList accounts;
	
	private static FrameAccount currentFrame;

	public static MouseAdapter setMouseBankAccountList() {
		return new MouseAdapter() {
			@SuppressWarnings("unchecked")
			@Override
			public void mouseClicked(MouseEvent evt) {
				@SuppressWarnings("rawtypes")
				JList<BankAccount> list = (JList)evt.getSource();
				if (evt.getClickCount() == 2) {
					int index = list.locationToIndex(evt.getPoint());
					currentFrame.dispatchEvent(new WindowEvent(currentFrame, WindowEvent.WINDOW_CLOSING));
					currentFrame = new FrameAccount(accounts.get(index));
					currentFrame.build();
				}
			}
		};
	}
	
	public static ActionListener setActionWithdrawCash(BankAccount account) {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					account.withdraw(currentFrame.getWithdrawValue());
					currentFrame.refresh();
				} catch (Exception e) {
					Popup.showErrorMessage(e.getMessage());
				}
			}
			
		};
	}
	
	public static ActionListener setActionDepositCash(BankAccount account) {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					account.deposit(currentFrame.getDepositValue());
					currentFrame.refresh();
				} catch (Exception e) {
					Popup.showErrorMessage(e.getMessage());
				}
			}
			
		};
	}
	
	public static ActionListener setActionCreateBankAccount() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String name = panelCreateBankAccount.getName();
				String phone = panelCreateBankAccount.getNumber();
				String address = panelCreateBankAccount.getAddress();
				double value = 0;
				try {
					value = Double.parseDouble(panelCreateBankAccount.getBalance());
				} catch (NumberFormatException e) {
					Popup.showErrorMessage(e.getMessage());
					return;
				}
				if (name.isEmpty() || phone.isEmpty() || address.isEmpty()) {
					try {
						throw new Exception("Invalid inputs");
					} catch (Exception e) {
						Popup.showErrorMessage(e.getMessage());
					}
					return;
				}
				BankAccount account = new BankAccount(name, phone, address, value);
				accounts.addAccount(account);
				panelBankAccounts.addToList(account);
				System.out.println("Account Created");
				mainGrid.changeTab("MainMenu");
				panelCreateBankAccount.reset();
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

	public static void importPanelCreateBankAccount(PanelCreateBankAccount panel) {
		panelCreateBankAccount = panel;
	}
	
	public static void importPanelBankAccounts(PanelBankAccounts panel) {
		panelBankAccounts = panel;
	}
	
	public static void importEngineBankAccountsList(BankAccountList list) {
		accounts = list;
	}
	
	public static void importFrameAccount(FrameAccount frame) {
		currentFrame = frame;
	}

}