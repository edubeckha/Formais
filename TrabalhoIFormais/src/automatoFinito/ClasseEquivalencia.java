/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automatoFinito;

import java.util.LinkedHashSet;
import java.util.Set;

public class ClasseEquivalencia {
    

    public Set<Estado> estadosEquivalentes;
    public String label;
    
    public ClasseEquivalencia(String l){
        estadosEquivalentes = new LinkedHashSet<>();
        label = "q"+ l;
    }
    
   
    
   
    
}
