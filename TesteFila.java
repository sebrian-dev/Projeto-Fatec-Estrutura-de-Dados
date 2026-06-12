public class TesteFila {

    public static void main(String[] args) {

        Fila<String> fila = new Fila<>();

        fila.enfileira("Kaique top");
        fila.enfileira("Jorginho Granada");
        fila.enfileira("Eduardo Jacinto");

        System.out.println(fila);

        System.out.println("Primeiro: " + fila.primeiro());

        System.out.println("Removido: " + fila.desenfileira());

        System.out.println(fila);

        System.out.println("Tamanho: " + fila.tamanho());
    }
}