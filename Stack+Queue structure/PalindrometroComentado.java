import java.util.LinkedList; // Estrutura de lista ligada usada para criar a Fila
import java.util.Queue;      // Interface que define o comportamento de uma Fila 
import java.util.Stack;      // Classe que define o comportamento de uma Pilha 
import java.util.Scanner;    // Classe para ler a entrada do usuário no console
import java.text.Normalizer; // Classe vital para tratar acentos (ex: 'ó' vira 'o')

public class PalindrometroComentado {

    public static void main(String[] args) {
        // Cria um objeto para ler o que o usuário digita
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== Verificador de Palíndromos (Versão Robusta) ===");
        System.out.print("Digite uma palavra ou frase: ");
        
        // Armazena a frase completa digitada
        String entrada = scanner.nextLine();

        // Chama a função lógica e exibe o resultado baseado no retorno true ou false
        if (isPalindromo(entrada)) {
            System.out.println("Resultado: É um palíndromo!");
        } else {
            System.out.println("Resultado: Não é um palíndromo.");
        }
        
        scanner.close(); // Fecha o leitor para liberar memória
    }

    public static boolean isPalindromo(String texto) {
        // O último a entrar é o primeiro a sair
        Stack<Character> pilha = new Stack<>();
        
        // O primeiro a entrar é o primeiro a sair
        Queue<Character> fila = new LinkedList<>();
        
        // Decompõe caracteres 
        String textoDecomposto = Normalizer.normalize(texto, Normalizer.Form.NFD);
        
        // Converte tudo para minúsculo
        String textoLimpo = textoDecomposto.toLowerCase();

        // Loop para percorrer cada caractere da frase tratada
        for (int i = 0; i < textoLimpo.length(); i++) {
            char c = textoLimpo.charAt(i);

            // Filtro manual
            // Só aceitamos se for uma letra básica (a até z) ou um número (0 até 9)
            // Isso ignora automaticamente os acentos "soltos", espaços e pontuação
            if ((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9')) {
                pilha.push(c); // empilha a letra no topo
                fila.add(c);   // coloca a letra no fim da fila
            }
        }
        
        // Enquanto houver elementos na pilha
        while (!pilha.isEmpty()) {
            // Remove e retorna o elemento da frente da Fila
            char letraDaFrente = fila.poll();
            
            // Remove e retorna o elemento do topo da Pilha
            char letraDeTras = pilha.pop();

            // Se houver qualquer diferença, interrompe e retorna falso
            if (letraDaFrente != letraDeTras) {
                return false; 
            }
        }

        // Se o loop terminar, significa que deu certo
        return true;
    }
}