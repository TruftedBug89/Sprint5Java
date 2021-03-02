//package Sprint4Java.views.OLD;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//public class PrincipalPanel extends JPanel {
//
//	private JButton GINSB, GEMPB, GINCB, GCATB;
//	private GridBagConstraints gbc = new GridBagConstraints();
//
//	public PrincipalPanel(Frames frameManager) {
//
//		setLayout(new GridBagLayout());
//
//		gbc.fill = GridBagConstraints.BOTH;
//		gbc.insets = new Insets(10,10,0,10);
//
//		GINSB = new JButton("Gestionar Institut");
//		gbc.gridx = 0;
//		gbc.gridy = 0;
//		add(GINSB, gbc);
//
//		GEMPB = new JButton("Gestionar Empresa");
//		gbc.gridx = 0;
//		gbc.gridy = 1;
//		add(GEMPB, gbc);
//
//		GINCB = new JButton("Gestionar Incidència");
//		gbc.gridx = 0;
//		gbc.gridy = 2;
//		add(GINCB, gbc);
//
//		GCATB = new JButton("Gestionar Categoria");
//		gbc.insets = new Insets(10,10,10,10);
//		gbc.gridx = 0;
//		gbc.gridy = 3;
//		add(GCATB, gbc);
//
//		GINCB.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				if (frameManager.IncidenciaVisible()) {
//					frameManager.IncidenciaHide();
//				} else {
//					frameManager.IncidenciaShow();
//				}
//			}
//		});
//
//		GCATB.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				if (frameManager.CategoriaVisible()) {
//					frameManager.CategoriaHide();
//				} else {
//					frameManager.CategoriaShow();
//				}
//			}
//		});
//
//		GEMPB.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				if (frameManager.EmpresaVisible()) {
//					frameManager.EmpresaHide();
////				} else {
//					frameManager.EmpresaShow();
//				}
//			}
//		});
//
//		GINSB.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				if (frameManager.InstitutVisible()) {
//					frameManager.InstitutHide();
//				} else {
//					frameManager.InstitutShow();
//				}
//			}
//		});
//	}
//
//}
