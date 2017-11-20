package presentation;

import javax.swing.JOptionPane;

public class Popup {

	public static void showErrorMessage(String message) {
		JOptionPane.showMessageDialog(null, "<html>" +  message + "<html>", "Error", JOptionPane.ERROR_MESSAGE);
	}
	
}