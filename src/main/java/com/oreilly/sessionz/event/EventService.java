package com.oreilly.sessionz.event;

import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
class EventService {

    public List<Event> events = new ArrayList<>();

    public EventService() {
        var event = new Event(1,
                "SpringOne at VMware Explore",
                "Join us at the biggest gathering of Spring enthusiasts, beginners and practitioners who build the apps that make the world run. This year, we are excited to have the developer-focused SpringOne event unite with the incredible VMware Explore 2023 in Las Vegas. Learn how Spring can take you from code to production at speed with its support for modern application architectures that run seamlessly on any cloud.",
                LocalDate.of(2023,8,21),
                LocalDate.of(2023,8,24),
                LocalDate.now().minusDays(180),
                LocalDate.now().minusDays(90),
                "Las Vegas, NV",
                "https://springone.io/");

        events.add(event);
    }

    public List<Event> findAll() {
        return events;
    }

    public Optional<Event> findById(Integer id) {
        return events.stream().filter(e -> e.id().equals(id)).findFirst();
    }

    public void create(Event event) {
        events.add(event);
    }

    public void update(Event updatedEvent, Integer id) {
        Optional<Event> event = events.stream().filter(e -> e.id().equals(id)).findFirst();
        if (event.isPresent()) {
            events.remove(event.get());
            events.add(updatedEvent);
        }
    }

    public void delete(Integer id) {
        events.removeIf(e -> e.id().equals(id));
    }
}

