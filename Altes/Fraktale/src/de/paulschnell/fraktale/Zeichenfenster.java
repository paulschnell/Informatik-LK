package de.paulschnell.fraktale;

import java.awt.Button;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class Zeichenfenster extends JFrame {
	private JPanel contentPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Zeichenfenster frame = new Zeichenfenster();
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
	public Zeichenfenster() {
		// Frame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 720);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		// Canvas
		Canvas canvas = new Canvas();
		canvas.setBackground(Color.WHITE);
		canvas.setBounds(0, 28, 720, 720);
		contentPane.add(canvas);

		// Igel-Settings
		// Objekt Igel
		Igel i = new Igel(canvas, 2 * canvas.getWidth() / 5 , 4 * canvas.getHeight() / 5 , 0);

		// Button
		Button btnGo = new Button("Igel go!");
		btnGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				i.pythagoras(120, 30);
			}
		});
		btnGo.setBounds(0, 0, 70, 22);
		contentPane.add(btnGo);
		
		JSlider sliderWinkel = new JSlider();
		sliderWinkel.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				
			}
		});
		sliderWinkel.setBounds(742, 28, 200, 22);
		contentPane.add(sliderWinkel);
	}
}
