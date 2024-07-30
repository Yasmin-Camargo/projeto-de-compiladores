import java.io.*;

enum TokenType{ NUM, SOMA, MULT, SUB, DIV, APar,FPar, EOF}

class Token{
  String lexema;
  TokenType token;

 Token (String l, TokenType t)
 	{ lexema=l;token = t;}	

}

class AnaliseLexica {

	PushbackReader arquivo;

	AnaliseLexica(String a) throws Exception
	{
		
		this.arquivo = new PushbackReader(new FileReader(a));
		
	}

	Token getNextToken() throws Exception
	{	
		Token token;
		int eof = -1;
		char currchar;
		String currstring = "";
		int currchar1;

			do{ 
				currchar1 =  arquivo.read();
				currchar = (char) currchar1;
			} while (currchar == '\n' || currchar == ' ' || currchar =='\t' || currchar == '\r');
		
			
			if(currchar1 != eof && currchar1 !=10)
			{
				currstring = "";
				if (currchar >= '0' && currchar <= '9'){
					do {
						if (!(currchar >= '0' && currchar <= '9')){
							arquivo.unread(currchar1);
							break;
						}
						currstring += currchar;
						currchar1 = arquivo.read();
						currchar = (char) currchar1;
					} while (true);
		
					return (new Token (currstring, TokenType.NUM));
				}
				else
					currstring += currchar;
					switch (currchar){
						case '(':
							return (new Token (currstring,TokenType.APar));
						case ')':
							return (new Token (currstring,TokenType.FPar));
						case '+':
							return (new Token (currstring,TokenType.SOMA));
						case '*':
							return (new Token (currstring,TokenType.MULT));
						case '-':
							return (new Token (currstring,TokenType.SUB));
						case '/':
							return (new Token (currstring,TokenType.DIV));
						
						default: throw (new Exception("Caractere inválido: " + ((int) currchar)));
					}
			}

			arquivo.close();
			
		return (new Token(currstring,TokenType.EOF));
		
	}
}
