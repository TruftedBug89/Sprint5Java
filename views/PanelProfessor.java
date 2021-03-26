package Sprint5Java.views;

import Sprint5Java.controllers.MainController;
import Sprint5Java.models.Professor;

import javax.swing.*;
import java.awt.*;

public class PanelProfessor {
    MainController mainController;
    Finestra finestra;
    JPanel panel;

    public PanelProfessor(Finestra finestra, MainController mainController){
        this.finestra = finestra;
        this.mainController = mainController;
        this.crearPanell();
    }

    public void crearPanell(){
        this.panel = new JPanel();
        GridLayout distribucio = new GridLayout(7, 1, 2, 2);
        this.panel.setLayout(distribucio);
        JButton crear = new JButton("Crear Professors");
        JButton llistar = new JButton("Llistar Professors");
        JButton modificar = new JButton("Modificar Professors");
        JButton eliminar = new JButton("Eliminar Professors");
        JButton exportar = new JButton("Exportar Professors");
        JButton importar = new JButton("Importar Professors");
        JButton sortir = new JButton("Sortir");
        this.panel.add(crear);
        crear.addActionListener(e -> crearProfessor());
        this.panel.add(llistar);
        llistar.addActionListener(e -> llistarProfessor());
        this.panel.add(modificar);
        modificar.addActionListener(e -> editarProfessor());
        this.panel.add(eliminar);
        this.panel.add(exportar);
        this.panel.add(importar);
        this.panel.add(sortir);
        sortir.addActionListener(e -> new PanelMenu(this.finestra, this.mainController));
        this.finestra.changePanel(this.panel);
    }

    public void crearProfessor(){
        this.panel = new JPanel();
        GridLayout distribucio = new GridLayout(4, 2, 2, 2);
        this.panel.setLayout(distribucio);
        JLabel nom = new JLabel("Nom Professor");
        JLabel dni = new JLabel("DNI Professor");
        JLabel codi = new JLabel("Codi Professor");
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
        tornar.addActionListener(e -> this.mainController.CProfessor.altaProfessor(new Professor(textNom.getText(), textDni.getText(), codi.getText())));
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
        JTable table = new JTable(tableData, new String[]{"ID","Nom", "DNI", "Codi"});
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
                    this.mainController.CProfessor.modificarProfessor(id, nom, dni, codi);
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

    public void eliminarProfessor(){
        this.panel = new JPanel();
        this.finestra.changePanel(panel);
    }

}