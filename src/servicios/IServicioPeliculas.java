package servicios;

// Importamos la clase Pelicula del paquete dominio
import dominio.Pelicula;

// Interfaz que define los métodos para el servicio de películas
public interface IServicioPeliculas {

    // Método para listar todas las películas
    // Debe ser implementado por cualquier clase que implemente esta interfaz
    public void listarPeliculas();
    
    // Método para agregar una nueva película
    // Recibe un objeto Pelicula como parámetro
    public void agregarPelicula(Pelicula pelicula);

    // Método para buscar una película específica
    // Recibe un objeto Pelicula como parámetro
    public void buscarPelicula(Pelicula pelicula);

}
