//package Sprint4Java.views.OLD;
//
//import Sprint3Java.Clases.Professor;
//import Sprint3Java.Clases.RepositoriMissatges;
//import Sprint3Java.Clases.RepositoriPersona;
//import Sprint4Java.views.Finestra;
//
//import javax.swing.*;
//import java.awt.*;
//
///**
// * Grup 3 Sprint 2 2020-2021 - Alberto Dos Santos, David Falcó , Anwar El Khattabi -
// *
// */
//public class CrudProfessor extends JFrame{
//  Finestra finestra;
//  JPanel panel;
//  RepositoriPersona persones;
//  RepositoriMissatges missatges;
//  public CrudProfessor(Finestra finestra, RepositoriPersona persones,RepositoriMissatges missatges) {
//  this.finestra = finestra;
//  this.persones = persones;
//  this.missatges = missatges;
//  this.crearPanel();
//  }
//  /**
//   * Crea el panel per poder gestionar un professor
//   */
//  public void crearPanel(){
//    this.panel = new JPanel();
//    panel.setLayout(new GridLayout(5,1,2,2));
//    JButton crear = new JButton("Crear Professor");
//    JButton llistar = new JButton("Llistar Professor");
//    JButton modificar = new JButton("Modificar Professor");
//    JButton eliminar = new JButton("Eliminar Professor");
//    JButton tornar = new JButton("Tornar");
//    this.panel.add(crear);
//    crear.addActionListener(e -> this.crearProfessor());
//    this.panel.add(llistar);
//    llistar.addActionListener(e -> this.llistarProfessors());
//    this.panel.add(modificar);
//    modificar.addActionListener(e -> this.modificarProfessor());
//    this.panel.add(eliminar);
//    eliminar.addActionListener(e -> this.eliminarProfessor());
//    this.panel.add(tornar);
//    tornar.addActionListener(e-> new Sprint3Java.Finestra.PanelMenu(this.finestra, this.persones,this.missatges));
//    finestra.changePanel(this.panel);
//  }
//  /**
//   * Crea el panel per poder afegir un professor a l'aary de Persones
//   */
//  public void crearProfessor(){
//    this.panel = new JPanel();
//    panel.setLayout(new GridLayout(4,2,2,2));
//    JLabel nomLabel = new JLabel("Nom Professor");
//    JTextField nomText = new JTextField();
//    JLabel dniLabel = new JLabel("DNI Professor");
//    JLabel nssLabel = new JLabel("NSS Professor");
//    JTextField dniText = new JTextField();
//    JTextField nssText = new JTextField();
//    JButton tornar = new JButton("Tornar");
//    JButton crear = new JButton("Crear");
//    this.panel.add(nomLabel);
//    this.panel.add(nomText);
//    this.panel.add(dniLabel);
//    this.panel.add(dniText);
//    this.panel.add(nssLabel);
//    this.panel.add(nssText);
//    this.panel.add(crear);
//    crear.addActionListener(e-> {
//      if (nomText.getText().length() > 0 && dniText.getText().length() > 0 && nssText.getText().length() > 0) {
//        this.persones.afegirPersona(new Professor(nomText.getText(), dniText.getText(), nssText.getText()));
//        this.informacio("S'ha creat correctament");
//      } else {
//        this.informacio("Ha sorgit un error");
//      }
//    });
//    this.panel.add(tornar);
//    tornar.addActionListener(e-> new Sprint3Java.Finestra.PanelMenu(this.finestra, this.persones,this.missatges));
//    this.finestra.changePanel(this.panel);
//  }
//
//  /**
//   * @param text Text que veura l'usuari al missatge
//   * Crea un missatge per informar a l'usuari
//   */
//  private void informacio(String text){
//    JOptionPane.showMessageDialog(null, text);
//  }
//
//  /**
//   * Crea el panel per poder llistar els professors
//   */
//  public void llistarProfessors(){
//    this.panel = new JPanel();
//    panel.setLayout(new GridLayout(3,1,2,2));
//    JLabel label = new JLabel("Llistat de professors");
//    JButton tornar = new JButton("Tornar");
//    this.panel.add(label);
//    JList llistaProfes=new JList();
//    DefaultListModel model = new DefaultListModel();
//    int con = 0;
//    for (int i = 0; i < this.persones.contadorPersones; i++){
//      if(this.persones.arrayPersones[i].getClass() == Professor.class){
//        model.addElement("Nom: " + persones.arrayPersones[i].getNom() + " DNI: "+ persones.arrayPersones[i].getDni()
//                + " NSS: " + persones.arrayPersones[i].getNss());
//        con++;
//      }
//    }
//    if (con == 0){model.addElement("No hi ha professors");}
//    llistaProfes.setModel(model);
//    this.panel.add(llistaProfes);
//    this.panel.add(tornar);
//    tornar.addActionListener(e-> new Sprint3Java.Finestra.PanelMenu(this.finestra, this.persones,this.missatges));
//    this.finestra.changePanel(this.panel);
//  }
//
//  /**
//   * Crea el panel per poder modificar els atributs d'un professor
//   */
//  public void modificarProfessor(){
//    this.panel = new JPanel();
//    this.panel.setLayout(new GridLayout(8,1,2,2));
//    JLabel label = new JLabel("Editar Professors");
//    JTextField nomBuscar = new JTextField();
//    nomBuscar.setText("Nom a editar");
//    JTextField nom = new JTextField();
//    nom.setText("Nom");
//    JTextField dni = new JTextField();
//    dni.setText("DNI");
//    JTextField nss = new JTextField();
//    nss.setText("NSS");
//    JButton editar = new JButton("Editar");
//    JButton tornar = new JButton("Tornar");
//    panel.add(label);
//    JList llistaProfes=new JList();
//    DefaultListModel model = new DefaultListModel();
//    int con = 0;
//    for (int i = 0; i < this.persones.contadorPersones; i++){
//      if(this.persones.arrayPersones[i].getClass() == Professor.class){
//        model.addElement("Nom: " + persones.arrayPersones[i].getNom() + " DNI: "+ persones.arrayPersones[i].getDni()
//                + " NSS: " + persones.arrayPersones[i].getNss());
//        con++;
//      }
//    }
//    if (con == 0){model.addElement("No hi ha professors");}
//    llistaProfes.setModel(model);
//    this.panel.add(llistaProfes);
//    this.panel.add(nomBuscar);
//    this.panel.add(nom);
//    this.panel.add(dni);
//    this.panel.add(nss);
//    panel.add(editar);
//    editar.addActionListener(e -> {
//      for (int k = 0; k < this.persones.contadorPersones; k++){
//        if (this.persones.arrayPersones[k].getClass() == Professor.class){
//          if (nom.getText() != ""){
//            persones.arrayPersones[k].setNom(nom.getText());
//          }
//          else if (dni.getText() != ""){
//            persones.arrayPersones[k].setDni(dni.getText());
//          }
//          else if (nss.getText() != ""){
//            persones.arrayPersones[k].setNss(nss.getText());
//          }
//        }
//      }
//      this.llistarProfessors();
//    });
//    panel.add(tornar);
//    tornar.addActionListener(e-> new Sprint3Java.Finestra.PanelMenu(this.finestra, this.persones,this.missatges));
//    this.finestra.changePanel(this.panel);
//  }
//
//  /**
//   * Crea el panel per poder eliminar un professor
//   */
//  public void eliminarProfessor(){
//    this.panel = new JPanel();
//    this.panel.setLayout(new GridLayout(5,1,2,2));
//    JLabel labelEl = new JLabel("Eliminar Professors");
//    JTextField nom = new JTextField();
//    nom.setText("Nom a eliminar");
//    JButton eliminar = new JButton("Eliminar");
//    JButton tornar = new JButton("Tornar");
//    this.panel.add(labelEl);
//    JList llistaProfes=new JList();
//    DefaultListModel model = new DefaultListModel();
//    int con = 0;
//    for (int i = 0; i < this.persones.contadorPersones; i++){
//      if(this.persones.arrayPersones[i].getClass() == Professor.class){
//        model.addElement("Nom: " + persones.arrayPersones[i].getNom() + " DNI: "+ persones.arrayPersones[i].getDni()
//                + " NSS: " + persones.arrayPersones[i].getNss());
//        con++;
//      }
//    }
//    if (con == 0){model.addElement("No hi ha professors");}
//    llistaProfes.setModel(model);
//    this.panel.add(llistaProfes);
//    this.panel.add(nom);
//    this.panel.add(eliminar);
//    eliminar.addActionListener(e -> {
//      if (this.persones.eliminarPersonaPerNom(nom.getText())){
//        informacio("S'ha eliminat correctament");
//      }
//      else {
//        informacio("Ha sorgit un error");
//      }
//    });
//    this.panel.add(tornar);
//    tornar.addActionListener(e-> new Sprint3Java.Finestra.PanelMenu(this.finestra, this.persones,this.missatges));
//    this.finestra.changePanel(this.panel);
//  }
//}
