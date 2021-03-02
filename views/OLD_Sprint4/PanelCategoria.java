//package Sprint5Java.views.OLD_Sprint4;
//
//import Sprint4Java.files.ManagerCSV;
//import Sprint4Java.logManager.Error;
//import Sprint4Java.logManager.Log;
//import Sprint4Java.modules.ModulsGestors;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.MouseAdapter;
//import java.awt.event.MouseEvent;
//import java.util.ArrayList;
//
///**
// * Grup 2 Sprint 5 2020-2021 - Alberto Dos Santos
// * Classe PanelCategoria, Gestiona els panels del Crud
// */
//public class PanelCategoria {
//    final ModulsGestors MGestors;
//    Sprint4Java.views.Finestra finestra;
//    JPanel panel;
//
//    /**
//     * Constructor Per als Panels de Categoria
//     *
//     * @param finestra objecte Finestra
//     * @param MGestors objecte ModulsGestors per editar informacio
//     */
//    public PanelCategoria(Sprint4Java.views.Finestra finestra, ModulsGestors MGestors) {
//        this.finestra = finestra;
//        this.MGestors = MGestors;
//        this.menuCategoria();
//    }
//
//    /**
//     * Panel menú per a les opcions del crud de Categoria
//     */
//    public void menuCategoria() {
//        this.panel = new JPanel();
//
//        GridLayout distribucio = new GridLayout(5, 1, 2, 2);
//        this.panel.setLayout(distribucio);
//
//        JLabel titol = new JLabel("Categories:");
//
//        JList<String> llistaCategoria = new JList<>(this.MGestors.GCategoria.llistarCategoriaAArray());
//        llistaCategoria.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
//        JScrollPane scrollPane = new JScrollPane(llistaCategoria);
//        llistaCategoria.setVisibleRowCount(2);
//        llistaCategoria.setLayoutOrientation(JList.VERTICAL);
//        PanelCategoria guardar = this;
//        llistaCategoria.addMouseListener(new MouseAdapter() {
//
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                if (e.getClickCount() == 2) {
//                    Categoria categoriaAEditar = guardar.MGestors.GCategoria.getCategoriaByName((llistaCategoria.getSelectedValue()).substring(5));
//                    guardar.afegirCategoria(categoriaAEditar);
//
//                }
//            }
//        });
//        JButton crear = new JButton("Crear Categoria");
//        crear.addActionListener(e -> this.afegirCategoria(null));
//
//
//        JButton importExport = new JButton("Importar/Exportar a CSV");
//        PanelCategoria aquestPanel = this;
//        importExport.addActionListener(e -> {
//            new Sprint4Java.views.PanelMenu(this.finestra, MGestors);
//            this.importExportPopUp();
//        });
//        JButton exit = new JButton("Tornar al Menú");
//        exit.addActionListener(e -> new Sprint4Java.views.PanelMenu(this.finestra, MGestors));
//
//        this.panel.add(titol);
//        this.panel.add(scrollPane);
//        this.panel.add(crear);
//        this.panel.add(importExport);
//        this.panel.add(exit);
//        this.finestra.changePanel(this.panel);
//    }
//
//    /**
//     * Aquest mètode exporta les dades actuals a la carpeta Exports
//     */
//    private void exportData() {
//        ArrayList<String[]> export = new ArrayList<>();
//
//        String[] columnes = {"ID", "NOM", "DESCRIPCIO"};
//        export.add(columnes);
//        for (Categoria cat : this.MGestors.GCategoria.getArray()) {
//            String[] i = {String.valueOf(cat.getId()), cat.getNom().replace(",","|"), cat.getDescripcio().replace(",","|")};
//            export.add(i);
//        }
//        if (ManagerCSV.export(export, "Categoria")) {
//            this.popUp("S'ha exportat Correctament");
//            Log.log("S'han exportat les categories correctament", "exportcategoria");
//        } else {
//            this.popUp("Error al exportar, array buit");
//            Error.log("Error al exportar categories, array buit", "exportarcategoria");
//        }
//
//
//    }
//
//    /**
//     * Aquest mètode importa les dades d'un arxiu a l'aplicacio.
//     */
//    private void importData() {
//        ArrayList<String> dadesImportades = ManagerCSV.importCSV();
//        if (dadesImportades == null) return;
//        dadesImportades.remove(0);//El·liminem la capçalera
//        int categoriesImportades = 0;
//        for (String dada : dadesImportades) {
//            categoriesImportades++;
//            String[] data = dada.split(",");
//            if (data.length < 3) continue;
//            this.MGestors.GCategoria.altaCategoria(data[1].replace("|",","), data[2].replace("|",","));
//        }
//        this.popUp("Importades " + categoriesImportades + " categories.");
//        Log.log("Importades " + categoriesImportades + " categories.", "importcategoria");
//    }
//
//    /**
//     * Aplica un panel que conte components per afegir una categoria
//     *
//     * @param categoriaAEditar aquest parametre s'utiliza per gestionar una unica categoria, serveix per editar un empleat, enviar null si s'esta creant una categoria
//     *                         eliminar categoria, al acabar torna al menu d'empleat(aplicarPanel()), editar categoria, al acabar torna al menu d'empleat(aplicarPanel())
//     */
//
//    public void afegirCategoria(Categoria categoriaAEditar) {
//        this.panel = new JPanel();
//
//        GridLayout distribucio = new GridLayout((categoriaAEditar != null) ? 4 : 3, 2, 2, 2);
//        this.panel.setLayout(distribucio);
//        JLabel NomCategoriaTitol = new JLabel("Nom:");
//        JTextField NomCategoriaInput = new JTextField();
//        JLabel DescCategoriaTitol = new JLabel("Descripció:");
//        JTextField DescCategoriaInput = new JTextField();
//
//        JButton crearCategoria = new JButton("Crear");
//
//
//        JButton atras = new JButton("Tornar al gestor");
//        atras.addActionListener(e -> {
//            if (categoriaAEditar != null) {
//                this.MGestors.GCategoria.altaCategoria(categoriaAEditar.getNom(), categoriaAEditar.getDescripcio());
//                this.popUp("Cancelada la edició");
//            }
//            this.menuCategoria();
//
//        });
//
//
//        this.panel.add(NomCategoriaTitol);
//        this.panel.add(NomCategoriaInput);
//        this.panel.add(DescCategoriaTitol);
//        this.panel.add(DescCategoriaInput);
//        this.panel.add(crearCategoria);
//        this.panel.add(atras);
//        if (categoriaAEditar != null) {
//            crearCategoria.setText("Guardar Canvis");
//            crearCategoria.addActionListener(e -> {
//                if (NomCategoriaInput.getText().isBlank() || DescCategoriaInput.getText().isBlank()) {
//                    this.popUp("Error al crear la categoria, emplena tots els camps.");
//
//                } else {
//                    if (!this.MGestors.GCategoria.eliminarCategoria(categoriaAEditar.getId())) {
//                        this.menuCategoria();
//                        this.popUp("Ha sorgit un error al editar la categoria");
//                        return;
//                    }
//                    if (this.MGestors.GCategoria.altaCategoria(NomCategoriaInput.getText(), DescCategoriaInput.getText())) {
//                        this.menuCategoria();
//                        this.popUp("Categoria " + NomCategoriaInput.getText() + " editada " + "correctament.");
//
//                    } else {
//                        this.popUp("Error al crear la categoria.\n(No es poden repetir noms de categories)");
//                    }
//                }
//            });
//            NomCategoriaInput.setText(categoriaAEditar.getNom());
//            DescCategoriaInput.setText(categoriaAEditar.getDescripcio());
//            JButton descartar = new JButton("Descartar Canvis");
//            descartar.addActionListener(e -> this.menuCategoria());
//            this.panel.add(descartar);
//            JButton eliminar = new JButton("Eliminar Categoria");
//            eliminar.addActionListener(e -> {
//                if (this.MGestors.GCategoria.eliminarCategoria(categoriaAEditar.getId())) {
//                    this.menuCategoria();
//                    this.popUp("Categoria " + categoriaAEditar.getNom() + " eliminada correctament.");
//                } else {
//                    this.popUp("Ha sorgit un error al eliminar la categoria");
//                    this.menuCategoria();
//                }
//            });
//            this.panel.add(eliminar);
//        } else {
//            crearCategoria.addActionListener(e -> {
//                if (NomCategoriaInput.getText().isBlank() || DescCategoriaInput.getText().isBlank()) {
//                    this.popUp("Error al crear la categoria, emplena tots els camps.");
//
//                } else {
//                    if (this.MGestors.GCategoria.altaCategoria(NomCategoriaInput.getText(), DescCategoriaInput.getText())) {
//                        this.menuCategoria();
//                        this.popUp("Categoria " + NomCategoriaInput.getText() + " creada " + "correctament.");
//
//                    } else {
//                        this.popUp("Error al crear la categoria.\n(No es poden repetir noms de categories)");
//                    }
//                }
//            });
//        }
//        this.finestra.changePanel(this.panel);
//
//    }
//
//    /**
//     * Aquest mètode crea un popUp(finestra emergent) que no esta relacionada amb this.finestra i s'utilitza per el menu de exportar importar
//     */
//    private void importExportPopUp() {
//        Sprint4Java.views.Finestra popUp = new Sprint4Java.views.Finestra(300, 450, "Informació", null);
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
//
//    /**
//     * Aquest mètode crea un popUp(finestra emergent) que no esta relacionada amb this.finestra i sol utilitzar-se per mostrar informació
//     *
//     * @param message Missatge string per mostrar al mitj de la finestra
//     */
//    private void popUp(String message) {
//        JOptionPane.showMessageDialog(this.finestra, message, "Informació", JOptionPane.INFORMATION_MESSAGE);
////        __________________________________
////                JOptionPane Manual
////        Finestra popUp = new Finestra(200, 400, "Informació");
////        JPanel panelPopUp = new JPanel();
////        panelPopUp.setLayout(new GridLayout(2, 1));
////        JLabel msgLabel = new JLabel(message);
////        JButton continueButton = new JButton("OK");
////        continueButton.addActionListener(e -> popUp.dispose());
////        panelPopUp.add(msgLabel);
////        panelPopUp.add(continueButton);
////        popUp.changePanel(panelPopUp);
//    }
//
//
//}
