package com.oreilly.sessionz.event;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class EventGraphQLController {

    private final EventService eventService;

    public EventGraphQLController(EventService eventService) {
        this.eventService = eventService;
    }

    @QueryMapping
    public List<Event> events() {
        return eventService.findAll();
    }

    @QueryMapping
    public Optional<Event> event(@Argument Integer id) {
        return eventService.findById(id);
    }
}
