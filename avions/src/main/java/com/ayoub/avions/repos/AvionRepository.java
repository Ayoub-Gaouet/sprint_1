package com.ayoub.avions.repos;

import com.ayoub.avions.entities.Avion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvionRepository extends JpaRepository<Avion, Long> {
}
