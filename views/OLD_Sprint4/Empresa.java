//package Sprint5Java.views.OLD_Sprint4;
//
//import Sprint4Java.logManager.Log;
//
///**
// * Grup 2 Sprint 5 2020-2021 - Josep López
// * Classe Empresa
// */
//public class Empresa {
//
//    private Integer id;
//    public String nom;
//    public String telefon;
//    public String email;
//    public String localitat;
//    public String adresa;
//
//    /**
//     * Constructor per crear objectes d'Empreses
//     *
//     */
//    public Empresa(Integer id, String nom, String telefon, String email, String localitat, String adresa) {
//        this.nom = nom;
//        this.telefon = telefon;
//        this.email = email;
//        this.localitat = localitat;
//        this.adresa = adresa;
//        this.id = id;
//        Log.log("Creada Empresa \"" + nom + "\" amb la ID: " + id, "altaEmpresa");
//    }
//
//    public String getNom() {
//        return nom;
//    }
//
//    public void setNom(String nom) {
//        this.nom = nom;
//    }
//
//    public String getTelefon() {
//        return telefon;
//    }
//
//    public void setTelefon(String telefon) {
//        this.telefon = telefon;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getLocalitat() {
//        return localitat;
//    }
//
//    public void setLocalitat(String localitat) {
//        this.localitat = localitat;
//    }
//
//    public String getAdresa() {
//        return adresa;
//    }
//
//    public void setAdresa(String adresa) {
//        this.adresa = adresa;
//    }
//
//    public Integer getId() {
//        return id;
//    }
//
//
//    @Override
//    public String toString() {
//        return "Empresa{" +
//                "ID = " + id +
//                ", NOM ='" + nom + '\'' +
//                ", TELEFON ='" + telefon + '\'' +
//                ", EMAIL ='" + email + '\'' +
//                ", LOCALITAT ='" + localitat + '\'' +
//                ", ADREÇA ='" + adresa + '\'' +
//                '}';
//    }
//}
