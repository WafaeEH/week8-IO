package presentation;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import engine.handlers.ButtonHandler;

public class PanelCreateBankAccount extends JPanel {

	private static final long serialVersionUID = -6494390684260621787L;

	private JButton buttonCancel;
	private JButton buttonCreateAccount;
		
	private JLabel labelName;
	private JLabel labelPhoneNumber;
	private JLabel labelAddress;
	private JLabel labelBalance;
	
	private JTextField txtName;
	private JTextField txtPhoneNumber;
	private JTextField txtAddress;
	private JTextField txtBalance;

	public PanelCreateBankAccount() {
		super(new BorderLayout());
		initComponents();
		layoutComponents();
		initListeners();
	}
	
	private void initComponents() {
		buttonCancel = new JButton("Cancel");
		buttonCreateAccount = new JButton("Aanmaken");
		
		labelName = new JLabel("Naam: ");
		labelPhoneNumber = new JLabel("GSM: ");
		labelAddress = new JLabel("Adress: ");
		labelBalance = new JLabel("Kapitaal: ");
		
		txtName = new JTextField(5);
		txtPhoneNumber = new JTextField(5);
		txtAddress = new JTextField(5);
		txtBalance = new JTextField(5);
	}
	
	private void layoutComponents() {
		JPanel panelGrid = new JPanel(new GridLayout(4, 2));
		panelGrid.add(labelName);
		panelGrid.add(txtName);
		panelGrid.add(labelPhoneNumber);
		panelGrid.add(txtPhoneNumber);
		panelGrid.add(labelAddress);
		panelGrid.add(txtAddress);
		panelGrid.add(labelBalance);
		panelGrid.add(txtBalance);

		JPanel panelButtons = new JPanel(new FlowLayout());
		panelButtons.add(buttonCancel);
		panelButtons.add(buttonCreateAccount);
		
		JPanel mainGrid = new JPanel(new BorderLayout());
		mainGrid.add(panelGrid, BorderLayout.CENTER);
		mainGrid.add(panelButtons, BorderLayout.SOUTH);
		
		mainGrid.setBorder(BorderFactory.createTitledBorder("Aanmaken Rekening"));
		
		add(mainGrid, BorderLayout.NORTH);
	}
	
	public void reset() {
		txtName.setText("");
		txtPhoneNumber.setText("");
		txtAddress.setText("");
		txtBalance.setText("");
	}
	
	private void initListeners() {
		buttonCancel.addActionListener(ButtonHandler.setActionCancelCreateBankAccount());
		buttonCreateAccount.addActionListener(ButtonHandler.setActionCreateBankAccount());
	}
	
	public String getName() { return txtName.getText(); }
	public String getNumber() { return txtPhoneNumber.getText(); }
	public String getAddress() { return txtAddress.getText(); }
	public String getBalance() { return txtBalance.getText(); }
}