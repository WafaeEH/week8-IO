package presentation.nodes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

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
		initSearchPlaceholder();
		
		txtFilterAccounts.setForeground(Color.GRAY);
		txtFilterAccounts.setText(" Filter bankrekeningen");
	}
	
	private void initComponents() {
		buttonCreateBankAccount = new JButton("Aanmaken rekening");
		txtFilterAccounts = new JTextField(5);
		
		panelBankAccounts = new PanelBankAccounts();
		ButtonHandler.importPanelBankAccounts(panelBankAccounts);
	}
	
	private void initSearchPlaceholder() {
		txtFilterAccounts.addFocusListener(new FocusListener() {
		    @Override
		    public void focusGained(FocusEvent e) {
		        if (txtFilterAccounts.getText().equals(" Filter bankrekeningen")) {
		        	txtFilterAccounts.setText("");
		        	txtFilterAccounts.setForeground(Color.BLACK);
		        }
		    }
		    @Override
		    public void focusLost(FocusEvent e) {
		        if (txtFilterAccounts.getText().isEmpty()) {
		        	txtFilterAccounts.setForeground(Color.GRAY);
		        	txtFilterAccounts.setText(" Filter bankrekeningen");
		        }
		    }
		    });
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