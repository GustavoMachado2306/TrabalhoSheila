import java.util.ArrayList;
import java.util.List;

public class Carrinho {
    private final List<Produto> produtos;

    public Carrinho() {
        this.produtos = new ArrayList<>();
    }

    public void adicionarProduto(Produto produto) {
        if (produto == null) {
            throw new IllegalArgumentException("Produto não pode ser nulo");
        }
        if (!produtos.contains(produto)) {
            produtos.add(produto);
        }
    }

    public void removerProduto(Produto produto) {
        if (produto == null) {
            throw new IllegalArgumentException("Produto não pode ser nulo");
        }
        produtos.remove(produto);
    }

    public List<Produto> getProdutos() {
        return new ArrayList<>(produtos);
    }

    public double calcularTotal() {
        return produtos.stream()
                      .mapToDouble(Produto::getPreco)
                      .sum();
    }

    public void limparCarrinho() {
        produtos.clear();
    }

    public void exibirCarrinho() {
        if (produtos.isEmpty()) {
            System.out.println("Carrinho vazio.");
            return;
        }
        System.out.println("Produtos no carrinho:");
        for (Produto produto : produtos) {
            System.out.println("Nome: " + produto.getNome() + 
                             ", Descrição: " + produto.getDescricao() + 
                             ", Preço: R$ " + String.format("%.2f", produto.getPreco()));
        }
        System.out.println("Total: R$ " + String.format("%.2f", calcularTotal()));
    }
} 