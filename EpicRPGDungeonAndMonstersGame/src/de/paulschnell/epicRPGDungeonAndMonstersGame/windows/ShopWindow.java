package de.paulschnell.epicRPGDungeonAndMonstersGame.windows;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import de.paulschnell.epicRPGDungeonAndMonstersGame.EpicRPGDungeonAndMonstersGame;
import de.paulschnell.epicRPGDungeonAndMonstersGame.Shop;
import de.paulschnell.epicRPGDungeonAndMonstersGame.ShopHeldenEntry;
import de.paulschnell.epicRPGDungeonAndMonstersGame.ShopWaffenEntry;

public class ShopWindow extends JFrame {

	private JPanel contentPane;
	private JButton[] btnEntries = new JButton[4];
	private JLabel lblGold;
	private JLabel lblInfo;

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
		contentPane.setLayout(null);

		btnEntries[0] = new JButton("");
		btnEntries[0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShopHeldenEntry entry = shop.getHeldenEntry(0);
				if (entry.getKosten() > shop.getInv().getGold()) {
					lblInfo.setForeground(Color.RED);
					lblInfo.setText("Dir fehlen " + (entry.getKosten() - shop.getInv().getGold()) + " Gold.");
					return;
				}
				shop.getInv().setGold(shop.getInv().getGold() - entry.getKosten());
				entry.setGekauft();
				shop.getInv().addHeld(entry.getHeld());
				lblInfo.setForeground(Color.YELLOW);
				lblInfo.setText("Du hast " + entry.getHeld().getName() + " gekauft!");
				refresh();
			}
		});
		btnEntries[0].setBounds(10, 11, 197, 81);
		contentPane.add(btnEntries[0]);

		btnEntries[1] = new JButton("");
		btnEntries[1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShopHeldenEntry entry = shop.getHeldenEntry(1);
				if (entry.getKosten() > shop.getInv().getGold()) {
					lblInfo.setForeground(Color.RED);
					lblInfo.setText("Dir fehlen " + (entry.getKosten() - shop.getInv().getGold()) + " Gold.");
					return;
				}
				shop.getInv().setGold(shop.getInv().getGold() - entry.getKosten());
				entry.setGekauft();
				shop.getInv().addHeld(entry.getHeld());
				lblInfo.setForeground(Color.YELLOW);
				lblInfo.setText("Du hast " + entry.getHeld().getName() + " gekauft!");
				refresh();
			}
		});
		btnEntries[1].setBounds(217, 11, 197, 81);
		contentPane.add(btnEntries[1]);

		btnEntries[2] = new JButton("");
		btnEntries[2].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShopWaffenEntry entry = shop.getWaffenEntry(0);
				if (entry.getKosten() > shop.getInv().getGold()) {
					lblInfo.setForeground(Color.RED);
					lblInfo.setText("Dir fehlen " + (entry.getKosten() - shop.getInv().getGold()) + " Gold.");
					return;
				}
				shop.getInv().setGold(shop.getInv().getGold() - entry.getKosten());
				entry.setGekauft();
				shop.getInv().addWaffe(entry.getWaffe());
				lblInfo.setForeground(Color.YELLOW);
				lblInfo.setText("Du hast " + entry.getWaffe().getName() + " gekauft!");
				refresh();
			}
		});
		btnEntries[2].setBounds(10, 103, 197, 81);
		contentPane.add(btnEntries[2]);

		btnEntries[3] = new JButton("");
		btnEntries[3].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShopWaffenEntry entry = shop.getWaffenEntry(1);
				if (entry.getKosten() > shop.getInv().getGold()) {
					lblInfo.setForeground(Color.RED);
					lblInfo.setText("Dir fehlen " + (entry.getKosten() - shop.getInv().getGold()) + " Gold.");
					return;
				}
				shop.getInv().setGold(shop.getInv().getGold() - entry.getKosten());
				entry.setGekauft();
				shop.getInv().addWaffe(entry.getWaffe());
				lblInfo.setForeground(Color.YELLOW);
				lblInfo.setText("Du hast " + entry.getWaffe().getName() + " gekauft!");
				refresh();
			}
		});
		btnEntries[3].setBounds(217, 103, 197, 81);
		contentPane.add(btnEntries[3]);

		JLabel lblGoldName = new JLabel("Gold:");
		lblGoldName.setForeground(Color.ORANGE);
		lblGoldName.setFont(new Font("Tahoma", Font.ITALIC, 13));
		lblGoldName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGoldName.setBounds(161, 236, 46, 24);
		contentPane.add(lblGoldName);

		lblGold = new JLabel("0");
		lblGold.setForeground(Color.YELLOW);
		lblGold.setHorizontalAlignment(SwingConstants.LEFT);
		lblGold.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblGold.setBounds(219, 236, 46, 24);
		contentPane.add(lblGold);

		lblInfo = new JLabel("");
		lblInfo.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblInfo.setBounds(84, 204, 261, 24);
		contentPane.add(lblInfo);

		JLabel lblBackgroundImg = new JLabel("");
		lblBackgroundImg.setIcon(new ImageIcon(
				ShopWindow.class.getResource("/de/paulschnell/epicRPGDungeonAndMonstersGame/bilder/shop.jpg")));
		lblBackgroundImg.setBounds(0, 0, 444, 271);
		contentPane.add(lblBackgroundImg);

		refresh();
	}

	public void refresh() {
		lblGold.setText(Integer.toString(shop.getInv().getGold()));

		for (int i = 0; i < 2; i++) {
			btnEntries[i].setEnabled(true);
			if (shop.getHeldenEntry(i) != null) {
				ShopHeldenEntry entry = shop.getHeldenEntry(i);
				btnEntries[i].setText("Held: " + entry.getHeld().getName() + " - " + entry.getKosten() + " Gold");
				if (entry.isGekauft())
					btnEntries[i].setEnabled(false);
			}
		}
		for (int i = 0; i < 2; i++) {
			btnEntries[i + 2].setEnabled(true);
			if (shop.getWaffenEntry(i) != null) {
				ShopWaffenEntry entry = shop.getWaffenEntry(i);
				btnEntries[i + 2].setText("Waffe: " + entry.getWaffe().getName() + " - " + entry.getKosten() + " Gold");
				if (entry.isGekauft())
					btnEntries[i + 2].setEnabled(false);
			}
		}
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
