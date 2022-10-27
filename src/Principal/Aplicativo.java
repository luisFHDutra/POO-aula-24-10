package Principal;

import Classes.Agenda;
import Classes.Logs;
import java.util.Scanner;

public class Aplicativo {

    private static int indice = 0;

    private static Boolean cheio = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("\t\tAplicativo\n");

        System.out.print("Quantos contantos serão cadastrados: ");
        int qtdCont = sc.nextInt();
        System.out.println();

        Agenda contatos[] = new Agenda[qtdCont];

        int opcao = 1;
        while (opcao != 8) {
            System.out.println("\t\tMenu de opções:\n"
                    + "[1] - Cadastrar um contato\n"
                    + "[2] - Listar todos os contatos\n"
                    + "[3] - Pesquisar contato por nome\n"
                    + "[4] - Listar contatos de um tipo\n"
                    + "[5] - Enviar uma mensagem\n"
                    + "[6] - Consultar mensagens enviadas\n"
                    + "[7] - Listar log de envios (histórico das mensagens)\n"
                    + "[8] - Sair");
            do {
                if (opcao < 1 || opcao > 8) {
                    System.out.print("Digite uma opção válida: ");
                }
                opcao = sc.nextInt();
            } while (opcao < 1 || opcao > 8);
            System.out.println();

            switch (opcao) {
                case 1:
                    Boolean flag = cadastrarContato(sc, contatos);

                    if (flag) {
                        System.out.println("Cadastro efetuado com sucesso!\n");
                    } else {
                        System.out.println("Todas os contatos já foram cadastrados!\n");
                    }
                    break;
                case 2:
                    listarContatos(contatos);
                    break;
                case 3:
                    pesquisaNome(sc, contatos);
                    break;
                case 4:
                    pesquisaTipo(sc, contatos);
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    System.exit(0);
                    break;
            }
        }
    }

    private static Boolean cadastrarContato(Scanner leitura, Agenda[] contatos) {
        Boolean cadastrou = true;

        if (indice == contatos.length) {
            cheio = true;

            cadastrou = false;
        }

        if (cheio == false) {
            Agenda contato = new Agenda();

            System.out.print("Digite o nome do contato: ");
            String nome = leitura.next();
            nome += leitura.nextLine();

            contato.setNome(nome);

            System.out.print("Digite o telefone do contato: ");
            String telString = "";
            int telefone = 0;
            do {
                telefone = leitura.nextInt();
                telString = String.valueOf(telefone);
                if (telString.length() < 9) {
                    System.out.print("Digite uma opção válida: ");
                }
            } while (telString.length() < 9);
            System.out.println();

            contato.setTelefone(telefone);

            System.out.print("Digite o email do contato: ");
            contato.setEmail(leitura.next());

            System.out.println("Escolha o tipo do contato:\n"
                    + "[1] - Família\n"
                    + "[2] - Amigos\n"
                    + "[3] - Trabalho");
            int opcao = 1;
            do {
                if (opcao < 1 || opcao > 3) {
                    System.out.print("Digite uma opção válida: ");
                }
                opcao = leitura.nextInt();
            } while (opcao < 1 || opcao > 3);
            System.out.println();

            contato.setTipoCont(opcao);

            contatos[indice] = contato;
            indice++;

            cadastrou = true;
        }

        return cadastrou;
    }

    private static void listarContatos(Agenda[] contatos) {
        int i = 0;
        System.out.printf("%-10s%-10s%-15s%-15s%n", "Nome", "Telefone", "E-mail", "Tipo");
        while (i < indice) {
            System.out.printf("%-10s%-10s%-15s%-15s%n",
                    contatos[i].getNome(), contatos[i].getTelefone(), contatos[i].getEmail(), contatos[i].getTipoCont());
            i++;
        }
        System.out.println();
    }

    private static void pesquisaNome(Scanner leitura, Agenda[] contatos) {
        System.out.print("Digite o nome do contato: ");
        String nome = leitura.next();
        nome += leitura.nextLine();

        nome = nome.toLowerCase().trim();

        System.out.println();

        Boolean header = true;
        int i = 0;
        while (i < indice) {
            if (contatos[i].getNome().toLowerCase().trim().contains(nome)) {

                if (header) {
                    System.out.printf("%-10s%-10s%-15s%-15s%n", "Nome", "Telefone", "E-mail", "Tipo");
                }

                System.out.printf("%-10s%-10s%-15s%-15s%n",
                        contatos[i].getNome(), contatos[i].getTelefone(), contatos[i].getEmail(), contatos[i].getTipoCont());

                header = false;
            }
            i++;
        }
        System.out.println();
    }

    private static void pesquisaTipo(Scanner leitura, Agenda[] contatos) {
        System.out.println("Escolha o tipo do contato:\n"
                + "[1] - Família\n"
                + "[2] - Amigos\n"
                + "[3] - Trabalho");
        int opcao = 1;
        do {
            if (opcao < 1 || opcao > 3) {
                System.out.print("Digite uma opção válida: ");
            }
            opcao = leitura.nextInt();
        } while (opcao < 1 || opcao > 3);
        System.out.println();

        String tipoStr = "";

        switch (opcao) {
            case 1:
                tipoStr = "Família";
                break;
            case 2:
                tipoStr = "Amigos";
                break;
            case 3:
                tipoStr = "Trabalho";
                break;
        }

        Boolean header = true;
        int i = 0;
        while (i < indice) {
            if (contatos[i].getTipoCont().equals(tipoStr)) {

                if (header) {
                    System.out.printf("%-10s%-10s%-15s%-15s%n", "Nome", "Telefone", "E-mail", "Tipo");
                }

                System.out.printf("%-10s%-10s%-15s%-15s%n",
                        contatos[i].getNome(), contatos[i].getTelefone(), contatos[i].getEmail(), contatos[i].getTipoCont());

                header = false;
            }
            i++;
        }

        System.out.println();
    }

}
