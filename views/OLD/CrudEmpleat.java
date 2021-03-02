//package Sprint4Java.views.OLD;
//
//import Sprint3Java.Clases.Empleat;
//import Sprint3Java.Clases.RepositoriMissatges;
//import Sprint3Java.Clases.RepositoriPersona;
//import Sprint4Java.views.Finestra;
//
//import javax.swing.*;
//import java.awt.*;
//import java.util.ArrayList;
//
///**
// * Grup 3 Sprint 2 2020-2021 - Alberto Dos Santos, David Falcó , Anwar El Khattabi -
// * Classe CrudEmpleat, Crear i canviar JPanels automaticament
// */
//public class CrudEmpleat {
//
//    Finestra finestra;
//    JPanel panel;
//    RepositoriPersona repoPersones;
//    RepositoriMissatges repoMissatges;
//
//    /**
//     * Constructor CrudEmpleat
//     * @param finestra objecte tipus Finestra
//     * @param repoPersones objecte tipus RepositoriPersona
//     * @param repoMissatges objecte tipus RepositoriMissatge
//     */
//    public CrudEmpleat(Finestra finestra, RepositoriPersona repoPersones, RepositoriMissatges repoMissatges) {
//        this.repoPersones = repoPersones;
//        this.finestra = finestra;
//        this.repoMissatges = repoMissatges;
//        this.aplicarPanel();
//    }
//
//    /**
//     * Aplica un panel menu sobre el crudEmpleat a la finestra principal
//     */
//    public void aplicarPanel() {
//        this.panel = new JPanel();
//        GridLayout distribucio = new GridLayout(5, 1, 2, 2);
//        this.panel.setLayout(distribucio);
//
//        JButton crear = new JButton("Crear Empleat");
//        crear.addActionListener(e -> this.afegirEmpleat(null));
//        JButton llistar = new JButton("Llistar Empleats");
//        llistar.addActionListener(e -> this.llistarEmpleat());
//        JButton editar = new JButton("Editar Empleat");
//        editar.addActionListener(e -> this.editarEmpleat());
//        JButton eliminar = new JButton("Eliminar Empleat");
//        eliminar.addActionListener(e -> this.eliminarEmpleat());
//        JButton exit = new JButton("Tornar al Menú");
//        exit.addActionListener(e -> new Sprint3Java.Finestra.PanelMenu(this.finestra, this.repoPersones, this.repoMissatges));
//
//        this.panel.add(crear);
//        this.panel.add(llistar);
//        this.panel.add(editar);
//        this.panel.add(eliminar);
//        this.panel.add(exit);
//        this.finestra.changePanel(this.panel);
//    }
//
//    /**
//     * Aplica un panel que conte components per afegir un empleat
//     * @param empleatAEditar aquest parametre serveix per editar un empleat, enviar null si s'esta creant un empleat
//     */
//    public void afegirEmpleat(Empleat empleatAEditar) {
//        this.panel = new JPanel();
//        GridLayout distribucio = new GridLayout(5, 2, 2, 2);
//        this.panel.setLayout(distribucio);
//        JLabel NomPersonaTitol = new JLabel("Nom:");
//        JTextField NomPersonaInput = new JTextField();
//        JLabel DniPersonaTitol = new JLabel("Dni:");
//        JTextField DniPersonaInput = new JTextField();
//        JLabel NssPersonaTitol = new JLabel("Nss:");
//        JTextField NssPersonaInput = new JTextField();
//        JLabel CodiEmpleatTitol = new JLabel("Codi d'Empleat:");
//        JTextField CodiEmpleatInput = new JTextField();
//        JButton crearPersona = new JButton("Crear");
//        if ( empleatAEditar != null ) {
//            crearPersona = new JButton("Guardar Canvis");
//            NomPersonaInput.setText(empleatAEditar.getNom());
//            DniPersonaInput.setText(empleatAEditar.getDni());
//            NssPersonaInput.setText(empleatAEditar.getNss());
//            CodiEmpleatInput.setText(empleatAEditar.getCodiEmpleat());
//        }
//        crearPersona.addActionListener(e -> {
//            if ( NomPersonaInput.getText().equals("") || DniPersonaInput.getText().equals("") || NssPersonaInput.getText().equals("") || CodiEmpleatInput.getText().equals("") ) {
//                this.popUp("Error al crear Empleat");
//            } else {
//                this.repoPersones.afegirPersona(new Empleat(NomPersonaInput.getText(), DniPersonaInput.getText(), NssPersonaInput.getText(), CodiEmpleatInput.getText()));
//                this.popUp("Empleat " + NomPersonaInput.getText() + " creat correctament.");
//                this.aplicarPanel();
//            }
//            //codicrearempleat
//        });
//        JButton atras = new JButton("Tornar al gestor");
//        atras.addActionListener(e -> this.aplicarPanel());
//
//        this.panel.add(NomPersonaTitol);
//        this.panel.add(NomPersonaInput);
//        this.panel.add(DniPersonaTitol);
//        this.panel.add(DniPersonaInput);
//        this.panel.add(NssPersonaTitol);
//        this.panel.add(NssPersonaInput);
//        this.panel.add(CodiEmpleatTitol);
//        this.panel.add(CodiEmpleatInput);
//        this.panel.add(crearPersona);
//        this.panel.add(atras);
//        this.finestra.changePanel(this.panel);
//    }
//    /**
//     * Aquest mètode crea un popUp(finestra emergent) que no esta relacionada amb this.finestra i sol utilitzar-se per mostrar informació
//     * @param message Missatge string per mostrar al mitj de la finestra
//     */
//    private void popUp(String message) {
//        Finestra popUp = new Finestra(200, 400, "Informació");
//        JPanel panelPopUp = new JPanel();
//        panelPopUp.setLayout(new GridLayout(2, 1));
//        JLabel msgLabel = new JLabel(message);
//        JButton continueButton = new JButton("OK");
//        continueButton.addActionListener(e -> popUp.dispose());
//        panelPopUp.add(msgLabel);
//        panelPopUp.add(continueButton);
//        popUp.changePanel(panelPopUp);
//    }
//    /**
//     * Aquest mètode crea un JPanel per eliminar Empleats, al acabar torna al menu d'empleat(aplicarPanel())
//     */
//    public void eliminarEmpleat() {
//        this.panel = new JPanel();
//        GridLayout distribucio = new GridLayout(4, 1, 2, 2);
//        this.panel.setLayout(distribucio);
//        JLabel msgLabel = new JLabel("Llistat d'Empleats");
//        ArrayList<String> empleatsRepo = new ArrayList<String>();
//        for (int i = 0; i < this.repoPersones.contadorPersones; i++) {
//            if ( this.repoPersones.arrayPersones[i].getClass() == Empleat.class ) {
//                empleatsRepo.add(this.repoPersones.arrayPersones[i].getNom());
//            }
//
//        }
//        JList llistaEmpleats = new JList(empleatsRepo.toArray());
//        JButton eliminarEmpleat = new JButton("Eliminar");
//        eliminarEmpleat.addActionListener(e -> {
//
//            if ( this.repoPersones.eliminarPersonaPerNom((String) llistaEmpleats.getSelectedValue()) )
//                this.popUp("S'ha eliminat correctament");
//            else this.popUp("Ha sorgit un error");
//            this.aplicarPanel();
//
//        });
//        JButton atras = new JButton("Tornar al gestor");
//        atras.addActionListener(e -> this.aplicarPanel());
//        this.panel.add(msgLabel);
//        this.panel.add(llistaEmpleats);
//        this.panel.add(eliminarEmpleat);
//        this.panel.add(atras);
//        this.finestra.changePanel(this.panel);
//    }
//
//    /**
//     * Aquest mètode crea un JPanel per editar Empleats, al acabar torna al menu d'empleat(aplicarPanel())
//     */
//    public void editarEmpleat() {
//        this.panel = new JPanel();
//        GridLayout distribucio = new GridLayout(4, 1, 2, 2);
//        this.panel.setLayout(distribucio);
//        JLabel msgLabel = new JLabel("Llistat d'Empleats");
//        ArrayList<String> empleatsRepo = new ArrayList<String>();
//        for (int i = 0; i < this.repoPersones.contadorPersones; i++) {
//            if ( this.repoPersones.arrayPersones[i].getClass() == Empleat.class ) {
//                empleatsRepo.add(this.repoPersones.arrayPersones[i].getNom());
//            }
//
//        }
//        JList llistaEmpleats = new JList(empleatsRepo.toArray());
//        JButton eliminarEmpleat = new JButton("Editar");
//        eliminarEmpleat.addActionListener(e -> {
//            Empleat empleatAEditar = this.repoPersones.getEmpleatByName((String) llistaEmpleats.getSelectedValue());
//            if ( this.repoPersones.eliminarPersonaPerNom((String) llistaEmpleats.getSelectedValue()) ) {
//                this.afegirEmpleat(empleatAEditar);
//            } else {
//                this.popUp("Ha sorgit un error");
//                this.aplicarPanel();
//            }
//
//
//        });
//        JButton atras = new JButton("Tornar al gestor");
//        atras.addActionListener(e -> this.aplicarPanel());
//        this.panel.add(msgLabel);
//        this.panel.add(llistaEmpleats);
//        this.panel.add(eliminarEmpleat);
//        this.panel.add(atras);
//        this.finestra.changePanel(this.panel);
//    }
//    /**
//     * Aquest mètode crea un JPanel per llistar Empleats, al acabar torna al menu d'empleat(aplicarPanel())
//     */
//    public void llistarEmpleat() {
//        this.panel = new JPanel();
//        GridLayout distribucio = new GridLayout(3, 1, 2, 2);
//        this.panel.setLayout(distribucio);
//        JLabel msgLabel = new JLabel("Llistat d'Empleats");
//        ArrayList<String> empleatsRepo = new ArrayList<String>();
//        for (int i = 0; i < this.repoPersones.contadorPersones; i++) {
//            if ( this.repoPersones.arrayPersones[i].getClass() == Empleat.class ) {
//                empleatsRepo.add("Nom: " + this.repoPersones.arrayPersones[i].getNom() + "| Dni: " + this.repoPersones.arrayPersones[i].getDni());
//            }
//        }
//        JList llistaEmpleats = new JList(empleatsRepo.toArray());
//        JButton atras = new JButton("Tornar al gestor");
//        atras.addActionListener(e -> this.aplicarPanel());
//        this.panel.add(msgLabel);
//        this.panel.add(llistaEmpleats);
//        this.panel.add(atras);
//        this.finestra.changePanel(this.panel);
//    }
//}
