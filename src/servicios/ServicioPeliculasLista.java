package servicios;

// Importamos la clase Pelicula del paquete dominio
import dominio.Pelicula;

// Importamos las clases necesarias para trabajar con listas
import java.util.ArrayList;
import java.util.List;

// Clase que implementa la interfaz IServicioPeliculas utilizando una lista
public class ServicioPeliculasLista implements IServicioPeliculas{

    // Lista de películas
    private final List<Pelicula> peliculas;

    // Constructor que inicializa la lista de películas
    public ServicioPeliculasLista(){
        this.peliculas = new ArrayList<>();
    }

    // Método para listar todas las películas
    @Override
    public void listarPeliculas() {
        // Imprimimos un título para el listado de películas
        System.out.println("Listado de Peliculas: ");
        
        // Recorremos la lista de películas e imprimimos cada una
        peliculas.forEach(System.out::println);
    }

    // Método para agregar una nueva película a la lista
    @Override
    public void agregarPelicula(Pelicula pelicula) {
        // Agregamos la película a la lista
        peliculas.add(pelicula);
        
        // Imprimimos un mensaje para confirmar que se agregó la película
        System.out.println("Se agregó la película: " + pelicula);
    }

    // Método para buscar una película específica en la lista
    @Override
    public void buscarPelicula(Pelicula pelicula) {
        // Buscamos la película en la lista y obtenemos su índice
        var indice = peliculas.indexOf(pelicula);
        
        // Si la película no se encontró, imprimimos un mensaje de error
        if(indice == -1)
            System.out.println("No se encontró la película: " + pelicula);
        // Si la película se encontró, imprimimos su índice
        else
            System.out.println("Película encontrada en el índice: " + indice);
    }
}
