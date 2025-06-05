import java.util.*;
import java.util.function.Predicate;

public class Recomendacoes {
    private final List<Produto> produtosRecomendados;
    private final Map<String, Predicate<Produto>> categorias;

    public Recomendacoes() {
        this.produtosRecomendados = new ArrayList<>();
        this.categorias = new HashMap<>();
        inicializarCategorias();
    }

    private void inicializarCategorias() {
        categorias.put("NOTEBOOKS", p -> p.getNome().contains("Notebook"));
        categorias.put("SMARTPHONES", p -> p.getNome().contains("iPhone") || 
                                         p.getNome().contains("Samsung") || 
                                         p.getNome().contains("Xiaomi") || 
                                         p.getNome().contains("Motorola"));
        categorias.put("TABLETS", p -> p.getNome().contains("iPad") || 
                                     p.getNome().contains("Tab"));
        categorias.put("SMART TVs", p -> p.getNome().contains("\""));
        categorias.put("FONES DE OUVIDO", p -> p.getNome().contains("AirPods") || 
                                             p.getNome().contains("Sony") || 
                                             p.getNome().contains("Buds") || 
                                             p.getNome().contains("JBL"));
        categorias.put("MONITORES", p -> (p.getNome().contains("Dell") || 
                                        p.getNome().contains("LG") || 
                                        p.getNome().contains("Samsung") || 
                                        p.getNome().contains("AOC")) && 
                                        p.getNome().contains("\""));
        categorias.put("TECLADOS E MOUSES", p -> p.getNome().contains("Logitech") || 
                                                p.getNome().contains("Razer") || 
                                                p.getNome().contains("HyperX"));
        categorias.put("IMPRESSORAS", p -> p.getNome().contains("HP") || 
                                         p.getNome().contains("Epson") || 
                                         p.getNome().contains("Canon") || 
                                         p.getNome().contains("Brother"));
    }

    public void gerarRecomendacoes(List<Produto> historico, List<Produto> carrinho) {
        produtosRecomendados.clear();
        Set<String> produtosVistos = new HashSet<>();
        Set<String> categoriasVisualizadas = new HashSet<>();

        // Coleta produtos vistos e suas categorias
        for (Produto produto : historico) {
            produtosVistos.add(produto.getNome());
            String categoria = encontrarCategoria(produto);
            if (categoria != null) {
                categoriasVisualizadas.add(categoria);
            }
        }
        for (Produto produto : carrinho) {
            produtosVistos.add(produto.getNome());
        }

        // Gera recomendações por categoria
        if (!categoriasVisualizadas.isEmpty()) {
            for (String categoria : categoriasVisualizadas) {
                List<Produto> produtosCategoria = Produto.getProdutos().stream()
                    .filter(p -> !produtosVistos.contains(p.getNome()))
                    .filter(categorias.get(categoria))
                    .map(p -> criarProdutoRecomendado(p, categoria))
                    .toList();
                produtosRecomendados.addAll(produtosCategoria);
            }
        }

        // Adiciona produtos similares e complementares
        for (Produto produto : historico) {
            adicionarProdutosSimilares(produto);
        }
        for (Produto produto : carrinho) {
            adicionarProdutosComplementares(produto);
        }

        // Remove duplicatas e limita a quantidade
        produtosRecomendados.removeAll(carrinho);
        if (produtosRecomendados.size() > 4) {
            Collections.shuffle(produtosRecomendados);
            produtosRecomendados.subList(4, produtosRecomendados.size()).clear();
        }
    }

    private String encontrarCategoria(Produto produto) {
        for (Map.Entry<String, Predicate<Produto>> entry : categorias.entrySet()) {
            if (entry.getValue().test(produto)) {
                return entry.getKey();
            }
        }
        return null;
    }

    private Produto criarProdutoRecomendado(Produto original, String categoria) {
        double variacaoPreco = original.getPreco() * (0.8 + Math.random() * 0.4);
        return new Produto(
            original.getNome() + " (Recomendado)",
            "Produto recomendado da categoria " + categoria,
            variacaoPreco
        );
    }

    private void adicionarProdutosSimilares(Produto produto) {
        double precoVariacao = produto.getPreco() * 0.2;
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
        Produto complementar = new Produto(
            "Complemento para " + produto.getNome(),
            "Produto complementar a " + produto.getNome(),
            produto.getPreco() * 0.5
        );
        if (!produtosRecomendados.contains(complementar)) {
            produtosRecomendados.add(complementar);
        }
    }

    public Map<String, List<Produto>> agruparPorCategoria() {
        Map<String, List<Produto>> recomendacoesPorCategoria = new HashMap<>();
        for (Produto produto : produtosRecomendados) {
            String categoria = encontrarCategoria(produto);
            if (categoria != null) {
                recomendacoesPorCategoria.computeIfAbsent(categoria, k -> new ArrayList<>())
                    .add(produto);
            }
        }
        return recomendacoesPorCategoria;
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

        System.out.println("\n=== RECOMENDAÇÕES PERSONALIZADAS ===");
        Map<String, List<Produto>> recomendacoesPorCategoria = agruparPorCategoria();
        
        for (Map.Entry<String, List<Produto>> entry : recomendacoesPorCategoria.entrySet()) {
            System.out.println("\n--- " + entry.getKey() + " ---");
            for (Produto produto : entry.getValue()) {
                System.out.printf("Nome: %-30s | Descrição: %-40s | Preço: R$ %.2f%n",
                    produto.getNome(),
                    produto.getDescricao(),
                    produto.getPreco());
            }
        }
    }
} 