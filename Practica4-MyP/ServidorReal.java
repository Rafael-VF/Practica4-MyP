import java.io.*;
import java.net.*;
import java.util.Queue;
import java.util.LinkedList;

/**
 * Clase ServidorReal con manejo de sockets para recibir solicitudes de impresión
 */
public class ServidorReal implements ServidorImpresion {

    private Queue<Documento> colaImpresion = new LinkedList<>();
    private Impresora impresora = Impresora.getInstancia();

    public ServidorReal() {
        // Configurar y levantar el servidor socket
        try (ServerSocket serverSocket = new ServerSocket(12345)) {
            System.out.println("Servidor de impresión en ejecución...");

            while (true) {
                // Espera conexiones de clientes
                Socket clientSocket = serverSocket.accept();
                System.out.println("Cliente conectado");

                // Procesa la solicitud del cliente
                handleClient(clientSocket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Maneja la solicitud del cliente
     */
    private void handleClient(Socket clientSocket) {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

            // Leer la solicitud de impresión (nombre del documento, si es a color o no)
            String nombreDocumento = in.readLine();
            boolean aColor = Boolean.parseBoolean(in.readLine());

            // Crear un nuevo documento
            Documento documento = new Documento(nombreDocumento, aColor);

            // Agregar el documento a la cola de impresión
            procesarImpresion(documento);

            out.println("El documento " + nombreDocumento + " se ha enviado a la impresora.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void procesarImpresion(Documento documento) {
        colaImpresion.add(documento);
        impresora.imprimir(colaImpresion.poll());
    }
}
