package Sprint5Java.views;

import Sprint5Java.controllers.MainController;
import Sprint5Java.files.ManagerCSV;
import Sprint5Java.logManager.Error;
import Sprint5Java.logManager.Log;
import Sprint5Java.models.Alumne;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

public class PanelAlumne {
    MainController mainController;
    Finestra finestra;
    JPanel panel;
    ManagerCSV csv;

    public PanelAlumne(Finestra finestra, MainController mainController){
        this.finestra = finestra;
        this.mainController = mainController;
        this.csv = new ManagerCSV();
        this.crearPanell();
    }

    public void crearPanell(){
        this.panel = new JPanel();
        GridLayout distribucio = new GridLayout(6, 1, 2, 2);
        this.panel.setLayout(distribucio);
        JButton crear = new JButton("Crear Alumnes");
        JButton llistar = new JButton("Llistar Alumnes");
        JButton modificar = new JButton("Modificar Alumnes");
        JButton eliminar = new JButton("Eliminar Alumnes");
        JButton sortir = new JButton("Sortir");
        this.panel.add(crear);
        crear.addActionListener(e -> crearAlumne());
        this.panel.add(llistar);
        llistar.addActionListener(e -> llistarAlumne());
        this.panel.add(modificar);
        modificar.addActionListener(e -> editarAlumne());
        this.panel.add(eliminar);
        eliminar.addActionListener(e -> eliminarAlumne());
        this.panel.add(sortir);
        sortir.addActionListener(e -> new PanelMenu(this.finestra, this.mainController));
        this.finestra.changePanel(this.panel);
    }

    public void crearAlumne(){
        this.panel = new JPanel();
        GridLayout distribucio = new GridLayout(4, 2, 2, 2);
        this.panel.setLayout(distribucio);
        JLabel nom = new JLabel("Nom Alumne");
        JLabel dni = new JLabel("DNI Alumne");
        JLabel codi = new JLabel("Codi Alumne");
        JTextField textNom = new JTextField();
        JTextField textDni = new JTextField();
        JTextField textCodi = new JTextField();
        JButton tornar = new JButton("Tornar");
        JButton crear = new JButton("Crear");
        this.panel.add(nom);
        this.panel.add(textNom);
        this.panel.add(dni);
        this.panel.add(textDni);
        this.panel.add(codi);
        this.panel.add(textCodi);
        this.panel.add(crear);
        tornar.addActionListener(e -> this.mainController.CAlumne.altaAlumne(new Alumne(textNom.getText(), textDni.getText(), codi.getText())));
        this.panel.add(tornar);
        tornar.addActionListener(e -> crearPanell());
        this.finestra.changePanel(this.panel);
    }

    public void llistarAlumne(){
        this.panel = new JPanel();
        GridLayout distribucio = new GridLayout(3, 1, 2, 2);
        this.panel.setLayout(distribucio);
        JLabel llistat = new JLabel("Llistat d'Alumnes");
        String[][] tableData = this.mainController.CAlumne.dadesAlumne();
        JTable table = new JTable(tableData, new String[]{"ID","Nom", "DNI", "Codi"});
        JButton tornar = new JButton("Tornar");
        this.panel.add(llistat);

        JScrollPane scrollPaneTable = new JScrollPane(table);
        this.panel.add(scrollPaneTable);
        this.panel.add(tornar);
        tornar.addActionListener(e -> crearPanell());
        this.finestra.changePanel(panel);
    }

    public void editarAlumne(){
        this.panel = new JPanel();
        GridLayout distribucio = new GridLayout(4, 1, 2, 2);
        this.panel.setLayout(distribucio);
        JLabel llistat = new JLabel("Llistat d'Alumnes");
        String[][] tableData = this.mainController.CAlumne.dadesAlumne();
        JTable table = new JTable(tableData, new String[]{"ID","Nom", "DNI", "Codi"});
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
                    String codi = (String) table.getValueAt(i, 3);
                    System.out.println(id);
                    System.out.println(nom);
                    this.mainController.CAlumne.modificarAlumne(id, nom, dni, codi);
                }
            } else {
                //this.LOGGER.warning("No s'ha pogut modificar l'alumne, cap registre seleccionat.");
                //finestra.popup("Cap registre seleccionat actualment");
            }
        });
        this.panel.add(tornar);
        tornar.addActionListener(e -> crearPanell());
        this.finestra.changePanel(this.panel);
    }

    public void eliminarAlumne(){
        this.panel = new JPanel();
        GridLayout distribucio = new GridLayout(4, 1, 2, 2);
        this.panel.setLayout(distribucio);
        JLabel llistat = new JLabel("Llistat d'alumnes");
        String[][] tableData = this.mainController.CAlumne.dadesAlumne();
        JTable table = new JTable(tableData, new String[]{"ID","Nom", "DNI", "Codi"});
        JButton tornar = new JButton("Tornar");
        JButton eliminar = new JButton("Eliminar");
        this.panel.add(llistat);
        JScrollPane scrollPaneTable = new JScrollPane(table);
        this.panel.add(scrollPaneTable);
        this.panel.add(eliminar);
        eliminar.addActionListener(e-> {
            if (table.getRowCount() > 0 && !table.getSelectionModel().isSelectionEmpty()){
                Integer idAlumne = Integer.parseInt((String) table.getValueAt(table.getSelectedRow(),0));
                this.mainController.CAlumne.eliminarAlumne(idAlumne);
                // finestra.changePanel(1,4);
                //finestra.popup("Usuari eliminat correctament");
            }
        });
        this.panel.add(tornar);
        tornar.addActionListener(e -> crearPanell());
        this.finestra.changePanel(this.panel);
    }

    private boolean exportData() {
        String[][] getDB = this.mainController.CAlumne.dadesAlumne();
        if (getDB[0][0] == "ERROR DB") {
            Error.log("Error: No s'han trobat alumnes.", "exportarAlumne");
            return false;
        }
        ArrayList<String[]> export = new ArrayList<>();
        String[] columnes = {"ID", "NOM", "DNI", "CODI"};
        export.add(columnes);
        Collections.addAll(export, getDB);
        if (ManagerCSV.export(export, "Alumne")) {
            Log.log("S'han exportat els alumnes correctament", "exportAlumne");
            return true;
        } else {
            Error.log("Error: No s'han trobat alumnes.", "exportarAlumne");
            return false;
        }

    }



}

