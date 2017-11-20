package presentation;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.text.DecimalFormat;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import engine.BankAccount;
import engine.handlers.ButtonHandler;

public class FrameAccount extends JFrame {

	private static final long serialVersionUID = 5434962246360907351L;

	private BankAccount account;
	
	private JLabel name;
	private JLabel phoneNumber;
	private JLabel address;
	private JLabel balance;
	
	private JButton buttonDeposit;
	private JButton buttonWithdraw;
	
	private JTextField txtDeposit;
	private JTextField txtWithdraw;
	
	private JPanel sub = new JPanel(new BorderLayout());
	
	public FrameAccount(BankAccount account) {
		this.account = account;
		initCore();
		initComponents();
		layoutComponents();
		initListeners();
		setLocationRelativeTo(null);
	}
	
	public void build() {
		refresh();
		repaint();
		validate();
		setLocationRelativeTo(null);
		setMinimumSize(new Dimension(270, 1));
		pack();
		setVisible(true);
	}
	
	private void initCore() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		
		setTitle("Bankrekening");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
	}
	
	private void initComponents() {
		name = new JLabel("Naam: ONBEKEND");
		phoneNumber = new JLabel("GSM: ONBEKEND");
		address = new JLabel("Adress: ONBEKEND");
		balance = new JLabel("Kapitaal: ONBEKEND");
		
		buttonDeposit = new JButton("Storten");
		buttonWithdraw = new JButton("Afhalen");
		
		txtDeposit = new JTextField(5);
		txtWithdraw = new JTextField(5);
	}
	
	private void layoutComponents() {
		JPanel grid = new JPanel(new GridLayout(4, 1));
		grid.add(name);
		grid.add(phoneNumber);
		grid.add(address);
		grid.add(balance);
		sub.add(grid, BorderLayout.CENTER);
		
		JPanel panel = new JPanel(new GridLayout(2, 2));
		panel.add(buttonDeposit);
		panel.add(txtDeposit);
		panel.add(buttonWithdraw);
		panel.add(txtWithdraw);
		sub.add(panel, BorderLayout.SOUTH);

		add(sub, BorderLayout.NORTH);
	}
	
	private void initListeners() {
		buttonDeposit.addActionListener(ButtonHandler.setActionDepositCash(account));
		buttonWithdraw.addActionListener(ButtonHandler.setActionWithdrawCash(account));
	}
	
	public long getDepositValue() {
		return Long.parseLong(txtDeposit.getText());
	}
	
	public long getWithdrawValue() {
		return Long.parseLong(txtWithdraw.getText());
	}
	
	public void refresh() {
		name.setText("Naam: " + account.getName());
		phoneNumber.setText("GSM: " + account.getPhoneNumber());
		address.setText("Adress: " + account.getAddress());
		balance.setText("Kapitaal: " + new DecimalFormat("###,###,###,###.##").format(account.getBalance()).toString());
		
		sub.setBorder(BorderFactory.createTitledBorder(account.getAccountSignature()));
	}
}
