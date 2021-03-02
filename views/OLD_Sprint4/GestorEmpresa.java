//package Sprint5Java.views.OLD_Sprint4;
//
//import Sprint4Java.logManager.Error;
//import Sprint4Java.logManager.Log;
//
//import java.util.ArrayList;
//
///**
// * Grup 2 Sprint 5 2020-2021 - Josep López
// * Classe GestorEmpresa, Aquesta conté l'array on s'emmagatzemen els objectes tipus Empresa, també conte diferents mètodes útils
// */
//public class GestorEmpresa {
//
//    private Integer contadorEmpreses = 0;
//    private ArrayList<Empresa> ArrayEmpreses;
//
//    /**
//     * Getter que retorna el tamany del array
//     * @return
//     */
//    public Object getMax() {
//        return this.ArrayEmpreses.size();
//    }
//
//
//    /**
//     * Aquest mètode retorna l'ArrayList on es troben emmagatzemats les Empreses
//     * @return
//     */
//    public ArrayList<Empresa>  getArray() {
//        return this.ArrayEmpreses;
//    }
//
//    /**
//     * Constructor que inicia l'array
//     */
//    public GestorEmpresa(Integer maxim) {
//        Log.log("S'ha accedit al gestor de empreses", "GestorEmpresa");
//        this.ArrayEmpreses = new ArrayList<>();
//    }
//
//    /**
//     * Aquest mètode retorna una empresa, basant-se amb el nom que li donem com a paràmetre
//     * @param name nom de la empresa a buscar
//     * @return
//     */
//    public Empresa getEmpresaByName(String name) {
//        for (Empresa cat : this.ArrayEmpreses) {
//            if (cat.getNom().trim().equals(name.trim()))
//                return cat;
//        }
//        return null;
//    }
//
//    /** Dona d'alta una empresa posant-la al array, retona true si es fa correctament, false si no
//     * @param nom
//     * @param telefon
//     * @param email
//     * @param localitat
//     * @param adresa
//     */
//    public boolean altaEmpresa(String nom, String telefon, String email, String localitat, String adresa) {
//        for (Empresa cat : this.ArrayEmpreses) {
//            if (cat.getNom().trim().equals(nom.trim())) {
//                Error.log("No s'ha pogut crear l'empresa, nom repetit", "altaEmpresa");
//                return false;
//            }
//        }
//        try {
//            this.ArrayEmpreses.add(new Empresa(this.contadorEmpreses, nom, telefon, email, localitat, adresa));
//            this.contadorEmpreses++;
//            return true;
//
//        } catch (Exception e) {
//            Error.log("No s'ha pogut introduir empresa al array espais ocupats :" + contadorEmpreses + "/" + ArrayEmpreses.size(), "altaEmpresa");
//            return false;
//        }
//
//    }
//
//    /**
//     * Aquest mètode elimina una empresa basant-se de la ID que té
//     * @param id
//     * @return
//     */
//    public boolean eliminarEmpresa(Integer id) {
//
//        for (int i = 0; i < ArrayEmpreses.size(); i++) {
//
//            if (ArrayEmpreses.get(i) != null) {
//                if (ArrayEmpreses.get(i).getId() == id) {
//                    Log.log("Empresa " + ArrayEmpreses.get(i).getNom() + " eliminada correctament", "eliminarEmpresa");
//                    this.ArrayEmpreses.remove(i);
//                    return true;
//                }
//            }
//        }
//        Error.log("No s'ha trobat la ID de la empresa a eliminar ", "eliminarEmpresa");
//        return false;
//    }
//
//
//    /**
//     * Aquest mètode retorna un array String[] amb tots els noms de totes les empreses al array, incloent nomes " Nom : " al principi de cada nom
//     * @return
//     */
//    public String[] llistarEmpreses(){
//        String[] returnedValue = new String[this.ArrayEmpreses.size()];
//        for (Empresa cat : this.ArrayEmpreses){
//            returnedValue[this.ArrayEmpreses.indexOf(cat)] = "Nom : "+cat.getNom();
//        }
//        return returnedValue;
//    }
//}
