package Sprint5Java.views;

import Sprint5Java.controllers.MainController;
import Sprint5Java.models.Matricula;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;

/**
 * Grup 2 Sprint 5 2020-2021 - Alberto Dos Santos
 * Classe PanelMatricula, Gestiona els panels del Crud
 */
public class PanelMatricula {
    MainController MainController;
    Finestra finestra;
    JPanel panel;

    /**
     * Constructor Per als Panels de Matricula
     *
     * @param finestra       objecte Finestra
     * @param MainController objecte MainController per accedir als controladors per editar informacio
     */
    public PanelMatricula(Finestra finestra, MainController MainController) {
        this.finestra = finestra;
        this.MainController = MainController;
        this.menuMatricula();
    }

    /**
     * Panel menú per a les opcions del crud de Matricula
     */
    public void menuMatricula() {
        this.panel = new JPanel();

        GridLayout distribucio = new GridLayout(5, 1, 2, 2);
        this.panel.setLayout(distribucio);
        JLabel titol = new JLabel("Matricules:");
        String[][] tableData = this.MainController.CMatricula.getDataTable();
        JTable table = new JTable(tableData, new String[]{"ID", "GRUP", "ALUMNE", "DATA MATRICULAT", "DATA DESMATRICULAT", "ESTAT"} ){
            public boolean editCellAt(int row, int column, java.util.EventObject e) {
                return false;
            }
        };
//        table.setRowSelectionAllowed(false);
        JScrollPane scrollPaneTable = new JScrollPane(table);
        PanelMatricula guardar = this;
        table.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
//                System.out.println(e.getClickCount());
                if (e.getClickCount() == 2) {
                    int id_edit = Integer.parseInt(tableData[table.getSelectedRow()][0]);
                    guardar.afegirMatricula(new Matricula(Integer.parseInt(tableData[table.getSelectedRow()][0]),Integer.parseInt(tableData[table.getSelectedRow()][1]),Integer.parseInt(tableData[table.getSelectedRow()][2]),Date.valueOf(tableData[table.getSelectedRow()][3]),Date.valueOf(tableData[table.getSelectedRow()][4]), tableData[table.getSelectedRow()][5]));
//                    Matricula MatriculaAEditar = guardar.MainController.CMatricula.getMatriculaByName((table.getrowllistaMatricula.getSelectedValue()).substring(5));
//                    guardar.afegirMatricula(MatriculaAEditar);

                }
            }
        });
        JButton crear = new JButton("Crear Matricula");
//        crear.addActionListener(e -> this.afegirMatricula(null));


        JButton importExport = new JButton("Importar/Exportar a CSV");
        PanelMatricula aquestPanel = this;
//        importExport.addActionListener(e -> {
//            new PanelMenu(this.finestra, MainController);
//            this.importExportPopUp();
//        });
        JButton exit = new JButton("Tornar al Menú");
        exit.addActionListener(e -> new PanelMenu(this.finestra, MainController));

        this.panel.add(titol);
        this.panel.add(scrollPaneTable);
        this.panel.add(crear);
        this.panel.add(importExport);
        this.panel.add(exit);
        this.finestra.changePanel(this.panel);
    }

    /**
     * Aquest mètode exporta les dades actuals a la carpeta Exports
     */
//    private void exportData() {
//        ArrayList<String[]> export = new ArrayList<>();
//
//        String[] columnes = {"ID", "NOM", "DESCRIPCIO"};
//        export.add(columnes);
//        for (Matricula cat : this.MGestors.GMatricula.getArray()) {
//            String[] i = {String.valueOf(cat.getId()), cat.getNom().replace(",","|"), cat.getDescripcio().replace(",","|")};
//            export.add(i);
//        }
//        if (ManagerCSV.export(export, "Matricula")) {
//            this.popUp("S'ha exportat Correctament");
//            Log.log("S'han exportat les matricules correctament", "exportMatricula");
//        } else {
//            this.popUp("Error al exportar, array buit");
//            Error.log("Error al exportar matricules, array buit", "exportarMatricula");
//        }
//
//
//    }

    /**
     * Aquest mètode importa les dades d'un arxiu a l'aplicacio.
     */
//    private void importData() {
//        ArrayList<String> dadesImportades = ManagerCSV.importCSV();
//        if (dadesImportades == null) return;
//        dadesImportades.remove(0);//El·liminem la capçalera
//        int matriculesImportades = 0;
//        for (String dada : dadesImportades) {
//            matriculesImportades++;
//            String[] data = dada.split(",");
//            if (data.length < 3) continue;
//            this.MGestors.GMatricula.altaMatricula(data[1].replace("|",","), data[2].replace("|",","));
//        }
//        this.popUp("Importades " + matriculesImportades + " matricules.");
//        Log.log("Importades " + matriculesImportades + " matricules.", "importMatricula");
//    }

    /**
     * Aplica un panel que conte components per afegir una Matricula
     *
     * @param MatriculaAEditar aquest parametre s'utiliza per gestionar una unica Matricula, serveix per editar un empleat, enviar null si s'esta creant una Matricula
     *                         eliminar Matricula, al acabar torna al menu d'empleat(aplicarPanel()), editar Matricula, al acabar torna al menu d'empleat(aplicarPanel())
     */

    public void afegirMatricula(Matricula MatriculaAEditar) {
        this.panel = new JPanel();

        GridLayout distribucio = new GridLayout((MatriculaAEditar != null) ? 4 : 3, 2, 2, 2);
        this.panel.setLayout(distribucio);
        JLabel NomMatriculaTitol = new JLabel("Nom:");
        JTextField NomMatriculaInput = new JTextField();
        JLabel DescMatriculaTitol = new JLabel("Descripció:");
        JTextField DescMatriculaInput = new JTextField();

        JButton crearMatricula = new JButton("Crear");


        JButton atras = new JButton("Tornar al gestor");
//        atras.addActionListener(e -> {
//            if (MatriculaAEditar != null) {
//                this.MainController.CMatricula.altaMatricula(MatriculaAEditar.getNom(), MatriculaAEditar.getDescripcio());
//                this.popUp("Cancelada la edició");
//            }
//            this.menuMatricula();
//
//        });


        this.panel.add(NomMatriculaTitol);
        this.panel.add(NomMatriculaInput);
        this.panel.add(DescMatriculaTitol);
        this.panel.add(DescMatriculaInput);
        this.panel.add(crearMatricula);
        this.panel.add(atras);
//        if (MatriculaAEditar != null) {
//            crearMatricula.setText("Guardar Canvis");
//            crearMatricula.addActionListener(e -> {
//                if (NomMatriculaInput.getText().isBlank() || DescMatriculaInput.getText().isBlank()) {
//                    this.popUp("Error al crear la Matricula, emplena tots els camps.");
//
//                } else {
//                    if (!this.MainController.CMatricula.eliminarMatricula(MatriculaAEditar.getId())) {
//                        this.menuMatricula();
//                        this.popUp("Ha sorgit un error al editar la Matricula");
//                        return;
//                    }
//                    if (this.MainController.CMatricula.altaMatricula(NomMatriculaInput.getText(), DescMatriculaInput.getText())) {
//                        this.menuMatricula();
//                        this.popUp("Matricula " + NomMatriculaInput.getText() + " editada " + "correctament.");
//
//                    } else {
//                        this.popUp("Error al crear la Matricula.\n(No es poden repetir noms de matricules)");
//                    }
//                }
//            });
//            NomMatriculaInput.setText(MatriculaAEditar.getNom());
//            DescMatriculaInput.setText(MatriculaAEditar.getDescripcio());
//            JButton descartar = new JButton("Descartar Canvis");
//            descartar.addActionListener(e -> this.menuMatricula());
//            this.panel.add(descartar);
//            JButton eliminar = new JButton("Eliminar Matricula");
//            eliminar.addActionListener(e -> {
//                if (this.MainController.CMatricula.eliminarMatricula(MatriculaAEditar.getId())) {
//                    this.menuMatricula();
//                    this.popUp("Matricula " + MatriculaAEditar.getNom() + " eliminada correctament.");
//                } else {
//                    this.popUp("Ha sorgit un error al eliminar la Matricula");
//                    this.menuMatricula();
//                }
//            });
//            this.panel.add(eliminar);
//        } else {
//            crearMatricula.addActionListener(e -> {
//                if (NomMatriculaInput.getText().isBlank() || DescMatriculaInput.getText().isBlank()) {
//                    this.popUp("Error al crear la Matricula, emplena tots els camps.");
//
//                } else {
//                    if (this.MainController.CMatricula.altaMatricula(NomMatriculaInput.getText(), DescMatriculaInput.getText())) {
//                        this.menuMatricula();
//                        this.popUp("Matricula " + NomMatriculaInput.getText() + " creada " + "correctament.");
//
//                    } else {
//                        this.popUp("Error al crear la Matricula.\n(No es poden repetir noms de matricules)");
//                    }
//                }
//            });
//        }
        this.finestra.changePanel(this.panel);

    }

    /**
     * Aquest mètode crea un popUp(finestra emergent) que no esta relacionada amb this.finestra i s'utilitza per el menu de exportar importar
     */
//    private void importExportPopUp() {
//        Finestra popUp = new Finestra(300, 450, "Informació", null);
//        JPanel panelPopUp = new JPanel();
//        panelPopUp.setLayout(new GridLayout(4, 1));
//        JButton importar = new JButton("Importar CSV");
//        importar.addActionListener(e -> {
//            this.importData();
//            popUp.dispose();
//        });
//        JButton exportar = new JButton("Exportar CSV");
//        exportar.addActionListener(e -> {
//            this.exportData();
//            popUp.dispose();
//        });
//        JButton continueButton = new JButton("Sortir");
//        continueButton.addActionListener(e -> popUp.dispose());
//        panelPopUp.add(importar);
//        panelPopUp.add(exportar);
//        panelPopUp.add(continueButton);
//        JLabel avis = new JLabel("Recorda que NO pots utilitzar accents, emojis o el caracter \"|\" ");
//        panelPopUp.add(avis);
//        popUp.changePanel(panelPopUp);
//    }

    /**
     * Aquest mètode crea un popUp(finestra emergent) que no esta relacionada amb this.finestra i sol utilitzar-se per mostrar informació
     *
     * @param message Missatge string per mostrar al mitj de la finestra
     */
    private void popUp(String message) {
        JOptionPane.showMessageDialog(this.finestra, message, "Informació", JOptionPane.INFORMATION_MESSAGE);
//        __________________________________
//                JOptionPane Manual
//        Finestra popUp = new Finestra(200, 400, "Informació");
//        JPanel panelPopUp = new JPanel();
//        panelPopUp.setLayout(new GridLayout(2, 1));
//        JLabel msgLabel = new JLabel(message);
//        JButton continueButton = new JButton("OK");
//        continueButton.addActionListener(e -> popUp.dispose());
//        panelPopUp.add(msgLabel);
//        panelPopUp.add(continueButton);
//        popUp.changePanel(panelPopUp);
    }


}
