// Arquivo: ColisaoComentada.java

// 1. Estrutura do Nó: Representa cada elemento (aluno) que será guardado na tabela.
// Funciona como o elo de uma corrente (lista encadeada).
class NoAluno {
    int matricula; // Chave que usaremos para calcular a posição
    String nome;   // Valor/Dado que queremos armazenar
    NoAluno proximo; // Ponteiro que aponta para o próximo aluno (usado quando há colisão)

    // Construtor para inicializar um novo aluno
    public NoAluno(int matricula, String nome) {
        this.matricula = matricula;
        this.nome = nome;
        this.proximo = null; // Por padrão, o próximo é nulo até que ocorra uma colisão
    }
}

// 2. A Tabela Hash: Gerencia o armazenamento e as listas encadeadas.
class TabelaHash {
    // Array (vetor) onde cada posição guarda a "cabeça" de uma lista encadeada
    private NoAluno[] tabela;
    private int capacidade;

    // Construtor que define o tamanho do array da tabela
    public TabelaHash(int capacidade) {
        this.capacidade = capacidade;
        this.tabela = new NoAluno[capacidade];
    }

    // Função Hash: Pega a matrícula e calcula o resto da divisão pela capacidade.
    // Isso garante que o resultado sempre caia dentro do tamanho do array (0 até capacidade-1).
    private int calcularHash(int matricula) {
        return matricula % capacidade;
    }

    // Método para inserir um novo aluno na tabela
    public void inserir(int matricula, String nome) {
        // Descobre em qual "gaveta" (índice) o aluno deve entrar
        int indice = calcularHash(matricula);
        NoAluno novoAluno = new NoAluno(matricula, nome);

        // Se a gaveta estiver completamente vazia, o aluno entra direto
        if (tabela[indice] == null) {
            tabela[indice] = novoAluno;
        } else {
            // COLISÃO: Já tem alguém nessa gaveta!
            // O novo aluno aponta para o aluno que já estava lá (encadeamento)
            novoAluno.proximo = tabela[indice];
            // E a gaveta passa a apontar para o novo aluno (ele vira o primeiro da fila)
            tabela[indice] = novoAluno;
        }
    }

    // Método para buscar o nome de um aluno a partir da matrícula
    public String buscar(int matricula) {
        int indice = calcularHash(matricula);
        // Vai direto na gaveta correspondente
        NoAluno atual = tabela[indice];

        // Percorre a lista encadeada daquela gaveta procurando a matrícula
        while (atual != null) {
            if (atual.matricula == matricula) {
                return atual.nome; // Achou! Retorna o nome.
            }
            atual = atual.proximo; // Vai para o próximo elo da corrente
        }
        return "Aluno não encontrado."; // Percorreu tudo e não achou
    }

    // Método auxiliar para imprimir visualmente o que está acontecendo na memória
    public void imprimirTabela() {
        System.out.println("--- Tabela Hash Atual ---");
        // Passa por todas as gavetas do array
        for (int i = 0; i < capacidade; i++) {
            System.out.print("Índice [" + i + "]: ");
            NoAluno atual = tabela[i];
            // Imprime todos os alunos pendurados naquela gaveta
            while (atual != null) {
                System.out.print("{" + atual.matricula + " - " + atual.nome + "} -> ");
                atual = atual.proximo;
            }
            System.out.println("null"); // Fim da lista daquela gaveta
        }
        System.out.println("-------------------------");
    }
}

// 3. Classe Principal: Onde o programa começa a rodar.
// NOME ALTERADO: Agora a classe se chama ColisaoComentada
public class ColisaoComentada {
    public static void main(String[] args) {
        // Cria uma tabela pequena (tamanho 5) para forçar as colisões acontecerem rápido
        TabelaHash tabela = new TabelaHash(5);

        // Inserções: Observe que 10 e 15 deixam resto 0 na divisão por 5. (Vão colidir!)
        // 22 e 27 deixam resto 2 na divisão por 5. (Vão colidir!)
        tabela.inserir(10, "Ana");    
        tabela.inserir(22, "Carlos"); 
        tabela.inserir(15, "Bruno");  
        tabela.inserir(27, "Diana");  
        tabela.inserir(31, "Elena");  

        // Mostra a tabela completa no console
        tabela.imprimirTabela();

        // Faz alguns testes de busca para provar que funciona mesmo com colisões
        System.out.println("Buscando matrícula 22: " + tabela.buscar(22));
        System.out.println("Buscando matrícula 15: " + tabela.buscar(15));
    }
}