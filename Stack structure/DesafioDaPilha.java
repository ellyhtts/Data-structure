import java.util.Stack;
import java.util.Scanner;

public class DesafioDaPilha {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        
        while (true) {
            System.out.println("\nDigite uma frase (ou 'sair'):");
            String entrada = leitor.nextLine();

            if (entrada.equalsIgnoreCase("sair")) break;

            String limpa = "";

            for (int i = 0; i < entrada.length(); i++) {
                char c = entrada.charAt(i);
                
                c = removerAcentoManualmente(c);
                
                if (Character.isLetterOrDigit(c)) {
                    
                    limpa += Character.toLowerCase(c);
                }
            }

            Stack<Character> pilha = new Stack<>();
            for (int i = 0; i < limpa.length(); i++) {
                pilha.push(limpa.charAt(i));
            }

            String invertida = "";
            while (!pilha.isEmpty()) {
                invertida += pilha.pop();
            }

            if (limpa.equals(invertida)) {
                System.out.println("Resultado: É um palíndromo! ✅");
            } else {
                System.out.println("Resultado: Não é um palíndromo. ❌");
            }
        }
        leitor.close();
    }

    public static char removerAcentoManualmente(char c) {
        String comAcento = "áàâãéèêíìîóòôõúùûçÁÀÂÃÉÈÊÍÌÎÓÒÔÕÚÙÛÇ";
        String semAcento = "aaaaeeeiiioooouuucAAAAEEEIIIOOOOUUUC";
        
        int index = comAcento.indexOf(c);
        if (index != -1) {
            return semAcento.charAt(index);
        }
        return c; 
    }
}
