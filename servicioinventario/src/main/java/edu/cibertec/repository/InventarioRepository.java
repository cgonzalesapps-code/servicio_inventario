package edu.cibertec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.cibertec.entity.InventarioEntity;

public interface InventarioRepository  extends JpaRepository<InventarioEntity, Integer> {
    
}
