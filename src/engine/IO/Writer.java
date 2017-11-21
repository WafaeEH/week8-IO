package engine.IO;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;

import engine.BankAccount;
import presentation.Popup;

public class Writer {

	private static final String FILE_LOCATION = "src" + File.separator + "resources" + File.separator;
	
	public static void write(String fileName, String details) {
		try (FileWriter file = new FileWriter(FILE_LOCATION + fileName + ".acc")) {
			file.write(details);
			file.close();
		} catch (IOException ex) {
			Popup.showErrorMessage(ex.getMessage());
		}
	}
	
	public static void writeObject(BankAccount account) {
		try {
			FileOutputStream fos = new FileOutputStream(FILE_LOCATION + File.separator + account.getAccountSignature() + ".acc");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(account);
			oos.flush();
			oos.close();
		} catch (IOException ex) {
			Popup.showErrorMessage(ex.getMessage());
		}
	}
}