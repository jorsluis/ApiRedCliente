package com.clientes.api.web.controller;

import com.clientes.api.domain.Hospitall;
import com.clientes.api.domain.service.HospitallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/hospital")
public class HospitallController {

    @Autowired
    private HospitallService hospitallService;

    @GetMapping("/all")
    public ResponseEntity<List<Hospitall>> getAll(){

        return new ResponseEntity<>(hospitallService.getAll1(), HttpStatus.OK);
    }
    @GetMapping("{idHospital}")
    public ResponseEntity<Hospitall> getById(@PathVariable("idHospital") int idHospital){

        return hospitallService.getById(idHospital).map(hospitall -> new ResponseEntity<>(hospitall, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
