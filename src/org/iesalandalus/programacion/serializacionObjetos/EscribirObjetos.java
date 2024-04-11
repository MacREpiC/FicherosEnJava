package org.iesalandalus.programacion.serializacionObjetos;

import org.iesalandalus.programacion.utilidades.Entrada;

import java.io.*;

public class EscribirObjetos {
    /*Escribir un programa en java que escriba en un fichero 10 instancias de la clase Persona*/
    public static final String FICHERO = String.format("%s%s%s", "ficheros", File.separator, "personas.dat");
    public static void main(String[] args) {
        try (ObjectOutputStream salida = new ObjectOutputStream (new FileOutputStream(FICHERO))) {
            Persona persona;
            System.out.print("Dime el nombre: ");
            String nombre = Entrada.cadena();
            System.out.print("Dime tu edad: ");
            int edad = Entrada.entero();
            persona = new Persona(nombre, edad);
            salida.writeObject(persona);
            System.out.println("Fichero escrito satisfactoriamente.");
        } catch (FileNotFoundException e) {
            System.out.println("No puedo crear el fichero de salida.");
        } catch (IOException e) {
            System.out.println("Error inesperado de Entrada/Salida.");
        }
    }
}
