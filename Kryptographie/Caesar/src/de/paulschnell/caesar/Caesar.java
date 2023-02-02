package de.paulschnell.caesar;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Caesar extends JFrame {

	private JPanel contentPane;
	private JTextField tfKey;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Caesar frame = new Caesar();
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
	public Caesar() {
		setTitle("Cearsar Verschluessulung");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 863, 497);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTextArea taInput = new JTextArea();
		taInput.setBounds(39, 40, 354, 215);
		contentPane.add(taInput);

		JTextArea taOutput = new JTextArea();
		taOutput.setBounds(454, 40, 354, 215);
		contentPane.add(taOutput);

		tfKey = new JTextField();
		tfKey.setBounds(39, 292, 96, 19);
		contentPane.add(tfKey);
		tfKey.setColumns(10);

		JButton btnVerschluesseln = new JButton("Verschluesseln");
		btnVerschluesseln.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tfKey.getText().length() == 0) {
					taOutput.setText("");
					return;
				}
				
				int key = (int) tfKey.getText().charAt(0);
				String input = taInput.getText();
				StringBuilder result = new StringBuilder();

				if (input.length() == 0) {
					taOutput.setText("");
					return;
				}
				
				for (int i = 0; i < input.length(); i++) {
					char c = (char)(input.charAt(i) + key);
					if (c > 127) {
						result.append((char)(c - 128));
					} else {
						result.append(c);
					}
				}
				
				taOutput.setText(result.toString());
			}
		});
		btnVerschluesseln.setBounds(278, 361, 115, 42);
		contentPane.add(btnVerschluesseln);

		JButton btnEntschluesseln = new JButton("Entschluesseln");
		btnEntschluesseln.setBounds(454, 361, 115, 42);
		contentPane.add(btnEntschluesseln);

		JButton btnEnde = new JButton("Ende");
		btnEnde.setBounds(723, 385, 85, 28);
		contentPane.add(btnEnde);

		JButton btnClear = new JButton("Clear");
		btnClear.setBounds(723, 347, 85, 28);
		contentPane.add(btnClear);
	}
}
