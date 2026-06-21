package view;

import dao.VeiculoDAO;
import java.util.List;
import java.util.Scanner;
import model.Veiculo;

public class TelaVeiculo {

    private Scanner scanner = new Scanner(System.in);
    private VeiculoDAO dao = new VeiculoDAO();

    public void iniciar() {

        int opcao;

        do {

            System.out.println("\n===== SISTEMA DE VEICULOS =====");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Listar");
            System.out.println("3 - Buscar por ID");
            System.out.println("4 - Atualizar");
            System.out.println("5 - Excluir");
            System.out.println("0 - Sair");
            System.out.print("Opcao: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {

                case 1:
                    cadastrar();
                    break;

                case 2:
                    listar();
                    break;

                case 3:
                    buscarPorId();
                    break;

                case 4:
                    atualizar();
                    break;

                case 5:
                    excluir();
                    break;

                case 0:
                    System.out.println("Sistema encerrado.");
                    break;

                default:
                    System.out.println("Opcao invalida.");
            }

        } while (opcao != 0);
    }

    private void cadastrar() {

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Cor: ");
        String cor = scanner.nextLine();

        System.out.print("Ano: ");
        int ano = scanner.nextInt();

        System.out.print("Modelo: ");
        int modelo = scanner.nextInt();

        scanner.nextLine();

        System.out.print("Numero do Chassi: ");
        String chassi = scanner.nextLine();

        System.out.print("Placa: ");
        String placa = scanner.nextLine();

        System.out.print("Unico dono (true/false): ");
        boolean unicoDono = scanner.nextBoolean();

        Veiculo veiculo = new Veiculo(
                nome,
                cor,
                ano,
                modelo,
                chassi,
                placa,
                unicoDono
        );

        dao.salvar(veiculo);
    }

    private void listar() {

        List<Veiculo> lista = dao.listarTodos();

        for (Veiculo v : lista) {

            System.out.println(v);
        }
    }

    private void buscarPorId() {

        System.out.print("ID: ");
        int id = scanner.nextInt();

        Veiculo veiculo = dao.buscarPorId(id);

        if (veiculo != null) {

            System.out.println(veiculo);

        } else {

            System.out.println("Veiculo nao encontrado.");
        }
    }

    private void atualizar() {

        System.out.print("ID do veiculo: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Veiculo veiculo = dao.buscarPorId(id);

        if (veiculo == null) {

            System.out.println("Veiculo nao encontrado.");
            return;
        }

        System.out.print("Novo nome: ");
        veiculo.setNome(scanner.nextLine());

        System.out.print("Nova cor: ");
        veiculo.setCor(scanner.nextLine());

        dao.atualizar(veiculo);
    }

    private void excluir() {

        System.out.print("ID do veiculo: ");
        int id = scanner.nextInt();

        dao.excluir(id);
    }
}