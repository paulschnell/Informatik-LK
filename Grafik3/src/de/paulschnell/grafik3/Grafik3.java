package de.paulschnell.grafik3;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Canvas;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Grafik3 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Grafik3 frame = new Grafik3();
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
	public Grafik3() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1261, 656);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		Canvas cvCanvas = new Canvas();
		cvCanvas.setBackground(Color.WHITE);
		cvCanvas.setBounds(816, 311, 400, 300);
		contentPane.add(cvCanvas);

		Canvas cvCanvas2 = new Canvas();
		cvCanvas2.setBackground(Color.WHITE);
		cvCanvas2.setBounds(10, 10, 800, 600);
		contentPane.add(cvCanvas2);

		JButton btnMalen = new JButton("Aufgabe 1");
		btnMalen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Graphics graphics = cvCanvas.getGraphics();
				graphics.clearRect(0, 0, cvCanvas.getWidth(), cvCanvas.getHeight());

				Color[] farben = { Color.BLACK, Color.BLUE, Color.CYAN, Color.GREEN, Color.YELLOW };

				for (int i = 0; i < farben.length; i++) {
					graphics.setColor(farben[i]);
					graphics.fillOval(i * 10, i * 10, (cvCanvas.getWidth() / 4) - i * 10 * 2,
							(cvCanvas.getHeight() / 3) - i * 10 * 2);
				}

			}
		});
		btnMalen.setBounds(816, 10, 130, 40);
		contentPane.add(btnMalen);

		JButton btnMalen2 = new JButton("Aufgabe 2");
		btnMalen2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Graphics graphics = cvCanvas.getGraphics();
				graphics.clearRect(0, 0, cvCanvas.getWidth(), cvCanvas.getHeight());

				Color[] farben = { Color.BLACK, Color.BLUE, Color.CYAN, Color.GREEN, Color.YELLOW };

				for (int i = 0; i < cvCanvas.getWidth() / 10 / 4; i++) {
					for (int j = 0; j < farben.length; j++) {
						graphics.setColor(farben[j]);
						graphics.fillOval(i * (cvCanvas.getWidth() / 4) + j * 10, j * 10,
								(cvCanvas.getWidth() / 4) - j * 10 * 2, (cvCanvas.getHeight() / 3) - j * 10 * 2);
					}
				}

			}
		});
		btnMalen2.setBounds(956, 10, 130, 40);
		contentPane.add(btnMalen2);

		JButton btnMalen3 = new JButton("Aufgabe 3");
		btnMalen3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Graphics graphics = cvCanvas.getGraphics();
				graphics.clearRect(0, 0, cvCanvas.getWidth(), cvCanvas.getHeight());

				Color[] farben = { Color.BLACK, Color.BLUE, Color.CYAN, Color.GREEN, Color.YELLOW };

				for (int k = 0; k < cvCanvas.getHeight() / 10 / 3; k++) {
					for (int i = 0; i < cvCanvas.getWidth() / 10 / 4; i++) {
						for (int j = 0; j < farben.length; j++) {
							graphics.setColor(farben[j]);
							graphics.fillOval(i * (cvCanvas.getWidth() / 4) + j * 10,
									k * (cvCanvas.getHeight() / 3) + j * 10, (cvCanvas.getWidth() / 4) - j * 10 * 2,
									(cvCanvas.getHeight() / 3) - j * 10 * 2);
						}
					}
				}

			}
		});
		btnMalen3.setBounds(1096, 10, 130, 40);
		contentPane.add(btnMalen3);

		JButton btnMalen4 = new JButton("Aufgabe 4");
		btnMalen4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Graphics graphics = cvCanvas2.getGraphics();
				graphics.clearRect(0, 0, cvCanvas2.getWidth(), cvCanvas2.getHeight());

				Color[] farben = { Color.BLACK, Color.BLUE, Color.CYAN, Color.GREEN, Color.YELLOW, Color.MAGENTA,
						Color.RED, Color.ORANGE };

				for (int i = 0; i < farben.length; i++) {
					graphics.setColor(farben[i]);
					graphics.drawOval(i * 100, 0, 100, 100);
				}

			}
		});
		btnMalen4.setBounds(816, 60, 130, 40);
		contentPane.add(btnMalen4);

		JButton btnMalen5 = new JButton("Aufgabe 5");
		btnMalen5.setBounds(956, 60, 130, 40);
		btnMalen5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Graphics graphics = cvCanvas2.getGraphics();
				graphics.clearRect(0, 0, cvCanvas2.getWidth(), cvCanvas2.getHeight());

				Color[] farben = { Color.BLACK, Color.BLUE, Color.CYAN, Color.GREEN, Color.YELLOW, Color.MAGENTA,
						Color.RED, Color.ORANGE };

//				for (int i = 0; i < farben.length; i++) {
//					graphics.setColor(farben[i]);
//					graphics.drawOval(i * cvCanvas2.getHeight() + i * 5, 0 + i * 5, cvCanvas2.getHeight() - i * 10, cvCanvas2.getHeight() - i * 10);
//				}

				for (int i = 0; i < farben.length; i++) {
					graphics.setColor(farben[i]);
					graphics.drawOval(100 * i + (5 * 10 - i * 5), 5 * 10 - i * 5, (i + 1) * 10, (i + 1) * 10);
				}

			}
		});
		contentPane.add(btnMalen5);

		JButton btnMalen6 = new JButton("Aufgabe 6");
		btnMalen6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Graphics graphics = cvCanvas2.getGraphics();
				graphics.clearRect(0, 0, cvCanvas2.getWidth(), cvCanvas2.getHeight());

				Color[] farben = { Color.BLACK, Color.BLUE, Color.CYAN, Color.GREEN, Color.YELLOW, Color.MAGENTA,
						Color.RED, Color.ORANGE };

//				for (int i = 0; i < farben.length; i++) {
//					graphics.setColor(farben[i]);
//					graphics.drawOval(i * cvCanvas2.getHeight() + i * 5, 0 + i * 5, cvCanvas2.getHeight() - i * 10, cvCanvas2.getHeight() - i * 10);
//				}

				for (int j = 0; j < 6; j++) {
					for (int i = 0; i < farben.length; i++) {
						graphics.setColor(farben[i]);
						graphics.drawOval(100 * i + (5 * 10 - i * 5), 100 * j + 5 * 10 - i * 5, (i + 1) * 10,
								(i + 1) * 10);
					}
				}

			}
		});
		btnMalen6.setBounds(1096, 60, 130, 40);
		contentPane.add(btnMalen6);

		JButton btnMalen7 = new JButton("Aufgabe 7");
		btnMalen7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Graphics graphics = cvCanvas2.getGraphics();
				graphics.clearRect(0, 0, cvCanvas2.getWidth(), cvCanvas2.getHeight());

				Color[] farben = { Color.BLACK, Color.BLUE, Color.CYAN, Color.GREEN, Color.YELLOW, Color.MAGENTA,
						Color.RED, Color.ORANGE };

//				for (int i = 0; i < farben.length; i++) {
//					graphics.setColor(farben[i]);
//					graphics.drawOval(i * cvCanvas2.getHeight() + i * 5, 0 + i * 5, cvCanvas2.getHeight() - i * 10, cvCanvas2.getHeight() - i * 10);
//				}

				for (int j = 0; j < 6; j++) {
					for (int i = 0; i < farben.length; i++) {
						graphics.setColor(farben[i]);
						graphics.drawOval(100 * i + (5 * 10 - i * 5) - j * 5, 100 * j + 5 * 10 - i * 5 - j * 5,
								(i + 1) * 10 + j * 10, (i + 1) * 10 + j * 10);
					}
				}

			}
		});
		btnMalen7.setBounds(816, 110, 130, 40);
		contentPane.add(btnMalen7);

		JButton btnMalen8 = new JButton("Aufgabe 8");
		btnMalen8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Graphics graphics = cvCanvas2.getGraphics();
				graphics.clearRect(0, 0, cvCanvas2.getWidth(), cvCanvas2.getHeight());

				Color[] farben = { Color.BLACK, Color.BLUE, Color.CYAN, Color.GREEN, Color.YELLOW, Color.MAGENTA,
						Color.RED, Color.ORANGE };

//				for (int i = 0; i < farben.length; i++) {
//					graphics.setColor(farben[i]);
//					graphics.drawOval(i * cvCanvas2.getHeight() + i * 5, 0 + i * 5, cvCanvas2.getHeight() - i * 10, cvCanvas2.getHeight() - i * 10);
//				}

				for (int j = 0; j < 6; j++) {
					for (int i = 0; i < farben.length; i++) {
						graphics.setColor(farben[i]);
						for (int k = 0; k < 5 + i + j; k++) {
							graphics.drawOval(
									100 * i + (5 * 10 - i * 5) - j * 5,
									100 * j + 5 * 10 - i * 5 - j * 5,
									(i + 1) * 10 + j * 10,
									(i + 1) * 10 + j * 10
							);
						}
					}
				}

			}
		});
		btnMalen8.setBounds(956, 110, 130, 40);
		contentPane.add(btnMalen8);
	}
}
