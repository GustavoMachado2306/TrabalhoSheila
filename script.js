// Dados iniciais
const produtosPrincipais = [
    // Notebooks
    { id: 'NB001', nome: "Notebook Dell i7", descricao: "Notebook Dell i7 16GB, 512GB SSD", preco: 4500.00 },
    { id: 'NB002', nome: "Notebook MacBook Pro", descricao: "MacBook Pro M2 16GB, 512GB SSD", preco: 12000.00 },
    { id: 'NB003', nome: "Notebook Lenovo", descricao: "Lenovo ThinkPad i5 8GB, 256GB SSD", preco: 3500.00 },
    { id: 'NB004', nome: "Notebook HP", descricao: "HP Pavilion i5 8GB, 512GB SSD", preco: 3800.00 },
    { id: 'NB005', nome: "Notebook Asus ROG", descricao: "Asus ROG Strix G15, RTX 3060, 16GB RAM", preco: 8500.00 },
    { id: 'NB006', nome: "Notebook Acer Nitro", descricao: "Acer Nitro 5, GTX 1650, 8GB RAM", preco: 4200.00 },
    { id: 'NB007', nome: "Notebook Samsung Book", descricao: "Samsung Book Pro 360, 13.3\", 8GB RAM", preco: 5500.00 },
    { id: 'NB008', nome: "Notebook Microsoft Surface", descricao: "Microsoft Surface Laptop 4, 13.5\", 8GB RAM", preco: 7800.00 },

    // Smartphones
    { id: 'SP001', nome: "iPhone 13", descricao: "iPhone 13 128GB", preco: 5500.00 },
    { id: 'SP002', nome: "Samsung S21", descricao: "Samsung Galaxy S21 128GB", preco: 4800.00 },
    { id: 'SP003', nome: "Xiaomi 12", descricao: "Xiaomi 12 256GB", preco: 3500.00 },
    { id: 'SP004', nome: "Motorola Edge", descricao: "Motorola Edge 30 128GB", preco: 2800.00 },
    { id: 'SP005', nome: "iPhone 14 Pro", descricao: "iPhone 14 Pro 256GB", preco: 8500.00 },
    { id: 'SP006', nome: "Samsung S23", descricao: "Samsung Galaxy S23 Ultra 256GB", preco: 7500.00 },
    { id: 'SP007', nome: "Google Pixel 7", descricao: "Google Pixel 7 Pro 128GB", preco: 5200.00 },
    { id: 'SP008', nome: "OnePlus 11", descricao: "OnePlus 11 256GB", preco: 4500.00 },

    // Tablets
    { id: 'TB001', nome: "iPad Pro", descricao: "iPad Pro 12.9 256GB", preco: 8000.00 },
    { id: 'TB002', nome: "Samsung Tab S8", descricao: "Samsung Galaxy Tab S8 128GB", preco: 4500.00 },
    { id: 'TB003', nome: "iPad Air", descricao: "iPad Air 64GB", preco: 5000.00 },
    { id: 'TB004', nome: "Lenovo Tab", descricao: "Lenovo Tab P11 Pro 128GB", preco: 3000.00 },
    { id: 'TB005', nome: "iPad Mini", descricao: "iPad Mini 6 64GB", preco: 4200.00 },
    { id: 'TB006', nome: "Samsung Tab S9", descricao: "Samsung Galaxy Tab S9+ 256GB", preco: 6500.00 },
    { id: 'TB007', nome: "Microsoft Surface Pro", descricao: "Microsoft Surface Pro 9 128GB", preco: 7800.00 },
    { id: 'TB008', nome: "Xiaomi Pad 6", descricao: "Xiaomi Pad 6 Pro 256GB", preco: 3500.00 },

    // Smart TVs
    { id: 'TV001', nome: "Samsung 55\"", descricao: "Samsung 55\" 4K Smart TV", preco: 3500.00 },
    { id: 'TV002', nome: "LG 65\"", descricao: "LG 65\" 4K Smart TV", preco: 4500.00 },
    { id: 'TV003', nome: "Philips 50\"", descricao: "Philips 50\" 4K Smart TV", preco: 2800.00 },
    { id: 'TV004', nome: "TCL 43\"", descricao: "TCL 43\" 4K Smart TV", preco: 2000.00 },
    { id: 'TV005', nome: "Samsung 75\"", descricao: "Samsung 75\" QLED 4K Smart TV", preco: 8500.00 },
    { id: 'TV006', nome: "LG 77\"", descricao: "LG 77\" OLED 4K Smart TV", preco: 12000.00 },
    { id: 'TV007', nome: "Sony 65\"", descricao: "Sony 65\" BRAVIA OLED 4K", preco: 7800.00 },
    { id: 'TV008', nome: "Philips 65\"", descricao: "Philips 65\" OLED 4K Smart TV", preco: 6500.00 },

    // Fones de Ouvido
    { id: 'FO001', nome: "AirPods Pro", descricao: "AirPods Pro com Cancelamento de Ruído", preco: 2000.00 },
    { id: 'FO002', nome: "Sony WH-1000", descricao: "Sony WH-1000XM4", preco: 2500.00 },
    { id: 'FO003', nome: "Samsung Buds", descricao: "Samsung Galaxy Buds Pro", preco: 1500.00 },
    { id: 'FO004', nome: "JBL Tune", descricao: "JBL Tune 750BTNC", preco: 800.00 },
    { id: 'FO005', nome: "AirPods Max", descricao: "AirPods Max com Cancelamento de Ruído", preco: 4500.00 },
    { id: 'FO006', nome: "Sony WH-1000XM5", descricao: "Sony WH-1000XM5 com Cancelamento de Ruído", preco: 3200.00 },
    { id: 'FO007', nome: "Samsung Buds2 Pro", descricao: "Samsung Galaxy Buds2 Pro", preco: 1800.00 },
    { id: 'FO008', nome: "Bose QC45", descricao: "Bose QuietComfort 45", preco: 2800.00 },

    // Monitores
    { id: 'MN001', nome: "Dell 27\"", descricao: "Dell 27\" 4K UHD", preco: 2500.00 },
    { id: 'MN002', nome: "LG 32\"", descricao: "LG 32\" UltraWide", preco: 3000.00 },
    { id: 'MN003', nome: "Samsung 24\"", descricao: "Samsung 24\" Full HD", preco: 1200.00 },
    { id: 'MN004', nome: "AOC 27\"", descricao: "AOC 27\" Gaming", preco: 1800.00 },
    { id: 'MN005', nome: "Dell 34\"", descricao: "Dell 34\" UltraWide QHD", preco: 4500.00 },
    { id: 'MN006', nome: "LG 38\"", descricao: "LG 38\" UltraWide QHD+", preco: 5800.00 },
    { id: 'MN007', nome: "Samsung 32\"", descricao: "Samsung 32\" Odyssey G7 QHD", preco: 3500.00 },
    { id: 'MN008', nome: "Asus 27\"", descricao: "Asus 27\" ROG Swift QHD", preco: 4200.00 },

    // Teclados e Mouses
    { id: 'TM001', nome: "Logitech MX", descricao: "Logitech MX Keys", preco: 800.00 },
    { id: 'TM002', nome: "Razer BlackWidow", descricao: "Razer BlackWidow V3", preco: 1200.00 },
    { id: 'TM003', nome: "Logitech G Pro", descricao: "Logitech G Pro Mouse", preco: 600.00 },
    { id: 'TM004', nome: "HyperX Alloy", descricao: "HyperX Alloy Origins", preco: 900.00 },
    { id: 'TM005', nome: "Logitech MX Master", descricao: "Logitech MX Master 3S", preco: 850.00 },
    { id: 'TM006', nome: "Razer DeathAdder", descricao: "Razer DeathAdder V2 Pro", preco: 750.00 },
    { id: 'TM007', nome: "Corsair K95", descricao: "Corsair K95 RGB Platinum", preco: 1100.00 },
    { id: 'TM008', nome: "SteelSeries Apex", descricao: "SteelSeries Apex Pro", preco: 1300.00 },

    // Impressoras
    { id: 'IM001', nome: "HP LaserJet", descricao: "HP LaserJet Pro M404", preco: 1500.00 },
    { id: 'IM002', nome: "Epson EcoTank", descricao: "Epson EcoTank L3250", preco: 1200.00 },
    { id: 'IM003', nome: "Canon PIXMA", descricao: "Canon PIXMA TS3350", preco: 800.00 },
    { id: 'IM004', nome: "Brother DCP", descricao: "Brother DCP-L2530DW", preco: 1300.00 },
    { id: 'IM005', nome: "HP OfficeJet", descricao: "HP OfficeJet Pro 9015", preco: 1800.00 },
    { id: 'IM006', nome: "Epson WorkForce", descricao: "Epson WorkForce Pro WF-3720", preco: 950.00 },
    { id: 'IM007', nome: "Canon MAXIFY", descricao: "Canon MAXIFY GX4020", preco: 1100.00 },
    { id: 'IM008', nome: "Brother MFC", descricao: "Brother MFC-L8900CDW", preco: 2500.00 }
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
                    preco: produto.preco * (0.8 + Math.random() * 0.4),
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
    if (carrinho.length === 0) {
        container.innerHTML = '<p>Seu carrinho está vazio.</p>';
        document.getElementById('carrinho-total-valor').textContent = '0.00';
        return;
    }

    container.innerHTML = carrinho.map(item => `
        <div class="carrinho-item">
            <div>
                <h3>${item.nome}</h3>
                <p>${item.descricao}</p>
            </div>
            <div>
                <p class="preco">R$ ${item.preco.toFixed(2)}</p>
                <button onclick="removerDoCarrinho('${item.id}')">Remover</button>
            </div>
        </div>
    `).join('');

    const total = carrinho.reduce((sum, item) => sum + item.preco, 0);
    document.getElementById('carrinho-total-valor').textContent = total.toFixed(2);
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
        const detalhes = `
            <div class="produto-detalhes">
                <h2>${produto.nome}</h2>
                <p class="descricao">${produto.descricao}</p>
                <p class="preco">R$ ${produto.preco.toFixed(2)}</p>
                <div class="acoes">
                    <button onclick="adicionarAoCarrinho('${produto.id}')">Adicionar ao Carrinho</button>
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
        produtosAnalisadosRecomendacoes.delete(produto.id);
        
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
        }
        atualizarCarrinho();
        atualizarHistorico();
        alert('Produto adicionado ao carrinho!');
    }
}

function removerDoCarrinho(id) {
    carrinho = carrinho.filter(item => item.id !== id);
    atualizarCarrinho();
    alert('Produto removido do carrinho!');
}

function gerarRecomendacoes() {
    return sistemaRecomendacoes.gerarRecomendacoes(produtosPrincipais, historico, carrinho);
}

// Função para analisar produto
function analisarProduto(id) {
    const produto = produtosPrincipais.find(p => p.id === id);
    if (produto) {
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
        
        // Mostra detalhes do produto
        const detalhes = `
            <div class="produto-detalhes">
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
    // Estatísticas de Produtos
    const estatisticasProdutos = document.getElementById('estatisticas-produtos');
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

    // Estatísticas de Preços
    const estatisticasPrecos = document.getElementById('estatisticas-precos');
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

    // Estatísticas do Carrinho
    const estatisticasCarrinho = document.getElementById('estatisticas-carrinho');
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

    // Estatísticas do Histórico
    const estatisticasHistorico = document.getElementById('estatisticas-historico');
    const produtosUnicos = new Set(historico.map(item => item.id)).size;

    estatisticasHistorico.innerHTML = `
        <div class="estatistica-item">
            <strong>Produtos Analisados:</strong>
            <span class="estatistica-valor">${historico.length}</span>
        </div>
        <div class="estatistica-item">
            <strong>Produtos Únicos:</strong>
            <span class="estatistica-valor">${produtosUnicos}</span>
        </div>
    `;
}

function cadastrarProduto(event) {
    event.preventDefault();
    
    const categoria = document.getElementById('categoria').value;
    const nome = document.getElementById('nome').value;
    const descricao = document.getElementById('descricao').value;
    const preco = parseFloat(document.getElementById('preco').value);

    // Gerar ID único baseado na categoria
    const id = `${categoria}${Date.now()}`;

    // Criar novo produto
    const novoProduto = {
        id,
        nome,
        descricao,
        preco
    };

    // Adicionar à lista de produtos
    produtosPrincipais.push(novoProduto);

    // Limpar formulário
    limparFormulario();

    // Mostrar mensagem de sucesso
    alert('Produto cadastrado com sucesso!');

    // Atualizar a lista de produtos
    atualizarProdutos();
}

function limparFormulario() {
    document.getElementById('categoria').value = '';
    document.getElementById('nome').value = '';
    document.getElementById('descricao').value = '';
    document.getElementById('preco').value = '';
}

// Inicialização
document.addEventListener('DOMContentLoaded', () => {
    atualizarProdutos();
    // Mostra a seção de produtos por padrão
    mostrarSecao('produtos');
}); 