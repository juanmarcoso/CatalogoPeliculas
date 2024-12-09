// Paquete donde se encuentra la clase Pelicula
package dominio;

// Clase que representa una película
public class Pelicula {

    // Atributo que almacena el nombre de la película
    private String nombre;

    // Constructor vacío para crear objetos Pelicula sin inicializar el nombre
    public Pelicula(){}

    // Constructor que inicializa el nombre de la película
    public Pelicula(String nombre){
        this.nombre = nombre;
    }

    // Método getter para obtener el nombre de la película
    public String getNombre() {
        return nombre;
    }

    // Método setter para modificar el nombre de la película
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Método hashCode para generar un código hash único para cada objeto Pelicula
    @Override
    public int hashCode() {
        // Constante prima para calcular el hash
        final int prime = 31;
        int result = 1;
        // Calculamos el hash basado en el nombre de la película
        result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
        return result;
    }

    // Método equals para comparar si dos objetos Pelicula son iguales
    @Override
    public boolean equals(Object obj) {
        // Si el objeto es el mismo, devuelve true
        if (this == obj)
            return true;
        // Si el objeto es null, devuelve false
        if (obj == null)
            return false;
        // Si la clase del objeto no es Pelicula, devuelve false
        if (getClass() != obj.getClass())
            return false;
        // Castear el objeto a Pelicula
        Pelicula other = (Pelicula) obj;
        // Comparamos el nombre de la película
        if (nombre == null) {
            if (other.nombre != null)
                return false;
        } else if (!nombre.equals(other.nombre))
            return false;
        return true;
    }

    // Método toString para obtener una representación en cadena de la película
    @Override
    public String toString() {
        return this.nombre;
    }

}