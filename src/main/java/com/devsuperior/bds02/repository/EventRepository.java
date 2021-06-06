package com.devsuperior.bds02.repository;

import com.devsuperior.bds02.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}
