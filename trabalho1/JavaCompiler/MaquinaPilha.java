import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Stack;

public class MaquinaPilha {
    public static void main(String[] args) {
        Stack<Integer> pilha = new Stack<>();
        
        if (args.length < 1) {
            System.err.println("Por favor, forneça o nome do arquivo como argumento.");
            System.exit(1);
        }

        String nomeArquivo = args[0];

        try (BufferedReader arquivo = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            while ((linha = arquivo.readLine()) != null) {
                if (linha.equals("PRINT")) {
                    System.out.println(pilha.pop());
                } else if (linha.equals("SUM")) {
                    int num1 = pilha.pop();
                    int num2 = pilha.pop();
                    pilha.push(num1 + num2);
                } else if (linha.equals("SUB")) {
                    int num1 = pilha.pop();
                    int num2 = pilha.pop();
                    pilha.push(num2 - num1);
                } else if (linha.equals("MULT")) {
                    int num1 = pilha.pop();
                    int num2 = pilha.pop();
                    pilha.push(num1 * num2);
                } else if (linha.equals("DIV")) {
                    int num1 = pilha.pop();
                    int num2 = pilha.pop();
                    pilha.push(num2 / num1);
                } else if (linha.startsWith("PUSH")) {
                    pilha.push(Integer.parseInt(linha.split(" ")[1]));
                } else {
                    System.err.println("Comando inválido: " + linha);
                    System.exit(1);
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }

}
