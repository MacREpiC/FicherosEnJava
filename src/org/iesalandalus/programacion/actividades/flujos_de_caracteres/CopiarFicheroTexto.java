package org.iesalandalus.programacion.actividades.flujos_de_caracteres;

import java.io.*;

public class CopiarFicheroTexto {
    private static final String FICHERO_ENTRADA = String.format("%s%s%s", "ficheros", File.separator, "ficheroEntrada.txt");
    private static final String FICHERO_SALIDA = String.format("%s%s%s", "ficheros", File.separator, "ficheroSalida.txt");
    public static void main(String[] args) {
        try (FileReader entrada = new FileReader(FICHERO_ENTRADA); FileWriter salida = new FileWriter(FICHERO_SALIDA)){
            int dato;
            while ((dato = entrada.read()) != -1) {
                salida.write((char)dato);
            }
            System.out.print("Fichero copiado.");
        } catch (FileNotFoundException e) {
            System.out.println("No se puede leer el fichero de entrada");
        } catch (IOException e) {
            System.out.println("Error inesperado de Entrada/Salida");
        }
    }
}
