import java.util.Stack;  
import java.util.Scanner;

// Importamos a estrutura de dados 'Stack' (Pilha) da biblioteca oficial do Java
import java.util.Stack;
// Importamos o 'Scanner', que serve para o programa "ouvir" o que você digita
import java.util.Scanner;

public class PilhaComentada {
    // O 'main' é o ponto de entrada: é aqui que o computador começa a ler seu código
    public static void main(String[] args) {
        // Criamos um objeto chamado 'leitor' para capturar as entradas do teclado
        Scanner leitor = new Scanner(System.in);
        
        // 'while (true)' cria um loop infinito. Isso resolve aquele problema de
        // o programa rodar uma vez e fechar. Ele vai repetir até você mandar parar.
        while (true) {
            System.out.println("\nDigite uma frase (ou 'sair' para encerrar):");
            
            // Lemos a linha inteira que você digitou e guardamos na variável 'entrada'
            String entrada = leitor.nextLine();

            // Verificamos se você digitou "sair". 
            // 'equalsIgnoreCase' ignora se você usou maiúsculas ou minúsculas.
            if (entrada.equalsIgnoreCase("sair")) {
                break; // O comando 'break' quebra o loop e encerra o programa
            }

            // 'limpa' será a frase final apenas com letras e números, sem "ruídos"
            String limpa = "";

            // O loop 'for' vai caminhar por cada letra da sua frase original
            for (int i = 0; i < entrada.length(); i++) {
                // .charAt(i) pega o caractere exato na posição 'i'
                char c = entrada.charAt(i);
                
                // Chamamos nossa função (lá embaixo) para trocar 'ó' por 'o', etc.
                c = removerAcentoManualmente(c);
                
                // 'Character.isLetterOrDigit' verifica se o que sobrou é letra ou número.
                // Se for um espaço ou vírgula, o programa simplesmente ignora.
                if (Character.isLetterOrDigit(c)) {
                    // Adicionamos a letra à variável 'limpa' sempre em minúsculo
                    limpa += Character.toLowerCase(c);
                }
            }

            // --- LÓGICA DA PILHA (STACK) ---
            
            // Criamos uma pilha vazia chamada 'pilha' que guardará caracteres
            Stack<Character> pilha = new Stack<>();

            // Vamos colocar cada letra da frase 'limpa' dentro da pilha
            for (int i = 0; i < limpa.length(); i++) {
                // .push() "empilha" a letra no topo
                pilha.push(limpa.charAt(i));
            }

            // 'invertida' vai guardar as letras que vamos tirar da pilha
            String invertida = "";
            
            // '!pilha.isEmpty()' significa: enquanto a pilha NÃO estiver vazia
            while (!pilha.isEmpty()) {
                // .pop() retira a letra que está no topo (a última que entrou)
                // Como a última letra entra por cima, ela é a primeira a sair,
                // fazendo com que a frase saia ao contrário!
                invertida += pilha.pop();
            }

            // Agora comparamos: a frase limpa é igual à frase invertida?
            if (limpa.equals(invertida)) {
                System.out.println("Resultado: É um palíndromo! ✅");
            } else {
                System.out.println("Resultado: Não é um palíndromo. ❌");
            }
        }
        
        // Fechamos o leitor para liberar a memória do sistema
        leitor.close();
    }

    /**
     * Esta função é como um "tradutor" manual.
     * Ela recebe uma letra (char c) e vê se ela tem um acento correspondente.
     */
    public static char removerAcentoManualmente(char c) {
        // Duas listas: uma com acento e outra com as letras "puras" na mesma ordem
        String comAcento = "áàâãéèêíìîóòôõúùûçÁÀÂÃÉÈÊÍÌÎÓÒÔÕÚÙÛÇ";
        String semAcento = "aaaaeeeiiioooouuucAAAAEEEIIIOOOOUUUC";
        
        // .indexOf procura em qual posição a letra 'c' está na lista de acentos
        int index = comAcento.indexOf(c);
        
        // Se index não for -1, significa que a letra FOI encontrada na lista de acentos
        if (index != -1) {
            // Pegamos a letra correspondente na lista 'semAcento' usando a mesma posição
            return semAcento.charAt(index);
        }
        
        // Se não tinha acento, devolvemos a própria letra original
        return c; 
    }
}
