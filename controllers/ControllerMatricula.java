package Sprint5Java.controllers;


import Sprint5Java.logManager.Log;
import Sprint5Java.models.Matricula;

import java.sql.*;
import java.util.HashMap;

/**
 * Grup 2 Sprint 5 2020-2021 - Alberto Dos Santos
 * Classe ControllerMatricula, Aquesta conté l'array on s'emmagatzemen els objectes tipus Matricula, també conte diferents mètodes útils
 */
public class ControllerMatricula {

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
    private static final String DBTableName = "matriculas";

    /**
     * Constructor que inicia l'array
     */
    public ControllerMatricula(HashMap<String, String> dbParam) {
        try {
            this.connexioBD = DriverManager.getConnection("jdbc:mysql://localhost/" + dbParam.get("db.database"), dbParam.get("db.user"), dbParam.get("db.password"));
            Statement sentencia = this.connexioBD.createStatement();
            ResultSet resultado = sentencia.executeQuery("select * from "+DBTableName);
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
            ResultSet resultado = sentencia.executeQuery("INSERT INTO matriculas (id_grup, id_alumne, data_matriculat, data_desmatriculat, estat) VALUES ("+matriculaAlta.getId_grup()+","+matriculaAlta.getId_alumne()+","+matriculaAlta.getData_matriculat()+","+matriculaAlta.getData_desmatriculat()+","+matriculaAlta.getEstat()+";");
            System.out.println("INSERT INTO matriculas (id_grup, id_alumne, data_matriculat, data_desmatriculat, estat) VALUES ("+matriculaAlta.getId_grup()+","+matriculaAlta.getId_alumne()+","+matriculaAlta.getData_matriculat()+","+matriculaAlta.getData_desmatriculat()+","+matriculaAlta.getEstat()+";");

            while (resultado.next()) {
                System.out.println(resultado.getRow());
            }
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
    public String[][] getDataTable(){
        int numberOfFields = 6;
        String[][] tableData = new String[this.contadorMatricules][numberOfFields];
        try {
            Statement sentencia = this.connexioBD.createStatement();
            ResultSet resultado = sentencia.executeQuery("select * from "+DBTableName);
            int tableCounter = 0;
            while (resultado.next()) {

                for (int i = 0; i < numberOfFields; i++) {
                    tableData[tableCounter][i] = resultado.getString(i+1);//+1 perque el getString(int) comença desde 1 i no desde 0
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
            ResultSet resultado = sentencia.executeQuery("update "+DBTableName+" set estat = 'inactiu' where id = "+id);
            while (resultado.next()) {
                System.out.println(resultado.getRow());
            }
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
