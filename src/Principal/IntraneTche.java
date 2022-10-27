package Principal;

import java.util.Scanner;
import Apoio.Autor;
import Apoio.Noticia;

/*
INSTRUÇÕES GERAIS
-O projeto deverá se chamar IntraneTche. Construir na classe principal desse projeto (IntraneTche.java) o menu e a
lógica de chamada para as demais classes.
-A Intranet deve permitir até 2000 postagens e no máximo 50 autores.
-Os autores precisam ser cadastrados antes de serem cadastradas notícias.
-No momento de cadastrar uma notícia, listar os autores disponíveis e pedir para que o usuário escolha um da lista.
-Realizar as validações necessárias
-Fornecer mensagens adequadas
 */
public class IntraneTche {

    private static int indAutor = 0;
    private static int indNoticia = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("\t\tIntraneTche\n");
        
        System.out.print("Quantos autores serão cadastrados: ");
        int qtdAutor = sc.nextInt();

        System.out.print("Quantas notícias serão cadastradas: ");
        int qtdNot = sc.nextInt();
        System.out.println();

        Autor autores[] = new Autor[qtdAutor];
        Noticia noticias[] = new Noticia[qtdNot];

        int opcao = 1;
        while (opcao != 7) {
            System.out.println("\t\tMenu de opções:\n"
                    + "[1] - Cadastrar um autor\n"
                    + "[2] - Listar autores cadastrados\n"
                    + "[3] - Cadastrar notícia\n"
                    + "[4] - Listar todas notícias cadastradas\n"
                    + "[5] - Listar notícias de um determinado autor – usuário informa o nome do autor\n"
                    + "[6] - Excluir notícia\n"
                    + "[7] - Sair");
            do {
                if (opcao < 1 || opcao > 7) {
                    System.out.print("Digite uma opção válida: ");
                }
                opcao = sc.nextInt();
            } while (opcao < 1 || opcao > 7);
            System.out.println();

            switch (opcao) {
                case 1:
                    if (indAutor == autores.length) {
                        System.out.println("Todos os autores foram cadastrados!\n");
                    } else {
                        cadastrarAutor(sc, autores);
                    }
                    break;
                case 2:
                    listarAutor(autores);
                    break;
                case 3:
                    if (indNoticia == noticias.length) {
                        System.out.println("Todas as noticias foram cadastrados!\n");
                    } else {
                        cadastrarNoticia(sc, noticias, autores);
                    }
                    break;
                case 4:
                    listarNoticia(noticias);
                    break;
                case 5:
                    noticiaAutor(sc, noticias, autores);
                    break;
                case 6:
                    excluirNoticia(sc, noticias);
                    break;
                case 7:
                    System.exit(0);
                    break;
            }
        }
    }

    private static void cadastrarAutor(Scanner leitura, Autor[] vetorAutor) {
        Autor autor = new Autor();

        autor.setCodigo();

        System.out.print("Digite o nome do autor: ");
        String nome = leitura.next();
        nome += leitura.nextLine();

        autor.setNome(nome);

        vetorAutor[indAutor] = autor;

        indAutor++;

        System.out.println();
    }

    private static void listarAutor(Autor[] vetorAutor) {
        int i = 0;
        System.out.printf("%-8s%-15s%n", "Código", "Nome");
        while (i < indAutor) {
            System.out.printf("%-8s%-15s%n", vetorAutor[i].getCodigo(), vetorAutor[i].getNome());

            i++;
        }
        System.out.println();
    }

    private static void cadastrarNoticia(Scanner leitura, Noticia[] vetorNoticia, Autor[] vetorAutor) {
        Noticia noticia = new Noticia();

        noticia.setCodigo();

        System.out.print("Digite o título da notícia: ");
        String titulo = leitura.next();
        titulo += leitura.nextLine();

        noticia.setTitulo(titulo);

        System.out.print("Digite a descrição da notícia: ");
        String descricao = leitura.next();
        descricao += leitura.nextLine();

        noticia.setDescricao(descricao);

        System.out.println("Escolha o autor da notícia:");
        int opAutor = 1;
        int i = 0;
        while (i < vetorAutor.length) {
            System.out.println("[" + (i + 1) + "] - " + vetorAutor[i].getNome());
            i++;
        }
        do {
            if (opAutor < 1 || opAutor > vetorAutor.length) {
                System.out.print("Digite uma opção válida: ");
            }
            opAutor = leitura.nextInt();
        } while (opAutor < 1 || opAutor > vetorAutor.length);
        System.out.println();

        noticia.setAutor(vetorAutor[opAutor - 1]);

        vetorNoticia[indNoticia] = noticia;

        indNoticia++;

        System.out.println();
    }

    private static void listarNoticia(Noticia[] vetorNoticia) {
        int i = 0;
        System.out.printf("%-8s%-15s%-10s%-20s%n", "Código", "Título", "Autor", "Descrição");
        while (i < indNoticia) {
            if (vetorNoticia[i] != null) {
                System.out.printf("%-8s%-15s%-10s%-20s%n",
                        vetorNoticia[i].getCodigo(), vetorNoticia[i].getTitulo(), vetorNoticia[i].getAutor().getNome(), vetorNoticia[i].getDescricao());
            }
            i++;
        }
        System.out.println();
    }

    private static void noticiaAutor(Scanner leitura, Noticia[] vetorNoticia, Autor[] vetorAutor) {
        listarAutor(vetorAutor);

        System.out.print("Digite o nome do autor que deseja ver a notícia: ");
        String autor = leitura.next();
        autor += leitura.nextLine();

        autor = autor.toLowerCase().trim();

        System.out.println();

        Boolean header = true;
        int i = 0;
        while (i < indNoticia) {
            if (vetorNoticia[i].getAutor().getNome().toLowerCase().trim().contains(autor)) {

                if (header) {
                    System.out.printf("%-8s%-15s%-10s%-20s%n", "Código", "Título", "Autor", "Descrição");
                }

                System.out.printf("%-8s%-15s%-10s%-20s%n",
                        vetorNoticia[i].getCodigo(), vetorNoticia[i].getTitulo(), vetorNoticia[i].getAutor().getNome(), vetorNoticia[i].getDescricao());

                header = false;
            }
            i++;
        }
        System.out.println();
    }

    private static void excluirNoticia(Scanner leitura, Noticia[] vetorNoticia) {
        listarNoticia(vetorNoticia);

        System.out.print("Digite o código da notícia que deseja excluir: ");
        int codNoticia = leitura.nextInt();

        int i = 0;
        Boolean flag = false;
        while (i < indNoticia) {
            if (vetorNoticia[i].getCodigo() == codNoticia) {
                vetorNoticia[i] = null;
                flag = true;
            }
            i++;
        }
        
        if (flag) {
            System.out.println("Notícia exluída!\n");
        }
        
        listarNoticia(vetorNoticia);
    }
}
