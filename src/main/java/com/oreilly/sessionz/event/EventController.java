package com.oreilly.sessionz.event;

import io.micrometer.observation.Observation;
import io.micrometer.observation.ObservationRegistry;
import io.micrometer.observation.annotation.Observed;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/events")
class EventController {

    private final EventRepository eventRepository;
    private static final Logger log = LoggerFactory.getLogger(EventController.class);
    private ObservationRegistry observationRegistry;

    public EventController(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    // Example of using an annotation to observe methods
    // <events.findAll> will be used as a metric name
    // <finding-all-events> will be used as a span name
    // @Observed(name = "events.findAll", contextualName = "finding-all-events")
    @GetMapping
    public List<Event> findAll() {
        return Observation.createNotStarted("events.findAll", observationRegistry)
                        .contextualName("events.findAll")
                        .lowCardinalityKeyValue("userType","attendee")
                        .observe(() -> {
                            log.info("Retrieving all events in the system.");
                            return eventRepository.findAll();
                        });
    }

    @GetMapping("/delay")
    public List<Event> findAllWithDelay() {
        return Observation.createNotStarted("events.findAll", observationRegistry)
                .contextualName("events.findAll")
                .lowCardinalityKeyValue("userType","attendee")
                .observe(() -> {
                    long delay = 3000;
                    try {
                        Thread.sleep(delay);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    log.info("Retrieving all events in the system with a {} second delay.", delay);
                    return eventRepository.findAll();
                });
    }

    @GetMapping("/{id}")
    public Optional<Event> findEventById(@PathVariable Integer id) {
        return Observation.createNotStarted("events.findById", observationRegistry)
                .contextualName("events.findById")
                .lowCardinalityKeyValue("userType","attendee")
                .highCardinalityKeyValue("eventId",id.toString())
                .observe(() -> eventRepository.findById(id));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void create(@Valid @RequestBody Event event) {
        eventRepository.save(event);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@Valid @RequestBody Event updatedEvent, Integer id) {
        eventRepository.save(updatedEvent);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        eventRepository.deleteById(id);
    }

}

