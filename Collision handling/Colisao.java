class NoAluno {
    int matricula;
    String nome;
    NoAluno proximo;

    public NoAluno(int matricula, String nome) {
        this.matricula = matricula;
        this.nome = nome;
        this.proximo = null;
    }
}

class TabelaHash {
    private NoAluno[] tabela;
    private int capacidade;

    public TabelaHash(int capacidade) {
        this.capacidade = capacidade;
        this.tabela = new NoAluno[capacidade];
    }

    private int calcularHash(int matricula) {
        return matricula % capacidade;
    }

    public void inserir(int matricula, String nome) {
        int indice = calcularHash(matricula);
        NoAluno novoAluno = new NoAluno(matricula, nome);

        if (tabela[indice] == null) {
            tabela[indice] = novoAluno;
        } else {
            novoAluno.proximo = tabela[indice];
            tabela[indice] = novoAluno;
        }
    }

    public String buscar(int matricula) {
        int indice = calcularHash(matricula);
        NoAluno atual = tabela[indice];

        while (atual != null) {
            if (atual.matricula == matricula) {
                return atual.nome;
            }
            atual = atual.proximo;
        }
        return "Aluno não encontrado.";
    }

    public void imprimirTabela() {
        System.out.println("--- Tabela Hash Atual ---");
        for (int i = 0; i < capacidade; i++) {
            System.out.print("Índice [" + i + "]: ");
            NoAluno atual = tabela[i];
            while (atual != null) {
                System.out.print("{" + atual.matricula + " - " + atual.nome + "} -> ");
                atual = atual.proximo;
            }
            System.out.println("null");
        }
        System.out.println("-------------------------");
    }
}

public class Colisao {
    public static void main(String[] args) {
        TabelaHash tabela = new TabelaHash(5);

        tabela.inserir(10, "Ana");    
        tabela.inserir(22, "Carlos"); 
        tabela.inserir(15, "Bruno");  
        tabela.inserir(27, "Diana");  
        tabela.inserir(31, "Elena");  

        tabela.imprimirTabela();

        System.out.println("Buscando matrícula 22: " + tabela.buscar(22));
        System.out.println("Buscando matrícula 15: " + tabela.buscar(15));
    }
}