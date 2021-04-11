package Sprint5Java.controllers;

import java.util.HashMap;

public class MainController {

    public ControllerMatricula CMatricula;
    public ControllerProfessor CProfessor;
    public ControllerAlumne CAlumne;

    public MainController(HashMap<String, String> confLoadedDB) {
        this.CMatricula = new ControllerMatricula(confLoadedDB);
        this.CProfessor = new ControllerProfessor(confLoadedDB);
        this.CAlumne = new ControllerAlumne(confLoadedDB);
    }
}
