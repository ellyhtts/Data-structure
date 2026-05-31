public class FloydWarshall {

    final static int INF = 99999;
    final static int V = 4; 

    public void calcularMenoresCaminhos(int[][] grafo) {
        int[][] d = new int[V][V];

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                d[i][j] = grafo[i][j];
            }
        }

        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (d[i][k] != INF && d[k][j] != INF && d[i][k] + d[k][j] < d[i][j]) {
                        d[i][j] = d[i][k] + d[k][j];
                    }
                }
            }
        }

        System.out.println("\n--- Matriz Final (Menores Caminhos) ---");
        imprimirMatriz(d);
    }

    public void imprimirMatriz(int[][] matriz) {
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (matriz[i][j] == INF) {
                    System.out.print("INF\t");
                } else {
                    System.out.print(matriz[i][j] + "\t");
                }
            }
            System.out.println(); 
        }
    }

    public static void main(String[] args) {
        FloydWarshall fw = new FloydWarshall();

        int[][] grafo = {
            {0,   3,   INF, 7},
            {8,   0,   2,   INF},
            {5,   INF, 0,   1},
            {2,   INF, INF, 0}
        };

        System.out.println("--- Matriz de Adjacência Original ---");
        fw.imprimirMatriz(grafo);

        fw.calcularMenoresCaminhos(grafo);
    }
}