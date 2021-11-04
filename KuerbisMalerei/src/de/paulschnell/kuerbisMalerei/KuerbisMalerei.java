package de.paulschnell.kuerbisMalerei;

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
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class KuerbisMalerei extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KuerbisMalerei frame = new KuerbisMalerei();
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
	public KuerbisMalerei() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Canvas cvCanvas = new Canvas();
		cvCanvas.setBounds(0, 0, 600, 400);
		contentPane.add(cvCanvas);
		
		JButton btnMalen = new JButton("Malen");
		btnMalen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Graphics graphics = cvCanvas.getGraphics();
				
				graphics.setColor(new Color(42, 204, 31));
				graphics.fillRect(0, 300, 600, 100);
				graphics.setColor(new Color(6, 10, 46));
				graphics.fillRect(0, 0, 600, 300);
				
				graphics.setColor(new Color(247, 132, 0));
				graphics.fillOval(24, 24, 576, 376);
				
				graphics.setColor(Color.BLACK);
				graphics.fillPolygon(new int[]{ 176, 151, 201 }, new int[]{ 166, 126, 126 }, 3);
				graphics.fillPolygon(new int[]{ 426, 401, 451 }, new int[]{ 166, 126, 126 }, 3);
				
				graphics.fillOval(101, 166, 400, 166);
				
				graphics.setColor(new Color(247, 132, 0));
				graphics.fillRect(101, 166, 400, 90);
				graphics.fillRect(101, 296, 400, 40);
				
				graphics.fillRect(120, 254, 20, 20);
				graphics.fillRect(180, 254, 20, 20);
				graphics.fillRect(240, 254, 20, 20);
				graphics.fillRect(300, 254, 20, 20);
				graphics.fillRect(360, 254, 20, 20);
				graphics.fillRect(410, 254, 20, 20);
				graphics.fillRect(460, 254, 20, 20);
				
				graphics.setColor(Color.BLACK);
				graphics.drawOval(24, 24, 576, 376);
				graphics.drawOval(44, 24, 536, 376);
				graphics.drawOval(84, 24, 456, 376);
				graphics.drawOval(164, 24, 296, 376);
				graphics.drawLine(304, 24, 304, 406);
				
				graphics.setColor(new Color(26, 107, 46));
				graphics.fillRect(278, 0, 40, 60);
				
			}
		});
		btnMalen.setBounds(606, 32, 130, 50);
		contentPane.add(btnMalen);
	}
}
