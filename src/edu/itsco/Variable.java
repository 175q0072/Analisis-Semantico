/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.itsco;

import java.util.Objects;

/**
 *
 * @author paco
 */
public class Variable {
    
    private String id;
    private String tipoDato;
    private boolean inicializada;
    
    public Variable(){
        
    }
    
    public Variable(String id, String tipoDato){
        this.id = id;
        this.tipoDato = tipoDato;
    }
    
    public void setId(String id){
        this.id = id;
    }
    
    public String getId(){
        return this.id;
    }
    
    public void setTipoDato(String tipoDato){
        this.tipoDato = tipoDato;
    }
    
    public String getTipoDato(){
        return this.tipoDato;
    }
    
    public void setInicializada(boolean inicializada){
        this.inicializada = inicializada;
    }
    
    public boolean isInicializada(){
        return this.inicializada;
    }
    
    @Override
    public boolean equals(Object obj){
        if( obj instanceof Variable){
            Variable v = (Variable) obj;
            return v.hashCode()==this.hashCode();
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.id);
        return hash;
    }
}
