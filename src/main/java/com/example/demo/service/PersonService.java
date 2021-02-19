package com.example.demo.service;

import com.example.demo.dao.persondao;
import com.example.demo.modal.person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonService {

    private final persondao persondao;
    @Autowired
    public PersonService(@Qualifier("postgres") persondao persondao) {
        this.persondao = persondao;
    }

    public int addPerson(person person)
    {
        UUID id = UUID.randomUUID();
        return persondao.insertPersion(id, person);
    }

    public List<person> getAllPeople()
    {
        return persondao.selectAllPeople();
    }

    public Optional<person> getPersonByID(UUID id)
    {
        return persondao.selectPersonbyId(id);
    }

    public int deletePerson(UUID id)
    {
        return persondao.deletePersonById(id);
    }

    public int updatePerson(UUID id, person newPerson)
    {
        return persondao.updatePersonById(id, newPerson);
    }
}
