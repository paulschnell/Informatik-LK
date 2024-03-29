package de.paulschnell.epicRPGDungeonAndMonstersGame.windows;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.AbstractListModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import de.paulschnell.epicRPGDungeonAndMonstersGame.Erpgdamg;
import de.paulschnell.epicRPGDungeonAndMonstersGame.Inventar;
import de.paulschnell.epicRPGDungeonAndMonstersGame.Waffe;
import de.paulschnell.epicRPGDungeonAndMonstersGame.helden.Held;
import de.paulschnell.epicRPGDungeonAndMonstersGame.helden.Krieger;
import de.paulschnell.epicRPGDungeonAndMonstersGame.helden.Magier;

public class InventarWindow extends JFrame {

	private JPanel contentPane;
	private Inventar inv;

	private JList<?> listHelden;
	private JList listWaffen;
	private JLabel lblAngriffwert;
	private JLabel lblStaerke;
	private JLabel lblLebenspunkte;
	private JLabel lblBonus;
	private JLabel lblMaterial;
	private JLabel lblMagie;
	private JComboBox cbWaffeAuswaehlen;
	private JLabel lblTyp;

	/**
	 * Create the frame.
	 */
	public InventarWindow(Inventar inv) {
		this.inv = inv;

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				Erpgdamg.frame.setEnabled(true);
				Erpgdamg.frame.refresh();
			}
		});
		setResizable(false);
		setAlwaysOnTop(true);
		setTitle("Inventar");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 642, 564);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblHelden = new JLabel("Freigeschaltete Helden");
		lblHelden.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblHelden.setBounds(10, 11, 238, 34);
		contentPane.add(lblHelden);

		JLabel lblWaffen = new JLabel("Freigeschaltete Waffen");
		lblWaffen.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblWaffen.setBounds(336, 11, 189, 34);
		contentPane.add(lblWaffen);

		listHelden = new JList();
		listHelden.setSelectedIndex(0);
		listHelden.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				// Wenn ein Held ausgewaehlt wird, das Inventar dann geschlossen und wieder
				// geoeffnet, wird der
				// Selected Index verfaelscht, und dieser Code repariert dieses Problem
				if (listHelden.getSelectedIndex() < 0
						|| listHelden.getSelectedIndex() >= inv.getFreigeschalteteHelden().size())
					listHelden.setSelectedIndex(0);

				Held currentHeld = inv.getFreigeschalteteHelden().get(listHelden.getSelectedIndex());
				if (currentHeld == null)
					return;

				lblAngriffwert.setText(Integer.toString(currentHeld.getAngriffswert()));
				lblStaerke.setText(Integer.toString(currentHeld.getStaerke()));
				lblLebenspunkte.setText(Integer.toString(currentHeld.getLebenspunkte()));
				if (currentHeld instanceof Krieger) {
					lblTyp.setText("Krieger");
				} else if (currentHeld instanceof Magier) {
					lblTyp.setText("Magier");
				} else {
					lblTyp.setText("Normie");
				}

				cbWaffeAuswaehlen.setEnabled(true);
				int curHeldIndexWaff = 0;
				if (currentHeld.getWaffe() != null) {
					for (int i = 0; i < inv.getFreigeschalteteWaffen().size(); i++) {
						if (inv.getFreigeschalteteWaffen().get(i).getName().equals(currentHeld.getWaffe().getName())) {
							curHeldIndexWaff = i + 1;
							break;
						}
					}
				}
				cbWaffeAuswaehlen.setSelectedIndex(curHeldIndexWaff);
			}
		});
		listHelden.setFont(new Font("Tahoma", Font.PLAIN, 13));
		listHelden.setBounds(10, 56, 256, 358);
		contentPane.add(listHelden);

		listWaffen = new JList();
		listWaffen.setSelectedIndex(0);
		listWaffen.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				// Wenn ein Held ausgewaehlt wird, das Inventar dann geschlossen und wieder
				// geoeffnet, wird der
				// Selected Index verfaelscht, und dieser Code repariert dieses Problem
				if (listWaffen.getSelectedIndex() < 0
						|| listWaffen.getSelectedIndex() >= inv.getFreigeschalteteWaffen().size())
					listWaffen.setSelectedIndex(0);

				Waffe currentWaffe = inv.getFreigeschalteteWaffen().get(listWaffen.getSelectedIndex());
				if (currentWaffe == null)
					return;

				lblBonus.setText(Integer.toString(currentWaffe.getBonus()));
				lblMaterial.setText(currentWaffe.getMaterial());
				lblMagie.setText(Integer.toString(currentWaffe.getMagie()));
			}
		});
		listWaffen.setFont(new Font("Tahoma", Font.PLAIN, 13));
		listWaffen.setBounds(336, 122, 256, 292);
		contentPane.add(listWaffen);

		JScrollBar listHeldenScrollbar = new JScrollBar();
		listHeldenScrollbar.setBounds(591, 122, 17, 292);
		contentPane.add(listHeldenScrollbar);

		JScrollBar listMonsterScrollbar = new JScrollBar();
		listMonsterScrollbar.setBounds(265, 56, 17, 358);
		contentPane.add(listMonsterScrollbar);

		JLabel lblStatsHeld = new JLabel("Stats:");
		lblStatsHeld.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblStatsHeld.setBounds(10, 424, 46, 14);
		contentPane.add(lblStatsHeld);

		JLabel lblAngriffwertName = new JLabel("Angriffswert");
		lblAngriffwertName.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblAngriffwertName.setBounds(10, 438, 72, 14);
		contentPane.add(lblAngriffwertName);

		JLabel lblStaerkeName = new JLabel("St\u00E4rke");
		lblStaerkeName.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblStaerkeName.setBounds(10, 456, 60, 14);
		contentPane.add(lblStaerkeName);

		JLabel lblLebenspunkteName = new JLabel("Lebenspunkte");
		lblLebenspunkteName.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblLebenspunkteName.setBounds(10, 472, 72, 14);
		contentPane.add(lblLebenspunkteName);

		JLabel lblStatsWaffe = new JLabel("Stats:");
		lblStatsWaffe.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblStatsWaffe.setBounds(336, 425, 46, 14);
		contentPane.add(lblStatsWaffe);

		lblAngriffwert = new JLabel("");
		lblAngriffwert.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAngriffwert.setBounds(194, 438, 72, 14);
		contentPane.add(lblAngriffwert);

		lblStaerke = new JLabel("");
		lblStaerke.setHorizontalAlignment(SwingConstants.RIGHT);
		lblStaerke.setBounds(194, 456, 72, 14);
		contentPane.add(lblStaerke);

		lblLebenspunkte = new JLabel("");
		lblLebenspunkte.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLebenspunkte.setBounds(194, 472, 72, 14);
		contentPane.add(lblLebenspunkte);

		JLabel lblBonusName = new JLabel("Bonus");
		lblBonusName.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblBonusName.setBounds(336, 438, 46, 14);
		contentPane.add(lblBonusName);

		JLabel lblMaterialName = new JLabel("Material");
		lblMaterialName.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblMaterialName.setBounds(336, 456, 46, 14);
		contentPane.add(lblMaterialName);

		JLabel lblMagieName = new JLabel("Magie");
		lblMagieName.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblMagieName.setBounds(336, 472, 46, 14);
		contentPane.add(lblMagieName);

		lblBonus = new JLabel("");
		lblBonus.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBonus.setBounds(520, 438, 72, 14);
		contentPane.add(lblBonus);

		lblMaterial = new JLabel("");
		lblMaterial.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMaterial.setBounds(474, 456, 118, 14);
		contentPane.add(lblMaterial);

		lblMagie = new JLabel("");
		lblMagie.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMagie.setBounds(520, 472, 72, 14);
		contentPane.add(lblMagie);

		cbWaffeAuswaehlen = new JComboBox();
		cbWaffeAuswaehlen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cbWaffeAuswaehlen.getSelectedIndex() <= 0) {
					inv.getFreigeschalteteHelden().get(listHelden.getSelectedIndex()).setWaffe(null);
				} else {
					inv.getFreigeschalteteHelden().get(listHelden.getSelectedIndex())
							.setWaffe(inv.getFreigeschalteteWaffen().get(cbWaffeAuswaehlen.getSelectedIndex() - 1));
				}
			}
		});
		cbWaffeAuswaehlen.setEnabled(false);
		cbWaffeAuswaehlen.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cbWaffeAuswaehlen.setBounds(336, 56, 256, 41);
		contentPane.add(cbWaffeAuswaehlen);

		JLabel lblTypName = new JLabel("Typ");
		lblTypName.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblTypName.setBounds(10, 490, 72, 14);
		contentPane.add(lblTypName);

		lblTyp = new JLabel("");
		lblTyp.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTyp.setBounds(194, 490, 72, 14);
		contentPane.add(lblTyp);

		refresh();
	}

	public void refresh() {
		String[] heldenNamen = new String[inv.getFreigeschalteteHelden().size()];
		for (int i = 0; i < inv.getFreigeschalteteHelden().size(); i++) {
			heldenNamen[i] = inv.getFreigeschalteteHelden().get(i).getName();
		}
		listHelden.setModel(new AbstractListModel() {
			public int getSize() {
				return heldenNamen.length;
			}

			public Object getElementAt(int index) {
				return heldenNamen[index];
			}
		});

		String[] waffenNamen = new String[inv.getFreigeschalteteWaffen().size()];
		for (int i = 0; i < inv.getFreigeschalteteWaffen().size(); i++) {
			waffenNamen[i] = inv.getFreigeschalteteWaffen().get(i).getName();
		}
		listWaffen.setModel(new AbstractListModel() {
			public int getSize() {
				return waffenNamen.length;
			}

			public Object getElementAt(int index) {
				return waffenNamen[index];
			}
		});

		String[] waffenNamenSelection = new String[waffenNamen.length + 1];
		for (int i = 1; i < waffenNamenSelection.length; i++) {
			waffenNamenSelection[i] = waffenNamen[i - 1];
		}
		waffenNamenSelection[0] = "Keine";
		cbWaffeAuswaehlen.setModel(new DefaultComboBoxModel(waffenNamenSelection));

		if (cbWaffeAuswaehlen.isEnabled()) {
			// currentHeld kann nicht null sein, weil sich cbWaffeAuswaehlen nur aktiviert,
			// wenn ein Held ausgewaehlt ist
			Held currentHeld = inv.getFreigeschalteteHelden().get(listHelden.getSelectedIndex());
			int curHeldIndexWaff = 0;
			for (int i = 0; i < inv.getFreigeschalteteWaffen().size(); i++) {
				if (inv.getFreigeschalteteWaffen().get(i) != null) {
					if (inv.getFreigeschalteteWaffen().get(i).getName().equals(currentHeld.getWaffe().getName())) {
						curHeldIndexWaff = i + 1;
						break;
					}
				}
			}
			cbWaffeAuswaehlen.setSelectedIndex(curHeldIndexWaff);
		}
	}

	public void run() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					setVisible(true);
					Erpgdamg.frame.setEnabled(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
