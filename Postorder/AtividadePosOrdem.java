class No {
    int valor;
    No esquerda, direita;

    public No(int item) {
        valor = item;
        esquerda = direita = null;
    }
}

public class AtividadePosOrdem {
    No raiz;

    No inserir(No root, int valor) {
        if (root == null) {
            return new No(valor);
        }
        if (valor < root.valor)
            root.esquerda = inserir(root.esquerda, valor);
        else if (valor > root.valor)
            root.direita = inserir(root.direita, valor);
        return root;
    }

    void percorrerPosOrdem(No node) {
        if (node != null) {
            percorrerPosOrdem(node.esquerda);
            percorrerPosOrdem(node.direita);
            System.out.print(node.valor + " ");
        }
    }

    public static void main(String[] args) {
        AtividadePosOrdem bst = new AtividadePosOrdem();
        int[] valores = {50, 30, 70, 20, 40, 60, 80};

        for (int v : valores) {
            bst.raiz = bst.inserir(bst.raiz, v);
        }

        bst.percorrerPosOrdem(bst.raiz);
    }
}