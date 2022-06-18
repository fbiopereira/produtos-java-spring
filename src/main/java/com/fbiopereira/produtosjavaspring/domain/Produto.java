package com.fbiopereira.produtosjavaspring.domain;

import java.time.LocalDateTime;

public class Produto {

    private String id;
    private String nome;
    private String sku;
    private String fornecedor;
    private LocalDateTime dataCadastro;

    public Produto() {
        //this.id = UUID.randomUUID();
    }

    public Produto(String id, String nome, String sku, String fornecedor, LocalDateTime dataCadastro) {
        this.id = id;
        this.nome = nome;
        this.sku = sku;
        this.fornecedor = fornecedor;
        this.dataCadastro = dataCadastro;
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

