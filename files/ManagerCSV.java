package Sprint4Java.files;

import Sprint4Java.logManager.Error;
import Sprint4Java.logManager.Log;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
/**
 * Grup 1 Sprint 4 2020-2021 - Alberto Dos Santos
 * Aquesta clase gestiona l'exportacio i importacio d'arxius CSV
 */
public class ManagerCSV {
    private static boolean idePath;//variable que li diu al programa si les rutes
    //- seran per a executar desde un ide o desde un jar
    private static final String csvPathLocation = "src/Sprint4Java/Exports";
    private static final String csvAlternativePath = "Exports";

    /**
     * Aquest mètode exporta un ArrayList a l'arxiu desitjat
     *
     * @param export Dades amb la linea de columna
     * @param family Tipus de dades que estem exportant: "categoria", "incidencia" etc..
     * @return retona true si es fa succesivament i false si no
     */
    public static boolean export(ArrayList<String[]> export, String family) {
        if (export.size() < 2) {
            Error.log("S'esta intentant exportar un arxiu amb dades buides", "ExportarCSV");
            return false;
        }
        for (String[] line : export) {
            exportCSV(line, family);
        }
        if (!createCSVFolder()) {
            Error.log("No s'ha pogut crear la carpeta per exportar els CSV", "exportCSV");
            return false;
        }
        return true;
    }

    /**
     * Aquest mètode crea una carpeta per emmagatzemar els CSV exportats si no hi es creada previament
     *
     * @return boolean true si ha pogut crear la carpeta i false si no ha pogut
     */
    public static boolean createCSVFolder() {
        if (new File(csvPathLocation).exists()) idePath = true;
        else idePath = false;
        File logFolder = new File((idePath) ? csvPathLocation : csvAlternativePath);
        if (!logFolder.exists()) {
            return logFolder.mkdir();
        }
        return true;
    }

    /**
     * Aquest mètode el crida export() per escriure linea per linea
     *
     * @param Dades  Array String[]
     * @param family apartat que venen les dades
     */
    private static void exportCSV(String[] Dades, String family) {

        if (new File(csvPathLocation).exists()) idePath = true;
        else idePath = false;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-hh-mm");
        Date date = new Date(System.currentTimeMillis());
        String exportCSVName = "/" + formatter.format(date) + "export" + family.trim() + ".csv";

        File csvOutputFile = new File(((idePath) ? csvPathLocation : csvAlternativePath) + exportCSVName);
        System.out.println("peta aixo a  k si");
        System.out.println(((idePath) ? csvPathLocation : csvAlternativePath) +" "+ exportCSVName);
        try {
            if (!csvOutputFile.createNewFile())
                Error.log("No s'ha pogut crear l'arxiu per exportar les dades", "ExportCSV");
            FileWriter fw = new FileWriter(csvOutputFile, true);
            BufferedWriter bw = new BufferedWriter(fw);

            Dades[Dades.length - 1] += "\n";
            for (int i = 0; i < Dades.length - 1; i++) {
                bw.write(Dades[i] + ",");
            }
            bw.write(Dades[Dades.length - 1]);
            bw.close();
            fw.close();
            Log.log("CSV Exportat correctament", "ExportCSV");

        } catch (IOException e) {
            e.printStackTrace();
            Error.log("No s'ha pogut exportar el csv, error exportCSV()", "exportcsv");
        }
    }

    /**
     * Aquest mètode surt un pop up per el·legir l'arxiu per importar i retorna l'arrry
     *
     * @return ArrayList amb les dades importades
     */
    public static ArrayList<String> importCSV() {
        if (new File(csvPathLocation).exists()) idePath = true;
        else idePath = false;

        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File((idePath) ? csvPathLocation : csvAlternativePath));
//chooser.setCurrentDirectory(new File("src/"));
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "CSV Data files", "csv");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(null);
        ArrayList<String> importData = new ArrayList<>();
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            try {
                BufferedReader br = Files.newBufferedReader(Path.of(chooser.getSelectedFile().getAbsolutePath()), StandardCharsets.US_ASCII);
                while (true) {
                    String line = br.readLine();
                    if (line == null) break;
                    importData.add(line);
                }

            } catch (IOException e) {
                e.printStackTrace();
                Error.log("Error al importar l'arxiu CSV", "importCSV");
            }
            Log.log("S'ha importat l'arxiu " + chooser.getSelectedFile().getName(), "importCSV");
            return importData;
        }
        return null;
    }

}
