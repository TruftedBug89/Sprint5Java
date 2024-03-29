package Sprint5Java.logManager;

import Sprint5Java.files.LogFiles;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * Grup 2 Sprint 5 2020-2021 - Alberto Dos Santos
 * Aquesta classe crea els logs i els guarda al arxiu una vegada s'ha cridat el mètode
 */
public class Error {
    /**
     * Crea els logs i els guarda al arxiu una vegada s'ha cridat el mètode
     * @param rawText Text d'informacio sobre el LOG
     * @param action  Paraula clau sobre l'operacio que s'esta fent
     */
    public static void log(String rawText, String action){
        rawText = rawText.toUpperCase();
        action = action.toUpperCase();
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        String toWrite = "###- "+action+" -###- "+rawText+" ##-- "+formatter.format(date);
        try {
            LogFiles.writeError(toWrite);
        } catch (IOException e) {
            e.printStackTrace();//SI PETA AIXO YA VAMOS TIRA PA CASA
        }
    }
}
