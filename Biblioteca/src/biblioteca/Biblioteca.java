package biblioteca;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Biblioteca {

    private RandomAccessFile raf;
    private final String FILE_NAME="Biblioteca.dat";

    private void writeLibro(int num, Libro libro) throws IOException {
        raf.seek(num * Libro.SIZE);
        byte[] record = libro.toBytes();
        raf.write(record);
    }

    private Libro readLibro(int num) throws IOException {
        raf.seek(num * Libro.SIZE);
        byte[] record = new byte[Libro.SIZE];
        raf.read(record);
        return Libro.fromBytes(record);
    }

    private void mostrar() throws IOException {
        raf.seek(0);
        System.out.println("Registros existentes:");
        System.out.println("---------------------");
        int numRecords = (int) (raf.length() / Libro.SIZE);
        for (int i = 0; i < numRecords; i++) {
            Libro libro = readLibro(i);
            System.out.println("Indice= "+i+" "+libro);
        }
        System.out.println("---------------------");
    }

   
     private void buscar() throws IOException {
        String titulo = LeerTeclado.leerString("Ingresa el título del libro: ");
   
        long numLibros = (int)(raf.length() / Libro.SIZE);
        for (int i = 0; i < numLibros; i++) {
            Libro libro = readLibro(i);
            if (libro.getTitulo().equals(titulo)) {
                System.out.println("El libro se encuentra en el índice " + i );
                 System.out.println(libro);
              
                return ;
            }
        }
       System.out.println("El libro no se encontró.");
    }

  
    private void eliminar(int num) throws IOException {
        if (num >= 0 && num < this.raf.length() / Libro.SIZE) {
            Libro libro = new Libro("", "", "", "", 0, 0, false, false, "", "");
            this.writeLibro(num, libro);
            System.out.println("Libro eliminado.");
        } else {
            System.out.println("Índice inválido.");
        }
    }


    public static void main(String[] args) {
        new Biblioteca().ejecutar();
    }

    public void ejecutar() {
        try {
             File file = new File(FILE_NAME);
            raf = new RandomAccessFile(file, "rw");
            int opcion;
            do {
                menu();
                opcion = LeerTeclado.leerInt("Ingrese opcion: ");
                switch (opcion) {
                    case 1:
                        
                           Libro L1 = new Libro("03/04/2023", "Roma"                   , "Marco Polo"               , "123345678901"  , 20,  600, false , true  , "09/04/2023"  , "Edgar");
                        Libro L2 = new Libro("20/04/2023", "Orgullo y prejuicio"    , "Jane Austen"              , "123345634567"  , 50,  800, true  , true  , "25/04/2023"  , "Diego");
                        Libro L3 = new Libro("30/04/2023", "Moby Dick"              , "Herman Melville"          , "122980125789"  , 60,  300, true  , false , "05/05/2023"  , "Ariel");
                        Libro L4 = new Libro("15/09/2023", "1984"                   , "George Orwell"            ,"9780451524935"  , 328, 26 , true  , false , "N/A"         ,   "N/A");
                       Libro L5 = new Libro("10/06/2023", "El amor en los T.C.", "Gabriel García Márquez", "9780307387264", 368, 250, true, false, "N/A", "N/A");
                        Libro L6 = new Libro("05/03/2023", "El principito", "Antoine de Saint-Exupéry", "9780156012195", 96, 150, false, true, "10/03/2023", "María");
                        Libro L7 = new Libro("20/06/2023", "El codigo Da Vinci"     , "Dan Brown"                , "9780307474278" , 592, 320, true  , true  , "15/07/2023"  ,"Carlos");
                        Libro L8 = new Libro("18/04/2023", "Harry Potter y la piedra filosofal", "J.K. Rowling"  , "9788478884458" , 352, 440, false , false , "N/A", "N/A");
                        Libro L9 = new Libro("10/05/2023", "Crimen y castigo"       , "Fyodor Dostoevsky"        , "9780140449136" , 576, 250, false , false , "N/A", "N/A");
                        Libro L10 = new Libro("22/08/2023", "Don Quijote de la Mancha", "Miguel de Cervantes"    , "9788420667602" ,1088, 400, true  , true  , "15/09/2023", "Laura");
                        Libro L11 = new Libro("12/07/2023", "Cien anios de Soledad"   , "Gabriel García "   , "9780307474728" , 431, 380, false , true  , "10/08/2023"  ,   "Ana");
                        this.writeLibro(0, L1);
                        this.writeLibro(1, L2);
                        this.writeLibro(2, L3);
                        this.writeLibro(3, L4);
                        this.writeLibro(4, L5);
                        this.writeLibro(5, L6);
                        this.writeLibro(6, L7);
                        this.writeLibro(7, L8);
                        this.writeLibro(8, L9);
                        this.writeLibro(9, L10);
                        this.writeLibro(10, L11);
                        System.out.println("Se agrego correctamente");
                        break;
                    case 2:
                        mostrar();
                        break;
                    case 3:
                       
                      buscar(); 
                        break;
                    case 4:
                        int numLibro = LeerTeclado.leerInt("Ingrese indice del libro: ");
                        eliminar(numLibro);
                        break;
                    case 5:
                        System.out.println("Fin del programa......");
                        break;
                }

            } while (opcion != 5);

            this.raf.close();

        } catch (Exception e) {
            System.out.println("Algo salio mal");
        }
    }

    private void menu() {
        System.out.println("\n----- MENU -----");
        System.out.println("1. Agregar libro");
        System.out.println("2. Mostrar registros");
        System.out.println("3. Buscar registro");
        System.out.println("4. Eliminar registro");
        System.out.println("5. Salir");
        System.out.println("-----------------\n");
    }

}
