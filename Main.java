import java.util.*;

public class Main {
    private static final Map<UUID, Product> produtos = new HashMap<>();
    private static final Map<UUID, User> usuarios = new HashMap<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;

        do {
            try {
                System.out.println("\n=== MENU ===");
                System.out.println("1. Cadastrar produto");
                System.out.println("2. Cadastrar usuário");
                System.out.println("3. Registrar navegação");
                System.out.println("4. Ver histórico de navegação");
                System.out.println("5. Sair");
                System.out.print("Escolha uma opção: ");
                
                String entrada = scanner.nextLine();
                opcao = Integer.parseInt(entrada);

                switch (opcao) {
                    case 1 -> cadastrarProduto();
                    case 2 -> cadastrarUsuario();
                    case 3 -> registrarNavegacao();
                    case 4 -> verHistorico();
                    case 5 -> System.out.println("Encerrando...");
                    default -> System.out.println("Opção inválida! Digite um número entre 1 e 5.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Erro: Digite um número válido!");
                opcao = 0;
            } catch (Exception e) {
                System.out.println("Ocorreu um erro: " + e.getMessage());
                opcao = 0;
            }
        } while (opcao != 5);
    }

    private static void cadastrarProduto() {
        boolean sucesso = false;
        do {
            try {
                System.out.print("Nome do produto: ");
                String nome = scanner.nextLine();
                if (nome.trim().isEmpty()) {
                    System.out.println("Erro: Nome do produto não pode estar vazio!");
                    continue;
                }

                System.out.print("Categoria: ");
                String categoria = scanner.nextLine();
                if (categoria.trim().isEmpty()) {
                    System.out.println("Erro: Categoria não pode estar vazia!");
                    continue;
                }

                System.out.print("Nota (0.0 a 5.0): ");
                String notaStr = scanner.nextLine().replace(",", ".");
                double nota = Double.parseDouble(notaStr);
                
                if (nota < 0.0 || nota > 5.0) {
                    System.out.println("Erro: A nota deve estar entre 0.0 e 5.0!");
                    continue;
                }

                // Arredonda para 1 casa decimal
                nota = Math.round(nota * 10.0) / 10.0;

                Product produto = new Product(UUID.randomUUID(), nome, categoria, nota);
                produtos.put(produto.getId(), produto);
                System.out.println("Produto cadastrado com sucesso!");
                sucesso = true;
            } catch (NumberFormatException e) {
                System.out.println("Erro: Digite uma nota válida (ex: 4.7)!");
                System.out.println("Deseja tentar novamente? (S/N)");
                if (!scanner.nextLine().equalsIgnoreCase("S")) {
                    return;
                }
            } catch (Exception e) {
                System.out.println("Erro ao cadastrar produto: " + e.getMessage());
                System.out.println("Deseja tentar novamente? (S/N)");
                if (!scanner.nextLine().equalsIgnoreCase("S")) {
                    return;
                }
            }
        } while (!sucesso);
    }

    private static void cadastrarUsuario() {
        boolean sucesso = false;
        do {
            try {
                System.out.print("Nome do usuário: ");
                String nome = scanner.nextLine();
                
                if (nome.trim().isEmpty()) {
                    System.out.println("Erro: Nome do usuário não pode estar vazio!");
                    continue;
                }

                User usuario = new User(UUID.randomUUID(), nome, new ArrayList<>());
                usuarios.put(usuario.getId(), usuario);
                System.out.println("Usuário cadastrado com sucesso!");
                sucesso = true;
            } catch (Exception e) {
                System.out.println("Erro ao cadastrar usuário: " + e.getMessage());
                System.out.println("Deseja tentar novamente? (S/N)");
                if (!scanner.nextLine().equalsIgnoreCase("S")) {
                    return;
                }
            }
        } while (!sucesso);
    }

    private static void registrarNavegacao() {
        if (usuarios.isEmpty() || produtos.isEmpty()) {
            System.out.println("Cadastre ao menos um usuário e um produto antes!");
            return;
        }

        boolean sucesso = false;
        do {
            try {
                User usuario = selecionarUsuario();
                if (usuario == null) {
                    System.out.println("Deseja tentar novamente? (S/N)");
                    if (!scanner.nextLine().equalsIgnoreCase("S")) {
                        return;
                    }
                    continue;
                }

                Product produto = selecionarProduto();
                if (produto == null) {
                    System.out.println("Deseja tentar novamente? (S/N)");
                    if (!scanner.nextLine().equalsIgnoreCase("S")) {
                        return;
                    }
                    continue;
                }

                NavigationEvent evento = new NavigationEvent(
                    UUID.randomUUID(),
                    usuario.getId(),
                    produto.getId(),
                    new Date()
                );

                usuario.getNavigationHistory().add(evento);
                System.out.println("Navegação registrada com sucesso!");
                sucesso = true;
            } catch (Exception e) {
                System.out.println("Erro ao registrar navegação: " + e.getMessage());
                System.out.println("Deseja tentar novamente? (S/N)");
                if (!scanner.nextLine().equalsIgnoreCase("S")) {
                    return;
                }
            }
        } while (!sucesso);
    }

    private static void verHistorico() {
        if (usuarios.isEmpty()) {
            System.out.println("Nenhum usuário cadastrado.");
            return;
        }

        boolean sucesso = false;
        do {
            try {
                User usuario = selecionarUsuario();
                if (usuario == null) {
                    System.out.println("Deseja tentar novamente? (S/N)");
                    if (!scanner.nextLine().equalsIgnoreCase("S")) {
                        return;
                    }
                    continue;
                }

                System.out.println("Histórico de navegação de " + usuario.getNome() + ":");
                if (usuario.getNavigationHistory().isEmpty()) {
                    System.out.println("Nenhum histórico de navegação encontrado.");
                    return;
                }

                for (NavigationEvent evento : usuario.getNavigationHistory()) {
                    Product produto = produtos.get(evento.getProductId());
                    String nomeProduto = (produto != null) ? produto.getNome() : "Produto não encontrado";
                    System.out.println(" - " + nomeProduto + " em " + evento.getAccessDate());
                }
                sucesso = true;
            } catch (Exception e) {
                System.out.println("Erro ao ver histórico: " + e.getMessage());
                System.out.println("Deseja tentar novamente? (S/N)");
                if (!scanner.nextLine().equalsIgnoreCase("S")) {
                    return;
                }
            }
        } while (!sucesso);
    }

    private static User selecionarUsuario() {
        try {
            System.out.println("Usuários:");
            int i = 1;
            List<User> lista = new ArrayList<>(usuarios.values());
            
            if (lista.isEmpty()) {
                System.out.println("Nenhum usuário cadastrado.");
                return null;
            }

            for (User u : lista) {
                System.out.println(i + ". " + u.getNome());
                i++;
            }

            System.out.print("Escolha o número do usuário: ");
            String escolhaStr = scanner.nextLine();
            int escolha = Integer.parseInt(escolhaStr);

            if (escolha < 1 || escolha > lista.size()) {
                System.out.println("Erro: Escolha inválida!");
                return null;
            }

            return lista.get(escolha - 1);
        } catch (NumberFormatException e) {
            System.out.println("Erro: Digite um número válido!");
            return null;
        } catch (Exception e) {
            System.out.println("Erro ao selecionar usuário: " + e.getMessage());
            return null;
        }
    }

    private static Product selecionarProduto() {
        try {
            System.out.println("Produtos:");
            int i = 1;
            List<Product> lista = new ArrayList<>(produtos.values());
            
            if (lista.isEmpty()) {
                System.out.println("Nenhum produto cadastrado.");
                return null;
            }

            for (Product p : lista) {
                System.out.println(i + ". " + p.getNome() + " (" + p.getCategory() + ")");
                i++;
            }

            System.out.print("Escolha o número do produto: ");
            String escolhaStr = scanner.nextLine();
            int escolha = Integer.parseInt(escolhaStr);

            if (escolha < 1 || escolha > lista.size()) {
                System.out.println("Erro: Escolha inválida!");
                return null;
            }

            return lista.get(escolha - 1);
        } catch (NumberFormatException e) {
            System.out.println("Erro: Digite um número válido!");
            return null;
        } catch (Exception e) {
            System.out.println("Erro ao selecionar produto: " + e.getMessage());
            return null;
        }
    }
}
