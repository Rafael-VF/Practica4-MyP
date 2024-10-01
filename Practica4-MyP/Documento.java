/**
 * Clase que representa un documento a ser impreso.
 */
public class Documento {
    private String nombre;
    private boolean aColor;

    /**
     * Constructor para crear un documento.
     * 
     * @param nombre el nombre del documento.
     * @param aColor si el documento debe imprimirse a color.
     */
    public Documento(String nombre, boolean aColor) {
        this.nombre = nombre;
        this.aColor = aColor;
    }

    /**
     * Devuelve el nombre del documento.
     * 
     * @return el nombre del documento.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Indica si el documento se imprimirá a color.
     * 
     * @return true si el documento es a color, false si es en blanco y negro.
     */
    public boolean getAColor() {
        return aColor;
    }
}
