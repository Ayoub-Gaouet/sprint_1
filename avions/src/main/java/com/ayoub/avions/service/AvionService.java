package com.ayoub.avions.service;

import com.ayoub.avions.entities.Avion;
import org.springframework.data.domain.Page;

import java.util.List;

public interface AvionService {
    Avion saveAvion(Avion a);
    Avion updateAvion(Avion a);
    void deleteAvion(Avion a);
    void deleteAvionById(Long id);
    Avion getAvion(Long id);
    List<Avion> getAllAvions();
    Page<Avion> getAllAvionsParPage(int page, int size);
}
