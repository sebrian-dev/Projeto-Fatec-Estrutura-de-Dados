public class ListaDupla {
    private NoDuplo primeiro;
    private NoDuplo ultimo;

    public boolean estaVazia() {
        return primeiro == null;
    }

    public void insereInicio(Livro livro) {
        NoDuplo novo = new NoDuplo(livro);
        if (estaVazia()) {
            ultimo = novo;
        } else {
            novo.setProximo(primeiro);
            primeiro.setAnterior(novo);
        }
        primeiro = novo;
    }

    public void insereFim(Livro livro) {
        NoDuplo novo = new NoDuplo(livro);
        if (estaVazia()) {
            primeiro = novo;
        } else {
            novo.setAnterior(ultimo);
            ultimo.setProximo(novo);
        }
        ultimo = novo;
    }

    public Livro removePrimeiro() {
        if (estaVazia()) return null;
        Livro removido = primeiro.getLivro();
        primeiro = primeiro.getProximo();
        if (primeiro == null) {
            ultimo = null;
        } else {
            primeiro.setAnterior(null);
        }
        return removido;
    }

    public Livro removeUltimo() {
        if (estaVazia()) return null;
        Livro removido = ultimo.getLivro();
        ultimo = ultimo.getAnterior();
        if (ultimo == null) {
            primeiro = null;
        } else {
            ultimo.setProximo(null);
        }
        return removido;
    }

    public Livro buscarPorIsbn(String isbn) {
        NoDuplo atual = primeiro;
        while (atual != null) {
            if (atual.getLivro().getIsbn().equals(isbn)) {
                return atual.getLivro();
            }
            atual = atual.getProximo();
        }
        return null;
    }

    public void listarDoInicio() {
        if (estaVazia()) {
            System.out.println("Acervo vazio");
            return;
        }
        NoDuplo atual = primeiro;
        while (atual != null) {
            System.out.println(atual);
            atual = atual.getProximo();
        }
    }

    public void listarDoFim() {
        if (estaVazia()) {
            System.out.println("Acervo vazio");
            return;
        }
        NoDuplo atual = ultimo;
        while (atual != null) {
            System.out.println(atual);
            atual = atual.getAnterior();
        }
    }

    public int tamanho() {
        int count = 0;
        NoDuplo atual = primeiro;
        while (atual != null) {
            count++;
            atual = atual.getProximo();
        }
        return count;
    }

    @Override
    public String toString() {
        if (estaVazia()) return "Lista vazia";
        StringBuilder sb = new StringBuilder();
        NoDuplo atual = primeiro;
        while (atual != null) {
            sb.append(atual).append(" ");
            atual = atual.getProximo();
        }
        return sb.toString();
    }
}
