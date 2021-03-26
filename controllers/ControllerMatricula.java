package Sprint5Java.controllers;


import Sprint5Java.logManager.Log;
import Sprint5Java.models.Matricula;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Grup 2 Sprint 5 2020-2021 - Alberto Dos Santos
 * Classe ControllerMatricula, Aquesta conté l'array on s'emmagatzemen els objectes tipus Matricula, també conte diferents mètodes útils
 */
public class ControllerMatricula {

    private static final String DBTableName = "matriculas";
    //try {
//        this.connexioBD = DriverManager.getConnection("jdbc:mysql://localhost/" + dbParam.get("db.database"), dbParam.get("db.user"), dbParam.get("db.password"));
//        Statement sentencia = this.connexioBD.createStatement();
//        ResultSet resultado = sentencia.executeQuery("select * from matriculas;");
//        while (resultado.next()) {
//            contadorMatricules++;
//        }
//
//    } catch (SQLException e) {
//        e.printStackTrace();
//        Log.log("Error al connectar a la BD desde les dades de config", "ControllerMatricula");
//    }
    private Connection connexioBD;
    private int contadorMatricules = 0;

    /**
     * Constructor que inicia l'array
     */
    public ControllerMatricula(HashMap<String, String> dbParam) {
        try {
            this.connexioBD = DriverManager.getConnection("jdbc:mysql://localhost/" + dbParam.get("db.database"), dbParam.get("db.user"), dbParam.get("db.password"));
            Statement sentencia = this.connexioBD.createStatement();
            ResultSet resultado = sentencia.executeQuery("select * from " + DBTableName);
            while (resultado.next()) {
                this.contadorMatricules++;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            Log.log("Error al connectar a la BD desde les dades de config", "ControllerMatricula");
        }
        Log.log("S'ha accedit al Controller de Matricules", "ControllerMatricula");

    }

    /**
     * Aquest mètode retorna una Matricula, basant-se amb el nom que li donem com a paràmetre
     *
     * @param name nom de la Matricula a buscar
     * @return objecte tipus Matricula
     */
//    public Matricula getMatriculaByName(String name) {
//        for (Matricula cat : this.ArrayMatricules) {
//            if (cat.getNom().trim().equals(name.trim()))
//                return cat;
//        }
//        return null;
//    }
//    private static void loadFromDB() {
//
//
//        String consulta = "select * from matriculas;";
//
//
//        try {
//
//            Statement sentencia = conexion.createStatement();
//
//            ResultSet resultat = sentencia.executeQuery(consulta);
////            while(resultat.next()){
////                System.out.println(resultat.getString("id_grup")+" "+resultat.getString("id_alumne"));
////            }
////            System.out.println(resultat.);Ç
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

    /**
     * Dona d'alta una Matricula posant-la al array, retona true si es fa correctament, false si no
     *
     * @param matriculaAlta
     */
    public boolean altaMatricula(Matricula matriculaAlta) {
        try {
            Statement sentencia = this.connexioBD.createStatement();
//            System.out.println("INSERT INTO matriculas (id_grup, id_alumne, data_matriculat," + ((matriculaAlta.getData_desmatriculat() != null) ? " data_desmatriculat," : "") + " estat) VALUES (" + matriculaAlta.getId_grup() + "," + matriculaAlta.getId_alumne() + "," + "DATE '" + matriculaAlta.getData_matriculat() + "'" + ((matriculaAlta.getData_desmatriculat() != null) ? ",DATE '" + matriculaAlta.getData_desmatriculat() + "'" : "") + ",'" + matriculaAlta.getEstat() + "')");

            int resultat = sentencia.executeUpdate("INSERT INTO matriculas (id_grup, id_alumne, data_matriculat," + ((matriculaAlta.getData_desmatriculat() != null) ? " data_desmatriculat," : "") + " estat) VALUES (" + matriculaAlta.getId_grup() + "," + matriculaAlta.getId_alumne() + "," + "DATE '" + matriculaAlta.getData_matriculat() + "'" + ((matriculaAlta.getData_desmatriculat() != null) ? ",DATE '" + matriculaAlta.getData_desmatriculat() + "'" : "") + ",'" + matriculaAlta.getEstat() + "')");
            if (resultat < 1) {
                throw new SQLException("insert didnt affect any row, check(altaMatricula) in Controller Matricula");
            }
//            while (resultado.next()) {
//                System.out.println(resultado.getRow());
//            }
            this.contadorMatricules++;
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            Log.log("Error al donar d'alta una matricula", "ControllerMatricula");
            return false;
        }

//        int contador = 0;
//        for (Matricula cat : this.ArrayMatricules) {
//            if (cat.getNom().trim().equals(nom.trim())) {
//                Error.log("No s'ha pogut crear la Matricula, nom repetit", "AltaMatricula");
//                return false;
//            }
//        }
//        try {
//            this.ArrayMatricules.add(new Matricula(this.contadorMatricules, nom, descripcio));
//            this.contadorMatricules++;
//            return true;
//
//        } catch (Exception e) {
//            Error.log("No s'ha pogut introduir Matricula al array espais ocupats :" + contador + "/" + ArrayMatricules.size(), "AltaMatricula");
//            return false;
//        }

    }

    public String[][] getDataTable() {
        int numberOfFields = 6;
        String[][] tableData = new String[this.contadorMatricules][numberOfFields];
        try {
            Statement sentencia = this.connexioBD.createStatement();
            ResultSet resultado = sentencia.executeQuery("select matriculas.id, grupo_clases.nom, concat(usuarios.nom,' ',usuarios.cognom), matriculas.data_matriculat, matriculas.data_desmatriculat, matriculas.estat from matriculas, usuarios, grupo_clases, alumnos where matriculas.id_alumne = alumnos.id and alumnos.id = usuarios.id and matriculas.id_grup = grupo_clases.id and matriculas.estat = 'actiu'");

            int tableCounter = 0;
            while (resultado.next()) {

                for (int i = 0; i < numberOfFields; i++) {
                    tableData[tableCounter][i] = resultado.getString(i + 1);//+1 perque el getString(int) comença desde 1 i no desde 0
                }
                tableCounter++;
            }
            return tableData;

        } catch (SQLException e) {
            e.printStackTrace();
            Log.log("Error al crear la taula amb les dades (getdatatable)", "ControllerMatricula");
            tableData[0][0] = "ERROR DB";
            return tableData;
        }

    }

    /**
     * Aquest mètode elimina una Matricula basant-se de la ID que té
     *
     * @param id id de la Matricula a eliminar
     * @return retorna true si s'ha eliminat i false si no
     */
    public boolean eliminarMatricula(Integer id) {
        try {
            Statement sentencia = this.connexioBD.createStatement();
            ResultSet resultado = sentencia.executeQuery("update " + DBTableName + " set estat = 'inactiu' where id = " + id);
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            Log.log("Error al eliminar la matricula(eliminarmatricula)", "ControllerMatricula");
            return false;
        }

    }

    public String[] getGroupNameList() {
        ArrayList<String> groupNameList = new ArrayList<String>();
        try {
            Statement sentencia = this.connexioBD.createStatement();
            ResultSet resultado = sentencia.executeQuery("select * from grupo_clases");
            int tableCounter = 0;
            while (resultado.next()) {
                groupNameList.add(resultado.getString("nom") + " ID: " + resultado.getString("id"));
            }
            return groupNameList.toArray(new String[0]);

        } catch (SQLException e) {
            e.printStackTrace();
            Log.log("Error al crear el llistat amb els noms de grup (getGroupNameList)", "ControllerMatricula");
            groupNameList.add("ERROR DB");
            return (String[]) groupNameList.toArray();
        }
    }

    public String[] getStudentNameList() {
        ArrayList<String> studentNameList = new ArrayList<>();
        try {
            Statement sentencia = this.connexioBD.createStatement();
            ResultSet resultado = sentencia.executeQuery("select * from usuarios where id_roles = 4");
            int tableCounter = 0;
            while (resultado.next()) {
                studentNameList.add(resultado.getString("nom") + " " + resultado.getString("cognom") + " ID: " + resultado.getString("id"));
            }
            return studentNameList.toArray(new String[0]);

        } catch (SQLException e) {
            e.printStackTrace();
            Log.log("Error al crear el llistat amb els noms dels alumnes (getStudentNameList)", "ControllerMatricula");
            studentNameList.add("ERROR DB");
            return (String[]) studentNameList.toArray();
        }
    }

    public Matricula getMatriculaById(int id) {
        try {
            Statement sentencia = this.connexioBD.createStatement();
            ResultSet resultado = sentencia.executeQuery("select * from " + DBTableName + " where id = " + id);
            Matricula getFromDB = null;
            while (resultado.next()) {
//                System.out.println(resultado.getString("data_matriculat").split(" ")[0]);
                getFromDB = new Matricula(
                        Integer.parseInt(resultado.getString("id")),
                        Integer.parseInt(resultado.getString("id_grup")),
                        Integer.parseInt(resultado.getString("id_alumne")),

                        Date.valueOf(resultado.getString("data_matriculat").split(" ")[0]),
                        (resultado.getString("data_desmatriculat") == null) ? null : Date.valueOf(resultado.getString("data_desmatriculat").split(" ")[0]),
                        resultado.getString("estat")
                );
                return getFromDB;

            }
            return getFromDB;

        } catch (SQLException e) {
            e.printStackTrace();
            Log.log("Error al buscar la matricula per ID (getMatriculaById)", "ControllerMatricula");
            return null;
        }
    }

    public boolean editMatricula(Integer id_matricula, Matricula matricula) {
        try {
            Statement sentencia = this.connexioBD.createStatement();
            ResultSet resultado = sentencia.executeQuery("update " + DBTableName + " SET id_grup="+matricula.getId_grup()+", id_alumne="+matricula.getId_alumne()+", data_matriculat="+matricula.getData_matriculat()+", data_desmatriculat="+matricula.getData_desmatriculat()+",estat="+matricula.getEstat()+" WHERE id = "+id_matricula);
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            Log.log("Error al eliminar la matricula(eliminarmatricula)", "ControllerMatricula");
            return false;
        }

    }

    /**
     * Aquest mètode retorna un array String[] amb tots els noms de totes les Matricules al array, incloent " Nom : " al principi de cada nom
     *
     * @return llista amb el nom de totes les Matricules
     */
//    public String[] llistarMatriculaAArray() {
//        String[] returnedValue = new String[this.ArrayMatricules.size()];
//        for (Matricula cat : this.ArrayMatricules) {
//            returnedValue[this.ArrayMatricules.indexOf(cat)] = "Nom : " + cat.getNom();
//        }
//        return returnedValue;
//    }

}
