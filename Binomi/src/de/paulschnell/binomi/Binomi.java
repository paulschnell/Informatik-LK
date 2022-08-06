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
import java.awt.Event;

import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

import java.awt.event.AdjustmentListener;
import java.awt.event.AdjustmentEvent;

public class Binomi extends JFrame {

	private JPanel contentPane;
	private JTextField tfBiKoeff_n;
	private JTextField tfBiKoeffOutput;
	private JTextField tfBiKoeff_k;
	private JLabel lblBiKoeffError;
	private JTextField tfBiForm_n;
	private JTextField tfPasDrei_n;

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
		setTitle("Binomi");
		String[] exponenten = new String[12 + 1]; // ⁰¹²³⁴⁵⁶⁷⁸⁹
		exponenten[0] = "⁰";
		exponenten[1] = "¹";
		exponenten[2] = "²";
		exponenten[3] = "³";
		exponenten[4] = "⁴";
		exponenten[5] = "⁵";
		exponenten[6] = "⁶";
		exponenten[7] = "⁷";
		exponenten[8] = "⁸";
		exponenten[9] = "⁹";
		exponenten[10] = "¹⁰";
		exponenten[11] = "¹¹";
		exponenten[12] = "¹²";

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
		lblBiFormFormel.setBounds(10, 237, 1244, 27);
		contentPane.add(lblBiFormFormel);

		JLabel lblBiFormKoeffizienten = new JLabel("");
		lblBiFormKoeffizienten.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBiFormKoeffizienten.setBackground(Color.WHITE);
		lblBiFormKoeffizienten.setBounds(10, 263, 1244, 27);
		contentPane.add(lblBiFormKoeffizienten);

		tfBiForm_n = new JTextField();
		tfBiForm_n.setText("0");
		tfBiForm_n.setHorizontalAlignment(SwingConstants.CENTER);
		tfBiForm_n.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfBiForm_n.setColumns(10);
		tfBiForm_n.setBounds(46, 203, 51, 23);
		contentPane.add(tfBiForm_n);

		JLabel lblBiForm_n = new JLabel("n:");
		lblBiForm_n.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblBiForm_n.setBounds(10, 204, 25, 20);
		contentPane.add(lblBiForm_n);

		JButton btnBiFormAusrechnen = new JButton("=");
		btnBiFormAusrechnen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int n = Integer.parseInt(tfBiForm_n.getText());
				int[] koeffizienten = new int[n + 1];

				for (int k = 0; k <= n; k++)
					koeffizienten[k] = binKoeff(n, k);

				if (n < exponenten.length) {

					lblBiFormFormel.setText(koeffizienten[0] + "a" + exponenten[n]);
					lblBiFormKoeffizienten.setText("" + koeffizienten[0]);
					for (int k = 1; k < n; k++) {
						lblBiFormFormel.setText(lblBiFormFormel.getText() + " + " + koeffizienten[k] + "a"
								+ exponenten[n - k] + "b" + exponenten[k]);

						lblBiFormKoeffizienten.setText(lblBiFormKoeffizienten.getText() + ", " + koeffizienten[k]);
					}
					lblBiFormFormel.setText(lblBiFormFormel.getText() + " + " + koeffizienten[n] + "b" + exponenten[n]);
					lblBiFormKoeffizienten.setText(lblBiFormKoeffizienten.getText() + ", " + koeffizienten[n]);

				} else {

					lblBiFormFormel.setText(koeffizienten[0] + "a^" + n);
					lblBiFormKoeffizienten.setText("" + koeffizienten[0]);
					for (int k = 1; k < n; k++) {
						lblBiFormFormel.setText(
								lblBiFormFormel.getText() + " + " + koeffizienten[k] + "a^" + (n - k) + " × b^" + k);

						lblBiFormKoeffizienten.setText(lblBiFormKoeffizienten.getText() + ", " + koeffizienten[k]);
					}
					lblBiFormFormel.setText(lblBiFormFormel.getText() + " + " + koeffizienten[n] + "b^" + n);
					lblBiFormKoeffizienten.setText(lblBiFormKoeffizienten.getText() + ", " + koeffizienten[n]);

				}
			}
		});
		btnBiFormAusrechnen.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnBiFormAusrechnen.setBounds(110, 197, 61, 35);
		contentPane.add(btnBiFormAusrechnen);

		JLabel lblPasDrei = new JLabel("Pascal'sche Dreieck bis n");
		lblPasDrei.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPasDrei.setBounds(10, 324, 174, 21);
		contentPane.add(lblPasDrei);

		JLabel lblPasDrei_n = new JLabel("n:");
		lblPasDrei_n.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPasDrei_n.setBounds(10, 356, 25, 20);
		contentPane.add(lblPasDrei_n);

		tfPasDrei_n = new JTextField();
		tfPasDrei_n.setText("0");
		tfPasDrei_n.setHorizontalAlignment(SwingConstants.CENTER);
		tfPasDrei_n.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfPasDrei_n.setColumns(10);
		tfPasDrei_n.setBounds(46, 356, 51, 23);
		contentPane.add(tfPasDrei_n);

		JTextArea taPasDreiDreieck = new JTextArea();
		taPasDreiDreieck.setFont(new Font("Monospaced", Font.PLAIN, 20));
		taPasDreiDreieck.setBounds(10, 387, 1219, 272);
		taPasDreiDreieck.setEditable(false);
		taPasDreiDreieck.setText("1");
		contentPane.add(taPasDreiDreieck);

		JScrollPane scrollBar = new JScrollPane(taPasDreiDreieck);
		scrollBar.setBounds(10, 387, 1219, 272);
		contentPane.add(scrollBar);

		JButton btnPasDreiAusrechnen = new JButton("=");
		btnPasDreiAusrechnen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				taPasDreiDreieckAusrechnen(taPasDreiDreieck);

			}
		});
		btnPasDreiAusrechnen.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnPasDreiAusrechnen.setBounds(110, 349, 61, 35);
		contentPane.add(btnPasDreiAusrechnen);
		
		JButton btnPasDrei_n_a = new JButton("+");
		btnPasDrei_n_a.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				tfPasDrei_n.setText("" + (Integer.parseInt(tfPasDrei_n.getText()) + 1));
				taPasDreiDreieckAusrechnen(taPasDreiDreieck);
				
			}
		});
		btnPasDrei_n_a.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnPasDrei_n_a.setBounds(181, 349, 61, 35);
		contentPane.add(btnPasDrei_n_a);
		
		JButton btnPasDrei_n_s = new JButton("-");
		btnPasDrei_n_s.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (Integer.parseInt(tfPasDrei_n.getText()) > 0)
				tfPasDrei_n.setText("" + (Integer.parseInt(tfPasDrei_n.getText()) - 1));
				taPasDreiDreieckAusrechnen(taPasDreiDreieck);
				
			}
		});
		btnPasDrei_n_s.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnPasDrei_n_s.setBounds(254, 349, 61, 35);
		contentPane.add(btnPasDrei_n_s);
	}

	public int binKoeff(int n, int k) {
		if (k == 0 || k == n)
			return 1;
		else
			return binKoeff(n - 1, k) + binKoeff(n - 1, k - 1);
	}
	
	public void taPasDreiDreieckAusrechnen(JTextArea taPasDreiDreieck) {
		int n = Integer.parseInt(tfPasDrei_n.getText());
		int[][] dreieck = new int[n + 1][1];

		dreieck[0][0] = 1;
		
		for (int m = n; m > 0; m--) {
			dreieck[m] = new int[m + 1];
			for (int k = 0; k < dreieck[m].length; k++)
				dreieck[m][k] = binKoeff(m, k);
		}

		taPasDreiDreieck.setText("");
		for (int m = 0; m <= n; m++) {
			if (m != 0)
			taPasDreiDreieck.setText(taPasDreiDreieck.getText() + "\n");
				
			for (int k = 0; k < dreieck[m].length; k++) {
				taPasDreiDreieck.setText(taPasDreiDreieck.getText() + dreieck[m][k] + " ");
			}
		}
	}
}
