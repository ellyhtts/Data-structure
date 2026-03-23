import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class LaboratorioHeap {
    private ArrayList<Integer> heap = new ArrayList<>();

    public void inserir(int valor) {
        heap.add(valor);
        heapifyUp(heap.size() - 1);
        System.out.println("[+] " + valor + " adicionado ao Heap.");
    }

    public void remover(int indice) {
        if (indice < 0 || indice >= heap.size()) {
            System.out.println("[!] Erro: Índice " + indice + " é inválido.");
            return;
        }

        int valorRemovido = heap.get(indice);
        int ultimoValor = heap.get(heap.size() - 1);

        heap.set(indice, ultimoValor);
        heap.remove(heap.size() - 1);

        if (!heap.isEmpty() && indice < heap.size()) {
            heapifyDown(indice);
        }
        System.out.println("[-] " + valorRemovido + " removido com sucesso.");
    }

    private void heapifyUp(int index) {
        int pai = (index - 1) / 2;
        if (index > 0 && heap.get(index) > heap.get(pai)) {
            Collections.swap(heap, index, pai);
            heapifyUp(pai);
        }
    }

    private void heapifyDown(int index) {
        int maior = index;
        int esquerda = 2 * index + 1;
        int direita = 2 * index + 2;

        if (esquerda < heap.size() && heap.get(esquerda) > heap.get(maior)) {
            maior = esquerda;
        }
        if (direita < heap.size() && heap.get(direita) > heap.get(maior)) {
            maior = direita;
        }

        if (maior != index) {
            Collections.swap(heap, index, maior);
            heapifyDown(maior);
        }
    }

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
        LaboratorioHeap meuHeap = new LaboratorioHeap();
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
