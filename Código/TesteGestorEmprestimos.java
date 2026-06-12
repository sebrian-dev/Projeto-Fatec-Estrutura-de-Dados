import java.util.Scanner;

public class TesteGestorEmprestimos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== TESTE GESTOR DE EMPRÉSTIMOS ===\n");
        
        ListaDupla acervo = new ListaDupla();
        
        System.out.println("--- Cadastro inicial de livros ---");
        System.out.print("Quantos livros deseja cadastrar? ");
        int qtdLivros = scanner.nextInt();
        scanner.nextLine();
        
        for (int i = 0; i < qtdLivros; i++) {
            System.out.println("\nLivro " + (i + 1) + ":");
            System.out.print("ISBN: ");
            String isbn = scanner.nextLine();
            System.out.print("Título: ");
            String titulo = scanner.nextLine();
            System.out.print("Autor: ");
            String autor = scanner.nextLine();
            System.out.print("Ano de publicação: ");
            int ano = scanner.nextInt();
            scanner.nextLine();
            
            Livro livro = new Livro(isbn, titulo, autor, ano);
            acervo.insereFim(livro);
            System.out.println("✓ Livro cadastrado!");
        }
        
        // Cadastrar usuários
        System.out.println("\n--- Cadastro de usuários ---");
        System.out.print("Quantos usuários deseja cadastrar? ");
        int qtdUsuarios = scanner.nextInt();
        scanner.nextLine();
        
        Usuario[] usuarios = new Usuario[qtdUsuarios];
        for (int i = 0; i < qtdUsuarios; i++) {
            System.out.println("\nUsuário " + (i + 1) + ":");
            System.out.print("Matrícula: ");
            int matricula = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Nome: ");
            String nome = scanner.nextLine();
            System.out.print("E-mail: ");
            String email = scanner.nextLine();
            
            usuarios[i] = new Usuario(matricula, nome, email);
            System.out.println("✓ Usuário cadastrado!");
        }
        
        GestorEmprestimos gestor = new GestorEmprestimos(acervo);
        
        int opcao;
        do {
            System.out.println("\n=== MENU GESTOR DE EMPRÉSTIMOS ===");
            System.out.println("1 - Solicitar empréstimo");
            System.out.println("2 - Devolver livro");
            System.out.println("3 - Listar fila de espera de um livro");
            System.out.println("4 - Listar todos os livros");
            System.out.println("5 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();
            
            switch (opcao) {
                case 1:
                    System.out.println("\n--- Solicitar empréstimo ---");
                    System.out.print("ISBN do livro: ");
                    String isbn = scanner.nextLine();
                    
                    System.out.println("Usuários disponíveis:");
                    for (int i = 0; i < usuarios.length; i++) {
                        System.out.println((i + 1) + " - " + usuarios[i].getNome() + " (Matrícula: " + usuarios[i].getMatricula() + ")");
                    }
                    System.out.print("Escolha o usuário (número): ");
                    int escolha = scanner.nextInt();
                    scanner.nextLine();
                    
                    if (escolha >= 1 && escolha <= usuarios.length) {
                        gestor.solicitarEmprestimo(isbn, usuarios[escolha - 1]);
                    } else {
                        System.out.println("Opção inválida!");
                    }
                    break;
                    
                case 2:
                    System.out.println("\n--- Devolver livro ---");
                    System.out.print("ISBN do livro a ser devolvido: ");
                    isbn = scanner.nextLine();
                    gestor.devolverLivro(isbn);
                    break;
                    
                case 3:
                    System.out.println("\n--- Listar fila de espera ---");
                    System.out.print("ISBN do livro: ");
                    isbn = scanner.nextLine();
                    gestor.listarFilaDeEspera(isbn);
                    break;
                    
                case 4:
                    System.out.println("\n--- Listar todos os livros ---");
                    System.out.println("Do início ao fim:");
                    acervo.listarDoInicio();
                    System.out.println("\nDo fim ao início:");
                    acervo.listarDoFim();
                    break;
                    
                case 5:
                    System.out.println("\nSaindo...");
                    break;
                    
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 5);
        
        scanner.close();
        System.out.println("\n=== FIM DOS TESTES ===");
    }
}
