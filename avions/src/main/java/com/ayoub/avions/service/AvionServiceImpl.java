package com.ayoub.avions.service;

import com.ayoub.avions.entities.Avion;
import com.ayoub.avions.repos.AvionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvionServiceImpl implements AvionService{
    @Autowired
    AvionRepository avionRepository;
    @Override
    public Avion saveAvion(Avion p) {
        return avionRepository.save(p);
    }
    @Override
    public Avion updateAvion(Avion p) {
        return avionRepository.save(p);
    }
    @Override
    public void deleteAvion(Avion p) {
        avionRepository.delete(p);
    }
    @Override
    public void deleteAvionById(Long id) {
        avionRepository.deleteById(id);
    }
    @Override
    public Avion getAvion(Long id) {
        return avionRepository.findById(id).get();
    }
    @Override
    public List<Avion> getAllAvions() {
        return avionRepository.findAll();
    }
    @Override
    public Page<Avion> getAllAvionsParPage(int page, int size) {
        return avionRepository.findAll(PageRequest.of(page, size));
    }
}
