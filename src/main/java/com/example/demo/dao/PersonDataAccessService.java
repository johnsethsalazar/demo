package com.example.demo.dao;

import com.example.demo.modal.person;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("postgres")
public class PersonDataAccessService implements persondao{
    @Override
    public int insertPersion(UUID id, person person) {
        return 0;
    }

    @Override
    public List<person> selectAllPeople() {
        return List.of(new person(UUID.randomUUID(), "FROM POSTGRES DB"));
    }

    @Override
    public Optional<person> selectPersonbyId(UUID id) {
        return Optional.empty();
    }

    @Override
    public int deletePersonById(UUID id) {
        return 0;
    }

    @Override
    public int updatePersonById(UUID id, person person) {
        return 0;
    }
}
