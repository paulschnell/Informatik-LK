package de.paulschnell.epicRPGDungeonAndMonstersGame.windows;

import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import de.paulschnell.epicRPGDungeonAndMonstersGame.EpicRPGDungeonAndMonstersGame;
import de.paulschnell.epicRPGDungeonAndMonstersGame.Shop;

public class ShopWindow extends JFrame {

	private JPanel contentPane;
	private Shop shop;

	public ShopWindow(Shop shop) {
		this.shop = shop;
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				EpicRPGDungeonAndMonstersGame.frame.setEnabled(true);
				EpicRPGDungeonAndMonstersGame.frame.refresh();
			}
		});
		setResizable(false);
		setAlwaysOnTop(true);
		setTitle("Shop");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
	}

	public void refresh() {

	}

	public void run() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					setVisible(true);
					EpicRPGDungeonAndMonstersGame.frame.setEnabled(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
