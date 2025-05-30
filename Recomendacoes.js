class Recomendacoes {
    constructor() {
        this.categorias = {
            'NOTEBOOKS': p => p.nome.includes('Notebook'),
            'SMARTPHONES': p => p.nome.includes('iPhone') || p.nome.includes('Samsung') || p.nome.includes('Xiaomi') || p.nome.includes('Motorola'),
            'TABLETS': p => p.nome.includes('iPad') || p.nome.includes('Tab'),
            'SMART TVs': p => p.nome.includes('"'),
            'FONES DE OUVIDO': p => p.nome.includes('AirPods') || p.nome.includes('Sony') || p.nome.includes('Buds') || p.nome.includes('JBL'),
            'MONITORES': p => (p.nome.includes('Dell') || p.nome.includes('LG') || p.nome.includes('Samsung') || p.nome.includes('AOC')) && p.nome.includes('"'),
            'TECLADOS E MOUSES': p => p.nome.includes('Logitech') || p.nome.includes('Razer') || p.nome.includes('HyperX'),
            'IMPRESSORAS': p => p.nome.includes('HP') || p.nome.includes('Epson') || p.nome.includes('Canon') || p.nome.includes('Brother')
        };
    }

    encontrarCategoria(produto) {
        for (const [categoria, filtro] of Object.entries(this.categorias)) {
            if (filtro(produto)) {
                return categoria;
            }
        }
        return null;
    }

    encontrarCategoriasVisualizadas(historico) {
        const categoriasVisualizadas = new Set();
        historico.forEach(produto => {
            const categoria = this.encontrarCategoria(produto);
            if (categoria) {
                categoriasVisualizadas.add(categoria);
            }
        });
        return categoriasVisualizadas;
    }

    gerarRecomendacoes(produtosPrincipais, historico, carrinho) {
        const produtosVistos = new Set([...historico, ...carrinho].map(p => p.nome));
        const categoriasVisualizadas = this.encontrarCategoriasVisualizadas(historico);

        if (categoriasVisualizadas.size === 0) {
            return [];
        }

        let recomendacoes = [];
        for (const categoria of categoriasVisualizadas) {
            const produtosCategoria = produtosPrincipais
                .filter(produto => this.categorias[categoria](produto) && !produtosVistos.has(produto.nome))
                .map(produto => ({
                    ...produto,
                    categoria: categoria,
                    preco: produto.preco * (0.8 + Math.random() * 0.4)
                }));
            
            recomendacoes.push(...produtosCategoria);
        }

        return recomendacoes
            .sort(() => Math.random() - 0.5)
            .slice(0, 4);
    }

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
}

// Exporta a classe para uso em outros arquivos
export default Recomendacoes; 