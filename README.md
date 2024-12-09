# Listado Peliculas

## Aplicación para gestionar un listado de películas.

**Para la graficacion del proyecto puede verlo en: [Grafico UML](IdeaProyecto.uxf)**

### Descripción
------
Esta aplicación permite agregar, listar y buscar películas en un listado. Se utiliza una interfaz de usuario sencilla para interactuar con el usuario.

### Características
------
    * Agregar películas al listado
    * Listar todas las películas en el listado
    * Buscar una película específica en el listado
    * Utiliza un archivo para almacenar el listado de películas

### Tecnologías utilizadas
------
    * Java como lenguaje de programación
    * Interfaz de usuario basada en consola

### Estructura del proyecto
------
* **dominio:** Paquete que contiene la clase Pelicula que representa una película.
* **servicios:** Paquete que contiene la interfaz IServicioPeliculas y la clase ServicioPeliculasLista que implementa la lógica para gestionar el listado de películas.
* **presentacion:** Paquete que contiene la clase CatallogoPeliculasApp que es la clase principal de la aplicación y contiene la lógica para interactuar con el usuario.

### Instrucciones para ejecutar la aplicación
------
```sh
    1- Compilar el proyecto utilizando el comando javac en la terminal.
    2- Ejecutar la clase CatallogoPeliculasApp utilizando el comando java en la terminal.
```

### Autor:
------
***Juan Marcos Orellana***

<sub>**Licencia**: Este proyecto está bajo la licencia [MIT](https://opensource.org/license/MIT).</sub>