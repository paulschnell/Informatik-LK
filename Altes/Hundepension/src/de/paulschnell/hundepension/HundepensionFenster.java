package de.paulschnell.hundepension;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class HundepensionFenster extends JFrame {

	private JPanel contentPane;
	
	private JLabel lblStatus;
	private JButton btnStart;
	private JButton btnFuettern;
	private JButton btnGassiGehen;

	private String name;
	private String rasse;
	private double gewicht;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HundepensionFenster frame = new HundepensionFenster();
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
	public HundepensionFenster() {
		getContentPane().setBackground(Color.WHITE);
		setTitle("Hundepension");
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(HundepensionFenster.class.getResource("/de/paulschnell/hundepension/Hund_Dackel.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.WHITE);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTitel = new JLabel("Willkommen bei der Hundepension");
		lblTitel.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitel.setFont(new Font("Tahoma", Font.BOLD, 32));
		lblTitel.setBounds(10, 10, 766, 39);
		contentPane.add(lblTitel);

		JLabel lblBeschreibung = new JLabel(
				"Gib einen Namen, eine Rasse und ein Startgewicht f\u00FCr deinen Hund ein.");
		lblBeschreibung.setHorizontalAlignment(SwingConstants.CENTER);
		lblBeschreibung.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblBeschreibung.setBounds(10, 56, 766, 25);
		contentPane.add(lblBeschreibung);

		JLabel lblNameFragen = new JLabel("Name deines Hundes:");
		lblNameFragen.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNameFragen.setBounds(71, 141, 178, 32);
		contentPane.add(lblNameFragen);

		JLabel lblRasseFragen = new JLabel("Rasse deines Hundes:");
		lblRasseFragen.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblRasseFragen.setBounds(71, 182, 178, 32);
		contentPane.add(lblRasseFragen);

		JLabel lblGewichtFragen = new JLabel("Gewicht deines Hundes:");
		lblGewichtFragen.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblGewichtFragen.setBounds(71, 221, 196, 32);
		contentPane.add(lblGewichtFragen);

		JTextField tfEingabeName = new JTextField();
		tfEingabeName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tfEingabeName.setBounds(277, 148, 142, 25);
		contentPane.add(tfEingabeName);
		tfEingabeName.setColumns(10);

		JTextField tfEingabeRasse = new JTextField();
		tfEingabeRasse.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tfEingabeRasse.setColumns(10);
		tfEingabeRasse.setBounds(277, 189, 142, 25);
		contentPane.add(tfEingabeRasse);

		JTextField tfEingabeGewicht = new JTextField();
		tfEingabeGewicht.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tfEingabeGewicht.setColumns(10);
		tfEingabeGewicht.setBounds(277, 228, 142, 25);
		contentPane.add(tfEingabeGewicht);
		tfEingabeGewicht.setText("8.00");

		JLabel lblKg = new JLabel("kg");
		lblKg.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblKg.setBounds(441, 225, 45, 32);
		contentPane.add(lblKg);

		JLabel lblBild = new JLabel("");
		lblBild.setIcon(
				new ImageIcon(HundepensionFenster.class.getResource("/de/paulschnell/hundepension/Hund_Dackel.png")));
		lblBild.setBounds(567, 141, 159, 137);
		contentPane.add(lblBild);

		lblStatus = new JLabel("");
		lblStatus.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblStatus.setBounds(71, 320, 655, 32);
		contentPane.add(lblStatus);

		JLabel lblStatusGewicht = new JLabel("");
		lblStatusGewicht.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblStatusGewicht.setBounds(71, 363, 655, 32);
		contentPane.add(lblStatusGewicht);

		
		// Start
		btnStart = new JButton("Start");
		btnStart.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (btnStart.getText().equals("Start")) {
					name = tfEingabeName.getText();
					rasse = tfEingabeRasse.getText();
					gewicht = Double.parseDouble(tfEingabeGewicht.getText());
					
					lblStatus.setText("Dein Hund " + name + ", ein " + rasse + ", ist nun in der Hundepension.");
					lblStatusGewicht.setText("Aktuelles Gewicht: " + String.format("%.2f", gewicht) + " kg.");
					
					tfEingabeName.setEnabled(false);
					tfEingabeRasse.setEnabled(false);
					tfEingabeGewicht.setEnabled(false);
					btnFuettern.setEnabled(true);
					btnGassiGehen.setEnabled(true);
					btnStart.setText("Stop");
				} else {
					lblStatus.setText("Du hast deinen Hund " + name + ", ein " + rasse + ", aus der Hundepension genommen.");
					lblStatusGewicht.setText("Letztes Gewicht: " + String.format("%.2f", gewicht) + " kg.");
					
					tfEingabeName.setEnabled(true);
					tfEingabeRasse.setEnabled(true);
					tfEingabeGewicht.setEnabled(true);
					btnFuettern.setEnabled(false);
					btnGassiGehen.setEnabled(false);
					
					btnStart.setText("Start");
					
					tfEingabeGewicht.setText(String.format("%.2f", gewicht).replace(",", "."));
				}

			}
		});
		btnStart.setBounds(71, 440, 150, 50);
		contentPane.add(btnStart);

		
		// Fuettern
		btnFuettern = new JButton("F\u00FCttern");
		btnFuettern.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (!btnGassiGehen.isEnabled()) {
					btnGassiGehen.setEnabled(true);
				}
				
				if (gewicht < 29.9 && gewicht < 29.8) {
					gewicht += 0.2;
					
					lblStatus.setText("Du hast " + name + ", ein " + rasse + ", gefüttert. (+ 0.2 kg)");
					lblStatusGewicht.setText("Aktuelles Gewicht: " + String.format("%.2f", gewicht) + " kg.");
				} else {
					lblStatus.setText(name + " ist zu schwer. Vielleicht solltest du mit ihm Gassi gehen.");
					lblStatusGewicht.setText("Aktuelles Gewicht: " + String.format("%.2f", gewicht) + " kg.");
					btnFuettern.setEnabled(false);
				}
				
			}
		});
		btnFuettern.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnFuettern.setBounds(360, 440, 150, 50);
		btnFuettern.setEnabled(false);
		contentPane.add(btnFuettern);

		
		// Gassi gehen
		btnGassiGehen = new JButton("Gassi gehen");
		btnGassiGehen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (!btnFuettern.isEnabled()) {
					btnFuettern.setEnabled(true);
				}
				
				if (gewicht >= 4.1) {
					gewicht -= 0.1;
					
					lblStatus.setText("Du bist mit " + name + ", ein " + rasse + ", Gassi gegangen. (- 0.1 kg)");
					lblStatusGewicht.setText("Aktuelles Gewicht: " + String.format("%.2f", gewicht) + " kg.");
				} else {
					lblStatus.setText(name + " ist zu schwach. Vielleicht solltest du ihn mal Füttern.");
					lblStatusGewicht.setText("Aktuelles Gewicht: " + String.format("%.2f", gewicht) + " kg.");
					btnGassiGehen.setEnabled(false);
				}
				
			}
		});
		btnGassiGehen.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnGassiGehen.setBounds(548, 440, 150, 50);
		btnGassiGehen.setEnabled(false);
		contentPane.add(btnGassiGehen);
		
		
		// Dark Mode
		JButton btnDarkLightMode = new JButton("Dark Mode");
		btnDarkLightMode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (btnDarkLightMode.getText().equals("Dark Mode")) {
					btnDarkLightMode.setText("Light Mode");
					
					contentPane.setBackground(Color.DARK_GRAY);
					lblTitel.setForeground(Color.WHITE);
					lblBeschreibung.setForeground(Color.WHITE);
					lblNameFragen.setForeground(Color.WHITE);
					lblRasseFragen.setForeground(Color.WHITE);
					lblGewichtFragen.setForeground(Color.WHITE);
					lblKg.setForeground(Color.WHITE);
					lblStatus.setForeground(Color.WHITE);
					lblStatusGewicht.setForeground(Color.WHITE);
				} else {
					btnDarkLightMode.setText("Dark Mode");

					contentPane.setBackground(Color.WHITE);
					lblTitel.setForeground(Color.BLACK);
					lblBeschreibung.setForeground(Color.BLACK);
					lblNameFragen.setForeground(Color.BLACK);
					lblRasseFragen.setForeground(Color.BLACK);
					lblGewichtFragen.setForeground(Color.BLACK);
					lblKg.setForeground(Color.BLACK);
					lblStatus.setForeground(Color.BLACK);
					lblStatusGewicht.setForeground(Color.BLACK);
				}
				
			}
		});
		btnDarkLightMode.setBounds(681, 528, 105, 25);
		contentPane.add(btnDarkLightMode);
	}
}
