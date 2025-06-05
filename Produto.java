import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.UUID;

public class Produto {
    private static final List<Produto> produtos = new ArrayList<>();
    private UUID id;
    private String nome;
    private String descricao;
    private double preco;

    public Produto(String nome, String descricao, double preco) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser nulo ou vazio");
        }
        if (descricao == null || descricao.trim().isEmpty()) {
            throw new IllegalArgumentException("Descrição não pode ser nula ou vazia");
        }
        if (preco < 0) {
            throw new IllegalArgumentException("Preço não pode ser negativo");
        }
        this.id = UUID.randomUUID();
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
    }

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public static void adicionarProduto(String nome, String descricao, double preco) {
        produtos.add(new Produto(nome, descricao, preco));
    }

    public static void cadastrarNovoProduto() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("\n=== CADASTRO DE PRODUTO ===");
            System.out.println("Digite o nome do novo produto:");
            String nomeProduto = scanner.nextLine();
            System.out.println("Digite a descrição do produto:");
            String descricao = scanner.nextLine();
            System.out.println("Digite o preço do produto:");
            double preco = scanner.nextDouble();
            adicionarProduto(nomeProduto, descricao, preco);
            System.out.println("Produto cadastrado com sucesso!");
        }
    }

    public static List<Produto> getProdutos() {
        return new ArrayList<>(produtos);
    }

    // Busca por nome exato
    public static Optional<Produto> buscarPorNome(String nome) {
        return produtos.stream()
                .filter(p -> p.getNome().equalsIgnoreCase(nome))
                .findFirst();
    }

    // Busca por nome parcial
    public static List<Produto> buscarPorNomeParcial(String nome) {
        return produtos.stream()
                .filter(p -> p.getNome().toLowerCase().contains(nome.toLowerCase()))
                .toList();
    }

    // Busca por preço máximo
    public static List<Produto> buscarPorPrecoMaximo(double precoMaximo) {
        return produtos.stream()
                .filter(p -> p.getPreco() <= precoMaximo)
                .toList();
    }

    // Busca por categoria (baseado no nome)
    public static List<Produto> buscarPorCategoria(String categoria) {
        return produtos.stream()
                .filter(p -> p.getNome().toLowerCase().contains(categoria.toLowerCase()))
                .toList();
    }

    public static Optional<Produto> getProdutoPorIndice(int indice) {
        if (indice >= 0 && indice < produtos.size()) {
            return Optional.of(produtos.get(indice));
        }
        return Optional.empty();
    }

    public static boolean atualizarProduto(String nomeAntigo, String novoNome, String novaDescricao, double novoPreco) {
        return buscarPorNome(nomeAntigo)
            .map(produto -> {
                produto.setNome(novoNome);
                produto.setDescricao(novaDescricao);
                produto.setPreco(novoPreco);
                return true;
            })
            .orElse(false);
    }

    public static boolean excluirProduto(String nome) {
        return produtos.removeIf(p -> p.getNome().equalsIgnoreCase(nome));
    }

    public static boolean excluirProdutoPorIndice(int indice) {
        if (indice >= 0 && indice < produtos.size()) {
            produtos.remove(indice);
            return true;
        }
        return false;
    }

    public static int excluirProdutosPorCategoria(String categoria) {
        int tamanhoAntes = produtos.size();
        produtos.removeIf(p -> p.getNome().toLowerCase().contains(categoria.toLowerCase()));
        return tamanhoAntes - produtos.size();
    }

    public static int excluirProdutosPorPrecoMaximo(double precoMaximo) {
        int tamanhoAntes = produtos.size();
        produtos.removeIf(p -> p.getPreco() <= precoMaximo);
        return tamanhoAntes - produtos.size();
    }

    public String getNome() { return nome; }
    public String getDescricao() { return descricao; }
    public double getPreco() { return preco; }

    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser nulo ou vazio");
        }
        this.nome = nome;
    }

    public void setDescricao(String descricao) {
        if (descricao == null || descricao.trim().isEmpty()) {
            throw new IllegalArgumentException("Descrição não pode ser nula ou vazia");
        }
        this.descricao = descricao;
    }

    public void setPreco(double preco) {
        if (preco < 0) {
            throw new IllegalArgumentException("Preço não pode ser negativo");
        }
        this.preco = preco;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Produto produto = (Produto) obj;
        return nome.equals(produto.nome);
    }

    @Override
    public int hashCode() {
        return nome.hashCode();
    }
} 