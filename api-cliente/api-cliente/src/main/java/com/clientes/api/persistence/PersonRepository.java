package com.clientes.api.persistence;

import com.clientes.api.domain.Personn;
import com.clientes.api.domain.repository.PersonnRepository;
import com.clientes.api.persistence.crud.ClienteCrudRepository;
import com.clientes.api.persistence.entity.Person;
import com.clientes.api.persistence.mapper.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

//Implementa PersonnRepository para definir nuestra API a terminos de dominio
@Repository // se denota con esta anotacion para indicarle a Spring que esta
// es una clase que se encarga de interactuar con nuestra base de datos
public class PersonRepository implements PersonnRepository {

    @Autowired
    private ClienteCrudRepository clienteCrudRepository;

    @Autowired // los objetos que reciban esta anotacion (Spring va a crear estas instancias)
    //Se declara variable que nos va a realizar el mapeo con las clases del dominio
    private PersonMapper mapper;

    @Override //Se debe estar seguro que el objeto es un compontente de SPRNG
    //Solo hace uso de crudRepository
    public List<Personn> getAll(){
        List<Person> persons = (List<Person>) clienteCrudRepository.findAll();
        return mapper.toPersons(persons);
    }

    @Override
    //Se hace uso de QUERYMETHODS para establecer toda la consulta en especifico
    public Optional<List<Personn>> getByCenterUbi(int idCenterPerson){
        List<Person> persons = clienteCrudRepository.findByIdCenterOrderByFirstNameAsc(idCenterPerson);
        return  Optional.of(mapper.toPersons(persons));
    }

    @Override
    //No se hace usos de query methods ya que tiene internamente una funcion de encontrar por id o PK
    public Optional<Personn> getByIdPerson( int idPersonn){

        return  clienteCrudRepository.findById(idPersonn).map(per -> mapper.toPersonn(per));
    }

    //Los repositorios de spring DATA ofrecen el metodo save igual que en el anterior
    @Override
    public Personn save(Personn personn) {
        Person person = mapper.toPerson(personn);
        return mapper.toPersonn(clienteCrudRepository.save(person));
    }

    public void  delete(int idPersonn){

        clienteCrudRepository.deleteById(idPersonn);
    }

    @Override
    public Personn update(Personn personn) {
        return clienteCrudRepository.findById(personn.getIdPersonn()).map(person -> {

            personn.setNamePerson(personn.getNamePerson());
            personn.setLastNamePerson(personn.getLastNamePerson());
            personn.setAdressPerson(personn.getAdressPerson());
            personn.setIdCenterPerson(personn.getIdCenterPerson());
            personn.setCity(personn.getCity());
            person = mapper.toPerson(personn);
            return mapper.toPersonn(clienteCrudRepository.save(person));
                }).get();
    }
}
