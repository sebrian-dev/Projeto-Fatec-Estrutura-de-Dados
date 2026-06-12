public class NossoHash<K, V> {

    private static final int CAPACIDADE_INICIAL = 16;
    private Entrada<K, V>[] tabela;

    @SuppressWarnings("unchecked")
    public NossoHash() {
        tabela = (Entrada<K, V>[]) new Entrada[CAPACIDADE_INICIAL];
    }

    private int hash(K key) {
        if (key == null) {
            return 0;
        }
        return Math.abs(key.hashCode()) % tabela.length;
    }

    public void put(K key, V value) {
        int posicao = hash(key);
        Entrada<K, V> novaEntrada = new Entrada<>(key, value);
        novaEntrada.proximo = tabela[posicao];
        tabela[posicao] = novaEntrada;
    }

    public V get(K key) {
        int posicao = hash(key);
        Entrada<K, V> atual = tabela[posicao];

        while (atual != null) {
            if (chavesIguais(atual.key, key)) {
                return atual.value;
            }
            atual = atual.proximo;
        }

        return null;
    }

    public boolean containsKey(K key) {
        int posicao = hash(key);
        Entrada<K, V> atual = tabela[posicao];

        while (atual != null) {
            if (chavesIguais(atual.key, key)) {
                return true;
            }
            atual = atual.proximo;
        }

        return false;
    }

    public boolean containsValue(V value) {
        for (Entrada<K, V> entrada : tabela) {
            Entrada<K, V> atual = entrada;

            while (atual != null) {
                if (valoresIguais(atual.value, value)) {
                    return true;
                }
                atual = atual.proximo;
            }
        }

        return false;
    }

    public void exibeMap() {
        for (int i = 0; i < tabela.length; i++) {
            System.out.print(i + ": ");
            Entrada<K, V> atual = tabela[i];

            if (atual == null) {
                System.out.println("vazio");
                continue;
            }

            while (atual != null) {
                System.out.print("[" + atual.key + " = " + atual.value + "]");
                atual = atual.proximo;

                if (atual != null) {
                    System.out.print(" -> ");
                }
            }
            System.out.println();
        }
    }

    private boolean chavesIguais(K chave1, K chave2) {
        if (chave1 == null) {
            return chave2 == null;
        }
        return chave1.equals(chave2);
    }

    private boolean valoresIguais(V valor1, V valor2) {
        if (valor1 == null) {
            return valor2 == null;
        }
        return valor1.equals(valor2);
    }
}
