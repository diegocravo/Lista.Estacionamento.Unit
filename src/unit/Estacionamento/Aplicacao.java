package unit.Estacionamento;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Aplicacao {

    static List<EstacionamentoNovo> listaEstacionamento = new ArrayList<EstacionamentoNovo>();

    static Scanner ler = new Scanner(System.in);
    static int opcao;

    public static int codigo = 0;

    public static void main(String[] args) {

        do {
            System.out.println("\n****** Opções ******");
            System.out.println();
            System.out.println("1 - Cadastrar Estacionamento");
            System.out.println("2 - Consultar Estacionamento");
            System.out.println("3 - Desativar Estacionamento");
            System.out.println("4 - Registrar Entrada Carro");
            System.out.println("5 - Registrar Saída Carro");
            System.out.println("0 - Finalizar");

            try {
                System.out.print("\nOpção: ");
                opcao = ler.nextInt();
            } catch (Exception e) {
                System.out.println("\nA opção deve ser numérica\n");
                ler.next();
                continue;
            }

            switch (opcao) {
                case 1:
                    cadastrarEstacionamento();
                    break;
                case 2:
                    consultarEstacionamento();
                    break;
                case 3:
                    Desativar();
                    break;
                case 4:
                    registrarEntrada();
                    break;
                case 5:
                    registrarSaida();
                    break;
                case 0:
                    System.out.println("\n--- PROGRAMA FINALIZADO  ---");
                    break;
                default:
                    System.out.printf("\nOpção incorreta!!!\n");
            }
        } while (opcao != 0);

    }

    public static EstacionamentoNovo pesquisarEstacionamentoPorCodigo(int cod) {
        for (EstacionamentoNovo parking : listaEstacionamento) {
            if (parking.getCodigo() == cod) {
                return parking;
            }
        }
        return null;
    }

    public static void cadastrarEstacionamento() {

        codigo += 1;
        System.out.printf("Código: %d", codigo);

        ler.nextLine();
        System.out.printf("\nNome: ");
        String nome = ler.nextLine();

        System.out.print("Cidade: ");
        String cidade = ler.nextLine();

        int vagas;
        do {
            try {
                System.out.print("Vagas: ");
                vagas = ler.nextInt();
                break;
            }
            catch (Exception e) {
                System.out.println("\nO preço de custo deve ser numérico");
                ler.next();
                continue;
            }
        } while (true);

        System.out.printf("\nStatus: Ativo");

        EstacionamentoNovo estacionamento = new EstacionamentoNovo(codigo, nome, cidade, vagas);

        listaEstacionamento.add(estacionamento);
        System.out.println("\nProduto Cadastrado");

    }

    public static void consultarEstacionamento() {

        if (listaEstacionamento.size() == 0) {
            System.out.println("\nNão há estacionamentos cadastrado");
            return;
        }

        System.out.println("\n--- Consultar Estacionamento ---");

        int codigo;
        do {
            try {
                System.out.print("\nCódigo: ");
                codigo = ler.nextInt();
                break;
            }
            catch(Exception e) {
                System.out.println("\nO código deve ser numérico");
                ler.next();
                continue;
            }
        } while (true);

        EstacionamentoNovo parking = pesquisarEstacionamentoPorCodigo(codigo);
        if (parking == null) {
            System.out.println("\nEstacionamento não cadastrado");
        }
        else {
            System.out.printf("\nCódigo.............: %d", parking.getCodigo());
            System.out.printf("\nNome...............: %s", parking.getNome());
            System.out.printf("\nCidade.............: %s", parking.getCidade());
            System.out.printf("\nVagas Disponíveis..: %d", parking.getVagas());
            //colocar o status
            System.out.println();
        }

    }


    public static void Desativar() {

        int codigo;
        do {
            try {
                System.out.print("\nCódigo: ");
                codigo = ler.nextInt();
                break;
            }
            catch(Exception e) {
                System.out.println("\nO código deve ser numérico");
                ler.next();
                continue;
            }
        } while (true);

        EstacionamentoNovo parking = pesquisarEstacionamentoPorCodigo(codigo);
        if (parking == null) {
            System.out.println("\nEstacionamento não cadastrado");
        }
        else {
            if (parking.isSituacao()){
                parking.setSituacao(false);
                parking.setVagas(0);
            } else {
                System.out.println("Estacionamento já desativado");
            }
        }

    }

    public static void registrarEntrada() {

        if (listaEstacionamento.size() == 0) {
            System.out.println("\nNão há estacionamentos cadastrado");
            return;
        }

        System.out.println("\n--- Consultar Estacionamento ---");

        int codigo;
        do {
            try {
                System.out.print("\nCódigo: ");
                codigo = ler.nextInt();
                break;
            }
            catch(Exception e) {
                System.out.println("\nO código deve ser numérico");
                ler.next();
                continue;
            }
        } while (true);

        EstacionamentoNovo parking = pesquisarEstacionamentoPorCodigo(codigo);
        if (parking == null) {
            System.out.println("\nEstacionamento não cadastrado");
        }
        else {
            int vagasAtuais = parking.getVagasUsadas();
            if (vagasAtuais < parking.getVagas()){
                parking.setVagas(vagasAtuais + 1);
                System.out.printf("Vagas Ocupadas: %d", (vagasAtuais + 1));
            } else {
                System.out.println("Estacionamento Cheio");
            }
        }
    }

    private static void registrarSaida() {
        if (listaEstacionamento.size() == 0) {
            System.out.println("\nNão há estacionamentos cadastrado");
            return;
        }

        System.out.println("\n--- Consultar Estacionamento ---");

        int codigo;
        do {
            try {
                System.out.print("\nCódigo: ");
                codigo = ler.nextInt();
                break;
            }
            catch(Exception e) {
                System.out.println("\nO código deve ser numérico");
                ler.next();
                continue;
            }
        } while (true);

        EstacionamentoNovo parking = pesquisarEstacionamentoPorCodigo(codigo);
        if (parking == null) {
            System.out.println("\nEstacionamento não cadastrado");
        }
        else {
            int vagasAtuais = parking.getVagasUsadas();
            if (vagasAtuais > 0){
                parking.setVagas(vagasAtuais - 1);
                System.out.printf("Vagas Ocupadas: %d", (vagasAtuais - 1));
            } else {
                System.out.println("Estacionamento já está vazio");
            }
        }
    }
}
