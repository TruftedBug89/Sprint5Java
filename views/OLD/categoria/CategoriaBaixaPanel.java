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
//public class CategoriaBaixaPanel extends JPanel {
//
//	private JButton AC, CN;
//	private JSpinner IDTF;
//	private SpinnerModel IDFMT;
//	private JLabel IDLBL;
//
//	private GridBagConstraints gbc = new GridBagConstraints();
//
//	public CategoriaBaixaPanel(Frames frameManager, GestorCategoria GC) {
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
//		AC = new JButton("Acceptar");
//		gbc.insets = new Insets(10,10,10,10);
//		gbc.gridx = 0;
//		gbc.gridy = 1;
//		add(AC, gbc);
//
//		CN = new JButton("Cancel·lar");
//		gbc.gridx = 1;
//		gbc.gridy = 1;
//		add(CN, gbc);
//
//		AC.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				if (!IDTF.getValue().equals("")) {
//					boolean success = GC.eliminarCategoria((Integer) IDTF.getValue());
//					if (success) {
//						JOptionPane.showMessageDialog(null, "La categoria s'ha esborrat correctament");
//					} else {
//						JOptionPane.showMessageDialog(null, "No s'ha trobart la categoria");
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
