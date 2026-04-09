package com.hc.app.repository;

import com.hc.app.model.ComputadorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComputadorRepository extends JpaRepository<ComputadorEntity, Long> {
}
