package presentation.nodes;

import java.awt.BorderLayout;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import engine.BankAccount;
import engine.BankAccountList;
import engine.IO.Reader;
import engine.handlers.ButtonHandler;
import presentation.FrameAccount;

public class PanelBankAccounts extends JPanel {

	private static final long serialVersionUID = 8623223755624917107L;

	private JList<BankAccount> list;
	private JScrollPane scroll;
	private DefaultListModel<BankAccount> listModel;
	
	private BankAccountList accounts;
	
	private FrameAccount accountFrame;
	
	public PanelBankAccounts() {
		super(new BorderLayout());
		accounts = new BankAccountList();
		listModel = new DefaultListModel<>();
		list = new JList<>(listModel);
		scroll = new JScrollPane(list);
		add(scroll);
		accountFrame = new FrameAccount(new BankAccount());
		ButtonHandler.importFrameAccount(accountFrame);
		ButtonHandler.importEngineBankAccountsList(accounts);
		list.addMouseListener(ButtonHandler.setMouseBankAccountList());
		Reader.readBankAccounts(this);
	}
	
	public void addToList(BankAccount account) {
		accounts.addAccount(account);
		listModel.addElement(account);
	}
}