// Classe No: define a estrutura de cada elemento da árvore
class No {
    int valor;
    No esquerda, direita;

    public No(int item) {
        valor = item;
        esquerda = direita = null; // Inicializa um novo nó sem filhos
    }
}

public class PostorderComentado {
    No raiz;

    // Método para inserir valores respeitando a regra da Árvore de Busca Binária (BST) 
    No inserir(No root, int valor) {
        // Se a posição estiver vazia, cria o nó e o retorna para ser ligado ao pai 
        if (root == null) {
            root = new No(valor);
            return root;
        }

        // Se o valor for menor que o atual, tenta inserir na subárvore esquerda
        if (valor < root.valor) {
            root.esquerda = inserir(root.esquerda, valor);
        } 
        // Se o valor for maior que o atual, tenta inserir na subárvore direita
        else if (valor > root.valor) {
            root.direita = inserir(root.direita, valor);
        }

        return root;
    }

    // Método de Percurso Pós-Ordem (Postorder): Esquerda -> Direita -> Raiz 
    void percorrerPosOrdem(No node) {
        // Caso base: se o nó for nulo, a recursão para e retorna
        if (node == null) {
            return;
        }

        // Visita recursivamente todos os nós à esquerda
        percorrerPosOrdem(node.esquerda);
        
        // Visita recursivamente todos os nós à direita
        percorrerPosOrdem(node.direita);
        
        // Processa a raiz (nó atual) após os filhos terem sido visitados
        System.out.print(node.valor + " ");
    }

    public static void main(String[] args) {
        PostorderComentado bst = new PostorderComentado();
        
        int[] valores = {50, 30, 70, 20, 40, 60, 80};

        // Preenche a árvore com os valores do array
        for (int v : valores) {
            bst.raiz = bst.inserir(bst.raiz, v);
        }

        System.out.println("Resultado do Percurso Pós-Ordem:");
        // Inicia o percurso a partir da raiz principal 
        bst.percorrerPosOrdem(bst.raiz); 
    }
}