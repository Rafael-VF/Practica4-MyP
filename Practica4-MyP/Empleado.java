/**
 * Clase que representa a un empleado en la empresa.
 */
public class Empleado {
    String nombre;
    String RFC;
    String areaDeTrabajo;
    int    pisoDeTrabajo;

    /**
     * Constructor para crear un empleado.
     * 
     * @param nombre        el nombre del empleado.
     * @param RFC           el RFC del empleado.
     * @param areaDeTrabajo el área de trabajo del empleado.
     * @param pisoDeTrabajo el piso donde trabaja el empleado.
     */
    public Empleado(String nombre, String RFC, String areaDeTrabajo, int pisoDeTrabajo) {
        this.nombre = nombre;
        this.RFC = RFC;
        this.areaDeTrabajo = areaDeTrabajo;
        this.pisoDeTrabajo = pisoDeTrabajo;
    }

    /**
     * Devuelve el nombre del empleado.
     * 
     * @return el nombre del empleado.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Devuelve el RFC del empleado.
     * 
     * @return el RFC del empleado.
     */
    public String getRFC() {
        return RFC;
    }

    /**
     * Devuelve el área de trabajo del empleado.
     * 
     * @return el área de trabajo del empleado.
     */
    public String getAreaDeTrabajo() {
        return areaDeTrabajo;
    }

    /**
     * Devuelve el piso de trabajo del empleado.
     * 
     * @return el número de piso donde trabaja el empleado.
     */
    public int getPisoDeTrabajo() {
        return pisoDeTrabajo;
    }

    /**
     * Determina si el empleado tiene permisos para imprimir a color.
     * 
     * @return true si puede imprimir a color, false en caso contrario.
     */
    public boolean puedeImprimirColor() {
        return areaDeTrabajo.equals("Mercadotecnia");
    }

    /**
     * Solicita la impresión de un documento al servidor de impresión.
     * 
     * @param documento el documento que se desea imprimir.
     * @param servidor  el servidor de impresión.
     */
    public void pedirImpresion(Documento documento, ServidorImpresion servidor) {
        servidor.procesarImpresion(documento);
    }
}
