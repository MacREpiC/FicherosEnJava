package org.iesalandalus.programacion.actividades.bufferes;

import org.iesalandalus.programacion.utilidades.Entrada;

import java.io.*;

public class MostrarFicheroTexto {
    private static final String FICHERO = String.format("%s%s%s", "ficheros", File.separator, "ficheroSalida.txt");
    public static void main(String[] args) {
        try (BufferedReader entrada = new BufferedReader(new FileReader(FICHERO))){
            int caracter;
            if(estaVacio()){
                caracter = entrada.read();
                if (caracter != -1) {
                    System.out.print((char) caracter);
                }
                while ((caracter = entrada.read()) != -1) {
                    System.out.print((char) caracter);
                }
            } else{
                System.out.println("ESTÁ VACÍO.");
            }
        } catch (FileNotFoundException e) {
            System.out.println("No se puede leer el fichero de entrada");
        } catch (IOException e) {
            System.out.println("Error inesperado de Entrada/Salida");
        }
    }
    public static boolean estaVacio() {
        boolean estaVacio = false;
        try (FileReader entrada = new FileReader(FICHERO)){
            if(entrada.read() != -1){
                estaVacio = true;
            }
        } catch (FileNotFoundException e) {
            System.out.println("No se puede leer el fichero de entrada");
        } catch (IOException e) {
            System.out.println("Error inesperado de Entrada/Salida");
        }
        return estaVacio;
    }
}
