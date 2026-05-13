class NoAVL {
    int valor;
    int altura; // Requisito rastrear a altura do nó
    NoAVL esquerda, direita;

    // Construtor
    NoAVL(int valor) {
        this.valor = valor;
        this.altura = 1; // Todo nó novo é inserido como folha, logo, tem altura 1
    }
}

public class ArvoreAVLComentada {
    NoAVL raiz;

    // Função para pegar a altura de um nó com segurança
    int altura(NoAVL N) {
        if (N == null) return 0;
        return N.altura;
    }

    // Função para pegar o maior entre dois números
    int max(int a, int b) {
        return (a > b) ? a : b;
    }

    // Calcula Altura da Esquerda - Altura da Direita
    int obterBalanceamento(NoAVL N) {
        if (N == null) return 0;
        return altura(N.esquerda) - altura(N.direita);
    }


    // Rotação à Direita (Puxa o nó da esquerda para cima)
    NoAVL rotacaoDireita(NoAVL y) {
        NoAVL x = y.esquerda;
        NoAVL T2 = x.direita;

        // Faz a rotação
        x.direita = y;
        y.esquerda = T2;

        // Atualiza as alturas após mover os nós (Pai primeiro, depois o novo topo)
        y.altura = max(altura(y.esquerda), altura(y.direita)) + 1;
        x.altura = max(altura(x.esquerda), altura(x.direita)) + 1;

        // Retorna o novo nó raiz desta subárvore
        return x;
    }

    // Rotação à Esquerda (Puxa o nó da direita para cima)
    NoAVL rotacaoEsquerda(NoAVL x) {
        NoAVL y = x.direita;
        NoAVL T2 = y.esquerda;

        // Faz a rotação
        y.esquerda = x;
        x.direita = T2;

        // Atualiza as alturas
        x.altura = max(altura(x.esquerda), altura(x.direita)) + 1;
        y.altura = max(altura(y.esquerda), altura(y.direita)) + 1;

        return y;
    }

    NoAVL inserir(NoAVL no, int valor) {
        // Inserção normal de Árvore de Busca Binária (BST)
        if (no == null) return new NoAVL(valor);

        if (valor < no.valor)
            no.esquerda = inserir(no.esquerda, valor);
        else if (valor > no.valor)
            no.direita = inserir(no.direita, valor);
        else // Valores duplicados não são permitidos na AVL
            return no;

        // Atualiza a altura do nó ancestral atual
        no.altura = 1 + max(altura(no.esquerda), altura(no.direita));

        // Calcula o fator de balanceamento para verificar se quebrou a regra
        int balanceamento = obterBalanceamento(no);

        // Se desbalanceou, existem 4 casos possíveis:

        // Esquerda-Esquerda (LL) -> Rotação Simples à Direita
        if (balanceamento > 1 && valor < no.esquerda.valor)
            return rotacaoDireita(no);

        // Direita-Direita (RR) -> Rotação Simples à Esquerda
        if (balanceamento < -1 && valor > no.direita.valor)
            return rotacaoEsquerda(no);

        // Esquerda-Direita (LR) -> Rotação Dupla
        if (balanceamento > 1 && valor > no.esquerda.valor) {
            no.esquerda = rotacaoEsquerda(no.esquerda); // Roda o filho pra esquerda
            return rotacaoDireita(no);                  // Roda o pai pra direita
        }

        // Caso 4: Direita-Esquerda (RL) -> Rotação Dupla
        if (balanceamento < -1 && valor < no.direita.valor) {
            no.direita = rotacaoDireita(no.direita);    // Roda o filho pra direita
            return rotacaoEsquerda(no);                 // Roda o pai pra esquerda
        }

        // Retorna o nó (inalterado se já estava balanceado)
        return no;
    }

    // Método apenas para imprimir e visualizar se a estrutura ficou correta
    void preOrdem(NoAVL no) {
        if (no != null) {
            System.out.print(no.valor + " ");
            preOrdem(no.esquerda);
            preOrdem(no.direita);
        }
    }

    public static void main(String[] args) {
        ArvoreAVLComentada arvore = new ArvoreAVLComentada();

        arvore.raiz = arvore.inserir(arvore.raiz, 10);
        arvore.raiz = arvore.inserir(arvore.raiz, 20);
        arvore.raiz = arvore.inserir(arvore.raiz, 30); // Aqui rola a 1ª rotação à esquerda
        arvore.raiz = arvore.inserir(arvore.raiz, 40);
        arvore.raiz = arvore.inserir(arvore.raiz, 50); // Aqui rola a 2ª rotação à esquerda
        arvore.raiz = arvore.inserir(arvore.raiz, 25); // Aqui rola uma rotação dupla (RL)

        System.out.println("Percurso em Pré-ordem: ");
        arvore.preOrdem(arvore.raiz);
    }
}