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
     * Panel menú per a les opcions del crud de Matricula
     */
    public void menuMatricula() {
        this.panel = new JPanel();

        GridLayout distribucio = new GridLayout(5, 1, 2, 2);
        this.panel.setLayout(distribucio);
        JLabel titol = new JLabel("Matricules:");
        String[][] tableData = this.MainController.CMatricula.getDataTable();
        JTable table = new JTable(tableData, new String[]{"ID", "GRUP", "ALUMNE", "DATA MATRICULAT", "DATA DESMATRICULAT", "ESTAT"}) {
            public boolean editCellAt(int row, int column, java.util.EventObject e) {
                return false;
            }
        };
        JScrollPane scrollPaneTable = new JScrollPane(table);
        PanelMatricula guardar = this;
        table.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {

                    int id_edit = Integer.parseInt(tableData[table.getSelectedRow()][0]);
                    guardar.afegirMatricula(guardar.MainController.CMatricula.getMatriculaById(id_edit));

                }
            }
        });
        JButton crear = new JButton("Crear Matricula");
        crear.addActionListener(e -> this.afegirMatricula(null));


        JButton importExport = new JButton("Importar/Exportar a CSV");
        PanelMatricula aquestPanel = this;
        importExport.addActionListener(e -> {
            new PanelMenu(this.finestra, MainController);
            this.importExportPopUp();
        });
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
     * Aplica un panel que conte components per afegir una Matricula
     *
     * @param MatriculaAEditar aquest parametre s'utiliza per gestionar una unica Matricula, serveix per editar un empleat, enviar null si s'esta creant una Matricula
     *                         eliminar Matricula, al acabar torna al menu d'empleat(aplicarPanel()), editar Matricula, al acabar torna al menu d'empleat(aplicarPanel())
     */

    public void afegirMatricula(Matricula MatriculaAEditar) {
        this.panel = new JPanel();

        GridLayout distribucio = new GridLayout((MatriculaAEditar != null) ? 6 : 5, 2, 2, 2);
        this.panel.setLayout(distribucio);
        JLabel GrupMatriculaTitol = new JLabel("Grup : ");
        JComboBox GrupMatriculaInput = new JComboBox(this.MainController.CMatricula.getGroupNameList());
        JLabel AlumneMatriculaTitol = new JLabel("Alumne : ");
        JComboBox AlumneMatriculaInput = new JComboBox(this.MainController.CMatricula.getStudentNameList());
        JLabel DataMMatriculaTitol = new JLabel("Data Matriculat : format(AAAA-MM-DD)");
        JTextField DataMMatriculaInput = new JTextField();
        JLabel DataDMatriculaTitol = new JLabel("Data Desmatriculat : format(AAAA-MM-DD)");
        JTextField DataDMatriculaInput = new JTextField();
        JButton crearMatricula = new JButton("Crear");


        JButton atras = new JButton("Tornar al gestor");
        atras.addActionListener(e -> {
            if (MatriculaAEditar != null) {
                this.popUp("Cancelada la edició");
            }
            this.menuMatricula();

        });

        this.panel.add(GrupMatriculaTitol);
        this.panel.add(GrupMatriculaInput);
        this.panel.add(AlumneMatriculaTitol);
        this.panel.add(AlumneMatriculaInput);
        this.panel.add(DataMMatriculaTitol);
        this.panel.add(DataMMatriculaInput);
        this.panel.add(DataDMatriculaTitol);
        this.panel.add(DataDMatriculaInput);
        this.panel.add(crearMatricula);
        this.panel.add(atras);
        if (MatriculaAEditar != null) {
            crearMatricula.setText("Guardar Canvis");
            crearMatricula.addActionListener(e -> {
                if (GrupMatriculaInput.getSelectedItem().toString().isBlank() || AlumneMatriculaInput.getSelectedItem().toString().isBlank() || DataMMatriculaInput.getText().isBlank()) {
                    this.popUp("Error al crear la Matricula, emplena tots els camps.(No cal la data de Desmatriculacio)");
                } else {
                    int id_grup = Integer.parseInt(GrupMatriculaInput.getSelectedItem().toString().split("ID:")[1].trim());
                    int id_usuari = Integer.parseInt(AlumneMatriculaInput.getSelectedItem().toString().split("ID:")[1].trim());
                    Date dataMatricula = Date.valueOf(DataMMatriculaInput.getText());
                    Date dataDesMatricula = (DataDMatriculaInput.getText().isBlank()) ? null : Date.valueOf(DataDMatriculaInput.getText());
                    if (this.MainController.CMatricula.editMatricula(MatriculaAEditar.getId(), new Matricula(null, id_grup, id_usuari, dataMatricula, dataDesMatricula, "actiu"))) {
                        this.menuMatricula();
                        this.popUp("Matricula editada correctament.");

                    } else {
                        this.popUp("Error al editar la Matricula.");
                    }
                }
//                if (!this.MainController.CMatricula.eliminarMatricula(MatriculaAEditar.getId())) {
//                    this.menuMatricula();
//                    this.popUp("Ha sorgit un error al editar la Matricula");
//                    return;
//                }
//                if (this.MainController.CMatricula.altaMatricula(NomMatriculaInput.getText(), DescMatriculaInput.getText())) {
//                    this.menuMatricula();
//                    this.popUp("Matricula " + NomMatriculaInput.getText() + " editada " + "correctament.");
//
//                } else {
//                    this.popUp("Error al crear la Matricula.\n(No es poden repetir noms de matricules)");
//                }
//            }
            });
//            GrupMatriculaInput.setSelectedItem();
//            AlumneMatriculaInput.setSelectedItem();
            DataMMatriculaInput.setText(String.valueOf(MatriculaAEditar.getData_matriculat()));
            DataDMatriculaInput.setText(String.valueOf(MatriculaAEditar.getData_matriculat()));


            JButton eliminar = new JButton("Eliminar Matricula");
            eliminar.addActionListener(e -> {
                if (this.MainController.CMatricula.eliminarMatricula(MatriculaAEditar.getId())) {
                    this.menuMatricula();
                    this.popUp("Matricula eliminada correctament.");
                } else {
                    this.popUp("Ha sorgit un error al eliminar la Matricula");
                    this.menuMatricula();
                }
            });
            this.panel.add(eliminar);
            JButton descartar = new JButton("Descartar Canvis");
            descartar.addActionListener(e -> this.menuMatricula());
            this.panel.add(descartar);
        }
        this.finestra.changePanel(this.panel);

    }

    /**
     * Aquest mètode crea un popUp(finestra emergent) que no esta relacionada amb this.finestra i s'utilitza per el menu de exportar importar
     */
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
//            this.exportData();
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
