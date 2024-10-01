import java.util.Queue;
import java.util.LinkedList;

/**
 * Clase que representa el servidor de impresión real. Maneja la cola de
 * impresión.
 */
public class ServidorReal implements ServidorImpresion {
    private Queue<Documento> colaImpresion;
    private Impresora impresora;

    /**
     * Constructor que inicializa la cola de impresión y la impresora.
     */
    public ServidorReal() {
        colaImpresion = new LinkedList<>();
        impresora = Impresora.getInstancia();
    }

    /**
     * Procesa la impresión de un documento sacándolo de la cola y enviándolo a la
     * impresora.
     * 
     * @param documento el documento a ser impreso.
     */
    @Override
    public void procesarImpresion(Documento documento) {
        colaImpresion.add(documento);
        Documento docAImprimir = colaImpresion.poll();
        impresora.imprimir(docAImprimir);
    }
}
