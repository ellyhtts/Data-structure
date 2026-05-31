public class FloydWarshallComentado {

    // Definimos o Infinito (INF) com um número grande.
    final static int INF = 99999;
    final static int V = 4; // Número total de vértices no grafo (A, B, C, D)

    // Método principal que aplica a lógica do algoritmo
    public void calcularMenoresCaminhos(int[][] grafo) {
        
        // Criamos uma matriz de distâncias (d) que será manipulada
        int[][] d = new int[V][V];

        // Copia a matriz original para a matriz de distâncias
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                d[i][j] = grafo[i][j];
            }
        }

        // Floyd-Warshall (Triplo Loop)
        // O loop mais externo 'k' representa o vértice intermediário (o atalho)
        for (int k = 0; k < V; k++) {
            // 'i' representa o vértice de origem
            for (int i = 0; i < V; i++) {
                // 'j' representa o vértice de destino
                for (int j = 0; j < V; j++) {
                    
                    // Verifica se existe caminho passando por 'k'
                    // Ou seja, a distância de 'i' até 'k' e de 'k' até 'j' não pode ser Infinita
                    if (d[i][k] != INF && d[k][j] != INF) {
                        
                        // Se o caminho via 'k' for menor que o caminho direto atual, atualizamos
                        if (d[i][k] + d[k][j] < d[i][j]) {
                            d[i][j] = d[i][k] + d[k][j];
                        }
                    }
                }
            }
        }

        // Exibir o resultado final
        System.out.println("\n--- Matriz Final (Menores Caminhos) ---");
        imprimirMatriz(d);
    }

    // Método utilitário para imprimir matrizes formatadas no console
    public void imprimirMatriz(int[][] matriz) {
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (matriz[i][j] == INF) {
                    System.out.print("INF\t"); // Imprime texto se for infinito
                } else {
                    System.out.print(matriz[i][j] + "\t"); // Imprime o valor numérico
                }
            }
            System.out.println(); // Quebra de linha para formar a tabela
        }
    }

    public static void main(String[] args) {
        FloydWarshallComentado fw = new FloydWarshallComentado();

        // Construindo a matriz de adjacência (A=0, B=1, C=2, D=3)
        int[][] grafo = {
            {0,   3,   INF, 7},
            {8,   0,   2,   INF},
            {5,   INF, 0,   1},
            {2,   INF, INF, 0}
        };

        System.out.println("--- Matriz de Adjacência Original ---");
        fw.imprimirMatriz(grafo);

        // Dispara o algoritmo
        fw.calcularMenoresCaminhos(grafo);
    }
}