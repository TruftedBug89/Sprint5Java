//package Sprint4Java.views.OLD;
//
//import Sprint4Java.modules.GestorCategoria;
//import Sprint4Java.modules.GestorEmpresa;
//import Sprint4Java.modules.GestorIncidencia;
//import Sprint4Java.modules.GestorInstitut;
//import Sprint4Java.views.OLD.categoria.*;
//import Sprint4Java.views.OLD.empresa.*;
//import Sprint4Java.views.OLD.incidencia.*;
//import Sprint4Java.views.OLD.institut.*;
//
//import javax.swing.*;
//
//public class Frames {
//
//	//FRAMES
//	private JFrame unique;
//	private GestorIncidencia GI;
//	private GestorCategoria GC;
//	private GestorEmpresa GE;
//	private GestorInstitut GIN;
//
//	public void Principal() {
//		unique = new JFrame();
//		unique.setTitle("Gestor");
//
//		unique.setResizable(false);
//		unique.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//		unique.add(new PrincipalPanel(this));
//
//		unique.pack();
//
//		unique.setLocationRelativeTo(null);
//		unique.setVisible(true);
//	}
//
//	//INCIDENCIA
//	public void Incidencia() {
//		unique = new JFrame();
//
//		unique.setTitle("Gestionar Incidència");
//
//		unique.setResizable(false);
//		unique.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
//
//		IncidenciaSwitch(0);
//
//		unique.pack();
//
//		unique.setLocationRelativeTo(null);
//		unique.setVisible(false);
//
//	}
//
//	public void IncidenciaShow() {
//		unique.setVisible(true);
//	}
//
//	public void IncidenciaHide() {
//		unique.setVisible(false);
//	}
//
//	public boolean IncidenciaVisible() {
//		return unique.isVisible();
//	}
//
//	public void IncidenciaSwitch(Integer panel) {
//
//		unique.getContentPane().removeAll();
//
//		switch (panel) {
//			default:
//				unique.add(new IncidenciaPanel(this));
//				break;
//
//			case 1:
//				unique.add(new IncidenciaAltaPanel(this, GI));
//				break;
//
//			case 2:
//				unique.add(new IncidenciaBaixaPanel(this, GI));
//				break;
//
//			case 3:
//				unique.add(new IncidenciaModificarPanel(this, GI));
//				break;
//
//			case 4:
//				unique.add(new IncidenciaLlistarPanel(this, GI));
//				break;
//		}
//
//		unique.validate();
//		unique.repaint();
//		unique.pack();
//
//	}
//
//	//CATEGORIA
//	public void Categoria() {
//		unique = new JFrame();
//
//		unique.setTitle("Gestionar Categoria");
//
//		unique.setResizable(false);
//		unique.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
//
//		CategoriaSwitch(0);
//
//		unique.pack();
//
//		unique.setLocationRelativeTo(null);
//		unique.setVisible(false);
//
//	}
//
//	public void CategoriaShow() {
//		unique.setVisible(true);
//	}
//
//	public void CategoriaHide() {
//		unique.setVisible(false);
//	}
//
//	public boolean CategoriaVisible() {
//		return unique.isVisible();
//	}
//
//	public void CategoriaSwitch(Integer panel) {
//
//		unique.getContentPane().removeAll();
//
//		switch (panel) {
//			default:
//				unique.add(new CategoriaPanel(this));
//				break;
//
//			case 1:
//				unique.add(new CategoriaAltaPanel(this, GC));
//				break;
//
//			case 2:
//				unique.add(new CategoriaBaixaPanel(this, GC));
//				break;
//
//			case 3:
//				unique.add(new CategoriaModificarPanel(this, GC));
//				break;
//
//			case 4:
//				unique.add(new CategoriaLlistarPanel(this, GC));
//				break;
//		}
//
//		unique.validate();
//		unique.repaint();
//		unique.pack();
//
//	}
//
//
//	//EMPRESA
//	public void Empresa() {
//		unique = new JFrame();
//
//		unique.setTitle("Gestionar Empresa");
//
//		unique.setResizable(false);
//		unique.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
//
//		EmpresaSwitch(0);
//
//		unique.pack();
//
//		unique.setLocationRelativeTo(null);
//		unique.setVisible(false);
//
//	}
//
//	public void EmpresaShow() {
//		unique.setVisible(true);
//	}
//
//	public void EmpresaHide() {
//		unique.setVisible(false);
//	}
//
//	public boolean EmpresaVisible() {
//		return unique.isVisible();
//	}
//
//	public void EmpresaSwitch(Integer panel) {
//
//		unique.getContentPane().removeAll();
//
//		switch (panel) {
//			default:
//				unique.add(new EmpresaPanel(this));
//				break;
//
//			case 1:
//				unique.add(new EmpresaAltaPanel(this, GE));
//				break;
//
//			case 2:
//				unique.add(new EmpresaBaixaPanel(this, GE));
//				break;
//
//			case 3:
//				unique.add(new EmpresaModificarPanel(this, GE));
//				break;
//
//			case 4:
//				unique.add(new EmpresaLlistarPanel(this, GE));
//				break;
//		}
//
//		unique.validate();
//		unique.repaint();
//		unique.pack();
//
//	}
//
//	//Institut
//	public void Institut() {
//		unique = new JFrame();
//
//		unique.setTitle("Gestionar Institut");
//
//		unique.setResizable(false);
//		unique.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
//
//		InstitutSwitch(0);
//
//		unique.pack();
//
//		unique.setLocationRelativeTo(null);
//		unique.setVisible(false);
//
//	}
//
//	public void InstitutShow() {
//		Institut();
//	}
//
//	public void InstitutHide() {
//		unique.setVisible(false);
//	}
//
//	public boolean InstitutVisible() {
//		return unique.isVisible();
//	}
//
//	public void InstitutSwitch(Integer panel) {
//
//		unique.getContentPane().removeAll();
//
//		switch (panel) {
//			default:
//				unique.add(new InstitutPanel(this));
//				break;
//
//			case 1:
//				unique.add(new InstitutAltaPanel(this, GIN));
//				break;
//
//			case 2:
//				unique.add(new InstitutBaixaPanel(this, GIN));
//				break;
//
//			case 3:
//				unique.add(new InstitutModificarPanel(this, GIN));
//				break;
//
//			case 4:
//				unique.add(new InstitutLlistarPanel(this, GIN));
//				break;
//		}
//
//		unique.validate();
//		unique.repaint();
//		unique.pack();
//
//	}
//
//	public Frames(GestorIncidencia GI, GestorCategoria GC, GestorEmpresa GE, GestorInstitut GIN) {
//		this.GI = GI;
//		this.GC = GC;
//		this.GE = GE;
//		this.GIN = GIN;
//	}
//}
