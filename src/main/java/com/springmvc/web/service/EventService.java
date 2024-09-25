package com.springmvc.web.service;

import com.springmvc.web.dto.EventDto;
import com.springmvc.web.model.Event;

import java.util.List;

public interface EventService {
    void createEvent(Long id, EventDto eventDto);
    List<EventDto> findAllEvents();
    EventDto findByEventId(Long eventId);
}
