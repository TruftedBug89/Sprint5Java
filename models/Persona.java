package Sprint5Java.models;

public abstract class Persona {
    protected String nom;
    protected String dni;

    public Persona(String nom, String dni) {
        this.nom = nom;
        this.dni = dni;
    }

    /**
     * Getters & Setters
     */

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }


    @Override
    public String toString() {
        return "Nom: " + nom + " | " +
                "DNI: " + dni + " | ";
    }

}