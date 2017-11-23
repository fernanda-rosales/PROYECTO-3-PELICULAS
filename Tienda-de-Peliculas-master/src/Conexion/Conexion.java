/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @author Rosales paez /Martinez Barradas
 * @version 1.5
 * fecha:12 octubre 2017*/
package Conexion;


import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *Esta clase sirve para conectar la base de datos de Oracle al programa.
 */
public class Conexion {

    static Connection conn = null; //variable estatica conn para la base de datos  
    /**
     *Constructor Sin parametros de entrada
     */
    public Conexion() {
    }

    /**
     *Regresa la conexion y retorna el DriveMangaer que 
     *contiene la direccion de la BD, contraseña y usuario de la BD.
     * @return conn
     */
    public Connection getConexion() {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            String bDatos = "jdbc:oracle:thin:@localhost:1521:XE";
            conn = DriverManager.getConnection(bDatos, "system", "oracle");
            System.out.println("En linea");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }
}
