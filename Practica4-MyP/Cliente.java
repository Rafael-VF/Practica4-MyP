import java.io.*;
import java.net.*;

/**
 * Clase Cliente para solicitar la impresión de documentos a través de sockets
 */
public class Cliente {

    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 12345); // Conectar al servidor
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            // Enviar datos del documento a imprimir
            String nombreDocumento = "Reporte Anual";
            boolean aColor = true; // Indicar si es a color o blanco y negro

            out.println(nombreDocumento);
            out.println(aColor);

            // Recibir confirmación del servidor
            String respuesta = in.readLine();
            System.out.println(respuesta);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
