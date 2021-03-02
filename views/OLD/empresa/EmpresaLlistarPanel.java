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
//public class EmpresaLlistarPanel extends JPanel {
//
//	private JButton CN;
//	private JLabel ERRLBL;
//	private JTable LIS;
//	private JScrollPane LSP;
//
//	private GridBagConstraints gbc = new GridBagConstraints();
//
//	public EmpresaLlistarPanel(Frames frameManager, GestorEmpresa GE) {
//
//		setLayout(new GridBagLayout());
//
//		gbc.fill = GridBagConstraints.BOTH;
//		gbc.insets = new Insets(10,10,0,10);
//
//        // Data to be displayed in the JTable
//        String[][] data = GE.llistarEmpresa();
//
//        // Column Names
//        String[] columnNames = { "ID", "Nom", "Telèfon", "Email", "Localitat", "Adreça" };
//
//        if (data[0][0] != null) {
//	        // Initializing the JTable
//	        LIS = new JTable(data, columnNames);
//	        //LIS.setBounds(0, 0, 100, 100);
//	        LSP = new JScrollPane(LIS);
//			gbc.gridx = 0;
//			gbc.gridy = 0;
//			add(LSP, gbc);
//        } else {
//        	ERRLBL = new JLabel("No s'ha trobart cap empresa", JLabel.CENTER);
//    		gbc.gridx = 0;
//    		gbc.gridy = 0;
//    		add(ERRLBL, gbc);
//        }
//
//		CN = new JButton("Tornar");
//		gbc.insets = new Insets(10,10,10,10);
//		gbc.gridx = 0;
//		gbc.gridy = 1;
//		add(CN, gbc);
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
