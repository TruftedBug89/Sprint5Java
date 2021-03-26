package Sprint5Java.controllers;

import Sprint5Java.logManager.Log;
import Sprint5Java.models.Professor;

import java.sql.*;
import java.util.HashMap;

public class ControllerProfessor {
    private Connection connexioBD;
    private int contadorProfessors = 0;
    public ControllerProfessor(HashMap<String, String> confLoadedDB) {
        try {
            this.connexioBD = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + confLoadedDB.get("db.database"), confLoadedDB.get("db.user"), confLoadedDB.get("db.password"));
            Statement sentencia = this.connexioBD.createStatement();
            ResultSet resultado = sentencia.executeQuery("select * from profesors, usuarios where usuarios.id = profesors.id_usuari");
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
            Statement sql = this.connexioBD.createStatement();
            PreparedStatement psInsertar = this.connexioBD.prepareStatement("INSERT INTO usuarios (id_roles, nom, cognom, segon_cognom, dni, user_name, password, ruta_avatar, email, telefon, data_naixement, estat) " +
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
            /*int resultat = sql.executeUpdate(
                    "INSERT INTO usuarios (id_roles, nom, cognom, segon_cognom, dni, user_name, password, ruta_avatar, email, telefon, data_naixement, estat) " +
                            "VALUES (5," + professor.getNom()+", Ferragut, Garcia,"+professor.getDni()+",joelferragut, $2y$10$OARgkagA5zjp4ReLNxy7je.Vo1OrnKQ/OcjGlpHxPob/5aAF7A4mi, default.jpg, joelferragut, 693859056, 1999-03-14, actiu)");*/
            System.out.println("S'ha creat profe");
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
            Log.log("Error al donar d'alta un professor", "ControllerProfessor");
            return false;
        }
    }

    public String[][] dadesProfessor() {
        int numberOfFields = 4;
        String[][] tableData = new String[this.contadorProfessors][numberOfFields];
        try {
            Statement sentencia = this.connexioBD.createStatement();
            ResultSet resultado = sentencia.executeQuery("select usuarios.id,usuarios.nom, usuarios.dni, profesors.codi_professor " +
                    "from usuarios, profesors where usuarios.id = profesors.id_usuari AND usuarios.id_roles = 5");

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
            String[] profe = {nom,dni,codi};
            Statement sentencia = this.connexioBD.createStatement();
            PreparedStatement stmt;
            stmt = this.connexioBD.prepareStatement("UPDATE usuarios SET nom=? WHERE id=?");
            for (Integer i = 1; i < 4; i++){
                stmt.setString(i,nom);


            }
            stmt.setString(4,Integer.toString(id));
            stmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }


    }
}