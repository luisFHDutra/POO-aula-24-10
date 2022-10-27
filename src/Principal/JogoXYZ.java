package Principal;

import Classes.Arma;
import Classes.Defesa;
import Classes.Personagem;
import java.util.Scanner;

public class JogoXYZ {

    private static int indArma = 0;
    private static int indDefesa = 0;
    private static int indPersonagem = 0;

    private static Boolean cheioArma = false;
    private static Boolean cheioDef = false;
    private static Boolean cheioPers = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("\t\tJogoXYZ\n");

        System.out.print("Quantas armas serão cadastradas: ");
        int qtdArmas = sc.nextInt();

        System.out.print("Quantas defesas serão cadastradas: ");
        int qtdDefesas = sc.nextInt();

        System.out.print("Quantos personagens serão cadastrados: ");
        int qtdPers = sc.nextInt();
        System.out.println();

        Arma armasCad[] = new Arma[qtdArmas];
        Defesa defesasCad[] = new Defesa[qtdDefesas];
        Personagem personagensCad[] = new Personagem[qtdPers];

        int opcao = 1;
        while (opcao != 7) {
            System.out.println("\t\tMenu de opções:\n"
                    + "[1] - Cadastrar arma\n"
                    + "[2] - Listar armas\n"
                    + "[3] - Cadastrar defesa\n"
                    + "[4] - Listar defesas\n"
                    + "[5] - Criar personagem\n"
                    + "[6] - Listar personagens\n"
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
                    Boolean flagA = cadastrarArma(sc, armasCad);

                    if (flagA) {
                        System.out.println("Cadastro efetuado com sucesso!\n");
                    } else {
                        System.out.println("Todas as armas já foram cadastradas!\n");
                    }
                    break;
                case 2:
                    listarArmas(armasCad);
                    break;
                case 3:
                    Boolean flagD = cadastrarDefesa(sc, defesasCad);

                    if (flagD) {
                        System.out.println("Cadastro efetuado com sucesso!\n");
                    } else {
                        System.out.println("Todas as defesas já foram cadastradas!\n");
                    }
                    break;
                case 4:
                    listarDefesas(defesasCad);
                    break;
                case 5:
                    Boolean flagP = cadastrarPersonagem(sc, personagensCad, armasCad, defesasCad);

                    if (flagP) {
                        System.out.println("Cadastro efetuado com sucesso!\n");
                    } else {
                        System.out.println("Todas os personagens já foram cadastradas!\n");
                    }
                    break;
                case 6:
                    listarPersonagem(personagensCad);
                    break;
                case 7:
                    System.exit(0);
                    break;
            }
        }
    }

    private static boolean cadastrarArma(Scanner leitura, Arma[] armas) {
        Boolean cadastrou = true;

        if (indArma == armas.length) {
            cheioArma = true;

            cadastrou = false;
        }

        if (cheioArma == false) {
            Arma arma = new Arma();

            arma.setCodigo();

            System.out.print("Digite a descrição da arma: ");
            String desc = leitura.next();
            desc += leitura.nextLine();

            arma.setDescricao(desc);

            System.out.print("Digite a força da arma: ");
            arma.setForca(leitura.nextDouble());

            System.out.print("Digite o nível de utilização: ");
            arma.setNivelUtilizacao(leitura.nextInt());

            armas[indArma] = arma;
            indArma++;

            cadastrou = true;

            System.out.println();
        }

        return cadastrou;
    }

    private static boolean cadastrarDefesa(Scanner leitura, Defesa[] defesas) {
        Boolean cadastrou = true;

        if (indDefesa == defesas.length) {
            cheioDef = true;

            cadastrou = false;
        }

        if (cheioDef == false) {
            Defesa defesa = new Defesa();

            defesa.setCodigo();

            System.out.print("Digite a descrição da defesa: ");
            String desc = leitura.next();
            desc += leitura.nextLine();

            defesa.setDescricao(desc);

            System.out.print("Digite a força da defesa: ");
            defesa.setForca(leitura.nextDouble());

            System.out.print("Digite o nível de utilização: ");
            defesa.setNivelUtilizacao(leitura.nextInt());

            defesas[indDefesa] = defesa;
            indDefesa++;

            cadastrou = true;

            System.out.println();
        }

        return cadastrou;
    }

    private static void listarArmas(Arma[] armas) {
        int i = 0;
        System.out.printf("%-8s%-8s%-9s%-15s%n", "Código", "Força", "Nível U", "Descrição");
        while (i < indArma) {
            System.out.printf("%-8s%-8s%-9s%-15s%n",
                    armas[i].getCodigo(), armas[i].getForca(), armas[i].getNivelUtilizacao(), armas[i].getDescricao());
            i++;
        }
        System.out.println();
    }

    private static void listarDefesas(Defesa[] defesas) {
        int i = 0;
        System.out.printf("%-8s%-8s%-9s%-15s%n", "Código", "Força", "Nível U", "Descrição");
        while (i < indDefesa) {
            System.out.printf("%-8s%-8s%-9s%-15s%n",
                    defesas[i].getCodigo(), defesas[i].getForca(), defesas[i].getNivelUtilizacao(), defesas[i].getDescricao());
            i++;
        }
        System.out.println();
    }

    private static boolean cadastrarPersonagem(Scanner leitura, Personagem[] personagens, Arma[] armas, Defesa[] defesas) {
        Boolean cadastrou = true;

        if (indPersonagem == personagens.length) {
            cheioPers = true;

            cadastrou = false;
        }

        if (cheioPers == false) {
            Personagem perso = new Personagem();

            perso.setCodigo();

            System.out.print("Digite o nome do personagem: ");
            String nome = leitura.next();
            nome += leitura.nextLine();

            perso.setNome(nome);
            System.out.println();

            perso.setArmas(armas);

            listarArmas(armas);

            System.out.print("Digite o código da arma principal: ");
            int codParma = 0;
            int i = 0;
            while (i < indArma && codParma != armas[i].getCodigo()) {
                do {
                    codParma = leitura.nextInt();
                    if (codParma != armas[i].getCodigo()) {
                        System.out.print("Digite uma opção válida: ");
                    }
                } while (codParma != armas[i].getCodigo());
                i++;
            }
            System.out.println();

            perso.setpArmas(codParma);

            perso.setDefesas(defesas);

            listarDefesas(defesas);

            System.out.print("Digite o código da defesa principal: ");
            int codPdef = 0;
            int ind = 0;
            while (ind < indDefesa && codPdef != defesas[ind].getCodigo()) {
                do {
                    codPdef = leitura.nextInt();
                    if (codPdef != defesas[ind].getCodigo()) {
                        System.out.print("Digite uma opção válida: ");
                    }
                } while (codPdef != defesas[ind].getCodigo());
                ind++;
            }

            System.out.println();

            perso.setpDefesas(codPdef);

            personagens[indPersonagem] = perso;
            indPersonagem++;

            cadastrou = true;

            System.out.println();
        }

        return cadastrou;
    }

    private static void listarPersonagem(Personagem[] personagens) {
        int i = 0;
        System.out.println("\t\tPersonagens:");
        while (i < indPersonagem) {
            System.out.printf("%-8s%-10s%-16s%-20s%n", "Código", "Nome", "Arma principal", "Defesa principal");
            System.out.printf("%-8s%-10s%-16s%-20s%n",
                    personagens[i].getCodigo(), personagens[i].getNome(), personagens[i].getpArmas(), personagens[i].getpDefesas());
            System.out.println();

            listarArmas(personagens[i].getArmas());

            listarDefesas(personagens[i].getDefesas());

            i++;
            System.out.println("\t\t-----\n");
        }
    }
}
