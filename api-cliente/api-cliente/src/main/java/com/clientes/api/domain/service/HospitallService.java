package com.clientes.api.domain.service;

import com.clientes.api.domain.Hospitall;
import com.clientes.api.domain.repository.HospitallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HospitallService {

    @Autowired
    private HospitallRepository hospitallRepository;

    public List<Hospitall> getAll1(){

        return hospitallRepository.getAll1();
    }
    public Optional<Hospitall> getById(int idHospital){

        return hospitallRepository.getById(idHospital);
    }
}
