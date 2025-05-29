# Sistema de Navegação de Produtos

Este é um sistema Java que permite gerenciar produtos, usuários e registrar navegações entre eles.

## Funcionalidades

- Cadastro de produtos com nome, categoria e nota
- Cadastro de usuários
- Registro de navegações (quando um usuário acessa um produto)
- Visualização do histórico de navegação por usuário

## Como Executar

1. Certifique-se de ter o Java instalado
2. Compile os arquivos:
   ```
   javac *.java
   ```
3. Execute o programa:
   ```
   java Main
   ```

## Estrutura do Projeto

- `Main.java`: Classe principal com o menu interativo
- `Product.java`: Classe que representa um produto
- `User.java`: Classe que representa um usuário
- `NavigationEvent.java`: Classe que representa um evento de navegação

## Características

- Interface de linha de comando interativa
- Tratamento de erros robusto
- Possibilidade de tentar novamente em caso de erro
- Suporte a notas decimais (ex: 4.7)
- Validação de dados de entrada 