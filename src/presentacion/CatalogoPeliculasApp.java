package presentacion;

// Importamos las clases necesarias
import java.util.Scanner;

import dominio.Pelicula;
import servicios.IServicioPeliculas;
import servicios.ServicioPeliculasArchivo;
// import servicios.ServicioPeliculasLista; // Ya no es necesaria. Es donde empezamos

// Clase principal de la aplicación
public class CatalogoPeliculasApp {
    // Método main donde se inicia la aplicación
    public static void main(String[] args) throws Exception {
        
        // Variable para controlar si se debe salir de la aplicación
        var salir = false;
        
        // Creamos un objeto Scanner para leer la entrada del usuario
        var teclado = new Scanner(System.in);

        // Instanciamos el servicio de películas, en este caso utilizando un archivo
        //IServicioPeliculas servicioPeliculas = new ServicioPeliculasLista();
        IServicioPeliculas servicioPeliculas = new ServicioPeliculasArchivo();

        // Ciclo principal de la aplicación
        while (!salir){
            try {
                // Mostramos el menú de opciones
                mostrarMenu();
                
                // Ejecutamos la opción seleccionada por el usuario
                salir = ejecutarOpciones(teclado, servicioPeliculas);
            } catch (Exception e){
                // Si ocurre un error, mostramos un mensaje de error
                System.out.println("Ocurrió un error: " + e.getMessage());
            }
            // Imprimimos un espacio en blanco para separar las iteraciones
            System.out.println();
        } // Fin while

        // Cerramos el objeto Scanner para liberar recursos
        teclado.close();
    }

    // Método para mostrar el menú de opciones
    private static void mostrarMenu(){

        // Imprimimos el menú de opciones
        System.out.print("""
                *** Catalogo de Peliculas ***
                1. Agregar películas
                2. Listar películas
                3. Buscar películas 
                4. Salir

                Elige una opción: 
                """);
    }

    // Método para ejecutar la opción seleccionada por el usuario
    private static boolean ejecutarOpciones(Scanner teclado, IServicioPeliculas servicioPeliculas){

        // Leemos la opción seleccionada por el usuario
        var opcion = Integer.parseInt(teclado.nextLine());
        
        // Variable para controlar si se debe salir de la aplicación
        var salir = false;

        // Switch para ejecutar la opción seleccionada
        switch (opcion) {
            case 1:
                // Opción para agregar una película
                System.out.println("Introduce el nombre de la película: ");
                var nombrePelicula = teclado.nextLine();
                servicioPeliculas.agregarPelicula(new Pelicula(nombrePelicula));                
                break;
            
            case 2:
                // Opción para listar las películas
                servicioPeliculas.listarPeliculas();
                break;

            case 3:
                // Opción para buscar una película
                System.out.println("Introduce la película a buscar: ");
                var buscar = teclado.nextLine();
                servicioPeliculas.buscarPelicula(new Pelicula(buscar));
                break;

            case 4:
                // Opción para salir de la aplicación
                System.out.println("Hasta pronto!!");
                salir = true;
                break;
        
            default:
                // Opción no reconocida
                System.out.println("Opción no reconocida: " + opcion);
                break;
        }

        // Devolvemos la variable salir para controlar el ciclo principal
        return salir;

    }
}