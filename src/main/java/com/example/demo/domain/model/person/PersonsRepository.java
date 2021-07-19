package com.example.demo.domain.model.person;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface PersonsRepository extends JpaRepository<Person, Long> {

    <T> Collection<T> findByName(String name, Class<T> type);

}
