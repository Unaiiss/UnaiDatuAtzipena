package Funciones;

import java.util.Scanner;

import Modelo.CD;

public class Utilidades {

    public static CD pedirCD(Scanner sc) {
        System.out.println("Titulo: ");
        String titulo = sc.nextLine();
        
        System.out.println("Artista: ");
        String artista = sc.nextLine();
        
        System.out.println("Pais: ");
        String pais = sc.nextLine();
        
        System.out.println("Sello: ");
        String sello = sc.nextLine();
        
        System.out.println("Precio: ");
        double precio = Double.parseDouble(sc.nextLine());
        
        System.out.println("Año: ");
        int año = Integer.parseInt(sc.nextLine());
        
        // Crea y devuelve un nuevo CD (sin ID, se le asignará después)
        return new CD(2, titulo, artista, pais, sello, precio, año);
    }
}
