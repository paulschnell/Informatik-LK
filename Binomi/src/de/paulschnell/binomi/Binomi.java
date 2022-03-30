package de.paulschnell.binomi;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextArea;

public class Binomi extends JFrame {

	private JPanel contentPane;
	private JTextField tfBiKoeff_n;
	private JTextField tfBiKoeffOutput;
	private JTextField tfBiKoeff_k;
	private JLabel lblBiKoeffError;
	private JTextField tfBiForm_n;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Binomi frame = new Binomi();
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
	public Binomi() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
//		erik hat geholfen 	
		JLabel lblBiKoeff_n = new JLabel("Binominalkoeffizient");
		lblBiKoeff_n.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblBiKoeff_n.setBounds(10, 10, 144, 21);
		contentPane.add(lblBiKoeff_n);

		tfBiKoeff_n = new JTextField();
		tfBiKoeff_n.setHorizontalAlignment(SwingConstants.CENTER);
		tfBiKoeff_n.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfBiKoeff_n.setText("0");
		tfBiKoeff_n.setBounds(46, 48, 51, 23);
		contentPane.add(tfBiKoeff_n);
		tfBiKoeff_n.setColumns(10);

		tfBiKoeffOutput = new JTextField();
		tfBiKoeffOutput.setHorizontalAlignment(SwingConstants.CENTER);
		tfBiKoeffOutput.setEditable(false);
		tfBiKoeffOutput.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfBiKoeffOutput.setText("1");
		tfBiKoeffOutput.setBounds(193, 66, 96, 27);
		contentPane.add(tfBiKoeffOutput);
		tfBiKoeffOutput.setColumns(10);

		JButton btnBiKoeffAusrechnen = new JButton("=");
		btnBiKoeffAusrechnen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int n = Integer.parseInt(tfBiKoeff_n.getText());
				int k = Integer.parseInt(tfBiKoeff_k.getText());

				if (k <= n) {
					tfBiKoeffOutput.setText("" + binKoeff(n, k));
					lblBiKoeffError.setText("");
				} else {
					lblBiKoeffError.setText("k darf nicht größer als n sein");
				}
			}
		});
		btnBiKoeffAusrechnen.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnBiKoeffAusrechnen.setBounds(123, 62, 61, 35);
		contentPane.add(btnBiKoeffAusrechnen);

		tfBiKoeff_k = new JTextField();
		tfBiKoeff_k.setText("0");
		tfBiKoeff_k.setHorizontalAlignment(SwingConstants.CENTER);
		tfBiKoeff_k.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfBiKoeff_k.setColumns(10);
		tfBiKoeff_k.setBounds(46, 81, 51, 23);
		contentPane.add(tfBiKoeff_k);

		JLabel lblBiKoeffKlammern = new JLabel("(  )");
		lblBiKoeffKlammern.setFont(new Font("Tahoma", Font.PLAIN, 64));
		lblBiKoeffKlammern.setHorizontalAlignment(SwingConstants.CENTER);
		lblBiKoeffKlammern.setBounds(10, 10, 125, 123);
		contentPane.add(lblBiKoeffKlammern);

		JLabel lblErikWarHier = new JLabel("Erik war hier ඞ");
		lblErikWarHier.setBounds(1167, 670, 89, 13);
		contentPane.add(lblErikWarHier);
		
		lblBiKoeffError = new JLabel("");
		lblBiKoeffError.setForeground(Color.RED);
		lblBiKoeffError.setBounds(10, 114, 279, 23);
		contentPane.add(lblBiKoeffError);
		
		JLabel lblBiForm = new JLabel("Koeffizienten Binomische Formel");
		lblBiForm.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblBiForm.setBounds(10, 165, 237, 21);
		contentPane.add(lblBiForm);
		
		JLabel lblBiFormFormel = new JLabel("");
		lblBiFormFormel.setBackground(Color.WHITE);
		lblBiFormFormel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBiFormFormel.setBounds(10, 204, 291, 42);
		contentPane.add(lblBiFormFormel);
		
		tfBiForm_n = new JTextField();
		tfBiForm_n.setText("0");
		tfBiForm_n.setHorizontalAlignment(SwingConstants.CENTER);
		tfBiForm_n.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfBiForm_n.setColumns(10);
		tfBiForm_n.setBounds(46, 253, 51, 23);
		contentPane.add(tfBiForm_n);
		
		JLabel lblBiForm_n = new JLabel("n:");
		lblBiForm_n.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblBiForm_n.setBounds(10, 254, 25, 20);
		contentPane.add(lblBiForm_n);
		
		JButton btnBiFormAusrechnen = new JButton("=");
		btnBiFormAusrechnen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int n = Integer.parseInt(tfBiForm_n.getText());
				int[] koeffizienten = new int[n];
				koeffizienten[0] = koeffizienten[n - 1] = 1;
				
				for (int k = 0; k < n; k++) {
					if (n % 2 == 0)
					koeffizienten[k] = k < (n / 2) ? binKoeff(n, k) : koeffizienten[];
				}
				
				lblBiFormFormel.setText("");
				for (int k = 0; k < n; k++)
					lblBiFormFormel.setText(lblBiFormFormel.getText() + " " + koeffizienten[k]);
			}
		});
		btnBiFormAusrechnen.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnBiFormAusrechnen.setBounds(110, 247, 61, 35);
		contentPane.add(btnBiFormAusrechnen);
	}

	public int binKoeff(int n, int k) {
		if (k == 0 || k == n)
			return 1;
		else
			return binKoeff(n - 1, k) + binKoeff(n - 1, k - 1);
	}
}
