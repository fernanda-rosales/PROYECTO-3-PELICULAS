/*
*Este clase  va hacer referncia a un objeto de la lista que es una pelicula
 */
package Modelo;

/**
 * @author Rosales paez /Martinez Barradas
 * @version 1.5
 * fecha:12 octubre 2017*/
public class Pelicula { 
    
    //Campos de la clase
    private String codigo; //Codigo de barras para identificar de manera unica
    private String titulo; //titulo de la pelicula
    private String director; //nombre del director de la pelicula
    private String actor_Prin; //nombrel del actor principal de la pelicula
    private String genero; //genero de la pelicula
    private float precio; // precio de la pelicula
    private String imagen; //imagen de la portada de la pelicula

     /*
     * Constructor
     */
    public Pelicula(String codigo, String titulo, String director, String actor_Prin, String genero, float precio, String imagen) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.director = director;
        this.actor_Prin = actor_Prin;
        this.genero = genero;
        this.precio = precio;
        this.imagen = imagen;
    }

    /**
     * @return the codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the autor
     */
    public String getDirector() {
        return director;
    }

    /**
     * @param autor the autor to set
     */
    public void setAutor(String autor) {
        this.director = autor;
    }

    /**
     * @return the actor_Prin
     */
    public String getActor_Prin() {
        return actor_Prin;
    }

    /**
     * @param actor_Prin the actor_Prin to set
     */
    public void setActor_Prin(String actor_Prin) {
        this.actor_Prin = actor_Prin;
    }

    /**
     * @return the genero
     */
    public String getGenero() {
        return genero;
    }

    /**
     * @param genero the genero to set
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }

    /**
     * @return the precio
     */
    public float getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(float precio) {
        this.precio = precio;
    }  //Cierre de la metodo setPrecio

    /**
     * @return the imagen
     */
    public String getImagen() {
        return imagen;
    }

    /**
     * @param imagen the imagen to set
     */
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    
}//Cierre de la clase
