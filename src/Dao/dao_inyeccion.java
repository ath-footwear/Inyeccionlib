/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Modelo.Inyeccion;
import Persistencia.sql_inyeccion;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author GATEWAY1-
 */
public class dao_inyeccion implements Int_Inyeccion {

    private final sql_inyeccion s= new sql_inyeccion();

    /**
     * Obtiene todas las combinaciones de acuerdo al estilo
     *
     * @param c
     * @param var
     * @return
     */
    @Override
    public ArrayList<String> getCombinacion(Connection c, String var) {
        return s.getcombinaciones(c, var);
    }

    /**
     * Obtiene todas las combinaciones de acuerdo al estilo
     *
     * @param c
     * @param var
     * @return
     */
    @Override
    public ArrayList<String> getCorrida(Connection c, String var) {
        return s.getcorridas(c, var);
    }

    /**
     * Agrega un nuevo avance de inyeccion de acuerdo al objeto de tipo
     * inyeccion
     *
     * @param c
     * @param i
     * @return
     */
    @Override
    public boolean new_avanceinyeccion(Connection c, Inyeccion i) {
        return s.newAvanceinyeccion(c, i);
    }

}
