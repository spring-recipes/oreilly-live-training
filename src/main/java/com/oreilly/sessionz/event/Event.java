package com.oreilly.sessionz.event;

import org.springframework.data.annotation.Id;

import java.time.LocalDate;

public record Event(
        @Id
        Integer id,
        String name,
        String description,
        LocalDate startDate,
        LocalDate endDate,
        LocalDate cfpStartDate,
        LocalDate cfpEndDate,
        String location,
        String website
) {

}
