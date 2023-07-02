package com.clientes.api.persistence.crud;

import com.clientes.api.persistence.entity.Hospital;
import org.springframework.data.repository.CrudRepository;

public interface HospitalCrudRepository extends CrudRepository<Hospital, Integer> {


}
