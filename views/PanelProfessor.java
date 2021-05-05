package Sprint5Java.views;

import Sprint5Java.controllers.MainController;
import Sprint5Java.files.ManagerCSV;
import Sprint5Java.logManager.Error;
import Sprint5Java.logManager.Log;
import Sprint5Java.models.Professor;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

public class PanelProfessor {
    MainController mainController;
    Finestra finestra;
    JPanel panel;
    ManagerCSV csv;

    public PanelProfessor(Finestra finestra, MainController mainController){
        this.finestra = finestra;
        this.mainController = mainController;
        this.csv = new ManagerCSV();
        this.crearPanell();
    }

    public void crearPanell(){
        this.panel = new JPanel();
        GridLayout distribucio = new GridLayout(6, 1, 2, 2);
        this.panel.setLayout(distribucio);
        JButton crear = new JButton("Crear Professors");
        JButton llistar = new JButton("Llistar Professors");
        JButton modificar = new JButton("Modificar Professors");
        JButton eliminar = new JButton("Eliminar Professors");
        JButton exportar = new JButton("Exportar/Importar Professors");
        JButton sortir = new JButton("Sortir");
        this.panel.add(crear);
        crear.addActionListener(e -> crearProfessor());
        this.panel.add(llistar);
        llistar.addActionListener(e -> llistarProfessor());
        this.panel.add(modificar);
        modificar.addActionListener(e -> editarProfessor());
        this.panel.add(eliminar);
        eliminar.addActionListener(e -> eliminarProfessor());
        this.panel.add(exportar);
        exportar.addActionListener(e -> this.importExportPopUp());
        this.panel.add(sortir);
        sortir.addActionListener(e -> new PanelMenu(this.finestra, this.mainController));
        this.finestra.changePanel(this.panel);
    }

    public void crearProfessor(){
        this.panel = new JPanel();
        GridLayout distribucio = new GridLayout(3, 2, 2, 2);
        this.panel.setLayout(distribucio);
        JLabel nom = new JLabel("Nom Professor");
        JLabel dni = new JLabel("DNI Professor");
        JTextField textNom = new JTextField();
        JTextField textDni = new JTextField();
        JButton tornar = new JButton("Tornar");
        JButton crear = new JButton("Crear");
        this.panel.add(nom);
        this.panel.add(textNom);
        this.panel.add(dni);
        this.panel.add(textDni);
        this.panel.add(crear);
        crear.addActionListener(e -> {
            if(this.mainController.CProfessor.altaProfessor(new Professor(textNom.getText(), textDni.getText(), "hola"))){
                this.info("S'ha creat correctament.");
            }
            else {
                this.info("Falten camps per emplenar.");
            }
            crearPanell();
        });
        this.panel.add(tornar);
        tornar.addActionListener(e -> crearPanell());
        this.finestra.changePanel(this.panel);
    }

    public void llistarProfessor(){
        this.panel = new JPanel();
        GridLayout distribucio = new GridLayout(3, 1, 2, 2);
        this.panel.setLayout(distribucio);
        JLabel llistat = new JLabel("Llistat de professors");
        String[][] tableData = this.mainController.CProfessor.dadesProfessor();
        JTable table = new JTable(tableData, new String[]{"ID","Nom", "DNI"});
        JButton tornar = new JButton("Tornar");
        this.panel.add(llistat);

        JScrollPane scrollPaneTable = new JScrollPane(table);
        this.panel.add(scrollPaneTable);
        this.panel.add(tornar);
        tornar.addActionListener(e -> crearPanell());
        this.finestra.changePanel(panel);
    }

    public void editarProfessor(){
        this.panel = new JPanel();
        GridLayout distribucio = new GridLayout(4, 1, 2, 2);
        this.panel.setLayout(distribucio);
        JLabel llistat = new JLabel("Llistat de professors");
        String[][] tableData = this.mainController.CProfessor.dadesProfessor();
        JTable table = new JTable(tableData, new String[]{"ID","Nom", "DNI"});
        JButton tornar = new JButton("Tornar");
        JButton modificar = new JButton("Modificar");
        this.panel.add(llistat);
        JScrollPane scrollPaneTable = new JScrollPane(table);
        this.panel.add(scrollPaneTable);
        this.panel.add(modificar);

        modificar.addActionListener(e-> {
            if (table.getRowCount() > 0){
                for(Integer i = 0;i<tableData.length;i++) {
                    Integer id = Integer.parseInt((String) table.getValueAt(i, 0));
                    String nom = (String) table.getValueAt(i, 1);
                    String dni = (String) table.getValueAt(i, 2);
                    System.out.println(id);
                    System.out.println(nom);
                    this.mainController.CProfessor.modificarProfessor(id, nom, dni, "Hola");
                }
                crearPanell();
                this.info("Professor modicat correctament.");
            } else {
                this.info("No s'ha pogut modificar.");
            }
        });
        this.panel.add(tornar);
        tornar.addActionListener(e -> crearPanell());
        this.finestra.changePanel(this.panel);
    }

    public void eliminarProfessor(){
        this.panel = new JPanel();
        GridLayout distribucio = new GridLayout(4, 1, 2, 2);
        this.panel.setLayout(distribucio);
        JLabel llistat = new JLabel("Llistat de professors");
        String[][] tableData = this.mainController.CProfessor.dadesProfessor();
        JTable table = new JTable(tableData, new String[]{"ID","Nom", "DNI"});
        JButton tornar = new JButton("Tornar");
        JButton eliminar = new JButton("Eliminar");
        this.panel.add(llistat);
        JScrollPane scrollPaneTable = new JScrollPane(table);
        this.panel.add(scrollPaneTable);
        this.panel.add(eliminar);
        eliminar.addActionListener(e-> {
            if (table.getRowCount() > 0 && !table.getSelectionModel().isSelectionEmpty()){
                Integer idAlumne = Integer.parseInt((String) table.getValueAt(table.getSelectedRow(),0));
                if(this.mainController.CProfessor.eliminarProfessor(idAlumne)){
                    this.info("S'ha eliminat correctament");
                    crearPanell();
                }
                else {
                    this.info("No s'ha pogut eliminar");
                    crearPanell();
                }

            }
        });
        this.panel.add(tornar);
        tornar.addActionListener(e -> crearPanell());
        this.finestra.changePanel(this.panel);
    }

    private boolean exportData() {
        String[][] getDB = this.mainController.CProfessor.dadesProfessor();
        if (getDB[0][0] == "ERROR DB") {
            Error.log("Error al exportar matricules,possiblement array buit", "exportarProfessor");
            return false;
        }
        ArrayList<String[]> export = new ArrayList<>();
        String[] columnes = {"ID", "NOM", "DNI", "CODI"};
        export.add(columnes);
        Collections.addAll(export, getDB);
        if (ManagerCSV.export(export, "Professor")) {
            Log.log("S'han exportat les professors correctament", "exportProfessor");
            return true;
        } else {
            Error.log("Error a l'exportar professors, array buit", "exportarProfessor");
            return false;
        }

    }

    private void importExportPopUp() {
        Finestra popUp = new Finestra(300, 450, "Importar/Exportar");
        JPanel panelPopUp = new JPanel();
        panelPopUp.setLayout(new GridLayout(3, 1));
        JButton importar = new JButton("Importar CSV");
        importar.addActionListener(e -> {
//            this.importData();
            popUp.dispose();
        });
        JButton exportar = new JButton("Exportar CSV");
        exportar.addActionListener(e -> {
            this.exportData();
            this.info("S'han exportat els professors");
            popUp.dispose();
        });
        JButton continueButton = new JButton("Sortir");
        continueButton.addActionListener(e -> popUp.dispose());
        panelPopUp.add(importar);
        panelPopUp.add(exportar);
        panelPopUp.add(continueButton);
//        JLabel avis = new JLabel("Recorda que NO pots utilitzar accents, emojis o el caracter \"|\" ");
//        panelPopUp.add(avis);
        popUp.changePanel(panelPopUp);
    }
    public void info(String text){
        JOptionPane.showMessageDialog(null, text);
    }
}
