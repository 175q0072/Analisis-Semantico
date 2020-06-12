/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.itsco;

/**
 *
 */
public class SemanticException extends Exception{
    
    public static final int VARIABLE_NO_DEFINIDA = 1;
    public static final int VARIABLE_DUPLICADA = 2;
    public static final int VARIABLE_NO_INICIALIZADA = 3;
    public static final int TIPOS_NO_COINCIDEN = 4;
    public static final int OPERACION_NO_VALIDA= 5;
   
    
    public SemanticException(String id,int tipoException){
       super(getMessage(id,tipoException));     
    }
    
    private static String getMessage(String id, 
            int tipoException){
        String msg="";
        if(tipoException == VARIABLE_NO_DEFINIDA){
            msg = "La variable "+id+" no ha sido definida";
        }else if(tipoException == VARIABLE_DUPLICADA){
            msg = "La variable "+id+" ya está declarada";
        }else if(tipoException == VARIABLE_NO_INICIALIZADA){
            msg = "La variable "+id+" no tiene valor";
        }else if(tipoException==TIPOS_NO_COINCIDEN){
            msg = "El tipo de dato no coincide con la variable "
                    +id;
        }else if(tipoException == OPERACION_NO_VALIDA){
            msg = "Operacion invalida";
        }
        return msg;
    }
}
