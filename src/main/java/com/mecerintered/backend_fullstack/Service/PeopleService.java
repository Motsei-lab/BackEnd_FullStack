package com.mecerintered.backend_fullstack.Service;

import com.mecerintered.backend_fullstack.Repository.PeopleRepository;
import org.springframework.stereotype.Service;

@Service
public class PeopleService {
    private final PeopleRepository peopleRepository;

    public PeopleService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }


}
