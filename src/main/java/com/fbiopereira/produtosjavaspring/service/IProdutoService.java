package com.fbiopereira.produtosjavaspring.service;

import br.com.fbiopereira.produtosrestgrpc.domain.Produto;
import br.com.fbiopereira.produtosrestgrpc.dto.produto.ProdutoRespostaDto;

import java.util.List;

public interface IProdutoService {

    public Produto cadastrar(Produto produto);

    public List<ProdutoRespostaDto> todosProdutos();

}
