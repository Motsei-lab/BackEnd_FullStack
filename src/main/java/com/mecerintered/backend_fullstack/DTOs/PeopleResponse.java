package com.mecerintered.backend_fullstack.DTOs;

import com.mecerintered.backend_fullstack.Entity.People;

public record PeopleResponse(
        Long id, String name, String email
) {
    public static PeopleResponse fromEntity(People person){
        return new PeopleResponse(
                person.getId(),
                person.getName(),
                person.getEmail()
        );
    }
}
