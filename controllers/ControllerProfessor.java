package Sprint5Java.controllers;

import Sprint5Java.logManager.*;
import Sprint5Java.models.Professor;

import javax.swing.*;
import java.sql.*;
import java.util.HashMap;

public class ControllerProfessor {
    private Connection connexioBD;
    private int contadorProfessors = 0;
    public ControllerProfessor(HashMap<String, String> confLoadedDB) {
        try {
            this.connexioBD = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + confLoadedDB.get("db.database"), confLoadedDB.get("db.user"), confLoadedDB.get("db.password"));
            Statement sentencia = this.connexioBD.createStatement();
            ResultSet resultado = sentencia.executeQuery("select * from users where users.estat = 'actiu'");
            while (resultado.next()) {
                this.contadorProfessors++;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            Log.log("Error al connectar a la BD desde les dades de config", "ControllerProfessor");
        }

    }


    public boolean altaProfessor(Professor professor){
        try{
            if(professor.getNom().length() > 0 && professor.getDni().length() > 0){
                Statement sql = this.connexioBD.createStatement();
                PreparedStatement psInsertar = this.connexioBD.prepareStatement("INSERT INTO users (id_roles, nom, cognom, segon_cognom, dni, user_name, password, ruta_avatar, email, telefon, data_naixement, estat) " +
                        "VALUES (5, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?)");
                psInsertar.setString(1,professor.getNom());
                psInsertar.setString(2,"Ferragut");
                psInsertar.setString(3,"Garcia");
                psInsertar.setString(4,professor.getDni());
                psInsertar.setString(5,"joelferragut");
                psInsertar.setString(6,"joelferragut");
                psInsertar.setString(7,"default.jpg");
                psInsertar.setString(8,"joelferragut");
                psInsertar.setString(9,"693859056");
                psInsertar.setString(10,"1999-03-14");
                psInsertar.setString(11,"actiu");
                psInsertar.executeUpdate();
                System.out.println("S'ha creat profe");
                Log.log("Creat un professor", "ControllerProfessor");
                return true;
            }
            else {
                Sprint5Java.logManager.Error.log("Error al crear professor. Camps buits", "ControllerProfessor");
                return false;
            }

        }
        catch (Exception e){
            e.printStackTrace();
            Sprint5Java.logManager.Error.log("Error al donar d'alta un professor. No s'ha pogut accedir a la base de dades", "ControllerProfessor");
            return false;
        }
    }

    public String[][] dadesProfessor() {
        int numberOfFields = 3;
        String[][] tableData = new String[this.contadorProfessors][numberOfFields];
        try {
            Statement sentencia = this.connexioBD.createStatement();
            ResultSet resultado = sentencia.executeQuery("select users.id,users.nom, users.dni " +
                    "from users where users.id_roles = 5 AND users.estat = 'actiu'");

            int tableCounter = 0;
            while (resultado.next()) {
                for (int i = 0; i < numberOfFields; i++) {
                    tableData[tableCounter][i] = resultado.getString(i + 1);//+1 perque el getString(int) comença desde 1 i no desde 0
                }
                tableCounter++;
            }
            return tableData;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return tableData;
        }
    }

    public void modificarProfessor(Integer id, String nom, String dni, String codi){
        try {
            String[] profe = {nom,dni};
            Statement sentencia = this.connexioBD.createStatement();
            PreparedStatement stmt;
            stmt = this.connexioBD.prepareStatement("UPDATE users SET nom=?, dni=? WHERE id=?");
            for (Integer i = 0; i < profe.length; i++){
                stmt.setString(i+1,profe[i]);
            }
            stmt.setString(3,Integer.toString(id));
            stmt.executeUpdate();
            Log.log("Professors modificat", "ControllerProfessor");
        }catch (SQLException e){
            Sprint5Java.logManager.Error.log("Error al modificar professor. No s'ha pogut connectar a la base de dades.", "ControllerProfessor");
            e.printStackTrace();
        }


    }

    public boolean eliminarProfessor(Integer id) {
        try{
            Statement sentencia = this.connexioBD.createStatement();
            String sql = "UPDATE users set estat='inactiu' where id = "+id;
            int resultat = sentencia.executeUpdate(sql);
            if (resultat <1){
                Sprint5Java.logManager.Error.log("Error a l'eliminar el professor amb id-> "+id,"ControllerProfessor");
               return false;
            }
            else {
                Log.log("Eliminat el professor-> "+id,"ControllerProfessor");
                return true;
            }
        }
        catch (SQLException e){
            Sprint5Java.logManager.Error.log("Error al connectar-se a la base de dades","ControllerProfessor");
            e.printStackTrace();
            return false;
        }
    }

    public String[] exportProfessor(){
        String[] export;
        try {
            int numberOfFields = 4;
            Statement sentencia = this.connexioBD.createStatement();
            ResultSet resultado = sentencia.executeQuery("select users.id, users.nom, users.dni," +
                    "from users where users.id_roles = 5");

            export = new String[this.contadorProfessors];
            while (resultado.next()) {
                for (int i = 0; i < numberOfFields; i++) {
                    export[i] = resultado.getString(i + 1);//+1 perque el getString(int) comença desde 1 i no desde 0
                }
            }
            return export;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            export = new String[1];
            return export;
        }

    }
}
