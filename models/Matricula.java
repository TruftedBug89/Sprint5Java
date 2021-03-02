package Sprint5Java.models;

import java.util.Date;

/**
 * Grup 2 Sprint 5 2020-2021 - Alberto Dos Santos
 * Classe Matricula
 */

public class Matricula {

    private Integer id;
    private Integer id_grup;
    private Integer id_alumne;
    private Date data_matriculat;
    private Date data_desmatriculat;
    private String estat;

    /**
     * @param id
     * @param id_grup
     * @param id_alumne
     * @param data_matriculat
     * @param data_desmatriculat
     * @param estat
     */
    public Matricula(Integer id, Integer id_grup, Integer id_alumne, Date data_matriculat, Date data_desmatriculat, String estat) {
        this.id = id;
        this.id_grup = id_grup;
        this.id_alumne = id_alumne;
        this.data_matriculat = data_matriculat;
        this.data_desmatriculat = data_desmatriculat;
        switch (estat) {
            case "actiu":
                this.estat = "actiu";
                break;
            case "inactiu":
                this.estat = "inactiu";
                break;
            default:
                this.estat = "";
                break;
        }
//        Log.log("Matricula Creada \"" + nom + "\" amb la ID: " + id, "CrearCategoria");


    }

    public Integer getId() {
        return id;
    }

    public Integer getId_grup() {
        return id_grup;
    }

    public void setId_grup(Integer id_grup) {
        this.id_grup = id_grup;
    }

    public Integer getId_alumne() {
        return id_alumne;
    }

    public void setId_alumne(Integer id_alumne) {
        this.id_alumne = id_alumne;
    }

    public Date getData_matriculat() {
        return data_matriculat;
    }

    public void setData_matriculat(Date data_matriculat) {
        this.data_matriculat = data_matriculat;
    }

    public Date getData_desmatriculat() {
        return data_desmatriculat;
    }

    public void setData_desmatriculat(Date data_desmatriculat) {
        this.data_desmatriculat = data_desmatriculat;
    }

    public String getEstat() {
        return estat;
    }

    public void setEstat(String estat) {
        this.estat = estat;
    }

    @Override
    public String toString() {
        return "Matricula{" +
                "id=" + id +
                ", id_grup=" + id_grup +
                ", id_alumne=" + id_alumne +
                ", data_matriculat=" + data_matriculat +
                ", data_desmatriculat=" + data_desmatriculat +
                ", estat='" + estat + '\'' +
                '}';
    }
}
