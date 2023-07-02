package com.clientes.api.persistence.crud;

import com.clientes.api.persistence.entity.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

//Al extender de crudREpository hace parte de spring esta interface y se puede inyectar con autowired
public interface ClienteCrudRepository extends CrudRepository<Person, Integer> {


    //QueryMethods para establecer la consulta
    List<Person> findByIdCenterOrderByFirstNameAsc(int idCenter);


}
