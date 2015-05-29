/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

public enum TipoSimbolo {
    INICIAL(),
    NAOTERMINAL(),
    TERMINAL();
    
   /**
    * Função que retorna o tipo do simbolo a partir do int mandada por parâmetro.
    * @param tipoSimbolo int para se determinar de qual tipo o símbolo é.
    * @return O enum correspondente ao tipo so símbolo
    */
    public static TipoSimbolo retornaTipoAPartirDeBooleano(int tipoSimbolo){
        switch(tipoSimbolo){
            case 0:
                return INICIAL;
            case 1:
                return NAOTERMINAL;
            case 2:
                return TERMINAL;
            default:
                return null;
        }
    }
}
