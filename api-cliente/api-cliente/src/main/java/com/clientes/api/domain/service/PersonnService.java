package com.clientes.api.domain.service;

import com.clientes.api.domain.Personn;
import com.clientes.api.domain.repository.PersonnRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//Todo el proceso viene de la clase PersonRepository, sin embargo esta se encuentra
//orientada a la base de datos por lo que para orientar al dominio se establace primero PersonnRepository
//y para utilizarla a nuestro dominio le creamos este service
@Service
public class PersonnService {

    @Autowired
    private PersonnRepository personnRepository;

    public List<Personn> getAll(){

        return personnRepository.getAll();
    }
    public Optional<List<Personn>> getByCenterUbi(int idCenterPerson) {

        return personnRepository.getByCenterUbi(idCenterPerson);
    }
    public  Optional<Personn>getByIdPerson(int idPersonn){
        return personnRepository.getByIdPerson(idPersonn);
    }
    public  Personn save (Personn personn){

        return personnRepository.save(personn);
    }
    //el metodo delete para que nos retorne un estado que nos confirme la accion realizada
    //le creamos este boolean
    public boolean delete (int idPersonn){

        return getByIdPerson(idPersonn).map(personn -> {
            personnRepository.delete(idPersonn);
            return true;
        }).orElse(false);

    }

    public Personn update(Personn personn){
        return personnRepository.update(personn);
    }
}
