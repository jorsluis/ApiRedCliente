package com.clientes.api.domain;

public class Personn {

    private int idPersonn;
    private String namePerson;
    private String lastNamePerson;
    private String adressPerson;
    private String idCenterPerson;
    private String city;
    private Hospitall hospitall;

    public int getIdPersonn() {
        return idPersonn;
    }

    public void setIdPersonn(int idPersonn) {
        this.idPersonn = idPersonn;
    }

    public String getNamePerson() {
        return namePerson;
    }

    public void setNamePerson(String namePerson) {
        this.namePerson = namePerson;
    }

    public String getLastNamePerson() {
        return lastNamePerson;
    }

    public void setLastNamePerson(String lastNamePerson) {
        this.lastNamePerson = lastNamePerson;
    }

    public String getAdressPerson() {
        return adressPerson;
    }

    public void setAdressPerson(String adressPerson) {
        this.adressPerson = adressPerson;
    }

    public String getIdCenterPerson() {
        return idCenterPerson;
    }

    public void setIdCenterPerson(String idCenterPerson) {
        this.idCenterPerson = idCenterPerson;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Hospitall getHospitall() {
        return hospitall;
    }

    public void setHospitall(Hospitall hospitall) {
        this.hospitall = hospitall;
    }
}
