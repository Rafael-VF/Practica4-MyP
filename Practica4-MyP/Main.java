/**
 * Clase principal para ejecutar el sistema de impresión.
 */
public class Main {
    public static void main(String[] args) {
        // Crear el servidor real y el proxy
        ServidorReal servidorReal = new ServidorReal(); // Variable correcta
        ServidorProxy servidorProxy = new ServidorProxy(servidorReal); // Usamos servidorReal

        // Crear empleados
        Empleado empleado1 = new Empleado("Juan", "RFC123456789012", "Contabilidad", 3);
        Empleado empleado2 = new Empleado("Maria", "RFC987654321012", "Mercadotecnia", 4);

        // Crear documentos
        Documento doc1 = new Documento("Reporte Finanzas", false); // Blanco y negro
        Documento doc2 = new Documento("Presentacion Marketing", true); // A color

        // Intentar imprimir desde el proxy
        empleado1.pedirImpresion(doc1, servidorProxy); // Debería permitir imprimir
        empleado1.pedirImpresion(doc2, servidorProxy); // No debería permitir imprimir en color
        empleado2.pedirImpresion(doc2, servidorProxy); // Debería permitir imprimir en color
    }
}
