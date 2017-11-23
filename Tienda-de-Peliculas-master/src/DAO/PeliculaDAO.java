/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * @author Rosales paez /Martinez Barradas
 * version 1.5
 * fecha:12 octubre 2017*/
package DAO;

import Conexion.Conexion;
import Modelo.Pelicula;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.rowset.serial.SerialBlob;


public class PeliculaDAO {

    Conexion conn; // variable para realizar la conexion a la bd
    private static PreparedStatement pState = null; //se usa para las sentencias SQL  

    Connection conexion;//crea un objeto de la bd para que puede proporcionar información de sus tablas
    Statement st;// se declara un objeto 

    /** Contructor PeliculasDAO se crea la conexion a la base de datos*/
    public PeliculaDAO() {
        conn = new Conexion();
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            String bDatos = "jdbc:oracle:thin:@localhost:1521:XE";
            conexion = DriverManager.getConnection(bDatos, "system", "oracle");
            st = conexion.createStatement();// se crean objetos Statement para pasar sentencias SQL a la base de datos
            System.out.println("En linea");
        } catch (Exception ex) {
            Logger.getLogger(PeliculaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /** este metodo que guarda la imagen que se inserta en la tabla desde la interfaz a la bd*/
    public boolean guardarImagen(Pelicula pelicula){
        String insert = "insert into TP_PELICULAS(CODIGO,TITULO,DIRECTOR,ACTOR_PRIN,GENERO,PRECIO,IMAGEN) values(?,?,?,?,?,?,?)";
        FileInputStream fis = null;
        PreparedStatement ps = null;
        try {
            conexion.setAutoCommit(false);// si todas sus declaraciones SQL se ejecutan
            File file = new File(pelicula.getImagen());
            fis = new FileInputStream(file);
            ps = conexion.prepareStatement(insert);//Creamos un objeto PreparedStatement desde el objeto Connection
            //Seteamos los datos al prepared statement de la siguiente forma:
            ps.setString(1, pelicula.getCodigo());
            ps.setString(2, pelicula.getTitulo());
            ps.setString(3, pelicula.getDirector());
            ps.setString(4, pelicula.getActor_Prin());
            ps.setString(5, pelicula.getGenero());
            ps.setFloat(6, pelicula.getPrecio());
            ps.setBinaryStream(7,fis,(int)file.length());
            // se modifica el metodo update de tal forma que no se le pasan argumentos
            ps.executeUpdate();
            conexion.commit();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(PeliculaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }finally{
            try {
                ps.close();
                fis.close();
            } catch (Exception ex) {
                Logger.getLogger(PeliculaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }        
    }
    /** este método obtiene los datos de columna correspondientes a peliculas*/
    public ResultSet VerPelicula() {
        try {
            Connection accesoBD = conn.getConexion();
            String sql = "SELECT * FROM TP_PELICULAS";
            Statement consulta = accesoBD.createStatement();
            return consulta.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(PeliculaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
 /** este método obtiene los datos de columna correspondientes a peliculas dependiendo de su codigo identificador*/   
    public ResultSet ClickPelicula(String codigo) {
        try {
            Connection accesoBD = conn.getConexion();
            String sql = "SELECT * FROM TP_PELICULAS WHERE CODIGO=" + "'" + codigo + "'";
            Statement consulta = accesoBD.createStatement();
            return consulta.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(PeliculaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

//     public boolean ExisteUsuario(String usuario) {
//        try {
//            Connection accesoBD = conn.getConexion();
//            String sql = "SELECT ID_TIPO_USU FROM PF_LOGIN "
//                    + "WHERE ID_USUARIO = '" + usuario + "' ";
//            Statement consulta = accesoBD.createStatement();
//            ResultSet resultado = consulta.executeQuery(sql);
//            if (resultado.next()) {
//                return true;
//            } else {
//                return false;
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(PeliculaDAO.class.getName()).log(Level.SEVERE, null, ex);
//            return false;
//        }
//    }
//     public int numeroUsuarios() {
//        try {
//            Connection accesoBD = conn.getConexion();
//            String sql = "SELECT COUNT(*) AS NUMUSU FROM PF_USUARIO";
//            Statement consulta = accesoBD.createStatement();
//            ResultSet resultado = consulta.executeQuery(sql);
//            if (resultado.next()) {
//                return resultado.getInt("NUMUSU");
//            } else {
//                return 0;
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(PeliculaDAO.class.getName()).log(Level.SEVERE, null, ex);
//            return 0;
//        }
//    }
    
    /** este método borra de la bd la pelicula que sea correspondiente al codigo ingresado*/
    public String BorrarPelicula(String codigo) {
        try {
            Connection accesoBD = conn.getConexion();
            String sql2 = "DELETE FROM TP_PELICULAS WHERE CODIGO = '" + codigo + "'";
            Statement consulta = accesoBD.createStatement();
            consulta.executeQuery(sql2);
//            consulta.executeQuery(sql);
            return "Pelicula borrado correctamente";
        } catch (SQLException ex) {
            Logger.getLogger(PeliculaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return "ERROR : ocurrio un erro al borrar Pelicula";
        }
    }

//       public String ModificarUsuario(Usuario miUsuario) {
//
//        try {
//            Connection accesoBD = conn.getConexion();
//            String sql = "UPDATE PF_USUARIO SET "
//                    + "ID_RUB_DEL = '" + miUsuario.getIdRubro() + "', "
//                    + "NOMBRE = '" + miUsuario.getpNombres() + "', "
//                    + "SNOMBRE = '" + miUsuario.getsNombres() + "', "
//                    + "PATERNO = '" + miUsuario.getpApellido() + "', "
//                    + "MATERNO = '" + miUsuario.getmApellido() + "', "
//                    + "CORREO = '" + miUsuario.getCorreo() + "', "
//                    + "ESCOLARIDAD = '" + miUsuario.getEscolaridad() + "', "
//                    + "FEC_NACIMIENTO = TO_DATE('" + miUsuario.getFechaNacimiento() + "', 'yyyy/mm/dd'), "
//                    + "CALLE = '" + miUsuario.getCalle() + "', "
//                    + "NUM_INT = " + miUsuario.getNumInt() + ", "
//                    + "COLONIA = '" + miUsuario.getColonia() + "', "
//                    + "CP = " + miUsuario.getCp() + " "
//                    + " WHERE ID_USUARIO = '" + miUsuario.getIdUsuario() + "' ";
//
////            String sql2 = "UPDATE PF_LOGIN SET "
////                    + "ID_USUARIO = '" + miUsuario.getIdUsuario() + "', "
////                    + "ID_TIPO_USU = " + miUsuario.getPerfil() + ","
////                    + "CLAVE = '" + miUsuario.getContraseña() + "' "
////                    + "WHERE ID_USUARIO = '" + miUsuario.getIdUsuario() + "' ";
//            
//            Statement consulta = accesoBD.createStatement();
//            consulta.executeUpdate(sql);
////            consulta.executeUpdate(sql2);
//            return "Ususarios modificado correctamente";
//        } catch (SQLException ex) {
//            Logger.getLogger(PeliculaDAO.class.getName()).log(Level.SEVERE, null, ex);
//            return "Ocurrio un error para modificar un usuario";
//        }
//    }
}
