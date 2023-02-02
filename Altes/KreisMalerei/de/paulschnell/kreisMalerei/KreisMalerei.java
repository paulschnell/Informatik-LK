package de.paulschnell.kreisMalerei;

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

public class KreisMalerei extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KreisMalerei frame = new KreisMalerei();
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
	public KreisMalerei() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 431, 305);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		Canvas cvCanvas = new Canvas();
		cvCanvas.setBackground(Color.WHITE);
		cvCanvas.setBounds(10, 10, 250, 250);
		contentPane.add(cvCanvas);

		JButton btnMalen = new JButton("Malen Kreise 1");
		btnMalen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Graphics graphics = cvCanvas.getGraphics();

				Color[] farben = { Color.CYAN, Color.MAGENTA, Color.GREEN, Color.YELLOW, Color.RED };

				for (int i = 0; i < farben.length; i++) {
					graphics.setColor(farben[i]);
					graphics.fillOval(0 + i * 20, 0 + i * 20, 250 - i * 40, 250 - i * 40);
				}

			}
		});
		btnMalen.setBounds(276, 10, 130, 40);
		contentPane.add(btnMalen);
		
		JButton btnMalen2 = new JButton("Malen Kreise 2");
		btnMalen2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Graphics graphics = cvCanvas.getGraphics();

				Color[] farben = { Color.RED, Color.WHITE };

				for (int i = 0; i < 200; i++) {
					if (i % 2 == 0) {
						graphics.setColor(farben[0]);
					} else {
						graphics.setColor(farben[1]);
					}
					
					graphics.fillOval(0 + i * 1, 0 + i * 1, 250 - i * 2, 250 - i * 2);
				}

			}
		});
		btnMalen2.setBounds(276, 60, 130, 40);
		contentPane.add(btnMalen2);
	}
}
