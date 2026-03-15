public class playmusic {

    static class Musica {
        int id;
        String nome;
        String artista;
        Musica proximo;
        Musica anterior;

        public Musica(int id, String nome, String artista) {
            this.id = id;
            this.nome = nome;
            this.artista = artista;
            this.proximo = null;
            this.anterior = null;
        }
    }

    static class Playlist {
        Musica inicio;
        Musica fim;
        Musica musicaAtual;

        public Playlist() {
            this.inicio = null;
            this.fim = null;
            this.musicaAtual = null;
        }

        public void adicionarNoFinal(int id, String nome, String artista) {
            Musica novaMusica = new Musica(id, nome, artista);

            if (inicio == null) {
                inicio = novaMusica;
                fim = novaMusica;
            } else {
                fim.proximo = novaMusica;
                novaMusica.anterior = fim;
                fim = novaMusica;
            }
        }

        public void removerDoInicio() {
            if (inicio == null) {
                System.out.println("❌ A playlist já está vazia.");
                return;
            }

            System.out.println("🗑️ Removendo música ouvida: " + inicio.nome + " - " + inicio.artista);
            
            if (musicaAtual == inicio) {
                musicaAtual = inicio.proximo;
            }

            inicio = inicio.proximo;

            if (inicio != null) {
                inicio.anterior = null; 
            } else {
                fim = null; 
            }
        }

        public void listarNormal() {
            System.out.println("\n--- 📜 Playlist (Normal) ---");
            if (inicio == null) {
                System.out.println("Playlist vazia.");
                return;
            }
            Musica atual = inicio;
            while (atual != null) {
                System.out.println(atual.id + ". " + atual.nome + " - " + atual.artista);
                atual = atual.proximo;
            }
        }

        public void listarReversa() {
            System.out.println("\n--- 🔄 Playlist (Reversa) ---");
            if (fim == null) {
                System.out.println("Playlist vazia.");
                return;
            }
            Musica atual = fim;
            while (atual != null) {
                System.out.println(atual.id + ". " + atual.nome + " - " + atual.artista);
                atual = atual.anterior;
            }
        }

        public void comecarPlayer() {
            if (inicio != null) {
                musicaAtual = inicio;
                System.out.println("\n▶️ Tocando agora: " + musicaAtual.nome);
            } else {
                System.out.println("Playlist vazia.");
            }
        }

        public void avancar() {
            if (musicaAtual != null && musicaAtual.proximo != null) {
                musicaAtual = musicaAtual.proximo;
                System.out.println("⏭️ Avançou para: " + musicaAtual.nome);
            } else {
                System.out.println("⚠️ Você já está na última música.");
            }
        }

        public void voltar() {
            if (musicaAtual != null && musicaAtual.anterior != null) {
                musicaAtual = musicaAtual.anterior;
                System.out.println("⏮️ Voltou para: " + musicaAtual.nome);
            } else {
                System.out.println("⚠️ Você já está na primeira música.");
            }
        }
    }

    public static void main(String[] args) {
        Playlist minhaPlaylist = new Playlist();

        minhaPlaylist.adicionarNoFinal(1, "Imagine", "John Lennon");
        minhaPlaylist.adicionarNoFinal(2, "Billie Jean", "Michael Jackson");
        minhaPlaylist.adicionarNoFinal(3, "Halo", "Beyoncé");
        minhaPlaylist.adicionarNoFinal(4, "Numb", "Linkin Park");
        minhaPlaylist.adicionarNoFinal(5, "Viva La Vida", "Coldplay");

        minhaPlaylist.listarNormal();
        minhaPlaylist.listarReversa();

        System.out.println("\n--- 🎧 Simulador do Player ---");
        minhaPlaylist.comecarPlayer();
        minhaPlaylist.avancar();
        minhaPlaylist.avancar();
        minhaPlaylist.voltar();

        System.out.println("\n--- 🧹 Limpando Playlist ---");
        minhaPlaylist.removerDoInicio();

        minhaPlaylist.listarNormal();
    }
}