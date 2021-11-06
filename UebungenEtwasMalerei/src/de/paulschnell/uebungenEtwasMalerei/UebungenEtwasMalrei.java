package de.paulschnell.uebungenEtwasMalerei;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class UebungenEtwasMalrei extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UebungenEtwasMalrei frame = new UebungenEtwasMalrei();
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
	public UebungenEtwasMalrei() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 725, 305);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		Canvas cvCanvas = new Canvas();
		cvCanvas.setBackground(Color.WHITE);
		cvCanvas.setBounds(10, 10, 350, 250);
		contentPane.add(cvCanvas);

		JButton btnMalen = new JButton("Aufgabe 1");
		btnMalen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Graphics graphics = cvCanvas.getGraphics();
				clearScreen(graphics, cvCanvas);

				for (int i = 0; i < 10; i++) {
					graphics.drawRect(0 + i * 10, 0 + i * 10, cvCanvas.getWidth() - i * 20, cvCanvas.getHeight() - i * 20);
				}

			}
		});
		btnMalen.setBounds(379, 10, 130, 40);
		contentPane.add(btnMalen);

		JButton btnMalen2 = new JButton("Aufgabe 2");
		btnMalen2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Graphics graphics = cvCanvas.getGraphics();
				clearScreen(graphics, cvCanvas);

				for (int i = 0; i < 10; i++) {
					graphics.drawOval(0 + i * 10, 0 + i * 10, cvCanvas.getWidth() - i * 20, cvCanvas.getHeight() - i * 20);
				}

			}
		});
		btnMalen2.setBounds(379, 60, 130, 40);
		contentPane.add(btnMalen2);

		JButton btnMalen3 = new JButton("Aufgabe 3");
		btnMalen3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Graphics graphics = cvCanvas.getGraphics();
				clearScreen(graphics, cvCanvas);

				for (int i = 0; i < cvCanvas.getWidth() / 10; i++) {
					graphics.drawLine(0 + i * 10, 0, cvCanvas.getWidth() - i * 10, cvCanvas.getHeight());
				}

			}
		});
		btnMalen3.setBounds(379, 110, 130, 40);
		contentPane.add(btnMalen3);

		JButton btnMalen4 = new JButton("Aufgabe 4");
		btnMalen4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Graphics graphics = cvCanvas.getGraphics();
				clearScreen(graphics, cvCanvas);

				graphics.setColor(Color.CYAN);
				for (int i = 0; i < cvCanvas.getHeight() / 10; i++) {
					graphics.drawLine(0, 0 + i * 10, cvCanvas.getWidth(), cvCanvas.getHeight() - i * 10);
				}

			}
		});
		btnMalen4.setBounds(379, 160, 130, 40);
		contentPane.add(btnMalen4);

		JButton btnMalen5 = new JButton("Aufgabe 5");
		btnMalen5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Graphics graphics = cvCanvas.getGraphics();
				clearScreen(graphics, cvCanvas);

				for (int i = 0; i < cvCanvas.getWidth() / 10; i++) {
					graphics.drawLine(0 + i * 10, 0, cvCanvas.getWidth() - i * 10, cvCanvas.getHeight());
				}

				graphics.setColor(Color.CYAN);
				for (int i = 0; i < cvCanvas.getHeight() / 10; i++) {
					graphics.drawLine(0, 0 + i * 10, cvCanvas.getWidth(), cvCanvas.getHeight() - i * 10);
				}

			}
		});
		btnMalen5.setBounds(379, 210, 130, 40);
		contentPane.add(btnMalen5);

		JButton btnMalen6 = new JButton("Aufgabe 6");
		btnMalen6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Graphics graphics = cvCanvas.getGraphics();
				clearScreen(graphics, cvCanvas);
				
				Color[] farben = { Color.WHITE, Color.PINK, Color.BLUE, Color.GREEN, Color.MAGENTA, Color.RED, Color.MAGENTA, Color.GREEN, Color.BLUE, Color.BLACK, Color.YELLOW, Color.RED };
				
				for (int i = 0; i < farben.length; i++) {
					graphics.setColor(farben[i]);
					graphics.fillRect(0 + i * 10, 0 + i * 10, cvCanvas.getWidth() - i * 20, cvCanvas.getHeight() - i * 20);
				}

			}
		});
		btnMalen6.setBounds(525, 10, 130, 40);
		contentPane.add(btnMalen6);

		JButton btnMalen7 = new JButton("Aufgabe 7");
		btnMalen7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Graphics graphics = cvCanvas.getGraphics();
				clearScreen(graphics, cvCanvas);

				for (int i = 0; i < cvCanvas.getWidth() / 10; i++) {
					graphics.drawLine(0 + i * 10, 0, 0 + i * 10, cvCanvas.getHeight());
				}

				for (int i = 0; i < cvCanvas.getHeight() / 10; i++) {
					graphics.drawLine(0, 0 + i * 10, cvCanvas.getWidth(), 0 + i * 10);
				}

			}
		});
		btnMalen7.setBounds(525, 60, 130, 40);
		contentPane.add(btnMalen7);

		JButton btnMalen8 = new JButton("Aufgabe 8");
		btnMalen8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Graphics graphics = cvCanvas.getGraphics();
				clearScreen(graphics, cvCanvas);

				Color[] farben = { Color.WHITE, Color.BLACK };

				for (int i = 0; i < cvCanvas.getHeight() / 10; i++) {
					for (int j = 0; j < cvCanvas.getWidth() / 10; j++) {

						graphics.setColor(farben[(j + i) % 2]);
						graphics.fillRect(0 + j * 10, i * 10, 10 + j * 10, 10 + i * 10);

					}
				}

			}
		});
		btnMalen8.setBounds(525, 110, 130, 40);
		contentPane.add(btnMalen8);
	}

	private static void clearScreen(Graphics graphics, Canvas cvCanvas) {
		graphics.setColor(Color.WHITE);
		graphics.fillRect(0, 0, cvCanvas.getWidth(), cvCanvas.getHeight());
		graphics.setColor(Color.BLACK);
	}
}
