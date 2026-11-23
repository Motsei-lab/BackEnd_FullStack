package com.mecerintered.backend_fullstack.Controller;

import com.mecerintered.backend_fullstack.DTOs.PeopleRequest;
import com.mecerintered.backend_fullstack.DTOs.PeopleResponse;
import com.mecerintered.backend_fullstack.Service.PeopleService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/people")
public class PeopleController {

    private final PeopleService peopleService;

    public PeopleController(PeopleService peopleService){
        this.peopleService = peopleService;
    }

    @PostMapping
    //request body it is used to extracts the data in the http request body and it stores it in my peopleRequest request

    //put and post must have a requestbody
    // @Valid performs or checks the validations done in my request
    // we use @reqest\body to access
    public ResponseEntity<PeopleResponse> create(@Valid @RequestBody PeopleRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(peopleService.createPerson(request));
    }

    @GetMapping
    public List<PeopleResponse> getAllPeople(){
        return peopleService.getAllPeople();
    }

    @GetMapping("/{id}")
    public PeopleResponse findById(@PathVariable Long id){
        return peopleService.findById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PeopleResponse> updateById(@PathVariable Long id, @Valid @RequestBody PeopleRequest request){
        return ResponseEntity.ok(peopleService.UpdatePerson(id,request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        peopleService.deletePerson(id);
        return ResponseEntity.noContent().build();
        }


}
