//package Sprint4Java.views.OLD.empresa;
//
//import java.awt.GridBagConstraints;
//import java.awt.GridBagLayout;
//import java.awt.Insets;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//import javax.swing.JButton;
//import javax.swing.JPanel;
//
//import Sprint4Java.views.Frames;
//
//public class EmpresaPanel extends JPanel {
//
//	private JButton INSAB, INSBB, INSMB, INSLB;
//	private GridBagConstraints gbc = new GridBagConstraints();
//
//	public EmpresaPanel(Frames frameManager) {
//
//		setLayout(new GridBagLayout());
//
//		gbc.fill = GridBagConstraints.BOTH;
//		gbc.insets = new Insets(10,10,0,10);
//
//		INSAB = new JButton("Alta Empresa");
//		gbc.gridx = 0;
//		gbc.gridy = 0;
//		add(INSAB, gbc);
//
//		INSBB = new JButton("Baixa Empresa");
//		gbc.gridx = 0;
//		gbc.gridy = 1;
//		add(INSBB, gbc);
//
//		INSMB = new JButton("Modificar Empresa");
//		gbc.gridx = 0;
//		gbc.gridy = 2;
//		add(INSMB, gbc);
//
//		INSLB = new JButton("Llistar Empresa");
//		gbc.insets = new Insets(10,10,10,10);
//		gbc.gridx = 0;
//		gbc.gridy = 3;
//		add(INSLB, gbc);
//
//		INSAB.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				frameManager.EmpresaSwitch(1);
//
//			}
//		});
//
//		INSBB.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				frameManager.EmpresaSwitch(2);
//
//			}
//		});
//
//		INSMB.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				frameManager.EmpresaSwitch(3);
//
//			}
//		});
//
//		INSLB.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				frameManager.EmpresaSwitch(4);
//
//			}
//		});
//	}
//
//}
