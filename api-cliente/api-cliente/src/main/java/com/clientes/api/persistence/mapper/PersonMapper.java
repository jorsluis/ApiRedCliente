package com.clientes.api.persistence.mapper;

import com.clientes.api.domain.Personn;
import com.clientes.api.persistence.entity.Person;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

//se impleme    nta debido a que se usa la relacion
@Mapper(componentModel = "spring", uses = {HospitalMapper.class})
public interface PersonMapper {

    @Mappings({

            @Mapping(source = "idPerson", target = "idPersonn"),
            @Mapping(source = "firstName", target = "namePerson"),
            @Mapping(source = "lastName", target = "lastNamePerson"),
            @Mapping(source = "adress", target = "adressPerson"),
            @Mapping(source = "idCenter", target = "idCenterPerson"),
            //No se agrega City porque lleva el mismo nombre
            //Se esta incluyendo nuestro atributo que se creo para la relacion
            @Mapping(source = "hospital", target = "hospitall")

    })
    Personn toPersonn(Person person);
    List<Personn> toPersons(List<Person> persons);

    @InheritInverseConfiguration

    Person toPerson(Personn personn);
}
