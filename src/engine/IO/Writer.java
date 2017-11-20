package engine.IO;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import presentation.Popup;

public class Writer {

	public static void write(String fileName, String details) {
		try (FileWriter file = new FileWriter("src" + File.separator + "resources" + File.separator + fileName + ".txt")) {
			file.write(details);
			file.close();
		} catch (IOException ex) {
			Popup.showErrorMessage(ex.getMessage());
		}
	}
	
}