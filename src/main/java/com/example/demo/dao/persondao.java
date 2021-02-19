package com.example.demo.dao;

import com.example.demo.modal.person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface persondao {

    int insertPersion(UUID id, person person);

    default int addPerson(person person){
        UUID id = UUID.randomUUID();
        return insertPersion(id, person);
    }

    List<person> selectAllPeople();

    Optional<person> selectPersonbyId(UUID id);

    int deletePersonById(UUID id);

    int updatePersonById(UUID id, person person);
}
