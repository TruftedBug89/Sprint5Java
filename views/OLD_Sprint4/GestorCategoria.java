//
//package Sprint5Java.views.OLD_Sprint4;
//
//import Sprint4Java.logManager.Error;
//import Sprint4Java.logManager.Log;
//
//import java.util.ArrayList;
//
///**
// * Grup 2 Sprint 5 2020-2021 - Alberto Dos Santos
// * Classe GestorCategoria, Aquesta conté l'array on s'emmagatzemen els objectes tipus Categoria, també conte diferents mètodes útils
// */
//public class GestorCategoria {
//
//
//    private final ArrayList<Categoria> ArrayCategories;
//    private int contadorCategories = 0;
//
//    /**
//     * Constructor que inicia l'array
//     */
//    public GestorCategoria() {
//        Log.log("S'ha accedit al gestor de categories", "GestorCategoria");
//        this.ArrayCategories = new ArrayList<>();
//    }
//
//    /**
//     * Getter que retorna el tamany del array
//     *
//     * @return quantitat d'elements al array
//     */
//    public Integer getMax() {
//        return this.ArrayCategories.size();
//    }
//
//    /**
//     * Aquest mètode retorna una categoria, basant-se amb el nom que li donem com a paràmetre
//     *
//     * @param name nom de la categoria a buscar
//     * @return objecte tipus categoria
//     */
//    public Categoria getCategoriaByName(String name) {
//        for (Categoria cat : this.ArrayCategories) {
//            if (cat.getNom().trim().equals(name.trim()))
//                return cat;
//        }
//        return null;
//    }
//
//    /**
//     * Dona d'alta una categoria posant-la al array, retona true si es fa correctament, false si no
//     *
//     * @param nom        nom de la nova categoria
//     * @param descripcio descripcio de la nova categoria
//     */
//    public boolean altaCategoria(String nom, String descripcio) {
//        int contador = 0;
//        for (Categoria cat : this.ArrayCategories) {
//            if (cat.getNom().trim().equals(nom.trim())) {
//                Error.log("No s'ha pogut crear la categoria, nom repetit", "Altacategoria");
//                return false;
//            }
//        }
//        try {
//            this.ArrayCategories.add(new Categoria(this.contadorCategories, nom, descripcio));
//            this.contadorCategories++;
//            return true;
//
//        } catch (Exception e) {
//            Error.log("No s'ha pogut introduir categoria al array espais ocupats :" + contador + "/" + ArrayCategories.size(), "Altacategoria");
//            return false;
//        }
//
//    }
//
//    /**
//     * Aquest mètode elimina una categoria basant-se de la ID que té
//     *
//     * @param id id de la categoria a eliminar
//     * @return retorna true si s'ha eliminat i false si no
//     */
//    public boolean eliminarCategoria(Integer id) {
//
//        for (int i = 0; i < ArrayCategories.size(); i++) {
//            if (ArrayCategories.get(i) != null) {
//                if (ArrayCategories.get(i).getId().equals(id)) {
//                    Log.log("Categoria " + ArrayCategories.get(i).getNom() + " eliminada correctament", "Eliminar categoria");
//                    this.ArrayCategories.remove(i);
//                    return true;
//                }
//            }
//
//        }
//        Error.log("No s'ha trobat la ID de la categoria a eliminar ", "eliminarcategoria");
//        return false;
//    }
//
//    /**
//     * Aquest mètode retorna un array String[] amb tots els noms de totes les categories al array, incloent " Nom : " al principi de cada nom
//     *
//     * @return llista amb el nom de totes les categories
//     */
//    public String[] llistarCategoriaAArray() {
//        String[] returnedValue = new String[this.ArrayCategories.size()];
//        for (Categoria cat : this.ArrayCategories) {
//            returnedValue[this.ArrayCategories.indexOf(cat)] = "Nom : " + cat.getNom();
//        }
//        return returnedValue;
//    }
//
//    /**
//     * Aquest mètode retorna l'ArrayList on es troben emmagatzemats les Categories
//     *
//     * @return ArrayList de categories
//     */
//    public ArrayList<Categoria> getArray() {
//        return this.ArrayCategories;
//    }
//}
