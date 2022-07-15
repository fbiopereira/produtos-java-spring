package com.fbiopereira.produtosjavaspring.service;

import com.fbiopereira.produtosjavaspring.domain.Produto;
import com.fbiopereira.produtosjavaspring.dto.produto.ProdutoRespostaDto;

import java.util.List;

public interface IProdutoService {

    public Produto cadastrar(Produto produto);

    public List<ProdutoRespostaDto> todosProdutos();

}
