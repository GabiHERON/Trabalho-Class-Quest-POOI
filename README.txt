========================================================================
                 Class Quest / TRABALHO FINAL POO I
========================================================================

DESCRICAO:
-----------
Este e um jogo de RPG de texto desenvolvido pelos alunos Bruno Hiert 
Rech, Erika Kirchbaner e Gabriel Heron. Para o desenvolvimento do jogo, 
os alunos utilizaram conhecimentos adquiridos durante a materia semestral 
de Programacao Orientada a Objetos I e a linguagem de programacao Java.

No jogo, e possivel criar um personagem (Guerreiro, Mago ou Ladino), 
enfrentar eventos aleatorios, coletar itens e moedas, e salvar o 
progresso.

REQUISITOS DO SISTEMA:
----------------------
* Java JDK: Versao 17 ou superior instalada.
* Sistema Operacional: Windows, Linux ou macOS.

COMO COMPILAR O PROJETO:
------------------------
Se voce estiver utilizando o terminal/prompt de comando, navegue ate a 
pasta onde estao os arquivos '.java' e execute:

   javac AppJogo.java

COMO EXECUTAR O JOGO:
---------------------
Apos compilar com sucesso, execute a classe principal (AppJogo) 
utilizando o comando:

   java AppJogo

COMO JOGAR:
-----------
1. Ao iniciar, escolha se deseja abrir um jogo salvo, ou criar um novo.
   1.1. Caso seja escolhido criar um novo, o jogador devera escolher um 
        nome para seu personagem e uma classe para ele (Guerreiro, Mago 
        ou Ladino).
   1.2. Caso seja escolhido abrir um jogo previamente salvo, sera 
        carregado onde o jogo foi interrompido da ultima vez.
2. A cada turno, selecione o evento que deseja enfrentar ou escolha 
   a opcao de Salvar e Sair para guardar seu progresso. (E importante 
   ressaltar que os eventos sao aleatorizados, para que assim, o 
   jogador nao possa calcular sua proxima acao).
3. Ao longo do jogo, o jogador ira vencendo suas batalhas, ganhando 
   moedas e trocando-as por itens da loja que melhoram seu desempenho 
   em lutas. Ao escolher o evento fogueira, o personagem consegue se 
   regenerar, e ao escolher o evento Bau do Tesouro, existe a chance 
   do jogador encontrar moedas.

ESTRUTURA DAS CLASSES PRINCIPAIS:
---------------------------------
* AppJogo.java           - Ponto de entrada do programa e controle do menu.
* Personagem.java        - Classe base para os herois (Guerreiro, Mago, Ladino).
* Evento.java            - Interface para os eventos do jogo.
* GereciandorSaves.java  - Gerencia a persistencia de dados do jogador.

========================================================================