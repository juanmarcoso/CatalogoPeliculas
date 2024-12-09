package servicios;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

import dominio.Pelicula;

public class ServicioPeliculasArchivo implements IServicioPeliculas {

    // Constante que representa el nombre del archivo donde se almacenarán las películas
    private final String NOMBRE_ARCHIVO = "peliculas.txt";

    // Constructor de la clase ServicioPeliculasArchivo
    public ServicioPeliculasArchivo() {

        // Creamos un objeto File para representar el archivo que contiene las películas
        var archivo = new File(NOMBRE_ARCHIVO);

        try {
            
            // Verificamos si el archivo ya existe
            if (archivo.exists()) {

                // Si ya existe, imprimimos un mensaje para indicarlo
                System.out.println("El archivo ya existe! ");

            } else {

                // Si no existe, creamos un nuevo archivo vacío
                var salida = new PrintWriter(new FileWriter(archivo));

                // Es importante cerrar el archivo para asegurarnos de que se guarde en el disco
                salida.close();

                // Imprimimos un mensaje para indicar que se creó el archivo
                System.out.println("Se ha creado el archivo");
            }
        } catch (Exception e) {
            // Si ocurre un error al abrir o crear el archivo, imprimimos un mensaje de
            // error
            System.out.println("Ocurrió un error al abrir el archivo: " + e.getMessage());
        }
    }

    // Este método se utiliza para listar todas las películas almacenadas en el
    // archivo
    @Override
    public void listarPeliculas() {

        // Creamos un objeto File para representar el archivo que contiene las películas
        var archivo = new File(NOMBRE_ARCHIVO);

        try {
            // Imprimimos un título para el listado de películas
            System.out.println("Listado de Peliculas");

            // Abrimos el archivo para lectura
            var entrada = new BufferedReader(new FileReader(archivo));

            // Leemos la primera línea del archivo
            String linea;
            linea = entrada.readLine();

            // Continuamos leyendo el archivo línea por línea hasta llegar al final
            while (linea != null) {
                // Creamos un objeto Pelicula a partir de la línea leída
                var pelicula = new Pelicula(linea);

                // Imprimimos la información de la película
                System.out.println(pelicula);

                // Leemos la siguiente línea del archivo
                linea = entrada.readLine();
            }

            // Cerramos el archivo para liberar recursos
            entrada.close();
        } catch (Exception e) {
            // Si ocurre un error al abrir o leer el archivo, imprimimos un mensaje de error
            System.out.println("Ocurrió un error al abrir el archivo: " + e.getMessage());
        }
    }

    // Este método se utiliza para agregar una nueva película al archivo
    @Override
    public void agregarPelicula(Pelicula pelicula) {
        // Indicamos si el archivo ya existe y debemos anexar la nueva película
        boolean anexar = false;

        // Creamos un objeto File para representar el archivo que contiene las películas
        var archivo = new File(NOMBRE_ARCHIVO);

        try {
            // Revisamos si el archivo ya existe
            anexar = archivo.exists();

            // Creamos un objeto PrintWriter para escribir en el archivo
            var salida = new PrintWriter(new FileWriter(archivo, anexar));

            // Agregamos la nueva película al archivo
            salida.println(pelicula.toString());

            // Cerramos el archivo para liberar recursos
            salida.close();

            // Imprimimos un mensaje para confirmar que la película se agregó correctamente
            System.out.println("Se agregó al archivo: " + pelicula);

        } catch (Exception e) {
            // Si ocurre un error al agregar la película, imprimimos un mensaje de error
            System.out.println("Ocurrió un error al agregar película: " + e.getMessage());
        }
    }

    // Este método se utiliza para buscar una película específica en el archivo
    @Override
    public void buscarPelicula(Pelicula pelicula) {

        // Creamos un objeto File para representar el archivo que contiene las películas
        var archivo = new File(NOMBRE_ARCHIVO);

        try {
            // Abrimos el archivo para lectura línea a línea
            var entrada = new BufferedReader(new FileReader(archivo));

            // Leemos la primera línea del archivo
            String lineaTexto;
            lineaTexto = entrada.readLine();

            // Inicializamos variables para llevar un registro de la búsqueda
            var indice = 1; // Número de línea actual
            var encontrada = false; // Indica si se encontró la película
            var peliculaBuscar = pelicula.getNombre(); // Nombre de la película a buscar

            // Recorremos el archivo línea a línea hasta encontrar la película o llegar al
            // final
            while (lineaTexto != null) {
                // Buscamos la película sin importar mayúsculas o minúsculas
                if (peliculaBuscar != null && peliculaBuscar.equalsIgnoreCase(lineaTexto)) {
                    encontrada = true; // Indicamos que se encontró la película
                    break; // Salimos del ciclo
                }

                // Leemos la siguiente línea del archivo para la próxima iteración
                lineaTexto = entrada.readLine();
                indice++; // Incrementamos el número de línea
            }

            // Imprimimos los resultados de la búsqueda
            if (encontrada) {
                System.out.println("Pelicula: " + lineaTexto + ". Encontrada - línea: " + indice);
            } else {
                System.out.println("No se encontró la película: " + pelicula.getNombre());
            }

            // Cerramos el archivo para liberar recursos
            entrada.close();

        } catch (Exception e) {
            // Si ocurre un error durante la búsqueda, imprimimos un mensaje de error
            System.out.println("Ocurrió un error al buscar la película: " + e.getMessage());
        }
    }

}
