import java.util.Scanner;

public class BibliotecaDigital{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Catalogo catalogo = new Catalogo();
        ListaDupla acervo = new ListaDupla();
        GestorEmprestimos gestorEmprestimos = new GestorEmprestimos(acervo);

        int esc;//varíavel para escolha
        boolean laco = true;//variável para controlar o laço de repetição
        boolean escolha = false;

        while(laco){
            System.out.println("\nMENU "+
                            "\n1 -> Cadastrar livro"+
                            "\n2 -> Buscar livro"+
                            "\n3 -> Listar Livros do ínicio ao fim"+
                            "\n4 -> Listar Livros do ínicio ao fim"+
                            "\n5 -> Solicitar empréstimo"+
                            "\n6 -> Devolver livro"+
                            "\n7 -> Ver fila de espera de um livro"+
                            "\n8 -> Sair");
            esc = sc.nextInt();
            if (esc > 8 || esc < 1) {
               
                
            }

            sc.nextLine();

            //Dados do Livro
            String isbn = new String();
            String titulo = new String();
            String autor = new String();
            int anoPub = 0;

            //Dados do Usuário
            int matricula;
            String nome = new String();
            String email = new String();

            switch (esc) {
                case 1://Cadastrar livro
                    try{
                        System.out.print("Digite o código do livro: ");
                        isbn = sc.nextLine();

                        System.out.print("Digite o titulo do livro: ");
                        titulo = sc.nextLine();

                        System.out.print("Digite o autor do livro: ");
                        autor = sc.nextLine();

                        System.out.print("Digite o ano de publicação do livro: ");
                        anoPub = sc.nextInt();

                        acervo.insereInicio(new Livro(isbn, titulo, autor, anoPub));
                        catalogo.cadastrar(new Livro(isbn, titulo, autor, anoPub));

                        System.out.println("Livro "+ titulo +" Cadastrado");
                    } catch(Exception e){
                        System.out.println("\nDigite apenas os valores válidos");
                        sc.nextLine();   
                    }
                    break;

                case 2://Buscar livro por ISBN
                    System.out.print("Digite o código do livro para busca: \n");
                    isbn = sc.nextLine();
                    if(catalogo.buscar(isbn) == null){
                        System.out.println("Nenhum livro encontrado");
                    }else{
                        System.out.println("Livro encontrado: "+ catalogo.buscar(isbn));
                    }
                   break;

                case 3://Listar do Início ao fim
                    System.out.println("Lista do acervo do Início ao Fim\n");
                    acervo.listarDoInicio();
                    break;

                case 4://Listar do Fim ao início
                    System.out.println("Lista do acervo do Fim ao Início\n");
                    acervo.listarDoFim();
                    break;

                case 5://Solicitar empréstimo
                    System.out.print("Digite o código do livro desejado: ");
                    isbn = sc.nextLine();
                    try{
                        System.out.print("Digite sua matrícula: ");
                        matricula = sc.nextInt();

                        sc.nextLine();

                        System.out.print("Digite o seu nome: ");
                        nome = sc.nextLine();

                        System.out.print("Digite o seu email: ");
                        email = sc.nextLine();

                        gestorEmprestimos.solicitarEmprestimo(isbn,new Usuario(matricula, nome, email));
                    } catch(Exception e){
                        System.out.println("Digite apenas valores válidos");
                        sc.nextLine();
                    }
                    
                    break;
                
                case 6://Devolver livro
                    System.out.print("Digite o código do livro para devolução: ");
                    isbn = sc.nextLine();
                    gestorEmprestimos.devolverLivro(isbn);
                    break;

                case 7://Ver a fila de espera de um livro
                    System.out.print("Digite o código do livro para busca: ");
                    isbn = sc.nextLine();

                    gestorEmprestimos.listarFilaDeEspera(isbn);
                    break;
            
                default://Sair
                    break;
            }

        }
    }
}