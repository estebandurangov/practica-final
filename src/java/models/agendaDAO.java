/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Connection;
import db.DB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Duran
 */
public class agendaDAO {
    PreparedStatement ps = null;
    ResultSet rs = null;
    Connection conn = null;
    DB conexion = null;

    public void agregar(agenda cita) {

        try {
            conn = DB.getConexion();
            String query = "INSERT INTO tbl_agenda (anio, mes, dia, hora) values (?, ?, ?, ?)";
            ps = conn.prepareStatement(query);
            ps.setString(1, cita.getAnio()); 
            ps.setString(2, cita.getMes());
            ps.setString(3, cita.getDia());
            ps.setString(4, cita.getHora());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("no se hizo nada");
        } finally { try { rs.close(); } catch (Exception e) { /* ignored */ }
        }
    }
    
    public List listar(String dia, String mes, String anio){
        ArrayList<agenda> list = new ArrayList<>();
        String sql = "SELECT * FROM `tbl_agenda` WHERE clientes_id_cliente IS NULL AND mes='"+mes+"' AND dia='"+dia+"' AND anio='"+anio+"'";
        try {
            conn = DB.getConexion();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                agenda agen = new agenda();
                agen.setId(rs.getString("id_cita"));
                agen.setAnio(rs.getString("anio"));
                agen.setMes(rs.getString("mes"));
                agen.setDia(rs.getString("dia"));
                agen.setHora(rs.getString("hora"));
                list.add(agen);
            }
        } catch (Exception e) {
        }
        
        return list;
        
    }
    
    public String buscarCel(String cel){
        String sql = "SELECT id_cliente FROM tbl_clientes WHERE cel='"+cel+"'";
        try {
            conn = DB.getConexion();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            rs.next();
            return rs.getString("id_cliente");
            
        } catch (Exception e) {
        }
        return "";
    }
    
    public boolean reservar(String id_Cita, String cel){
        String id_cliente = buscarCel(cel);
        if (id_cliente.length()==0)return false;
        String sql = "UPDATE tbl_agenda SET clientes_id_cliente='"+id_cliente+"' WHERE id_cita='"+id_Cita+"' ";
        try {
            conn = DB.getConexion();
            ps = conn.prepareStatement(sql);
            ps.executeUpdate();
            return true;
            
        } catch (Exception e) {
            return false;
        }
    }
}
