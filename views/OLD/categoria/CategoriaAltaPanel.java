//package Sprint4Java.views.OLD.categoria;
//
//import Sprint4Java.modules.GestorCategoria;
//import Sprint4Java.views.Frames;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//public class CategoriaAltaPanel extends JPanel {
//
//	private JButton AC, CN;
//	private JTextField NOMTF, DESTF;
//	private JLabel NOMLBL, DESLBL;
//
//	private GridBagConstraints gbc = new GridBagConstraints();
//
//	public CategoriaAltaPanel(Frames frameManager, GestorCategoria GC) {
//
//		setLayout(new GridBagLayout());
//
//		gbc.fill = GridBagConstraints.BOTH;
//		gbc.insets = new Insets(10,10,0,10);
//
//		NOMLBL = new JLabel("Nom de la categoria", JLabel.RIGHT);
//		gbc.gridx = 0;
//		gbc.gridy = 0;
//		add(NOMLBL, gbc);
//
//		NOMTF = new JTextField();
//		gbc.gridx = 1;
//		gbc.gridy = 0;
//		add(NOMTF, gbc);
//
//
//		DESLBL = new JLabel("Tipus de categoria", JLabel.RIGHT);
//		gbc.gridx = 0;
//		gbc.gridy = 1;
//		add(DESLBL, gbc);
//
//		DESTF = new JTextField();
//		gbc.gridx = 1;
//		gbc.gridy = 1;
//		add(DESTF, gbc);
//
//
//		AC = new JButton("Acceptar");
//		gbc.insets = new Insets(10,10,10,10);
//		gbc.gridx = 0;
//		gbc.gridy = 2;
//		add(AC, gbc);
//
//		CN = new JButton("Cancel·lar");
//		gbc.gridx = 1;
//		gbc.gridy = 2;
//		add(CN, gbc);
//
//		AC.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				if (!NOMTF.getText().equals("") && !DESTF.getText().equals("")) {
//					boolean success = GC.altaCategoria(NOMTF.getText(), DESTF.getText());
//					if (success) {
//						JOptionPane.showMessageDialog(null, "La categoria " + NOMTF.getText() + " s'ha afegit correctament");
//					} else {
//						JOptionPane.showMessageDialog(null, "Ja no es poden afegir més categories");
//					}
//					frameManager.CategoriaSwitch(0);
//				}
//			}
//		});
//
//		CN.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				frameManager.CategoriaSwitch(0);
//			}
//		});
//	}
//
//}
