/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiendapeliculas;

import Modelo.Pelicula;
import java.util.ArrayList;

/**
 * @author Rosales paez /Martinez Barradas
 * @version 1.5
 * fecha:12 octubre 2017*/
public class Carrito {

    private ArrayList<Pelicula> peliculas; //Contendor para las peliculas 
    
    /**
     *
     */
    public Carrito() {
        peliculas = new ArrayList<Pelicula>();
    }

   

    /**
     *
     * @param pelicula
     * @param numeroPeliculas
     * @return
     */

   public String addPelicula(Pelicula pelicula, int numeroPeliculas) {
        for (int i =0; i < numeroPeliculas; i++) {
            peliculas.add(pelicula);
        }
        return numeroPeliculas + " Peliculaw Agregadas";
    }
   
    /**
     *
     * @param pelicula
     * @return
     */
    public String deletPelicula(Pelicula pelicula){
       peliculas.remove(pelicula);
       return " Peliculaw Agregadas";
   }
}
