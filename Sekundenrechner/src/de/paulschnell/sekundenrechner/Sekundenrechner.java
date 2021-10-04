package de.paulschnell.sekundenrechner;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class Sekundenrechner extends JFrame {

	private JPanel contentPane;
	private JTextField tfEingabeTage;
	private JTextField tfEingabeStunden;
	private JTextField tfEingabeMinuten;
	private JTextField tfEingabeSekunden;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sekundenrechner frame = new Sekundenrechner();
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
	public Sekundenrechner() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitel = new JLabel("Willkommen beim Sekundenrechner");
		lblTitel.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitel.setFont(new Font("Tahoma", Font.BOLD, 32));
		lblTitel.setBounds(10, 10, 766, 39);
		contentPane.add(lblTitel);
		
		JLabel lblBeschreibung = new JLabel("Gib Tage, Stunden, Minuten und/oder Sekunden ein.");
		lblBeschreibung.setHorizontalAlignment(SwingConstants.CENTER);
		lblBeschreibung.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblBeschreibung.setBounds(10, 59, 766, 25);
		contentPane.add(lblBeschreibung);
		
		tfEingabeTage = new JTextField();
		tfEingabeTage.setToolTipText("Tage");
		tfEingabeTage.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tfEingabeTage.setColumns(10);
		tfEingabeTage.setBounds(10, 125, 142, 25);
		contentPane.add(tfEingabeTage);
		
		tfEingabeStunden = new JTextField();
		tfEingabeStunden.setToolTipText("Stunden");
		tfEingabeStunden.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tfEingabeStunden.setColumns(10);
		tfEingabeStunden.setBounds(215, 125, 142, 25);
		contentPane.add(tfEingabeStunden);
		
		tfEingabeMinuten = new JTextField();
		tfEingabeMinuten.setToolTipText("Minuten");
		tfEingabeMinuten.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tfEingabeMinuten.setColumns(10);
		tfEingabeMinuten.setBounds(422, 125, 142, 25);
		contentPane.add(tfEingabeMinuten);
		
		tfEingabeSekunden = new JTextField();
		tfEingabeSekunden.setToolTipText("Sekunden");
		tfEingabeSekunden.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tfEingabeSekunden.setColumns(10);
		tfEingabeSekunden.setBounds(634, 125, 142, 25);
		contentPane.add(tfEingabeSekunden);
		
		JLabel lblTage = new JLabel("Tage");
		lblTage.setHorizontalAlignment(SwingConstants.CENTER);
		lblTage.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTage.setBounds(10, 160, 142, 25);
		contentPane.add(lblTage);
		
		JLabel lblStunden = new JLabel("Stunden");
		lblStunden.setHorizontalAlignment(SwingConstants.CENTER);
		lblStunden.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblStunden.setBounds(215, 160, 142, 25);
		contentPane.add(lblStunden);
		
		JLabel lblMinuten = new JLabel("Minuten");
		lblMinuten.setHorizontalAlignment(SwingConstants.CENTER);
		lblMinuten.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMinuten.setBounds(422, 160, 142, 25);
		contentPane.add(lblMinuten);
		
		JLabel lblSekunden = new JLabel("Sekunden");
		lblSekunden.setHorizontalAlignment(SwingConstants.CENTER);
		lblSekunden.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSekunden.setBounds(634, 160, 142, 25);
		contentPane.add(lblSekunden);
	}
}
