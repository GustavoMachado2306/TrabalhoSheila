import java.util.ArrayList;
import java.util.List;

public class Historico {
    private final List<Produto> produtosAnalisados;

    public Historico() {
        this.produtosAnalisados = new ArrayList<>();
    }

    public void adicionarProdutoAnalisado(Produto produto) {
        if (produto == null) {
            throw new IllegalArgumentException("Produto não pode ser nulo");
        }
        if (!produtosAnalisados.contains(produto)) {
            produtosAnalisados.add(produto);
        }
    }

    public List<Produto> getProdutosAnalisados() {
        return new ArrayList<>(produtosAnalisados);
    }

    public void limparHistorico() {
        produtosAnalisados.clear();
    }

    public void exibirHistorico() {
        if (produtosAnalisados.isEmpty()) {
            System.out.println("Nenhum produto analisado ainda.");
            return;
        }
        System.out.println("Histórico de produtos analisados:");
        for (Produto produto : produtosAnalisados) {
            System.out.println("Nome: " + produto.getNome() + 
                             ", Descrição: " + produto.getDescricao() + 
                             ", Preço: R$ " + String.format("%.2f", produto.getPreco()));
        }
    }
} 