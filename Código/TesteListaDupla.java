public class TesteListaDupla {
    public static void main(String[] args) {
        ListaDupla lista = new ListaDupla();
        
        System.out.println("=== TESTE LISTA DUPLAMENTE ENCADEADA ===\n");
        
        System.out.println("Teste 1 - Lista vazia:");
        System.out.println(lista);
        System.out.println("Tamanho: " + lista.tamanho());
        System.out.println();
        
        System.out.println("Teste 2 - Inserir no início:");
        lista.insereInicio(new Livro("111", "Livro A", "Autor1", 2020));
        System.out.println(lista);
        lista.insereInicio(new Livro("222", "Livro B", "Autor2", 2021));
        System.out.println(lista);
        lista.insereInicio(new Livro("333", "Livro C", "Autor3", 2022));
        System.out.println(lista);
        System.out.println("Tamanho: " + lista.tamanho());
        System.out.println();
        
        System.out.println("Teste 3 - Inserir no fim:");
        lista.insereFim(new Livro("444", "Livro D", "Autor4", 2023));
        System.out.println(lista);
        lista.insereFim(new Livro("555", "Livro E", "Autor5", 2024));
        System.out.println(lista);
        System.out.println("Tamanho: " + lista.tamanho());
        System.out.println();
        
        System.out.println("Teste 4 - Listar do início:");
        lista.listarDoInicio();
        System.out.println();
        
        System.out.println("Teste 5 - Listar do fim:");
        lista.listarDoFim();
        System.out.println();
        
        System.out.println("Teste 6 - Buscar por ISBN:");
        Livro encontrado = lista.buscarPorIsbn("333");
        if (encontrado != null) {
            System.out.println("ISBN 333 encontrado: " + encontrado);
        } else {
            System.out.println("ISBN 333 não encontrado");
        }
        
        encontrado = lista.buscarPorIsbn("999");
        if (encontrado != null) {
            System.out.println("ISBN 999 encontrado: " + encontrado);
        } else {
            System.out.println("ISBN 999 não encontrado");
        }
        System.out.println();
        
        System.out.println("Teste 7 - Remover primeiro:");
        Livro removido = lista.removePrimeiro();
        System.out.println("Removeu: " + removido);
        System.out.println(lista);
        System.out.println("Tamanho: " + lista.tamanho());
        System.out.println();
        
        System.out.println("Teste 8 - Remover último:");
        removido = lista.removeUltimo();
        System.out.println("Removeu: " + removido);
        System.out.println(lista);
        System.out.println("Tamanho: " + lista.tamanho());
        System.out.println();
        
        System.out.println("Teste 9 - Remover até esvaziar:");
        while (!lista.estaVazia()) {
            System.out.println("Removendo: " + lista.removePrimeiro().getTitulo());
        }
        System.out.println(lista);
        System.out.println("Tamanho: " + lista.tamanho());
        System.out.println();
        
        System.out.println("Teste 10 - Remover de lista vazia:");
        System.out.println("removePrimeiro(): " + lista.removePrimeiro());
        System.out.println("removeUltimo(): " + lista.removeUltimo());
        
        System.out.println("\n=== FIM DOS TESTES ===");
    }
}
