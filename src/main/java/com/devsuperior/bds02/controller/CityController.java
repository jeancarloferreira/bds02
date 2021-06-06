package com.devsuperior.bds02.controller;

import com.devsuperior.bds02.dto.CityDTO;
import com.devsuperior.bds02.serviceImpl.CityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/cities")
public class CityController {

    @Autowired
    CityServiceImpl cityService;

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        cityService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<CityDTO>> findAll() {
        List<CityDTO> list = cityService.findAll();
        return ResponseEntity.ok().body(list);
    }
}
