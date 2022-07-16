package com.fbiopereira.produtosjavaspring.controller;

import com.fbiopereira.produtosjavaspring.domain.Produto;
import com.fbiopereira.produtosjavaspring.dto.produto.ProdutoEntradaDto;
import com.fbiopereira.produtosjavaspring.dto.produto.ProdutoRespostaDto;
import com.fbiopereira.produtosjavaspring.dto.produto.RespostaRestListaProdutoDto;
import com.fbiopereira.produtosjavaspring.dto.resposta.RespostaRestGenericaDto;
import com.fbiopereira.produtosjavaspring.service.ProdutoServiceRest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/produtos")
@Tag(name = "Produtos", description = "Endpoints para exemplificação de um CRUD no MongoDb")
public class ProdutoController {

    @Autowired
    private ProdutoServiceRest produtoService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Cadastra um novo produto na base. Não são permitidos SKUs repetidos. Nome e fornecedor precisam ser uma string válida", responses = {@ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = RespostaRestGenericaDto.class)))})
    public ResponseEntity<RespostaRestGenericaDto> cadastrarProduto(@RequestBody @Valid ProdutoEntradaDto produtoEntradaDto) {


        Produto produto = produtoEntradaDto.converterParaDominio();


        produto = produtoService.cadastrar(produto);

        ProdutoRespostaDto produtoRespostaDto = new ProdutoRespostaDto();
        produtoRespostaDto.converterDeDominio(produto);

        RespostaRestGenericaDto respostaRestGenericaDto = new RespostaRestGenericaDto(HttpStatus.CREATED.value(), HttpStatus.CREATED.toString(), null, null, produtoRespostaDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(respostaRestGenericaDto);

    }

    @Operation(summary = "Retorna todos os produtos cadastrados", responses = {@ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = RespostaRestListaProdutoDto.class)))})
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RespostaRestListaProdutoDto> todosProdutos() {
        List<ProdutoRespostaDto> listaProdutoRespostaDto = produtoService.todosProdutos();
        RespostaRestListaProdutoDto respostaRestListaProdutoDto = new RespostaRestListaProdutoDto(HttpStatus.OK.value(), HttpStatus.OK.toString(), null, null, listaProdutoRespostaDto);
        return ResponseEntity.status(HttpStatus.OK).body(respostaRestListaProdutoDto);

    }
}


