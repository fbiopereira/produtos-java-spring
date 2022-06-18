package com.fbiopereira.produtosjavaspring.entity;

import com.fbiopereira.produtosjavaspring.domain.Produto;
import com.fbiopereira.produtosjavaspring.dto.produto.ProdutoRespostaDto;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;

@Document(collection="Produtos")
public class ProdutoEntity {

    @Id
    private String id;
    private String nome;
    private String sku;
    private String fornecedor;
    @Field("data-cadastro")
    private LocalDateTime dataCadastro;

    public ProdutoEntity(Produto produto) {
        this.id = produto.getId();
        this.nome = produto.getNome();
        this.sku = produto.getSku();
        this.fornecedor = produto.getFornecedor();
        this.dataCadastro = produto.getDataCadastro();
    }

    public Produto converterParaDominio(){
        Produto produto = new Produto();
        BeanUtils.copyProperties(this, produto);
        return produto;
    }
    public ProdutoRespostaDto converterParaRespostaDto(){
        ProdutoRespostaDto produtoRespostaDto = new ProdutoRespostaDto();
        BeanUtils.copyProperties(this, produtoRespostaDto);
        return produtoRespostaDto;
    }

    public ProdutoEntity(){

    }


    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getSku() {
        return sku;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
}
