package org.iesalandalus.programacion.actividades.datosprimitivos;

import java.io.*;

public class LeerFicheroDatos {
    /*Escribir un programa en java que muestre los datos almacenados en un
    fichero de datos primitivos cuyo orden de escritura ha sido: String, int y double.*/
    private static final String FICHERO = String.format("%s%s%s", "ficheros", File.separator, "ficheroSerializacionObjectos.txt");
    public static void main(String[] args) {
        try (DataInputStream entrada = new DataInputStream(new FileInputStream(FICHERO))){
            mostrarDatos(entrada);
        } catch (FileNotFoundException e) {
            System.out.println("No se puede leer el fichero de entrada");
        } catch (IOException e) {
            System.out.printf("No existe el fichero de origen: %s%n", FICHERO);
        }
    }

    private static void mostrarDatos(DataInputStream entrada) throws IOException {
        try {
            String cadena = "";
            int elEntero;
            double elDouble;
            while (cadena != null) {
                cadena = entrada.readUTF();
                elEntero = entrada.readInt();
                elDouble = entrada.readDouble();
                System.out.println(cadena + elEntero + elDouble);
            }
        } catch (EOFException e) {
            System.out.println("Fichero leído satisfactoriamente.");
        }
    }
}
