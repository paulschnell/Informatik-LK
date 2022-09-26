package de.paulschnell.epicRPGDungeonAndMonstersGame;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

public class Window extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	private JProgressBar pbHeld;
	private JProgressBar pbMonster;
	private JComboBox comboBox;
	private JLabel lblMonsterIndex;
	private JLabel lblFertig;
	private JLabel lblMonsterBild;
	private JLabel lblHeldBild;
	private JLabel lblWaffe;

	private Held[] helden;
	private Monster[] monster;

	private int currentMonster = 0;
	private int currentHeld = 0;

	private Waffe revolver = new Waffe(5, "Diamant", 0, "/de/paulschnell/epicRPGDungeonAndMonstersGame/revolver.png");
	private Waffe pancada = new Waffe(6, "Stein", 0, "");
	private JLabel lblMonsterName;

	/**
	 * Create the frame.
	 */
	public Window() {
		setTitle("Epic RPG Dungen And Monsters Game No Similarities With DnD (2022 Copyrighted - for sure)");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Load
		helden = new Held[] { new Held("Erik", 2, 1, 100, "/de/paulschnell/epicRPGDungeonAndMonstersGame/erik.png"),
				new Held("Loud", 3, 2, 100, "/de/paulschnell/epicRPGDungeonAndMonstersGame/pancada.jpg") };

		helden[0].setWaffe(revolver);
		
		monster = new Monster[] {
				new Monster(5, 100, "Günther und seine Crew von Olaf",
						"/de/paulschnell/epicRPGDungeonAndMonstersGame/g\u00FCnther_und_seine_crew_von_olaf.gif"),
				new Monster(10, 100, "Der schreckliche Sven",
						"/de/paulschnell/epicRPGDungeonAndMonstersGame/der_schreckliche_sven.jpg"),
				new Monster(15, 100, "OpTic Gaming", "/de/paulschnell/epicRPGDungeonAndMonstersGame/optic_gaming.png"),
				new Monster(20, 100, "Lord Garmadon",
						"/de/paulschnell/epicRPGDungeonAndMonstersGame/lord_garmadon.jpg"),
				new Monster(20, 100, "Der Fliegende Holländer",
						"/de/paulschnell/epicRPGDungeonAndMonstersGame/der_fliegende_hollander.png"),
				new Monster(25, 100, "Evil Morty", "/de/paulschnell/epicRPGDungeonAndMonstersGame/evil_morty.jpg"),
				new Monster(30, 100, "this guy", "/de/paulschnell/epicRPGDungeonAndMonstersGame/this_guy.jpg") };
		// Load

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

		JButton btnKämpfen = new JButton("K\u00C4MPFEN");
		btnKämpfen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				helden[currentHeld].angreifen(monster[currentMonster], new Kampfregel());

				if (monster[currentMonster].getLebenspunkte() <= 0) {
					if (currentMonster == monster.length - 1) {
						lblFertig.setText("Gewonnen");
						btnKämpfen.setEnabled(false);
						comboBox.setEnabled(false);
					} else
						currentMonster++;
				} else if (helden[currentHeld].getLebenspunkte() <= 0) {
					lblFertig.setText("Verloren");
					btnKämpfen.setEnabled(false);
					comboBox.setEnabled(false);
				}

				refresh();

			}
		});
		btnKämpfen.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnKämpfen.setBounds(591, 607, 135, 40);
		contentPane.add(btnKämpfen);

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
		String[] heldenNamen = new String[helden.length];
		for (int i = 0; i < helden.length; i++) {
			heldenNamen[i] = helden[i].getName();
		}
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentHeld = comboBox.getSelectedIndex();
				refresh();
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(heldenNamen));
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
		lblWaffe.setBounds(363, 400, 150, 129);
		contentPane.add(lblWaffe);

		refresh();
	}

	private void refresh() {
		pbHeld.setMaximum(helden[currentHeld].getMaxLebenspunkte());
		pbHeld.setValue(helden[currentHeld].getLebenspunkte());
		pbMonster.setMaximum(monster[currentMonster].getMaxLebenspunkte());
		pbMonster.setValue(monster[currentMonster].getLebenspunkte());

		lblMonsterIndex.setText(Integer.toString(currentMonster + 1) + "/" + monster.length);
		lblMonsterName.setText(monster[currentMonster].getName());

		lblMonsterBild.setIcon(new ImageIcon(Window.class.getResource(monster[currentMonster].getImgSource())));
		lblHeldBild.setIcon(new ImageIcon(Window.class.getResource(helden[currentHeld].getImgSource())));
		if (helden[currentHeld].getWaffe() != null)
			lblWaffe.setIcon(new ImageIcon(Window.class.getResource(helden[currentHeld].getWaffe().getImgSource())));
		else
			lblWaffe.setIcon(null);
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
