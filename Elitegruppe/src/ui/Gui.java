package ui;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import base.*;
import java.awt.TextArea;
import java.awt.FlowLayout;

public class Gui extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	JButton btnNewButton, btnSort, btnExec;
	JTextArea log;
	FileSelector fileSelector;
	ArrayList<String> names;
	TextArea textArea;
	boolean fileTrue = false;
	private final static String newline = "\n";

	public Gui() {
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel lblNewLabel = new JLabel("Velkommen, vælg venligt en fil."); // Text
		lblNewLabel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		add(lblNewLabel);

		this.btnNewButton = new JButton("Vælg fil"); // knap
		btnNewButton.addActionListener(this);
		btnNewButton.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

		add(btnNewButton);

		this.textArea = new TextArea();
		add(textArea);

		this.btnSort = new JButton("Sortér");
		btnSort.addActionListener(this);
		add(btnSort);

		this.btnExec = new JButton("Udskriv");
		btnExec.addActionListener(this);
		add(btnExec);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		FileOperation fileop = new FileOperation();
		if (e.getSource() == btnNewButton) { 				// Hvis knappen bliver trykket på,
			System.out.println("Waiting for file select"); 	// starter følgende event:
														
			fileSelector = new FileSelector();
			try {
				names = fileop.FileRead(FileSelector.chosenFile);
				fileop.FileWriteArray(names, "SortedName");
			} catch (IOException e1) {
				e1.printStackTrace();
			} 
		} else if (e.getSource() == btnSort) {
			try {
				names = fileop.Sort(names);
				System.out.println("Sorting list");
			} catch (NullPointerException e2) {
				System.out.println("There was no list to sort");
				JOptionPane.showMessageDialog(this, "Der er ikke blevet valgt en fil endnu", "Inane error",
						JOptionPane.ERROR_MESSAGE);
			}
		} else if (e.getSource() == btnExec) {
			try {
				for (int i = 0; i < names.size(); i++) {
					textArea.append(names.get(i) + newline);
				}
				textArea.append("---------------------" + newline);
				System.out.println("Printing");
			} catch (NullPointerException e2) {
				System.out.println("There was no list to sort");
				// TODO: handle exception
				JOptionPane.showMessageDialog(this, "Der er ikke blevet valgt en fil endnu", "Inane error",
						JOptionPane.ERROR_MESSAGE);
			}

		}

	}
}
