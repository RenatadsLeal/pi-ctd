package com.digitalbooking.service;

import com.digitalbooking.model.Reservation;
import com.digitalbooking.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository repository;

    public Reservation save(Reservation reservation) {
        return repository.save(reservation);
    }

    public List<Reservation> findAll() {
        return repository.findAll();
    }

    public List<Reservation> findByProduct(Integer id) {
        return repository.findByProduct(id);
    }
}
