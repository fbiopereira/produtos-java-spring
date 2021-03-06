package com.fbiopereira.produtosjavaspring.service;

import com.fbiopereira.produtosjavaspring.domain.Produto;
import com.fbiopereira.produtosjavaspring.dto.produto.ProdutoRespostaDto;
import com.fbiopereira.produtosjavaspring.entity.ProdutoEntity;
import com.fbiopereira.produtosjavaspring.repository.IProdutoRepository;
import io.micrometer.core.annotation.Timed;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProdutoServiceRest implements IProdutoService {

    @Autowired
    IProdutoRepository produtoRepository;
    @Timed(description = "Tempo levado para salvar o produto na base")
    public Produto cadastrar(Produto produto)  {

        produto.setDataCadastro(LocalDateTime.now(ZoneId.of("UTC")));
        ProdutoEntity produtoEntity = new ProdutoEntity(produto);


        produtoEntity = produtoRepository.save(produtoEntity);
        BeanUtils.copyProperties(produtoEntity, produto);

        return produto;
    }

    @Override
    public List<ProdutoRespostaDto> todosProdutos() {
        List<ProdutoEntity> listaProdutoEntity = produtoRepository.findAll();
        List<ProdutoRespostaDto> listaProdutoRespostaDto = new ArrayList<ProdutoRespostaDto>();

        for (int indicelista=0;indicelista<listaProdutoEntity.size(); indicelista++){
            listaProdutoRespostaDto.add(listaProdutoEntity.get(indicelista).converterParaRespostaDto());
        }
        return listaProdutoRespostaDto;
    }


}
