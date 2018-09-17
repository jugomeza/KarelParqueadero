/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unal.poo.practica;

import becker.robots.Thing;

/**
 *
 * @author sebas
 */
public class Auto {
    private String placa;
    private double tingreso;
    private double tsalida;
    private double tinstancia;
    private double cobro;
    public double totali;
    private double tarifa;

    public Auto(){
        this.placa = null;
        this.tingreso = 0;
        this.tsalida = 0;
        this.tinstancia = 0;
        this.cobro = 0;
        this.totali = 0;
        this.tarifa = 133.3;
    }

    public double getTotali() {
        return totali;
    }
   
    public void recibo(){
    this.cobro=this.tinstancia*this.tarifa;}
 
    public String getPlaca() {
        return placa;
    }
    public void instancia(){
    this.tinstancia=this.tsalida-this.tingreso;
    }
    

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public double getTingreso() {
        return tingreso;
    }

    public void setTingreso(double tingreso) {
        this.tingreso = (int) tingreso;
    }

    public double getTsalida() {
        return tsalida;
    }

    public void setTsalida(double tsalida) {
        this.tsalida = (int) tsalida;
    }

    public double getTinstancia() {
        return tinstancia;
    }
    

    public double getCobro() {
        return cobro;
    }
    
   
}