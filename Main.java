package Sprint5Java;

import Sprint5Java.files.LoadConfig;
import Sprint5Java.controllers.*;
import Sprint5Java.views.Finestra;
import Sprint5Java.views.PanelMenu;

import java.util.HashMap;

/**
 * Grup 2 Sprint 5 2020-2021 - David Falcó, Anwar El Khattabi, Sofian Didouh, Alberto Dos Santos
 */

public class Main {
    static final int AMPLADA = 400;
    static final int ALTURA = 400;
    static final String NOM_FINESTRA = "Sprint2Java";

    /**
     * Main que crea els objectes essencials per a correr el programa
     *
     * @param args
     */
    public static void main(String[] args) {
        HashMap<String,String> loadedConfig = LoadConfig.loadConfig();
        MainController MainController = new MainController(loadedConfig);
        Finestra frame = new Finestra(ALTURA, AMPLADA, NOM_FINESTRA, loadedConfig);
        PanelMenu menu = new PanelMenu(frame, MainController);//la classe s'encarrega de posar el panel al frame

    }

}

