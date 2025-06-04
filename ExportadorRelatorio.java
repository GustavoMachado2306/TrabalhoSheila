import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ExportadorRelatorio {
    private static String gerarNomeArquivo() {
        LocalDateTime agora = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
        return "relatorio_" + agora.format(formatter) + ".txt";
    }

    public static void exportarEstatisticas(List<Produto> todosProdutos, Carrinho carrinho, Historico historico, Recomendacoes recomendacoes) {
        String nomeArquivo = gerarNomeArquivo();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
            writer.write("=== ESTATÍSTICAS DO SISTEMA ===\n");
            
            // Estatísticas de Produtos
            writer.write("\n--- PRODUTOS ---\n");
            writer.write("Total de produtos: " + todosProdutos.size() + "\n");
            
            // Estatísticas por Categoria
            writer.write("\nProdutos por categoria:\n");
            writer.write(String.format("Notebooks: %d%n", contarProdutosPorCategoria(todosProdutos, "Notebook")));
            writer.write(String.format("Smartphones: %d%n", contarProdutosPorCategoria(todosProdutos, "iPhone", "Samsung", "Xiaomi", "Motorola")));
            writer.write(String.format("Tablets: %d%n", contarProdutosPorCategoria(todosProdutos, "iPad", "Tab")));
            writer.write(String.format("Smart TVs: %d%n", contarProdutosPorCategoria(todosProdutos, "\"")));
            writer.write(String.format("Fones de Ouvido: %d%n", contarProdutosPorCategoria(todosProdutos, "AirPods", "Sony", "Buds", "JBL")));
            writer.write(String.format("Monitores: %d%n", contarProdutosPorCategoria(todosProdutos, "Dell", "LG", "Samsung", "AOC")));
            writer.write(String.format("Teclados e Mouses: %d%n", contarProdutosPorCategoria(todosProdutos, "Logitech", "Razer", "HyperX")));
            writer.write(String.format("Impressoras: %d%n", contarProdutosPorCategoria(todosProdutos, "HP", "Epson", "Canon", "Brother")));

            // Estatísticas de Preços
            writer.write("\n--- PREÇOS ---\n");
            double precoMedio = calcularPrecoMedio(todosProdutos);
            double precoMinimo = calcularPrecoMinimo(todosProdutos);
            double precoMaximo = calcularPrecoMaximo(todosProdutos);
            writer.write(String.format("Preço médio: R$ %.2f%n", precoMedio));
            writer.write(String.format("Preço mínimo: R$ %.2f%n", precoMinimo));
            writer.write(String.format("Preço máximo: R$ %.2f%n", precoMaximo));

            // Estatísticas do Carrinho
            writer.write("\n--- CARRINHO ---\n");
            List<Produto> produtosCarrinho = carrinho.getProdutos();
            writer.write("Quantidade de itens: " + produtosCarrinho.size() + "\n");
            writer.write(String.format("Valor total: R$ %.2f%n", carrinho.calcularTotal()));

            // Estatísticas do Histórico
            writer.write("\n--- HISTÓRICO ---\n");
            List<Produto> produtosHistorico = historico.getProdutosAnalisados();
            writer.write("Produtos analisados: " + produtosHistorico.size() + "\n");
            
            // Estatísticas de Recomendações
            writer.write("\n--- RECOMENDAÇÕES ---\n");
            List<Produto> produtosRecomendados = recomendacoes.getProdutosRecomendados();
            writer.write("Produtos recomendados: " + produtosRecomendados.size() + "\n");

            System.out.println("Relatório exportado com sucesso para: " + nomeArquivo);
        } catch (IOException e) {
            System.out.println("Erro ao exportar relatório: " + e.getMessage());
        }
    }

    public static void exportarProdutos(List<Produto> produtos) {
        String nomeArquivo = gerarNomeArquivo();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
            writer.write("=== LISTA DE PRODUTOS ===\n\n");
            
            for (Produto produto : produtos) {
                writer.write(String.format("Nome: %s%n", produto.getNome()));
                writer.write(String.format("Descrição: %s%n", produto.getDescricao()));
                writer.write(String.format("Preço: R$ %.2f%n", produto.getPreco()));
                writer.write("-------------------\n");
            }
            
            System.out.println("Lista de produtos exportada com sucesso para: " + nomeArquivo);
        } catch (IOException e) {
            System.out.println("Erro ao exportar produtos: " + e.getMessage());
        }
    }

    public static void exportarCarrinho(Carrinho carrinho) {
        String nomeArquivo = gerarNomeArquivo();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
            writer.write("=== CARRINHO DE COMPRAS ===\n\n");
            
            List<Produto> produtos = carrinho.getProdutos();
            if (produtos.isEmpty()) {
                writer.write("Carrinho vazio.\n");
            } else {
                for (Produto produto : produtos) {
                    writer.write(String.format("Nome: %s%n", produto.getNome()));
                    writer.write(String.format("Descrição: %s%n", produto.getDescricao()));
                    writer.write(String.format("Preço: R$ %.2f%n", produto.getPreco()));
                    writer.write("-------------------\n");
                }
                writer.write(String.format("%nTotal: R$ %.2f%n", carrinho.calcularTotal()));
            }
            
            System.out.println("Carrinho exportado com sucesso para: " + nomeArquivo);
        } catch (IOException e) {
            System.out.println("Erro ao exportar carrinho: " + e.getMessage());
        }
    }

    public static void exportarHistorico(Historico historico) {
        String nomeArquivo = gerarNomeArquivo();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
            writer.write("=== HISTÓRICO DE PRODUTOS ANALISADOS ===\n\n");
            
            List<Produto> produtos = historico.getProdutosAnalisados();
            if (produtos.isEmpty()) {
                writer.write("Nenhum produto analisado ainda.\n");
            } else {
                for (Produto produto : produtos) {
                    writer.write(String.format("Nome: %s%n", produto.getNome()));
                    writer.write(String.format("Descrição: %s%n", produto.getDescricao()));
                    writer.write(String.format("Preço: R$ %.2f%n", produto.getPreco()));
                    writer.write("-------------------\n");
                }
            }
            
            System.out.println("Histórico exportado com sucesso para: " + nomeArquivo);
        } catch (IOException e) {
            System.out.println("Erro ao exportar histórico: " + e.getMessage());
        }
    }

    public static void exportarRecomendacoes(Recomendacoes recomendacoes) {
        String nomeArquivo = gerarNomeArquivo();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
            writer.write("=== PRODUTOS RECOMENDADOS ===\n\n");
            
            List<Produto> produtos = recomendacoes.getProdutosRecomendados();
            if (produtos.isEmpty()) {
                writer.write("Nenhuma recomendação disponível no momento.\n");
            } else {
                for (Produto produto : produtos) {
                    writer.write(String.format("Nome: %s%n", produto.getNome()));
                    writer.write(String.format("Descrição: %s%n", produto.getDescricao()));
                    writer.write(String.format("Preço: R$ %.2f%n", produto.getPreco()));
                    writer.write("-------------------\n");
                }
            }
            
            System.out.println("Recomendações exportadas com sucesso para: " + nomeArquivo);
        } catch (IOException e) {
            System.out.println("Erro ao exportar recomendações: " + e.getMessage());
        }
    }

    private static int contarProdutosPorCategoria(List<Produto> produtos, String... palavrasChave) {
        return (int) produtos.stream()
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
} 