# Desafio de Implementação: Remoção em Heaps

## Contexto
O objetivo deste desafio foi implementar um sistema de gerenciamento de um **Max-Heap** (Árvore Binária Completa onde o pai é sempre maior ou igual aos filhos) com foco na operação de **remoção por índice**.

## Lógica da Implementação

### 1. Inserção ($O(\log n)$)
- O elemento é adicionado ao final do array.
- O método `heapifyUp` é chamado para comparar o elemento com seu pai e trocá-los caso a regra do Max-Heap seja violada.

### 2. Remoção Estratégica ($O(\log n)$)
Para remover qualquer elemento sem destruir a árvore:
1. **Substituição:** O valor no índice desejado é substituído pelo **último** elemento do array.
2. **Corte:** O último elemento (agora duplicado) é removido.
3. **Equilíbrio (Heapify Down):** O novo valor que está na posição de remoção é comparado com seus filhos. Ele "desce" na árvore até encontrar um lugar onde seja maior que seus descendentes.

## Estrutura de Índices (Array)
Para um nó no índice `i`:
- **Filho Esquerdo:** `2i + 1`
- **Filho Direito:** `2i + 2`
- **Pai:** `(i - 1) / 2`

## Como usar o Laboratório
1. Execute o código Java.
2. Insira valores para ver a árvore sendo montada.
3. Use o comando de remoção por índice para observar o elemento do final do array assumindo o lugar do removido e descendo conforme necessário.
