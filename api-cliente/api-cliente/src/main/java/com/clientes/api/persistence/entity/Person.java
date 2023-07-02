package com.clientes.api.persistence.entity;

import com.clientes.api.domain.service.HospitallService;

import javax.persistence.*;

@Entity //Se define esta anotacion de spring para indicar que es una tabla de nuestra DB
@Table(name= "persona") //se define porque el nombre de la tabla es diferente al de la clase
public class Person {

    @Id //anotacion que declara nuestra PK de la DB
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Anotacion semejante a auto_increment
    @Column(name ="person_id") // Se define porque el nombre de la columna de nuestra BD es diferente al de la variable declarada
    private Integer idPerson;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;
    private String adress;

    @Column(name = "id_center")
    private Integer idCenter;
    private String city;

    //Campo en donde se realiza la relacion que esta en nuestra BD

    @ManyToOne // relacion de muchos a uno
    @JoinColumn(name = "id_center", insertable = false, updatable = false) // campo que lleva la relacion
    private Hospital hospital;

    public Integer getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(Integer idPerson) {
        this.idPerson = idPerson;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public Integer getIdCenter() {
        return idCenter;
    }

    public void setIdCenter(Integer idCenter) {
        this.idCenter = idCenter;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }
}
