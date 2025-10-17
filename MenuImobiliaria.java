// Sem 'package'

import java.util.List;          
import java.util.Locale;        
import java.util.Scanner;       

public class MenuImobiliaria {
    
    private final GerenciadorImoveis gerenciador; 
    private final Scanner scanner;

    public MenuImobiliaria(GerenciadorImoveis gerenciador, Scanner scanner) {
        this.gerenciador = gerenciador; 
        this.scanner = scanner;
    }

    public void iniciar() {
        System.out.println("Bem-vindo ao Sistema de Corretora Imobiliaria");
        int opcao; 

        do {
            exibirMenu(); 
            try {
                opcao = Integer.parseInt(scanner.nextLine()); 
                processarOpcao(opcao); 
            } catch (NumberFormatException e) {
                System.out.println("Erro: Opcao invalida! Digite apenas numeros.");
                opcao = -1; 
            } catch (Exception e) {
                System.out.println("Ocorreu um erro. " + e.getMessage());
                opcao = -1; 
            }
        } while (opcao != 0); 

        System.out.println("Sistema finalizado.");
    }


    private void exibirMenu() {
        System.out.println("\n--- MENU PRINCIPAL ---");
        System.out.println("[1]. Cadastrar Imovel");
        System.out.println("[2]. Alugar Imovel");
        System.out.println("[3]. Disponibilizar Imovel (Encerrar Contrato)");
        System.out.println("[4]. Calcular Valor do Aluguel");
        System.out.println("[5]. Listar TODOS os Imoveis");
        System.out.println("[6]. Listar Imoveis ALUGADOS");
        System.out.println("[7]. Deletar Imovel");
        System.out.println("[0]. Sair");
        System.out.print("Digite sua opcao: ");
    }

    private void processarOpcao(int opcao) {
        switch (opcao) {
            case 1 -> cadastrarImovel();
            case 2 -> alugarImovel();
            case 3 -> disponibilizarImovel();
            case 4 -> calcularAluguel();
            case 5 -> listarTodosImoveis();
            case 6 -> listarImoveisAlugados();
            case 7 -> deletarImovel();
            case 0 -> {} 
            default -> System.out.println("Opcao invalida.");
        }
    }

    private void pressionarEnterParaContinuar() {
        System.out.println("\nPressione Enter para continuar...");
        scanner.nextLine();
    }

    private String lerString(String prompt) {
        System.out.print(prompt + ": ");
        return scanner.nextLine();
    }

    private double lerDouble(String prompt) {
        while (true) {
            try {
                return Double.parseDouble(lerString(prompt));
            } catch (NumberFormatException e) {
                System.out.println("Valor invalido. Digite um numero (ex: 1500.50).");
            }
        }
    }

    private int lerInt(String prompt) {
        while (true) {
            try {
                return Integer.parseInt(lerString(prompt));
            } catch (NumberFormatException e) {
                System.out.println("Valor invalido. Digite um numero inteiro.");
            }
        }
    }

    private boolean lerBoolean(String prompt) {
        while (true) {
            String input = lerString(prompt + " (s/n)").toLowerCase();
            if ("s".equals(input)) return true;
            if ("n".equals(input)) return false;
            System.out.println("Resposta invalida. Digite 's' para sim ou 'n' para nao.");
        }
    }

    private Proprietario lerDadosProprietario() {
        System.out.println("--- Dados do Proprietario ---");
        String nome = lerString("Nome do Proprietario");
        String tel = lerString("Telefone do Proprietario");
        String cpf = lerString("CPF do Proprietario");
        return new Proprietario(nome, tel, cpf);
    }

    private Inquilino lerDadosInquilino() {
        System.out.println("--- Dados do Inquilino ---");
        String nome = lerString("Nome do Inquilino");
        String tel = lerString("Telefone do Inquilino");
        String cpf = lerString("CPF do Inquilino");
        return new Inquilino(nome, tel, cpf);
    }
    
    private boolean exibirListaDeImoveis(List<Imovel> lista, String titulo) {
        System.out.println("\n--- " + titulo + " ---");
        if (lista.isEmpty()) {
            System.out.println("Nenhum imovel encontrado.");
            return false;
        }

        for (Imovel imovel : lista) {
            System.out.println("---------------------------------");
            System.out.println(imovel.verificarDisponibilidade()); 
            
            if (titulo.contains("TODOS")) {
                 System.out.println("Permite Pets: " + (imovel.isPermitePets() ? "Sim" : "Nao"));
                 System.out.println("Proprietario: " + imovel.contatoProprietario());
            }
            
            if (titulo.contains("ALUGADOS") && imovel.getInquilino() != null) {
                 System.out.println("Inquilino: " + imovel.getInquilino().getNome());
            }
        }
        System.out.println("---------------------------------"); 
        return true;
    }
    
    private void cadastrarImovel() {
        System.out.println("--- Cadastro de Novo Imovel ---");
        Proprietario prop = lerDadosProprietario();
        System.out.println("--- Dados do Imovel ---");
        String endereco = lerString("Endereco (Rua/Av.)");
        String numero = lerString("Numero do Predio/Casa");
        double aluguelBase = lerDouble("Valor do Aluguel Mensal (ex: 2000.00)");
        double manutencao = lerDouble("Taxa Manutencao"); 
        boolean pets = lerBoolean("Permite pets?");
        System.out.println("Tipo de Imovel: 1. Casa | 2. Apartamento | 3. Comercial");
        int tipo = lerInt("Digite o numero correspondente ao tipo");

        Imovel novoImovel = null;
        switch (tipo) {
            case 1:
                novoImovel = new Casa(endereco, numero, prop, aluguelBase, manutencao, pets);
                break;
            case 2:
                String unidade = lerString("Numero do Apartamento (ex: 101)"); 
                novoImovel = new Apartamento(endereco, numero, unidade, prop, aluguelBase, manutencao, pets); 
                break;
            case 3:
                String tipoNegocio = lerString("Tipo de negocio permitido (ex: Loja)");
                novoImovel = new Comercio(endereco, numero, prop, aluguelBase, manutencao, pets, tipoNegocio);
                break;
            default:
                System.out.println("Tipo invalido. Cadastro cancelado.");
                pressionarEnterParaContinuar(); 
                return;
        }

        if (gerenciador.cadastrarImovel(novoImovel)) { 
            System.out.println("Imovel cadastrado com sucesso!");
        } else {
            System.out.println("Erro: Imovel com este endereco e numero ja existe.");
        }
        pressionarEnterParaContinuar(); 
    }

    private void alugarImovel() {
        System.out.println("--- Alugar Imovel ---");
        
        String endereco = lerString("Digite o Endereco do imovel que deseja alugar");
        String numero = lerString("Digite o Numero do imovel");
        
        Inquilino inquilino = lerDadosInquilino();
        int meses = lerInt("Tempo de contrato (em meses)");

        CalculaAluguel calc = gerenciador.calcularAluguel(endereco, numero, meses); 

        if (calc == null) {
             System.out.println("Erro: Imovel com este endereco e numero nao encontrado para calcular.");
             pressionarEnterParaContinuar();
             return;
        }

        if (gerenciador.alugarImovel(endereco, numero, inquilino, meses)) { 
            System.out.println("Imovel alugado com sucesso!");
            
            Imovel imovelAlugado = gerenciador.buscarPorEnderecoENumero(endereco, numero); 
            
            if (imovelAlugado != null) { 
                System.out.println("\n--- Detalhes do Contrato ---");
                System.out.println("Imovel: " + endereco + ", " + numero);
                System.out.println("Inquilino: " + inquilino.getNome());
                System.out.println("Periodo: " + meses + " meses");
                
                System.out.println("--- Detalhes Financeiros ---");
                double valorMensalTotal = calc.getValorAluguelBaseMensal() + calc.getTaxaManutencaoMensal();
                System.out.println("Valor Mensal (Aluguel + Taxa Manutencao): " + valorMensalTotal);
                System.out.println("Valor Total para " + meses + " meses: " + calc.getValorTotalPeriodo()); 
            }

        } else {
            System.out.println("Erro: Nao foi possivel alugar. Imovel nao encontrado ou ja alugado.");
        }
        pressionarEnterParaContinuar(); 
    }

    private void disponibilizarImovel() {
        System.out.println("--- Disponibilizar Imovel (Encerrar Contrato) ---");
        
        String endereco = lerString("Digite o Endereco do imovel que deseja disponibilizar");
        String numero = lerString("Digite o Numero do imovel");

        if (gerenciador.disponibilizarImovel(endereco, numero)) { 
            System.out.println("Imovel marcado como disponivel.");
        } else {
            System.out.println("Erro: Imovel nao encontrado ou ja estava disponivel.");
        }
        pressionarEnterParaContinuar(); 
    }

    private void calcularAluguel() {
        System.out.println("--- Calculo de Aluguel ---");
        
        String endereco = lerString("Digite o Endereco do imovel para calcular");
        String numero = lerString("Digite o Numero do imovel");
        int meses = lerInt("Calcular para quantos meses?");

        CalculaAluguel calc = gerenciador.calcularAluguel(endereco, numero, meses); 

        if (calc != null) { 
            System.out.println("\n--- Projecao de Custos (" + endereco + ", " + numero + ", " + meses + " meses) ---");
            System.out.println("Aluguel Base Mensal: " + calc.getValorAluguelBaseMensal());
            System.out.println("Taxa Manutencao Mensal: " + calc.getTaxaManutencaoMensal());
            System.out.println("----------------------------------------------");
            System.out.println("VALOR TOTAL PARA " + meses + " MESES: " + calc.getValorTotalPeriodo());

        } else {
            System.out.println("Erro: Imovel nao encontrado.");
        }
        pressionarEnterParaContinuar(); 
    }

    private void listarTodosImoveis() {
        List<Imovel> lista = gerenciador.getTodosImoveis(); 
        exibirListaDeImoveis(lista, "Lista de TODOS os Imoveis");
        pressionarEnterParaContinuar(); 
    }

    private void listarImoveisAlugados() {
        List<Imovel> lista = gerenciador.getImoveisAlugados(); 
        exibirListaDeImoveis(lista, "Lista de Imoveis ALUGADOS");
        pressionarEnterParaContinuar(); 
    }

    private void deletarImovel() {
        System.out.println("--- Deletar Imovel ---");
        
        String endereco = lerString("Digite o Endereco do imovel que deseja deletar");
        String numero = lerString("Digite o Numero do imovel");

        if (gerenciador.deletarImovel(endereco, numero)) { 
            System.out.println("Imovel (" + endereco + ", " + numero + ") deletado com sucesso.");
        } else {
            System.out.println("Erro: Imovel nao encontrado ou nao pode ser deletado (esta alugado).");
        }
        pressionarEnterParaContinuar(); 
    }
}