package Sprint4Java.views;

import Sprint4Java.modules.ModulsGestors;

import javax.swing.*;
import java.awt.*;

/**
 * Grup 1 Sprint 4 2020-2021 - Isaac Brull, Josep López, Andrei Halauca, Alberto Dos Santos
 * Classe que s'esten de JPanel per a formar el menu del programa
 */
public class PanelMenu extends JPanel {
    Finestra finestra;
    ModulsGestors MGestors;

    /**
     * Constructor per a crear un menu
     * @param frame Marcar-li a quina finestra te que aplicar el menu
     * @param MGestors
     */
    public PanelMenu(Finestra frame, ModulsGestors MGestors) {
        this.finestra = frame;
        this.MGestors = MGestors;
        this.generarMenu();
    }

    /**
     * Generar Menu crea un JPanel i l'aplica a la finestra, aquest JPanel és un menu general de la nostra aplicació i conte diferents variables hardcoded
     */
    public void generarMenu() {

        GridLayout distribucio = new GridLayout(5, 1);
        this.setLayout(distribucio);
        JButton panelCategoria = new JButton("Gestio de Categories");
        panelCategoria.addActionListener(e -> new PanelCategoria(this.finestra,MGestors));
        JButton panelEmpresa = new JButton("Gestio d'Empreses");
        panelEmpresa.addActionListener(e -> new PanelEmpresa(this.finestra,MGestors));
        JButton panelIncidencia = new JButton("Gestio d'Incidencies");
        panelIncidencia.addActionListener(e -> new PanelIncidencia(this.finestra,MGestors));
        JButton panelInstitut = new JButton("Gestió d'instituts");
        panelInstitut.addActionListener(e -> new PanelInstitut(this.finestra,MGestors));
        JButton exit = new JButton("Sortir");
        exit.addActionListener(e -> this.finestra.dispose());
        this.add(panelCategoria);
        this.add(panelEmpresa);
        this.add(panelIncidencia);
        this.add(panelInstitut);
        this.add(exit);
        this.finestra.changePanel(this);

    }
}
