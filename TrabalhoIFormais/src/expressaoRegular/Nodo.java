package expressaoRegular;
// Classe que guarda as informações que serão armazenadas no nodo da arvore binária.
public class Nodo {

    Nodo pai, fEsquerda, fDireita, costura;
    char simbolo;
    int valor;

    // Construtor utilizado para instanciação do nodo.
    Nodo() {
    }

    // Construtor dos nodos folha
    Nodo(char simbolo, Nodo pai) {
        this.simbolo = simbolo;
        this.pai = pai;
    }
    // Construtor dos nodos operadores
    Nodo(Nodo pai, Nodo fEsquerda, Nodo fDireita, char simbolo) {
        this.pai = pai;
        this.fEsquerda = fEsquerda;
        this.fDireita = fDireita;
        this.simbolo = simbolo;
    }
}
