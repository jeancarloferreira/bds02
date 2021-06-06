package com.devsuperior.bds02.service;

import com.devsuperior.bds02.dto.CityDTO;

import java.util.List;

public interface CityService {

    void delete(Long id);

    List<CityDTO> findAll();
}
