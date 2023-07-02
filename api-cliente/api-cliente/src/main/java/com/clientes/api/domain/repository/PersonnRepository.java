package com.clientes.api.domain.repository;

import com.clientes.api.domain.Hospitall;
import com.clientes.api.domain.Personn;

import java.util.List;
import java.util.Optional;


//Se crea interface que se orienta al dominio y no a la base de datos.
//Dentro de la interfaz se crean los metodos que establecimos en el paquete persientence
//Por lo que esta deberia crearse primero que PersonRepository
public interface PersonnRepository {

     List<Personn> getAll();
     Optional<List<Personn>> getByCenterUbi(int idCenterPerson);
     Optional<Personn>getByIdPerson(int idPersonn);
     Personn save(Personn personn);
     void delete (int idPersonn);
     Personn update (Personn personn);
}
