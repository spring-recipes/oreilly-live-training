package com.oreilly.sessionz.event;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
class EventService {

    public List<Event> events = new ArrayList<>();

    public EventService() {
        events = List.of(new Event("O'Reilly Live Training"));
    }

    public List<Event> findAll() {
        return events;
    }

}

