package org.iesalandalus.programacion.actividades.datosprimitivos;

import java.io.*;

public class EscribirFicheroDatos {
    /*Escribir un programa en java que muestre los datos almacenados en un
    fichero de datos primitivos cuyo orden de escritura ha sido: String, int y double.*/
    private static final String FICHERO = String.format("%s%s%s", "ficheros", File.separator, "ficheroSerializacionObjectos.txt");
    public static void main(String[] args) {
        try (DataOutputStream salida = new DataOutputStream(new FileOutputStream(FICHERO))){
            escribirDatos(salida);
        } catch (FileNotFoundException e) {
            System.out.println("No se puede leer el fichero de entrada");
        } catch (IOException e) {
            System.out.printf("No existe el fichero de origen: %s%n", FICHERO);
        }
    }

    private static void escribirDatos(DataOutputStream salida) throws IOException {
        String cadena;
        int elEntero;
        double elDouble;

        for(int i = 0; i <= 10; i++){
            cadena = "Número de la cadena: " + i;
            elEntero = 10 * i;
            elDouble = elEntero / 100.00;
            salida.writeUTF(cadena);
            salida.writeInt(elEntero);
            salida.writeDouble(elDouble);
        }
        System.out.println("Fichero escrito correctamente.");
    }
}
