package br.com.fiap.projeto.main;

import br.com.fiap.projeto.entity.*;
import br.com.fiap.projeto.dao.*;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nBem-vindo ao sistema de gerenciamento!");
            System.out.println("----------Menu----------");
            System.out.println("1.  Cadastrar Montadora");
            System.out.println("2.  Consultar Montadora");
            System.out.println("3.  Cadastrar Automóvel");
            System.out.println("4.  Consultar Automóvel");
            System.out.println("5.  Cadastrar Cliente");
            System.out.println("6.  Consultar Cliente");
            System.out.println("7.  Cadastrar Endereço");
            System.out.println("8.  Consultar Endereço");
            System.out.println("9.  Cadastrar Oficina");
            System.out.println("10. Consultar Oficina");
            System.out.println("11. Cadastrar Produto");
            System.out.println("12. Consultar Produto");
            System.out.println("13. Cadastrar Serviço");
            System.out.println("14. Consultar Serviço");
            System.out.println("15. Cadastrar Fornecedor");
            System.out.println("16. Consultar Fornecedor");
            System.out.println("17. Atualizar Cliente");
            System.out.println("18. Deletar Cliente");
            System.out.println("19. Finalizar");

            int opcao = scan.nextInt();
            scan.nextLine(); // Consome o newline

            try {
                switch (opcao) {
                    case 1:
                        cadastrarMontadora();
                        break;
                    case 2:
                        consultarMontadora();
                        break;
                    case 3:
                        cadastrarAutomovel();
                        break;
                    case 4:
                        consultarAutomovel();
                        break;
                    case 5:
                        cadastrarCliente();
                        break;
                    case 6:
                        consultarCliente();
                        break;
                    case 7:
                        cadastrarEndereco();
                        break;
                    case 8:
                        consultarEndereco();
                        break;
                    case 9:
                        cadastrarOficina();
                        break;
                    case 10:
                        consultarOficina();
                        break;
                    case 11:
                        cadastrarProduto();
                        break;
                    case 12:
                        consultarProduto();
                        break;
                    case 13:
                        cadastrarServico();
                        break;
                    case 14:
                        consultarServico();
                        break;
                    case 15:
                        cadastrarFornecedor();
                        break;
                    case 16:
                        consultarFornecedor();
                        break;
                    case 17:
                        atualizarCliente();
                        break;
                    case 18:
                        deletarCliente();
                        break;
                    case 19:
                        System.out.println("Finalizando...");
                        return;
                    default:
                        System.out.println("Opção inválida!");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Métodos para Montadora
    private static void cadastrarMontadora() throws SQLException {
        System.out.println("Digite o ID da Montadora: ");
        int idMontadora = scan.nextInt();
        scan.nextLine(); // Consome o newline

        System.out.println("Digite o CNPJ da Montadora: ");
        String cnpj = scan.nextLine();

        System.out.println("Digite o Nome da Montadora: ");
        String nome = scan.nextLine();

        System.out.println("Digite a Placa do Automóvel: ");
        String placa = scan.nextLine();

        AutomovelDAO automovelDAO = new AutomovelDAO();
        Automovel automovel = automovelDAO.buscarPorPlaca(placa);

        MontadoraDAO montadoraDAO = new MontadoraDAO();
        Montadora montadora = new Montadora(idMontadora, cnpj, nome, automovel);

        montadoraDAO.inserir(montadora);

        System.out.println("Montadora cadastrada com sucesso!");
    }

    private static void consultarMontadora() throws SQLException {
        System.out.println("Digite o ID da Montadora: ");
        int idMontadora = scan.nextInt();
        scan.nextLine(); // Consome o newline

        MontadoraDAO montadoraDAO = new MontadoraDAO();
        Montadora montadora = montadoraDAO.buscarPorId(idMontadora);

        if (montadora != null) {
            System.out.println(montadora);
        } else {
            System.out.println("Montadora não encontrada.");
        }
    }

    // Métodos para Automóvel
    private static void cadastrarAutomovel() throws SQLException {
        System.out.println("Digite a Placa do Automóvel: ");
        String placa = scan.nextLine();

        System.out.println("Digite o Ano do Automóvel: ");
        int ano = scan.nextInt();
        scan.nextLine(); // Consome o newline

        System.out.println("Digite o Modelo do Automóvel: ");
        String modelo = scan.nextLine();

        System.out.println("Digite a Motorização do Automóvel: ");
        double motorizacao = scan.nextDouble();
        scan.nextLine(); // Consome o newline

        System.out.println("Digite o ID do Serviço (ou 0 para nenhum): ");
        int servicoId = scan.nextInt();
        scan.nextLine(); // Consome o newline

        Servico servico = null;
        if (servicoId != 0) {
            ServicoDAO servicoDAO = new ServicoDAO();
            servico = servicoDAO.buscarPorId(servicoId);
        }

        AutomovelDAO automovelDAO = new AutomovelDAO();
        Automovel automovel = new Automovel(placa, ano, modelo, motorizacao, servico);

        automovelDAO.inserir(automovel);

        System.out.println("Automóvel cadastrado com sucesso!");
    }

    private static void consultarAutomovel() throws SQLException {
        System.out.println("Digite a Placa do Automóvel: ");
        String placa = scan.nextLine();

        AutomovelDAO automovelDAO = new AutomovelDAO();
        Automovel automovel = automovelDAO.buscarPorPlaca(placa);

        if (automovel != null) {
            System.out.println(automovel);
        } else {
            System.out.println("Automóvel não encontrado.");
        }
    }

    // Métodos para Cliente
    private static void cadastrarCliente() throws SQLException {
        System.out.println("Digite o CPF do Cliente: ");
        String cpf = scan.nextLine();

        System.out.println("Digite o Nome do Cliente: ");
        String nome = scan.nextLine();

        System.out.println("Digite o Telefone do Cliente: ");
        String tel = scan.nextLine();

        System.out.println("Digite o Email do Cliente: ");
        String email = scan.nextLine();

        System.out.println("Digite a Placa do Automóvel: ");
        String placa = scan.nextLine();

        System.out.println("Digite o ID do Endereço: ");
        int enderecoId = scan.nextInt();
        scan.nextLine(); // Consome o newline

        AutomovelDAO automovelDAO = new AutomovelDAO();
        Automovel automovel = automovelDAO.buscarPorPlaca(placa);

        EnderecoDAO enderecoDAO = new EnderecoDAO();
        Endereco endereco = enderecoDAO.buscarPorId(enderecoId);

        ClienteDAO clienteDAO = new ClienteDAO();
        Cliente cliente = new Cliente(cpf, nome, tel, email, automovel, endereco);

        clienteDAO.inserir(cliente);

        System.out.println("Cliente cadastrado com sucesso!");
    }

    private static void consultarCliente() throws SQLException {
        System.out.println("Digite o CPF do Cliente: ");
        String cpf = scan.nextLine();

        ClienteDAO clienteDAO = new ClienteDAO();
        Cliente cliente = clienteDAO.buscarPorCpf(cpf);

        if (cliente != null) {
            System.out.println(cliente);
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }

    private static void atualizarCliente() throws SQLException {
        System.out.println("Digite o CPF do Cliente que deseja atualizar: ");
        String cpf = scan.nextLine();

        ClienteDAO clienteDAO = new ClienteDAO();
        Cliente cliente = clienteDAO.buscarPorCpf(cpf);

        if (cliente != null) {
            System.out.println("Digite o novo Nome do Cliente (ou pressione Enter para manter): ");
            String nome = scan.nextLine();
            if (!nome.isEmpty()) {
                cliente.setNome(nome);
            }

            System.out.println("Digite o novo Telefone do Cliente (ou pressione Enter para manter): ");
            String telefone = scan.nextLine();
            if (!telefone.isEmpty()) {
                cliente.setTelefone(telefone);
            }

            System.out.println("Digite o novo Email do Cliente (ou pressione Enter para manter): ");
            String email = scan.nextLine();
            if (!email.isEmpty()) {
                cliente.setEmail(email);
            }

            // Atualizar o automóvel associado
            System.out.println("Deseja alterar o Automóvel do Cliente? (S/N): ");
            String alterarAutomovel = scan.nextLine();
            if (alterarAutomovel.equalsIgnoreCase("S")) {
                System.out.println("Digite a Placa do novo Automóvel: ");
                String placa = scan.nextLine();
                AutomovelDAO automovelDAO = new AutomovelDAO();
                Automovel automovel = automovelDAO.buscarPorPlaca(placa);
                cliente.setAutomovel(automovel);
            }

            // Atualizar o endereço associado
            System.out.println("Deseja alterar o Endereço do Cliente? (S/N): ");
            String alterarEndereco = scan.nextLine();
            if (alterarEndereco.equalsIgnoreCase("S")) {
                System.out.println("Digite o ID do novo Endereço: ");
                int enderecoId = scan.nextInt();
                scan.nextLine();
                EnderecoDAO enderecoDAO = new EnderecoDAO();
                Endereco endereco = enderecoDAO.buscarPorId(enderecoId);
                cliente.setEndereco(endereco);
            }

            clienteDAO.atualizar(cliente);
            System.out.println("Cliente atualizado com sucesso!");
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }

    private static void deletarCliente() throws SQLException {
        System.out.println("Digite o CPF do Cliente que deseja deletar: ");
        String cpf = scan.nextLine();

        ClienteDAO clienteDAO = new ClienteDAO();
        Cliente cliente = clienteDAO.buscarPorCpf(cpf);

        if (cliente != null) {
            clienteDAO.deletar(cpf);
            System.out.println("Cliente deletado com sucesso!");
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }

    // Métodos para Endereço
    private static void cadastrarEndereco() throws SQLException {
        System.out.println("Digite o ID do Endereço: ");
        int idEndereco = scan.nextInt();
        scan.nextLine(); // Consome o newline

        System.out.println("Digite a Cidade: ");
        String cidade = scan.nextLine();

        System.out.println("Digite o UF: ");
        String uf = scan.nextLine();

        System.out.println("Digite o CEP: ");
        String cep = scan.nextLine();

        System.out.println("Digite a Rua: ");
        String rua = scan.nextLine();

        System.out.println("Digite o Número: ");
        String numero = scan.nextLine();

        System.out.println("Digite o Complemento: ");
        String complemento = scan.nextLine();

        Endereco endereco = new Endereco(idEndereco, cidade, uf, cep, rua, numero, complemento);

        EnderecoDAO enderecoDAO = new EnderecoDAO();
        enderecoDAO.inserir(endereco);

        System.out.println("Endereço cadastrado com sucesso!");
    }

    private static void consultarEndereco() throws SQLException {
        System.out.println("Digite o ID do Endereço: ");
        int idEndereco = scan.nextInt();
        scan.nextLine(); // Consome o newline

        EnderecoDAO enderecoDAO = new EnderecoDAO();
        Endereco endereco = enderecoDAO.buscarPorId(idEndereco);

        if (endereco != null) {
            System.out.println(endereco);
        } else {
            System.out.println("Endereço não encontrado.");
        }
    }

    // Métodos para Oficina
    private static void cadastrarOficina() throws SQLException {
        System.out.println("Digite o CNPJ da Oficina: ");
        String cnpj = scan.nextLine();

        System.out.println("Digite o Nome Fantasia: ");
        String nomeFantasia = scan.nextLine();

        System.out.println("Digite o Tipo: ");
        String tipo = scan.nextLine();

        System.out.println("Digite o ID do Endereço: ");
        int enderecoId = scan.nextInt();
        scan.nextLine(); // Consome o newline

        EnderecoDAO enderecoDAO = new EnderecoDAO();
        Endereco endereco = enderecoDAO.buscarPorId(enderecoId);

        Oficina oficina = new Oficina(cnpj, nomeFantasia, tipo, endereco);

        OficinaDAO oficinaDAO = new OficinaDAO();
        oficinaDAO.inserir(oficina);

        System.out.println("Oficina cadastrada com sucesso!");
    }

    private static void consultarOficina() throws SQLException {
        System.out.println("Digite o CNPJ da Oficina: ");
        String cnpj = scan.nextLine();

        OficinaDAO oficinaDAO = new OficinaDAO();
        Oficina oficina = oficinaDAO.buscarPorCnpj(cnpj);

        if (oficina != null) {
            System.out.println(oficina);
        } else {
            System.out.println("Oficina não encontrada.");
        }
    }

    // Métodos para Produto
    private static void cadastrarProduto() throws SQLException {
        System.out.println("Digite o Código do Produto: ");
        long codProduto = scan.nextLong();
        scan.nextLine(); // Consome o newline

        System.out.println("Digite a Marca: ");
        String marca = scan.nextLine();

        System.out.println("Digite o Tipo: ");
        String tipo = scan.nextLine();

        System.out.println("Digite o Nome: ");
        String nome = scan.nextLine();

        System.out.println("Digite o Valor: ");
        double valor = scan.nextDouble();
        scan.nextLine(); // Consome o newline

        Produto produto = new Produto(codProduto, marca, tipo, nome, valor);

        ProdutoDAO produtoDAO = new ProdutoDAO();
        produtoDAO.inserir(produto);

        System.out.println("Produto cadastrado com sucesso!");
    }

    private static void consultarProduto() throws SQLException {
        System.out.println("Digite o Código do Produto: ");
        long codProduto = scan.nextLong();
        scan.nextLine(); // Consome o newline

        ProdutoDAO produtoDAO = new ProdutoDAO();
        Produto produto = produtoDAO.buscarPorCodigo(codProduto);

        if (produto != null) {
            System.out.println(produto);
        } else {
            System.out.println("Produto não encontrado.");
        }
    }

    // Métodos para Serviço
    private static void cadastrarServico() throws SQLException {
        System.out.println("Digite o ID do Serviço: ");
        int idServico = scan.nextInt();
        scan.nextLine(); // Consome o newline

        System.out.println("Digite o Tipo de Serviço: ");
        String tipoServico = scan.nextLine();

        System.out.println("Digite a Duração: ");
        String duracao = scan.nextLine();

        System.out.println("Digite o Delivery (S/N): ");
        char delivery = scan.nextLine().charAt(0);

        System.out.println("Digite o CNPJ da Oficina: ");
        String cnpjOficina = scan.nextLine();

        OficinaDAO oficinaDAO = new OficinaDAO();
        Oficina oficina = oficinaDAO.buscarPorCnpj(cnpjOficina);

        Servico servico = new Servico(idServico, tipoServico, duracao, delivery, oficina);

        ServicoDAO servicoDAO = new ServicoDAO();
        servicoDAO.inserir(servico);

        System.out.println("Serviço cadastrado com sucesso!");
    }

    private static void consultarServico() throws SQLException {
        System.out.println("Digite o ID do Serviço: ");
        int idServico = scan.nextInt();
        scan.nextLine(); // Consome o newline

        ServicoDAO servicoDAO = new ServicoDAO();
        Servico servico = servicoDAO.buscarPorId(idServico);

        if (servico != null) {
            System.out.println(servico);
        } else {
            System.out.println("Serviço não encontrado.");
        }
    }

    // Métodos para Fornecedor
    private static void cadastrarFornecedor() throws SQLException {
        System.out.println("Digite o CNPJ do Fornecedor: ");
        String cnpj = scan.nextLine();

        System.out.println("Digite o Telefone: ");
        String telefone = scan.nextLine();

        System.out.println("Digite o Email: ");
        String email = scan.nextLine();

        System.out.println("Digite o Código do Produto: ");
        long codProduto = scan.nextLong();
        scan.nextLine(); // Consome o newline

        System.out.println("Digite o ID do Endereço: ");
        int enderecoId = scan.nextInt();
        scan.nextLine(); // Consome o newline

        ProdutoDAO produtoDAO = new ProdutoDAO();
        Produto produto = produtoDAO.buscarPorCodigo(codProduto);

        EnderecoDAO enderecoDAO = new EnderecoDAO();
        Endereco endereco = enderecoDAO.buscarPorId(enderecoId);

        Fornecedor fornecedor = new Fornecedor(cnpj, telefone, email, produto, endereco);

        FornecedorDAO fornecedorDAO = new FornecedorDAO();
        fornecedorDAO.inserir(fornecedor);

        System.out.println("Fornecedor cadastrado com sucesso!");
    }

    private static void consultarFornecedor() throws SQLException {
        System.out.println("Digite o CNPJ do Fornecedor: ");
        String cnpj = scan.nextLine();

        FornecedorDAO fornecedorDAO = new FornecedorDAO();
        Fornecedor fornecedor = fornecedorDAO.buscarPorCnpj(cnpj);

        if (fornecedor != null) {
            System.out.println(fornecedor);
        } else {
            System.out.println("Fornecedor não encontrado.");
        }
    }
}
