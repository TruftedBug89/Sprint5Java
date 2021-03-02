package Sprint5Java.controllers;

import java.util.HashMap;

public class MainController {

    public ControllerMatricula GMatricula;


    public MainController(HashMap<String, String> confLoadedDB) {
        this.GMatricula = new ControllerMatricula(confLoadedDB);
    }
}
