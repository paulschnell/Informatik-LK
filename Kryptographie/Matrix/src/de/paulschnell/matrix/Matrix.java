package de.paulschnell.matrix;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Matrix extends JFrame {

	private JPanel contentPane;
	private JTextField tfKey;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Matrix frame = new Matrix();
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
	public Matrix() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1015, 596);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea taEntschluesselt = new JTextArea();
		taEntschluesselt.setBounds(21, 26, 379, 141);
		contentPane.add(taEntschluesselt);
		
		JTextArea taVerschluesselt = new JTextArea();
		taVerschluesselt.setBounds(21, 207, 379, 141);
		contentPane.add(taVerschluesselt);
		
		JButton btnVerschluesseln = new JButton("Verschluesseln");
		btnVerschluesseln.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int key = Integer.parseInt(tfKey.getText());
				String input = taEntschluesselt.getText();
				
				
			}
		});
		btnVerschluesseln.setBounds(21, 419, 106, 38);
		contentPane.add(btnVerschluesseln);
		
		JButton btnEntschluesseln = new JButton("Entschluesseln");
		btnEntschluesseln.setBounds(294, 419, 106, 38);
		contentPane.add(btnEntschluesseln);
		
		tfKey = new JTextField();
		tfKey.setBounds(21, 358, 96, 28);
		contentPane.add(tfKey);
		tfKey.setColumns(10);
	}
}
