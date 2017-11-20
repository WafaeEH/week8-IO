package engine.IO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import engine.BankAccount;
import engine.BankAccountList;
import presentation.Popup;
import presentation.nodes.PanelBankAccounts;

public class Reader {

	public static void read(BankAccountList list, PanelBankAccounts panel) {
		File folder = new File("src" + File.separator + "resources");
		File[] listOfFiles = folder.listFiles();
		for (int i = 0; i < listOfFiles.length; i++) {
			File file = listOfFiles[i];
			if (file.isFile() && file.getName().endsWith(".txt")) {
				try (BufferedReader br = new BufferedReader(new FileReader(file))) {
					String line;
					while ((line = br.readLine()) != null) {
						BankAccount bankAccount = new BankAccount().build(line);
						list.addAccount(bankAccount);
						panel.addToList(bankAccount);
					}
				} catch (IOException ex) {
					Popup.showErrorMessage(ex.getMessage());
				}
			}
		}
	}
	
}