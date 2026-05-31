# Algoritmo de Floyd-Warshall

## Objetivo da Atividade
Implementar o algoritmo de Floyd-Warshall utilizando uma **matriz de adjacência** para encontrar o menor caminho entre todos os pares de vértices de um grafo ponderado e direcionado.

## Como o Algoritmo Funciona?
O algoritmo de Floyd-Warshall compara todos os caminhos possíveis através do grafo entre cada par de vértices. Ele utiliza uma abordagem de **Programação Dinâmica**.

A essência do algoritmo é testar se um vértice `k` pode atuar como um "atalho" entre um vértice de origem `i` e um vértice de destino `j`.

**A Fórmula Principal:**
`d[i][j] = min(d[i][j], d[i][k] + d[k][j])`

Onde:
* `d[i][j]` é a distância direta atual de `i` para `j`.
* `d[i][k] + d[k][j]` é a distância de `i` para `j` passando pelo vértice intermediário `k`.

## Estrutura de Dados
* **Matriz Bidimensional:** O grafo é representado por uma matriz `N x N`.
* **Infinito (INF):** Utilizamos um valor alto (ex: `99999`) para representar a ausência de conexão direta entre dois nós. Evitamos usar o valor máximo absoluto (`Integer.MAX_VALUE`) para não causar *overflow* (estouro numérico) durante a soma das distâncias.

## Cenário de Teste
Para esta implementação, utilizamos um grafo com 4 vértices (A, B, C, D), cuja matriz de adjacência inicial é:
      A   B   C   D
  A   0   3  INF  7
  B   8   0   2  INF
  C   5  INF  0   1
  D   2  INF INF  0