import java.util.Queue;
import java.util.LinkedList;

/**
 * Proxy para manejar la validación de permisos antes de imprimir
 */
public class ServidorProxy implements ServidorImpresion {
    private ServidorReal servidorReal;
    private Queue<Documento> colaImpresion = new LinkedList<>();

    public ServidorProxy(ServidorReal servidorReal) {
        this.servidorReal = servidorReal;
    }

    /**
     * Método para agregar una solicitud de impresión si el empleado tiene permisos.
     */
    public void agregarImpresion(Empleado empleado, Documento documento) {
        if (validarCredencial(empleado, documento)) {
            System.out.println("Solicitud aceptada para " + empleado.getNombre());
            procesarImpresion(documento);
        } else {
            System.out.println("Permiso denegado para imprimir a color");
        }
    }

    /**
     * Validar si el empleado puede imprimir a color.
     */
    public boolean validarCredencial(Empleado empleado, Documento documento) {
        if (documento.getAColor() && !empleado.puedeImprimirColor()) {
            return false;
        }
        return true;
    }

    @Override
    public void procesarImpresion(Documento documento) {
        // Enviar el documento a través del servidor real
        servidorReal.procesarImpresion(documento);
    }
}
