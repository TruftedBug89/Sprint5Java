package Sprint4Java;

import Sprint4Java.files.LoadConfig;
import Sprint4Java.modules.*;
import Sprint4Java.views.Finestra;
import Sprint4Java.views.PanelMenu;

/**
 * Grup 1 Sprint 4 2020-2021 - Isaac Brull, Josep López, Andrei Halauca, Alberto Dos Santos
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
        GestorCategoria GCategoria = new GestorCategoria();
        GestorEmpresa GEmpresa = new GestorEmpresa(10);
        GestorIncidencia GIncidencia = new GestorIncidencia(10);
        GestorInstitut GInstitut = new GestorInstitut(10);
        ModulsGestors MGestors = new ModulsGestors(GCategoria, GEmpresa, GIncidencia, GInstitut);
        Finestra frame = new Finestra(ALTURA, AMPLADA, NOM_FINESTRA, LoadConfig.loadConfig());
        PanelMenu menu = new PanelMenu(frame, MGestors);//la classe s'encarrega de posar el panel al frame


    }
}

