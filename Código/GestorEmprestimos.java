public class GestorEmprestimos {
    private NossoHash<String, Fila<Usuario>> esperaPorIsbn;
    private ListaDupla acervo;

    public GestorEmprestimos(ListaDupla acervo) {
        this.esperaPorIsbn = new NossoHash<>();
        this.acervo = acervo;
    }

    public void solicitarEmprestimo(String isbn, Usuario usuario) {
        Livro livro = acervo.buscarPorIsbn(isbn);

        if (livro == null) {
            System.out.println("Erro: Livro com ISBN " + isbn + " não encontrado no acervo.");
            return;
        }

        if (livro.isDisponivel()) {
            livro.setDisponivel(false);
            System.out.println("✓ Empréstimo concedido: " + livro.getTitulo() + " para " + usuario.getNome());
        } else {
            Fila<Usuario> fila = esperaPorIsbn.get(isbn);
            if (fila == null) {
                fila = new Fila<>();
                esperaPorIsbn.put(isbn, fila);
            }
            fila.enfileira(usuario);
            System.out.println(usuario.getNome() + " entrou na fila de espera para: " + livro.getTitulo());
        }
    }

    public void devolverLivro(String isbn) {
        Livro livro = acervo.buscarPorIsbn(isbn);

        if (livro == null) {
            System.out.println("Erro: Livro com ISBN " + isbn + " não encontrado.");
            return;
        }

        if (livro.isDisponivel()) {
            System.out.println("Aviso: Livro já estava disponível.");
            return;
        }

        Fila<Usuario> fila = esperaPorIsbn.get(isbn);

        if (fila != null && !fila.filaVazia()) {
            try {
                Usuario proximo = fila.desenfileira();
                System.out.println("✓ Livro devolvido. Próximo da fila: " + proximo.getNome());
                System.out.println("  Empréstimo automático concedido para " + proximo.getNome());
            } catch (Exception e) {
                System.out.println("Erro ao desenfileirar: " + e.getMessage());
            }
        } else {
            livro.setDisponivel(true);
            System.out.println("✓ Livro devolvido e agora está DISPONÍVEL: " + livro.getTitulo());
        }
    }

    public void listarFilaDeEspera(String isbn) {
        Livro livro = acervo.buscarPorIsbn(isbn);

        if (livro == null) {
            System.out.println("Erro: Livro com ISBN " + isbn + " não encontrado.");
            return;
        }

        Fila<Usuario> fila = esperaPorIsbn.get(isbn);

        System.out.println("\n=== FILA DE ESPERA ===");
        System.out.println("Livro: " + livro.getTitulo());
        System.out.println("Status: " + (livro.isDisponivel() ? "DISPONÍVEL" : "INDISPONÍVEL"));

        if (fila == null || fila.filaVazia()) {
            System.out.println("Nenhum usuário na fila de espera.");
        } else {
            System.out.println("Fila: " + fila);
        }
        System.out.println("=====================\n");
    }
}