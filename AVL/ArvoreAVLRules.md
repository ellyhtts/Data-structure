# Desafio de Implementação: Árvore AVL (Auto-balanceada)

## Contexto
Este projeto aprimora a implementação de uma Árvore de Busca Binária (BST) comum, transformando-a em uma **Árvore AVL**. A principal diferença é que a AVL garante que a árvore permaneça balanceada após cada inserção, otimizando o tempo de busca para `O(log n)`.

## Lógica da Implementação (Regras de Balanceamento)

### 1. Controle de Altura
Cada nó da árvore agora armazena sua própria altura. A altura de um nó folha é 1.

### 2. Fator de Balanceamento
Calculado através da fórmula:
`Balanceamento = Altura(Subárvore Esquerda) - Altura(Subárvore Direita)`
Se o resultado for maior que 1 ou menor que -1, a árvore está desbalanceada e precisa de rotação.

### 3. As 4 Rotações Obrigatórias
Quando um desbalanceamento é detectado, aplicamos uma das 4 rotações:
* **LL (Esquerda-Esquerda):** Rotação Simples à Direita.
* **RR (Direita-Direita):** Rotação Simples à Esquerda.
* **LR (Esquerda-Direita):** Rotação à Esquerda no filho, seguida de Rotação à Direita no pai.
* **RL (Direita-Esquerda):** Rotação à Direita no filho, seguida de Rotação à Esquerda no pai.