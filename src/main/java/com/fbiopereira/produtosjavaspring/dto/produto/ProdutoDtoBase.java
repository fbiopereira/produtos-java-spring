package com.fbiopereira.produtosjavaspring.dto.produto;

import com.fbiopereira.produtosjavaspring.domain.Produto;
import org.springframework.beans.BeanUtils;

abstract class ProdutoDtoBase  {

    private String nome;
    private String sku;
    private String fornecedor;

    public Produto converterParaDominio(){
        Produto produto = new Produto();
        BeanUtils.copyProperties(this, produto);
        return produto;
    }

    public void converterDeDominio(Produto produto){
        BeanUtils.copyProperties(produto, this);
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

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

}
