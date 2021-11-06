package de.paulschnell.bundeswettbewerbInformatik;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class Wortsuche extends JFrame {

	private JPanel contentPane;
	private JTextField tfWortHinzufuegen;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Wortsuche frame = new Wortsuche();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Wortsuche() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tfWortHinzufuegen = new JTextField();
		tfWortHinzufuegen.setBounds(606, 60, 96, 19);
		contentPane.add(tfWortHinzufuegen);
		tfWortHinzufuegen.setColumns(10);
		
		JLabel lblWoerter = new JLabel("");
		lblWoerter.setBounds(596, 153, 45, 13);
		contentPane.add(lblWoerter);
		
		JButton btnBestaetigen = new JButton("Best\u00E4tigen");
		btnBestaetigen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (tfWortHinzufuegen.getText().equals("")) {
					return;
				}
				
				lblWoerter.setText(lblWoerter.getText() + ", " + tfWortHinzufuegen.getText());
				
			}
		});
		btnBestaetigen.setBounds(603, 89, 85, 21);
		contentPane.add(btnBestaetigen);
	}
}
