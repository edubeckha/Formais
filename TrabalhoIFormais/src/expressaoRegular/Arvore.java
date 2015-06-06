package expressaoRegular;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// Classe responsável pela montagem da arvore binária a partir da expressão regular.
// 
public class Arvore {

    Nodo raiz;
    List<Nodo> listaDeFolhas;

    // Construtor da arvore
    // Recebe por parametro uma String que representa a expressão regular.
    public Arvore(String expressao) {
    	// Localiza o operador de menor precedencia da expressão para usar como raiz da arvore.
    	// A partir da raiz monta a arvore com a expressão regular.
        raiz = montaSubArvore(null, expressao);
        // Utilizado na costura
        Stack<Nodo> operadores = new Stack<>();
        // & vai ser interpretado como lambda após o desempilhamento.
        operadores.push(new Nodo('&', null));
        // Faz a costura da arvore a partir da raiz
        costurarEmPosOrder(raiz, operadores);
        // Gera a lista de folhas da arvore 
        listaDeFolhas = listarFolhas();
    }

    private Nodo montaSubArvore(Nodo nodo, String expressao) {
        Nodo novoNodo = new Nodo();
        SubArvore subarvore = new SubArvore();
        expressao = retirarParentesesExternos(expressao);
        int root = subarvore.posicaoDaRaiz(expressao);
        novoNodo.simbolo = expressao.charAt(root);
        novoNodo.pai = nodo;
        String ramoEsquerda = expressao.substring(0, root);
        String ramoDireita = expressao.substring(root + 1, expressao.length());
        if (ramoEsquerda.length() > 1) {
            novoNodo.fEsquerda = montaSubArvore(novoNodo, ramoEsquerda);
        } else if (ramoEsquerda.length() == 1) {
            novoNodo.fEsquerda = new Nodo(expressao.charAt(0), novoNodo);
        }
        if (ramoDireita.length() > 1) {
            novoNodo.fDireita = montaSubArvore(novoNodo, ramoDireita);
        } else if (ramoDireita.length() == 1) {
            novoNodo.fDireita = new Nodo(ramoDireita.charAt(0), novoNodo);
        }
        return novoNodo;
    }

    // Faz a costura da arvore, para cada elemento na lista de folhas vai ser costurado para o seu pai
    // se o pai ja foi costurado.
    private void costurarEmPosOrder(Nodo raiz, Stack<Nodo> operadores) {
        if (raiz == null) {
            return;
        }
        if (ehOperador(raiz.simbolo)) {
            operadores.push(raiz);
        } else {
            Nodo auxiliar = raiz;
            while (ehOperadorUnario(auxiliar.simbolo)) {
                auxiliar.costura = operadores.pop();
                auxiliar = auxiliar.costura;
                // costura para lambda
                if (auxiliar == null) {
                    break;
                }
            }
        }
        costurarEmPosOrder(raiz.fEsquerda, operadores);
        costurarEmPosOrder(raiz.fDireita, operadores);
    }

    // Gera a lista de folhas da arvore 
    private List<Nodo> listarFolhas() {
        List<Nodo> folhas = new ArrayList<>();
        Stack<Nodo> nodos = new Stack<>();
        Nodo auxiliar = raiz;
        int nAuxiliar = 1;
        while (!folhas.isEmpty() || auxiliar != null) {
            if (auxiliar != null) {
                nodos.push(auxiliar);
                auxiliar = auxiliar.fEsquerda;
            } else {
                auxiliar = nodos.pop();
                if (!ehOperador(auxiliar.simbolo)) {
                    auxiliar.valor = nAuxiliar;
                    folhas.add(auxiliar);
                    nAuxiliar++;
                }
                auxiliar = auxiliar.fDireita;
            }
        }
        return folhas;
    }

    // Remove os parenteses mais externos se necessário.
    private String retirarParentesesExternos(String expressao) {
        String auxiliar = expressao;
        if (auxiliar.charAt(0) == '(' && auxiliar.charAt(expressao.length() - 1) == ')') {
            for (int i = 0; i < auxiliar.length() / 2; i++) {
                if (auxiliar.charAt(i) == '(' && auxiliar.charAt(auxiliar.length() - (i + 1)) == ')') {
                    auxiliar = "[" + auxiliar.substring((i + 1), auxiliar.length() - (i + 1)) + "]";
                } else {
                    break;
                }
            }
            Stack<Character> ordemDosParenteses = new Stack<Character>();
            for (int i = 0; i < auxiliar.length(); i++) {
                if (auxiliar.charAt(i) == '[') {
                    ordemDosParenteses.push('[');
                } else if (auxiliar.charAt(i) == ']' && ordemDosParenteses.peek() == '[') {
                    ordemDosParenteses.pop();
                } else if (auxiliar.charAt(i) == '(' && (ordemDosParenteses.peek() == '(' || ordemDosParenteses.peek() == '[')) {
                    ordemDosParenteses.push('(');
                } else if (auxiliar.charAt(i) == ')' && ordemDosParenteses.peek() == '(') {
                    ordemDosParenteses.pop();
                }
            }
            if (ordemDosParenteses.isEmpty()) {
                return auxiliar.substring(1, auxiliar.length() - 1);
            } else {
                return expressao;
            }
        } else {
            return expressao;
        }
    }


    // Verifica se um dado simbolo é um operador válido.
    private boolean ehOperador(char simbolo) {
        return (simbolo == '.' || simbolo == '|' || simbolo == '*' || simbolo == '?');
    }

    // Verifica se um dado simbolo é um operador unário válido.
    private boolean ehOperadorUnario(char simbolo) {
        return simbolo == '*' || simbolo == '?';
    }


//    // Funções para teste da arvore
//		=====================================================
//    @Override
//    public String toString() {
//        Nodo a = raiz;
//        String volta = "Raiz: ";
//        do {
//            volta += "Simbolo: " + a.simbolo + "\n";
//            if (a.fEsquerda != null) {
//                a = a.fEsquerda;
//                volta += "\nesquerda\n";
//            } else {
//                a = a.fDireita;
//                volta += "\ndireita\n";
//            }
//
//        } while (a != null);
//        a = raiz;
//        volta += "\nraiz: ";
//        do {
//            volta += "Simbolo: " + a.simbolo + "\n";
//            if (a.fDireita != null) {
//                a = a.fDireita;
//                volta += "\ndireita\n";
//            } else {
//                a = a.fEsquerda;
//                volta += "\nesquerda\n";
//            }
//
//        } while (a != null);
//        return volta;
//    }
//
//    public static void main(String[] args) {
//        Nodo nd = new Nodo('a', null);
//        System.out.println(nd.mostra());
//        Arvore av = new Arvore("a*.(b?.c|d)*");
//        System.out.println("a*.(b?.c|d)*\n" + av.toString());
//    }
}