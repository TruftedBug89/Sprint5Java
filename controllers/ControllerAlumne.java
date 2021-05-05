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
<<<<<<< HEAD
            ResultSet resultado = sentencia.executeQuery("select * from alumnos, users where users.id = alumnos.user_id and users.estat = 'actiu'");
=======
            ResultSet resultado = sentencia.executeQuery("select * from alumnos, usuarios where usuarios.id = alumnos.id_usuari and usuarios.estat = 'actiu'");
>>>>>>> 8d3f99eae268e277e42e8696265afa2539e3411a
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
            psInsertar.setString(2,"Ferragut");
            psInsertar.setString(3,"Garcia");
            psInsertar.setString(4,Alumne.getDni());
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
                            "VALUES (5," + Alumne.getNom()+", Ferragut, Garcia,"+Alumne.getDni()+",joelferragut, $2y$10$OARgkagA5zjp4ReLNxy7je.Vo1OrnKQ/OcjGlpHxPob/5aAF7A4mi, default.jpg, joelferragut, 693859056, 1999-03-14, actiu)");*/
            System.out.println("S'ha creat l'alumne");
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
<<<<<<< HEAD
            ResultSet resultado = sentencia.executeQuery("select users.id,users.nom, users.dni, alumnos.id " +
                    "from users, alumnos where users.id = alumnos.user.id AND users.id_roles = 5 AND users.estat = 'actiu'");
=======
            ResultSet resultado = sentencia.executeQuery("select usuarios.id,usuarios.nom, usuarios.dni, alumnos.codi_Alumne " +
                    "from usuarios, alumnos where usuarios.id = alumnos.id_usuari AND usuarios.id_roles = 5 AND usuarios.estat = 'actiu'");
>>>>>>> 8d3f99eae268e277e42e8696265afa2539e3411a

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
<<<<<<< HEAD
            ResultSet resultado = sentencia.executeQuery("select usuarios.id,usuarios.nom, usuarios.dni, alumnes.codi_Alumne " +
                    "from usuarios, alumnes where usuarios.id = alumnes.id_user AND usuarios.id_roles = 5");
=======
            ResultSet resultado = sentencia.executeQuery("select usuarios.id,usuarios.nom, usuarios.dni, alumnos.codi_Alumne " +
                    "from usuarios, alumnos where usuarios.id = alumnos.id_usuari AND usuarios.id_roles = 5");
>>>>>>> 8d3f99eae268e277e42e8696265afa2539e3411a

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
