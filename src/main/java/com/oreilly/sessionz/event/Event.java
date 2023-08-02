package com.oreilly.sessionz.event;

import java.time.LocalDate;

public record Event(
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
