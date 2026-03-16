# Tratamento de Colisão em Tabela Hash com Chaining (Encadeamento Externo)

## Objetivo da Atividade
Implementar uma Tabela Hash utilizando a técnica de encadeamento (*Separate Chaining*) para resolver colisões. Quando ocorrer uma colisão (ou seja, quando dois ou mais elementos gerarem o mesmo índice na função hash), os elementos deverão ser armazenados utilizando uma **lista encadeada** naquele índice específico da tabela.

## Cenário Proposto
Para aplicar a estrutura de dados, foi criado um sistema simplificado de **Cadastro de Alunos**. A chave principal de espalhamento (Hash) utilizada para calcular a posição na tabela é a **matrícula** do aluno.

## Como o Algoritmo Funciona?

**1. A Função Hash:**
O índice onde o aluno será armazenado é calculado através do operador de módulo: `matricula % capacidade_da_tabela`. Isso garante que o resultado sempre caia dentro dos limites do array.

**2. A Estrutura (Array de Listas):**
A Tabela Hash foi construída como um array (vetor) de Nós. Cada posição do array não guarda apenas um dado, mas sim a "cabeça" (início) de uma lista encadeada.

**3. Tratamento da Colisão:**
* **Sem colisão:** Se a posição calculada estiver vazia (`null`), o aluno é inserido diretamente.
* **Com colisão:** Se já existir um ou mais alunos naquela posição, o novo aluno aponta para o aluno que já estava lá (tornando-se o novo início da lista encadeada daquele índice específico).

## Arquivos Implementados
* **`Colisao.java`**: Código limpo com a implementação das classes `NoAluno`, `TabelaHash` e a execução principal forçando colisões propositais.
* **`ColisaoComentada.java`**: O mesmo código, porém detalhadamente comentado para fins de estudo e fixação do conceito de ponteiros e encadeamento.
