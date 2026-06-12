public class Catalogo {

    private NossoHash<String, Livro> livros;

    public Catalogo() {
        livros = new NossoHash<>();
    }

    public void cadastrar(Livro livro) {
        livros.put(livro.getIsbn(), livro);
    }

    public Livro buscar(String isbn) {
        return livros.get(isbn);
    }

    public boolean existe(String isbn) {
        return livros.containsKey(isbn);
    }

    public void exibirCatalogo() {
        livros.exibeMap();
    }
}
