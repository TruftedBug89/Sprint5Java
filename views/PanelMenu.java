package Sprint5Java.views;

import Sprint5Java.controllers.MainController;

import javax.swing.*;
import java.awt.*;

/**
 * Grup 2 Sprint 5 2020-2021 - David Falcó, Anwar El Khattabi, Sofian Didouh, Alberto Dos Santos
 * Classe que s'esten de JPanel per a formar el menu del programa
 */
public class PanelMenu extends JPanel {
    Finestra finestra;
    MainController MainController;

    /**
     * Constructor per a crear un menu
     * @param frame Marcar-li a quina finestra te que aplicar el menu
     * @param MGestors
     */
    public PanelMenu(Finestra frame, MainController MGestors) {
        this.finestra = frame;
        this.MainController = MGestors;
        this.generarMenu();
    }

    /**
     * Generar Menu crea un JPanel i l'aplica a la finestra, aquest JPanel és un menu general de la nostra aplicació i conte diferents variables hardcoded
     */
    public void generarMenu() {

        GridLayout distribucio = new GridLayout(5, 1);
        this.setLayout(distribucio);
        JButton panelCategoria = new JButton("Gestio de Matricules");
        panelCategoria.addActionListener(e -> new PanelMatricula(this.finestra, MainController));
        JButton panelAlumne = new JButton("Gestio d'Alumnes");
        panelAlumne.addActionListener(e -> new PanelAlumne(this.finestra,MainController));
        JButton panelProfessor = new JButton("Gestio de Professors");
        panelProfessor.addActionListener(e -> new PanelProfessor(this.finestra,MainController));
        JButton panelInstitut = new JButton("Gestió de Grups");
//        panelInstitut.addActionListener(e -> new PanelInstitut(this.finestra,MGestors));
        JButton exit = new JButton("Sortir");
        exit.addActionListener(e -> this.finestra.dispose());
        this.add(panelCategoria);
        this.add(panelAlumne);
        this.add(panelProfessor);
        this.add(panelInstitut);
        this.add(exit);
        this.finestra.changePanel(this);

    }
}
