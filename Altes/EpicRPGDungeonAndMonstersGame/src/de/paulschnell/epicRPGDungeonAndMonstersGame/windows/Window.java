package de.paulschnell.epicRPGDungeonAndMonstersGame.windows;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import de.paulschnell.epicRPGDungeonAndMonstersGame.Drops;
import de.paulschnell.epicRPGDungeonAndMonstersGame.Erpgdamg;
import de.paulschnell.epicRPGDungeonAndMonstersGame.Inventar;
import de.paulschnell.epicRPGDungeonAndMonstersGame.Kampfregel;
import de.paulschnell.epicRPGDungeonAndMonstersGame.Monster;
import de.paulschnell.epicRPGDungeonAndMonstersGame.helden.Held;
import de.paulschnell.epicRPGDungeonAndMonstersGame.helden.Krieger;
import de.paulschnell.epicRPGDungeonAndMonstersGame.helden.Magier;
import de.paulschnell.epicRPGDungeonAndMonstersGame.shop.Shop;
import de.paulschnell.epicRPGDungeonAndMonstersGame.shop.ShopHeldenEntry;
import de.paulschnell.epicRPGDungeonAndMonstersGame.shop.ShopWaffenEntry;

public class Window extends JFrame { // Main window

	private static final long serialVersionUID = 1L; // auto-generated
	private JPanel contentPane;

	private JProgressBar pbHeld;
	private JProgressBar pbMonster;
	private JComboBox comboBox;
	private JLabel lblMonsterIndex;
	private JLabel lblFertig;
	private JLabel lblMonsterBild;
	private JLabel lblHeldBild;
	private JLabel lblWaffe;
	private JLabel lblMonsterName;
	private JLabel lblGold;
	private JLabel lblAbilityChargeName;
	private JLabel lblAbilityCharge;
	private JButton btnAbilityNutzen;

	private int currentMonster = 0;
	private int currentHeld = -1;

	private Inventar inv = new Inventar();
	private Shop shop = new Shop(inv);

	private InventarWindow invWin = new InventarWindow(inv);
	private ShopWindow shopWin = new ShopWindow(shop);

	public Window() {
		setTitle("Epic RPG Dungen And Monsters Game No Similarities With DnD (2022 Copyrighted - for sure)");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		setResizable(false); // das Shop Fenster ist skalierbar
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblMonsterTitle = new JLabel("Monster");
		lblMonsterTitle.setForeground(Color.WHITE);
		lblMonsterTitle.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMonsterTitle.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMonsterTitle.setBounds(1132, 10, 113, 27);
		contentPane.add(lblMonsterTitle);

		JLabel lblHeldTitle = new JLabel("Held");
		lblHeldTitle.setForeground(Color.WHITE);
		lblHeldTitle.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblHeldTitle.setBounds(21, 10, 52, 27);
		contentPane.add(lblHeldTitle);

		JButton btnKaempfen = new JButton("KAEMPFEN");
		btnKaempfen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (currentHeld < 0)
					return;

				Held held = inv.getFreigeschalteteHelden().get(currentHeld);

				held.angreifen(Erpgdamg.monster[currentMonster], new Kampfregel());

				if (Erpgdamg.monster[currentMonster].getLebenspunkte() <= 0) {
					if (currentMonster == Erpgdamg.monster.length - 1) {
						lblFertig.setText("Gewonnen");
						inv.addGold(Erpgdamg.monster[currentMonster].getDrops().muenzen());
						btnKaempfen.setEnabled(false);
						comboBox.setEnabled(false);
					} else {
						inv.addGold(Erpgdamg.monster[currentMonster].getDrops().muenzen());
						if (Erpgdamg.monster[currentMonster].getDrops().dropWaffe())
							inv.addWaffe(Erpgdamg.monster[currentMonster].getDrops().getWaffe());

						currentMonster++;
					}
				} else if (held.getLebenspunkte() <= 0) {
					lblFertig.setText("Verloren");
					btnKaempfen.setEnabled(false);
					comboBox.setEnabled(false);
				}

				// Abilities der Helden updaten
				for (Held curHeld : inv.getFreigeschalteteHelden()) {
					if (curHeld instanceof Krieger) {
						((Krieger) curHeld).setAusdauer(((Krieger) curHeld).getAusdauer() - 3);
						((Krieger) curHeld).erhohlen();
					} else if (curHeld instanceof Magier) {
						((Magier) curHeld).aufladen();
					}
				}

				refresh();
			}
		});
		btnKaempfen.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnKaempfen.setBounds(591, 607, 135, 40);
		contentPane.add(btnKaempfen);

		pbHeld = new JProgressBar();
		pbHeld.setForeground(new Color(0, 255, 0));
		pbHeld.setBounds(21, 53, 260, 27);
		contentPane.add(pbHeld);

		pbMonster = new JProgressBar();
		pbMonster.setBackground(new Color(255, 255, 255));
		pbMonster.setForeground(new Color(0, 255, 0));
		pbMonster.setBounds(927, 53, 260, 27);
		contentPane.add(pbMonster);

		lblFertig = new JLabel("");
		lblFertig.setForeground(Color.YELLOW);
		lblFertig.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 28));
		lblFertig.setHorizontalAlignment(SwingConstants.CENTER);
		lblFertig.setBounds(514, 263, 312, 98);
		contentPane.add(lblFertig);

		comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentHeld = comboBox.getSelectedIndex() - 1;

				if (currentHeld >= 0) {
					Held held = inv.getFreigeschalteteHelden().get(currentHeld);

					if (held instanceof Magier) {
						btnAbilityNutzen.setEnabled(true);
					} else {
						btnAbilityNutzen.setEnabled(false);
					}
				}
				refresh();
			}
		});
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox.setBounds(21, 607, 215, 40);
		contentPane.add(comboBox);

		lblMonsterIndex = new JLabel("1");
		lblMonsterIndex.setForeground(Color.WHITE);
		lblMonsterIndex.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMonsterIndex.setBounds(1208, 47, 48, 40);
		contentPane.add(lblMonsterIndex);

		lblMonsterName = new JLabel("");
		lblMonsterName.setForeground(Color.WHITE);
		lblMonsterName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMonsterName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMonsterName.setBounds(933, 607, 312, 40);
		contentPane.add(lblMonsterName);

		lblMonsterBild = new JLabel("");
		lblMonsterBild.setHorizontalAlignment(SwingConstants.CENTER);
		lblMonsterBild.setBounds(830, 166, 392, 292);
		contentPane.add(lblMonsterBild);

		lblHeldBild = new JLabel("");
		lblHeldBild.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeldBild.setBounds(43, 166, 392, 292);
		contentPane.add(lblHeldBild);

		lblWaffe = new JLabel("");
		lblWaffe.setBounds(387, 418, 150, 129);
		contentPane.add(lblWaffe);

		JButton btnInventar = new JButton("Inventar \u00F6ffnen");
		btnInventar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				invWin.run();
				invWin.refresh();
			}
		});
		btnInventar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnInventar.setBounds(447, 616, 127, 27);
		contentPane.add(btnInventar);

		JLabel lblGoldName = new JLabel("Gold:");
		lblGoldName.setForeground(new Color(218, 165, 32));
		lblGoldName.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblGoldName.setBounds(408, 33, 39, 27);
		contentPane.add(lblGoldName);

		lblGold = new JLabel("0");
		lblGold.setForeground(new Color(255, 255, 0));
		lblGold.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblGold.setBounds(447, 33, 39, 27);
		contentPane.add(lblGold);

		JButton btnShop = new JButton("Shop");
		btnShop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				shopWin.run();
				shopWin.refresh();
			}
		});
		btnShop.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnShop.setBounds(736, 616, 127, 27);
		contentPane.add(btnShop);

		lblAbilityChargeName = new JLabel("");
		lblAbilityChargeName.setForeground(Color.WHITE);
		lblAbilityChargeName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAbilityChargeName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAbilityChargeName.setBounds(43, 469, 127, 27);
		contentPane.add(lblAbilityChargeName);

		lblAbilityCharge = new JLabel("");
		lblAbilityCharge.setHorizontalAlignment(SwingConstants.LEFT);
		lblAbilityCharge.setForeground(Color.WHITE);
		lblAbilityCharge.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAbilityCharge.setBounds(180, 469, 52, 27);
		contentPane.add(lblAbilityCharge);

		btnAbilityNutzen = new JButton("Ability nutzen");
		btnAbilityNutzen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (inv.getFreigeschalteteHelden().get(currentHeld).ability())
					btnAbilityNutzen.setEnabled(false);

				refresh();
			}
		});
		btnAbilityNutzen.setEnabled(false);
		btnAbilityNutzen.setBounds(242, 469, 121, 27);
		contentPane.add(btnAbilityNutzen);

		JLabel lblHintergrund = new JLabel("");
		lblHintergrund.setBounds(0, 0, getWidth(), getHeight());
		lblHintergrund.setIcon(Erpgdamg.pasteImage(
				Window.class.getResource("/de/paulschnell/epicRPGDungeonAndMonstersGame/bilder/hintergrund.png"),
				getWidth(), getHeight()));
		contentPane.add(lblHintergrund);

		refresh();
	}

	// Wird verwendet, um das ganze Fenster zu aktualiesieren, so was wie Bilder,
	// Labels etc.
	public void refresh() {
		Held held = null;
		if (currentHeld >= 0)
			held = inv.getFreigeschalteteHelden().get(currentHeld);

		if (held != null) {
			pbHeld.setMaximum(held.getMaxLebenspunkte());
			pbHeld.setValue(held.getLebenspunkte());

			lblHeldBild.setIcon(Erpgdamg.pasteImage(Window.class.getResource(held.getImgSource()),
					lblHeldBild.getWidth(), lblHeldBild.getHeight()));

			if (held instanceof Krieger) {
				lblAbilityChargeName.setText("Ausdauer:");
				lblAbilityCharge.setText(Integer.toString(((Krieger) held).getAusdauer()));
				btnAbilityNutzen.setEnabled(false);
			} else if (held instanceof Magier) {
				lblAbilityChargeName.setText("Zauberkraft:");
				lblAbilityCharge.setText(Integer.toString(((Magier) held).getZauberkraft()));
				btnAbilityNutzen.setEnabled(true);
			} else {
				lblAbilityChargeName.setText("");
				lblAbilityCharge.setText("");
				btnAbilityNutzen.setEnabled(false);
			}
		} else {
			lblAbilityChargeName.setText("");
			lblAbilityCharge.setText("");
			btnAbilityNutzen.setEnabled(false);

			lblHeldBild.setIcon(null);
		}

		if (held != null && held.getWaffe() != null)
			lblWaffe.setIcon(Erpgdamg.pasteImage(Window.class.getResource(held.getWaffe().getImgSource()),
					lblWaffe.getWidth(), lblWaffe.getHeight()));
		else
			lblWaffe.setIcon(null);

		pbMonster.setMaximum(Erpgdamg.monster[currentMonster].getMaxLebenspunkte());
		pbMonster.setValue(Erpgdamg.monster[currentMonster].getLebenspunkte());

		lblMonsterBild
				.setIcon(Erpgdamg.pasteImage(Window.class.getResource(Erpgdamg.monster[currentMonster].getImgSource()),
						lblMonsterBild.getWidth(), lblMonsterBild.getHeight()));

		lblMonsterIndex.setText(Integer.toString(currentMonster + 1) + "/" + Erpgdamg.monster.length);
		lblMonsterName.setText(Erpgdamg.monster[currentMonster].getName());

		lblGold.setText(Integer.toString(inv.getGold()));

		for (int i = 0; i < 2; i++)
			shop.setHeldenEntry(i, (ShopHeldenEntry) Erpgdamg.monster[currentMonster].getEntries()[i]);
		for (int i = 0; i < 2; i++)
			shop.setWaffenEntry(i, (ShopWaffenEntry) Erpgdamg.monster[currentMonster].getEntries()[i + 2]);

		String[] heldenNamen = new String[inv.getFreigeschalteteHelden().size() + 1];
		for (int i = 0; i < inv.getFreigeschalteteHelden().size(); i++) {
			heldenNamen[i + 1] = inv.getFreigeschalteteHelden().get(i).getName();
		}
		heldenNamen[0] = "Keiner Ausgewählt.";
		comboBox.setModel(new DefaultComboBoxModel(heldenNamen));
		comboBox.setSelectedIndex(currentHeld + 1);
	}

	public void run() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
