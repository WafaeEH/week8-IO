package presentation;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import engine.BankAccountList;
import engine.handlers.ButtonHandler;
import presentation.nodes.PanelCreateBankAccount;
import presentation.nodes.PanelMainMenu;

public class WindowBuilder extends JFrame {

	private static final long serialVersionUID = -3951176943632103371L;

	private JPanel cards;
	private PanelMainMenu panelMainMenu;
	private PanelCreateBankAccount panelCreateBankAccount;
	
	private BankAccountList accounts;
	
	public WindowBuilder() {
		initCore();
		initValuableAssets();
		initComponents();
		layoutComponents();
		setVisible(true);
	}
	
	private void initCore() {
		ButtonHandler.importMainGrid(this);
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		setTitle("Java I/O");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(500, 420);
		setResizable(false);
		setLocationRelativeTo(null);
	}
	
	private void initComponents() {
		panelMainMenu = new PanelMainMenu();
		panelCreateBankAccount = new PanelCreateBankAccount();
		ButtonHandler.importPanelCreateBankAccount(panelCreateBankAccount);
	}
	
	private void layoutComponents() {
		cards = new JPanel(new CardLayout());
		cards.add(panelMainMenu, "MainMenu");
		cards.add(panelCreateBankAccount, "CreateBankAccount");
		add(cards);
	}
	
	private void initValuableAssets() {
		accounts = new BankAccountList();
		ButtonHandler.importEngineBankAccountsList(accounts);
	}
	
	public void changeTab(String tabName) {
		CardLayout cl = (CardLayout)(cards.getLayout());
	    cl.show(cards, tabName);
	}
}