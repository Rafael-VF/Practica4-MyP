/**
 * Clase Singleton que representa una impresora compartida por todos los pisos.
 */
public class Impresora {
    private static Impresora instancia;

    private Impresora() {
    }

    /**
     * Devuelve la instancia de la impresora.
     * 
     * @return instancia única de la impresora.
     */
    public static Impresora getInstancia() {
        if (instancia == null) {
            instancia = new Impresora();
        }
        return instancia;
    }

    /**
     * Método para imprimir un documento.
     * 
     * @param documento el documento a imprimir.
     */
    public void imprimir(Documento documento) {
        System.out.println("Imprimiendo: " + documento.getNombre());
        if (documento.getAColor()) {
            System.out.println("Imprimiendo en color.");
        } else {
            System.out.println("Imprimiendo en blanco y negro.");
        }
    }
}
