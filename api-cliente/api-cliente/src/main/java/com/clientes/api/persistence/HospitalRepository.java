package com.clientes.api.persistence;

import com.clientes.api.domain.Hospitall;
import com.clientes.api.domain.repository.HospitallRepository;
import com.clientes.api.persistence.crud.ClienteCrudRepository;
import com.clientes.api.persistence.crud.HospitalCrudRepository;
import com.clientes.api.persistence.entity.Hospital;
import com.clientes.api.persistence.mapper.HospitalMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class HospitalRepository implements HospitallRepository {

    @Autowired
    private HospitalCrudRepository hospitalCrudRepository;

    @Autowired
    private HospitalMapper mapper;
    @Override
    public List<Hospitall> getAll1() {

        List<Hospital> hospitalls = (List<Hospital>) hospitalCrudRepository.findAll();

        return mapper.toHospitalls(hospitalls) ;
    }

    @Override
    public Optional<Hospitall> getById(int idHospital) {

        return hospitalCrudRepository.findById(idHospital).map(hospital -> mapper.toHospitall(hospital));
    }
}
