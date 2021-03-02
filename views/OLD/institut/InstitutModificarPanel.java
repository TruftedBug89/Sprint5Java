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
//public class InstitutModificarPanel extends JPanel {
//
//	private JButton AC, CN;
//	private JSpinner IDTF;
//	private SpinnerModel IDFMT;
//	private JTextField NOMTF, TELTF, MAILTF, LOCTF, ADDTF;
//	private JLabel NOMLBL, TELLBL, MAILLBL, LOCLBL, ADDLBL, IDLBL;
//
//	private GridBagConstraints gbc = new GridBagConstraints();
//
//	public InstitutModificarPanel(Frames frameManager, GestorInstitut GIN) {
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
//		NOMLBL = new JLabel("Nom de l'institut", JLabel.RIGHT);
//		gbc.gridx = 0;
//		gbc.gridy = 1;
//		add(NOMLBL, gbc);
//
//		NOMTF = new JTextField();
//		gbc.gridx = 1;
//		gbc.gridy = 1;
//		add(NOMTF, gbc);
//
//
//		TELLBL = new JLabel("Telefon de l'institut", JLabel.RIGHT);
//		gbc.gridx = 0;
//		gbc.gridy = 2;
//		add(TELLBL, gbc);
//
//		TELTF = new JTextField();
//		gbc.gridx = 1;
//		gbc.gridy = 2;
//		add(TELTF, gbc);
//
//
//		MAILLBL = new JLabel("Email de l'institut", JLabel.RIGHT);
//		gbc.gridx = 0;
//		gbc.gridy = 3;
//		add(MAILLBL, gbc);
//
//		MAILTF = new JTextField();
//		gbc.gridx = 1;
//		gbc.gridy = 3;
//		add(MAILTF, gbc);
//
//
//		LOCLBL = new JLabel("Localitat de l'institut", JLabel.RIGHT);
//		gbc.gridx = 0;
//		gbc.gridy = 4;
//		add(LOCLBL, gbc);
//
//		LOCTF = new JTextField();
//		gbc.gridx = 1;
//		gbc.gridy = 4;
//		add(LOCTF, gbc);
//
//
//		ADDLBL = new JLabel("Adreça de l'institut", JLabel.RIGHT);
//		gbc.gridx = 0;
//		gbc.gridy = 5;
//		add(ADDLBL, gbc);
//
//		ADDTF = new JTextField();
//		gbc.gridx = 1;
//		gbc.gridy = 5;
//		add(ADDTF, gbc);
//
//		AC = new JButton("Acceptar");
//		gbc.insets = new Insets(10,10,10,10);
//		gbc.gridx = 0;
//		gbc.gridy = 6;
//		add(AC, gbc);
//
//		CN = new JButton("Cancel·lar");
//		gbc.gridx = 1;
//		gbc.gridy = 6;
//		add(CN, gbc);
//
//		AC.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				if (!IDTF.getValue().equals("") && !NOMTF.getText().equals("") && !TELTF.getText().equals("") && !MAILTF.getText().equals("") && !LOCTF.getText().equals("") && !ADDTF.getText().equals("")) {
//					boolean success = GIN.modificarInstitut((Integer) IDTF.getValue(), NOMTF.getText(), TELTF.getText(), MAILTF.getText(), LOCTF.getText(), ADDTF.getText());
//					if (success) {
//						JOptionPane.showMessageDialog(null, "L'institut " + NOMTF.getText() + " s'ha modificat correctament");
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
