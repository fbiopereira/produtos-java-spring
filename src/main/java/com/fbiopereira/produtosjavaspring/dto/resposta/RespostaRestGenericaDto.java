package com.fbiopereira.produtosjavaspring.dto.resposta;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class RespostaRestGenericaDto {

    private Integer codigoHttp;
    private String statusHttp;
    private String codigoErro;
    private String mensagemErro;
    @JsonProperty("hora-resposta-utc")
    private String dataHoraResposta;
    private Object resposta;


    public RespostaRestGenericaDto(Integer codigoHttp, String statusHttp, String codigoErro, String mensagemErro, Object resposta) {
        this.codigoHttp = codigoHttp;
        this.statusHttp = statusHttp;
        this.codigoErro = codigoErro;
        this.mensagemErro = mensagemErro;
        this.resposta = resposta;
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

    public Object getResposta() {
        return resposta;
    }
}
