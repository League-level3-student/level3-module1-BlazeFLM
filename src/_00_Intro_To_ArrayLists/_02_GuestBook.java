package _00_Intro_To_ArrayLists;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class _02_GuestBook implements ActionListener {
	/*
	 * Create a GUI with two buttons. One button reads "Add Name" and the other
	 * button reads "View Names". When the add name button is clicked, display an
	 * input dialog that asks the user to enter a name. Add that name to an
	 * ArrayList. When the "View Names" button is clicked, display a message dialog
	 * that displays all the names added to the list. Format the list as follows:
	 * Guest #1: Bob Banders Guest #2: Sandy Summers Guest #3: Greg Ganders Guest
	 * #4: Donny Doners
	 */
	ArrayList<String> names = new ArrayList<String>();
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton addNameButton = new JButton("Add Name");
	JButton viewNameButton = new JButton("View Names");

	void run() {
		frame.setVisible(true);
		panel.add(addNameButton);
		panel.add(viewNameButton);
		addNameButton.addActionListener(this);
		viewNameButton.addActionListener(this);
		frame.add(panel);
		frame.pack();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub\
		String askName;
		if (e.getSource() == addNameButton) {
			askName = JOptionPane.showInputDialog("For who today?");
			names.add(askName);
		} else {
			String output = "";
			for (String s : names) {
				output += s + "\n";
			}
			JOptionPane.showMessageDialog(null, output);
		}

	}

	
}
