# Exercício Prático: Controle de Músicas (Playlist)



## Contexto
Você foi contratado para desenvolver um sistema simples de playlist de músicas. 
A playlist deve permitir navegar de forma bidirecional:
* ▶ Próxima música
* ◀ Música anterior

Para isso, você deverá implementar uma **Lista Duplamente Encadeada**.

## Estrutura de Dados

**Cada música (Nó) deve ter:**
* `id` (inteiro)
* `nome` (string)
* `artista` (string)
* `ponteiro proximo`
* `ponteiro anterior`

**A playlist (Lista) deve ter:**
* `ponteiro inicio`
* `ponteiro fim`

## Funcionalidades Obrigatórias

**Implementar:**
1. Adicionar música no final da playlist.
2. Remover música a medida que for sendo ouvida (do início).
3. Listar músicas do início ao fim.
4. Listar músicas do fim ao início.

**Simular player:**
* Começar na primeira música.
* Permitir avançar para a próxima.
* Permitir voltar para a anterior.

## Simulação Obrigatória no `main`

**1. Inserir pelo menos 5 músicas:**
* Imagine – John Lennon
* Billie Jean – Michael Jackson
* Halo – Beyoncé
* Numb – Linkin Park
* Viva La Vida – Coldplay

**2. Ações:**
* Mostrar a playlist normal.
* Mostrar a playlist reversa.
* **Simular navegação:**
    * Começa na primeira música.
    * Avança 2 músicas.
    * Volta 1 música.
* Remover uma música do início.
* Mostrar a playlist atualizada.

## Regras Importantes
* Atualizar corretamente os ponteiros `anterior` e `proximo`.
* Tratar casos de exceção:
    * Remoção do primeiro elemento.
    * Remoção do último elemento.
    * Tentativa de ação em lista vazia.
