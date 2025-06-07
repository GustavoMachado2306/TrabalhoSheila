// Dados iniciais
const produtosPrincipais = [
    // Notebooks
    { id: 'NB001',nome: "Notebook Dell Inspiron", descricao: "Notebook Dell Inspiron i5 8GB 256GB SSD",preco: 3500.00,imagem: "https://images.unsplash.com/photo-1517336714731-489689fd1ca8?auto=format&fit=crop&w=600&q=80" },
    { id: 'NB002', nome: "Notebook Lenovo ThinkPad", descricao: "Notebook Lenovo ThinkPad i7 16GB 512GB SSD", preco: 4500.00, imagem: "https://images.unsplash.com/photo-1496181133206-80ce9b88a853?q=80&w=2071&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D" },
    { id: 'NB003', nome: "Notebook MacBook Pro", descricao: "MacBook Pro M2 16GB, 512GB SSD", preco: 12000.00, imagem: "https://images.unsplash.com/photo-1498050108023-c5249f4df085?w=600&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8Y29tcHV0YURvciUyMHBlY3NvYWx8ZW58MHx8MHx8fDA%3D" },
    { id: 'NB004', nome: "Notebook HP", descricao: "HP Pavilion i5 8GB, 512GB SSD", preco: 3800.00, imagem: "https://images.unsplash.com/photo-1537498425277-c283d32ef9db?w=600&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTJ8fGNvbXB1dGFkb3J8ZW58MHx8MHx8fDA%3D" },
    { id: 'NB005', nome: "Notebook Asus ROG", descricao: "Asus ROG Strix G15, RTX 3060, 16GB RAM", preco: 8500.00, imagem: "https://plus.unsplash.com/premium_photo-1670274606895-f2dc713f8a90?w=600&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mjd8fGNvbXB1dGFkb3J8ZW58MHx8MHx8fDA%3D" },
    { id: 'NB006', nome: "Notebook Acer Nitro", descricao: "Acer Nitro 5, GTX 1650, 8GB RAM", preco: 4200.00, imagem: "https://plus.unsplash.com/premium_photo-1681666713641-8d722b681edc?w=600&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mzl8fGNvbXB1dGFkb3J8ZW58MHx8MHx8fDA%3D" },
    { id: 'NB007', nome: "Notebook Samsung Book", descricao: "Samsung Book Pro 360, 13.3\", 8GB RAM", preco: 5500.00, imagem: "https://images.unsplash.com/photo-1517694712202-14dd9538aa97?auto=format&fit=crop&w=600&q=80" },
    { id: 'NB008', nome: "Notebook Microsoft Surface", descricao: "Microsoft Surface Laptop 4, 13.5\", 8GB RAM", preco: 7800.00, imagem: "https://plus.unsplash.com/premium_photo-1681302427948-2fd0eca629b1?q=80&w=1935&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D" },

    // Smartphones
    { id: 'SP001', nome: "iPhone 13", descricao: "iPhone 13 128GB Preto", preco: 5500.00, imagem: "https://images.unsplash.com/photo-1511707171634-5f897ff02aa9?auto=format&fit=crop&w=600&q=80" },
    { id: 'SP002', nome: "Samsung Galaxy S21", descricao: "Samsung Galaxy S21 128GB Cinza", preco: 4800.00, imagem: "https://images.unsplash.com/photo-1512499617640-c2f999098c01?auto=format&fit=crop&w=600&q=80" },
    { id: 'SP003', nome: "Xiaomi 12", descricao: "Xiaomi 12 256GB", preco: 3500.00, imagem: "https://images.unsplash.com/photo-1510557880182-3c5a911cb3b7?auto=format&fit=crop&w=600&q=80" },
    { id: 'SP004', nome: "Motorola Edge", descricao: "Motorola Edge 30 128GB", preco: 2800.00, imagem: "https://images.unsplash.com/photo-1517336714731-489689fd1ca8?auto=format&fit=crop&w=600&q=80" },
    { id: 'SP005', nome: "iPhone 14 Pro", descricao: "iPhone 14 Pro 256GB", preco: 8500.00, imagem: "https://images.unsplash.com/photo-1519125323398-675f0ddb6308?auto=format&fit=crop&w=600&q=80" },
    { id: 'SP006', nome: "Samsung S23", descricao: "Samsung Galaxy S23 Ultra 256GB", preco: 7500.00, imagem: "https://images.unsplash.com/photo-1512499617640-c2f999098c01?auto=format&fit=crop&w=600&q=80" },
    { id: 'SP007', nome: "Google Pixel 7", descricao: "Google Pixel 7 Pro 128GB", preco: 5200.00, imagem: "https://images.unsplash.com/photo-1510557880182-3c5a911cb3b7?auto=format&fit=crop&w=600&q=80" },
    { id: 'SP008', nome: "OnePlus 11", descricao: "OnePlus 11 256GB", preco: 4500.00, imagem: "https://images.unsplash.com/photo-1511707171634-5f897ff02aa9?auto=format&fit=crop&w=600&q=80" },

    // Tablets
    { id: 'TB001', nome: "iPad Pro", descricao: "iPad Pro 12.9 256GB Wi-Fi", preco: 8000.00, imagem: "https://images.unsplash.com/photo-1515378791036-0648a3ef77b2?auto=format&fit=crop&w=600&q=80" },
    { id: 'TB002', nome: "Samsung Galaxy Tab S8", descricao: "Samsung Galaxy Tab S8 128GB Wi-Fi", preco: 4500.00, imagem: "https://images.unsplash.com/photo-1465101178521-c1a9136a3b99?auto=format&fit=crop&w=600&q=80" },
    { id: 'TB003', nome: "iPad Air", descricao: "iPad Air 64GB", preco: 5000.00, imagem: "https://images.unsplash.com/photo-1465101046530-73398c7f28ca?auto=format&fit=crop&w=600&q=80" },
    { id: 'TB004', nome: "Lenovo Tab", descricao: "Lenovo Tab P11 Pro 128GB", preco: 3000.00, imagem: "https://images.unsplash.com/photo-1519389950473-47ba0277781c?auto=format&fit=crop&w=600&q=80" },
    { id: 'TB005', nome: "iPad Mini", descricao: "iPad Mini 6 64GB", preco: 4200.00, imagem: "https://images.unsplash.com/photo-1517694712202-14dd9538aa97?auto=format&fit=crop&w=600&q=80" },
    { id: 'TB006', nome: "Samsung Tab S9", descricao: "Samsung Galaxy Tab S9+ 256GB", preco: 6500.00, imagem: "https://images.unsplash.com/photo-1515378791036-0648a3ef77b2?auto=format&fit=crop&w=600&q=80" },
    { id: 'TB007', nome: "Microsoft Surface Pro", descricao: "Microsoft Surface Pro 9 128GB", preco: 7800.00, imagem: "https://images.unsplash.com/photo-1465101178521-c1a9136a3b99?auto=format&fit=crop&w=600&q=80" },
    { id: 'TB008', nome: "Xiaomi Pad 6", descricao: "Xiaomi Pad 6 Pro 256GB", preco: 3500.00, imagem: "https://images.unsplash.com/photo-1519389950473-47ba0277781c?auto=format&fit=crop&w=600&q=80" },

    // Smart TVs
    { id: 'TV001', nome: "Samsung 55\"", descricao: "Samsung 55\" 4K Smart TV", preco: 3500.00, imagem: "https://images.unsplash.com/photo-1465101046530-73398c7f28ca?auto=format&fit=crop&w=600&q=80" },
    { id: 'TV002', nome: "LG 65\"", descricao: "LG 65\" 4K Smart TV", preco: 4500.00, imagem: "https://images.unsplash.com/photo-1517694712202-14dd9538aa97?auto=format&fit=crop&w=600&q=80" },
    { id: 'TV003', nome: "Philips 50\"", descricao: "Philips 50\" 4K Smart TV", preco: 2800.00, imagem: "https://images.unsplash.com/photo-1515378791036-0648a3ef77b2?auto=format&fit=crop&w=600&q=80" },
    { id: 'TV004', nome: "TCL 43\"", descricao: "TCL 43\" 4K Smart TV", preco: 2000.00, imagem: "https://images.unsplash.com/photo-1519389950473-47ba0277781c?auto=format&fit=crop&w=600&q=80" },
    { id: 'TV005', nome: "Samsung 75\"", descricao: "Samsung 75\" QLED 4K Smart TV", preco: 8500.00, imagem: "https://images.unsplash.com/photo-1511707171634-5f897ff02aa9?auto=format&fit=crop&w=600&q=80" },
    { id: 'TV006', nome: "LG 77\"", descricao: "LG 77\" OLED 4K Smart TV", preco: 12000.00, imagem: "https://images.unsplash.com/photo-1512499617640-c2f999098c01?auto=format&fit=crop&w=600&q=80" },
    { id: 'TV007', nome: "Sony 65\"", descricao: "Sony 65\" BRAVIA OLED 4K", preco: 7800.00, imagem: "https://images.unsplash.com/photo-1510557880182-3c5a911cb3b7?auto=format&fit=crop&w=600&q=80" },
    { id: 'TV008', nome: "Philips 65\"", descricao: "Philips 65\" OLED 4K Smart TV", preco: 6500.00, imagem: "https://images.unsplash.com/photo-1519125323398-675f0ddb6308?auto=format&fit=crop&w=600&q=80" },

    // Fones de Ouvido
    { id: 'FO001', nome: "AirPods Pro", descricao: "AirPods Pro com Cancelamento de Ruído", preco: 2000.00, imagem: "https://images.unsplash.com/photo-1511707171634-5f897ff02aa9?auto=format&fit=crop&w=600&q=80" },
    { id: 'FO002', nome: "Sony WH-1000XM4", descricao: "Sony WH-1000XM4 com Cancelamento de Ruído", preco: 2500.00, imagem: "https://images.unsplash.com/photo-1512499617640-c2f999098c01?auto=format&fit=crop&w=600&q=80" },
    { id: 'FO003', nome: "Samsung Buds", descricao: "Samsung Galaxy Buds Pro", preco: 1500.00, imagem: "https://images.unsplash.com/photo-1510557880182-3c5a911cb3b7?auto=format&fit=crop&w=600&q=80" },
    { id: 'FO004', nome: "JBL Tune", descricao: "JBL Tune 750BTNC", preco: 800.00, imagem: "https://images.unsplash.com/photo-1519125323398-675f0ddb6308?auto=format&fit=crop&w=600&q=80" },
    { id: 'FO005', nome: "AirPods Max", descricao: "AirPods Max com Cancelamento de Ruído", preco: 4500.00, imagem: "https://images.unsplash.com/photo-1511707171634-5f897ff02aa9?auto=format&fit=crop&w=600&q=80" },
    { id: 'FO006', nome: "Sony WH-1000XM5", descricao: "Sony WH-1000XM5 com Cancelamento de Ruído", preco: 3200.00, imagem: "https://images.unsplash.com/photo-1512499617640-c2f999098c01?auto=format&fit=crop&w=600&q=80" },
    { id: 'FO007', nome: "Samsung Buds2 Pro", descricao: "Samsung Galaxy Buds2 Pro", preco: 1800.00, imagem: "https://images.unsplash.com/photo-1510557880182-3c5a911cb3b7?auto=format&fit=crop&w=600&q=80" },
    { id: 'FO008', nome: "Bose QC45", descricao: "Bose QuietComfort 45", preco: 2800.00, imagem: "https://images.unsplash.com/photo-1519125323398-675f0ddb6308?auto=format&fit=crop&w=600&q=80" },

    // Monitores
    { id: 'MN001', nome: "Dell 27\"", descricao: "Dell 27\" 4K UHD Monitor", preco: 2500.00, imagem: "https://images.unsplash.com/photo-1519389950473-47ba0277781c?auto=format&fit=crop&w=600&q=80" },
    { id: 'MN002', nome: "LG 32\"", descricao: "LG 32\" UltraWide Monitor", preco: 3000.00, imagem: "https://images.unsplash.com/photo-1517694712202-14dd9538aa97?auto=format&fit=crop&w=600&q=80" },
    { id: 'MN003', nome: "Samsung 24\"", descricao: "Samsung 24\" Full HD", preco: 1200.00, imagem: "https://images.unsplash.com/photo-1515378791036-0648a3ef77b2?auto=format&fit=crop&w=600&q=80" },
    { id: 'MN004', nome: "AOC 27\"", descricao: "AOC 27\" Gaming", preco: 1800.00, imagem: "https://images.unsplash.com/photo-1465101046530-73398c7f28ca?auto=format&fit=crop&w=600&q=80" },
    { id: 'MN005', nome: "Dell 34\"", descricao: "Dell 34\" UltraWide QHD", preco: 4500.00, imagem: "https://images.unsplash.com/photo-1519389950473-47ba0277781c?auto=format&fit=crop&w=600&q=80" },
    { id: 'MN006', nome: "LG 38\"", descricao: "LG 38\" UltraWide QHD+", preco: 5800.00, imagem: "https://images.unsplash.com/photo-1517694712202-14dd9538aa97?auto=format&fit=crop&w=600&q=80" },
    { id: 'MN007', nome: "Samsung 32\"", descricao: "Samsung 32\" Odyssey G7 QHD", preco: 3500.00, imagem: "https://images.unsplash.com/photo-1515378791036-0648a3ef77b2?auto=format&fit=crop&w=600&q=80" },
    { id: 'MN008', nome: "Asus 27\"", descricao: "Asus 27\" ROG Swift QHD", preco: 4200.00, imagem: "https://images.unsplash.com/photo-1465101046530-73398c7f28ca?auto=format&fit=crop&w=600&q=80" },

    // Teclados e Mouses
    { id: 'TM001', nome: "Logitech MX Keys", descricao: "Logitech MX Keys Teclado Sem Fio", preco: 800.00, imagem: "https://images.unsplash.com/photo-1511707171634-5f897ff02aa9?auto=format&fit=crop&w=600&q=80" },
    { id: 'TM002', nome: "Razer BlackWidow", descricao: "Razer BlackWidow V3 Teclado Mecânico", preco: 1200.00, imagem: "https://images.unsplash.com/photo-1512499617640-c2f999098c01?auto=format&fit=crop&w=600&q=80" },
    { id: 'TM003', nome: "Logitech G Pro", descricao: "Logitech G Pro Mouse", preco: 600.00, imagem: "https://images.unsplash.com/photo-1510557880182-3c5a911cb3b7?auto=format&fit=crop&w=600&q=80" },
    { id: 'TM004', nome: "HyperX Alloy", descricao: "HyperX Alloy Origins", preco: 900.00, imagem: "https://images.unsplash.com/photo-1519125323398-675f0ddb6308?auto=format&fit=crop&w=600&q=80" },
    { id: 'TM005', nome: "Logitech MX Master", descricao: "Logitech MX Master 3S", preco: 850.00, imagem: "https://images.unsplash.com/photo-1511707171634-5f897ff02aa9?auto=format&fit=crop&w=600&q=80" },
    { id: 'TM006', nome: "Razer DeathAdder", descricao: "Razer DeathAdder V2 Pro", preco: 750.00, imagem: "https://images.unsplash.com/photo-1512499617640-c2f999098c01?auto=format&fit=crop&w=600&q=80" },
    { id: 'TM007', nome: "Corsair K95", descricao: "Corsair K95 RGB Platinum", preco: 1100.00, imagem: "https://images.unsplash.com/photo-1510557880182-3c5a911cb3b7?auto=format&fit=crop&w=600&q=80" },
    { id: 'TM008', nome: "SteelSeries Apex", descricao: "SteelSeries Apex Pro", preco: 1300.00, imagem: "https://images.unsplash.com/photo-1519125323398-675f0ddb6308?auto=format&fit=crop&w=600&q=80" },

    // Impressoras
    { id: 'IM001', nome: "HP LaserJet", descricao: "HP LaserJet Pro M404 Impressora", preco: 1500.00, imagem: "https://images.unsplash.com/photo-1519389950473-47ba0277781c?auto=format&fit=crop&w=600&q=80" },
    { id: 'IM002', nome: "Epson EcoTank", descricao: "Epson EcoTank L3250 Impressora", preco: 1200.00, imagem: "https://images.unsplash.com/photo-1517694712202-14dd9538aa97?auto=format&fit=crop&w=600&q=80" },
    { id: 'IM003', nome: "Canon PIXMA", descricao: "Canon PIXMA TS3350", preco: 800.00, imagem: "https://images.unsplash.com/photo-1515378791036-0648a3ef77b2?auto=format&fit=crop&w=600&q=80" },
    { id: 'IM004', nome: "Brother DCP", descricao: "Brother DCP-L2530DW", preco: 1300.00, imagem: "https://images.unsplash.com/photo-1465101046530-73398c7f28ca?auto=format&fit=crop&w=600&q=80" },
    { id: 'IM005', nome: "HP OfficeJet", descricao: "HP OfficeJet Pro 9015", preco: 1800.00, imagem: "https://images.unsplash.com/photo-1519389950473-47ba0277781c?auto=format&fit=crop&w=600&q=80" },
    { id: 'IM006', nome: "Epson WorkForce", descricao: "Epson WorkForce Pro WF-3720", preco: 950.00, imagem: "https://images.unsplash.com/photo-1517694712202-14dd9538aa97?auto=format&fit=crop&w=600&q=80" },
    { id: 'IM007', nome: "Canon MAXIFY", descricao: "Canon MAXIFY GX4020", preco: 1100.00, imagem: "https://images.unsplash.com/photo-1515378791036-0648a3ef77b2?auto=format&fit=crop&w=600&q=80" },
    { id: 'IM008', nome: "Brother MFC", descricao: "Brother MFC-L8900CDW", preco: 2500.00, imagem: "https://images.unsplash.com/photo-1465101046530-73398c7f28ca?auto=format&fit=crop&w=600&q=80" }
];

let carrinho = [];
let historico = [];
let produtosAnalisadosRecomendacoes = new Set();

// Sistema de recomendações
const sistemaRecomendacoes = {
    categorias: {
        'NOTEBOOKS': p => p.id.startsWith('NB'),
        'SMARTPHONES': p => p.id.startsWith('SP'),
        'TABLETS': p => p.id.startsWith('TB'),
        'SMART TVs': p => p.id.startsWith('TV'),
        'FONES DE OUVIDO': p => p.id.startsWith('FO'),
        'MONITORES': p => p.id.startsWith('MN'),
        'TECLADOS E MOUSES': p => p.id.startsWith('TM'),
        'IMPRESSORAS': p => p.id.startsWith('IM')
    },

    encontrarCategoria(produto) {
        for (const [categoria, filtro] of Object.entries(this.categorias)) {
            if (filtro(produto)) {
                return categoria;
            }
        }
        return null;
    },

    encontrarCategoriasVisualizadas(historico) {
        const categoriasVisualizadas = new Set();
        historico.forEach(produto => {
            const categoria = this.encontrarCategoria(produto);
            if (categoria) {
                categoriasVisualizadas.add(categoria);
            }
        });
        return categoriasVisualizadas;
    },

    gerarRecomendacoes(produtosPrincipais, historico, carrinho) {
        // Usa apenas o histórico e carrinho para determinar produtos vistos
        const produtosVistos = new Set([...historico, ...carrinho].map(p => p.id));
        
        // Encontra categorias apenas do histórico (não inclui produtos analisados nas recomendações)
        const categoriasVisualizadas = new Set();
        historico.forEach(produto => {
            const categoria = this.encontrarCategoria(produto);
            if (categoria) {
                categoriasVisualizadas.add(categoria);
            }
        });

        if (categoriasVisualizadas.size === 0) {
            return [];
        }

        // Ordena as categorias por ordem de visualização (mais recentes primeiro)
        const categoriasOrdenadas = Array.from(categoriasVisualizadas)
            .reverse()
            .slice(0, 5);

        let recomendacoes = [];
        for (const categoria of categoriasOrdenadas) {
            // Filtra produtos da categoria que não foram vistos e não foram analisados nas recomendações
            const produtosDisponiveis = produtosPrincipais
                .filter(produto => 
                    this.categorias[categoria](produto) && 
                    !produtosVistos.has(produto.id) &&
                    !produtosAnalisadosRecomendacoes.has(produto.id)
                )
                .map(produto => ({
                    ...produto,
                    categoria: categoria,
                    preco: produto.preco, // <-- mantém o preço original
                    relevancia: this.calcularRelevancia(produto, historico)
                }))
                .sort((a, b) => b.relevancia - a.relevancia);

            // Adiciona apenas os produtos disponíveis, sem preencher
            recomendacoes.push(...produtosDisponiveis);
        }

        return recomendacoes;
    },

    calcularRelevancia(produto, historico) {
        let relevancia = 0;
        
        // Produtos da mesma marca têm maior relevância
        const marcaProduto = this.extrairMarca(produto.nome);
        historico.forEach(item => {
            if (this.extrairMarca(item.nome) === marcaProduto) {
                relevancia += 2;
            }
        });

        // Produtos com preço similar têm maior relevância
        const precoMedio = this.calcularPrecoMedio(historico);
        const diferencaPreco = Math.abs(produto.preco - precoMedio);
        if (diferencaPreco < 1000) relevancia += 1;
        if (diferencaPreco < 500) relevancia += 1;

        // Produtos da mesma categoria têm maior relevância
        const categoriaProduto = this.encontrarCategoria(produto);
        historico.forEach(item => {
            if (this.encontrarCategoria(item) === categoriaProduto) {
                relevancia += 1;
            }
        });

        return relevancia;
    },

    extrairMarca(nome) {
        const marcas = ['Dell', 'MacBook', 'Lenovo', 'HP', 'iPhone', 'Samsung', 'Xiaomi', 'Motorola', 
                       'iPad', 'LG', 'Philips', 'TCL', 'AirPods', 'Sony', 'JBL', 'AOC', 
                       'Logitech', 'Razer', 'HyperX', 'Epson', 'Canon', 'Brother'];
        
        for (const marca of marcas) {
            if (nome.includes(marca)) {
                return marca;
            }
        }
        return '';
    },

    calcularPrecoMedio(historico) {
        if (historico.length === 0) return 0;
        const soma = historico.reduce((acc, item) => acc + item.preco, 0);
        return soma / historico.length;
    },

    agruparPorCategoria(recomendacoes) {
        const recomendacoesPorCategoria = {};
        recomendacoes.forEach(produto => {
            if (!recomendacoesPorCategoria[produto.categoria]) {
                recomendacoesPorCategoria[produto.categoria] = [];
            }
            recomendacoesPorCategoria[produto.categoria].push(produto);
        });
        return recomendacoesPorCategoria;
    }
};

// Navegação
function mostrarSecao(secao) {
    // Esconde todas as seções
    document.querySelectorAll('main section').forEach(s => {
        s.style.display = 'none';
    });
    
    // Mostra a seção selecionada
    document.getElementById(secao).style.display = 'block';
    
    // Atualiza o conteúdo da seção
    switch(secao) {
        case 'produtos':
            atualizarProdutos();
            break;
        case 'carrinho':
            atualizarCarrinho();
            break;
        case 'historico':
            atualizarHistorico();
            break;
        case 'recomendacoes':
            atualizarRecomendacoes();
            break;
        case 'estatisticas':
            atualizarEstatisticas();
            break;
        case 'cadastro':
            limparFormulario();
            break;
    }
}

// Funções de atualização
function atualizarProdutos() {
    const produtosContainer = document.getElementById('produtos-container');
    produtosContainer.innerHTML = '';

    // Agrupar produtos por categoria
    const categorias = {
        'NOTEBOOKS': produtosPrincipais.filter(p => p.id.startsWith('NB')),
        'SMARTPHONES': produtosPrincipais.filter(p => p.id.startsWith('SP')),
        'TABLETS': produtosPrincipais.filter(p => p.id.startsWith('TB')),
        'SMART TVs': produtosPrincipais.filter(p => p.id.startsWith('TV')),
        'FONES DE OUVIDO': produtosPrincipais.filter(p => p.id.startsWith('FO')),
        'MONITORES': produtosPrincipais.filter(p => p.id.startsWith('MN')),
        'TECLADOS E MOUSES': produtosPrincipais.filter(p => p.id.startsWith('TM')),
        'IMPRESSORAS': produtosPrincipais.filter(p => p.id.startsWith('IM'))
    };

    // Criar seções para cada categoria
    for (const [categoria, produtos] of Object.entries(categorias)) {
        if (produtos.length > 0) {
            const categoriaSection = document.createElement('div');
            categoriaSection.className = 'categoria-section';
            
            const categoriaTitulo = document.createElement('h2');
            categoriaTitulo.textContent = categoria;
            categoriaSection.appendChild(categoriaTitulo);

            const produtosGrid = document.createElement('div');
            produtosGrid.className = 'produtos-grid';

            produtos.forEach(produto => {
                const produtoCard = document.createElement('div');
                produtoCard.className = 'produto-card';
                produtoCard.onclick = () => analisarProduto(produto.id);
                produtoCard.innerHTML = `
                    <img src="${produto.imagem || 'https://via.placeholder.com/150'}" alt="${produto.nome}" class="produto-imagem">
                    <h3>${produto.nome}</h3>
                    <p>${produto.descricao}</p>
                    <p class="preco">R$ ${produto.preco.toFixed(2)}</p>
                `;
                produtosGrid.appendChild(produtoCard);
            });

            categoriaSection.appendChild(produtosGrid);
            produtosContainer.appendChild(categoriaSection);
        }
    }
}

function atualizarCarrinho() {
    const container = document.getElementById('carrinho-container');
    const totalDiv = document.getElementById('carrinho-total');
    const totalValorDiv = document.getElementById('carrinho-total-valor');

    if (!container || !totalDiv || !totalValorDiv) return;

    if (carrinho.length === 0) {
        container.innerHTML = '<p style="text-align:center;color:#888;">Seu carrinho está vazio.</p>';
        totalDiv.textContent = 'Total: R$ 0,00';
        totalValorDiv.textContent = '';
        return;
    }

    container.innerHTML = carrinho.map(item => `
        <div class="carrinho-item melhorado">
            <img src="${item.imagem || 'https://via.placeholder.com/80'}" alt="${item.nome}" class="carrinho-imagem">
            <div class="carrinho-info">
                <h3>${item.nome}</h3>
                <p>${item.descricao}</p>
                <p class="preco">R$ ${item.preco.toFixed(2)}</p>
            </div>
            <button class="btn-remover" onclick="removerDoCarrinho('${item.id}')">Remover</button>
        </div>
    `).join('');

    const total = carrinho.reduce((sum, item) => sum + item.preco, 0);
    totalDiv.textContent = `Total: R$ ${total.toFixed(2)}`;
    totalValorDiv.textContent = `R$ ${total.toFixed(2)}`;
}

function atualizarHistorico() {
    const container = document.getElementById('historico-container');
    if (historico.length === 0) {
        container.innerHTML = '<p>Nenhum produto no histórico.</p>';
        return;
    }

    container.innerHTML = historico.map(item => `
        <div class="historico-item">
            <div>
                <h3>${item.nome}</h3>
                <p>${item.descricao}</p>
                <p class="horario">Analisado em: ${item.horarioAnalise}</p>
            </div>
            <p class="preco">R$ ${item.preco.toFixed(2)}</p>
        </div>
    `).join('');
}

function atualizarRecomendacoes() {
    const container = document.getElementById('recomendacoes-container');
    const recomendacoes = gerarRecomendacoes();
    
    if (recomendacoes.length === 0) {
        container.innerHTML = `
            <div class="recomendacoes-info">
                <p>Nenhuma recomendação disponível no momento.</p>
                <p>Analise alguns produtos para receber recomendações personalizadas!</p>
            </div>`;
        return;
    }

    const recomendacoesPorCategoria = sistemaRecomendacoes.agruparPorCategoria(recomendacoes);

    let html = `
        <div class="recomendacoes-info">
            <h3>Recomendações Personalizadas</h3>
            <p>Baseado nos produtos que você analisou, selecionamos as melhores opções para você:</p>
            <p class="recomendacoes-subinfo">Mostrando produtos disponíveis das categorias que você analisou.</p>
        </div>`;

    for (const [categoria, produtos] of Object.entries(recomendacoesPorCategoria)) {
        html += `
            <div class="categoria-section">
                <div class="categoria-header">
                    <h2>${categoria}</h2>
                    <span class="produtos-count">${produtos.length} produtos</span>
                </div>
                <div class="produtos-grid">
                    ${produtos.map(produto => `
                        <div class="produto-card" onclick="analisarProdutoRecomendado('${produto.id}')">
                            <img src="${produto.imagem || 'https://via.placeholder.com/150'}" alt="${produto.nome}" class="produto-imagem" style="height: 200px; object-fit: cover; border-radius: 8px 8px 0 0; margin-bottom: 8px;">
                            <div class="produto-header">
                                <h3>${produto.nome}</h3>
                                <span class="marca">${sistemaRecomendacoes.extrairMarca(produto.nome)}</span>
                            </div>
                            <p>${produto.descricao}</p>
                            <p class="preco">R$ ${produto.preco.toFixed(2)}</p>
                        </div>
                    `).join('')}
                </div>
            </div>`;
    }

    container.innerHTML = html;
}

function analisarProdutoRecomendado(id) {
    const produto = produtosPrincipais.find(p => p.id === id);
    if (produto) {
        produtosAnalisadosRecomendacoes.add(produto.id);
        // Adiciona ao histórico se ainda não estiver lá
        if (!historico.some(item => item.id === produto.id)) {
            const dataHora = new Date();
            const horarioFormatado = dataHora.toLocaleString('pt-BR', {
                day: '2-digit',
                month: '2-digit',
                year: 'numeric',
                hour: '2-digit',
                minute: '2-digit'
            });
            historico.unshift({
                ...produto,
                horarioAnalise: horarioFormatado
            });
            atualizarHistorico();
        }
        // Mostra detalhes do produto, agora com imagem grande e botão de excluir
        const detalhes = `
            <div class="produto-detalhes">
                <div class="produto-id">ID: ${produto.id}</div>
                <img src="${produto.imagem || 'https://via.placeholder.com/300'}" alt="${produto.nome}" class="produto-imagem" style="margin-bottom:16px;max-width:100%;height:340px;object-fit:cover;border-radius:12px;">
                <h2>${produto.nome}</h2>
                <p class="descricao">${produto.descricao}</p>
                <p class="preco">R$ ${produto.preco.toFixed(2)}</p>
                <div class="acoes">
                    <button onclick="adicionarAoCarrinho('${produto.id}')">Adicionar ao Carrinho</button>
                    <button onclick="excluirProduto('${produto.id}')" class="btn-excluir">Excluir</button>
                    <button onclick="voltarParaRecomendacoes()">Voltar</button>
                </div>
            </div>
        `;
        document.getElementById('recomendacoes-container').innerHTML = detalhes;
    }
}

function voltarParaRecomendacoes() {
    atualizarRecomendacoes();
}

// Funções de manipulação
function adicionarAoCarrinho(id) {
    const produto = produtosPrincipais.find(p => p.id === id);
    if (produto) {
        carrinho.push(produto);
        atualizarCarrinho();
        atualizarEstatisticas();
        mostrarToast('Produto adicionado ao carrinho!');
        // Remova o setTimeout e o voltarParaProdutos();
    }
}

function removerDoCarrinho(id) {
    carrinho = carrinho.filter(item => item.id !== id);
    atualizarCarrinho();
    mostrarToast('Produto removido do carrinho!');
}

function gerarRecomendacoes() {
    return sistemaRecomendacoes.gerarRecomendacoes(produtosPrincipais, historico, carrinho);
}

// Função para analisar produto
function analisarProduto(id) {
    const produto = produtosPrincipais.find(p => p.id === id);
    if (produto) {
        // Esconde todas as seções
        document.querySelectorAll('main section').forEach(s => {
            s.style.display = 'none';
        });
        // Mostra só o container de produtos
        document.getElementById('produtos').style.display = 'block';

        // Adiciona ao histórico se ainda não estiver lá
        if (!historico.some(item => item.id === produto.id)) {
            const dataHora = new Date();
            const horarioFormatado = dataHora.toLocaleString('pt-BR', {
                day: '2-digit',
                month: '2-digit',
                year: 'numeric',
                hour: '2-digit',
                minute: '2-digit'
            });

            historico.unshift({
                ...produto,
                horarioAnalise: horarioFormatado
            });
            atualizarHistorico();
            atualizarEstatisticas();
        }

        // Mostra detalhes do produto
        const detalhes = `
            <div class="produto-detalhes">
                <div class="produto-id">ID: ${produto.id}</div>
                <img src="${produto.imagem || 'https://via.placeholder.com/300'}" alt="${produto.nome}" class="produto-imagem" style="margin-bottom:16px;max-width:100%;height:400px;object-fit:cover;border-radius:12px;">
                <h2>${produto.nome}</h2>
                <p class="descricao">${produto.descricao}</p>
                <p class="preco">R$ ${produto.preco.toFixed(2)}</p>
                <div class="acoes">
                    <button onclick="adicionarAoCarrinho('${produto.id}')">Adicionar ao Carrinho</button>
                    <button onclick="excluirProduto('${produto.id}')" class="btn-excluir">Excluir</button>
                    <button onclick="voltarParaProdutos()">Voltar</button>
                </div>
            </div>
        `;
        document.getElementById('produtos-container').innerHTML = detalhes;
    }
}

// Função para voltar à lista de produtos
function voltarParaProdutos() {
    // Esconde todas as seções
    document.querySelectorAll('main section').forEach(s => {
        s.style.display = 'none';
    });
    // Mostra só a seção de produtos
    document.getElementById('produtos').style.display = 'block';
    atualizarProdutos();
}

// Adicionar função de excluir produto
function excluirProduto(id) {
    const produto = produtosPrincipais.find(p => p.id === id);
    if (produto) {
        if (confirm(`Tem certeza que deseja excluir o produto "${produto.nome}"?`)) {
            // Remove o produto da lista
            const index = produtosPrincipais.findIndex(p => p.id === id);
            if (index !== -1) {
                produtosPrincipais.splice(index, 1);
                // Remove do carrinho se estiver lá
                carrinho = carrinho.filter(item => item.id !== id);
                // Remove do histórico se estiver lá
                historico = historico.filter(item => item.id !== id);
                // Remove das recomendações se estiver lá
                produtosAnalisadosRecomendacoes.delete(id);
                
                // Atualiza a interface
                atualizarProdutos();
                atualizarCarrinho();
                atualizarHistorico();
                atualizarRecomendacoes();
                
                alert('Produto excluído com sucesso!');
            }
        }
    }
}

function atualizarEstatisticas() {
    // Produtos por categoria
    const estatisticasProdutos = document.getElementById('estatisticas-produtos');
    if (estatisticasProdutos) {
        const categorias = {
            'Notebooks': produtosPrincipais.filter(p => p.id.startsWith('NB')).length,
            'Smartphones': produtosPrincipais.filter(p => p.id.startsWith('SP')).length,
            'Tablets': produtosPrincipais.filter(p => p.id.startsWith('TB')).length,
            'Smart TVs': produtosPrincipais.filter(p => p.id.startsWith('TV')).length,
            'Fones de Ouvido': produtosPrincipais.filter(p => p.id.startsWith('FO')).length,
            'Monitores': produtosPrincipais.filter(p => p.id.startsWith('MN')).length,
            'Teclados e Mouses': produtosPrincipais.filter(p => p.id.startsWith('TM')).length,
            'Impressoras': produtosPrincipais.filter(p => p.id.startsWith('IM')).length
        };

        let htmlProdutos = '';
        for (const [categoria, quantidade] of Object.entries(categorias)) {
            htmlProdutos += `
                <div class="estatistica-item">
                    <strong>${categoria}:</strong>
                    <span class="estatistica-valor">${quantidade}</span>
                </div>
            `;
        }
        estatisticasProdutos.innerHTML = htmlProdutos;
    }

    // Preços
    const estatisticasPrecos = document.getElementById('estatisticas-precos');
    if (estatisticasPrecos) {
        const precos = produtosPrincipais.map(p => p.preco);
        const precoMedio = precos.reduce((a, b) => a + b, 0) / precos.length;
        const precoMinimo = Math.min(...precos);
        const precoMaximo = Math.max(...precos);

        estatisticasPrecos.innerHTML = `
            <div class="estatistica-item">
                <strong>Preço Médio:</strong>
                <span class="estatistica-valor">R$ ${precoMedio.toFixed(2)}</span>
            </div>
            <div class="estatistica-item">
                <strong>Preço Mínimo:</strong>
                <span class="estatistica-valor">R$ ${precoMinimo.toFixed(2)}</span>
            </div>
            <div class="estatistica-item">
                <strong>Preço Máximo:</strong>
                <span class="estatistica-valor">R$ ${precoMaximo.toFixed(2)}</span>
            </div>
        `;
    }

    // Carrinho
    const estatisticasCarrinho = document.getElementById('estatisticas-carrinho');
    if (estatisticasCarrinho) {
        const totalCarrinho = carrinho.reduce((total, item) => total + item.preco, 0);
        estatisticasCarrinho.innerHTML = `
            <div class="estatistica-item">
                <strong>Quantidade de Itens:</strong>
                <span class="estatistica-valor">${carrinho.length}</span>
            </div>
            <div class="estatistica-item">
                <strong>Valor Total:</strong>
                <span class="estatistica-valor">R$ ${totalCarrinho.toFixed(2)}</span>
            </div>
        `;
    }

    // Histórico
    const estatisticasHistorico = document.getElementById('estatisticas-historico');
    if (estatisticasHistorico) {
        estatisticasHistorico.innerHTML = `
            <div class="estatistica-item">
                <strong>Produtos analisados:</strong>
                <span class="estatistica-valor">${historico.length}</span>
            </div>
        `;
    }
}

function cadastrarProduto(event) {
    event.preventDefault();

    const nome = document.getElementById('nome').value;
    const descricao = document.getElementById('descricao').value;
    const preco = parseFloat(document.getElementById('preco').value);

    // Gerar ID único
    const id = `PROD${Date.now()}`;

    // Criar novo produto
    const novoProduto = {
        id,
        nome,
        descricao,
        preco
    };

    produtosPrincipais.push(novoProduto);
    limparFormulario();
    alert('Produto cadastrado com sucesso!');
    atualizarProdutos();
    atualizarEstatisticas();
}

function limparFormulario() {
    document.getElementById('nome').value = '';
    document.getElementById('descricao').value = '';
    document.getElementById('preco').value = '';
}

function exportarRelatorio() {
    // Criar conteúdo do relatório
    let conteudo = '=== RELATÓRIO DO SISTEMA ===\n\n';
    
    // Adicionar data e hora
    const dataHora = new Date().toLocaleString('pt-BR');
    conteudo += `Data e Hora: ${dataHora}\n\n`;
    
    // Estatísticas de Produtos
    conteudo += '--- PRODUTOS ---\n';
    const categorias = {
        'Notebooks': produtosPrincipais.filter(p => p.id.startsWith('NB')),
        'Smartphones': produtosPrincipais.filter(p => p.id.startsWith('SP')),
        'Tablets': produtosPrincipais.filter(p => p.id.startsWith('TB')),
        'Smart TVs': produtosPrincipais.filter(p => p.id.startsWith('TV')),
        'Fones de Ouvido': produtosPrincipais.filter(p => p.id.startsWith('FO')),
        'Monitores': produtosPrincipais.filter(p => p.id.startsWith('MN')),
        'Teclados e Mouses': produtosPrincipais.filter(p => p.id.startsWith('TM')),
        'Impressoras': produtosPrincipais.filter(p => p.id.startsWith('IM'))
    };

    for (const [categoria, produtos] of Object.entries(categorias)) {
        conteudo += `\n${categoria} (${produtos.length} produtos):\n`;
        produtos.forEach(produto => {
            conteudo += `- ${produto.id}: ${produto.nome} - R$ ${produto.preco.toFixed(2)}\n`;
        });
    }

    // Estatísticas do Carrinho
    conteudo += '\n--- CARRINHO ---\n';
    if (carrinho.length > 0) {
        const totalCarrinho = carrinho.reduce((total, item) => total + item.preco, 0);
        conteudo += `Total de itens: ${carrinho.length}\n`;
        conteudo += `Valor total: R$ ${totalCarrinho.toFixed(2)}\n`;
        carrinho.forEach(item => {
            conteudo += `- ${item.id}: ${item.nome} - R$ ${item.preco.toFixed(2)}\n`;
        });
    } else {
        conteudo += 'Carrinho vazio\n';
    }

    // Histórico de Produtos
    conteudo += '\n--- HISTÓRICO ---\n';
    if (historico.length > 0) {
        historico.forEach(item => {
            conteudo += `- ${item.id}: ${item.nome} (${item.horarioAnalise})\n`;
        });
    } else {
        conteudo += 'Nenhum produto analisado\n';
    }

    // Criar e baixar o arquivo
    const blob = new Blob([conteudo], { type: 'text/plain' });
    const url = window.URL.createObjectURL(blob);
    const a = document.createElement('a');
    a.href = url;
    a.download = `relatorio_${new Date().toISOString().slice(0,10)}.txt`;
    document.body.appendChild(a);
    a.click();
    document.body.removeChild(a);
    window.URL.revokeObjectURL(url);
}

// Inicialização
document.addEventListener('DOMContentLoaded', () => {
    atualizarProdutos();
    atualizarEstatisticas();
    // Mostra a seção de produtos por padrão
    mostrarSecao('produtos');
});

function atualizarEstatisticas() {
    // Produtos por categoria
    const estatisticasProdutos = document.getElementById('estatisticas-produtos');
    if (estatisticasProdutos) {
        const categorias = {
            'Notebooks': produtosPrincipais.filter(p => p.id.startsWith('NB')).length,
            'Smartphones': produtosPrincipais.filter(p => p.id.startsWith('SP')).length,
            'Tablets': produtosPrincipais.filter(p => p.id.startsWith('TB')).length,
            'Smart TVs': produtosPrincipais.filter(p => p.id.startsWith('TV')).length,
            'Fones de Ouvido': produtosPrincipais.filter(p => p.id.startsWith('FO')).length,
            'Monitores': produtosPrincipais.filter(p => p.id.startsWith('MN')).length,
            'Teclados e Mouses': produtosPrincipais.filter(p => p.id.startsWith('TM')).length,
            'Impressoras': produtosPrincipais.filter(p => p.id.startsWith('IM')).length
        };

        let htmlProdutos = '';
        for (const [categoria, quantidade] of Object.entries(categorias)) {
            htmlProdutos += `
                <div class="estatistica-item">
                    <strong>${categoria}:</strong>
                    <span class="estatistica-valor">${quantidade}</span>
                </div>
            `;
        }
        estatisticasProdutos.innerHTML = htmlProdutos;
    }

    // Preços
    const estatisticasPrecos = document.getElementById('estatisticas-precos');
    if (estatisticasPrecos) {
        const precos = produtosPrincipais.map(p => p.preco);
        const precoMedio = precos.reduce((a, b) => a + b, 0) / precos.length;
        const precoMinimo = Math.min(...precos);
        const precoMaximo = Math.max(...precos);

        estatisticasPrecos.innerHTML = `
            <div class="estatistica-item">
                <strong>Preço Médio:</strong>
                <span class="estatistica-valor">R$ ${precoMedio.toFixed(2)}</span>
            </div>
            <div class="estatistica-item">
                <strong>Preço Mínimo:</strong>
                <span class="estatistica-valor">R$ ${precoMinimo.toFixed(2)}</span>
            </div>
            <div class="estatistica-item">
                <strong>Preço Máximo:</strong>
                <span class="estatistica-valor">R$ ${precoMaximo.toFixed(2)}</span>
            </div>
        `;
    }

    // Carrinho
    const estatisticasCarrinho = document.getElementById('estatisticas-carrinho');
    if (estatisticasCarrinho) {
        const totalCarrinho = carrinho.reduce((total, item) => total + item.preco, 0);
        estatisticasCarrinho.innerHTML = `
            <div class="estatistica-item">
                <strong>Quantidade de Itens:</strong>
                <span class="estatistica-valor">${carrinho.length}</span>
            </div>
            <div class="estatistica-item">
                <strong>Valor Total:</strong>
                <span class="estatistica-valor">R$ ${totalCarrinho.toFixed(2)}</span>
            </div>
        `;
    }

    // Histórico
    const estatisticasHistorico = document.getElementById('estatisticas-historico');
    if (estatisticasHistorico) {
        estatisticasHistorico.innerHTML = `
            <div class="estatistica-item">
                <strong>Produtos analisados:</strong>
                <span class="estatistica-valor">${historico.length}</span>
            </div>
        `;
    }
}

// Certifique-se de chamar esta função sempre que o histórico for modificado
function adicionarAoHistorico(produto) {
    historico.push(produto);
    atualizarEstatisticas();
}

// Atualiza a contagem de itens no carrinho na estatística
function atualizarEstatisticaCarrinho() {
    const estatisticasCarrinhoItens = document.getElementById('estatisticas-carrinho-itens');
    const estatisticasCarrinhoTotal = document.getElementById('estatisticas-carrinho-total');
    estatisticasCarrinhoItens.textContent = carrinho.length;
    
    const totalCarrinho = carrinho.reduce((total, item) => total + item.preco, 0);
    estatisticasCarrinhoTotal.textContent = `Total: R$ ${totalCarrinho.toFixed(2)}`;
}

// Chame esta função sempre que um produto for adicionado ou removido do carrinho
function atualizarEstatisticasCarrinho() {
    atualizarEstatisticaCarrinho();
    // Você pode adicionar outras estatísticas relacionadas ao carrinho aqui, se necessário
}

// Exemplo de uso: adicionar um produto ao carrinho
function adicionarProdutoExemplo() {
    const produtoExemplo = produtosPrincipais[0]; // Pegando o primeiro produto como exemplo
    adicionarAoCarrinho(produtoExemplo.id);
    alert(`Produto ${produtoExemplo.nome} adicionado ao carrinho!`);
}

// Exemplo de uso: remover um produto do carrinho
function removerProdutoExemplo() {
    const produtoExemplo = carrinho[0]; // Pegando o primeiro produto do carrinho como exemplo
    removerDoCarrinho(produtoExemplo.id);
    alert(`Produto ${produtoExemplo.nome} removido do carrinho!`);
}

// Exemplo de uso: gerar relatório
function gerarRelatorioExemplo() {
    exportarRelatorio();
    alert('Relatório gerado e baixado com sucesso!');
}

// Exemplo de uso: cadastrar um novo produto
function cadastrarProdutoExemplo() {
    const novoProduto = {
        id: 'PROD' + Date.now(),
        nome: 'Produto Exemplo',
        descricao: 'Descrição do Produto Exemplo',
        preco: 100.00,
        imagem: 'https://via.placeholder.com/150'
    };

    produtosPrincipais.push(novoProduto);
    alert('Produto cadastrado com sucesso!');
    atualizarProdutos();
    atualizarEstatisticas();
}

// Exemplo de uso: excluir um produto (usando o ID do primeiro produto como exemplo)
function excluirProdutoExemplo() {
    const produtoId = produtosPrincipais[0].id;
    excluirProduto(produtoId);
}

// Adicionei um exemplo de uso para cada função importante, agora você pode testar cada uma delas individualmente
// Basta descomentar a função desejada e chamá-la no console do navegador, por exemplo:

// adicionarProdutoExemplo();
// removerProdutoExemplo();
// gerarRelatorioExemplo();
// cadastrarProdutoExemplo();
// excluirProdutoExemplo();

function mostrarToast(mensagem) {
    const toast = document.getElementById('toast-notificacao');
    toast.textContent = mensagem;
    toast.classList.add('mostrar');
    setTimeout(() => {
        toast.classList.remove('mostrar');
    }, 2500);
}