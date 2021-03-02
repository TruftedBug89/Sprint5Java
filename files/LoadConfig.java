package Sprint4Java.files;

import Sprint4Java.logManager.Error;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class LoadConfig {
    private static boolean idePath;//variable que li diu al programa si les rutes
    //- seran per a executar desde un ide o desde un jar
    private static final String cfgPathLocation = "src/Sprint4Java/config.cfg";
    private static final String cfgAlternativePath = "config.cfg";

    /**
     * Mètode que carrega la informacio del arxiu .cfg
     *
     * @return retorna un arraylist amb les dades carregades
     */
    public static String[] loadConfig() {
        if ( new File(cfgPathLocation).exists() ) idePath = true;
        ArrayList<String> savedConfig = new ArrayList<>();
        try {
            BufferedReader br = Files.newBufferedReader(Path.of((idePath) ? cfgPathLocation : cfgAlternativePath), StandardCharsets.US_ASCII);
            while (true) {
                String line = br.readLine();
                if ( line == null ) break;
                savedConfig.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
            Error.log("No s'ha pogut trobar l'arxiu de configuració i/o ha sorgit un error durant l'inici", "configLoad");
            return null;
        }
        int staticSize = savedConfig.size() - 1;
        for (int i = 0; i < staticSize; i++) {
            String[] lines = savedConfig.get(i).split("=");
            savedConfig.add(lines[1]);
            savedConfig.remove(0);
        }
        return savedConfig.toArray(new String[savedConfig.size()]);

    }
}
