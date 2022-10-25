package Principal;

/*
INSTRUÇÕES GERAIS
-Permitir o cadastro de até 3000 peças
-Implementar um menu de opções de acordo com o descrito
-Realizar as validações necessárias
-Fornecer mensagens adequadas
 */
import java.util.Scanner;
import Apoio.Peca;

public class AutoPeca {

    private static int indice = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Quantos peças serão cadastradas: ");
        int qtdLogs = sc.nextInt();
        System.out.println();

        Peca pecas[] = new Peca[qtdLogs];
        
        System.out.println("\t\tAuto Peças\n");
        
        int opcao = 1;
        while (opcao != 5) {
            System.out.println("\t\tMenu de opções:\n"
                    + "[1] - Cadastrar uma peça\n"
                    + "[2] - Consultar uma peça através da referência\n"
                    + "[3] - Consultar o número de peças e o valor total de uma categoria\n"
                    + "[4] - Consultar peças de uma categoria\n"
                    + "[5] - Sair");
            do {
                if (opcao < 1 || opcao > 5) {
                    System.out.print("Digite uma opção válida: ");
                }
                opcao = sc.nextInt();
            } while (opcao < 1 || opcao > 5);
            System.out.println();

            switch (opcao) {
                case 1:
                    if (indice == pecas.length) {
                        System.out.println("Todas as peças foram cadastradas!\n");
                    } else {
                        cadastrarPeca(sc, pecas);
                    }
                    break;
                case 2:
                    consultarReferencia(sc, pecas);
                    break;
                case 3:
                    exibirCategoria(sc, pecas);
                    break;
                case 4:
                    listarCategoria(sc, pecas);
                    break;
                case 5:
                    System.exit(0);
                    break;
            }
        }
    }

    private static void cadastrarPeca(Scanner leitura, Peca[] vetorPecas) {
        Peca peca = new Peca();

        peca.setCodigo();

        System.out.print("Digite o nome da peça: ");
        String nome = leitura.next();
        nome += leitura.nextLine();
        peca.setNomePeca(nome);
        System.out.println();

        int cat = 1;
        System.out.println("Escolha a categoria:\n"
                + "[1] - Elétrica\n"
                + "[2] - Manutenção\n"
                + "[3] - Hidráulica\n"
                + "[4] - Motor");
        do {
            if (cat < 1 || cat > 4) {
                System.out.print("Digite uma opção válida: ");
            }
            cat = leitura.nextInt();
        } while (cat < 1 || cat > 4);
        switch (cat) {
            case 1:
                peca.setCategoria("Elétrica");
                break;
            case 2:
                peca.setCategoria("Manutenção");
                break;
            case 3:
                peca.setCategoria("Hidráulica");
                break;
            case 4:
                peca.setCategoria("Motor");
                break;
        }
        System.out.println();

        System.out.print("Digite uma referência para a peça: ");
        peca.setReferencia(leitura.next());
        System.out.println();

        System.out.print("Digite o valor da peça: ");
        peca.setValor(leitura.nextDouble());
        System.out.println();

        vetorPecas[indice] = peca;

        indice++;
    }

    private static void consultarReferencia(Scanner leitura, Peca[] vetorPecas) {
        System.out.print("Digite a referência da peça a ser consultada: ");
        String ref = leitura.next().toLowerCase();
        System.out.println();

        Boolean header = true;
        int i = 0;
        while (i < indice) {

            if (vetorPecas[i].getReferencia().toLowerCase().contains(ref)) {

                if (header) {
                    System.out.printf("%-7s%-14s%-10s%6s%n", "Código", "Nome", "Referência", "Valor");
                }

                System.out.printf("%-7s%-14s%-12s%5.2f%n",
                        vetorPecas[i].getCodigo(), vetorPecas[i].getNomePeca(), vetorPecas[i].getReferencia(), vetorPecas[i].getValor());

                header = false;
            }
            i++;
        }
        System.out.println();
    }

    private static void exibirCategoria(Scanner leitura, Peca[] vetorPecas) {
        int cat = 1;
        String catString = "";
        System.out.println("Escolha a categoria:\n"
                + "[1] - Elétrica\n"
                + "[2] - Manutenção\n"
                + "[3] - Hidráulica\n"
                + "[4] - Motor");
        do {
            if (cat < 1 || cat > 4) {
                System.out.print("Digite uma opção válida: ");
            }
            cat = leitura.nextInt();
        } while (cat < 1 || cat > 4);
        switch (cat) {
            case 1:
                catString = "elétrica";
                break;
            case 2:
                catString = "manutenção";
                break;
            case 3:
                catString = "hidráulica";
                break;
            case 4:
                catString = "motor";
                break;
        }
        System.out.println();

        int numPecas = 0;
        int i = 0;
        double total = 0;
        while (i < indice) {

            if (vetorPecas[i].getCategoria().toLowerCase().contains(catString)) {

                numPecas++;
                total += vetorPecas[i].getValor();
            }
            i++;
        }
        System.out.printf("Número total de peças: %4s%nValor em total: %5.2f%n", numPecas, total);
        System.out.println();
    }

    private static void listarCategoria(Scanner leitura, Peca[] vetorPecas) {
        int cat = 1;
        String catString = "";
        System.out.println("Escolha a categoria:\n"
                + "[1] - Elétrica\n"
                + "[2] - Manutenção\n"
                + "[3] - Hidráulica\n"
                + "[4] - Motor");
        do {
            if (cat < 1 || cat > 4) {
                System.out.print("Digite uma opção válida: ");
            }
            cat = leitura.nextInt();
        } while (cat < 1 || cat > 4);
        switch (cat) {
            case 1:
                catString = "elétrica";
                break;
            case 2:
                catString = "manutenção";
                break;
            case 3:
                catString = "hidráulica";
                break;
            case 4:
                catString = "motor";
                break;
        }
        System.out.println();

        Boolean header = true;
        double total = 0;
        int i = 0;
        while (i < indice) {

            if (vetorPecas[i].getCategoria().toLowerCase().contains(catString)) {

                if (header) {
                    System.out.printf("%-7s%-14s%-10s%6s%n", "Código", "Nome", "Referência", "Valor");
                }

                System.out.printf("%-7s%-14s%-12s%5.2f%n",
                        vetorPecas[i].getCodigo(), vetorPecas[i].getNomePeca(), vetorPecas[i].getReferencia(), vetorPecas[i].getValor());

                total += vetorPecas[i].getValor();

                header = false;
            }
            i++;
        }
        System.out.printf("Valor total das peças da categoria: %5.2f%n%n", total);
    }
}
