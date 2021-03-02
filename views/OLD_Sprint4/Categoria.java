//
//
//package Sprint5Java.views.OLD_Sprint4;
//
//import Sprint4Java.logManager.Log;
//
///**
// * Grup 2 Sprint 5 2020-2021 - Alberto Dos Santos
// * Classe Categoria
// */
////public class Categoria {
//    private final Integer id;
//    private String nom;
//    private String descripcio;
//
//    /**
//     * Constructor per crear objectes de tipus categoria
//     *
//     * @param id         id del objecte
//     * @param nom        del objecte
//     * @param descripcio del objecte
//     */
//    public Categoria(Integer id, String nom, String descripcio) {
//        this.id = id;
//        this.nom = nom.trim();
//        this.descripcio = descripcio.trim();
//        Log.log("Creada categoria \"" + nom + "\" amb la ID: " + id, "CrearCategoria");
//    }
//
//    /**
//     * Retorna el valor de nom
//     *
//     * @return nom
//     */
//    public String getNom() {
//        return nom;
//    }
//
//    /**
//     * Actualitza el valor de nom
//     *
//     * @param nom nou valor per el nom
//     */
//    public void setNom(String nom) {
//        this.nom = nom;
//    }
//
//    /**
//     * Retorna el valor de la descripcio
//     *
//     * @return descripcio del objecte
//     */
//    public String getDescripcio() {
//        return this.descripcio;
//    }
//
//    /**
//     * Actualitza el valor de la descripcio
//     *
//     * @param descripcio nova descripcio per al objecte
//     */
//    public void setDescripcio(String descripcio) {
//        this.descripcio = descripcio;
//    }
//
//    /**
//     * Retorna la ID del objecte actual
//     *
//     * @return retorna la id del objecte
//     */
//    public Integer getId() {
//        return this.id;
//    }
//
//
//    @Override
//    public String toString() {
//        return "Categoria{" +
//                "ID = " + this.id +
//                ", NOM ='" + this.nom + '\'' +
//                ", DESCRIPCIO ='" + this.descripcio + '\'' +
//                '}';
//    }
//}
