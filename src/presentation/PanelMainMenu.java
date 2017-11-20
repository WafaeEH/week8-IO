package presentation;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import engine.handlers.ButtonHandler;

public class PanelMainMenu extends JPanel {

	private static final long serialVersionUID = 2547455106184986638L;

	private JButton buttonCreateBankAccount;
	private JTextField txtFilterAccounts;
	
	private PanelBankAccounts panelBankAccounts;
	
	public PanelMainMenu() {
		super(new BorderLayout());
		initComponents();
		layoutComponents();
		initListeners();
	}
	
	private void initComponents() {
		buttonCreateBankAccount = new JButton("Aanmaken rekening");
		txtFilterAccounts = new JTextField(5);
		
		panelBankAccounts = new PanelBankAccounts();
		ButtonHandler.importPanelBankAccounts(panelBankAccounts);
	}
	
	private void layoutComponents() {
		JPanel panel = new JPanel(new BorderLayout());
		panel.add(buttonCreateBankAccount, BorderLayout.WEST);
		panel.add(txtFilterAccounts, BorderLayout.CENTER);
		add(panel, BorderLayout.NORTH);
		add(panelBankAccounts, BorderLayout.CENTER);
	}
	
	private void initListeners() {
		buttonCreateBankAccount.addActionListener(ButtonHandler.setActionChangeTabCreateBankAccount());
	}
	
}