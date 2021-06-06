package com.devsuperior.bds02.serviceImpl;

import com.devsuperior.bds02.dto.EventDTO;
import com.devsuperior.bds02.entity.City;
import com.devsuperior.bds02.entity.Event;
import com.devsuperior.bds02.repository.EventRepository;
import com.devsuperior.bds02.service.EventService;
import com.devsuperior.bds02.serviceImpl.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    EventRepository eventRepository;

    @Override
    @Transactional
    public EventDTO update(Long id, EventDTO dto) {
        try {
            Event entity = eventRepository.getOne(id);
            copyDtoToEntity(dto, entity);
            eventRepository.save(entity);
            return new EventDTO(entity);
        } catch (EntityNotFoundException e) {
            throw new NotFoundException("ID not found: "+id);
        }

    }

    private void copyDtoToEntity(EventDTO dto, Event entity) {
        entity.setName(dto.getName());
        entity.setDate(dto.getDate());
        entity.setUrl(dto.getUrl());
        entity.setCity(new City(dto.getCityId(), null));
    }
}
