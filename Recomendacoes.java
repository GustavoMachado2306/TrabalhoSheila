import java.util.ArrayList;
import java.util.List;

public class Recomendacoes {
    private final List<Produto> produtosRecomendados;

    public Recomendacoes() {
        this.produtosRecomendados = new ArrayList<>();
    }

    public void gerarRecomendacoes(List<Produto> historico, List<Produto> carrinho) {
        produtosRecomendados.clear();
        
        // Adiciona produtos similares baseados no histórico
        for (Produto produto : historico) {
            adicionarProdutosSimilares(produto);
        }
        
        // Adiciona produtos complementares baseados no carrinho
        for (Produto produto : carrinho) {
            adicionarProdutosComplementares(produto);
        }
        
        // Remove produtos que já estão no carrinho
        produtosRecomendados.removeAll(carrinho);
    }

    private void adicionarProdutosSimilares(Produto produto) {
        // Simula produtos similares com preços próximos
        double precoVariacao = produto.getPreco() * 0.2; // 20% de variação
        Produto similar = new Produto(
            produto.getNome() + " (Similar)",
            "Produto similar a " + produto.getNome(),
            produto.getPreco() + (Math.random() * precoVariacao * 2 - precoVariacao)
        );
        if (!produtosRecomendados.contains(similar)) {
            produtosRecomendados.add(similar);
        }
    }

    private void adicionarProdutosComplementares(Produto produto) {
        // Simula produtos complementares
        Produto complementar = new Produto(
            "Complemento para " + produto.getNome(),
            "Produto complementar a " + produto.getNome(),
            produto.getPreco() * 0.5 // 50% do preço do produto original
        );
        if (!produtosRecomendados.contains(complementar)) {
            produtosRecomendados.add(complementar);
        }
    }

    public List<Produto> getProdutosRecomendados() {
        return new ArrayList<>(produtosRecomendados);
    }

    public void limparRecomendacoes() {
        produtosRecomendados.clear();
    }

    public void exibirRecomendacoes() {
        if (produtosRecomendados.isEmpty()) {
            System.out.println("Nenhuma recomendação disponível no momento.");
            return;
        }
        System.out.println("Produtos recomendados para você:");
        for (Produto produto : produtosRecomendados) {
            System.out.println("Nome: " + produto.getNome() + 
                             ", Descrição: " + produto.getDescricao() + 
                             ", Preço: R$ " + String.format("%.2f", produto.getPreco()));
        }
    }
} 