package org.iesalandalus.programacion.actividades.flujos_de_caracteres;

import org.iesalandalus.programacion.utilidades.Entrada;

import java.io.*;

public class EscribirFicheroTexto {
    private static final String FICHERO = String.format("%s%s%s", "ficheros", File.separator, "ficheroTexto.txt");
    public static void main(String[] args) {
        System.out.print("Escribe el contenido del fichero: ");
        String cadena = null;
        try (FileWriter entrada = new FileWriter(FICHERO)){
            while(!(cadena = Entrada.cadena()).equals("|")){
                cadena = Entrada.cadena();
                entrada.write(String.format("%n"));
            }
        } catch (FileNotFoundException e) {
            System.out.println("No se puede leer el fichero de entrada");
        } catch (IOException e) {
            System.out.println("Error inesperado de Entrada/Salida");
        }
    }

}
