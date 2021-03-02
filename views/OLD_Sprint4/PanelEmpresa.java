//package Sprint5Java.views.OLD_Sprint4;
//
//import Sprint4Java.files.ManagerCSV;
//import Sprint4Java.logManager.Error;
//import Sprint4Java.logManager.Log;
//import Sprint4Java.modules.ModulsGestors;
//import java.io.*;
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.MouseAdapter;
//import java.awt.event.MouseEvent;
//import java.nio.charset.StandardCharsets;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.util.ArrayList;
//
///**
// * Grup 2 Sprint 5 2020-2021 - Josep López
// * Classe PanelEmpresa, Gestiona els panels del Crud Empresa
// */
//public class PanelEmpresa {
//    Sprint4Java.views.Finestra finestra;
//    JPanel panel;
//    ModulsGestors MGestors;
//
//
//    /**
//     * Constructor Per als Panels de Empresa
//     *
//     * @param finestra
//     * @param MGestors
//     */
//    public PanelEmpresa(Sprint4Java.views.Finestra finestra, ModulsGestors MGestors) {
//        this.finestra = finestra;
//        this.MGestors = MGestors;
//        this.menuEmpresa();
//    }
//
//    /**
//     * Panel menú per a les opcions del crud de Empresa
//     */
//    public void menuEmpresa() {
//        this.panel = new JPanel();
//        GridLayout distribucio = new GridLayout(6, 1, 2, 2);
//        Color colorfondo = new Color(87, 173, 73);
//        this.panel.setLayout(distribucio);
//        this.panel.setBackground(colorfondo);
//
//        JLabel titol = new JLabel("Empreses:");
//
//        JList<String> llistaEmpresa = new JList<>(this.MGestors.GEmpresa.llistarEmpreses());
//        llistaEmpresa.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
//        JScrollPane scrollPane = new JScrollPane(llistaEmpresa);
//        llistaEmpresa.setVisibleRowCount(2);
//        llistaEmpresa.setLayoutOrientation(JList.VERTICAL);
//        PanelEmpresa guardar = this;
//        llistaEmpresa.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                if (e.getClickCount() == 2) {
//                    Empresa empresaaAEditar = guardar.MGestors.GEmpresa.getEmpresaByName((llistaEmpresa.getSelectedValue()).substring(5));
//                    guardar.altaEmpresa(empresaaAEditar);
//
//                }
//            }
//        });
//        JButton crear = new JButton("Crear Empresa");
//        crear.addActionListener(e -> this.altaEmpresa(null));
//
//
//        JButton importar = new JButton("Importar csv");
//        importar.addActionListener(e -> this.importarEmpreses());
//        JButton exportar = new JButton("Exportar csv");
//        exportar.addActionListener(e -> this.exportarEmpresa());
//        JButton exit = new JButton("Tornar al Menú");
//        exit.addActionListener(e -> new PanelMenu(this.finestra, MGestors));
//        this.panel.add(titol);
//        this.panel.add(scrollPane);
//        this.panel.add(crear);
//        this.panel.add(importar);
//        this.panel.add(exportar);
//        this.panel.add(exit);
//        this.finestra.changePanel(this.panel);
//    }
//
//
//    /**
//     * Aplica un panel que conte components per afegir una Empresa
//     *
//     * @param EmpresaAEditar aquest parametre serveix per editar una Empresa, enviar null si s'esta creant un Empresa
//     */
//    public void altaEmpresa(Empresa EmpresaAEditar) {
//        this.panel = new JPanel();
//        GridLayout distribucio = new GridLayout((EmpresaAEditar != null) ? 7 : 6, 2, 2, 2);
//
//        Color colorfondo = new Color((EmpresaAEditar != null) ? 23 : 245,207,141);
//        this.panel.setLayout(distribucio);
//        this.panel.setBackground(colorfondo);
//
//        JLabel NomEmpresaTitol = new JLabel("Nom:");
//        JTextField NomEmpresaInput = new JTextField();
//        JLabel TelEmpresaTitol = new JLabel("Telefon:");
//        JTextField TelEmpresaInput = new JTextField();
//        JLabel EmEmpresaTitol = new JLabel("Email:");
//        JTextField EmEmpresaInput = new JTextField();
//        JLabel LocEmpresaTitol = new JLabel("Localitat:");
//        JTextField LocEmpresaInput = new JTextField();
//        JLabel AdrEmpresaTitol = new JLabel("Adreça:");
//        JTextField AdrEmpresaInput = new JTextField();
//
//        JButton altaEmpresa = new JButton("Crear");
//        JButton atras = new JButton("Tornar al gestor");
//        atras.addActionListener(e -> {
//            if (EmpresaAEditar != null) {
//                this.MGestors.GEmpresa.altaEmpresa(EmpresaAEditar.getNom(), EmpresaAEditar.getTelefon(), EmpresaAEditar.getEmail(), EmpresaAEditar.getLocalitat(), EmpresaAEditar.getAdresa());
//                this.popUp("Cancelada la edició");
//            }
//            this.menuEmpresa();
//        });
//
//        this.panel.add(NomEmpresaTitol);
//        this.panel.add(NomEmpresaInput);
//        this.panel.add(TelEmpresaTitol);
//        this.panel.add(TelEmpresaInput);
//        this.panel.add(EmEmpresaTitol);
//        this.panel.add(EmEmpresaInput);
//        this.panel.add(LocEmpresaTitol);
//        this.panel.add(LocEmpresaInput);
//        this.panel.add(AdrEmpresaTitol);
//        this.panel.add(AdrEmpresaInput);
//        this.panel.add(altaEmpresa);
//        this.panel.add(atras);
//        if (EmpresaAEditar != null) {
//            altaEmpresa.setText("Guardar Canvis");
//            altaEmpresa.addActionListener(e -> {
//                if (NomEmpresaInput.getText().isBlank() || TelEmpresaInput.getText().isBlank() || EmEmpresaInput.getText().isBlank() || LocEmpresaInput.getText().isBlank() || AdrEmpresaInput.getText().isBlank()) {
//                    this.popUp("Error al crear l'empresa, emplena tots els camps.");
//
//                } else {
//                    if (!this.MGestors.GEmpresa.eliminarEmpresa(EmpresaAEditar.getId())) {
//                        this.menuEmpresa();
//                        this.popUp("Ha sorgit un error al editar l'empresa");
//                        return;
//                    }
//                    if (this.MGestors.GEmpresa.altaEmpresa(NomEmpresaInput.getText(), TelEmpresaInput.getText(), EmEmpresaInput.getText(), LocEmpresaInput.getText(), AdrEmpresaInput.getText() )) {
//                        this.menuEmpresa();
//                        this.popUp("Empresa " + NomEmpresaInput.getText() + " editada " + "correctament.");
//
//                    } else {
//                        this.popUp("Error al crear l'empresa.\n(No es poden repetir noms d'empreses)");
//                    }
//                }
//            });
//            NomEmpresaInput.setText(EmpresaAEditar.getNom());
//            TelEmpresaInput.setText(EmpresaAEditar.getTelefon());
//            EmEmpresaInput.setText(EmpresaAEditar.getEmail());
//            LocEmpresaInput.setText(EmpresaAEditar.getLocalitat());
//            AdrEmpresaInput.setText(EmpresaAEditar.getAdresa());
//
//            JButton descartar = new JButton("Descartar Canvis");
//            descartar.addActionListener(e -> this.menuEmpresa());
//            this.panel.add(descartar);
//            JButton eliminar = new JButton("Eliminar Empresa");
//            eliminar.addActionListener(e -> {
//                if (this.MGestors.GEmpresa.eliminarEmpresa(EmpresaAEditar.getId())) {
//                    this.menuEmpresa();
//                    this.popUp("Empresa " + EmpresaAEditar.getNom() + " eliminada correctament.");
//                } else {
//                    this.popUp("Ha sorgit un error al eliminar l'empresa");
//                    this.menuEmpresa();
//                }
//            });
//            this.panel.add(eliminar);
//        } else {
//            altaEmpresa.addActionListener(e -> {
//                if (NomEmpresaInput.getText().isBlank() || TelEmpresaInput.getText().isBlank() || EmEmpresaInput.getText().isBlank() || LocEmpresaInput.getText().isBlank() || AdrEmpresaInput.getText().isBlank()) {
//                    this.popUp("Error al crear l'empresa, emplena tots els camps.");
//
//                } else {
//                    if (this.MGestors.GEmpresa.altaEmpresa(NomEmpresaInput.getText(), TelEmpresaInput.getText(), EmEmpresaInput.getText(), LocEmpresaInput.getText(), AdrEmpresaInput.getText() )) {
//                        this.menuEmpresa();
//                        this.popUp("Empresa " + NomEmpresaInput.getText() + " creada " + "correctament.");
//
//                    } else {
//                        this.popUp("Error al crear l'empresa.\n(No es poden repetir noms d'empreses)");
//                    }
//                }
//            });
//        }
//        this.finestra.changePanel(this.panel);
//    }
//
//    /**
//     * Aquest mètode crea un popUp(finestra emergent) que no esta relacionada amb this.finestra i sol utilitzar-se per mostrar informació
//     *
//     * @param message Missatge string per mostrar al mitj de la finestra
//     */
//    private void popUp(String message) {
//        JOptionPane.showMessageDialog(this.finestra, message, "Informació", JOptionPane.INFORMATION_MESSAGE);
//    }
//
//
//    /**
//     * Aquest mètode surt un pop up per triar un arxiu per importar
//     *
//     */
//
//    public void importarEmpreses(){
//        JFileChooser arxiuSel = new JFileChooser(".");
//        int estat = arxiuSel.showOpenDialog(null); //fileChooser
//        ArrayList<String> importData = new ArrayList<>();
//
//        if (estat == JFileChooser.APPROVE_OPTION) {
//
//            try {
//                BufferedReader br = Files.newBufferedReader(Path.of(arxiuSel.getSelectedFile().getAbsolutePath()), StandardCharsets.US_ASCII);
//                while (true) {
//                    String line = br.readLine();
//                    if (line == null) break;
//                    importData.add(line);
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//                Error.log("Error al importar l'arxiu CSV", "importarEmpreses");
//            }
//            Log.log("S'ha importat l'arxiu ", "importarEmpreses");
//        }
//        if (importData == null) return;
//        importData.remove(0);
//        int empresesImportades = 0;
//        for (String dada : importData) {
//            empresesImportades++;
//            String[] data = dada.split(",");
//            if (data.length < 3) continue;
//            this.MGestors.GEmpresa.altaEmpresa(data[1], data[2], data[3], data[4], data[5]);
//        }
//        this.popUp("Importades " + empresesImportades + " empreses.");
//        Log.log("Importades " + empresesImportades + " empreses.", "importarEmpreses");
//
//    }
//    public void exportarEmpresa(){
//        ArrayList<String[]> export = new ArrayList<>();
//
//        String[] columnes = {"ID", "NOM", "Localitat", "Telefon", "Email", "Adreça"};
//        export.add(columnes);
//        for (Empresa cat : this.MGestors.GEmpresa.getArray()) {
//            String[] i = {String.valueOf(cat.getId()), cat.getNom(), cat.getLocalitat(),cat.getTelefon(),cat.getEmail(), cat.getAdresa()};
//            export.add(i);
//        }
//        if (ManagerCSV.export(export, "Empresa")) {
//            this.popUp("S'ha exportat Correctament");
//            Log.log("S'han exportat les empreses correctament", "exportarEmpresa");
//        } else {
//            this.popUp("Error al exportar, array buit");
//            Error.log("Error al exportar empreses, array buit", "exportarEmpresa");
//        }
//
//    }
//
//}
