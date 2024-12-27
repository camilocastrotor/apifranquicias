package com.api.prueba.user.franquicia.repository;

import com.api.prueba.user.franquicia.model.entity.Branch;
import com.api.prueba.user.franquicia.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {}

