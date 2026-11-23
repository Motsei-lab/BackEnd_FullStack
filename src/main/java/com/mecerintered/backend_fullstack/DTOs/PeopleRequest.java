package com.mecerintered.backend_fullstack.DTOs;

import com.mecerintered.backend_fullstack.Entity.People;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record PeopleRequest(
        @NotBlank(message = "Person's Name is required!")
        String name,
        @Email(message = "Email format must include @ symbol")
        String email
) {
    public People toEntity(){
        People person = new People();
        person.setName(name);
        person.setEmail(email);

        return person;
    }
}
