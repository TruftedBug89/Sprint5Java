//package Sprint4Java.views.OLD.institut;
//
//import Sprint4Java.views.Frames;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//public class InstitutPanel extends JPanel {
//
//	private JButton INSAB, INSBB, INSMB, INSLB;
//	private GridBagConstraints gbc = new GridBagConstraints();
//
//	public InstitutPanel(Frames frameManager) {
//
//		setLayout(new GridBagLayout());
//
//		gbc.fill = GridBagConstraints.BOTH;
//		gbc.insets = new Insets(10,10,0,10);
//
//		INSAB = new JButton("Alta Institut");
//		gbc.gridx = 0;
//		gbc.gridy = 0;
//		add(INSAB, gbc);
//
//		INSBB = new JButton("Baixa Institut");
//		gbc.gridx = 0;
//		gbc.gridy = 1;
//		add(INSBB, gbc);
//
//		INSMB = new JButton("Modificar Institut");
//		gbc.gridx = 0;
//		gbc.gridy = 2;
//		add(INSMB, gbc);
//
//		INSLB = new JButton("Llistar Institut");
//		gbc.insets = new Insets(10,10,10,10);
//		gbc.gridx = 0;
//		gbc.gridy = 3;
//		add(INSLB, gbc);
//
//		INSAB.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				frameManager.InstitutSwitch(1);
//
//			}
//		});
//
//		INSBB.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				frameManager.InstitutSwitch(2);
//
//			}
//		});
//
//		INSMB.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				frameManager.InstitutSwitch(3);
//
//			}
//		});
//
//		INSLB.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				frameManager.InstitutSwitch(4);
//
//			}
//		});
//	}
//
//}
