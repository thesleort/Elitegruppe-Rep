package ui;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import base.*;

public class Gui extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	JButton btnNewButton;
	JTextArea log;
	FileSelector fileSelector;
	public Gui() {
		
		setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("Velkommen, vælg venligt en fil."); //Text	
		lblNewLabel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		add(lblNewLabel, BorderLayout.NORTH);	
		
		this.btnNewButton = new JButton("Vælg fil"); //knap
		btnNewButton.addActionListener(this);
		btnNewButton.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
		add(btnNewButton, BorderLayout.CENTER);
	
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNewButton) { //Hvis knappen bliver trykket på, starter følgende event:
			fileSelector = new FileSelector();
			FileOperation fileop = new FileOperation();
			try {
				ArrayList<String> names = fileop.FileRead(FileSelector.chosenFile);
				fileop.Sort(names);
				fileop.FileWriteArray(names,"SortedName");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	
    }
}
