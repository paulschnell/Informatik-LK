package de.paulschnell.sekundenrechner;

import java.awt.Color;
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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Sekundenrechner extends JFrame {

	private JPanel contentPane;
	private JTextField tfEingabeTage;
	private JTextField tfEingabeStunden;
	private JTextField tfEingabeMinuten;
	private JTextField tfEingabeSekunden;
	private JLabel lblAusgabe;
	
	private JButton btnUmrechnenTage;
	private JButton btnUmrechnenStunden;
	private JButton btnUmrechnenMinuten;
	private JButton btnUmrechnenSekunden;
	
	private double tage = 0;
	private double stunden = 0;
	private double minuten = 0;
	private double sekunden = 0;

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
		
		lblAusgabe = new JLabel("");
		lblAusgabe.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAusgabe.setBounds(10, 387, 766, 25);
		contentPane.add(lblAusgabe);

		tfEingabeTage = new JTextField();
		tfEingabeTage.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				tage = tfEingabeTage.getText().equals("") ? 0 : Double.parseDouble(tfEingabeTage.getText());	
				
			}
		});
		tfEingabeTage.setText("0");
		tfEingabeTage.setToolTipText("Tage");
		tfEingabeTage.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tfEingabeTage.setColumns(10);
		tfEingabeTage.setBounds(10, 125, 142, 25);
		contentPane.add(tfEingabeTage);

		tfEingabeStunden = new JTextField();
		tfEingabeStunden.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				stunden = tfEingabeStunden.getText().equals("") ? 0 : Double.parseDouble(tfEingabeStunden.getText());
				
			}
		});
		tfEingabeStunden.setText("0");
		tfEingabeStunden.setToolTipText("Stunden");
		tfEingabeStunden.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tfEingabeStunden.setColumns(10);
		tfEingabeStunden.setBounds(215, 125, 142, 25);
		contentPane.add(tfEingabeStunden);

		tfEingabeMinuten = new JTextField();
		tfEingabeMinuten.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				minuten = tfEingabeMinuten.getText().equals("") ? 0 : Double.parseDouble(tfEingabeMinuten.getText());
				
			}
		});
		tfEingabeMinuten.setText("0");
		tfEingabeMinuten.setToolTipText("Minuten");
		tfEingabeMinuten.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tfEingabeMinuten.setColumns(10);
		tfEingabeMinuten.setBounds(422, 125, 142, 25);
		contentPane.add(tfEingabeMinuten);

		tfEingabeSekunden = new JTextField();
		tfEingabeMinuten.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				sekunden = tfEingabeSekunden.getText().equals("") ? 0 : Double.parseDouble(tfEingabeSekunden.getText());
				
			}
		});
		tfEingabeSekunden.setText("0");
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

		JLabel lblUmrechnenIn = new JLabel("Umrechnen in:");
		lblUmrechnenIn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblUmrechnenIn.setBounds(10, 225, 142, 25);
		contentPane.add(lblUmrechnenIn);

		btnUmrechnenTage = new JButton("Tage");
		btnUmrechnenTage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				lblAusgabe.setText(Double.toString(tage + (stunden / 24) + (minuten / 60 / 24) + (sekunden / 60 / 60 / 24)));

			}
		});
		btnUmrechnenTage.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnUmrechnenTage.setBounds(10, 272, 142, 48);
		contentPane.add(btnUmrechnenTage);

		btnUmrechnenStunden = new JButton("Stunden");
		btnUmrechnenStunden.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				lblAusgabe.setText(Double.toString((tage * 24) + stunden + (minuten / 60) + (sekunden / 60 / 60)));

			}
		});
		btnUmrechnenStunden.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnUmrechnenStunden.setBounds(215, 272, 142, 48);
		contentPane.add(btnUmrechnenStunden);

		btnUmrechnenMinuten = new JButton("Minuten");
		btnUmrechnenMinuten.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				lblAusgabe.setText(Double.toString((tage * 24 * 60) + (stunden * 60) + minuten + (sekunden / 60)));

			}
		});
		btnUmrechnenMinuten.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnUmrechnenMinuten.setBounds(422, 272, 142, 48);
		contentPane.add(btnUmrechnenMinuten);

		btnUmrechnenSekunden = new JButton("Sekunden");
		btnUmrechnenSekunden.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				lblAusgabe.setText(Double.toString((tage * 24 * 60 * 60) + (stunden * 60 * 60) + (minuten * 60) + sekunden));

			}
		});
		btnUmrechnenSekunden.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnUmrechnenSekunden.setBounds(634, 272, 142, 48);
		contentPane.add(btnUmrechnenSekunden);
	}
}
