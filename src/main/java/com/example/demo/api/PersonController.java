package com.example.demo.api;

import com.example.demo.modal.person;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/person")
@RestController
public class PersonController {
    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService)
    {
        this.personService = personService;
    }

    @PostMapping
    public void addPerson(@Validated @NonNull @RequestBody person person)
    {
        personService.addPerson(person);
    }

    @GetMapping
    public List<person> getAllPeople()
    {
        return personService.getAllPeople();
    }

    @GetMapping(path = "{id}")
    public person getPersonById(@PathVariable("id") UUID id)
    {
        return personService.getPersonByID(id).orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deletePersonById(@PathVariable("id") UUID id)
    {
        personService.deletePerson(id);
    }

    @PutMapping(path = "{id}")
    public void updatePerson(@PathVariable("id") UUID id, @Validated @NonNull @RequestBody person personToUpdate)
    {
        personService.updatePerson(id, personToUpdate);
    }
}
