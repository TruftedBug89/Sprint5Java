package Sprint4Java.files;

import Sprint4Java.logManager.Error;

import java.io.*;

/**
 * Grup 1 Sprint 4 2020-2021 - Alberto Dos Santos
 * Classe que gestiona l'escriptura i lectura dels fitxers de Logs
 */
public class LogFiles {
    private static boolean idePath;//variable que li diu al programa si les rutes
    //- seran per a executar desde un ide o desde un jar
    private static final String logFileName = "/logs.txt";
    private static final String errorFileName = "/error.txt";
    private static final String logPathLocation = "src/Sprint4Java/Logs";
    private static final String logAlternativePath = "Logs";

    /**
     * Aquest mètode crea una carpeta per emmagatzemar els logs si no hi es creada previament
     */
    public static void createLogFolder() {
        if (new File(logPathLocation).exists()) idePath = true;
        File logFolder = new File(((idePath) ? logPathLocation : logAlternativePath));
        if (!logFolder.exists()) {
            if (!logFolder.mkdirs()) Error.log("No s'ha pogut crear la carpeta de logs", "createLogFolder");
        }
    }

    /**
     * Aquest mètode comprova si existeixen els arxius de logs ja creats
     *
     * @return true si esta creat i false si no esta
     */
    public static boolean existsLogFile() {
        return (new File(((idePath) ? logPathLocation : logAlternativePath) + logFileName).exists());
    }

    /**
     * Aquest mètode crea un arxiu de logs
     */
    public static boolean createLogFile() throws IOException {
        File logFile = new File(((idePath) ? logPathLocation : logAlternativePath) + logFileName);
        return logFile.createNewFile();
    }

    /**
     * Aquest mètode obre l'arxiu de logs i escriu la nova linea
     *
     * @param finalLine linea per escriure al log, final formatada
     */
    public static void writeLog(String finalLine) throws IOException {
        createLogFolder();
        if (!existsLogFile()) createLogFile();
        FileWriter fw = new FileWriter(new File(((idePath) ? logPathLocation : logAlternativePath) + logFileName), true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write("\n" + finalLine);
        bw.close();
        fw.close();
    }

    /**
     * Aquest mètode comprova si existeixen els arxius de logs d'errors ja creats
     *
     * @return true si esta creat i false si no esta
     */
    public static boolean existsErrorFile() {
        return (new File(((idePath) ? logPathLocation : logAlternativePath) + errorFileName).exists());
    }

    /**
     * Aquest mètode crea un arxiu de logs d'errors
     */
    public static boolean createErrorFile() throws IOException {
        File errorFile = new File(((idePath) ? logPathLocation : logAlternativePath) + errorFileName);
        return errorFile.createNewFile();
    }

    /**
     * Aquest mètode obre l'arxiu de logs d'errors i escriu la nova linea
     *
     * @param finalLine linea per escriure al log, final formatada
     */
    public static void writeError(String finalLine) throws IOException {
        createLogFolder();
        if (!existsErrorFile()) createErrorFile();
        FileWriter fw = new FileWriter(new File(((idePath) ? logPathLocation : logAlternativePath) + errorFileName), true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write("\n" + finalLine);
        bw.close();
        fw.close();
    }
}
