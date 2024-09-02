import java.io.FileWriter;
import java.io.IOException;

class Compilador{

	public static void main(String[]args)
	{	
		ArvoreSintatica arv=null;
	
		try{

			AnaliseLexica al = new AnaliseLexica(args[0]);
			Parser as = new Parser(al);
		
			arv = as.parseProg();
		
			CodeGen backend = new CodeGen();
			String codigo = backend.geraCodigo(arv);
			System.out.println(codigo);

			// Salva o conteúdo em um arquivo
			try {
				FileWriter writer = new FileWriter("maquina_pilha.txt");
				writer.write(codigo);
				writer.close();
			} catch (IOException e) {
				System.err.println("Erro ao salvar o conteúdo no arquivo: " + e.getMessage());
			}

			System.out.println("\n --- Interpretador --- ");
			Interpretador backend2 = new Interpretador();
			int codigo2 = backend2.geraResult(arv);
			System.out.println("Resultado: "+codigo2);

		}catch(Exception e)
		{			
			System.out.println("Erro de compilação:\n" + e);
		}



	}
}
