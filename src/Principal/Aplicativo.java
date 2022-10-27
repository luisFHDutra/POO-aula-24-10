package Principal;

import Classes.Agenda;
import Classes.Log;
import Classes.Mensagem;
import java.util.Scanner;

public class Aplicativo {

    private static int indice = 0;
    private static int indMsn = 0;
    private static int indLogs = 0;

    private static Boolean cheio = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("\t\tAplicativo\n");

        System.out.print("Quantos contantos serão cadastrados: ");
        int qtdCont = sc.nextInt();

        System.out.print("Quantidade de logs armazenados na memória: ");
        int qtdLogs = sc.nextInt();
        System.out.println();

        Agenda contatos[] = new Agenda[qtdCont];
        Mensagem mensagens[] = new Mensagem[qtdCont];
        Log logs[] = new Log[qtdLogs];

        int opcao = 1;
        while (opcao != 9) {
            System.out.println("\t\tMenu de opções:\n"
                    + "[1] - Cadastrar um contato\n"
                    + "[2] - Listar todos os contatos\n"
                    + "[3] - Pesquisar contato por nome\n"
                    + "[4] - Listar contatos de um tipo\n"
                    + "[5] - Enviar uma mensagem\n"
                    + "[6] - Consultar mensagens enviadas\n"
                    + "[7] - Listar log de envios (histórico das mensagens)\n"
                    + "[8] - Limpar logs de envios\n"
                    + "[9] - Sair");
            do {
                if (opcao < 1 || opcao > 9) {
                    System.out.print("Digite uma opção válida: ");
                }
                opcao = sc.nextInt();
            } while (opcao < 1 || opcao > 9);
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
                    enviaMensagens(sc, contatos, mensagens, logs);
                    break;
                case 6:
                    consultarMensagens(contatos, mensagens);
                    break;
                case 7:
                    listarLogs(logs);
                    break;
                case 8:
                    limparLogs(logs);
                    indLogs = 0;

                    System.out.println("Histórico de mensagens limpo!\n");
                    break;
                case 9:
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

    private static void enviaMensagens(Scanner leitura, Agenda[] contatos, Mensagem[] mensagens, Log[] logs) {
        int i, opcao = i = 0;
        System.out.println("Escolha o contato:");
        while (i < indice) {
            System.out.println("[" + (i + 1) + "] - " + contatos[i].getNome());
            i++;
        }
        do {
            opcao = leitura.nextInt();
            if (opcao < 1 || opcao > (indice + 1)) {
                System.out.print("Digite uma opção válida: ");
            }
        } while (opcao < 1 || opcao > (indice + 1));
        System.out.println();

        int ind = 0;
        Boolean existe = false;
        while (ind < indMsn && existe == false) {
            if (mensagens[ind] != null && contatos[opcao - 1] == mensagens[ind].getContato()) {

                if (indLogs < logs.length) {
                    mensagens[ind].setContador();
                }

                existe = true;
            } else {
                existe = false;
            }
            ind++;
        }

        if (existe == false) {

            Mensagem msn = new Mensagem();

            msn.setContato(contatos[opcao - 1]);

            msn.setContador();

            mensagens[indMsn] = msn;
            indMsn++;
        }

        if (indLogs == logs.length) {
            System.out.println("Os logs estão cheios, esvazie para manter salvas as mensagens!\n");
        } else {
            Log log = new Log();

            log.setContato(contatos[opcao - 1]);

            log.setDatahora();

            System.out.print("Digite a mensagem: ");
            String mensagem = leitura.next();
            mensagem += leitura.nextLine();

            log.setMensagem(mensagem);

            logs[indLogs] = log;
            indLogs++;

            System.out.println("Mensagem enviada!\n");
        }
    }

    private static void consultarMensagens(Agenda[] contatos, Mensagem[] mensagens) {
        int i = 0;
        System.out.printf("%-10s%-10s%-20s%n", "Contato", "Telefone", "Mensagens enviadas");
        while (i < indice) {
            System.out.printf("%-10s%-10s", contatos[i].getNome(), contatos[i].getTelefone());

            if (mensagens[i] != null && contatos[i] == mensagens[i].getContato()) {
                System.out.println("\t" + mensagens[i].getContador());
            }
            i++;
        }
        System.out.println();
    }

    private static void listarLogs(Log[] logs) {
        int i = 0;
        System.out.printf("%-18s%-10s%-20s%n", "DataHora", "Contato", "Mensagem");
        while (i < indLogs) {
            System.out.printf("%-18s%-10s%-20s%n", logs[i].getDatahora(), logs[i].getContato().getNome(), logs[i].getMensagem());
            i++;
        }
        System.out.println();
    }

    private static void limparLogs(Log[] logs) {
        int i = 0;
        while (i < logs.length) {
            logs[i] = null;
            i++;
        }
    }
}
