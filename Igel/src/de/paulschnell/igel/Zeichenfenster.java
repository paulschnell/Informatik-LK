package de.paulschnell.igel;

import java.awt.Button;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class Zeichenfenster extends JFrame {

	private Canvas canvas = new Canvas();
	private Igel sonic = new Igel(canvas, 100, 100, 0, Color.BLUE);
	private Igel shadow = new Igel(canvas, 200, 100, 0, Color.BLACK);
	
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
		canvas.setBackground(Color.WHITE);
		canvas.setBounds(0, 28, 586, 335);
		contentPane.add(canvas);

		// Button
		Button btnGo = new Button("Go Hedghoggers!");
		btnGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sonic.nEck(8);
				shadow.nEck(9);
			}
		});
		btnGo.setBounds(0, 0, 111, 22);
		contentPane.add(btnGo);
	}
}
