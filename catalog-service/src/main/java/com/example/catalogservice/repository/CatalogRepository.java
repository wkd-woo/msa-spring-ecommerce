package com.example.catalogservice.repository;

import com.example.catalogservice.jpa.Catalog;
import org.springframework.data.repository.CrudRepository;

public interface CatalogRepository extends CrudRepository<Catalog, Long> {

    Catalog findByProductId(String productId);


}
