package de.paulschnell.malen;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.Choice;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Malen extends JFrame {

	private Canvas canvas = new Canvas();
	private JPanel contentPane;
	private JLabel lblDurchmesserZahl;
	private JComboBox cbFarbeAuswaehlen;
	private JSlider sliderDurchmesser;

	private Color[] colors = { Color.BLACK, Color.WHITE, Color.BLUE, Color.GREEN, Color.MAGENTA, Color.CYAN, Color.PINK, Color.ORANGE, Color.YELLOW };

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
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 986, 633);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		canvas.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {

				Graphics graphics = canvas.getGraphics();

				if (!radieren) {
					graphics.setColor(colors[cbFarbeAuswaehlen.getSelectedIndex()]);
					graphics.fillOval(e.getX() - sliderDurchmesser.getValue() / 2, e.getY() - sliderDurchmesser.getValue() / 2,  sliderDurchmesser.getValue(), sliderDurchmesser.getValue());
				} else {
					graphics.setColor(Color.WHITE);
					graphics.fillOval(e.getX() - sliderDurchmesser.getValue() / 2, e.getY() - sliderDurchmesser.getValue() / 2, sliderDurchmesser.getValue(), sliderDurchmesser.getValue());
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
		btnLoeschen.setBounds(212, 548, 119, 38);
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
		btnToggleRadieren.setBounds(341, 548, 119, 38);
		contentPane.add(btnToggleRadieren);

		sliderDurchmesser = new JSlider();
		sliderDurchmesser.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {

				lblDurchmesserZahl.setText(String.valueOf(sliderDurchmesser.getValue()));

			}
		});
		sliderDurchmesser.setBounds(10, 564, 200, 22);
		contentPane.add(sliderDurchmesser);

		JLabel lblDurchmesser = new JLabel("Durchmesser:");
		lblDurchmesser.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDurchmesser.setBounds(10, 531, 86, 23);
		contentPane.add(lblDurchmesser);

		lblDurchmesserZahl = new JLabel("50");
		lblDurchmesserZahl.setHorizontalAlignment(SwingConstants.CENTER);
		lblDurchmesserZahl.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDurchmesserZahl.setBounds(92, 531, 37, 23);
		contentPane.add(lblDurchmesserZahl);
		
		cbFarbeAuswaehlen = new JComboBox();
		cbFarbeAuswaehlen.setModel(new DefaultComboBoxModel(new String[] {"Schwarz", "Weiß", "Blau", "Grün", "Magenta", "Chayen", "Pink", "Orange", "Gelb"}));
		cbFarbeAuswaehlen.setSelectedIndex(0);
		cbFarbeAuswaehlen.setBounds(528, 43, 119, 37);
		contentPane.add(cbFarbeAuswaehlen);
	}
}