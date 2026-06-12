public class NoDuplo {
    private Livro livro;
    private NoDuplo anterior;
    private NoDuplo proximo;

    public NoDuplo(Livro livro) {
        this.livro = livro;
        this.anterior = null;
        this.proximo = null;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public NoDuplo getAnterior() {
        return anterior;
    }

    public void setAnterior(NoDuplo anterior) {
        this.anterior = anterior;
    }

    public NoDuplo getProximo() {
        return proximo;
    }

    public void setProximo(NoDuplo proximo) {
        this.proximo = proximo;
    }

    @Override
    public String toString() {
        return livro.toString();
    }
}
