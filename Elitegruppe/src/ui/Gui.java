package ui;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import base.*;
import java.awt.TextArea;
import java.awt.FlowLayout;

public class Gui extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	JButton btnNewButton, btnSort, btnExec, btnSave;
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
		// btnNewButton.setBorder(BorderFactory.createEmptyBorder(20, 20, 20,
		// 20));

		add(btnNewButton);

		this.textArea = new TextArea();
		add(textArea);

		this.btnSort = new JButton("Sortér");
		btnSort.addActionListener(this);
		add(btnSort);

		this.btnExec = new JButton("Udskriv");
		btnExec.addActionListener(this);
		add(btnExec);

		this.btnSave = new JButton("Gem fil");
		btnSave.addActionListener(this);
		add(btnSave);
		fileSelector = new FileSelector();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		FileOperation fileop = new FileOperation();

		if (e.getSource() == btnNewButton) {
			// Hvis knappen bliver trykket på,starter følgende event:
			System.out.println("Waiting for file select");

			fileSelector.FileSelect();
			try {
				names = fileop.FileRead(FileSelector.chosenFile);
			} catch (IOException e1) {
				e1.printStackTrace();
			} catch (NullPointerException e1) {
				System.out.println("No file was chosen");
			}
		} else if (e.getSource() == btnSort) {
			try {
				names = fileop.Sort(names);
				System.out.println("Sorting list");
			} catch (NullPointerException e2) {
				System.out.println("There was no list to sort");
				JOptionPane.showMessageDialog(this,
						"Der er ikke blevet valgt en fil endnu", "Inane error",
						JOptionPane.ERROR_MESSAGE);
			}
		} else if (e.getSource() == btnExec) {
			try {
				for (int i = 0; i < names.size(); i++) {
					textArea.append(names.get(i) + newline);
				}
				textArea.append("---------------------" + newline);
				System.out.println("List printed");
			} catch (NullPointerException e2) {
				System.out.println("There was no list to sort");
				JOptionPane.showMessageDialog(this,
						"Der er ikke blevet valgt en fil endnu", "Inane error",
						JOptionPane.ERROR_MESSAGE);
			}
		} else if (e.getSource() == btnSave) {

			
			try {
				if (names == null) {
					JOptionPane.showMessageDialog(this,
							"Der er ikke nogen fil at gemme", "Inane error",
							JOptionPane.ERROR_MESSAGE);
				} else {
					File path = fileSelector.FileSave();
					fileop.FileWriteArray(names, path);
				}
			} catch (FileNotFoundException | UnsupportedEncodingException e1) {
				// TODO Auto-generated catch block
				System.out.println("No file was saved");
				// e1.printStackTrace();
			} catch (NullPointerException e1) {
				// TODO: handle exception
			}
		}

	}
}
