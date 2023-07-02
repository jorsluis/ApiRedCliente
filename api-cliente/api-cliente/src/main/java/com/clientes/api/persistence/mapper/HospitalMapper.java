package com.clientes.api.persistence.mapper;

import com.clientes.api.domain.Hospitall;
import com.clientes.api.persistence.entity.Hospital;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

//Se le indica que este es una interfaz de mapeo
@Mapper(componentModel = "spring")
public interface HospitalMapper {

    //se declara para mapear nuestros valores de Hospitall a hospital
    @Mappings({
            @Mapping(source = "id", target = "idHospital"),
            @Mapping(source = "hospital", target = "hospitalName")

    })
    Hospitall toHospitall(Hospital hospital);
    List<Hospitall> toHospitalls(List<Hospital> hospitals);

    //Se realiza la inversa por si se requiere traducir la misma informacion
    @InheritInverseConfiguration
    //Se excluye debido a que no lo creamos en hospitall
    @Mapping(target = "person", ignore = true)
    Hospital toHospital(Hospitall hospitall);
}
