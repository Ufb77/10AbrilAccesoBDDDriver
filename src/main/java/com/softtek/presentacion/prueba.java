package com.softtek.presentacion;

import com.softtek.modelo.AccesoProducto;
import com.softtek.modelo.Producto;
import com.softtek.persistencia.Conexion;

import java.sql.SQLException;

public class prueba {
    public static void main(String[] args) {

        AccesoProducto a1 = new AccesoProducto();


        try {



            a1.delete(78);



            for (Producto productos: a1.obtenerTodos()
                 ) {
                System.out.println(productos);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



}
