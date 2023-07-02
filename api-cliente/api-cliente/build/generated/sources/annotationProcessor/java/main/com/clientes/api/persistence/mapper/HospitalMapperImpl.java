package com.clientes.api.persistence.mapper;

import com.clientes.api.domain.Hospitall;
import com.clientes.api.persistence.entity.Hospital;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-07-02T14:20:57-0500",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.6.1.jar, environment: Java 11.0.17 (Eclipse Adoptium)"
)
@Component
public class HospitalMapperImpl implements HospitalMapper {

    @Override
    public Hospitall toHospitall(Hospital hospital) {
        if ( hospital == null ) {
            return null;
        }

        Hospitall hospitall = new Hospitall();

        if ( hospital.getId() != null ) {
            hospitall.setIdHospital( hospital.getId() );
        }
        hospitall.setHospitalName( hospital.getHospital() );

        return hospitall;
    }

    @Override
    public List<Hospitall> toHospitalls(List<Hospital> hospitals) {
        if ( hospitals == null ) {
            return null;
        }

        List<Hospitall> list = new ArrayList<Hospitall>( hospitals.size() );
        for ( Hospital hospital : hospitals ) {
            list.add( toHospitall( hospital ) );
        }

        return list;
    }

    @Override
    public Hospital toHospital(Hospitall hospitall) {
        if ( hospitall == null ) {
            return null;
        }

        Hospital hospital = new Hospital();

        hospital.setId( hospitall.getIdHospital() );
        hospital.setHospital( hospitall.getHospitalName() );

        return hospital;
    }
}
