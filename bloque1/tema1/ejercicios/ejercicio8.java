package bloque1.tema1.ejercicios;

import java.io.FileReader;
import java.util.Scanner;

public class ejercicio8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("1-Guardar");
        System.out.print("2-Imprimir");
        int opcion = Integer.parseInt(sc.nextLine());

        if (opcion == 1) {
            System.out.print("Nombre y apellidos");
            String nombre = sc.nextLine();
            System.out.print("Email");
            String email = sc.nextLine();
            System.out.print("Fecha de nacimiento");
            String fecha = sc.nextLine();
            System.out.print("Genero");
            String genero = sc.nextLine();
            System.out.print("Titulo");
            String titulo = sc.nextLine();
            System.out.print("observaciones");
            String observaciones = sc.nextLine();

            String contenido = " Formulacion de Matricula" + "nNombre y apellidos: " + nombre + "\nEmail: " + email
                    + "\nFecha de nacimiento: " + fecha + "\nGenero: " + genero + "\nTitulo: " + titulo
                    + "\nObservaciones: " + observaciones;
            try {

                FileReader fw = new FileReader("matricula.txt");

                int data;
                while ((data = fw.read()) != -1) {
                    System.out.print((char) data);
                }
                
                fw.close();
                sc.close();
            } catch (Exception e) {
                // TODO: handle exception
            }
            
            
        }
    }
}
