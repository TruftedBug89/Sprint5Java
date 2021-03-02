//package Sprint4Java.views.OLD;
//
//import Sprint3Java.Clases.Missatge;
//import Sprint3Java.Clases.RepositoriMissatges;
//import Sprint3Java.Clases.RepositoriPersona;
//import Sprint4Java.views.Finestra;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.MouseAdapter;
//import java.awt.event.MouseEvent;
//import java.util.ArrayList;
//
///**
// * Grup 3 Sprint 2 2020-2021 - Alberto Dos Santos, David Falcó , Anwar El Khattabi -
// * Classe que crea els diferents JPanels i els aplica a la finestra per poder gestionar Missatges
// */
//public class Missatgeria {
//    Finestra finestra;
//    JPanel panel;
//    RepositoriPersona repoPersones;
//    RepositoriMissatges repoMissatges;
//    private JList llistaMissatgesRebuts;
//    private JComboBox selectUserBox;
//    private JButton updateButton;
//    private JComboBox emissorMsg;
//    private JComboBox receptorMsg;
//    private JTextArea cosMsg;
//
//
//    /**
//     * Constructor principal per a iniciar la Missatgeria, aplica un JPanel a la finestra per defecte.
//     * @param finestra Marcar-li a quina finestra te que aplicar el menu
//     * @param repoPersones Repositori per a emmagatzemar Persones
//     * @param repoMissatges Repositori per a emmagatzemar Missatges
//     */
//    public Missatgeria(Finestra finestra, RepositoriPersona repoPersones, RepositoriMissatges repoMissatges) {
//        this.repoMissatges = repoMissatges;
//        this.repoPersones = repoPersones;
//        this.finestra = finestra;
//
//        //Botons de llistar Missatges
//
//        this.selectUserBox = this.jcomboboxPersones();
//
//        this.aplicarPanel();
//
//
//    }
//
//    /**
//     * Mètode que crea un JComboBox amb un llistat de totes les persones del repositori donat com a argument
//     * @return objecte JComboBox
//     */
//    public JComboBox jcomboboxPersones() {
//        ArrayList<String> nomPersones = new ArrayList<String>();
//        for (int i = 0; i < this.repoPersones.contadorPersones; i++) {
//            nomPersones.add(this.repoPersones.arrayPersones[i].getNom());
//        }
//        return new JComboBox(nomPersones.toArray());
//
//    }
//
//    /**
//     * Aquest mètode conte un menu per a la gestio de Missatges, aplica el JPanel a this.finestra
//     */
//    public void aplicarPanel() {
//        this.updateButton = new JButton("Actualitzar");
//        this.llistaMissatgesRebuts = new JList(new String[]{"No actualitzat"});
//        this.panel = new JPanel();
//        GridLayout distribucio = new GridLayout(4, 1, 2, 2);
//        this.panel.setLayout(distribucio);
//
//        JButton crear = new JButton("Enviar Missatge");
//        crear.addActionListener(e -> this.afegirMissatge());
//        JButton llistar = new JButton("Llistar Missatges");
//        llistar.addActionListener(e -> this.llistarMissatges());
//        JButton eliminar = new JButton("Eliminar Missatge");
//        eliminar.addActionListener(e -> this.eliminarMissatge());
//        JButton exit = new JButton("Tornar al Menú");
//        exit.addActionListener(e -> new Sprint3Java.Finestra.PanelMenu(this.finestra, this.repoPersones, this.repoMissatges));
//        this.panel.add(crear);
//        this.panel.add(llistar);
//        this.panel.add(eliminar);
//        this.panel.add(exit);
//        this.finestra.changePanel(this.panel);
//    }
//
//    /**
//     * Aquest mètode crea un JPanel per crear Missatges, al acabar torna al menu de missatges(aplicarPanel())
//     */
//    public void afegirMissatge() {
//        this.panel = new JPanel();
//        GridLayout distribucio = new GridLayout(4, 2, 2, 2);
//        this.panel.setLayout(distribucio);
//        JLabel emissorMsgLabel = new JLabel("Emissor:");
//        this.emissorMsg = this.jcomboboxPersones();
//        JLabel receptorMsgLabel = new JLabel("Receptor:");
//        this.receptorMsg = this.jcomboboxPersones();
//        JLabel cosMissatgeLabel = new JLabel("Cos del Missatge:");
//        this.cosMsg = new JTextArea();
//        JButton crearMissatge = new JButton("Crear");
//
//        crearMissatge.addActionListener(e -> {
//            if ( String.valueOf(emissorMsg.getSelectedItem()).equals("") || String.valueOf(emissorMsg.getSelectedItem()).equals("") || cosMsg.getText().equals("") ) {
//                this.popUp("Error al crear Missatge");
//            } else if ( cosMsg.getText().length() > 30 ) {
//                this.popUp("Text massa llarg, 30 caracters màxim.");
//            } else{
//                Missatge missatgeAEnviar = new Missatge(this.repoPersones.getPersonaByName((String) this.emissorMsg.getSelectedItem()), this.repoPersones.getPersonaByName((String) this.receptorMsg.getSelectedItem()), this.cosMsg.getText());
//                this.repoMissatges.afegirMissatge(missatgeAEnviar);
//                this.popUp("Missatge enviat correctament.");
//                this.aplicarPanel();
//            }
//            //codicrearempleat
//        });
//        JButton atras = new JButton("Tornar al gestor");
//        atras.addActionListener(e -> this.aplicarPanel());
//
//        this.panel.add(emissorMsgLabel);
//        this.panel.add(emissorMsg);
//        this.panel.add(receptorMsgLabel);
//        this.panel.add(receptorMsg);
//        this.panel.add(cosMissatgeLabel);
//        this.panel.add(cosMsg);
//        this.panel.add(crearMissatge);
//        this.panel.add(atras);
//        this.finestra.changePanel(this.panel);
//    }
//
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
//     * Aquest mètode STATIC crea un popUp(finestra emergent) que no esta relacionada amb this.finestra i sol utilitzar-se per mostrar informació
//     * @param data Missatge string per mostrar al mitj de la finestra
//     */
//    private static void msgPopUp(String data) {
//        Finestra popUp = new Finestra(200, 400, "Missatge");
//        JPanel panelPopUp = new JPanel();
//        panelPopUp.setLayout(new GridLayout(2, 1));
//        JLabel msgLabel = new JLabel(data);
//        JButton continueButton = new JButton("OK");
//        continueButton.addActionListener(e -> popUp.dispose());
//        panelPopUp.add(msgLabel);
//        panelPopUp.add(continueButton);
//        popUp.changePanel(panelPopUp);
//    }
//
//    /**
//     * Aquest mètode crea un JPanel per eliminar Missatges, al acabar torna al menu de missatges(aplicarPanel())
//     */
//    public void eliminarMissatge() {
//        this.panel = new JPanel();
//        GridLayout distribucio = new GridLayout(3, 1, 2, 2);
//        this.panel.setLayout(distribucio);
//        JLabel selectUser = new JLabel("Sel·lecciona un usuari:");
//        JLabel msgList = new JLabel("Llistat de Missatges");
//
//
//        this.updateButton.addActionListener(e -> {
//            if ( this.updateButton.getText().equals("Actualitzar") ) {
//                ArrayList<String> missatges = new ArrayList<String>();
//                for (int i = 0; i < this.repoMissatges.contadorMissatges; i++) {
//                    if ( this.repoMissatges.arrayMissatges[i].receptor.getNom() == selectUserBox.getSelectedItem() ) {
//                        missatges.add("Msg " + missatges.size() + " | De: " + this.repoMissatges.arrayMissatges[i].emissor.getNom() + " | :" + this.repoMissatges.arrayMissatges[i].cosText);
//                    }
//                }
//                this.llistaMissatgesRebuts = new JList((missatges.isEmpty() ? new String[]{"No hi ha ningun missatge"} : missatges.toArray()));
//
//                this.selectUserBox.setSelectedIndex(this.selectUserBox.getSelectedIndex());
//                this.updateButton = new JButton("Eliminar");
//                this.eliminarMissatge();
//            } else {
//                boolean found = false;
//                String cosMissatgeComplet = ((String) (this.llistaMissatgesRebuts.getSelectedValue())).split("|")[2].substring(1);
//                System.out.println(cosMissatgeComplet);
//                for (int i = 0; i < this.repoMissatges.contadorMissatges; i++) {
//                    if ( this.repoMissatges.arrayMissatges[i].cosText.contains(cosMissatgeComplet) ) {
//                        found = true;
//                        this.repoMissatges.eliminarMissatge(i);
//                        this.popUp("El missatge s'ha el·liminat");
//                    }
//                    if ( !found ) {
//                        this.popUp("Ha sorgit un error ,el missatge NO s'ha el·liminat");
//                    }
//                }
//                this.updateButton = new JButton("Actualitzar");
//                this.aplicarPanel();
//            }
//        });
//        this.llistaMissatgesRebuts.addMouseListener(new MouseAdapter() {
//            public void mousePressed(MouseEvent e) {
//                JList theList = (JList) e.getSource();
//                if ( e.getClickCount() == 2 ) {
//                    Missatgeria.msgPopUp((String) theList.getSelectedValue());
//                }
//            }
//        });
//        JButton atras = new JButton("Tornar al gestor");
//        atras.addActionListener(e -> this.
//
//                aplicarPanel());
//        this.panel.add(selectUser);
//        this.panel.add(this.selectUserBox);
//        this.panel.add(msgList);
//        this.panel.add(this.llistaMissatgesRebuts);
//        this.panel.add(this.updateButton);
//        this.panel.add(atras);
//        this.finestra.changePanel(this.panel);
//    }
//
//    /**
//     * Aquest mètode crea un JPanel per llistar Missatges, al acabar torna al menu de missatges(aplicarPanel())
//     */
//    public void llistarMissatges() {
//        this.panel = new JPanel();
//        GridLayout distribucio = new GridLayout(3, 1, 2, 2);
//        this.panel.setLayout(distribucio);
//        JLabel selectUser = new JLabel("Sel·lecciona un usuari:");
//        JLabel msgList = new JLabel("Llistat de Missatges");
//        JButton update = new JButton("Actualitzar");
//
//        update.addActionListener(e -> {
//            ArrayList<String> missatges = new ArrayList<String>();
//            for (int i = 0; i < this.repoMissatges.contadorMissatges; i++) {
//                if ( this.repoMissatges.arrayMissatges[i].receptor.getNom() == selectUserBox.getSelectedItem() ) {
//                    missatges.add("Msg " + missatges.size() + " | De: " + this.repoMissatges.arrayMissatges[i].emissor.getNom() + " | \n:" + this.repoMissatges.arrayMissatges[i].cosText);
//                }
//            }
//            this.llistaMissatgesRebuts = new JList((missatges.isEmpty() ? new String[]{"No hi ha ningun missatge"} : missatges.toArray()));
//
//            this.selectUserBox.setSelectedIndex(this.selectUserBox.getSelectedIndex());
//            this.llistarMissatges();
//
//
//        });
//        this.llistaMissatgesRebuts.addMouseListener(new MouseAdapter() {
//            public void mousePressed(MouseEvent e) {
//                JList theList = (JList) e.getSource();
//                if ( e.getClickCount() == 2 ) {
//                    Missatgeria.msgPopUp((String) theList.getSelectedValue());
//                }
//            }
//        });
//        JButton atras = new JButton("Tornar al gestor");
//        atras.addActionListener(e -> this.aplicarPanel());
//        this.panel.add(selectUser);
//        this.panel.add(this.selectUserBox);
//        this.panel.add(msgList);
//        this.panel.add(this.llistaMissatgesRebuts);
//        this.panel.add(update);
//        this.panel.add(atras);
//        this.finestra.changePanel(this.panel);
//    }
//}
