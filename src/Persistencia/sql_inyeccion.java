/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Modelo.Inyeccion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author GATEWAY1-Michel araujo Es importante tomar en cuenta que la conexion
 * se finaliza al terminar el proceso y no tener siempre una conexion activa.
 */
public class sql_inyeccion {

    public ArrayList<String> getcombinaciones(Connection c, String estilo) {
        ArrayList<String> arr = new ArrayList<>();
        try {
            PreparedStatement st;
            ResultSet rs;
            String sql = "select distinct combinacion\n"
                    + "from programa\n"
                    + "where estilo=?\n"
                    + "group by combinacion\n"
                    + "order by combinacion";
            st = c.prepareStatement(sql);
            st.setInt(1, Integer.parseInt(estilo));
            rs = st.executeQuery();
            while (rs.next()) {
                arr.add(rs.getString("combinacion"));
            }
            rs.close();
            st.close();
            c.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            Logger.getLogger(sql_inyeccion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }

    public ArrayList<String> getcorridas(Connection c, String estilo) {
        ArrayList<String> arr = new ArrayList<>();
        try {
            PreparedStatement st;
            ResultSet rs;
            String sql = "select distinct corrida\n"
                    + "from programa\n"
                    + "where estilo=?\n"
                    + "group by corrida\n"
                    + "order by corrida";
            st = c.prepareStatement(sql);
            st.setInt(1, Integer.parseInt(estilo));
            rs = st.executeQuery();
            while (rs.next()) {
                arr.add(rs.getString("corrida"));
            }
            rs.close();
            st.close();
            c.close();
        } catch (SQLException ex) {
            Logger.getLogger(sql_inyeccion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }

    public boolean newAvanceinyeccion(Connection c, Inyeccion i) {
        try {
            c.setAutoCommit(false);
            PreparedStatement st;
            String sql="insert into inyeccion(estilo,combinacion,pares,corrida,fecha,estatus) "
                    + "values(?,?,?,?,?,?)";
            st=c.prepareStatement(sql);
            st.setInt(1, i.getEstilo());
            st.setString(2, i.getCombinacion());
            st.setInt(3, i.getPares());
            st.setInt(4, i.getCorrida());
            st.setString(5, i.getFecha());
            st.setString(6, "1");
            st.executeUpdate();
            c.commit();
            st.close();
            return true;
        } catch (SQLException ex) {
            try {
                c.rollback();
                Logger.getLogger(sql_inyeccion.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex1) {
                Logger.getLogger(sql_inyeccion.class.getName()).log(Level.SEVERE, null, ex1);
            }
            return false;
        } finally {
            try {
                c.close();
            } catch (SQLException ex1) {
                Logger.getLogger(sql_inyeccion.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }

}
