package com.clientes.api.persistence.mapper;

import com.clientes.api.domain.Personn;
import com.clientes.api.persistence.entity.Person;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-07-02T14:20:57-0500",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.6.1.jar, environment: Java 11.0.17 (Eclipse Adoptium)"
)
@Component
public class PersonMapperImpl implements PersonMapper {

    @Autowired
    private HospitalMapper hospitalMapper;

    @Override
    public Personn toPersonn(Person person) {
        if ( person == null ) {
            return null;
        }

        Personn personn = new Personn();

        if ( person.getIdPerson() != null ) {
            personn.setIdPersonn( person.getIdPerson() );
        }
        personn.setNamePerson( person.getFirstName() );
        personn.setLastNamePerson( person.getLastName() );
        personn.setAdressPerson( person.getAdress() );
        if ( person.getIdCenter() != null ) {
            personn.setIdCenterPerson( String.valueOf( person.getIdCenter() ) );
        }
        personn.setHospitall( hospitalMapper.toHospitall( person.getHospital() ) );
        personn.setCity( person.getCity() );

        return personn;
    }

    @Override
    public List<Personn> toPersons(List<Person> persons) {
        if ( persons == null ) {
            return null;
        }

        List<Personn> list = new ArrayList<Personn>( persons.size() );
        for ( Person person : persons ) {
            list.add( toPersonn( person ) );
        }

        return list;
    }

    @Override
    public Person toPerson(Personn personn) {
        if ( personn == null ) {
            return null;
        }

        Person person = new Person();

        person.setIdPerson( personn.getIdPersonn() );
        person.setFirstName( personn.getNamePerson() );
        person.setLastName( personn.getLastNamePerson() );
        person.setAdress( personn.getAdressPerson() );
        if ( personn.getIdCenterPerson() != null ) {
            person.setIdCenter( Integer.parseInt( personn.getIdCenterPerson() ) );
        }
        person.setHospital( hospitalMapper.toHospital( personn.getHospitall() ) );
        person.setCity( personn.getCity() );

        return person;
    }
}
