package biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LeerTeclado {
    public static String leerString(String mensaje){
        // 1. Paso numero uno, ubicar el origen de la información
        // 2. Conectarse al flujo de la información
        InputStreamReader isr = new InputStreamReader(System.in);
        // 3. Leer desde el flujo de información
        BufferedReader br = new BufferedReader(isr);
        String dato = null;
        try {
            
            System.out.println(mensaje);
            dato = br.readLine();
            
        } catch (IOException iOException) {
        }
        return dato;
    }
    public static int leerInt(String mensaje){
        // 1. Paso numero uno, ubicar el origen de la información
        // 2. Conectarse al flujo de la información
        InputStreamReader isr = new InputStreamReader(System.in);
        // 3. Leer desde el flujo de información
        BufferedReader br = new BufferedReader(isr);
        String dato = null;
        try {
            
            System.out.println(mensaje);
            dato = br.readLine();
            
        } catch (IOException iOException) {
        }
        return Integer.parseInt(dato);
    }
    
    public static float leerFloat(String mensaje){
        // 1. Paso numero uno, ubicar el origen de la información
        // 2. Conectarse al flujo de la información
        InputStreamReader isr = new InputStreamReader(System.in);
        // 3. Leer desde el flujo de información
        BufferedReader br = new BufferedReader(isr);
        String dato = null;
        try {
            
            System.out.println(mensaje);
            dato = br.readLine();
            
        } catch (IOException iOException) {
        }
        return Float.parseFloat(dato);
    }
}
