package de.paulschnell.beispielHUESchleifen;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Canvas;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GrafikTest extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GrafikTest frame = new GrafikTest();
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
	public GrafikTest() {
		setTitle("Grafik Test 19.11.2021");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1061, 891);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		Canvas canvas = new Canvas();
		canvas.setBackground(Color.WHITE);
		canvas.setBounds(10, 10, 800, 800);
		contentPane.add(canvas);

		JButton Aufgabe1BTN = new JButton("Aufgabe 1");
		Aufgabe1BTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Aufgabe 1

				Graphics graphics = canvas.getGraphics();

				graphics.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

				graphics.setColor(Color.CYAN);

				for (int i = 0; i < canvas.getWidth() / 100; i++) {
					graphics.fillOval(0 + i * 100, 0 + i * 100, 100, 100);
				}

			}
		});
		Aufgabe1BTN.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Aufgabe1BTN.setBounds(850, 246, 148, 70);
		contentPane.add(Aufgabe1BTN);

		JButton Aufgabe2BTN = new JButton("Aufgabe 2");
		Aufgabe2BTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Aufgabe 2

				Graphics graphics = canvas.getGraphics();

				graphics.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

				Color[] farben = { Color.CYAN, Color.GREEN, Color.RED, Color.YELLOW, Color.BLUE, Color.MAGENTA,
						Color.BLACK, Color.pink };

				for (int ix = 0; ix < farben.length; ix++) {
					graphics.setColor(farben[ix]);
					graphics.fillOval(ix * 100, 0, 100, 100);
				}

			}
		});
		Aufgabe2BTN.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Aufgabe2BTN.setBounds(850, 344, 148, 70);
		contentPane.add(Aufgabe2BTN);

		JButton Aufgabe3BTN = new JButton("Aufgabe 3");
		Aufgabe3BTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Aufgabe 3

				Graphics graphics = canvas.getGraphics();

				graphics.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

				Color[] farben = { Color.CYAN, Color.GREEN, Color.RED, Color.YELLOW, Color.BLUE, Color.MAGENTA,
						Color.BLACK, Color.pink };

				for (int iy = 0; iy < farben.length; iy++) {
					for (int ix = 0; ix < farben.length; ix++) {
						graphics.setColor(farben[ix]);
						graphics.fillOval(ix * 100, iy * 100, 100, 100);
					}
				}
			}
		});
		Aufgabe3BTN.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Aufgabe3BTN.setBounds(850, 441, 148, 70);
		contentPane.add(Aufgabe3BTN);

		JButton Aufgabe4BTN = new JButton("Aufgabe 4");
		Aufgabe4BTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Aufgabe 4

				Graphics graphics = canvas.getGraphics();

				graphics.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

				for (int i = 0; i < 8; i++) {
					for (int j = 0; j < 8; j++) {
						graphics.drawLine(0 + j * 100, 0, 0 + j * 100, canvas.getHeight());
						graphics.drawLine(0, 0 + j * 100, canvas.getWidth(), 0 + j * 100);

					}
				}

				for (int iy = 0; iy < 8; iy++) {
					for (int ix = 0; ix < 8; ix++) {
						graphics.setColor(Color.RED);
						graphics.fillOval(ix * 100 + iy * 5, iy * 100 + iy * 5, 100 - iy * 10, 100 - iy * 10);
						graphics.setColor(Color.YELLOW);
						graphics.fillOval(ix * 100 + iy * 5 + 10, iy * 100 + iy * 5 + 10, 100 - iy * 10 - 20,
								100 - iy * 10 - 20);
					}
				}

			}
		});
		Aufgabe4BTN.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Aufgabe4BTN.setBounds(850, 533, 148, 70);
		contentPane.add(Aufgabe4BTN);
	}
}
