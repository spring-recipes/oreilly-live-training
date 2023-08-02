package com.oreilly.sessionz.event;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class EventDataLoader implements CommandLineRunner {

    private final EventRepository eventRepository;

    public EventDataLoader(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        var event = new Event(null,
                "SpringOne at VMware Explore",
                "Join us at the biggest gathering of Spring enthusiasts, beginners and practitioners who build the apps that make the world run. This year, we are excited to have the developer-focused SpringOne event unite with the incredible VMware Explore 2023 in Las Vegas. Learn how Spring can take you from code to production at speed with its support for modern application architectures that run seamlessly on any cloud.",
                LocalDate.of(2023,8,21),
                LocalDate.of(2023,8,24),
                LocalDate.now().minusDays(180),
                LocalDate.now().minusDays(90),
                "Las Vegas, NV",
                "https://springone.io/");

        eventRepository.save(event);
    }
}


