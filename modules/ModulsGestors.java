package Sprint4Java.modules;

public class ModulsGestors {

    public   GestorCategoria GCategoria;
    public  GestorEmpresa GEmpresa;
    public  GestorIncidencia GIncidencia;
    public  GestorInstitut GInstitut;

    public ModulsGestors(GestorCategoria gCategoria, GestorEmpresa gEmpresa, GestorIncidencia gIncidencia, GestorInstitut gInstitut) {
        this.GCategoria = gCategoria;
        this.GEmpresa = gEmpresa;
        this.GIncidencia = gIncidencia;
        this.GInstitut = gInstitut;
    }
}
