/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

/**
 *
 * @author GATEWAY1-
 */
public class Inyeccion implements java.io.Serializable{
    private int id_inyeccion,pares, estilo, corrida, corridacpt, id_prog, periodo, lote;
    private String fecha, combinacion, estatus, punto;

    /**
     *
     * @return
     */
    public String getPunto() {
        return punto;
    }

    /**
     *
     * @param punto
     */
    public void setPunto(String punto) {
        this.punto = punto;
    }

    /**
     *
     * @return
     */
    public int getLote() {
        return lote;
    }

    /**
     *
     * @param lote
     */
    public void setLote(int lote) {
        this.lote = lote;
    }

    /**
     *
     * @return
     */
    public int getPeriodo() {
        return periodo;
    }

    /**
     *
     * @param periodo
     */
    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }

    /**
     *
     * @return
     */
    public int getCorridacpt() {
        return corridacpt;
    }

    /**
     *
     * @param corridacpt
     */
    public void setCorridacpt(int corridacpt) {
        this.corridacpt = corridacpt;
    }

    /**
     *
     * @return
     */
    public int getId_prog() {
        return id_prog;
    }

    /**
     *
     * @param id_prog
     */
    public void setId_prog(int id_prog) {
        this.id_prog = id_prog;
    }

    /**
     *
     * @return
     */
    public int getId_inyeccion() {
        return id_inyeccion;
    }

    /**
     *
     * @param id_inyeccion
     */
    public void setId_inyeccion(int id_inyeccion) {
        this.id_inyeccion = id_inyeccion;
    }

    /**
     *
     * @return
     */
    public int getPares() {
        return pares;
    }

    /**
     *
     * @param pares
     */
    public void setPares(int pares) {
        this.pares = pares;
    }

    /**
     *
     * @return
     */
    public int getEstilo() {
        return estilo;
    }

    /**
     *
     * @param estilo
     */
    public void setEstilo(int estilo) {
        this.estilo = estilo;
    }

    /**
     *
     * @return
     */
    public int getCorrida() {
        return corrida;
    }

    /**
     *
     * @param corrida
     */
    public void setCorrida(int corrida) {
        this.corrida = corrida;
    }

    /**
     *
     * @return
     */
    public String getFecha() {
        return fecha;
    }

    /**
     *
     * @param fecha
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     *
     * @return
     */
    public String getCombinacion() {
        return combinacion;
    }

    /**
     *
     * @param combinacion
     */
    public void setCombinacion(String combinacion) {
        this.combinacion = combinacion;
    }

    /**
     *
     * @return
     */
    public String getEstatus() {
        return estatus;
    }

    /**
     *
     * @param estatus
     */
    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }
    
}
