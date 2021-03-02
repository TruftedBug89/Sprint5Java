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
//public class CategoriaModificarPanel extends JPanel {
//
//	private JButton AC, CN;
//	private JTextField NOMTF, DESTF;
//	private JSpinner IDTF;
//	private SpinnerModel IDFMT;
//	private JLabel NOMLBL, DESLBL, IDLBL;
//
//	private GridBagConstraints gbc = new GridBagConstraints();
//
//	public CategoriaModificarPanel(Frames frameManager, GestorCategoria GC) {
//
//		setLayout(new GridBagLayout());
//
//		gbc.fill = GridBagConstraints.BOTH;
//		gbc.insets = new Insets(10,10,0,10);
//
//		IDLBL = new JLabel("ID de la categoria", JLabel.RIGHT);
//		gbc.gridx = 0;
//		gbc.gridy = 0;
//		add(IDLBL, gbc);
//
//		IDFMT = new SpinnerNumberModel(1, 1, (int) GC.getMax(), 1);
//	    IDTF = new JSpinner(IDFMT);
//		gbc.gridx = 1;
//		gbc.gridy = 0;
//		add(IDTF, gbc);
//
//		NOMLBL = new JLabel("Nom de la categoria", JLabel.RIGHT);
//		gbc.gridx = 0;
//		gbc.gridy = 1;
//		add(NOMLBL, gbc);
//
//		NOMTF = new JTextField();
//		gbc.gridx = 1;
//		gbc.gridy = 1;
//		add(NOMTF, gbc);
//
//		DESLBL = new JLabel("Tipus de la categoria", JLabel.RIGHT);
//		gbc.gridx = 0;
//		gbc.gridy = 2;
//		add(DESLBL, gbc);
//
//		DESTF = new JTextField();
//		gbc.gridx = 1;
//		gbc.gridy = 2;
//		add(DESTF, gbc);
//
//		AC = new JButton("Acceptar");
//		gbc.insets = new Insets(10,10,10,10);
//		gbc.gridx = 0;
//		gbc.gridy = 3;
//		add(AC, gbc);
//
//		CN = new JButton("Cancel·lar");
//		gbc.gridx = 1;
//		gbc.gridy = 3;
//		add(CN, gbc);
//
//		AC.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				if (!IDTF.getValue().equals("") && !NOMTF.getText().equals("") && !DESTF.getText().equals("")) {
//					boolean success = GC.modificarCategoria((Integer) IDTF.getValue(), NOMTF.getText(), DESTF.getText());
//					if (success) {
//						JOptionPane.showMessageDialog(null, "La categoria " + NOMTF.getText() + " s'ha modificat correctament");
//					} else {
//						JOptionPane.showMessageDialog(null, "No s'ha trobat la categoria");
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
