package com.example.accessingdataneo4j.model.repository.st;

import com.example.accessingdataneo4j.model.domain.st.Person;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface PersonRepository extends Neo4jRepository<Person, Long> {

}
