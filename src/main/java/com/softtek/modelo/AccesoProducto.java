package com.softtek.modelo;

import com.softtek.persistencia.Conexion;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AccesoProducto extends Conexion {

    public List<Producto> obtenerTodos() throws SQLException, ClassNotFoundException {
        Statement sentencia;
        ResultSet resultado;
        String sql = "Select product_id, product_name, unit_price, units_in_stock from products;";
        List<Producto> productos = new ArrayList<>();
        abrirConexion();
        sentencia = miConexion.createStatement();
        resultado = sentencia.executeQuery(sql);
        while(resultado.next()){
            productos.add(new Producto(resultado.getInt("product_id"),
                    resultado.getString("product_name"),
                    resultado.getDouble("unit_price"),
                    resultado.getInt("units_in_stock") ));
        }

        miConexion.close();
        return productos;
    }


    public void crear() throws SQLException, ClassNotFoundException {
        abrirConexion();
        Statement sentencia;

        Producto p1 = new Producto(78, "Softtek Cafe", 1, 40);
        String sql = "INSERT INTO products(product_id, product_name, unit_price, units_in_stock, discontinued) VALUES (" + p1.getIdProducto() + ", '" + p1.getNombreProducto() + "',"
        +p1.getPrecioUnitario() + "," + p1.getUnidadesStock() + ",0)";
        sentencia = miConexion.createStatement();
        sentencia.executeUpdate(sql);
        miConexion.close();
    }

    public void delete() throws SQLException, ClassNotFoundException {
        abrirConexion();
        Statement sentencia;

        String sql = "DELETE FROM products where product_name = 'Softtek Cafe'";
        sentencia = miConexion.createStatement();
        sentencia.executeUpdate(sql);
        miConexion.close();
    }

    public void update() throws SQLException, ClassNotFoundException {
        abrirConexion();
        Statement sentencia;
        String sql = "UPDATE products SET product_name = 'Cafe etiopia' where product_name ='Softtek Cafe'";
        sentencia = miConexion.createStatement();
        sentencia.executeUpdate(sql);

    }


}
