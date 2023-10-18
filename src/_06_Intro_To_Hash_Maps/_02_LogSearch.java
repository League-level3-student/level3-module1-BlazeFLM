package _06_Intro_To_Hash_Maps;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class _02_LogSearch implements ActionListener {
	/*
	 * Crate a HashMap of Integers for the keys and Strings for the values. Create a
	 * GUI with three buttons. Button 1: Add Entry When this button is clicked, use
	 * an input dialog to ask the user to enter an ID number. After an ID is
	 * entered, use another input dialog to ask the user to enter a name. Add this
	 * information as a new entry to your HashMap.
	 * 
	 * Button 2: Search by ID When this button is clicked, use an input dialog to
	 * ask the user to enter an ID number. If that ID exists, display that name to
	 * the user. Otherwise, tell the user that that entry does not exist.
	 * 
	 * Button 3: View List When this button is clicked, display the entire list in a
	 * message dialog in the following format: ID: 123 Name: Harry Howard ID: 245
	 * Name: Polly Powers ID: 433 Name: Oliver Ortega etc...
	 * 
	 * When this is complete, add a fourth button to your window. Button 4: Remove
	 * Entry When this button is clicked, prompt the user to enter an ID using an
	 * input dialog. If this ID exists in the HashMap, remove it. Otherwise, notify
	 * the user that the ID is not in the list.
	 */

	HashMap<Integer, String> users = new HashMap<Integer, String>();
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();

	JButton entryButton = new JButton("Add Entry");
	JButton searchByIDButton = new JButton("Search by ID");
	JButton viewListButton = new JButton("View List");

	public static void main(String args[]) {
		new _02_LogSearch().run();
	}
	public void run() {
		panel.add(viewListButton);
		panel.add(searchByIDButton);
		panel.add(entryButton);

		entryButton.addActionListener(this);
		searchByIDButton.addActionListener(this);
		viewListButton.addActionListener(this);

		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 100);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == entryButton) {
			String idInput = JOptionPane.showInputDialog("Enter an ID number");
			int idInputInt = Integer.parseInt(idInput);
			String nameInput = JOptionPane.showInputDialog("Enter a name");
			users.put(idInputInt, nameInput);
		}
		if (e.getSource() == searchByIDButton) {
			String idInput = JOptionPane.showInputDialog("Enter an ID number");
			int idInputInt = Integer.parseInt(idInput);
			for (Integer i : users.keySet()) {
				if (i == idInputInt) {
					JOptionPane.showMessageDialog(null, users.get(i));
				}
			}
		}
		if (e.getSource() == viewListButton) {
			String message = "";
			for(Integer i : users.keySet()) {
				message += "ID: " + i + " Name: " + users.get(i) + "\n";
			}
			JOptionPane.showMessageDialog(null, message);
		}
	}

}
