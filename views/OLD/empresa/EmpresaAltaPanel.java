//package Sprint4Java.views.OLD.empresa;
//
//import Sprint4Java.modules.GestorEmpresa;
//import Sprint4Java.views.Frames;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//public class EmpresaAltaPanel extends JPanel {
//
//	private JButton AC, CN;
//	private JTextField NOMTF, TELTF, MAILTF, LOCTF, ADDTF;
//	private JLabel NOMLBL, TELLBL, MAILLBL, LOCLBL, ADDLBL;
//
//	private GridBagConstraints gbc = new GridBagConstraints();
//
//	public EmpresaAltaPanel(Frames frameManager, GestorEmpresa GE) {
//
//		setLayout(new GridBagLayout());
//
//		gbc.fill = GridBagConstraints.BOTH;
//		gbc.insets = new Insets(10,10,0,10);
//
//		NOMLBL = new JLabel("Nom de l'empresa", JLabel.RIGHT);
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
//		TELLBL = new JLabel("Telefon de l'empresa", JLabel.RIGHT);
//		gbc.gridx = 0;
//		gbc.gridy = 1;
//		add(TELLBL, gbc);
//
//		TELTF = new JTextField();
//		gbc.gridx = 1;
//		gbc.gridy = 1;
//		add(TELTF, gbc);
//
//
//		MAILLBL = new JLabel("Email de l'empresa", JLabel.RIGHT);
//		gbc.gridx = 0;
//		gbc.gridy = 2;
//		add(MAILLBL, gbc);
//
//		MAILTF = new JTextField();
//		gbc.gridx = 1;
//		gbc.gridy = 2;
//		add(MAILTF, gbc);
//
//
//		LOCLBL = new JLabel("Localitat de l'empresa", JLabel.RIGHT);
//		gbc.gridx = 0;
//		gbc.gridy = 3;
//		add(LOCLBL, gbc);
//
//		LOCTF = new JTextField();
//		gbc.gridx = 1;
//		gbc.gridy = 3;
//		add(LOCTF, gbc);
//
//
//		ADDLBL = new JLabel("Adreça de l'empresa", JLabel.RIGHT);
//		gbc.gridx = 0;
//		gbc.gridy = 4;
//		add(ADDLBL, gbc);
//
//		ADDTF = new JTextField();
//		gbc.gridx = 1;
//		gbc.gridy = 4;
//		add(ADDTF, gbc);
//
//		AC = new JButton("Acceptar");
//		gbc.insets = new Insets(10,10,10,10);
//		gbc.gridx = 0;
//		gbc.gridy = 5;
//		add(AC, gbc);
//
//		CN = new JButton("Cancel·lar");
//		gbc.gridx = 1;
//		gbc.gridy = 5;
//		add(CN, gbc);
//
//		AC.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				if (!NOMTF.getText().equals("") && !TELTF.getText().equals("") && !MAILTF.getText().equals("") && !LOCTF.getText().equals("") && !ADDTF.getText().equals("")) {
//					boolean success = GE.altaEmpresa(NOMTF.getText(), TELTF.getText(), MAILTF.getText(), LOCTF.getText(), ADDTF.getText());
//					if (success) {
//						JOptionPane.showMessageDialog(null, "L'empresa " + NOMTF.getText() + " s'ha afegit correctament");
//					} else {
//						JOptionPane.showMessageDialog(null, "Ja no es poden afegir més empreses");
//					}
//					frameManager.EmpresaSwitch(0);
//				}
//			}
//		});
//
//		CN.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				frameManager.EmpresaSwitch(0);
//			}
//		});
//	}
//
//}
