package com.api.prueba.user.franquicia.repository;

import com.api.prueba.user.franquicia.model.entity.Franchise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FranchiseRepository extends JpaRepository<Franchise, Long> {}

