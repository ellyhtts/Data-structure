import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Laboratório de Heaps: Versão Didática
 * Esta classe implementa um Max-Heap utilizando um ArrayList.
 */
public class LaboratorioHeapComentada {
    // A árvore é representada como um array onde:
    // Filho Esquerdo = 2 * pai + 1
    // Filho Direito = 2 * pai + 2
    // Pai = (filho - 1) / 2
    private ArrayList<Integer> heap = new ArrayList<>();

    // --- MÉTODOS DE ESTRUTURA ---

    public void inserir(int valor) {
        // Adiciona o novo valor ao final do array (folha mais à esquerda livre)
        heap.add(valor);
        // "Sobe" o valor (Heapify Up) para garantir que o pai seja maior que ele
        heapifyUp(heap.size() - 1);
        System.out.println("[+] " + valor + " adicionado ao Heap.");
    }

    public void remover(int indice) {
        // Validação de segurança: o índice existe no array?
        if (indice < 0 || indice >= heap.size()) {
            System.out.println("[!] Erro: Índice " + indice + " é inválido.");
            return;
        }

        int valorRemovido = heap.get(indice);
        int ultimoValor = heap.get(heap.size() - 1);

        // PASSO 1: Troca estratégica. 
        // Substituímos o valor alvo pelo último elemento da árvore para manter a estrutura completa.
        heap.set(indice, ultimoValor);
        
        // PASSO 2: Redução de tamanho.
        // Removemos o último elemento (que agora está duplicado ou era o próprio alvo).
        heap.remove(heap.size() - 1);

        // PASSO 3: Reorganização (Heapify Down).
        // Se a árvore não ficou vazia, fazemos o novo valor "descer" até sua posição correta.
        if (!heap.isEmpty() && indice < heap.size()) {
            heapifyDown(indice);
        }
        System.out.println("[-] " + valorRemovido + " removido com sucesso.");
    }

    private void heapifyUp(int index) {
        int pai = (index - 1) / 2;
        // Se o elemento atual for maior que o seu pai, eles trocam de lugar
        if (index > 0 && heap.get(index) > heap.get(pai)) {
            Collections.swap(heap, index, pai);
            // Continua subindo recursivamente
            heapifyUp(pai);
        }
    }

    private void heapifyDown(int index) {
        int maior = index;
        int esquerda = 2 * index + 1;
        int direita = 2 * index + 2;

        // Verifica se o filho da esquerda existe e se é maior que o nó atual
        if (esquerda < heap.size() && heap.get(esquerda) > heap.get(maior)) {
            maior = esquerda;
        }
        // Verifica se o filho da direita existe e se é o maior entre os três
        if (direita < heap.size() && heap.get(direita) > heap.get(maior)) {
            maior = direita;
        }

        // Se o maior não for o nó original, troca e continua descendo
        if (maior != index) {
            Collections.swap(heap, index, maior);
            heapifyDown(maior);
        }
    }

    // --- INTERFACE VISUAL NO CONSOLE ---
    public void desenharArvore() {
        if (heap.isEmpty()) {
            System.out.println("\n--- HEAP VAZIO ---");
            return;
        }

        System.out.println("\n======= VISUALIZAÇÃO DO HEAP =======");
        int altura = (int) (Math.log(heap.size()) / Math.log(2)) + 1;
        
        for (int i = 0; i < heap.size(); i++) {
            int nivel = (int) (Math.log(i + 1) / Math.log(2));
            int espacamento = (int) Math.pow(2, altura - nivel + 1);
            
            if (i == (int) Math.pow(2, nivel) - 1) {
                System.out.print(" ".repeat(espacamento));
            }

            System.out.print(heap.get(i) + "(idx:" + i + ")" + " ".repeat(espacamento));

            if ((i + 2 & (i + 1)) == 0 || i == heap.size() - 1) {
                System.out.println("\n");
            }
        }
        System.out.println("Array Interno: " + heap);
        System.out.println("====================================");
    }

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        LaboratorioHeapComentada meuHeap = new LaboratorioHeapComentada();
        int comando = 0;

        System.out.println("--- BEM-VINDO AO LABORATÓRIO DE HEAPS ---");

        while (comando != 4) {
            meuHeap.desenharArvore();
            System.out.println("\nEscolha:");
            System.out.println("1. Inserir | 2. Deletar p/ Índice | 3. Remover Raiz | 4. Sair");
            System.out.print("> ");
            
            comando = entrada.nextInt();

            switch (comando) {
                case 1:
                    System.out.print("Valor: ");
                    meuHeap.inserir(entrada.nextInt());
                    break;
                case 2:
                    System.out.print("Índice: ");
                    meuHeap.remover(entrada.nextInt());
                    break;
                case 3:
                    meuHeap.remover(0);
                    break;
                case 4:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
        entrada.close();
    }
}