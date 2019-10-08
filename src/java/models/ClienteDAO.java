/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author mateo.llano
 */
import java.sql.Connection;
import db.DB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ClienteDAO {

    PreparedStatement ps = null;
    ResultSet rs = null;
    Connection conn = null;
    DB conexion = null;

    public boolean agregar(Cliente p) {

        try {
            conn = conexion.getConexion();
            String query = "INSERT INTO tbl_clientes (id_cliente, nombre_cliente, apellido_cliente, cel, tipoDocumento) values (?, ?, ?, ?, ?)";
            ps = conn.prepareStatement(query);
            ps.setString(1, p.getId()); 
            ps.setString(2, p.getName());
            ps.setString(3, p.getLastName());
            ps.setString(4, p.getCel());
            ps.setString(5, p.getTipoDocumento());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("no se hizo nada");
            return false;
        } finally { try { rs.close(); } catch (Exception e) { /* ignored */ }
        }
    }
}
