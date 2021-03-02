package Sprint5Java.files;

import Sprint5Java.logManager.Error;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;

public class LoadConfig {
    //- seran per a executar desde un ide o desde un jar
    private static final String cfgPathLocation = "src/Sprint5Java/config.cfg";
    private static final String cfgAlternativePath = "config.cfg";
    private static boolean idePath;//variable que li diu al programa si les rutes

    /**
     * Mètode que carrega la informacio del arxiu .cfg
     *
     * @return retorna un arraylist amb les dades carregades
     */
    public static HashMap<String, String> loadConfig() {
        if (new File(cfgPathLocation).exists()) idePath = true;
        ArrayList<String> savedConfig = new ArrayList<>();
        try {
            BufferedReader br = Files.newBufferedReader(Path.of((idePath) ? cfgPathLocation : cfgAlternativePath), StandardCharsets.US_ASCII);
            while (true) {
                String line = br.readLine();
                if (line == null) break;
                savedConfig.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();

            Error.log("No s'ha pogut trobar l'arxiu de configuració i/o ha sorgit un error durant l'inici", "configLoad");
            return null;
        }
        HashMap<String, String> configHash = new HashMap<>();
        for (int i = 0; i < savedConfig.size(); i++) {
            configHash.put(savedConfig.get(i).split("=")[0].replace("\"", "").trim(), savedConfig.get(i).split("=")[1].replace("\"", "").trim());
        }
        return configHash;

    }
}
