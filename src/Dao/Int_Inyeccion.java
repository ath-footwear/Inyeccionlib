/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Modelo.Inyeccion;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author GATEWAY1-
 */
public interface Int_Inyeccion {

    public ArrayList<String> getCombinacion(Connection c, String var);

    public ArrayList<String> getCorrida(Connection c, String var);
    
    Inyeccion getinfowith(Connection c, int lote);

    public boolean new_avanceinyeccion(Connection c, Inyeccion i);
    
    public boolean new_avancedetalle(Connection c, Inyeccion i);
}
