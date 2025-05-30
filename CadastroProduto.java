import java.util.Scanner;

public class CadastroProduto {
    private final ProdutosPrincipais produtosPrincipais;

    public CadastroProduto(ProdutosPrincipais produtosPrincipais) {
        this.produtosPrincipais = produtosPrincipais;
    }

    public void cadastrarNovoProduto() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Digite o nome do novo produto:");
            String nomeProduto = scanner.nextLine();
            System.out.println("Digite a descrição do produto:");
            String descricao = scanner.nextLine();
            System.out.println("Digite o preço do produto:");
            double preco = scanner.nextDouble();
            produtosPrincipais.adicionarProduto(nomeProduto, descricao, preco);
            System.out.println("Produto cadastrado com sucesso!");
        }
    }
} 