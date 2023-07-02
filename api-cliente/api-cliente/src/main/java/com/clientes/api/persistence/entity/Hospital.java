package com.clientes.api.persistence.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "centro_atencion")
public class Hospital {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String hospital;

    @OneToMany(mappedBy = "hospital") // se define para la relacion en base a nuestra BD
    private List<Person> person;

    public List<Person> getPerson() {
        return person;
    }

    public void setPerson(List<Person> person) {
        this.person = person;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }
}
