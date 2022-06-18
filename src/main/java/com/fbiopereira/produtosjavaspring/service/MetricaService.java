package com.fbiopereira.produtosjavaspring.service;

import io.micrometer.core.annotation.Timed;
import io.micrometer.core.instrument.*;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

@Service
public class MetricaService {

    private Counter vendasCounter;
    private Gauge velocidadeGauge;

    private DistributionSummary distributionSummary;
    private Integer velocidade;
    private final MeterRegistry registroDeMetricas;

    public MetricaService(MeterRegistry registroMetricas) {
        this.registroDeMetricas = registroMetricas;
        this.iniciarContadores();
        this.iniciarGauge();
    }

    @Timed(value = "metodo_execucao_longa", extraTags = {"tempo_longo", "metodo"})
    public long tempoRandomico(){
        Random tempoRandomico = new Random();
        long tempoThread =  tempoRandomico.nextLong(3000L - 1000L) + 1000L;

        try {
            Thread.sleep(tempoThread);
        }
        catch (InterruptedException e){
            //TODO: Log
        }

        return tempoThread;
    }
    private void iniciarContadores() {

        vendasCounter = Counter.builder("numero_vendas")
                .tag("type", "loja")
                .description("Numero de vendas feitas em loja fisica.")
                .register(registroDeMetricas);

    }

    public void vender(Integer quantidade){
        vendasCounter.increment(quantidade);
    }
    private void iniciarGauge(){

        velocidadeGauge = Gauge.builder("velocidade_atual", this, value -> this.getVelocidade())
                .description("Velocidade atual do veículo")
                .tags(Tags.of(Tag.of("data", LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")))))
                .baseUnit("unidade")
                .register(registroDeMetricas);
    }
    public double alterarVelocidade(Integer velocidadeParametro){

        this.velocidade = velocidadeParametro;
        return velocidadeGauge.value();
    }
    public Integer getVelocidade(){
        return this.velocidade;
    }
    private void iniciarDistributionSummary(){

        this.distributionSummary = DistributionSummary
                .builder("usuarios_online")
                .baseUnit("unidade")
                .register(registroDeMetricas);
    }

    public void adicionarUsuarioOnline(Integer quantidade){
        this.distributionSummary.record(quantidade);
    }





}
