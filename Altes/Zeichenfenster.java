package de.felten.igelgrafik;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Button;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		setBounds(100, 100, 600, 400);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		// Canvas
		Canvas canvas = new Canvas();
		canvas.setBackground(Color.WHITE);
		canvas.setBounds(0, 28, 586, 335);
		contentPane.add(canvas);

		// Igel-Settings
		// Objekt Igel
		int winkel = 0;
		Igel i = new Igel(canvas, canvas.getWidth() / 2 - 50, canvas.getHeight() / 2, winkel);

		// Button
		Button btnGo = new Button("Igel go!");
		btnGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				i.nEck(8);
				i.rechts(360 / 8);

			}
		});
		btnGo.setBounds(0, 0, 70, 22);
		contentPane.add(btnGo);
	}
}
