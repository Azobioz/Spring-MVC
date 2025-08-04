package com.springmvc.web.repository;

import com.springmvc.web.dto.ClubDto;
import com.springmvc.web.dto.EventDto;
import com.springmvc.web.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}
