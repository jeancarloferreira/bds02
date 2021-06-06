package com.devsuperior.bds02.serviceImpl;

import com.devsuperior.bds02.dto.CityDTO;
import com.devsuperior.bds02.entity.City;
import com.devsuperior.bds02.repository.CityRepository;
import com.devsuperior.bds02.service.CityService;
import com.devsuperior.bds02.serviceImpl.exception.DataIntegrityException;
import com.devsuperior.bds02.serviceImpl.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    CityRepository cityRepository;

    @Override
    public void delete(Long id) {
        try {
            cityRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new NotFoundException("ID not found: "+id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Integraty violation");
        }

    }

    @Override
    public List<CityDTO> findAll() {
        List<City> list = cityRepository.findAll(Sort.by("name").ascending());

        return  list.stream().map(obj -> new CityDTO(obj)).collect(Collectors.toList());
    }
}
