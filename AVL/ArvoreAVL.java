class NoAVL {
    int valor, altura;
    NoAVL esquerda, direita;

    NoAVL(int valor) {
        this.valor = valor;
        this.altura = 1;
    }
}

public class ArvoreAVL {
    NoAVL raiz;

    int altura(NoAVL N) {
        if (N == null) return 0;
        return N.altura;
    }

    int max(int a, int b) {
        return (a > b) ? a : b;
    }

    int obterBalanceamento(NoAVL N) {
        if (N == null) return 0;
        return altura(N.esquerda) - altura(N.direita);
    }

    NoAVL rotacaoDireita(NoAVL y) {
        NoAVL x = y.esquerda;
        NoAVL T2 = x.direita;

        x.direita = y;
        y.esquerda = T2;

        y.altura = max(altura(y.esquerda), altura(y.direita)) + 1;
        x.altura = max(altura(x.esquerda), altura(x.direita)) + 1;

        return x;
    }

    NoAVL rotacaoEsquerda(NoAVL x) {
        NoAVL y = x.direita;
        NoAVL T2 = y.esquerda;

        y.esquerda = x;
        x.direita = T2;

        x.altura = max(altura(x.esquerda), altura(x.direita)) + 1;
        y.altura = max(altura(y.esquerda), altura(y.direita)) + 1;

        return y;
    }

    NoAVL inserir(NoAVL no, int valor) {
        if (no == null) return new NoAVL(valor);

        if (valor < no.valor)
            no.esquerda = inserir(no.esquerda, valor);
        else if (valor > no.valor)
            no.direita = inserir(no.direita, valor);
        else
            return no;

        no.altura = 1 + max(altura(no.esquerda), altura(no.direita));

        int balanceamento = obterBalanceamento(no);

        if (balanceamento > 1 && valor < no.esquerda.valor)
            return rotacaoDireita(no);

        if (balanceamento < -1 && valor > no.direita.valor)
            return rotacaoEsquerda(no);

        if (balanceamento > 1 && valor > no.esquerda.valor) {
            no.esquerda = rotacaoEsquerda(no.esquerda);
            return rotacaoDireita(no);
        }

        if (balanceamento < -1 && valor < no.direita.valor) {
            no.direita = rotacaoDireita(no.direita);
            return rotacaoEsquerda(no);
        }

        return no;
    }

    void preOrdem(NoAVL no) {
        if (no != null) {
            System.out.print(no.valor + " ");
            preOrdem(no.esquerda);
            preOrdem(no.direita);
        }
    }

    public static void main(String[] args) {
        ArvoreAVL arvore = new ArvoreAVL();

        arvore.raiz = arvore.inserir(arvore.raiz, 10);
        arvore.raiz = arvore.inserir(arvore.raiz, 20);
        arvore.raiz = arvore.inserir(arvore.raiz, 30);
        arvore.raiz = arvore.inserir(arvore.raiz, 40);
        arvore.raiz = arvore.inserir(arvore.raiz, 50);
        arvore.raiz = arvore.inserir(arvore.raiz, 25);

        System.out.println("Percurso em Pré-ordem da árvore AVL construída:");
        arvore.preOrdem(arvore.raiz);
    }
}