//package Sprint4Java.views.OLD.categoria;
//
//import Sprint4Java.views.Frames;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//public class CategoriaPanel extends JPanel {
//
//	private JButton INSAB, INSBB, INSMB, INSLB;
//	private GridBagConstraints gbc = new GridBagConstraints();
//
//	public CategoriaPanel(Frames frameManager) {
//
//		setLayout(new GridBagLayout());
//
//		gbc.fill = GridBagConstraints.BOTH;
//		gbc.insets = new Insets(10,10,0,10);
//
//		INSAB = new JButton("Alta Categoria");
//		gbc.gridx = 0;
//		gbc.gridy = 0;
//		add(INSAB, gbc);
//
//		INSBB = new JButton("Baixa Categoria");
//		gbc.gridx = 0;
//		gbc.gridy = 1;
//		add(INSBB, gbc);
//
//		INSMB = new JButton("Modificar Categoria");
//		gbc.gridx = 0;
//		gbc.gridy = 2;
//		add(INSMB, gbc);
//
//		INSLB = new JButton("Llistar Categoria");
//		gbc.insets = new Insets(10,10,10,10);
//		gbc.gridx = 0;
//		gbc.gridy = 3;
//		add(INSLB, gbc);
//
//		INSAB.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				frameManager.CategoriaSwitch(1);
//
//			}
//		});
//
//		INSBB.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				frameManager.CategoriaSwitch(2);
//
//			}
//		});
//
//		INSMB.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				frameManager.CategoriaSwitch(3);
//
//			}
//		});
//
//		INSLB.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				frameManager.CategoriaSwitch(4);
//
//			}
//		});
//	}
//
//}
