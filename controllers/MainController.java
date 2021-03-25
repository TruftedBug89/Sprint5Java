package Sprint5Java.controllers;

import java.util.HashMap;

public class MainController {

    public ControllerMatricula CMatricula;
    public ControllerProfessor controllerProfessor;

    public MainController(HashMap<String, String> confLoadedDB) {
        this.CMatricula = new ControllerMatricula(confLoadedDB);
        this.controllerProfessor = new ControllerProfessor(confLoadedDB);
    }
}
