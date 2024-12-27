package com.api.prueba.user.franquicia.repository;

import com.api.prueba.user.franquicia.model.entity.Branch;
import com.api.prueba.user.franquicia.model.entity.Franchise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BranchRepository extends JpaRepository<Branch, Long> {}

