import java.util.LinkedList; 
import java.util.Queue;       
import java.util.Stack;  
import java.util.Scanner;
import java.text.Normalizer; 

public class Palindrometro {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== Verificador de Palíndromos (Versão Robusta) ===");
        System.out.print("Digite uma palavra ou frase: ");
        
        String entrada = scanner.nextLine();

        if (isPalindromo(entrada)) {
            System.out.println("Resultado: É um palíndromo!");
        } else {
            System.out.println("Resultado: Não é um palíndromo.");
        }
        
        scanner.close(); 
    }

    public static boolean isPalindromo(String texto) {
        Stack<Character> pilha = new Stack<>();
        
        Queue<Character> fila = new LinkedList<>();
        
        String textoDecomposto = Normalizer.normalize(texto, Normalizer.Form.NFD);
        
        String textoLimpo = textoDecomposto.toLowerCase();

        for (int i = 0; i < textoLimpo.length(); i++) {
            char c = textoLimpo.charAt(i);

            if ((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9')) {
                pilha.push(c); 
                fila.add(c);   
            }
        }
        
        while (!pilha.isEmpty()) {
    
            char letraDaFrente = fila.poll();
   
            char letraDeTras = pilha.pop();

            if (letraDaFrente != letraDeTras) {
                return false; 
            }
        }

        return true;
    }
}