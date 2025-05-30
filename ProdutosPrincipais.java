import java.util.ArrayList;
import java.util.List;

public class ProdutosPrincipais {
    private final List<Produto> produtos;

    public ProdutosPrincipais() {
        this.produtos = new ArrayList<>();
    }

    public void adicionarProduto(String nome, String descricao, double preco) {
        Produto produto = new Produto(nome, descricao, preco);
        produtos.add(produto);
    }

    public List<Produto> getProdutos() {
        return new ArrayList<>(produtos);
    }
} 