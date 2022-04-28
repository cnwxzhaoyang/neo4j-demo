package com.example.accessingdataneo4j.model.repository.neo4j;

import java.util.List;
import com.example.accessingdataneo4j.model.domain.neo4j.Person;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface PersonRepository extends Neo4jRepository<Person, Long> {

	Person findByName(String name);
	List<Person> findByTeammatesName(String name);
}
