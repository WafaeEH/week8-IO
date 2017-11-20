package presentation;

import java.awt.BorderLayout;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import engine.BankAccount;

public class PanelBankAccounts extends JPanel {

	private static final long serialVersionUID = 8623223755624917107L;

	private JList<String> list;
	private JScrollPane scroll;
	private DefaultListModel<String> listModel;
	
	public PanelBankAccounts() {
		super(new BorderLayout());
		listModel = new DefaultListModel<>();
		list = new JList<>(listModel);
		scroll = new JScrollPane(list);
		add(scroll);
	}
	
	public void addToList(BankAccount account) {
		listModel.addElement(account.getAccountSignature());
	}
}