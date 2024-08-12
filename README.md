# Compiladores

Trabalhos práticos elaborados na disciplina de Projeto de Compiladores.

## Comando de Execução

**OBS**: Os comandos devem ser executados dentro da pasta do trabalho

### Trabalho 1

Remover arquivos .class:
    ```bash
    rm *.class
    ```

1. Compile os arquivos Java:

    ```bash
    javac *.java
    ```

2. Execute o compilador:

    ```bash
    java Compilador ../exemplos/teste
    ```

3. Execute a máquina de pilha:

    ```bash
    java MaquinaPilha .\maquina_pilha.txt
    ```


### Trabalho 2 e Trabalho 3

**OBS**: Executar comandos dentro da pasta do Karloff

Remover arquivos .class e .java:  
    ```bash
    rm *.class
    ```   
    ```bash
    rm *.java
    ```

1. Gere o parser com o JavaCC:

    ```bash
    java -cp C:\Users\yasmi\codigos_github\projeto-de-compiladores\javacc-javacc-7.0.13\javacc-javacc-7.0.13\bootstrap\javacc.jar javacc Karloff.jj
    ```

2. Compile os arquivos Java:

    ```bash
    javac *.java
    ```

3. Execute o parser:

    ```bash
    java Karloff ../exemplos/exemplo.kar
    ```
