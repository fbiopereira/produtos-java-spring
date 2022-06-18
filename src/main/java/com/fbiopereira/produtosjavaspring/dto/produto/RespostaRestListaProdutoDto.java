package com.fbiopereira.produtosjavaspring.dto.produto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class RespostaRestListaProdutoDto {

    private Integer codigoHttp;
    private String statusHttp;
    private String codigoErro;
    private String mensagemErro;

    @JsonProperty("hora-resposta-utc")
    private String dataHoraResposta;
    private List<ProdutoRespostaDto> produtos;

    public RespostaRestListaProdutoDto(Integer codigoHttp, String statusHttp, String codigoErro, String mensagemErro, List<ProdutoRespostaDto> produtosRespostaDto) {
        this.codigoHttp = codigoHttp;
        this.statusHttp = statusHttp;
        this.codigoErro = codigoErro;
        this.mensagemErro = mensagemErro;
        this.produtos = produtosRespostaDto;

        this.dataHoraResposta = LocalDateTime.now(ZoneId.of("UTC")).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSS"));
    }

    public Integer getCodigoHttp() {
        return codigoHttp;
    }

    public String getStatusHttp() {
        return statusHttp;
    }

    public String getCodigoErro() {
        return codigoErro;
    }

    public String getMensagemErro() {
        return mensagemErro;
    }

    public List<ProdutoRespostaDto> getProdutos() {
        return produtos;
    }
}
