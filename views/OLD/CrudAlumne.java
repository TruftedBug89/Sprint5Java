//package Sprint4Java.views.OLD;
//
//
//import Sprint3Java.Clases.Alumne;
//import Sprint3Java.Clases.RepositoriMissatges;
//import Sprint3Java.Clases.RepositoriPersona;
//import Sprint4Java.views.Finestra;
//
//import javax.swing.*;
//import java.awt.*;
//
///**
// * Grup 3 Sprint 2 2020-2021 - Alberto Dos Santos, David Falcó , Anwar El Khattabi -
// * Herència - Classe que agafa els paràmetres necessaris de la classe JFrame
// * i que té tots els mètodes a utilitzar, Crear i canviar JPanels automaticament
// */
//
//public class CrudAlumne extends JFrame{
//
//    Finestra finestra;
//    JPanel panel;
//    RepositoriPersona persones;
//    RepositoriMissatges missatges;
//    /**
//     * Constructor CrudAlumne
//     * @param finestra objecte tipus Finestra
//     * @param persones objecte tipus RepositoriPersona
//     * @param missatges objecte tipus RepositoriMissatge
//     */
//    public CrudAlumne(Finestra finestra, RepositoriPersona persones, RepositoriMissatges missatges) {
//        this.finestra = finestra;
//        this.persones = persones;
//        this.missatges = missatges;
//        this.crearPanel();
//    }
//
//
//    /**
//     * Aplica un panel menu sobre el crudAlumne a la finestra principal
//     */
//
//    public void crearPanel(){
//        this.panel = new JPanel();
//        panel.setLayout(new GridLayout(5,1,2,2));
//        JButton crear = new JButton("Crear Alumne");
//        JButton llistar = new JButton("Llistar Alumne");
//        JButton modificar = new JButton("Modificar Alumne");
//        JButton eliminar = new JButton("Eliminar Alumne");
//        JButton tornar = new JButton("Tornar al menú");
//        this.panel.add(crear);
//        crear.addActionListener(e -> this.crearAlumne());
//        this.panel.add(llistar);
//        llistar.addActionListener(e -> this.llistarAlumnes());
//        this.panel.add(modificar);
//        modificar.addActionListener(e -> this.modificarAlumnes());
//        this.panel.add(eliminar);
//        eliminar.addActionListener(e -> this.eliminarAlumnes());
//        this.panel.add(tornar);
//
//        tornar.addActionListener(e-> new Sprint3Java.Finestra.PanelMenu(this.finestra, this.persones,this.missatges));
//        finestra.changePanel(this.panel);
//    }
//    /**
//     * Aplica un panel que conte components per afegir un Alumne
//     */
//    public void crearAlumne(){
//        this.panel = new JPanel();
//        panel.setLayout(new GridLayout(4,2,2,2));
//        JLabel nomLabel = new JLabel("Nom Alumne");
//        JTextField nomText = new JTextField();
//        JLabel dniLabel = new JLabel("DNI Alumne");
//        JLabel nssLabel = new JLabel("NSS Alumne");
//        JTextField dniText = new JTextField();
//        JTextField nssText = new JTextField();
//        JButton tornar = new JButton("Tornar");
//        JButton crear = new JButton("Crear");
//        this.panel.add(nomLabel);
//        this.panel.add(nomText);
//        this.panel.add(dniLabel);
//        this.panel.add(dniText);
//        this.panel.add(nssLabel);
//        this.panel.add(nssText);
//        this.panel.add(crear);
//        crear.addActionListener(e-> {
//            if (nomText.getText().length() > 0 && dniText.getText().length() > 0 && nssText.getText().length() > 0) {
//                this.persones.afegirPersona(new Alumne(nomText.getText(), dniText.getText(), nssText.getText()));
//                System.out.println("S'ha creat correctament");
//            } else {
//                System.out.println("Ha sorgit un error");
//            }
//        });
//        this.panel.add(tornar);
//        tornar.addActionListener(e-> this.crearPanel());
//        this.finestra.changePanel(this.panel);
//    }
//    /**
//     * Aquest mètode crea un JPanel per llistar Alumnes, al acabar torna al menu d'Alumne(aplicarPanel())
//     */
//    public void llistarAlumnes(){
//        this.panel = new JPanel();
//        panel.setLayout(new GridLayout(3,1,2,2));
//        JLabel label = new JLabel("Llistat d'alumnes");
//        JButton tornar = new JButton("Tornar");
//        this.panel.add(label);
//        JList llistaAlumnes1 =new JList();
//        DefaultListModel model = new DefaultListModel();
//        int con = 0;
//        for (int i = 0; i < this.persones.contadorPersones; i++){
//            if(this.persones.arrayPersones[i].getClass() == Sprint3Java.Clases.Alumne.class){
//                model.addElement("Nom: " + persones.arrayPersones[i].getNom() + " DNI: "+ persones.arrayPersones[i].getDni()
//                        + " NSS: " + persones.arrayPersones[i].getNss());
//                con++;
//            }
//        }
//        if (con == 0){model.addElement("No hi ha alumnes");}
//        llistaAlumnes1.setModel(model);
//        this.panel.add(llistaAlumnes1);
//        this.panel.add(tornar);
//        tornar.addActionListener(e-> this.crearPanel());
//        this.finestra.changePanel(this.panel);
//    }
//    /**
//     * Aquest mètode crea un JPanel per editar Alumnes, al acabar torna al menu d'Alumne(aplicarPanel())
//     */
//    public void modificarAlumnes(){
//        this.panel = new JPanel();
//        this.panel.setLayout(new GridLayout(8,1,2,2));
//        JLabel label = new JLabel("Editar Alumnes");
//        JTextField nomBuscar = new JTextField();
//        nomBuscar.setText("Nom a editar");
//        JTextField nom = new JTextField();
//        nom.setText("Nom");
//        JTextField dni = new JTextField();
//        dni.setText("DNI");
//        JTextField nss = new JTextField();
//        nss.setText("NSS");
//        JButton editar = new JButton("Editar");
//        JButton tornar = new JButton("Tornar");
//        panel.add(label);
//        JList llistaAlumnes1=new JList();
//        DefaultListModel model = new DefaultListModel();
//        int con = 0;
//        for (int i = 0; i < this.persones.contadorPersones; i++){
//            if(this.persones.arrayPersones[i].getClass() == Sprint3Java.Clases.Alumne.class){
//                model.addElement("Nom: " + persones.arrayPersones[i].getNom() + " DNI: "+ persones.arrayPersones[i].getDni()
//                        + " NSS: " + persones.arrayPersones[i].getNss());
//                con++;
//            }
//        }
//        if (con == 0){model.addElement("No hi ha alumnes");}
//        llistaAlumnes1.setModel(model);
//        this.panel.add(llistaAlumnes1);
//        this.panel.add(nomBuscar);
//        this.panel.add(nom);
//        this.panel.add(dni);
//        this.panel.add(nss);
//        panel.add(editar);
//        editar.addActionListener(e -> {
//            for (int k = 0; k < this.persones.contadorPersones; k++){
//                if (this.persones.arrayPersones[k].getClass() == Sprint3Java.Clases.Alumne.class){
//                    if (nom.getText() != ""){
//                        persones.arrayPersones[k].setNom(nom.getText());
//                    }
//                    else if (dni.getText() != ""){
//                        persones.arrayPersones[k].setDni(dni.getText());
//                    }
//                    else if (nss.getText() != ""){
//                        persones.arrayPersones[k].setNss(nss.getText());
//                    }
//                }
//            }
//            this.llistarAlumnes();
//        });
//        panel.add(tornar);
//        tornar.addActionListener(e-> this.crearPanel());
//        this.finestra.changePanel(this.panel);
//    }
//    /**
//     * Aquest mètode crea un JPanel per eliminar Alumnes, al acabar torna al menu d'Alumne(aplicarPanel())
//     */
//    public void eliminarAlumnes(){
//        this.panel = new JPanel();
//        this.panel.setLayout(new GridLayout(5,1,2,2));
//        JLabel labelEl = new JLabel("Eliminar Alumnes");
//        JTextField nom = new JTextField();
//        nom.setText("Nom a eliminar");
//        JButton eliminar = new JButton("Eliminar");
//        JButton tornar = new JButton("Tornar");
//        this.panel.add(labelEl);
//        JList llistaAlumnes1=new JList();
//        DefaultListModel model = new DefaultListModel();
//        int con = 0;
//
//        for (int i = 0; i < this.persones.contadorPersones; i++){
//            if(this.persones.arrayPersones[i].getClass() == Sprint3Java.Clases.Alumne.class){
//                model.addElement("Nom: " + persones.arrayPersones[i].getNom() + " DNI: "+ persones.arrayPersones[i].getDni()
//                        + " NSS: " + persones.arrayPersones[i].getNss());
//                con++;
//            }
//        }
//        if (con == 0){model.addElement("No hi ha alumnes");}
//        eliminar.addActionListener(e -> {
//
//            this.persones.eliminarPersonaPerNom(nom.getText());
//            this.crearPanel();
//
//        });
//        llistaAlumnes1.setModel(model);
//        this.panel.add(llistaAlumnes1);
//        this.panel.add(nom);
//        this.panel.add(eliminar);
//
//        this.panel.add(tornar);
//        tornar.addActionListener(e-> this.crearPanel());
//        this.finestra.changePanel(this.panel);
//    }
//}
