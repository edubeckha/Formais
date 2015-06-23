/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

public enum TipoSimbolo {
    
    TERMINAL(),
    NAOTERMINAL();
    
    public TipoSimbolo intParaTipo(int tipo){
        switch(tipo){
            case 0:
                return TERMINAL;
            case 1:
                return NAOTERMINAL;
            default:
                return null;
        }
    }
}
