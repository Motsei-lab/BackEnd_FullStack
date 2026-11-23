package com.mecerintered.backend_fullstack.Service;

import com.mecerintered.backend_fullstack.DTOs.PeopleRequest;
import com.mecerintered.backend_fullstack.DTOs.PeopleResponse;
import com.mecerintered.backend_fullstack.Entity.People;
import com.mecerintered.backend_fullstack.Exceptions.ResourceNotFoundException;
import com.mecerintered.backend_fullstack.Repository.PeopleRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PeopleService {
    private final PeopleRepository peopleRepository;

    public PeopleService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    public PeopleResponse createPerson(PeopleRequest request){
        People person = peopleRepository.save(request.toEntity());// here we create a new person object using the JPA methods to save the newly created person object

        return PeopleResponse.fromEntity(person); // here we get the response of what we have created from the database using the fromEntity() Method
    }

    public List<PeopleResponse> getAllPeople(){
        return peopleRepository.findAll().stream().map(PeopleResponse::fromEntity).toList();
    }

    public PeopleResponse findById(Long id){
       People person = peopleRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException(id));
       return PeopleResponse.fromEntity(person);
    }

    public PeopleResponse UpdatePerson(Long id, PeopleRequest request){
        People person = peopleRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException(id));
        person.setEmail(request.email());
        person.setName(request.name());

        People updated = peopleRepository.save(person);
        return PeopleResponse.fromEntity(updated);
    }

    public void deletePerson(Long id){
        if (!peopleRepository.existsById(id)){
            throw new ResourceNotFoundException(id);
        }
        peopleRepository.deleteById(id);
    }


}
