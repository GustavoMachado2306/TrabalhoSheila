import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class Main {
    private static final Carrinho carrinho = new Carrinho();
    private static final Historico historico = new Historico();
    private static final Recomendacoes recomendacoes = new Recomendacoes();
    private static final User usuarioAtual = new User(UUID.randomUUID(), "Usuário Padrão", new ArrayList<>());

    public static void main(String[] args) {
        inicializarProdutos();
        exibirMenu();
    }

    private static void inicializarProdutos() {
        // Notebooks
        Produto.adicionarProduto("Notebook Dell i7", "Notebook Dell i7 16GB, 512GB SSD", 4500.00);
        Produto.adicionarProduto("Notebook MacBook Pro", "MacBook Pro M2 16GB, 512GB SSD", 12000.00);
        Produto.adicionarProduto("Notebook Lenovo", "Lenovo ThinkPad i5 8GB, 256GB SSD", 3500.00);
        Produto.adicionarProduto("Notebook HP", "HP Pavilion i5 8GB, 512GB SSD", 3800.00);

        // Smartphones
        Produto.adicionarProduto("iPhone 13", "iPhone 13 128GB", 5500.00);
        Produto.adicionarProduto("Samsung S21", "Samsung Galaxy S21 128GB", 4800.00);
        Produto.adicionarProduto("Xiaomi 12", "Xiaomi 12 256GB", 3500.00);
        Produto.adicionarProduto("Motorola Edge", "Motorola Edge 30 128GB", 2800.00);

        // Tablets
        Produto.adicionarProduto("iPad Pro", "iPad Pro 12.9 256GB", 8000.00);
        Produto.adicionarProduto("Samsung Tab S8", "Samsung Galaxy Tab S8 128GB", 4500.00);
        Produto.adicionarProduto("iPad Air", "iPad Air 64GB", 5000.00);
        Produto.adicionarProduto("Lenovo Tab", "Lenovo Tab P11 Pro 128GB", 3000.00);

        // Smart TVs
        Produto.adicionarProduto("Samsung 55\"", "Samsung 55\" 4K Smart TV", 3500.00);
        Produto.adicionarProduto("LG 65\"", "LG 65\" 4K Smart TV", 4500.00);
        Produto.adicionarProduto("Philips 50\"", "Philips 50\" 4K Smart TV", 2800.00);
        Produto.adicionarProduto("TCL 43\"", "TCL 43\" 4K Smart TV", 2000.00);

        // Fones de Ouvido
        Produto.adicionarProduto("AirPods Pro", "AirPods Pro com Cancelamento de Ruído", 2000.00);
        Produto.adicionarProduto("Sony WH-1000", "Sony WH-1000XM4", 2500.00);
        Produto.adicionarProduto("Samsung Buds", "Samsung Galaxy Buds Pro", 1500.00);
        Produto.adicionarProduto("JBL Tune", "JBL Tune 750BTNC", 800.00);

        // Monitores
        Produto.adicionarProduto("Dell 27\"", "Dell 27\" 4K UHD", 2500.00);
        Produto.adicionarProduto("LG 32\"", "LG 32\" UltraWide", 3000.00);
        Produto.adicionarProduto("Samsung 24\"", "Samsung 24\" Full HD", 1200.00);
        Produto.adicionarProduto("AOC 27\"", "AOC 27\" Gaming", 1800.00);

        // Teclados e Mouses
        Produto.adicionarProduto("Logitech MX", "Logitech MX Keys", 800.00);
        Produto.adicionarProduto("Razer BlackWidow", "Razer BlackWidow V3", 1200.00);
        Produto.adicionarProduto("Logitech G Pro", "Logitech G Pro Mouse", 600.00);
        Produto.adicionarProduto("HyperX Alloy", "HyperX Alloy Origins", 900.00);

        // Impressoras
        Produto.adicionarProduto("HP LaserJet", "HP LaserJet Pro M404", 1500.00);
        Produto.adicionarProduto("Epson EcoTank", "Epson EcoTank L3250", 1200.00);
        Produto.adicionarProduto("Canon PIXMA", "Canon PIXMA TS3350", 800.00);
        Produto.adicionarProduto("Brother DCP", "Brother DCP-L2530DW", 1300.00);
    }

    private static void exibirMenu() {
        Scanner scanner = new Scanner(System.in);
            while (true) {
            try {
                System.out.println("\n=== MENU PRINCIPAL ===");
                System.out.println("1. Ver todos os produtos");
                System.out.println("2. Adicionar produto ao carrinho");
                System.out.println("3. Ver carrinho");
                System.out.println("4. Ver histórico");
                System.out.println("5. Para Você");
                System.out.println("6. Cadastrar novo produto");
                System.out.println("7. Atualizar produto");
                System.out.println("8. Excluir produto");
                System.out.println("9. Ver estatísticas");
                System.out.println("10. Exportar relatório");
                System.out.println("11. Ver histórico de navegação");
                System.out.println("0. Sair");
                System.out.print("Escolha uma opção: ");

                int opcao = scanner.nextInt();
                scanner.nextLine(); // Limpar buffer

                switch (opcao) {
                    case 1 -> exibirProdutos();
                    case 2 -> adicionarAoCarrinho(scanner);
                    case 3 -> carrinho.exibirCarrinho();
                    case 4 -> historico.exibirHistorico();
                    case 5 -> {
                        System.out.println("\n=== PARA VOCÊ ===");
                        System.out.println("Recomendações personalizadas baseadas no seu histórico e carrinho:");
                        atualizarRecomendacoes();
                        recomendacoes.exibirRecomendacoes();
                    }
                    case 6 -> Produto.cadastrarNovoProduto();
                    case 7 -> atualizarProduto(scanner);
                    case 8 -> excluirProduto(scanner);
                    case 9 -> exibirEstatisticas();
                    case 10 -> exportarRelatorio();
                    case 11 -> exibirHistoricoNavegacao();
                    case 0 -> {
                        System.out.println("Saindo do sistema...");
                        scanner.close();
                        return;
                    }
                    default -> System.out.println("Opção inválida!");
                }
            } catch (Exception e) {
                System.out.println("Erro na entrada. Por favor, digite um número válido.");
                scanner.nextLine(); // Limpar buffer em caso de erro
            }
        }
    }

    private static void exibirProdutos() {
        System.out.println("\n=== PRODUTOS DISPONÍVEIS ===");
        int indice = 0;
        List<Produto> todosProdutos = new ArrayList<>();
        
        // Notebooks
        System.out.println("\n--- NOTEBOOKS ---");
        for (Produto produto : Produto.getProdutos()) {
            if (produto.getNome().contains("Notebook")) {
                todosProdutos.add(produto);
                System.out.printf("[%d] Nome: %-30s | Descrição: %-40s | Preço: R$ %.2f%n",
                    indice++,
                    produto.getNome(),
                    produto.getDescricao(),
                    produto.getPreco());
            }
        }

        // Smartphones
        System.out.println("\n--- SMARTPHONES ---");
        for (Produto produto : Produto.getProdutos()) {
            if (produto.getNome().contains("iPhone") || 
                produto.getNome().contains("Samsung") && produto.getNome().contains("S21") ||
                produto.getNome().contains("Xiaomi") ||
                produto.getNome().contains("Motorola")) {
                todosProdutos.add(produto);
                System.out.printf("[%d] Nome: %-30s | Descrição: %-40s | Preço: R$ %.2f%n",
                    indice++,
                    produto.getNome(),
                    produto.getDescricao(),
                    produto.getPreco());
            }
        }

        // Tablets
        System.out.println("\n--- TABLETS ---");
        for (Produto produto : Produto.getProdutos()) {
            if (produto.getNome().contains("iPad") || 
                produto.getNome().contains("Tab")) {
                todosProdutos.add(produto);
                System.out.printf("[%d] Nome: %-30s | Descrição: %-40s | Preço: R$ %.2f%n",
                    indice++,
                    produto.getNome(),
                    produto.getDescricao(),
                    produto.getPreco());
            }
        }

        // Smart TVs
        System.out.println("\n--- SMART TVs ---");
        for (Produto produto : Produto.getProdutos()) {
            if (produto.getNome().contains("\"")) {
                todosProdutos.add(produto);
                System.out.printf("[%d] Nome: %-30s | Descrição: %-40s | Preço: R$ %.2f%n",
                    indice++,
                    produto.getNome(),
                    produto.getDescricao(),
                    produto.getPreco());
            }
        }

        // Fones de Ouvido
        System.out.println("\n--- FONES DE OUVIDO ---");
        for (Produto produto : Produto.getProdutos()) {
            if (produto.getNome().contains("AirPods") || 
                produto.getNome().contains("Sony") ||
                produto.getNome().contains("Buds") ||
                produto.getNome().contains("JBL")) {
                todosProdutos.add(produto);
                System.out.printf("[%d] Nome: %-30s | Descrição: %-40s | Preço: R$ %.2f%n",
                    indice++,
                    produto.getNome(),
                    produto.getDescricao(),
                    produto.getPreco());
            }
        }

        // Monitores
        System.out.println("\n--- MONITORES ---");
        for (Produto produto : Produto.getProdutos()) {
            if (produto.getNome().contains("Dell") && produto.getNome().contains("\"") ||
                produto.getNome().contains("LG") && produto.getNome().contains("\"") ||
                produto.getNome().contains("Samsung") && produto.getNome().contains("\"") ||
                produto.getNome().contains("AOC")) {
                todosProdutos.add(produto);
                System.out.printf("[%d] Nome: %-30s | Descrição: %-40s | Preço: R$ %.2f%n",
                    indice++,
                    produto.getNome(),
                    produto.getDescricao(),
                    produto.getPreco());
            }
        }

        // Teclados e Mouses
        System.out.println("\n--- TECLADOS E MOUSES ---");
        for (Produto produto : Produto.getProdutos()) {
            if (produto.getNome().contains("Logitech") ||
                produto.getNome().contains("Razer") ||
                produto.getNome().contains("HyperX")) {
                todosProdutos.add(produto);
                System.out.printf("[%d] Nome: %-30s | Descrição: %-40s | Preço: R$ %.2f%n",
                    indice++,
                    produto.getNome(),
                    produto.getDescricao(),
                    produto.getPreco());
            }
        }

        // Impressoras
        System.out.println("\n--- IMPRESSORAS ---");
        for (Produto produto : Produto.getProdutos()) {
            if (produto.getNome().contains("HP") && produto.getNome().contains("LaserJet") ||
                produto.getNome().contains("Epson") ||
                produto.getNome().contains("Canon") ||
                produto.getNome().contains("Brother")) {
                todosProdutos.add(produto);
                System.out.printf("[%d] Nome: %-30s | Descrição: %-40s | Preço: R$ %.2f%n",
                    indice++,
                    produto.getNome(),
                    produto.getDescricao(),
                    produto.getPreco());
            }
        }

        // Opção para visualizar produto específico
        System.out.print("\nDigite o número do produto para ver mais detalhes (ou -1 para voltar): ");
        try {
            int escolha = Integer.parseInt(System.console().readLine());
            if (escolha >= 0 && escolha < todosProdutos.size()) {
                Produto produtoEscolhido = todosProdutos.get(escolha);
                registrarEventoNavegacao(produtoEscolhido);
                exibirDetalhesProduto(produtoEscolhido);
            } else if (escolha != -1) {
                System.out.println("Número de produto inválido!");
            }
        } catch (Exception e) {
            System.out.println("Erro na entrada. Por favor, digite um número válido.");
        }
    }

    private static void adicionarAoCarrinho(Scanner scanner) {
        System.out.println("\n=== ADICIONAR AO CARRINHO ===");
        System.out.println("1. Buscar produto por nome");
        System.out.println("2. Ver produtos por categoria");
        System.out.println("3. Ver produtos por faixa de preço");
        System.out.print("Escolha uma opção: ");

        try {
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            List<Produto> produtosEncontrados = new ArrayList<>();

            switch (opcao) {
                case 1 -> {
                    System.out.print("Digite o nome do produto: ");
                    String nome = scanner.nextLine();
                    produtosEncontrados = Produto.buscarPorNomeParcial(nome);
                }
                case 2 -> {
                    System.out.println("\nCategorias disponíveis:");
                    System.out.println("1. Notebooks");
                    System.out.println("2. Smartphones");
                    System.out.println("3. Tablets");
                    System.out.println("4. Smart TVs");
                    System.out.println("5. Fones de Ouvido");
                    System.out.println("6. Monitores");
                    System.out.println("7. Teclados e Mouses");
                    System.out.println("8. Impressoras");
                    System.out.print("Escolha uma categoria: ");
                    
                    int categoria = scanner.nextInt();
                    scanner.nextLine(); // Limpar buffer
                    
                    String categoriaNome = switch (categoria) {
                        case 1 -> "Notebook";
                        case 2 -> "iPhone";
                        case 3 -> "iPad";
                        case 4 -> "\"";
                        case 5 -> "AirPods";
                        case 6 -> "Dell";
                        case 7 -> "Logitech";
                        case 8 -> "HP";
                        default -> "";
                    };
                    
                    if (!categoriaNome.isEmpty()) {
                        produtosEncontrados = Produto.buscarPorCategoria(categoriaNome);
                    } else {
                        System.out.println("Categoria inválida!");
                        return;
                    }
                }
                case 3 -> {
                    System.out.print("Digite o preço mínimo: R$ ");
                    double precoMin = scanner.nextDouble();
                    System.out.print("Digite o preço máximo: R$ ");
                    double precoMax = scanner.nextDouble();
                    scanner.nextLine(); // Limpar buffer
                    
                    produtosEncontrados = Produto.getProdutos().stream()
                        .filter(p -> p.getPreco() >= precoMin && p.getPreco() <= precoMax)
                        .toList();
                }
                default -> {
                    System.out.println("Opção inválida!");
                    return;
                }
            }

            if (produtosEncontrados.isEmpty()) {
                System.out.println("Nenhum produto encontrado!");
                return;
            }

            // Mostrar produtos encontrados
            System.out.println("\nProdutos encontrados:");
            for (int i = 0; i < produtosEncontrados.size(); i++) {
                Produto p = produtosEncontrados.get(i);
                System.out.printf("[%d] %-30s | R$ %.2f%n", i, p.getNome(), p.getPreco());
            }

            // Opção para ver detalhes ou adicionar ao carrinho
            System.out.println("\nO que você deseja fazer?");
            System.out.println("1. Ver detalhes de um produto");
            System.out.println("2. Adicionar produto ao carrinho");
            System.out.print("Escolha uma opção: ");

            int acao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            System.out.print("Digite o número do produto: ");
            int indice = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            if (indice < 0 || indice >= produtosEncontrados.size()) {
                System.out.println("Número de produto inválido!");
                return;
            }

            Produto produtoEscolhido = produtosEncontrados.get(indice);

            switch (acao) {
                case 1 -> {
                    exibirDetalhesProduto(produtoEscolhido);
                    System.out.print("\nDeseja adicionar este produto ao carrinho? (S/N): ");
                    String resposta = scanner.nextLine();
                    if (resposta.equalsIgnoreCase("S")) {
                        carrinho.adicionarProduto(produtoEscolhido);
                        System.out.println("Produto adicionado ao carrinho!");
                    }
                }
                case 2 -> {
                    carrinho.adicionarProduto(produtoEscolhido);
                    System.out.println("Produto adicionado ao carrinho!");
                }
                default -> System.out.println("Opção inválida!");
            }

            // Mostrar resumo do carrinho
            System.out.println("\n=== RESUMO DO CARRINHO ===");
            System.out.printf("Total de itens: %d%n", carrinho.getProdutos().size());
            System.out.printf("Valor total: R$ %.2f%n", carrinho.calcularTotal());

        } catch (Exception e) {
            System.out.println("Erro na entrada. Por favor, digite valores válidos.");
            scanner.nextLine(); // Limpar buffer em caso de erro
        }
    }

    private static void atualizarRecomendacoes() {
        recomendacoes.gerarRecomendacoes(historico.getProdutosAnalisados(), carrinho.getProdutos());
    }

    private static void atualizarProduto(Scanner scanner) {
        exibirProdutos();
        System.out.print("\nDigite o nome do produto que deseja atualizar: ");
        String nomeAntigo = scanner.nextLine();

        System.out.print("Digite o novo nome do produto: ");
        String novoNome = scanner.nextLine();
        System.out.print("Digite a nova descrição do produto: ");
        String novaDescricao = scanner.nextLine();
        System.out.print("Digite o novo preço do produto: ");
        double novoPreco = scanner.nextDouble();
        scanner.nextLine(); // Limpar buffer

        if (Produto.atualizarProduto(nomeAntigo, novoNome, novaDescricao, novoPreco)) {
            System.out.println("Produto atualizado com sucesso!");
        } else {
            System.out.println("Produto não encontrado!");
        }
    }

    private static void excluirProduto(Scanner scanner) {
        System.out.println("\n=== EXCLUIR PRODUTO ===");
        System.out.println("1. Excluir por nome");
        System.out.println("2. Excluir por categoria");
        System.out.println("3. Excluir por preço máximo");
        System.out.println("4. Excluir por índice");
        System.out.print("Escolha uma opção: ");
        
        int opcao = scanner.nextInt();
        scanner.nextLine(); // Limpar buffer

        switch (opcao) {
            case 1 -> {
                exibirProdutos();
                System.out.print("\nDigite o nome do produto que deseja excluir: ");
                String nome = scanner.nextLine();
                if (Produto.excluirProduto(nome)) {
                    System.out.println("Produto excluído com sucesso!");
                } else {
                    System.out.println("Produto não encontrado!");
                }
            }
            case 2 -> {
                System.out.print("\nDigite a categoria que deseja excluir: ");
                String categoria = scanner.nextLine();
                int quantidade = Produto.excluirProdutosPorCategoria(categoria);
                System.out.printf("%d produtos da categoria '%s' foram excluídos!%n", quantidade, categoria);
            }
            case 3 -> {
                System.out.print("\nDigite o preço máximo dos produtos que deseja excluir: ");
                double precoMaximo = scanner.nextDouble();
                scanner.nextLine(); // Limpar buffer
                int quantidade = Produto.excluirProdutosPorPrecoMaximo(precoMaximo);
                System.out.printf("%d produtos com preço até R$ %.2f foram excluídos!%n", quantidade, precoMaximo);
            }
            case 4 -> {
                exibirProdutos();
                System.out.print("\nDigite o número do produto que deseja excluir: ");
                int indice = scanner.nextInt();
                scanner.nextLine(); // Limpar buffer
                
                Produto.getProdutoPorIndice(indice).ifPresentOrElse(
                    produto -> {
                        if (Produto.excluirProdutoPorIndice(indice)) {
                            System.out.printf("Produto '%s' excluído com sucesso!%n", produto.getNome());
                        }
                    },
                    () -> System.out.println("Índice inválido!")
                );
            }
            default -> System.out.println("Opção inválida!");
        }
    }

    private static void exibirEstatisticas() {
        System.out.println("\n=== ESTATÍSTICAS DO SISTEMA ===");
        
        // Estatísticas de Produtos
        System.out.println("\n--- PRODUTOS ---");
        List<Produto> todosProdutos = Produto.getProdutos();
        System.out.println("Total de produtos: " + todosProdutos.size());
        
        // Estatísticas por Categoria
        System.out.println("\nProdutos por categoria:");
        System.out.printf("Notebooks: %d%n", contarProdutosPorCategoria("Notebook"));
        System.out.printf("Smartphones: %d%n", contarProdutosPorCategoria("iPhone", "Samsung", "Xiaomi", "Motorola"));
        System.out.printf("Tablets: %d%n", contarProdutosPorCategoria("iPad", "Tab"));
        System.out.printf("Smart TVs: %d%n", contarProdutosPorCategoria("\""));
        System.out.printf("Fones de Ouvido: %d%n", contarProdutosPorCategoria("AirPods", "Sony", "Buds", "JBL"));
        System.out.printf("Monitores: %d%n", contarProdutosPorCategoria("Dell", "LG", "Samsung", "AOC"));
        System.out.printf("Teclados e Mouses: %d%n", contarProdutosPorCategoria("Logitech", "Razer", "HyperX"));
        System.out.printf("Impressoras: %d%n", contarProdutosPorCategoria("HP", "Epson", "Canon", "Brother"));

        // Estatísticas de Preços
        System.out.println("\n--- PREÇOS ---");
        double precoMedio = calcularPrecoMedio(todosProdutos);
        double precoMinimo = calcularPrecoMinimo(todosProdutos);
        double precoMaximo = calcularPrecoMaximo(todosProdutos);
        System.out.printf("Preço médio: R$ %.2f%n", precoMedio);
        System.out.printf("Preço mínimo: R$ %.2f%n", precoMinimo);
        System.out.printf("Preço máximo: R$ %.2f%n", precoMaximo);

        // Estatísticas do Carrinho
        System.out.println("\n--- CARRINHO ---");
        List<Produto> produtosCarrinho = carrinho.getProdutos();
        System.out.println("Quantidade de itens: " + produtosCarrinho.size());
        System.out.printf("Valor total: R$ %.2f%n", carrinho.calcularTotal());

        // Estatísticas do Histórico
        System.out.println("\n--- HISTÓRICO ---");
        List<Produto> produtosHistorico = historico.getProdutosAnalisados();
        System.out.println("Produtos analisados: " + produtosHistorico.size());
        
        // Estatísticas de Recomendações
        System.out.println("\n--- RECOMENDAÇÕES ---");
        List<Produto> produtosRecomendados = recomendacoes.getProdutosRecomendados();
        System.out.println("Produtos recomendados: " + produtosRecomendados.size());
    }

    private static int contarProdutosPorCategoria(String... palavrasChave) {
        return (int) Produto.getProdutos().stream()
            .filter(p -> {
                String nome = p.getNome().toLowerCase();
                for (String palavra : palavrasChave) {
                    if (nome.contains(palavra.toLowerCase())) {
                        return true;
                    }
                }
                return false;
            })
            .count();
    }

    private static double calcularPrecoMedio(List<Produto> produtos) {
        return produtos.stream()
            .mapToDouble(Produto::getPreco)
            .average()
            .orElse(0.0);
    }

    private static double calcularPrecoMinimo(List<Produto> produtos) {
        return produtos.stream()
            .mapToDouble(Produto::getPreco)
            .min()
            .orElse(0.0);
    }

    private static double calcularPrecoMaximo(List<Produto> produtos) {
        return produtos.stream()
            .mapToDouble(Produto::getPreco)
            .max()
            .orElse(0.0);
    }

    private static void exportarRelatorio() {
        System.out.println("\n=== EXPORTAR RELATÓRIO ===");
        System.out.println("1. Exportar estatísticas");
        System.out.println("2. Exportar lista de produtos");
        System.out.println("3. Exportar carrinho");
        System.out.println("4. Exportar histórico");
        System.out.println("5. Exportar recomendações");
        System.out.print("Escolha uma opção: ");

        try (Scanner scanner = new Scanner(System.in)) {
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            String nomeArquivo = "relatorio_" + System.currentTimeMillis() + ".txt";
            
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
                switch (opcao) {
                    case 1 -> {
                        writer.write("=== ESTATÍSTICAS DO SISTEMA ===\n");
                        writer.write("Total de produtos: " + Produto.getProdutos().size() + "\n");
                        writer.write("Total no carrinho: " + carrinho.getProdutos().size() + "\n");
                        writer.write("Total no histórico: " + historico.getProdutosAnalisados().size() + "\n");
                        writer.write("Total de recomendações: " + recomendacoes.getProdutosRecomendados().size() + "\n");
                    }
                    case 2 -> {
                        writer.write("=== LISTA DE PRODUTOS ===\n");
                        for (Produto produto : Produto.getProdutos()) {
                            writer.write(String.format("Nome: %s%n", produto.getNome()));
                            writer.write(String.format("Descrição: %s%n", produto.getDescricao()));
                            writer.write(String.format("Preço: R$ %.2f%n", produto.getPreco()));
                            writer.write("-------------------\n");
                        }
                    }
                    case 3 -> {
                        writer.write("=== CARRINHO ===\n");
                        for (Produto produto : carrinho.getProdutos()) {
                            writer.write(String.format("Nome: %s%n", produto.getNome()));
                            writer.write(String.format("Descrição: %s%n", produto.getDescricao()));
                            writer.write(String.format("Preço: R$ %.2f%n", produto.getPreco()));
                            writer.write("-------------------\n");
                        }
                        writer.write(String.format("Total: R$ %.2f%n", carrinho.calcularTotal()));
                    }
                    case 4 -> {
                        writer.write("=== HISTÓRICO ===\n");
                        for (Produto produto : historico.getProdutosAnalisados()) {
                            writer.write(String.format("Nome: %s%n", produto.getNome()));
                            writer.write(String.format("Descrição: %s%n", produto.getDescricao()));
                            writer.write(String.format("Preço: R$ %.2f%n", produto.getPreco()));
                            writer.write("-------------------\n");
                        }
                    }
                    case 5 -> {
                        writer.write("=== RECOMENDAÇÕES ===\n");
                        for (Produto produto : recomendacoes.getProdutosRecomendados()) {
                            writer.write(String.format("Nome: %s%n", produto.getNome()));
                            writer.write(String.format("Descrição: %s%n", produto.getDescricao()));
                            writer.write(String.format("Preço: R$ %.2f%n", produto.getPreco()));
                            writer.write("-------------------\n");
                        }
                    }
                    default -> {
                        System.out.println("Opção inválida!");
                        return;
                    }
                }
                System.out.println("Relatório exportado com sucesso para: " + nomeArquivo);
            } catch (IOException e) {
                System.out.println("Erro ao exportar relatório: " + e.getMessage());
            }
        }
    }

    private static void registrarEventoNavegacao(Produto produto) {
        NavigationEvent evento = new NavigationEvent(
            UUID.randomUUID(),
            usuarioAtual.getId(),
            produto.getId(),
            new Date()
        );
        usuarioAtual.getNavigationHistory().add(evento);
    }

    private static void exibirHistoricoNavegacao() {
        System.out.println("\n=== HISTÓRICO DE NAVEGAÇÃO ===");
        List<NavigationEvent> historico = usuarioAtual.getNavigationHistory();
        
        if (historico.isEmpty()) {
            System.out.println("Nenhum produto visualizado ainda.");
            return;
        }

        for (NavigationEvent evento : historico) {
            Produto produto = Produto.getProdutos().stream()
                .filter(p -> p.getId().equals(evento.getProductId()))
                .findFirst()
                .orElse(null);

            if (produto != null) {
                System.out.printf("Data: %s%n", evento.getAccessDate());
                System.out.printf("Produto: %s%n", produto.getNome());
                System.out.printf("Preço: R$ %.2f%n", produto.getPreco());
                System.out.println("-------------------");
            }
        }
    }

    private static void exibirDetalhesProduto(Produto produto) {
        // 1. Mostrar detalhes do produto
        System.out.println("\n=== DETALHES DO PRODUTO ===");
        System.out.printf("Nome: %s%n", produto.getNome());
        System.out.printf("Descrição: %s%n", produto.getDescricao());
        System.out.printf("Preço: R$ %.2f%n", produto.getPreco());
        System.out.println("------------------------");

        // 2. Registrar no histórico e navegação
        historico.adicionarProdutoAnalisado(produto);
        registrarEventoNavegacao(produto);

        // 3. Identificar a categoria do produto
        final String categoria;
        String nome = produto.getNome();
        if (nome.contains("Notebook")) {
            categoria = "Notebook";
        } else if (nome.contains("iPhone") || nome.contains("Samsung") || 
                  nome.contains("Xiaomi") || nome.contains("Motorola")) {
            categoria = "Smartphone";
        } else if (nome.contains("iPad") || nome.contains("Tab")) {
            categoria = "Tablet";
        } else if (nome.contains("\"")) {
            categoria = "Smart TV";
        } else if (nome.contains("AirPods") || nome.contains("Sony") || 
                  nome.contains("Buds") || nome.contains("JBL")) {
            categoria = "Fone de Ouvido";
        } else if (nome.contains("Dell") || nome.contains("LG") || 
                  nome.contains("Samsung") || nome.contains("AOC")) {
            categoria = "Monitor";
        } else if (nome.contains("Logitech") || nome.contains("Razer") || 
                  nome.contains("HyperX")) {
            categoria = "Teclado/Mouse";
        } else if (nome.contains("HP") || nome.contains("Epson") || 
                  nome.contains("Canon") || nome.contains("Brother")) {
            categoria = "Impressora";
        } else {
            categoria = "";
        }

        // 4. Buscar produtos da mesma categoria
        List<Produto> produtosMesmaCategoria = Produto.getProdutos().stream()
            .filter(p -> !p.equals(produto) && p.getNome().contains(categoria))
            .limit(3)
            .toList();

        // 5. Atualizar e mostrar recomendações
        atualizarRecomendacoes();
        
        if (!produtosMesmaCategoria.isEmpty()) {
            System.out.println("\n=== PRODUTOS RECOMENDADOS ===");
            System.out.println("Produtos similares que podem te interessar:");
            for (Produto recomendado : produtosMesmaCategoria) {
                System.out.printf("Nome: %-30s | Preço: R$ %.2f%n", 
                    recomendado.getNome(), 
                    recomendado.getPreco());
            }
        }

        // 6. Mostrar recomendações personalizadas
        List<Produto> recomendacoesPersonalizadas = recomendacoes.getProdutosRecomendados();
        if (!recomendacoesPersonalizadas.isEmpty()) {
            System.out.println("\nBaseado no seu histórico, você também pode gostar de:");
            for (Produto recomendado : recomendacoesPersonalizadas) {
                if (!produtosMesmaCategoria.contains(recomendado)) { // Evitar duplicatas
                    System.out.printf("Nome: %-30s | Preço: R$ %.2f%n", 
                        recomendado.getNome(), 
                        recomendado.getPreco());
                }
            }
        }
        
        System.out.println("\nPressione ENTER para voltar ao menu principal...");
        try {
            System.in.read();
        } catch (Exception e) {
            System.out.println("Erro ao ler entrada.");
        }
    }
}
