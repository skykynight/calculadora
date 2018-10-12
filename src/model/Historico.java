/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;



public class Historico {
    private int id;
    private float pv, sv,resultado;
    private String operador;
    
    public Historico(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int Id) {
        this.id = Id;
    }

    public float getPv() {
        return pv;
    }

    public void setPv(float pv) {
        this.pv = pv;
    }

    public float getSv() {
        return sv;
    }

    public void setSv(float sv) {
        this.sv = sv;
    }

    public String getOperador() {
        return operador;
    }

    public void setOperador(String operador) {
        this.operador = operador;
    }

    public float getResultado() {
        return resultado;
    }

    public void setResultado(float resultado) {
        this.resultado = resultado;
    }

    
    
}
