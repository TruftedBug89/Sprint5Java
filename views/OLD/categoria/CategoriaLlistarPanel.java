//package Sprint4Java.views.OLD.categoria;
//
//import java.awt.GridBagConstraints;
//import java.awt.GridBagLayout;
//import java.awt.Insets;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//import javax.swing.JButton;
//import javax.swing.JLabel;
//import javax.swing.JPanel;
//import javax.swing.JScrollPane;
//import javax.swing.JTable;
//
//import Sprint4Java.modules.GestorCategoria;
//import Sprint4Java.views.Frames;
//
//public class CategoriaLlistarPanel extends JPanel {
//
//	private JButton CN;
//	private JLabel ERRLBL;
//	private JTable LIS;
//	private JScrollPane LSP;
//
//	private GridBagConstraints gbc = new GridBagConstraints();
//
//	public CategoriaLlistarPanel(Frames frameManager, GestorCategoria GC) {
//
//		setLayout(new GridBagLayout());
//
//		gbc.fill = GridBagConstraints.BOTH;
//		gbc.insets = new Insets(10,10,0,10);
//
//        // Data to be displayed in the JTable
////        String[][] data = GC.llistarCategoria();
//
//        // Column Names
//        String[] columnNames = { "ID", "Nom", "Tipus" };
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
//        	ERRLBL = new JLabel("No s'ha trobart cap categoria", JLabel.CENTER);
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
//				frameManager.CategoriaSwitch(0);
//			}
//		});
//	}
//
//}
