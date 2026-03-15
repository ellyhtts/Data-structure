public class playmusic_comentado {

    // 1. Estrutura do Nó (Música)
    // Em estruturas de dados, chamamos cada elemento de "Nó" (Node).
    // Como é uma Lista Duplamente Encadeada, cada nó precisa conhecer quem vem antes e quem vem depois.
    static class Musica {
        int id;
        String nome;
        String artista;
        Musica proximo;  // Ponteiro: Guarda a referência de memória da PRÓXIMA música
        Musica anterior; // Ponteiro: Guarda a referência de memória da música ANTERIOR

        // Construtor: Inicializa a música. Quando criada, ela ainda não está ligada a nenhuma outra.
        public Musica(int id, String nome, String artista) {
            this.id = id;
            this.nome = nome;
            this.artista = artista;
            this.proximo = null;  // null significa que não aponta para nada ainda
            this.anterior = null; // null significa que não aponta para nada ainda
        }
    }

    // 2. Estrutura da Lista Duplamente Encadeada (Playlist)
    // Aqui nós gerenciamos os nós criados acima.
    static class Playlist {
        Musica inicio;      // Ponteiro para o primeiro elemento (Head / Cabeça)
        Musica fim;         // Ponteiro para o último elemento (Tail / Cauda)
        Musica musicaAtual; // Ponteiro extra de estado para sabermos onde o usuário está no player

        public Playlist() {
            this.inicio = null; // Lista começa vazia
            this.fim = null;    // Lista começa vazia
            this.musicaAtual = null;
        }

        // Adicionar música no final da playlist
        // Complexidade O(1) - Rápido, pois usamos o ponteiro 'fim' direto, sem precisar percorrer a lista inteira.
        public void adicionarNoFinal(int id, String nome, String artista) {
            Musica novaMusica = new Musica(id, nome, artista);

            if (inicio == null) { 
                // CASO 1: A lista está vazia. O primeiro e o último elemento são a nova música.
                inicio = novaMusica;
                fim = novaMusica;
            } else {
                // CASO 2: Já existem músicas.
                fim.proximo = novaMusica; // O elemento que era o último agora aponta para a nova música
                novaMusica.anterior = fim; // A nova música aponta para trás, para o antigo último elemento
                fim = novaMusica; // Atualizamos o ponteiro 'fim' geral da lista para ser a nova música
            }
        }

        // Remover música do início (Cabeça) a medida que for sendo ouvida
        public void removerDoInicio() {
            if (inicio == null) {
                // Prevenção de erro caso tentem remover de uma lista que já está vazia
                System.out.println("❌ A playlist já está vazia.");
                return;
            }

            System.out.println("🗑️ Removendo música ouvida: " + inicio.nome + " - " + inicio.artista);
            
            // Se a música que está tocando agora for a que vamos remover, o player avança para a próxima
            if (musicaAtual == inicio) {
                musicaAtual = inicio.proximo;
            }

            // O início da lista passa a ser o SEGUNDO elemento
            inicio = inicio.proximo; 

            if (inicio != null) {
                // Se a lista não ficou vazia após a remoção, o novo primeiro elemento não pode ter ninguém antes dele
                inicio.anterior = null; 
            } else {
                // Se o início ficou null, significa que removemos a única música que existia.
                // Logo, o 'fim' também precisa ser null para a lista ficar 100% vazia.
                fim = null; 
            }
        }

        // Listar músicas do início ao fim (Percorre usando ponteiro 'proximo')
        public void listarNormal() {
            System.out.println("\n--- 📜 Playlist (Normal) ---");
            if (inicio == null) {
                System.out.println("Playlist vazia.");
                return;
            }
            Musica atual = inicio; // Começa da cabeça
            while (atual != null) { // Vai pulando de nó em nó até achar um null (fim da lista)
                System.out.println(atual.id + ". " + atual.nome + " - " + atual.artista);
                atual = atual.proximo;
            }
        }

        // Listar músicas do fim ao início 
        // A grande vantagem da Lista Duplamente Encadeada: podemos percorrer de trás para frente!
        public void listarReversa() {
            System.out.println("\n--- 🔄 Playlist (Reversa) ---");
            if (fim == null) {
                System.out.println("Playlist vazia.");
                return;
            }
            Musica atual = fim; // Começa da cauda
            while (atual != null) { // Vai pulando para trás usando o ponteiro 'anterior'
                System.out.println(atual.id + ". " + atual.nome + " - " + atual.artista);
                atual = atual.anterior;
            }
        }

        // --- SIMULADOR DE PLAYER ---

        public void comecarPlayer() {
            if (inicio != null) {
                musicaAtual = inicio; // Define o ponteiro de estado na primeira música
                System.out.println("\n▶️ Tocando agora: " + musicaAtual.nome);
            } else {
                System.out.println("Playlist vazia.");
            }
        }

        public void avancar() {
            // Verifica se existe uma música atual e se existe uma PRÓXIMA música
            if (musicaAtual != null && musicaAtual.proximo != null) {
                musicaAtual = musicaAtual.proximo; // Move o ponteiro para a frente
                System.out.println("⏭️ Avançou para: " + musicaAtual.nome);
            } else {
                System.out.println("⚠️ Você já está na última música.");
            }
        }

        public void voltar() {
            // Verifica se existe uma música atual e se existe uma música ANTERIOR
            if (musicaAtual != null && musicaAtual.anterior != null) {
                musicaAtual = musicaAtual.anterior; // Move o ponteiro para trás
                System.out.println("⏮️ Voltou para: " + musicaAtual.nome);
            } else {
                System.out.println("⚠️ Você já está na primeira música.");
            }
        }
    }

    public static void main(String[] args) {
        Playlist minhaPlaylist = new Playlist();

        // 1. Inserir 5 músicas obrigatórias
        minhaPlaylist.adicionarNoFinal(1, "Imagine", "John Lennon");
        minhaPlaylist.adicionarNoFinal(2, "Billie Jean", "Michael Jackson");
        minhaPlaylist.adicionarNoFinal(3, "Halo", "Beyoncé");
        minhaPlaylist.adicionarNoFinal(4, "Numb", "Linkin Park");
        minhaPlaylist.adicionarNoFinal(5, "Viva La Vida", "Coldplay");

        // 2. Mostrar playlist normal
        minhaPlaylist.listarNormal();

        // 3. Mostrar playlist reversa
        minhaPlaylist.listarReversa();

        // 4. Simular navegação do Player
        System.out.println("\n--- 🎧 Simulador do Player ---");
        minhaPlaylist.comecarPlayer(); // 1ª Música
        minhaPlaylist.avancar();       // Avança 1
        minhaPlaylist.avancar();       // Avança 2
        minhaPlaylist.voltar();        // Volta 1

        // 5. Remover uma música do início
        System.out.println("\n--- 🧹 Limpando Playlist ---");
        minhaPlaylist.removerDoInicio();

        // 6. Mostrar playlist atualizada
        minhaPlaylist.listarNormal();
    }
}