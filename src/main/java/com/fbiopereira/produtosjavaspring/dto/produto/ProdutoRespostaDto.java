package com.fbiopereira.produtosjavaspring.dto.produto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public class ProdutoRespostaDto extends ProdutoDtoBase {

    private String id;
    @JsonProperty("data-cadastro")
    private LocalDateTime dataCadastro;

    public ProdutoRespostaDto(){
        super();
    }

    public String getId() {
        return id;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public void setId(String id) {
        this.id = id;
    }



    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
}
