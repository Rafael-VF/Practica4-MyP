import java.util.Queue;
import java.util.LinkedList;

/**
 * Proxy que controla el acceso al servidor de impresión real, validando los
 * permisos de impresión de los empleados.
 */
public class ServidorProxy implements ServidorImpresion {
    private ServidorReal servidorReal;
    private Queue<Documento> colaImpresion;

    /**
     * Constructor que inicializa el proxy con un servidor real.
     * 
     * @param servidorReal el servidor real de impresión.
     */
    public ServidorProxy(ServidorReal servidorReal) {
        this.servidorReal = servidorReal;
        this.colaImpresion = new LinkedList<>();
    }

    /**
     * Agrega un documento a la cola de impresión después de validar las credenciales
     * del empleado.
     * 
     * @param empleado  el empleado que solicita la impresión.
     * @param documento el documento que se desea imprimir.
     */
    public void agregarImpresion(Empleado empleado, Documento documento) {
        if (validarCredencial(empleado, documento)) {
            colaImpresion.add(documento);
            procesarImpresion(documento);
        } else {
            System.out.println("El empleado " + empleado.getNombre() + " no tiene permisos para imprimir a color.");
        }
    }

    /**
     * Valida si el empleado tiene los permisos necesarios para imprimir.
     * 
     * @param empleado  el empleado que solicita la impresión.
     * @param documento el documento que se desea imprimir.
     * @return true si el empleado tiene los permisos necesarios, false en caso
     *         contrario.
     */
    private boolean validarCredencial(Empleado empleado, Documento documento) {
        if (documento.getAColor()) {
            return empleado.puedeImprimirColor();
        }
        return true;
    }

    /**
     * Procesa la impresión delegando al servidor real.
     * 
     * @param documento el documento a ser impreso.
     */
    @Override
    public void procesarImpresion(Documento documento) {
        servidorReal.procesarImpresion(documento);
    }
}