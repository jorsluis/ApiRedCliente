package com.clientes.api.domain.repository;

import com.clientes.api.domain.Hospitall;

import java.util.List;
import java.util.Optional;

public interface HospitallRepository {

    List<Hospitall> getAll1();
    Optional<Hospitall> getById(int idHospital);
}
