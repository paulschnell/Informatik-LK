package de.paulschnell.malen;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Malen extends JFrame {

	private Canvas canvas = new Canvas();
	private JPanel contentPane;
	private JLabel lblDurchmesserZahl;
	private JComboBox cbFarbeAuswaehlen;
	private JSlider sliderDurchmesser;
	private JLabel lblRot = new JLabel("255");
	private JLabel lblGruen = new JLabel("255");
	private JLabel lblBlau = new JLabel("255");
	private Canvas cvFarbe;

	private Color[] colors = { Color.BLACK, Color.WHITE, Color.BLUE, Color.GREEN, Color.MAGENTA, Color.CYAN, Color.PINK,
			Color.ORANGE, Color.YELLOW };

	private boolean radieren = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Malen frame = new Malen();
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
	public Malen() {
		setTitle("Malen");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 569);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		canvas.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {

				Graphics graphics = canvas.getGraphics();

				if (!radieren) {
					
					if (cbFarbeAuswaehlen.getSelectedIndex() != 0) {
						graphics.setColor(colors[cbFarbeAuswaehlen.getSelectedIndex() - 1]);
					} else {
						graphics.setColor(new Color(Integer.parseInt(lblRot.getText()),
								Integer.parseInt(lblGruen.getText()), Integer.parseInt(lblBlau.getText())));
					}
					
					graphics.fillOval(e.getX() - sliderDurchmesser.getValue() / 2,
							e.getY() - sliderDurchmesser.getValue() / 2, sliderDurchmesser.getValue(),
							sliderDurchmesser.getValue());
					
				} else {
					
					graphics.setColor(Color.WHITE);
					graphics.fillOval(e.getX() - sliderDurchmesser.getValue() / 2,
							e.getY() - sliderDurchmesser.getValue() / 2, sliderDurchmesser.getValue(),
							sliderDurchmesser.getValue());
					
				}
			}
		});
		canvas.setBackground(Color.WHITE);
		canvas.setBounds(10, 10, 512, 512);
		contentPane.add(canvas);

		JLabel lblFarben = new JLabel("Farbe ausw\u00E4hlen:");
		lblFarben.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblFarben.setBounds(528, 10, 110, 23);
		contentPane.add(lblFarben);

		JButton btnLoeschen = new JButton("L\u00F6schen");
		btnLoeschen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Graphics graphics = canvas.getGraphics();
				graphics.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

			}
		});
		btnLoeschen.setBounds(528, 167, 119, 38);
		contentPane.add(btnLoeschen);

		JButton btnToggleRadieren = new JButton("Radieren");
		btnToggleRadieren.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (!radieren) {
					radieren = true;
					btnToggleRadieren.setText("Zeichnen");
				} else {
					radieren = false;
					btnToggleRadieren.setText("Radieren");
				}

			}
		});
		btnToggleRadieren.setBounds(528, 222, 119, 38);
		contentPane.add(btnToggleRadieren);

		sliderDurchmesser = new JSlider();
		sliderDurchmesser.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {

				lblDurchmesserZahl.setText(String.valueOf(sliderDurchmesser.getValue()));

			}
		});
		sliderDurchmesser.setBounds(528, 134, 200, 22);
		contentPane.add(sliderDurchmesser);

		JLabel lblDurchmesser = new JLabel("Durchmesser:");
		lblDurchmesser.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDurchmesser.setBounds(528, 101, 86, 23);
		contentPane.add(lblDurchmesser);

		lblDurchmesserZahl = new JLabel("50");
		lblDurchmesserZahl.setHorizontalAlignment(SwingConstants.CENTER);
		lblDurchmesserZahl.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDurchmesserZahl.setBounds(610, 101, 37, 23);
		contentPane.add(lblDurchmesserZahl);

		cbFarbeAuswaehlen = new JComboBox();
		cbFarbeAuswaehlen.setModel(new DefaultComboBoxModel(new String[] { "Eigen", "Schwarz", "Weiß", "Blau", "Grün",
				"Magenta", "Chayen", "Pink", "Orange", "Gelb" }));
		cbFarbeAuswaehlen.setSelectedIndex(0);
		cbFarbeAuswaehlen.setBounds(528, 43, 119, 37);
		contentPane.add(cbFarbeAuswaehlen);

		JButton btnFuellen = new JButton("Füllen");
		btnFuellen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Graphics graphics = canvas.getGraphics();
				
				if (cbFarbeAuswaehlen.getSelectedIndex() != 0) {
					graphics.setColor(colors[cbFarbeAuswaehlen.getSelectedIndex() - 1]);
				} else {
					graphics.setColor(new Color(Integer.parseInt(lblRot.getText()),
							Integer.parseInt(lblGruen.getText()), Integer.parseInt(lblBlau.getText())));
				}
				
				graphics.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());

			}
		});
		btnFuellen.setBounds(528, 271, 119, 38);
		contentPane.add(btnFuellen);

		JLabel lblSliderFarben = new JLabel("RGB:");
		lblSliderFarben.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSliderFarben.setBounds(528, 331, 37, 23);
		contentPane.add(lblSliderFarben);

		lblRot.setForeground(Color.RED);
		lblRot.setHorizontalAlignment(SwingConstants.CENTER);
		lblRot.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblRot.setBounds(575, 331, 37, 23);
		contentPane.add(lblRot);

		lblGruen.setForeground(new Color(0, 128, 0));
		lblGruen.setHorizontalAlignment(SwingConstants.CENTER);
		lblGruen.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblGruen.setBounds(610, 331, 37, 23);
		contentPane.add(lblGruen);

		lblBlau.setForeground(new Color(0, 0, 255));
		lblBlau.setHorizontalAlignment(SwingConstants.CENTER);
		lblBlau.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblBlau.setBounds(648, 331, 37, 23);
		contentPane.add(lblBlau);

		cvFarbe = new Canvas();
		cvFarbe.setBackground(new Color(255, 255, 255));
		cvFarbe.setBounds(691, 331, 25, 25);
		contentPane.add(cvFarbe);

		JSlider sliderFarbeRot = new JSlider();
		sliderFarbeRot.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {

				lblRot.setText(String.valueOf(sliderFarbeRot.getValue()));

				try {
					Graphics graphics = cvFarbe.getGraphics();
					graphics.setColor(new Color(Integer.parseInt(lblRot.getText()),
							Integer.parseInt(lblGruen.getText()), Integer.parseInt(lblBlau.getText())));
					graphics.fillRect(0, 0, cvFarbe.getWidth(), cvFarbe.getHeight());
				} catch (Exception ex) {
				}

			}
		});
		sliderFarbeRot.setValue(255);
		sliderFarbeRot.setMaximum(255);
		sliderFarbeRot.setBounds(528, 365, 200, 26);
		contentPane.add(sliderFarbeRot);

		JSlider sliderFarbeGruen = new JSlider();
		sliderFarbeGruen.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {

				lblGruen.setText(String.valueOf(sliderFarbeGruen.getValue()));

				try {
					Graphics graphics = cvFarbe.getGraphics();
					graphics.setColor(new Color(Integer.parseInt(lblRot.getText()),
							Integer.parseInt(lblGruen.getText()), Integer.parseInt(lblBlau.getText())));
					graphics.fillRect(0, 0, cvFarbe.getWidth(), cvFarbe.getHeight());
				} catch (Exception ex) {
				}

			}
		});
		sliderFarbeGruen.setValue(255);
		sliderFarbeGruen.setMaximum(255);
		sliderFarbeGruen.setBounds(528, 402, 200, 26);
		contentPane.add(sliderFarbeGruen);

		JSlider sliderFarbeBlau = new JSlider();
		sliderFarbeBlau.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {

				lblBlau.setText(String.valueOf(sliderFarbeBlau.getValue()));

				try {
					Graphics graphics = cvFarbe.getGraphics();
					graphics.setColor(new Color(Integer.parseInt(lblRot.getText()),
							Integer.parseInt(lblGruen.getText()), Integer.parseInt(lblBlau.getText())));
					graphics.fillRect(0, 0, cvFarbe.getWidth(), cvFarbe.getHeight());
				} catch (Exception ex) {
				}

			}
		});
		sliderFarbeBlau.setValue(255);
		sliderFarbeBlau.setMaximum(255);
		sliderFarbeBlau.setBounds(528, 439, 200, 26);
		contentPane.add(sliderFarbeBlau);
	}
}
