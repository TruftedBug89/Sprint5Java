package Sprint5Java.controllers;

import Sprint5Java.logManager.Log;
import Sprint5Java.models.Alumne;

import java.sql.*;
import java.util.HashMap;

public class ControllerAlumne {
    private Connection connexioBD;
    private int contadorAlumnes = 0;
    public ControllerAlumne(HashMap<String, String> confLoadedDB) {
        try {
            this.connexioBD = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + confLoadedDB.get("db.database"), confLoadedDB.get("db.user"), confLoadedDB.get("db.password"));
            Statement sentencia = this.connexioBD.createStatement();

            ResultSet resultado = sentencia.executeQuery("select * from alumnos, usuarios where usuarios.id = alumnos.id_usuari and usuarios.estat = 'actiu'");

            while (resultado.next()) {
                this.contadorAlumnes++;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            Log.log("Error al connectar a la BD desde les dades de config", "ControllerAlumne");
        }

    }

    public boolean altaAlumne(Alumne Alumne){
        try{
            Statement sql = this.connexioBD.createStatement();
            PreparedStatement psInsertar = this.connexioBD.prepareStatement("INSERT INTO users (id_roles, nom, cognom, segon_cognom, dni, user_name, password, ruta_avatar, email, telefon, data_naixement, estat) " +
                    "VALUES (5, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?)");
            psInsertar.setString(1,Alumne.getNom());
            psInsertar.setString(2,"El Khattabi");
            psInsertar.setString(3,"Gatai");
            psInsertar.setString(4,Alumne.getDni());
            psInsertar.setString(5,"anwarekg");
            psInsertar.setString(6,"anwarekg");
            psInsertar.setString(7,"default.jpg");
            psInsertar.setString(8,"joelferragut");
            psInsertar.setString(9,"684071540");
            psInsertar.setString(10,"1995-09-12");
            psInsertar.setString(11,"actiu");
            psInsertar.executeUpdate();

            System.out.println("S'ha registrar l'alumne correctament");
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
            Log.log("Error al donar d'alta un alumne", "ControllerAlumne");
            return false;
        }
    }

    public String[][] dadesAlumne() {
        int numberOfFields = 4;
        String[][] tableData = new String[this.contadorAlumnes][numberOfFields];
        try {
            Statement sentencia = this.connexioBD.createStatement();

            ResultSet resultado = sentencia.executeQuery("select usuarios.id,usuarios.nom, usuarios.dni, alumnos.codi_Alumne " +
                    "from usuarios, alumnos where usuarios.id = alumnos.id_usuari AND usuarios.id_roles = 5 AND usuarios.estat = 'actiu'");

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

    public void modificarAlumne(Integer id, String nom, String dni, String codi){
        try {
            String[] alumne = {nom,dni};
            Statement sentencia = this.connexioBD.createStatement();
            PreparedStatement stmt;
            stmt = this.connexioBD.prepareStatement("UPDATE usuarios SET nom=?, dni=? WHERE id=?");
            for (Integer i = 0; i < alumne.length; i++){
                stmt.setString(i+1,alumne[i]);
            }
            stmt.setString(3,Integer.toString(id));
            stmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }


    }

    public String[] exportAlumne(){
        String[] export;
        try {
            int numberOfFields = 4;
            Statement sentencia = this.connexioBD.createStatement();

            ResultSet resultado = sentencia.executeQuery("select usuarios.id,usuarios.nom, usuarios.dni, alumnos.codi_Alumne " +
                    "from usuarios, alumnos where usuarios.id = alumnos.id_usuari AND usuarios.id_roles = 5");

            export = new String[this.contadorAlumnes];
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
