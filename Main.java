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
        
        // Notebooks
        System.out.println("\n--- NOTEBOOKS ---");
        for (Produto produto : produtosPrincipais.getProdutos()) {
            if (produto.getNome().contains("Notebook")) {
                System.out.printf("Nome: %-30s | Descrição: %-40s | Preço: R$ %.2f%n",
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
                System.out.printf("Nome: %-30s | Descrição: %-40s | Preço: R$ %.2f%n",
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
                System.out.printf("Nome: %-30s | Descrição: %-40s | Preço: R$ %.2f%n",
                    produto.getNome(),
                    produto.getDescricao(),
                    produto.getPreco());
            }
        }

        // Smart TVs
        System.out.println("\n--- SMART TVs ---");
        for (Produto produto : produtosPrincipais.getProdutos()) {
            if (produto.getNome().contains("\"")) {
                System.out.printf("Nome: %-30s | Descrição: %-40s | Preço: R$ %.2f%n",
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
                System.out.printf("Nome: %-30s | Descrição: %-40s | Preço: R$ %.2f%n",
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
                System.out.printf("Nome: %-30s | Descrição: %-40s | Preço: R$ %.2f%n",
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
                System.out.printf("Nome: %-30s | Descrição: %-40s | Preço: R$ %.2f%n",
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
                System.out.printf("Nome: %-30s | Descrição: %-40s | Preço: R$ %.2f%n",
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

        for (Produto produto : produtosPrincipais.getProdutos()) {
            if (produto.getNome().equalsIgnoreCase(nomeProduto)) {
                carrinho.adicionarProduto(produto);
                historico.adicionarProdutoAnalisado(produto);
                System.out.println("Produto adicionado ao carrinho!");
                return;
            }
        }
        System.out.println("Produto não encontrado!");
    }

    private static void atualizarRecomendacoes() {
        recomendacoes.gerarRecomendacoes(historico.getProdutosAnalisados(), carrinho.getProdutos());
    }
}
