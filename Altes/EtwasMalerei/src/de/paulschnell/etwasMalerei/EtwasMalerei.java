package de.paulschnell.etwasMalerei;

import java.awt.Canvas;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EtwasMalerei extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EtwasMalerei frame = new EtwasMalerei();					
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
	public EtwasMalerei() {
		setTitle("Etwas Malerei");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Canvas cvCanvas = new Canvas();
		cvCanvas.setBounds(10, 10, 416, 243);
		contentPane.add(cvCanvas);
		
		JButton btnMalen = new JButton("Malen");
		btnMalen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Graphics graphics = cvCanvas.getGraphics();
				
				graphics.drawRect(10, 10, 396, 223);
				graphics.drawOval(10, 10, 396, 223);
				graphics.drawLine(10, 107, 396, 107);
				graphics.drawLine(193, 10, 193, 223);
				
			}
		});
		btnMalen.setBounds(449, 24, 85, 21);
		contentPane.add(btnMalen);
	}
}
