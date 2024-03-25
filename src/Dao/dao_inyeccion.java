/*
 * Hay que resaltar que cada vez que termina de ejecutarse una funcion, en 
automatico cierra la conexion, para tomarse en cuanta para futuras 
actualizaciones
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

    private final sql_inyeccion s = new sql_inyeccion();

    /**
     * Obtiene todas las combinaciones de acuerdo al estilo en la bd de 
     * avances del 6.8
     *
     * @param c conexion sql
     * @param var Estilo
     * @return lista de combinaciones
     */
    @Override
    public ArrayList<String> getCombinacion(Connection c, String var) {
        return s.getcombinaciones(c, var);
    }

    /**
     * Obtiene todas las corridas de acuerdo al estilo en la bd de avances
     *
     * @param c conexion sql
     * @param var estilo
     * @return lista de corridas
     */
    @Override
    public ArrayList<String> getCorrida(Connection c, String var) {
        return s.getcorridas(c, var);
    }

    /**
     * Agrega un nuevo avance de inyeccion de acuerdo al objeto de tipo
     * inyeccion
     *
     * @param c conexion sql
     * @param i objeto tipo inyeccion
     * @return booleano para saber si se inserto o no
     */
    @Override
    public boolean new_avanceinyeccion(Connection c, Inyeccion i) {
        return s.newAvanceinyeccion(c, i);
    }

    /**
     * Obtiene toda la info del lote conforme al lote, sirve para obtener 
     * todos los datos necesarios para crear el avance y mostrar cierta 
     * informacion al operador.
     *
     * @param c conexion sql
     * @param lote lote de produccion
     * @return Un objeto de tipo inyeccion
     */
    @Override
    public Inyeccion getinfowith(Connection c, int lote) {
        return s.getinfowith(c, lote);
    }

    /**
     * Funcion que inserta el detalle de avance o programa para saber que lote
     * tiene ciertos numeros de punto con sus cantidades
     *
     * @param c conexion para ejecutar funcion
     * @param i
     * @return boolean, Si fue exitoso o no
     */
    @Override
    public boolean new_avancedetalle(Connection c, Inyeccion i) {
        return s.newAvanceDetalle(c, i);
    }

}
