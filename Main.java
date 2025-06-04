import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final ProdutosPrincipais produtosPrincipais = new ProdutosPrincipais();
    private static final Carrinho carrinho = new Carrinho();
    private static final Historico historico = new Historico();
    private static final Recomendacoes recomendacoes = new Recomendacoes();
    private static final CadastroProduto cadastroProduto = new CadastroProduto(produtosPrincipais);

    public static void main(String[] args) {
        inicializarProdutos();
        exibirMenu();
    }

    private static void inicializarProdutos() {
        // Notebooks
        produtosPrincipais.adicionarProduto("Notebook Dell i7", "Notebook Dell i7 16GB, 512GB SSD", 4500.00);
        produtosPrincipais.adicionarProduto("Notebook MacBook Pro", "MacBook Pro M2 16GB, 512GB SSD", 12000.00);
        produtosPrincipais.adicionarProduto("Notebook Lenovo", "Lenovo ThinkPad i5 8GB, 256GB SSD", 3500.00);
        produtosPrincipais.adicionarProduto("Notebook HP", "HP Pavilion i5 8GB, 512GB SSD", 3800.00);

        // Smartphones
        produtosPrincipais.adicionarProduto("iPhone 13", "iPhone 13 128GB", 5500.00);
        produtosPrincipais.adicionarProduto("Samsung S21", "Samsung Galaxy S21 128GB", 4800.00);
        produtosPrincipais.adicionarProduto("Xiaomi 12", "Xiaomi 12 256GB", 3500.00);
        produtosPrincipais.adicionarProduto("Motorola Edge", "Motorola Edge 30 128GB", 2800.00);

        // Tablets
        produtosPrincipais.adicionarProduto("iPad Pro", "iPad Pro 12.9 256GB", 8000.00);
        produtosPrincipais.adicionarProduto("Samsung Tab S8", "Samsung Galaxy Tab S8 128GB", 4500.00);
        produtosPrincipais.adicionarProduto("iPad Air", "iPad Air 64GB", 5000.00);
        produtosPrincipais.adicionarProduto("Lenovo Tab", "Lenovo Tab P11 Pro 128GB", 3000.00);

        // Smart TVs
        produtosPrincipais.adicionarProduto("Samsung 55\"", "Samsung 55\" 4K Smart TV", 3500.00);
        produtosPrincipais.adicionarProduto("LG 65\"", "LG 65\" 4K Smart TV", 4500.00);
        produtosPrincipais.adicionarProduto("Philips 50\"", "Philips 50\" 4K Smart TV", 2800.00);
        produtosPrincipais.adicionarProduto("TCL 43\"", "TCL 43\" 4K Smart TV", 2000.00);

        // Fones de Ouvido
        produtosPrincipais.adicionarProduto("AirPods Pro", "AirPods Pro com Cancelamento de Ruído", 2000.00);
        produtosPrincipais.adicionarProduto("Sony WH-1000", "Sony WH-1000XM4", 2500.00);
        produtosPrincipais.adicionarProduto("Samsung Buds", "Samsung Galaxy Buds Pro", 1500.00);
        produtosPrincipais.adicionarProduto("JBL Tune", "JBL Tune 750BTNC", 800.00);

        // Monitores
        produtosPrincipais.adicionarProduto("Dell 27\"", "Dell 27\" 4K UHD", 2500.00);
        produtosPrincipais.adicionarProduto("LG 32\"", "LG 32\" UltraWide", 3000.00);
        produtosPrincipais.adicionarProduto("Samsung 24\"", "Samsung 24\" Full HD", 1200.00);
        produtosPrincipais.adicionarProduto("AOC 27\"", "AOC 27\" Gaming", 1800.00);

        // Teclados e Mouses
        produtosPrincipais.adicionarProduto("Logitech MX", "Logitech MX Keys", 800.00);
        produtosPrincipais.adicionarProduto("Razer BlackWidow", "Razer BlackWidow V3", 1200.00);
        produtosPrincipais.adicionarProduto("Logitech G Pro", "Logitech G Pro Mouse", 600.00);
        produtosPrincipais.adicionarProduto("HyperX Alloy", "HyperX Alloy Origins", 900.00);

        // Impressoras
        produtosPrincipais.adicionarProduto("HP LaserJet", "HP LaserJet Pro M404", 1500.00);
        produtosPrincipais.adicionarProduto("Epson EcoTank", "Epson EcoTank L3250", 1200.00);
        produtosPrincipais.adicionarProduto("Canon PIXMA", "Canon PIXMA TS3350", 800.00);
        produtosPrincipais.adicionarProduto("Brother DCP", "Brother DCP-L2530DW", 1300.00);
    }

    private static void exibirMenu() {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("\n=== MENU PRINCIPAL ===");
                System.out.println("1. Ver produtos disponíveis");
                System.out.println("2. Adicionar produto ao carrinho");
                System.out.println("3. Ver carrinho");
                System.out.println("4. Ver histórico");
                System.out.println("5. Para Você");
                System.out.println("6. Cadastrar novo produto");
                System.out.println("7. Atualizar produto");
                System.out.println("8. Excluir produto");
                System.out.println("9. Ver estatísticas");
                System.out.println("10. Exportar relatório");
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
                    case 6 -> cadastroProduto.cadastrarNovoProduto();
                    case 7 -> atualizarProduto(scanner);
                    case 8 -> excluirProduto(scanner);
                    case 9 -> exibirEstatisticas();
                    case 10 -> exportarRelatorio();
                    case 0 -> {
                        System.out.println("Saindo do sistema...");
                        return;
                    }
                    default -> System.out.println("Opção inválida!");
                }
            }
        }
    }

    private static void exibirProdutos() {
        System.out.println("\n=== PRODUTOS DISPONÍVEIS ===");
        int indice = 0;
        
        // Notebooks
        System.out.println("\n--- NOTEBOOKS ---");
        for (Produto produto : produtosPrincipais.getProdutos()) {
            if (produto.getNome().contains("Notebook")) {
                System.out.printf("[%d] Nome: %-30s | Descrição: %-40s | Preço: R$ %.2f%n",
                    indice++,
                    produto.getNome(),
                    produto.getDescricao(),
                    produto.getPreco());
            }
        }

        // Smartphones
        System.out.println("\n--- SMARTPHONES ---");
        for (Produto produto : produtosPrincipais.getProdutos()) {
            if (produto.getNome().contains("iPhone") || 
                produto.getNome().contains("Samsung") && produto.getNome().contains("S21") ||
                produto.getNome().contains("Xiaomi") ||
                produto.getNome().contains("Motorola")) {
                System.out.printf("[%d] Nome: %-30s | Descrição: %-40s | Preço: R$ %.2f%n",
                    indice++,
                    produto.getNome(),
                    produto.getDescricao(),
                    produto.getPreco());
            }
        }

        // Tablets
        System.out.println("\n--- TABLETS ---");
        for (Produto produto : produtosPrincipais.getProdutos()) {
            if (produto.getNome().contains("iPad") || 
                produto.getNome().contains("Tab")) {
                System.out.printf("[%d] Nome: %-30s | Descrição: %-40s | Preço: R$ %.2f%n",
                    indice++,
                    produto.getNome(),
                    produto.getDescricao(),
                    produto.getPreco());
            }
        }

        // Smart TVs
        System.out.println("\n--- SMART TVs ---");
        for (Produto produto : produtosPrincipais.getProdutos()) {
            if (produto.getNome().contains("\"")) {
                System.out.printf("[%d] Nome: %-30s | Descrição: %-40s | Preço: R$ %.2f%n",
                    indice++,
                    produto.getNome(),
                    produto.getDescricao(),
                    produto.getPreco());
            }
        }

        // Fones de Ouvido
        System.out.println("\n--- FONES DE OUVIDO ---");
        for (Produto produto : produtosPrincipais.getProdutos()) {
            if (produto.getNome().contains("AirPods") || 
                produto.getNome().contains("Sony") ||
                produto.getNome().contains("Buds") ||
                produto.getNome().contains("JBL")) {
                System.out.printf("[%d] Nome: %-30s | Descrição: %-40s | Preço: R$ %.2f%n",
                    indice++,
                    produto.getNome(),
                    produto.getDescricao(),
                    produto.getPreco());
            }
        }

        // Monitores
        System.out.println("\n--- MONITORES ---");
        for (Produto produto : produtosPrincipais.getProdutos()) {
            if (produto.getNome().contains("Dell") && produto.getNome().contains("\"") ||
                produto.getNome().contains("LG") && produto.getNome().contains("\"") ||
                produto.getNome().contains("Samsung") && produto.getNome().contains("\"") ||
                produto.getNome().contains("AOC")) {
                System.out.printf("[%d] Nome: %-30s | Descrição: %-40s | Preço: R$ %.2f%n",
                    indice++,
                    produto.getNome(),
                    produto.getDescricao(),
                    produto.getPreco());
            }
        }

        // Teclados e Mouses
        System.out.println("\n--- TECLADOS E MOUSES ---");
        for (Produto produto : produtosPrincipais.getProdutos()) {
            if (produto.getNome().contains("Logitech") ||
                produto.getNome().contains("Razer") ||
                produto.getNome().contains("HyperX")) {
                System.out.printf("[%d] Nome: %-30s | Descrição: %-40s | Preço: R$ %.2f%n",
                    indice++,
                    produto.getNome(),
                    produto.getDescricao(),
                    produto.getPreco());
            }
        }

        // Impressoras
        System.out.println("\n--- IMPRESSORAS ---");
        for (Produto produto : produtosPrincipais.getProdutos()) {
            if (produto.getNome().contains("HP") && produto.getNome().contains("LaserJet") ||
                produto.getNome().contains("Epson") ||
                produto.getNome().contains("Canon") ||
                produto.getNome().contains("Brother")) {
                System.out.printf("[%d] Nome: %-30s | Descrição: %-40s | Preço: R$ %.2f%n",
                    indice++,
                    produto.getNome(),
                    produto.getDescricao(),
                    produto.getPreco());
            }
        }
    }

    private static void adicionarAoCarrinho(Scanner scanner) {
        exibirProdutos();
        System.out.print("\nDigite o nome do produto que deseja adicionar: ");
        String nomeProduto = scanner.nextLine();

        produtosPrincipais.buscarPorNome(nomeProduto)
            .ifPresentOrElse(
                produto -> {
                    carrinho.adicionarProduto(produto);
                    historico.adicionarProdutoAnalisado(produto);
                    System.out.println("Produto adicionado ao carrinho!");
                },
                () -> System.out.println("Produto não encontrado!")
            );
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

        if (produtosPrincipais.atualizarProduto(nomeAntigo, novoNome, novaDescricao, novoPreco)) {
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
                if (produtosPrincipais.excluirProduto(nome)) {
                    System.out.println("Produto excluído com sucesso!");
                } else {
                    System.out.println("Produto não encontrado!");
                }
            }
            case 2 -> {
                System.out.print("\nDigite a categoria que deseja excluir: ");
                String categoria = scanner.nextLine();
                int quantidade = produtosPrincipais.excluirProdutosPorCategoria(categoria);
                System.out.printf("%d produtos da categoria '%s' foram excluídos!%n", quantidade, categoria);
            }
            case 3 -> {
                System.out.print("\nDigite o preço máximo dos produtos que deseja excluir: ");
                double precoMaximo = scanner.nextDouble();
                scanner.nextLine(); // Limpar buffer
                int quantidade = produtosPrincipais.excluirProdutosPorPrecoMaximo(precoMaximo);
                System.out.printf("%d produtos com preço até R$ %.2f foram excluídos!%n", quantidade, precoMaximo);
            }
            case 4 -> {
                exibirProdutos();
                System.out.print("\nDigite o número do produto que deseja excluir: ");
                int indice = scanner.nextInt();
                scanner.nextLine(); // Limpar buffer
                
                produtosPrincipais.getProdutoPorIndice(indice).ifPresentOrElse(
                    produto -> {
                        if (produtosPrincipais.excluirProdutoPorIndice(indice)) {
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
        List<Produto> todosProdutos = produtosPrincipais.getProdutos();
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
        return (int) produtosPrincipais.getProdutos().stream()
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
                        writer.write("Total de produtos: " + produtosPrincipais.getProdutos().size() + "\n");
                        writer.write("Total no carrinho: " + carrinho.getProdutos().size() + "\n");
                        writer.write("Total no histórico: " + historico.getProdutosAnalisados().size() + "\n");
                        writer.write("Total de recomendações: " + recomendacoes.getProdutosRecomendados().size() + "\n");
                    }
                    case 2 -> {
                        writer.write("=== LISTA DE PRODUTOS ===\n");
                        for (Produto produto : produtosPrincipais.getProdutos()) {
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
}
