/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
public class Simbolo {
    public TipoSimbolo tipo; //terminal, nao-terminal
    public String nome;
    
    public Simbolo(String n, int t){
       nome = n;
       tipo = TipoSimbolo.retornaTipoAPartirDeBooleano(t);
    }
}
