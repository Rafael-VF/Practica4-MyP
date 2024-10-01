/**
 * Interfaz que define el comportamiento para el procesamiento de impresión.
 */
public interface ServidorImpresion {
    /**
     * Procesa la impresión de un documento.
     * 
     * @param documento el documento a ser impreso.
     */
    void procesarImpresion(Documento documento);
}
