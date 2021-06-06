package com.devsuperior.bds02.service;

import com.devsuperior.bds02.dto.EventDTO;

public interface EventService {

    EventDTO update(Long id, EventDTO dto);
}
