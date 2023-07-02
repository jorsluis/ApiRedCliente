package com.clientes.api.web.controller;

import com.clientes.api.domain.Personn;
import com.clientes.api.domain.service.PersonnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/persons")
public class PersonnController {

    @Autowired
    private PersonnService personnService;

    @GetMapping("/all")
    @CrossOrigin(origins = "*")
    public ResponseEntity<List<Personn>> getAll(){

        return new ResponseEntity<>(personnService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/hospital/{idCenterPerson}")
    public ResponseEntity<List<Personn>> getByCenterUbi(@PathVariable("idCenterPerson") int idCenterPerson){
        return personnService.getByCenterUbi(idCenterPerson)
                .map(center -> new ResponseEntity(center, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @GetMapping("/{idPersonn}")
    public ResponseEntity<Personn> getByIdPersonn(@PathVariable("idPersonn") int idPersonn){

        return personnService.getByIdPerson(idPersonn)
                .map(personn -> new ResponseEntity<>(personn, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PostMapping("/save")
    @CrossOrigin(origins = "*")
    public ResponseEntity<Personn> save(@RequestBody Personn personn){

        return new ResponseEntity<>(personnService.save(personn), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    @CrossOrigin(origins = "*")
    public ResponseEntity delete (@PathVariable("id") int idPersonn){

        if(personnService.delete(idPersonn)){
            return new ResponseEntity<>(HttpStatus.OK);
        }else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PutMapping("/update")
    @CrossOrigin(origins = "*")
    public ResponseEntity<Personn> update(@RequestBody Personn personn){
        return new ResponseEntity<>(personnService.update(personn), HttpStatus.OK);
    }


}
