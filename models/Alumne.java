package Sprint5Java.models;


public class Alumne extends Persona{
    private String codi;
    public Alumne(String nom, String dni, String codi){
        super(nom, dni);
        this.codi = codi;
    }

    public String getCodi() {
        return codi;
    }

    public void setCodi(String codi) {
        this.codi = codi;
    }
}
