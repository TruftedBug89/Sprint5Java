//package Sprint4Java.views.OLD.incidencia;
//
//import Sprint4Java.views.Frames;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//public class IncidenciaPanel extends JPanel {
//
//	private JButton INSAB, INSBB, INSMB, INSLB;
//	private GridBagConstraints gbc = new GridBagConstraints();
//
//	public IncidenciaPanel(Frames frameManager) {
//
//		setLayout(new GridBagLayout());
//
//		gbc.fill = GridBagConstraints.BOTH;
//		gbc.insets = new Insets(10,10,0,10);
//
//		INSAB = new JButton("Alta Incidència");
//		gbc.gridx = 0;
//		gbc.gridy = 0;
//		add(INSAB, gbc);
//
//		INSBB = new JButton("Baixa Incidència");
//		gbc.gridx = 0;
//		gbc.gridy = 1;
//		add(INSBB, gbc);
//
//		INSMB = new JButton("Modificar Incidència");
//		gbc.gridx = 0;
//		gbc.gridy = 2;
//		add(INSMB, gbc);
//
//		INSLB = new JButton("Llistar Incidència");
//		gbc.insets = new Insets(10,10,10,10);
//		gbc.gridx = 0;
//		gbc.gridy = 3;
//		add(INSLB, gbc);
//
//		INSAB.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				frameManager.IncidenciaSwitch(1);
//
//			}
//		});
//
//		INSBB.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				frameManager.IncidenciaSwitch(2);
//
//			}
//		});
//
//		INSMB.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				frameManager.IncidenciaSwitch(3);
//
//			}
//		});
//
//		INSLB.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				frameManager.IncidenciaSwitch(4);
//
//			}
//		});
//	}
//
//}
