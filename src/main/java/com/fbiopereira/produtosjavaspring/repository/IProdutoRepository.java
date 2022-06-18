package com.fbiopereira.produtosjavaspring.repository;

import com.fbiopereira.produtosjavaspring.entity.ProdutoEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface IProdutoRepository extends MongoRepository<ProdutoEntity, UUID> {
}
