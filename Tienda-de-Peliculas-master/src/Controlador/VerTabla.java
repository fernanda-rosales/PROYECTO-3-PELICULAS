/**
 * @author Rosales paez /Martinez Barradas
 * @version 1.5
 * fecha:12 octubre 2017*/
package Controlador;

import DAO.PeliculaDAO;
import Conexion.Conexion;
import Modelo.DetalleCarrito;
import Utilidades.RedimensionadorDeColumnas;
import Utilidades.TablaImagen;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class VerTabla {

    private DefaultTableModel miTabla;//propiedades de la tabla
/** crea la tabla del panel 1 y se conecta a la base de datos */
    public void visualizar_tabla(JTable tabla) {
        Conexion conn = new Conexion();
        Connection con = conn.getConexion();
        PeliculaDAO peliculaConeccion = new PeliculaDAO();
        ResultSet rs = peliculaConeccion.VerPelicula();
        //Image img = null;   
        tabla.setDefaultRenderer(Object.class, new TablaImagen());
        DefaultTableModel dt = new DefaultTableModel();
        dt.addColumn("Codigo");
        dt.addColumn("Nombre");
        dt.addColumn("Foto");

        try {

            while (rs.next()) {
                Object[] fila = new Object[7];
                fila[0] = rs.getObject(1);
                fila[1] = rs.getObject(2);

                Blob blob = rs.getBlob(7);

                if (blob != null) {
                    try {
                        byte[] data = blob.getBytes(1, (int) blob.length());
                        BufferedImage img = null;
                        try {
                            img = ImageIO.read(new ByteArrayInputStream(data));

                            img = resize(img, 200, 250);

                        } catch (Exception ex) {
                            System.out.println(ex.getMessage());
                        }
                        ImageIcon icono = new ImageIcon(img);
                        fila[2] = new JLabel(icono);
                    } catch (Exception ex) {
                        fila[2] = "No Imagen";
                    }
                } else {
                    fila[2] = "No Imagen";
                }

                dt.addRow(fila);
            }

            tabla.setModel(dt);
            RedimensionadorDeColumnas.ajustarAnchoColumnas(tabla);
            tabla.setRowMargin(5);
            tabla.setRowHeight(250);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }
/** crea la tabla del panel 3 y redimensiona la tabla */
    public void visualizar_tabla2(JTable tabla, ArrayList<DetalleCarrito> carrito) {
        DetalleCarrito detCarri;

        tabla.setDefaultRenderer(Object.class, new TablaImagen());
        DefaultTableModel dt = new DefaultTableModel();
        dt.addColumn("Codigo");
        dt.addColumn("Nombre");
        dt.addColumn("Cantidad");
        dt.addColumn("Precio");
        dt.addColumn("Subtotal");

        try {

            Iterator<DetalleCarrito> detPeli = carrito.iterator();
            while (detPeli.hasNext()) {
                detCarri = detPeli.next();
                Object[] fila = new Object[5];
                fila[0] = detCarri.getCodigo();
                fila[1] = detCarri.getNombre();
                fila[2] = "" + detCarri.getCantidad();
                fila[3] = "" + detCarri.getPrecio();
                fila[4] = "" + detCarri.getSubtotal();

                Blob blob = null;

                if (blob != null) {
                    try {
                        byte[] data = blob.getBytes(1, (int) blob.length());
                        BufferedImage img = null;
                        try {
                            img = ImageIO.read(new ByteArrayInputStream(data));

                            img = resize(img, 200, 250);

                        } catch (Exception ex) {
                            System.out.println(ex.getMessage());
                        }
                        ImageIcon icono = new ImageIcon(img);
                        fila[2] = new JLabel(icono);
                    } catch (Exception ex) {
                        fila[2] = "No Imagen";
                    }
                } else {
//                    fila[2] = "No Imagen";
                }

                dt.addRow(fila);
            }

            tabla.setModel(dt);
            RedimensionadorDeColumnas.ajustarAnchoColumnas(tabla);
            tabla.setRowMargin(5);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }

    }
/** Metodo que le da un resize determinado por default ,a las imagenes que ingresa el usuario 
 @return bufim regresa este objeto que hace representación de una imagen en memoria  */
    public static BufferedImage resize(BufferedImage bufferedImage, int newW, int newH) {
        int w = bufferedImage.getWidth();
        int h = bufferedImage.getHeight();
        BufferedImage bufim = new BufferedImage(newW, newH, bufferedImage.getType());
        Graphics2D g = bufim.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g.drawImage(bufferedImage, 0, 0, newW, newH, 0, 0, w, h, null);
        g.dispose();
        return bufim;
    }

}
