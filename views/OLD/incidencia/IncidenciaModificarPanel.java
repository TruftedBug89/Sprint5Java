//package Sprint4Java.views.OLD.incidencia;
//
//import Sprint4Java.modules.GestorIncidencia;
//import Sprint4Java.views.Frames;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//public class IncidenciaModificarPanel extends JPanel {
//
//	private JButton AC, CN;
//	private JTextField NOMTF, DESTF;
//	private JSpinner IDTF;
//	private SpinnerModel IDFMT;
//	private JLabel NOMLBL, DESLBL, IDLBL;
//
//	private GridBagConstraints gbc = new GridBagConstraints();
//
//	public IncidenciaModificarPanel(Frames frameManager, GestorIncidencia GI) {
//
//		setLayout(new GridBagLayout());
//
//		gbc.fill = GridBagConstraints.BOTH;
//		gbc.insets = new Insets(10,10,0,10);
//
//		IDLBL = new JLabel("ID de la incidència", JLabel.RIGHT);
//		gbc.gridx = 0;
//		gbc.gridy = 0;
//		add(IDLBL, gbc);
//
//		IDFMT = new SpinnerNumberModel(1, 1, (int) GI.getMax(), 1);
//	    IDTF = new JSpinner(IDFMT);
//		gbc.gridx = 1;
//		gbc.gridy = 0;
//		add(IDTF, gbc);
//
//		NOMLBL = new JLabel("Nom de la incidència", JLabel.RIGHT);
//		gbc.gridx = 0;
//		gbc.gridy = 1;
//		add(NOMLBL, gbc);
//
//		NOMTF = new JTextField();
//		gbc.gridx = 1;
//		gbc.gridy = 1;
//		add(NOMTF, gbc);
//
//		DESLBL = new JLabel("Descripció de la incidència", JLabel.RIGHT);
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
//					boolean success = GI.modificarIncidencia((Integer) IDTF.getValue(), NOMTF.getText(), DESTF.getText());
//					if (success) {
//						JOptionPane.showMessageDialog(null, "L'incidència " + NOMTF.getText() + " s'ha modificat correctament");
//					} else {
//						JOptionPane.showMessageDialog(null, "No s'ha trobat l'incidència");
//					}
//					frameManager.IncidenciaSwitch(0);
//				}
//			}
//		});
//
//		CN.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				frameManager.IncidenciaSwitch(0);
//			}
//		});
//	}
//
//}
