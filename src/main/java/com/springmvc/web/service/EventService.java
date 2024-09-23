package com.springmvc.web.service;

import com.springmvc.web.dto.EventDto;

import java.util.List;

public interface EventService {
    void createEvent(Long id, EventDto eventDto);
    List<EventDto> findAllEvents();
}
