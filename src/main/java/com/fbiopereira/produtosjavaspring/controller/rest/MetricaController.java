package com.fbiopereira.produtosjavaspring.controller.rest;

import com.fbiopereira.produtosjavaspring.service.MetricaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/metricas")
@Tag(name = "Métricas", description = "Endpoints para exemplificação de alguns tipos de métrica")
public class MetricaController {

    @Autowired
    private MetricaService metricasService;

    @Operation(summary = "Uma requisição que demora entre 1 e 3 segundos para responder", responses = {@ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = String.class)))})
    @GetMapping(path = "/requisicao-demorada")

    public ResponseEntity<String> requisicaoDemorada() {

        return ResponseEntity.status(HttpStatus.OK).body(String.format("Demorei %s milisegundo(s) para responder a requisição", metricasService.tempoRandomico()));

    }

    @Operation(summary = "Uma requisição post que recebe um numero inteiro registra a metrica em um counter. Só utilize counter para metricas que só crescem", responses = {@ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = String.class)))})
    @PostMapping(path = "/vender")
    public ResponseEntity<String> vender(@RequestBody Integer quantidade) {

        metricasService.vender(quantidade);
        return ResponseEntity.status(HttpStatus.OK).body(String.format("Vendi %s produto(s)", quantidade));

    }

    @Operation(summary = "Uma requisição que altera a velocidade de um carro e registra a metrica em um gauge. utilize quando quiser exibir valores que aumentam e diminuem. Não suporta query", responses = {@ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = String.class)))})
    @PostMapping(path = "/velocidade")
    public ResponseEntity<String> velocidade(@RequestBody Integer velocidade) {

        return ResponseEntity.status(HttpStatus.OK).body(String.format("Velocidade em %s Km/h", metricasService.alterarVelocidade(velocidade)));
    }
}
