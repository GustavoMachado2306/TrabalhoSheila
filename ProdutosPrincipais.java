import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    // Busca por nome exato
    public Optional<Produto> buscarPorNome(String nome) {
        return produtos.stream()
                .filter(p -> p.getNome().equalsIgnoreCase(nome))
                .findFirst();
    }

    // Busca por nome parcial
    public List<Produto> buscarPorNomeParcial(String nome) {
        return produtos.stream()
                .filter(p -> p.getNome().toLowerCase().contains(nome.toLowerCase()))
                .toList();
    }

    // Busca por preço máximo
    public List<Produto> buscarPorPrecoMaximo(double precoMaximo) {
        return produtos.stream()
                .filter(p -> p.getPreco() <= precoMaximo)
                .toList();
    }

    // Busca por categoria (baseado no nome)
    public List<Produto> buscarPorCategoria(String categoria) {
        return produtos.stream()
                .filter(p -> p.getNome().toLowerCase().contains(categoria.toLowerCase()))
                .toList();
    }

    // Atualizar produto
    public boolean atualizarProduto(String nomeAntigo, String novoNome, String novaDescricao, double novoPreco) {
        Optional<Produto> produtoOpt = buscarPorNome(nomeAntigo);
        if (produtoOpt.isPresent()) {
            Produto produto = produtoOpt.get();
            produto.setNome(novoNome);
            produto.setDescricao(novaDescricao);
            produto.setPreco(novoPreco);
            return true;
        }
        return false;
    }

    // Excluir produto por nome
    public boolean excluirProduto(String nome) {
        return produtos.removeIf(p -> p.getNome().equalsIgnoreCase(nome));
    }

    // Excluir produtos por categoria
    public int excluirProdutosPorCategoria(String categoria) {
        int quantidadeAntes = produtos.size();
        produtos.removeIf(p -> p.getNome().toLowerCase().contains(categoria.toLowerCase()));
        return quantidadeAntes - produtos.size();
    }

    // Excluir produtos por preço máximo
    public int excluirProdutosPorPrecoMaximo(double precoMaximo) {
        int quantidadeAntes = produtos.size();
        produtos.removeIf(p -> p.getPreco() <= precoMaximo);
        return quantidadeAntes - produtos.size();
    }

    // Excluir produto por índice
    public boolean excluirProdutoPorIndice(int indice) {
        if (indice >= 0 && indice < produtos.size()) {
            produtos.remove(indice);
            return true;
        }
        return false;
    }

    // Obter produto por índice
    public Optional<Produto> getProdutoPorIndice(int indice) {
        if (indice >= 0 && indice < produtos.size()) {
            return Optional.of(produtos.get(indice));
        }
        return Optional.empty();
    }
} 