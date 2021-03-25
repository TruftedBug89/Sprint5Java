package Sprint5Java.controllers;

import Sprint5Java.logManager.Log;

import java.sql.*;
import java.util.HashMap;

public class ControllerProfessor {
    private Connection connexioBD;
    private int contadorProfessors = 0;
    public ControllerProfessor(HashMap<String, String> dbParam){
        try {
            this.connexioBD = DriverManager.getConnection("jdbc:mysql://localhost/" + dbParam.get("db.database"), dbParam.get("db.user"), dbParam.get("db.password"));
            Statement sentencia = this.connexioBD.createStatement();
            ResultSet resultado = sentencia.executeQuery("select * from profesors, usuarios where usuarios.id = professors.id_usuari");
            while (resultado.next()) {
                this.contadorProfessors++;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            Log.log("Error al connectar a la BD desde les dades de config", "ControllerProfessor");
        }

    }
}
