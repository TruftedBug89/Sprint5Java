//package Sprint4Java.views.OLD.institut;
//
//import Sprint4Java.modules.GestorInstitut;
//import Sprint4Java.views.Frames;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//public class InstitutBaixaPanel extends JPanel {
//
//	private JButton AC, CN;
//	private JSpinner IDTF;
//	private SpinnerModel IDFMT;
//	private JLabel IDLBL;
//
//	private GridBagConstraints gbc = new GridBagConstraints();
//
//	public InstitutBaixaPanel(Frames frameManager, GestorInstitut GIN) {
//
//		setLayout(new GridBagLayout());
//
//		gbc.fill = GridBagConstraints.BOTH;
//		gbc.insets = new Insets(10,10,0,10);
//
//		IDLBL = new JLabel("ID de l'institut", JLabel.RIGHT);
//		gbc.gridx = 0;
//		gbc.gridy = 0;
//		add(IDLBL, gbc);
//
//		IDFMT = new SpinnerNumberModel(1, 1, (int) GIN.getMax(), 1);
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
//					boolean success = GIN.eliminarInstitut((Integer) IDTF.getValue());
//					if (success) {
//						JOptionPane.showMessageDialog(null, "L'institut s'ha esborrat correctament");
//					} else {
//						JOptionPane.showMessageDialog(null, "No s'ha trobat l'institut");
//					}
//					frameManager.InstitutSwitch(0);
//				}
//			}
//		});
//
//		CN.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				frameManager.InstitutSwitch(0);
//			}
//		});
//	}
//
//}
