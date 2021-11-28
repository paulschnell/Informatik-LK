package de.paulschnell.weihnachten;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Weihnachten extends JFrame {

	private JPanel contentPane;

	private Canvas canvas = new Canvas();
	private JButton btnSchneeRaeumen = new JButton("Schnee r\u00E4umen");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Weihnachten frame = new Weihnachten();
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
	public Weihnachten() {
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				
				canvas.setBounds(10, 10, getWidth() - (450 - 416), getHeight() - (300 - 202));
				btnSchneeRaeumen.setBounds(getWidth() / 2 - btnSchneeRaeumen.getWidth() / 2, getHeight() - 80, 142, 35);
				
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		canvas.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				
				int x = (int) (Math.random() * getWidth());
				int y = (int) (Math.random() * getHeight());
				
				Color[] farben = { Color.WHITE, Color.ORANGE, Color.BLUE, Color.CYAN, Color.GREEN, Color.MAGENTA, Color.RED, Color.YELLOW };
				
				Graphics graphics = canvas.getGraphics();
				
				graphics.setColor(farben[(int) Math.random() * farben.length]);
				graphics.drawString("*", x, y);
				
			}
		});
		
		canvas.setBackground(Color.BLACK);
		canvas.setBounds(10, 10, 416, 202);
		contentPane.add(canvas);
		
		btnSchneeRaeumen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSchneeRaeumen.setBounds(174, 218, 142, 35);
		contentPane.add(btnSchneeRaeumen);
	}
}
