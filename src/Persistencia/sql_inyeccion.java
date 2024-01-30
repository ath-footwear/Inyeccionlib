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

    /**
     * Funcion que solo se utiliza para finalizar la conexion sin repetir tanto
     * codigo
     * @param c 
     */
    private void cerrarbd(Connection c) {
        try {
            c.close();
        } catch (SQLException ex) {
            Logger.getLogger(sql_inyeccion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

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
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            Logger.getLogger(sql_inyeccion.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            cerrarbd(c);
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
        } catch (SQLException ex) {
            Logger.getLogger(sql_inyeccion.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            cerrarbd(c);
        }
        return arr;
    }

    public Inyeccion getinfowith(Connection c, int lote) {
        Inyeccion I = null;
        try {
            PreparedStatement st;
            ResultSet rs;
            String sql = "select max(id_prog) id_prog,estilo,corrida,combinacion,corridacpt,years\n"
                    + "from programa\n"
                    + "where lote =?\n"
                    + "group by estilo,corrida, combinacion,corridacpt,years";
//            System.out.println(sql);
            st = c.prepareStatement(sql);
            st.setInt(1, lote);
            rs = st.executeQuery();
            while (rs.next()) {
                I = new Inyeccion();
                I.setId_prog(rs.getInt("id_prog"));
                I.setEstilo(rs.getInt("estilo"));
                I.setCorrida(rs.getInt("corrida"));
                I.setCombinacion(rs.getString("combinacion"));
                I.setCorridacpt(rs.getInt("corridacpt"));
                I.setPeriodo(rs.getInt("years"));
                I.setLote(lote);
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(sql_inyeccion.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cerrarbd(c);
        }
        return I;
    }

    public boolean newAvanceinyeccion(Connection c, Inyeccion i) {
        try {
            c.setAutoCommit(false);
            PreparedStatement st;
            String sql = "insert into inyeccion(id_prog,lote,estilo,combinacion,pares,corrida,fecha,estatus) "
                    + "values(?,?,?,?,?,?,?,?)";
            st = c.prepareStatement(sql);
            st.setInt(1, i.getId_prog());
            st.setInt(2, i.getLote());
            st.setInt(3, i.getEstilo());
            st.setString(4, i.getCombinacion());
            st.setInt(5, i.getPares());
            st.setInt(6, i.getCorrida());
            st.setString(7, i.getFecha());
            st.setString(8, "1");
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
            cerrarbd(c);
        }
    }

}
