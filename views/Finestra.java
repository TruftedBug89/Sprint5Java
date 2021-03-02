package Sprint4Java.views;

import javax.swing.*;

/**
 * Grup 1 Sprint 4 2020-2021 - Isaac Brull, Josep López, Andrei Halauca, Alberto Dos Santos
 * Clase Finestra: Administra JFrame i conte mètodes per autoconfigurar-lo i canviar panels
 */
public class Finestra extends JFrame {

    private final int finestraHeight;
    private final int finestraWidth;
    private final String finestraName;

    /**
     * Constructor principal
     *
     * @param altura       altura en pixels
     * @param amplada      amplada en pixels
     * @param nomFinestra  String nom que surtira a la part superior de la finestra
     * @param loadedConfig aquestes dades es sobreescriuen si hi hes el fitxer de configuracio ple
     */
    public Finestra(int altura, int amplada, String nomFinestra, String[] loadedConfig) {
        this.finestraHeight = (loadedConfig == null) ? altura : Integer.parseInt(loadedConfig[1].split("x")[0].replace("\"", "").trim());
        this.finestraWidth = (loadedConfig == null) ? amplada : Integer.parseInt(loadedConfig[1].split("x")[1].replace("\"", "").trim());
        this.finestraName = (loadedConfig == null) ? nomFinestra : loadedConfig[0].split("=")[1].replace("\"", "").trim();
        this.configFrame();
    }

    /**
     * Aquest mètode configura la finestra amb diferent parametres
     */
    public void configFrame() {
        this.setSize(this.finestraWidth, this.finestraHeight);
        this.setTitle(this.finestraName);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

    }

    /**
     * Aquest mètode serveix per canviar els panels del JFrame, agafant el Panel com a argument
     *
     * @param panel objecte tipus JPanel que s'aplicara
     */
    public void changePanel(JPanel panel) {
        this.setContentPane(panel);
        this.repaint();
        this.setVisible(true);
        this.setFocusable(true);
        this.requestFocus();

    }

}
