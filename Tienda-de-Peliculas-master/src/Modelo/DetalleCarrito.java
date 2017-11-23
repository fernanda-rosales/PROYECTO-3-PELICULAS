/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * @author Rosales paez /Martinez Barradas
 * @version 1.5
 * fecha:12 octubre 2017*/

package Modelo;


public class DetalleCarrito {
    
    String codigo; //codigo unico que identifica a cada una de las peliculas
    String nombre; //nombre de la pelicula que se va a comprar
    int cantidad; //numero de peliculas que quiere de esa pelicula
    float precio; // precio de cada pelicula
    float subtotal; //precio total por la cantidad de pelicula que se llevan de cada una

    /**
     * metodo contructor con sus parametros de entrada 
     * @param codigo 
     * @param nombre
     * @param cantidad
     * @param precio
     * @param subtotal
     */
    public DetalleCarrito(String codigo, String nombre, int cantidad, float precio, float subtotal) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
        this.subtotal = subtotal;
    }

    /**
     *
     * metodo que regresa @return subtotal
     */
    public float getSubtotal() {
        return subtotal;
    }

    /**
     *
     * @param subtotal
     */
    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }
    
    /**
     *
     * @return codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     *
     * @param codigo
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     *
     * metodo que regresa @return nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     *
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     *
     * @return cantidad
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     *
     * @param Cantidad
     */
    public void setCantidad(int Cantidad) {
        this.cantidad = Cantidad;
    }

    /**
     *
     * @return precio
     */
    public float getPrecio() {
        return precio;
    }

    /**
     *
     * @param precio
     */
    public void setPrecio(float precio) {
        this.precio = precio;
    }  
}
