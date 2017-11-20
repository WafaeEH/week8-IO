package presentation.nodes;

import java.awt.BorderLayout;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import engine.BankAccount;
import engine.handlers.ButtonHandler;
import presentation.FrameAccount;

public class PanelBankAccounts extends JPanel {

	private static final long serialVersionUID = 8623223755624917107L;

	private JList<BankAccount> list;
	private JScrollPane scroll;
	private DefaultListModel<BankAccount> listModel;
	
	private FrameAccount accountFrame;
	
	public PanelBankAccounts() {
		super(new BorderLayout());
		listModel = new DefaultListModel<>();
		list = new JList<>(listModel);
		scroll = new JScrollPane(list);
		add(scroll);
		accountFrame = new FrameAccount(new BankAccount());
		ButtonHandler.importFrameAccount(accountFrame);
		list.addMouseListener(ButtonHandler.setMouseBankAccountList());
	}
	
	public void addToList(BankAccount account) {
		listModel.addElement(account);
	}
}